/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package asociacionsolidarista;

import Vista.Menu;
import Conector.Conector;

public class AsociacionSolidarista {

    
    public static void main(String[] args) {
        Conector con = new Conector();
        con.getConnection();
        Menu mn= new Menu();
        mn.setVisible(true);
        
    }
    
}
