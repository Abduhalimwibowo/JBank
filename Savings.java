 import java.math.*;
 
/**
 * Kelas untuk membuat Account Saving
 * @author Abdu Halim Wibowo
 * @version 2016.04.10
 */
public class Savings extends Account
{
    protected double interestEarned;

    /**
     * Constructor for objects of class Savings
     */
    public Savings(Customer customer, double amount)
    {
        super();
        balance = amount;
        id = Integer.toString(customer.getCustomerId());
    }
    
    /**
     * method untuk mendapatkan bunga
     */
    public double getInterestEarned()
    {
        return interestEarned;
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
        else
        {
            balance = balance - amount;
            return true;
        }
    }
    /*
    {
         if(balance-amount >= 10)
         {
             balance-=amount;
             return true;
         }
         else
         {
             return false;
         }
    }
    */
    
    /**
     * method untuk menambahkan bunga per hari
     */
    public void addDailyInterest(int days)
    {
        double a = Math.pow(((1 + (.03/365))),(365 * days / 365 ));
        double b = a * balance;
        interestEarned = b - balance;
        balance = b;
    }
}
