import javax.swing.*;
import java.awt.*;
import java.awt.event.*; 

/**
 * Kelas untuk ButtonHandler
 * 
 * @author Abdu Halim Wibowo
 * @version 16.04.2016
 */
public class ButtonHandler implements ActionListener
{
   private ATMGUI gui;
    /**
    * Kelas Konstruktor dari Button Handler
    * 
    * @param gui Objek gui yang akan dijadikan parameter.
    */
   public ButtonHandler(ATMGUI gui){
       this.gui=gui;
   }
   
   private String newline = "\n";
   
   /**
    * Method untuk menghandle Event
    * 
    * @param e event yang dilakukan
    */
   public void actionPerformed(ActionEvent event){
       JTextArea text = gui.text;
       if(event.getActionCommand().equals("Deposit")){
           text.append(newline + "Customer ID: " + gui.getIDcostumer() +" You are Saving:" + gui.getNominal());
       }
       else if(event.getActionCommand().equals("Withdraw")){
           text.append(newline + "Customer ID: " + gui.getIDcostumer() +" You are Withdraw:" + gui.getNominal());
       }
      else if(event.getActionCommand().equals("Exit")){
           JOptionPane.showMessageDialog(null,"Thank you for using ATMGUI :)");
            System.exit(0);
        }
    }
}

      