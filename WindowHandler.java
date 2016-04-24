import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 * Kelas untuk WindowHandler
 * 
 * @author Abdu Halim Wibowo
 * @version 16.04.2016
 */
public class WindowHandler extends WindowAdapter
{
   public void windowClosing(WindowEvent w){
       quitMessage();
       System.exit(0);
   }
   
   private void quitMessage(){
       JOptionPane.showMessageDialog(null,"You are exiting now, Thanks and Goodbye ");
   }
}
