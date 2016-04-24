import java.util.*;
import java.math.BigDecimal;
import java.math.MathContext;
import java.text.*;
import java.lang.Math;
/**
 * Merepresentasikan Kelas Akun yang berhubungan dengan balance dan tipe akun
 * 
 * @author Abdu Halim Wibowo
 * @version 16.04.2016
 */

public abstract class Account       
{   
    protected double balance;
    protected String id;
    protected static MathContext mc = new MathContext(3);
    
    /**
     * Method constructor class Account
     */
     public String toString() {
        if ( this instanceof Savings && !(this instanceof Investment)) {
            System.out.println("Saving");
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
    * method deposit dengan parameter jumlah saldo
    * @param amount menunjukkan jumlah saldo
    */
    public boolean deposite(double amount)
    {
         if (amount>=0)
        {
            balance = balance + amount;
            return true;
        }
        else
        {
            return false;
        }
    }
    
    /**
    * method nilai untuk menghitung laju berdasarkan compund, saldo, periode
    * @param balance adalah saldo
    * @param rate adalah laju
    * @param compound adalah compound
    * @param period adalah periode
    */
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
    * method getter untuk saldo nasabah
    * @return balance adalah saldo
    */
    public double getBalance() {
        return balance;
    }
    
    /**
    * method untuk melakukan setting id
    */
   /*
   public void setID(String acctId)
    {
        id = acctId;
    }
   */
    
   /**
    * untuk melakukan setting tipe akun
    */
   /*
   public void setAcctType(char type)
    {
        acctType = type;
    }
   */
  
    /**
     * Metode untuk mendapatkan Id Customer
     * @return nomor id customer
     */
    public String getId() 
    {
        return id;
    }
    
    /**
     * Metode untuk mengatur balance customer
     * @param amount nilai balance customer
     */
    public void setBalance(double amount) 
    {
        balance = amount; 
    }
        
    /**
    * method abstract untuk menarik uang
    * @param amount adalah jumlah saldo
    */
    public abstract boolean withdraw (double amount);
   
}
    

