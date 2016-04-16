
/**
 * Kelas untuk membuat Account Saving
 * @author Abdu Halim Wibowo
 * @version 16 April 2016
 */
public class Savings extends Account
{
    protected double interestEarned;

    /**
     * Method Constructor dari Kelas Savings
     */
    public Savings(Customer cust, double amount){
        super();
        ID = Integer.toString(cust.getCustID());
        super.balance = amount;
    }
    
    /**
     * Method untuk menarik sejumlah uang 
     */
    public boolean withdraw(double amount) throws AmountOverDrawnException{
        if (balance - amount >= 10) {
            balance -= amount;
            return true;
        } else {
            throw new AmountOverDrawnException(this);
        }
    }
    
    /**
     * Method untuk menghitung bunga sesuai jumlah hari 
     */
    public void addDailyInterest(int numOfDays) 
    {
        double A, period;
        period = (double)numOfDays / 365;
        A = futureValue(balance, 0.03, 360, period);
        interestEarned = A - balance;
        balance = A;
    }
    
    
    /**
     * Method untuk mendapatkan bunga
     */
    public double getInterestEarned() 
    {
        return interestEarned;
    }
}
