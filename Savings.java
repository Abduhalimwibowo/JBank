/**
 * Kelas yang mewakili saving, ektensi dari Account
 * 
 * @author Abdu Halim Wibowo
 * @version 16.04.2016
 */
public class Savings extends Account
{
    protected double interestEarned;

    /**
     * Constructor for objects of class Savings
     * @param customer adalah object dari kelas Customer
     * @param amount adalah jumlah saldo
     */
    public Savings(Customer cust, double amount)
    {
        super();
        id = Integer.toString(cust.getCustID());
        super.balance = amount;
    }

    /**
     * method getter untuk mendapatkaninteresrrate
     * @return interestEarned adalah bunga yang diperoleh
     */ 
    public double getInterestEarned() {
        return interestEarned;
    }
    
    
    /**
     * method untuk menambahkan bunga per hari
     * @param days adalah jumlah hari
     */
    public void addDailyInterest(int numOfDays) {
        double A, period;
        period = (double)numOfDays / 365;
        A = futureValue(balance, 0.03, 360, period);
        interestEarned = A - balance;
        balance = A;
    }
    
    /**
     * method override getter untuk saldo
     * @param balance adalah saldo
     */
    @Override
    public double getBalance()
    {
        return balance;
    }
    
    /**
     * method override setter untuk menset saldo
     * @param amount adalah jumlah saldo
     */
    @Override
    public void setBalance(double amount)
    {
        balance = amount;
    }
    
     /**
     * method untuk penarikan uang
     * @param amount adalah jumlah saldo
     */
    /*public void withdraw(double amount)
    {
        try
        {
            if(balance - amount > 0)
            {
                balance -= amount;
            }
            else
            {
                throw new AmountOverDrawnException('S');
            }
        }
        catch(AmountOverDrawnException exc)
        {
            ATMGUI.setTextArea(exc.getMessage() + "\n\n==================================\n Jumlah Saldo anda: " + balance);
            exc.printStackTrace();
        }
    }
    */
      /**
     * method withdraw untuk menarik sejumlah uang
     */ 
    public boolean withdraw(double amount) {
        if (balance - amount >= 10) {
            balance -= amount;
            return true;
        } else {
            return false;
        }
    }
    }
    


