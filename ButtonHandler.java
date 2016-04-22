import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 * Kelas untuk mengatur ActionLister dari ATM GUI,
 * Mengimplementasikan Action Listener
 * 
 * @author Abdu Halim Wibowo
 * @version 16.04.2016
 */
public class ButtonHandler implements ActionListener
{
   /**
    * Variabel untuk menyimpan parameter ATMGUI
    */
   private ATMGUI gui;
   
   /**
    * Kelas Konstruktor dari Button Handler
    * 
    * @param gui Objek gui yang akan dijadikan parameter.
    */
   public ButtonHandler(ATMGUI gui){
       this.gui=gui;
   }
   
   /**
    * Method untuk menghandle Event
    * 
    * @param e event yang dilakukan
    */
   public void actionPerformed(ActionEvent e){
       if(e.getActionCommand().equals("Deposit")){
           
           try{
               Bank.getCustomer(1001).getAccount('S').deposit(gui.getNominal());
               gui.textAreaMain.setText(Bank.getCustomer(1001).getAccount('S').getBalance()+ "");
            }
           catch (AccountTypeNotFoundException error){
               System.out.println(error.getMessage());
            }
            
       }
       else if(e.getActionCommand().equals("Withdraw")){
           
            try{
               Bank.getCustomer(1001).getAccount('S').withdraw(gui.getNominal());
               gui.textAreaMain.setText(Bank.getCustomer(1001).getAccount('S').getBalance()+ "");
            }
           catch (AccountTypeNotFoundException error){
               System.out.println(error.getMessage());
            }
           catch (AmountOverDrawnException error){
               System.out.println(error.getMessage());
            }
            
   }
}

 public void errorMessage (String message){
       gui.setTextArea (message);
    }
 
 //Mendefinisikan apa yang dilakukan oleh withdraw di gui
 public void withdrawAction (Account akun, double amount){
     try{
         akun.withdraw (amount);
        }
     catch (AmountOverDrawnException unexpected){
         errorMessage (unexpected.getMessage());
     }
    }
    
    
 //Method untuk mencari akun di kelas static Bank, dengan exception.   
 public Account locateAccount (char acctType){
     try{
         return Bank.getCustomer(gui.getIDcust()).getAccount(acctType);
     }
     catch (AccountTypeNotFoundException sameAccount){
         errorMessage (sameAccount.getMessage());
        }
        return null;
    }
      
 public void clearText(){
     gui.customerText.setText("");
     gui.amountText.setText("");
    }
}
