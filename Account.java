import java.math.BigDecimal;
import java.lang.Math;
import java.math.MathContext;

/**
 * kelas account berisikan deskripsi atau informasi akun customer
 * @author Abdu Halim Wibowo
 * @version 2016.04.10 
 */

public abstract class Account
{
    protected double balance;
    protected String id;
    protected static MathContext mc = new MathContext(5);
    /*
   /**
     * constructur kelass account
     */
    /*
    public Account(Customer customer,double amount,char tipe)
    {
        acctType = tipe;
        balance = amount;
        id = customer.getCustID()+" "+ tipe;
    }
    */
    public String toString()
    {
      /*System.out.println("Tipe Akun = "+acctType);*/
      System.out.println("ID = "+id);
      System.out.println("Saldo = "+balance);
      return "";  
    }
    /*
    /**
     * method pada costractor account
     * @param type tipe akun customer
     * @param amount nilai balance customer 
     */
    /*
    public Account (char type, double amount)
    {
      /*acctType = type;*/
      /*balance = amount;*/
    
   
    /**
     * method untuk deposit customer
     * @param amount nilai balance akun customer 
     */
    public boolean deposit(double amount)
    {
        if (amount < 0)
        { 
            return false;
        }
        else
        { 
            balance = balance + amount;
            return true;
        }
    }
    
    /*
    /**
     * method untuk mendapatkan tipe akun customer
     * @return tipe akun
     */
    /*
    public char getAcctType()
    {
        return acctType;
    }
    */
   
    /**
     * method untuk mendapatkan nilai balance customer
     * @return nilai balance
     */
    public double getBalance()
    {
        return balance;
    }
    
    /**
     * method untuk mendapatkan ID customer
     * @return no id customer
     */
    public String getId()
    {
        return id;
    }
    
    /**
     * method untuk assign nilai balance customer
     * @param amount nilai deposit customer
     */
    public void setBalance (double amount)
    {
        this.balance = amount;
    }
    
    /*
    /**
     * method untuk assign ID customer
     * @param accId ID dari akun 
     */
    /*
    public void setID (String acctId)
    {
        this.id = acctId;
    }
    */
   /*
   
    /**
     * method untuk assign tipe akun customer
     * @param type tipe akun
     */
    /*
    public void setAcctType(char type)
    {
        this.acctType = type;
    }
    */
    
    /**
     * method untuk customer mengambil uang
     */
    public abstract boolean withdraw (double amount);
    
      public static double nilai(double saldo, double rate, double compound, double period)
    {
         BigDecimal saldoS = new BigDecimal (saldo);
         BigDecimal t = new BigDecimal (rate);
         BigDecimal n = new BigDecimal (compound);
         BigDecimal p = new BigDecimal (period);
         BigDecimal f1Saving = t.divide(n, mc).add(new BigDecimal(1.0));
         BigDecimal f2 = n.multiply(t, mc);
         BigDecimal f3Saving = new BigDecimal (Math.pow(f1Saving.doubleValue(), f2.doubleValue()),mc);
         BigDecimal f4Saving = f3Saving.multiply(saldoS, mc);
         return f4Saving.doubleValue();
    }
    /*
    {
        if (balance - amount < 0)
        {
            return false;
        } 
        else 
        {
            balance = balance - amount;
            return true;
        }
    }
    */
    
}
    
