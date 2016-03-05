
package inheritanceproject;

import java.awt.Dimension;
import javax.swing.JFrame;

/**
 *
 * @author yassine
 */
public class InheritanceProject {

    
    public static void main(String[] args) {
        
        InheritanceGUI pan = new InheritanceGUI();
        JFrame window = new JFrame();
        window.setSize(new Dimension(640, 480));
        window.add(pan);
        window.setVisible(true);
        
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}
