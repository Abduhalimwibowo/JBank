import java.util.*;
import java.math.*;
import java.text.*;

/**
 * Kelas LineOfCredit ini merupakan ekstensi dari kelas checking 
 * @author Abdu Halim Wibowo
 * @version 10 April 2016
 */
public class LineOfCredit extends Checking
{
    private double creditBalance, creditLimit;
    
    /**
     * Constructor LineOfCredit dengan beberapa parameter : 
     * @param cust Obyek Customer acuan
     * @param amount Jumlah Saldo Checking Account
     * @param creditAmount Jumlah nilai limit kredit
     */
    public LineOfCredit (Customer cust, double amount, double creditAmount) {
        super();
        id = Integer.toString(cust.getCustID());
        balance = amount;
        creditBalance = creditAmount;
        creditLimit = creditAmount;
    }

    /**
     * Metode feeAssessment digunakan untuk perhitungan biaya kredit
     */
    public void feeAssessment() {
        int days = new GregorianCalendar ().get(Calendar.DAY_OF_MONTH);
        double deficit = creditLimit - creditBalance, period = (double) days/365; 
        double financeCharge = futureValue(deficit,0.21,360,period);
        monthlyFee = new BigDecimal(financeCharge).subtract(new BigDecimal(deficit), mc.DECIMAL32).doubleValue();
    }
    
    /**
     * Metode withdraw digunakan untuk menarik sejumlah saldo dari akun Line-of-Credit 
     * @param amount sebagai jumlah Saldo
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
     * Metode getCreditBalance digunakan untuk memberikan nilai saldo kredit
     * @return Nilai sebagai saldo dari kredit
     */
    public double getCreditBalance () {
        return creditBalance;
    }
    
    /**
     * Metode getCreditLimit digunakan untuk memberikan nilai limit kredit
     * @return Nilai sebagai limit dari kredit
     */
    public double getCreditLimit () {
        return creditLimit;
    }
    
    /**
     * Metode setCreditBalance digunakan untuk menentukan nilai saldo kredit
     * @param amount sebagai jumlah nilai untuk saldo kredit
     */
    public void setCreditBalance (double amount) {
        creditBalance = amount;
    }
    
    /**
     * Metode setCreditLimit digunakan untuk menentukan nilai limit kredit
     * @param amount sebagai jumlah nilai untuk limit kredit
     */
    public void setCreditLimit (double amount) {
        creditLimit = amount;
    }
}
