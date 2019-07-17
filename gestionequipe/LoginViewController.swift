//
//  LoginViewController.swift
//  gestionequipe
//
//  Created by corentin delage on 14/07/2019.
//  Copyright © 2019 corentin delage. All rights reserved.
//

import UIKit
import Alamofire

class LoginViewController: UIViewController {
    
    
    @IBOutlet weak var emailTF: UITextField!
    @IBOutlet weak var passwordTF: UITextField!
    @IBOutlet weak var connecterBTN: UIButton!
    
    override func viewDidLoad() {
        super.viewDidLoad()
    

        // Do any additional setup after loading the view.
    }

    
    @IBAction func connecter(_ sender: Any) {
        
        struct User: Codable {
            var Nom: String
            var prenom: String
            var id: Int
        }

        
        let userForm: [String:Any] = [
            "email": emailTF.text!,
            "password": passwordTF.text!
        ]
        
        let headers: HTTPHeaders = [
            "Content-Type": "application/json",
            ]
        Alamofire.request("http://localhost:3000/signin", method: .post, parameters: userForm,encoding: JSONEncoding.default, headers: headers)
            .responseJSON { response  in
                if( response.response?.statusCode==200){
                    print("200 ok")
                    guard let json_response = response.result.value as? [[String: Any]],
                    let nom = json_response[0]["Nom"] as? String,
                    let id = json_response[0]["id"] as? Int
                    else {
                        return
                    }
                    //set in userdefaults
                    let preferences = UserDefaults.standard
                    preferences.set(id, forKey: "id")
                    preferences.set(nom, forKey: "Nom")
                    //save in userdefaults
                    preferences.synchronize()
                    //get in userdefault
                    let iduser = UserDefaults.standard.string(forKey: "id")
                    debugPrint(iduser)
                    
                    self.emailTF.backgroundColor = #colorLiteral(red: 0.5373227596, green: 1, blue: 0.5942387581, alpha: 1)
                    self.passwordTF.backgroundColor = #colorLiteral(red: 0.5373227596, green: 1, blue: 0.5942387581, alpha: 1)
                }else{
                    self.emailTF.backgroundColor = #colorLiteral(red: 0.7450980544, green: 0.1568627506, blue: 0.07450980693, alpha: 1)
                    self.passwordTF.backgroundColor = #colorLiteral(red: 0.7450980544, green: 0.1568627506, blue: 0.07450980693, alpha: 1)
                }
        
        }
    }
}
