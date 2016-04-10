import java.lang.Math;
import java.math.MathContext;
import java.math.BigDecimal;

/**
 * kelas account berisikan deskripsi atau informasi akun customer
 * @author Abdu Halim Wibowo
 * @version 2016.04.10 
 */
public abstract class Account
{
   /**
    * deklarasi class variable
    */
   //public char acctType;
   //private double drawBalance;
   protected double balance;
   protected String id;
   protected static MathContext mc = new MathContext(5);
   
   /**
    * Constructor Account tanpa parameter
    */
   /*
   public Account()
    {
        acctType = 'S';
        balance = 10.00;
    }
    */
   
   /**
    * Constructor Account dengan parameter
    * @param char type menunjukkan tipe akun
    * @param amount menunjukkan jumlah uang
    */
   /*
   public Account(char type, double amount, Customer customer)
    {
        acctType = type;
        balance = amount;
        id = customer.getCustomerId()+ "" +type;
    }
   */
    
   /**
    * method untuk mengubah tipe data menjadi String
    * method toString untuk melakukan overriding untuk mengembalikan ID dari akun
    */
   public String toString()
   {
       System.out.println("ID           : " +id);
       //System.out.println("Tipe Akun    : " +acctType);
       System.out.println("Saldo        : " +balance);
       return "";
   }
   
   /**
    * method deposit dengan
    * @param amount menunjukkan jumlah uang
    */
   public boolean deposit(double amount)
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
    * method untuk mengembalikan nilai tipe akun
    */
   /*
   public char getAcctType()
    {
       return acctType;
    }
   */
    
   /**
    * untuk mengembalikan nilai balance
    */
   public double getBalance()
    {
       return balance;
    }
    
   /**
    * method untuk mengembalikan id
    */
   public String getId()
    {
       return id;
    }
    
   /**
    * method untuk melakukan setting jumlah balance
    */
   public void setBalance(double amount)
    {
        this.balance = amount;
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
    * method untuk menarik uang
    */
   public abstract boolean withdraw(double amount);
   
   public static double nilai(double balance, double rate, double compound, double period)
    {
         BigDecimal balanceS = new BigDecimal (balance);
         BigDecimal t = new BigDecimal (rate);
         BigDecimal n = new BigDecimal (compound);
         BigDecimal p = new BigDecimal (period);
         BigDecimal f1Saving = t.divide(n, mc).add(new BigDecimal(1.0));
         BigDecimal f2 = n.multiply(t, mc);
         BigDecimal f3Saving = new BigDecimal (Math.pow(f1Saving.doubleValue(), f2.doubleValue()),mc);
         BigDecimal f4Saving = f3Saving.multiply(balanceS, mc);
         return f4Saving.doubleValue();
    }
   
   /*
   public boolean withdraw(double amount) 
    {
        double drawBalance;
        drawBalance = balance - amount;
        if (drawBalance>=0)
        {
            balance = drawBalance;
            return true;
        }
        else
        {
            return false;
        }
    }
    */

}
