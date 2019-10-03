//
//  ViewController.swift
//  Reprehensible
//
//  Created by Alexander v. Below on 03.10.19.
//  Copyright © 2019 Alexander von Below. All rights reserved.
//

import UIKit

class ViewController: UIViewController {

    @IBOutlet weak var helloLabel: UILabel!
    
    override func viewDidLoad() {
        super.viewDidLoad()
    }

    override func viewDidAppear(_ animated: Bool) {
        super.viewDidAppear(animated)
        self.helloLabel.text = "Hello Macoun!"
    }
}

