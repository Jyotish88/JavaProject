/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package loginscreen;

import java.awt.GraphicsEnvironment;

/**
 *
 * @author Jyotish
 */
public class LoginScreen {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String fonts[]
        = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();

for (int i = 0; i < fonts.length; i++) {
    System.out.println(fonts[i]);
}
        
        
       Welcome object =new Welcome();
    }
}
