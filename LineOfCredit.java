import java.text.*;
import java.util.*;
import java.io.*;
import java.time.*;
import java.lang.Math;
import java.math.*;

/**
 * Kelas untuk membuat Account Line of Credit
 * @author Abdu Halim Wibowo
 * @version 2016.04.10
 */
public class LineOfCredit extends Checking {
    private double creditBalance;
    private double creditLimit;
    
    /**
     * Method Constructor LineOfCredit 
     * @param cust Objek Customer 
     * @param amount Jumlah Saldo Checking Account
     * @param creditAmount Jumlah nilai limit kredit
     */
    public LineOfCredit (Customer cust, double amount, double creditAmount) {
        super();
        id = Double.toString(cust.getCustID());
        balance = amount;
        creditBalance = creditAmount;
        creditLimit = creditAmount;
    }
    
    /**
     * Method feeAssessment Perhitungan biaya kredit
     */
    public void feeAssessment() {
        int day = new GregorianCalendar().get(Calendar.DAY_OF_MONTH);
        double def = creditLimit - creditBalance, 
        periode = (double) day/365; 
        double f = nilai(def,0.21,360,periode);
        monthlyFee = new BigDecimal(f).subtract(new BigDecimal(def), mc.DECIMAL32).doubleValue();
    }
    
    /**
     * Method withdraw digunakan untuk cek pernarikan saldo dari Line-of-Credit Account
     * @param amount jumlah saldo
     */
    public boolean withdraw (double amount) {
        if ( ( balance + creditBalance >= amount)) {
            if (balance >= amount) {
                balance = balance - amount;
            } else {
                creditBalance = creditBalance - (amount - balance);
                balance = 0;
                feeAssessment();
            }
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * Method getCreditBalance Memberikan nilai saldo kredit
     * @return nilai saldo kredit
     */
    public double getCreditBalance () {
        return creditBalance;
    }
    
    /**
     * Method getCreditLimit Mengambil nilai limit kredit
     * @return nilai limit kredit
     */
    public double getCreditLimit () {
        return creditLimit;
    }
    
    /**
     * Method setCreditBalance Menentukan nilai saldo kredit
     * @param amount nilai saldo kredit
     */
    public void setCreditBalance (double amount) {
        creditBalance = amount;
    }
    
    /**
     * Method setCreditLimit Menentukan nilai limit pada kredit
     * @param amount nilai limit kredit
     */
    public void setCreditLimit (double amount) {
        creditLimit = amount;
    }
}