import java.util.*;
import java.math.BigDecimal;
import java.math.MathContext;
import java.text.*;
import java.lang.Math;
/**
 * Kelas Account ini akan berisi informasi mengenai akun customer.
 * @author Abdu Halim Wibowo
 * @version 10 April 2016
 */
public abstract class Account   
{   
    protected double balance;
    protected String id;
    protected static MathContext mc = new MathContext(3);
    
    /**
     * Constructor (pembangun kelas Account)
     */
   /*public Account(String ID, double amount) {
        balance = amount;
        id = ID;
    }*/
    
    /**
     * Method pada constructor kelas Account
     * @param type sebagai tipe akun customer
     * @param amount sebagai nilai saldo customer
     */
    /*public Account(char type, double amount) {
          //acctType = type; 
          balance = amount;}*/
    
     public String toString() {
        //System.out.println("Account Type  :   " + acctType);
        //if (this.getClass().equals())
        if ( this instanceof Savings && !(this instanceof Investment)) {
            System.out.println("SAVING");
        } else if ( this instanceof LineOfCredit) {
            LineOfCredit l = (LineOfCredit)this;
            System.out.println("Line Of Credit");
            System.out.println("Credit Balance:   "+ l.getCreditBalance());
            System.out.println("Monthly Fee   :   "+ l.getMonthlyFee());
        } else if ( this instanceof OverDraftProtection) {
            OverDraftProtection o = (OverDraftProtection)this;
            System.out.println("Overdraft Protection");
            System.out.println("Monthly Fee   :   "+ o.getMonthlyFee());
        } else if ( this instanceof Investment) {
            System.out.println("Investment");
        }
        System.out.println("Balance       :   " + balance);
        return "";
    }
    
     /**
     * Method untuk deposit customer
     * @param amount saldo akun customer 
     */
    public boolean deposite(double amount)
    {
        if (amount < 0)
        { 
            return false; 
        }
        else
        { 
            balance += amount;
            return true; 
        }
    }
    
     public static double futureValue(double balance, double rate, double compound, double period) 
    {
        BigDecimal bal = new BigDecimal (balance);
        BigDecimal r = new BigDecimal (rate);
        BigDecimal n = new BigDecimal (compound);
        BigDecimal t = new BigDecimal (period);
        BigDecimal f1 = r.divide(n, mc.DECIMAL32).add(new BigDecimal(1));
        BigDecimal f2 = n.multiply(t, mc.DECIMAL32);
        BigDecimal f3 = new BigDecimal (Math.pow(f1.doubleValue(), f2.doubleValue()),mc.DECIMAL32);
        BigDecimal f4 = f3.multiply(bal, mc.DECIMAL32);
        return f4.doubleValue();
    }
    
    /**
     * Method untuk mendapatkan tipe akun customer
     * @return acctType 
     */
    //public String getAcctType() {
       //return acctType;}
    
    
     /** 
     * Method untuk mendapatkan nilai balance customer
     * @return balance sebagai nilai balance
     */
    public double getBalance() {
        return balance;
    }
    
    /**
     * Method untuk mendapatkan Id Customer
     * @return nomor id customer
     */
    public String getId() {
        return id;
    }
    
    /**
     * Method untuk mengatur balance customer
     * @param amount balance customer
     */
    public void setBalance(double amount) {
        balance = amount; 
    }
        
    /**
     * Method untuk mengatur id customer
     * @param acctId 
    //public void setID(String acctId) {
        //this.id = acctId; }
        
    /**
     * Method untuk mengatur tipe akun customer
     * @param type 
     */    
    //public void setAcctType(char type) {
        //this.acctType = type; }
        
    /**
     * method untuk customer mengambil uang
     */
    public abstract boolean withdraw (double amount);
   
}
    

