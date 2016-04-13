
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 * kelas WindowHandler dengan ekstensi WindowAdapter digunakan untuk mengatur window pada kelas ATMGUI
 * @author Abdu Halim Wibowo
 * @version 10 April 2016
 */
public class WindowHandler extends WindowAdapter
{
   public void windowClosing(WindowEvent w){
       quitMessage();
       System.exit(0);
   }
   
   private void quitMessage(){
       JOptionPane.showMessageDialog(null,"Thank you for your transaction and see you later ! :)");
   }
}
