import java.util.*;
import java.math.*;
import java.text.*;

/**
 * Kelas LineOfCredit yang berisi method dan variabel yang digunakan.
 * 
 * @author Abdu Halim Wibowo
 * @version 16.04.2016
 */
public class LineOfCredit extends Checking
{
    private double creditBalance, creditLimit;
    
     /**
     * Constructor for objects of class LineOfCredit
     * @param customer adalah objek Customer 
     * @param amount adalah jumlah saldo checking account
     * @param creditAmount adalah jumlah nilai limit kredit
     */
    public LineOfCredit (Customer cust, double amount, double creditAmount) {
        super();
        id = Integer.toString(cust.getCustID());
        balance = amount;
        creditBalance = creditAmount;
        creditLimit = creditAmount;
    }

     /**
     * method untuk melakukan perhitungan biaya kredit
     */
    public void feeAssessment() {
        monthlyFee += 3;
        balance -= monthlyFee;
    }
    
     /*{
        int days = new GregorianCalendar ().get(Calendar.DAY_OF_MONTH);
        double deficit = creditLimit - creditBalance, 
        period = (double) days/365; 
        double financeCharge = futureValue(deficit,0.21,360,period);
        monthlyFee = new BigDecimal(financeCharge).subtract(new BigDecimal(deficit), mc.DECIMAL32).doubleValue();
    }*/
    
    /**
     * Method yang digunakan untuk menarik saldo
     */
    public boolean withdraw (double amount) {
        if ( ( balance + creditBalance >= amount)) {
            if (balance >= amount) {
                balance -= amount;
            } else {
                creditBalance -= (amount - balance);
                balance = 0;
                feeAssessment();
            }
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * method untuk mendapatkan nilai saldo kredit
     * @return nilai saldo kredit
     */
    public double getCreditBalance () 
    {
        return creditBalance;
    }
    
     /**
     * method untuk mendapatkan nilai limit kredit
     * @return nilai limit kredit
     */
    public double getCreditLimit () 
    {
        return creditLimit;
    }
    
    /**
     * method untuk mengeset nilai saldo kredit
     * @param amount adalah nilai saldo kredit
     */
    public void setCreditBalance (double amount) 
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
