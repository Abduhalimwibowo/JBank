import java.util.Date;
import java.util.GregorianCalendar;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Kelas Investment merupakan extended kelas dari Savings. Kelas ini berfungsi sebagai
 * akun penyimpanan jangka panjang.
 * @author Abdu Halim Wibowo
 * @version 27 maret 2016
 */
public final class Investment extends Savings {
    private Date startDate, endDate;
    private int term;
    private double interestRate;
    
    public Investment (Customer cust, double amount, int term) {
        super(cust, amount);
        this.term = term;
        int localTerm;
        Calendar cal = new GregorianCalendar();
        startDate = cal.getTime();
        if (term < 6) {
            localTerm = 6;
        } else {
            localTerm = term;
        }
        cal.add(Calendar.MONTH, localTerm);
        endDate = cal.getTime();

        if (term <= 6) {
            interestRate = 0.05;
        } else if (term > 6 && term <=12) {
            interestRate = 0.06;
        } else {
            interestRate = 0.07;
        }
    }
    
    /**
     * Method addDailyInterest Menghitung bunga yang didapat sesuai banyaknya hari 
     * @param numberOfDays Banyak hari
     */
    public void addDailyInterest(int numOfDays) {
        double A, period;
        period = (double)numOfDays / 365;
        A = futureValue(balance, interestRate, 360, period);
        interestEarned = A - balance;
        balance = A;
    }
    
    /**
     * Method withdraw Mengambil uang dari suatu akun 
     * @param amount Jumlah Kas
     */
    public boolean withdraw(double amount) {
        
        if (balance - amount >= 100) {
            if (Calendar.getInstance().before(endDate)) {
                if ( (balance * 0.8) - amount >= 100 ) {
                    balance *= 0.8;
                    balance -= amount;
                    return true;
                } else {
                    return false;
                }
                
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}
