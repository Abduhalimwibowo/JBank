import java.util.Date;
import java.util.GregorianCalendar;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.math.BigDecimal;
import java.math.MathContext;

/**
 * Kelas untuk membuat Account Line of Credit
 * @author Abdu Halim Wibowo
 * @version 16 April 2016
 */
public class LineOfCredit extends Checking {
    private double creditBalance, creditLimit;
    
    /**
     * Constructor for objects of class LineOfCredit
     * @param customer adalah objek Customer 
     * @param amount adalah jumlah saldo checking account
     * @param creditAmount adalah jumlah nilai limit kredit
     */
    public LineOfCredit (Customer cust, double amount, double creditAmount) {
        super();
        ID = Integer.toString(cust.getCustID());
        balance = amount;
        creditBalance = creditAmount;
        creditLimit = creditAmount;
    }
    
    /**
     * Method untuk perhitungan biaya kredit
     */
    public void feeAssessment() {
        int days = new GregorianCalendar ().get(Calendar.DAY_OF_MONTH);
        double deficit = creditLimit - creditBalance, period = (double) days/365; 
        double financeCharge = futureValue(deficit,0.21,360,period);
        monthlyFee = new BigDecimal(financeCharge).subtract(new BigDecimal(deficit), mc.DECIMAL32).doubleValue();
    }
    
    /**
     * Method withdraw Menarik sejumlah Saldo dari Account LineOfCredit
     * @param amount Jumlah Saldo
     */
    public boolean withdraw (double amount) throws AmountOverDrawnException {
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
            throw new AmountOverDrawnException(this);
        }
    }
    
    /**
     * method untuk mendapatkan nilai saldo kredit
     * @return nilai saldo kredit
     */
    public double getCreditBalance () {
        return creditBalance;
    }
    
    /**
     * Method getCreditLimit Memberikan nilai limit kredit
     * @return Nilai limit kredit
     */
    public double getCreditLimit () {
        return creditLimit;
    }
    
    /**
     * method untuk mengeset nilai saldo kredit
     * @param amount adalah nilai saldo kredit
     */
    public void setCreditBalance (double amount) {
        creditBalance = amount;
    }
    
    /**
     * Method setCreditLimit Menentukan nilai limit kredit
     * @param amount Jumlah nilai untuk limit kredit
     */
    public void setCreditLimit (double amount) {
        creditLimit = amount;
    }
}
