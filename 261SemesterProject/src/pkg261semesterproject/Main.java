/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg261semesterproject;

/**
 *
 * @author Brian Morehouse
 */
public class Main {

  
    public static void main(String[] args) {
        NavModel nModel = new NavModel();
        NavView nView = new NavView(nModel);
        NavController nController = new NavController(nView,nModel);
        
        nView.setVisible(true);
        Login l=new Login();
        l.setVisible(true);
        
    }
    
}
