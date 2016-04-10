import java.util.Date;
import java.text.*;
import java.util.*;
import java.io.*;
/**
 * kelas bank yang akan menghasilkan object customer
 * @author Abdu Halim Wibowo
 * @version 2016.04.10
 */

public class Bank
{
    private static double creditInterestRate ;
    private static Date closeTime;
    private static Date startTime;
    private static double investmentInterestRate;
    private static int lastCustID = 1000, numOfCurrentCustomer;
    private static int nextID, nextCustID = 1000;
    private static String phone;
    public static String website;
    public static String Address = "1234 JavaStreet, AnyCity, ThisState,34567";
    private static final int MAX_NUM_OF_CUSTOMERS;
    public static final String Name = "JBANK";
  
   
    static
    {
        Scanner s = new Scanner (System.in);
        System.out.println("Maksimum Customer =  ");
        int x = s.nextInt();
        for (int i=0;i<x;i++)
        {
            System.out.println("Customer" +i);
            Customer[] cArray = new Customer[i];
        }
        
        MAX_NUM_OF_CUSTOMERS = x;
        System.out.println ("Maksimum: " +MAX_NUM_OF_CUSTOMERS);   
        
    }
   
    private static Customer[] Customers = new Customer[MAX_NUM_OF_CUSTOMERS];
     
    public Bank()
    {
       
    }
   
    public static boolean addCustomer (Customer customer)
    {
        for (int i = 0; i<Customers.length; i++)
        { if (Customers[i] == null){
              Customers[i] = customer;
              return true;
            
        }       
    }
     return false;
}

    public static Customer getCustomer (int custID)
    {
          for (int i = 0; i<Customers.length; i++)
          {
              if (Customers[i].getCustID() == custID)
              {
                  return Customers[i];
              }
          }
          return null;
    }
    /**
     * method untuk mendapatkan get address
     */
    
    /*public static String getAddress()
    {
        return "";
    }
   */
    
  
    /**
     * method untuk mendapatkan get credit rate
     */
    
    public static double getCreditRate ()
    {
        return 0;
    }
    
    
    /**
     * method untuk mendapatkan get investement rate
     */
    public static double getInvestmentRate()
    {
        return 0;
    }
    
    /**
     * method untuk mendapatkan jam operasi kerja
     */
    public static String getHoursOfOperation()
    {
        return null;
    }
    
    /**
     * method untuk mendapatkan ID terakhir customer
     */
    public static int getLastID()
    {
        return 0;
    }
    
    /**
     * method untuk mendapatkan maximun customer
     * @return nilai int MAX_NUM_OF_CUSTOMERS
     */
    
    public static int getMaxNumOfCustomers()
    {
        return MAX_NUM_OF_CUSTOMERS;
    }
    
 
    
    /**
     * method untuk mendapatkan nama customer
     */
    
    /*public static String getName()
    {
        return null;
    }
    */
   
    /**
     * method untuk mendapatkan nextID
     * @return nextCustID
     */
    public static double getNextID ()
    {
       double NextCustIDs;
        NextCustIDs = nextCustID;
        if (nextCustID == 0)  
        {
           
            
            lastCustID = 1000; 
            numOfCurrentCustomer = numOfCurrentCustomer;
            
            return NextCustIDs;
        }
        
        else if ( numOfCurrentCustomer == MAX_NUM_OF_CUSTOMERS)
        {
         
            return 0;
        }
        
        else if (nextCustID != 0)
        {
            lastCustID = nextCustID; 
            nextCustID += 1;
           
            numOfCurrentCustomer += 1;
        }
        return NextCustIDs;
    }
    
    /**
     * method untuk mendapatkan website
     */
    public static String getWebsite()
    {
        return "";
    }
    
    /**
     * method untuk mendapatkan premium rate customer
     */
    public static double getPremiumRate()
    {
        return 0;
    }
    
    /**
     * Method untuk getNumOfCurrentCustomers
     * @return nilai jumlah pelanggan
     */
    public static int getNumOfCurrentCustomers() 
    {
        return numOfCurrentCustomer;
    }
    
    /**
     * method untuk mendapatkan phone number
     */
    public static String getPhone()
    {
        return "";
    }
    
    /**
     * method untuk assign creditrate
     */
    public static void setCreditRate (double rate)
    {
        
    }
    
    /**
     * method untuk assign investment rate
     */
    public static void setInvestmentRate (double rate)
    {
        
    }
    
    /**
     * method untuk assign premium 
     */
    public static void setPremium (double rate)
    {
        
    }
    
    public Date getStartTime()
    {
        return startTime;
    }
    
    public void setStartTime()
    {
        
    }
    
    public Date getCloseTime()
    {
        return closeTime;
    }
    
    public void setCloseTime()
    {
        
    }
    
     public void printAllCustomers() {
        for (Customer c : Customers) {
            if (c!=null)
                System.out.println(c);
        }
    }
}
