
/**
 * Kelas Savings yang merupakan exxtend dari kelas Account.
 * @author Abdu Halim Wibowo
 * @version 10/04/2016
 */
public class Savings extends Account
{
    protected double interestEarned;

    /**
     * Constructor for objects of class Savings
     */
    public Savings(Customer cust, double amount)
    {
        super();
        id = Integer.toString(cust.getCustID());
        super.balance = amount;
    }

     public double getInterestEarned() {
        return interestEarned;
    }
    
   public boolean withdraw(double amount) {
        if (balance - amount >= 10) {
            balance -= amount;
            return true;
        } else {
            return false;
        }
    }
    
    public void addDailyInterest(int numOfDays) {
        double A, period;
        period = (double)numOfDays / 365;
        A = futureValue(balance, 0.03, 360, period);
        interestEarned = A - balance;
        balance = A;
    }
    }
    


