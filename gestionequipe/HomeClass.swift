//
//  LoginViewController.swift
//  gestionequipe
//
//  Created by corentin delage on 14/07/2019.
//  Copyright © 2019 corentin delage. All rights reserved.
//

import UIKit

class HomeClass: UIViewController {
    //On utilise un Outlet au moment où on veut référencer dans le code un élément graphique.
    @IBOutlet var tableView: UITableView!
    //On déclare une variable pour la liste des memes.
    var ListeEntrainement:[Entrainement]!
    override var preferredStatusBarStyle: UIStatusBarStyle {
        return .lightContent
    }
    
    override func viewWillAppear(_ animated: Bool) {
        super.viewWillAppear(animated)
        navigationController?.setNavigationBarHidden(true, animated: animated)
    }
    
    override func viewWillDisappear(_ animated: Bool) {
        super.viewWillDisappear(animated)
        navigationController?.setNavigationBarHidden(false, animated: animated)
    }
}
