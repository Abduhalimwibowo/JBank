import java.util.Scanner;// Library untuk scanner
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.text.ParseException;
import java.math.*;
/**
 * Merepresentasikan Akun teller, yang dapat berinteraksi dengan bank, kustomer dan akun.
 * , dengan GUI
 * 
 * @author Abdu Halim Wibowo
 * @version 16.04.2016
 */
public class Teller
{
    
    /**
    * Awal dari Program
    */
    
    public static void main(String[] args){
        try{
            Customer c1= new Customer("Abdu ", "Halim", ( new GregorianCalendar(1995, 7, 9).getTime()));
            Bank.addCustomer(c1);
            Savings saving= new Savings(c1, 500);
            c1.addAccount(saving);
            
            ATMGUI gui= new ATMGUI();
        }
        catch (AccountTypeAlreadyExistException error){
            System.out.println(error.getMessage());
        }
        
    }
}
