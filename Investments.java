import java.util.*;

/**
 * Kelas untuk membuat Account Investment
 * @author Abdu Halim Wibowo
 * @version 2016.04.10
 */
public final class Investments extends Savings
{
    private Date startDate, endDate;
    private int term;
    private double interestRate;

    /**
     * Constructor for objects of class Investments
     */
    public Investments(Customer customer, double amount, int term)
    {
        super(customer,amount);
        this.term = term;
        int localTerm;
        
        if (this.term < 6)
        {
            localTerm = 6;
        } 
        else 
        {
            localTerm = term;
        }
        
        Calendar s = new GregorianCalendar();
        startDate = s.getTime();      // Untuk mendapatkan tanggal sekarang
        s.add(Calendar.MONTH, term ); // Menambahkan term dalam bulan pada tanggal kalender 
        endDate = s.getTime();        // Mendapatkan end date baru
        
        if (term <= 6) 
        {
            interestRate = .05;
        } 
        else if (term > 6 && term <= 12)
        {
            interestRate = .06;
        } 
        else 
        {
            interestRate = .07;
        }
    }
    
    /**
     * method untuk menambahkan bunga per hari
     */
    public void addDailyInterest(int days)
    {
        double a = Math.pow(((1 + (interestRate / 365))),(365 * days / 365 ));
        double b = a * balance;
        interestEarned = b - balance;
        balance = b;
    }
    
    /**
     * method untuk penarikan uang
     */
    public boolean withdraw(double amount)
    {
        if(amount > balance)
        {
            return false;
        } 
        else if(Calendar.getInstance().before(endDate))
        {
            balance = balance * .8;
            if (amount > balance)
            {
                return false;
            }
            else
            {
                balance = balance - amount;
                return true;
            }
        }
        else
        {
            balance = balance - amount;
            return true;
        }
           
    }
}
