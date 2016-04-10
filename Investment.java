import java.text.*;
import java.util.*;
import java.io.*;
import java.time.*;
import java.lang.Math;
import java.math.*;

/**
 * Kelas untuk membuat Account Investment
 * @author Abdu Halim Wibowo
 * @version 2016.04.10
 */
public class Investment extends Savings
{
    private int x;
    private Date endDate;
    private double interestRate;
    private Date startDate;
    private int term;
    /**
     * Constructor for objects of class Investment
     */
    public Investment(Customer cust, double amount, int term)
    {
        super(cust,amount);
        this.term = term ;
        int localTerm;
        Calendar cal = new GregorianCalendar();
        startDate = cal.getTime();
        if (term < 6)
        {
            localTerm = 6;
        }
        else {
            localTerm = term;
            }       
            cal.add(Calendar.MONTH, localTerm);
            endDate = cal.getTime();
            
        if (term <=6)
        {
            interestRate =0.05;
        }
        else if (term >6 || term <=12)
        {
            interestRate = 0.06;
        }
            else
            {
                interestRate = 0.07;
            }
                   
            
          
    }
    
     public void addDailyInterest(int days)
    {
      double f, periode;
      int hari = 365;
      periode = days/hari;
      f = nilai(balance,0.03,360,periode);
      interestEarned = f - balance;
      balance = f;
    }

    public boolean withdraw(double amount)
    {
     if (balance - amount > 100)
     {
         if (Calendar.getInstance().before(endDate))
         { if ((balance*0.8)- amount > 100)
             {
                 balance *=0.8;
                 balance -=amount;
                 return true;
                }
              else 
              {return false;
                }              
    }else{ return false;}
    }
    else{ return false;}
}
}
