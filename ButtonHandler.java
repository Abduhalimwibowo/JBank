
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 * kelas ButtonHandler yang berfungsi untuk mengatur ActionLister dari ATM GUI.
 * @author Abdu Halim Wibowo
 * @version 10 April 2016
 */
public class ButtonHandler implements ActionListener
{
   private ATMGUI gui;
   
   /**
    * Constructor untuk kelas Button Handler
    * @param gui sebagai objek gui yang akan digunakan.
    */
   public ButtonHandler(ATMGUI gui){
       this.gui=gui;
   }
   
   /**
    * Method actionPerformed yang digunakan untuk memberikan aksi terhadap
    * input yang dilakukan oleh customer.
    * 
    * @param event Sebagai event yang sedang dilakukan
    */
   public void actionPerformed(ActionEvent event){
       if(event.getActionCommand().equals("Deposit")){
           gui.setTextArea("Customer: " + gui.getIDcust() +" saves amount of money:" + gui.getNominal());
       }
       else if(event.getActionCommand().equals("Withdraw")){
           gui.setTextArea("Customer: " + gui.getIDcust() +" withdraws amount of money:" + gui.getNominal());
           
          
           if(Bank.getCustomer(1001).getAccount('S').withdraw(gui.getNominal())==false){
               JOptionPane.showMessageDialog(null,"Invalid Transaction");
           }
           else{
               Bank.getCustomer(1001).getAccount('S').withdraw(gui.getNominal());
               JOptionPane.showMessageDialog(null,"Transaction Done");
           }
           
        }
       else{
           gui.setTextArea("");
       }
   }
}
