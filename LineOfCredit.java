import java.text.*;
import java.util.*;
import java.io.*;
import java.time.*;
import java.math.*;
import java.lang.Math;

/**
 * Kelas untuk membuat Account Line of Credit
 * @author Abdu Halim Wibowo
 * @version 2016.04.10
 */
public class LineOfCredit extends Checking
{
    private double creditBalance;
    private double creditLimit;

    /**
     * Constructor for objects of class LineOfCredit
     * @param customer adalah objek Customer 
     * @param amount adalah jumlah saldo checking account
     * @param creditAmount adalah jumlah nilai limit kredit
     */
    public LineOfCredit(Customer customer, double amount, double creditAmount)
    {
        super();
        id = Double.toString(customer.getCustomerId());
        balance = amount;
        creditBalance = creditAmount;
        creditLimit = creditAmount;
    }

    /**
     * method untuk melakukan perhitungan biaya kredit
     */
    public void feeAssessment() 
    {
        int day = new GregorianCalendar().get(Calendar.DAY_OF_MONTH);
        double def = creditLimit - creditBalance, 
        periode = (double) day/365; 
        double f = nilai(def,0.21,360,periode);
        monthlyFee = new BigDecimal(f).subtract(new BigDecimal(def), mc.DECIMAL32).doubleValue();
    }
    
    /**
     * method withdraw yang  digunakan untuk mengecek penarikan saldo dari Account LineOfCredit
     * @param amount adalah saldo
     */
    public boolean withdraw(double amount) 
    {
        if ( ( balance + creditBalance >= amount)) 
        {
            if (balance >= amount) 
            {
                balance = balance - amount;
            } 
            else 
            {
                creditBalance = creditBalance - (amount - balance);
                balance = 0;
                feeAssessment();
            }
            return true;
        } 
        else 
        {
            return false;
        }
    }
    
    /**
     * method untuk mendapatkan nilai saldo kredit
     * @return nilai saldo kredit
     */
    public double getCreditBalance() 
    {
        return creditBalance;
    }
    
    /**
     * method untuk mendapatkan nilai limit kredit
     * @return nilai limit kredit
     */
    public double getCreditLimit() 
    {
        return creditLimit;
    }
    
    /**
     * method untuk mengeset nilai saldo kredit
     * @param amount adalah nilai saldo kredit
     */
    public void setCreditBalance(double amount) 
    {
        creditBalance = amount;
    }
    
    /**
     * method untuk mengeset nilai limit pada kredit
     * @param amount adalah nilai limit kredit
     */
    public void setCreditLimit (double amount) 
    {
        creditLimit = amount;
    }
}
