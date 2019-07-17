//
//  CustomTabBarController.swift
//  ESGI-Swift
//
//  Created by Nicolas THIBAULT on 16/02/2019.
//  Copyright © 2019 Nicolas THIBAULT. All rights reserved.
//

import UIKit

class CustomTabBarController : UITabBarController{
    override func viewDidLoad() {
        super.viewDidLoad()
        
        
    }
    
    //On fait une fonction qui retourne un navigation controller avec le titre ainsi que l'image :
    private func createNavControllerWithImageTitle(title: String,imageName:String,view:UIViewController) -> UINavigationController {
        let viewController = view
        let navController = UINavigationController(rootViewController: viewController)
        navController.tabBarItem.title = title
        navController.tabBarItem.image = UIImage(named : imageName)
        UITabBar.appearance().barTintColor = UIColor.darkGray
        self.dismiss(animated: true, completion: nil)
        return navController
    }
    
    
}
