import java.util.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Pemodelan kelas Investment yang berisi method dan variabel yang digunakan.
 * @author Abdu Halim Wibowo
 * @version 24.04.2016
 */
public final class Investment extends Savings
{
    private Date startDate, endDate;
    private double interestRate;
    private int term;
  
     /**
     * Constructor for objects of class Investments
     * @param customer adalah object dari kelas Customer
     * @param amount adalah jumlah saldo
     * @param term adalah periode
     */
    public Investment(Customer cust, double amount, int term)
    {
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
     * method override untuk menambahkan bunga per hari dalam 1 tahun
     * @param days adalah jumlah hari
     */
    @Override
    public void addDailyInterest(int days)
    {
        double A, period;
        period = (double)days / 365;
        A = futureValue(balance, interestRate, 360, period);
        interestEarned = A - balance;
        balance = A;
    }
    
    /**
     * Method withdraw untuk mengambil uang dari akun 
     * @param amount adalah jumlah uang yang diambil
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
