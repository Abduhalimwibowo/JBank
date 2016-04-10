import java.util.Scanner;
import java.util.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.text.SimpleDateFormat;
import java.util.*;
import java.io.*;

/**
 * kelas bank yang akan menghasilkan object customer
 * @author Abdu Halim Wibowo
 * @version 2016.04.10
 */
public class Bank
{
   /**
    * deklarasi class variabel
    */
   private static double creditInterestRate;
   private static double investmentInterestRate;
   private static int lastCustID=1000;
   private static int nextCustID=1000;
   private static String phone;
   private static double premiumInterestRate;
   private static Date startTime;
   private static Date closeTime;
   public static String website;
   public static final String BANK_ADDRESS = "1234 JavaStreet, AnyCity, ThisState, 34567";
   public static final int MAX_NUM_OF_CUSTOMERS;
   public static int maxNumOfAcctsPerCustomer = 4;
   public static final String BANK_NAME = "JBANK";
   private static int numOfCurrentCustomer;
   private static int nextID;
  
   static //adalah static initializer block
   {
       Scanner s = new Scanner (System.in);
       System.out.println("Jumlah maksimum nasabah: ");
       int x = s.nextInt();
       MAX_NUM_OF_CUSTOMERS = x;
       System.out.println("Jumlah maksimum nasabah yang Anda masukkan: " +MAX_NUM_OF_CUSTOMERS);
   }
  
   private static Customer[] Customers = new Customer[MAX_NUM_OF_CUSTOMERS]; 
   
   /**
    * Constructor Bank tanpa argumen
    */
   public Bank()
   {
       
   }
   
   /**
    * method untuk membuat objek custommer
    * @param customer
    */
   public static boolean addCustomer(Customer customer)
   {
       for (int a = 0; a < Customers.length; a++)
       {
           if (Customers[a] == null)
           {
               Customers[a] = customer;
               return true;
           }
       }
       return false;
   }
   
   /**
    * method untuk mengalokasikan customer ID dengan objek customer
    * @param custId
    */
   public static Customer getCustomerId(int custId)
   {
       for (int a = 0; a < Customers.length; a++)
       {
           if (Customers[a].getCustomerId() == custId)
           {
               return Customers[a];
           }
       }
       return null;
   }
   
   /**
    * mengisi alamat bank
    */
   /*
   public static String getAddress()
    {
       return BANK_ADDRESS;
    }
   */
   
   /**
    * meminta bunga bank
    */
   public static double getCreditRate()
    {
       return creditInterestRate; 
    }
    
   /**
    * meminta bunga investasi
    */
   public static double getInvestmentRate()
    {
       return investmentInterestRate;
    }
   
   /**
    * mengisi bunga premium
    */
   public static double getPremiumRate()
    {
       return premiumInterestRate;
    }
   
   /**
    * mengisi jam operasional
    */
   public static String getHoursOfOperation()
    {
       SimpleDateFormat startclose = new SimpleDateFormat("k:mm");
       Calendar start = new GregorianCalendar();
       start.set(Calendar.HOUR_OF_DAY, 8);
       start.set(Calendar.MINUTE, 0);
       Date startTime = start.getTime();
       Calendar close = new GregorianCalendar();
       close.set(Calendar.HOUR_OF_DAY, 17);
       close.set(Calendar.MINUTE, 0);
       Date closeTime = close.getTime();
       
       return startclose.format(startTime) + " TO " + startclose.format(closeTime);
    }
   
   /**
    * mengisi nomor antrian terakhir
    */ 
   public static int getLastID()
    {
       return lastCustID;
    }
   
   /**
    * mengisi nomor antrian selanjutnya
    */
   public static int getNextID()
   {
      int nextID;
      nextID = nextCustID;
      if (nextCustID == 0)
      {
          lastCustID = 1000;
          numOfCurrentCustomer = numOfCurrentCustomer;
          return nextID;
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
      return nextID;
   }
   
   /**
    * mengisi jumlah maksimal nasabah
    */
   public static int getMaxCustomer()
    {
       return MAX_NUM_OF_CUSTOMERS;
    }
    
   /**
    * mengisi nama bank
    */
   /*
   public static String getName()
    {
       return BANK_NAME;
    }
   */
    
   /**
    * mengisi website bank
    */
   public static String getWebsite()
    {
       return website;
    }
  
   /**
    * mengisi nomor telepon bank
    */ 
   public static String getPhone()
    {
       return phone;
    }
   
   /**
    * mengisi jumlah nasabah sekarang
    */
   public static int getNumOfCurrentCustomer()
    {
        return numOfCurrentCustomer;
    }
   
   /**
    * method untuk mendapatkan jam buka bank
    */
   public static Date getStartTime()
   {
       return startTime;
   }
   
   /**
    * method untuk mendapatkan jam tutup bank
    */
   public static Date getCloseTime()
   {
       return closeTime;
   }
   
   /**
    * mengatur laju kredit
    * @param double rate adalah besar laju kredit
    */
   public static void setCreditRate(double rate)
    {
        creditInterestRate = rate;
    }
   
   /**
    * mengatur laju investasi
    * @param double rate adalah besar laju investasi
    */
   public static void setInvestmentRate(double rate)
    {
        investmentInterestRate = rate;
    }
    
   /**
    * mengatur bunga premium
    * @param double rate adalah besar laju bunga premium
    */
   public static void setPremium(double rate)
    {
        premiumInterestRate = rate;
    }
   
   /**
    * mengatur jam buka bank
    * @param int hour menujukkan jam
    * @param int min menunjukkan menit
    */
   public static void setStartTime(int hour, int min)
   {
       startTime = new GregorianCalendar(0,0,0,hour,min).getTime();
   }
    
   /**
    * mengatur jam tutup bank
    * @param int hour menujukkan jam
    * @param int min menunjukkan menit
    */
   public static void setCloseTime(int hour, int min)
   {
       closeTime = new GregorianCalendar(0,0,0,hour,min).getTime();
   }
   
   /**
    * untuk mengatur jam operasional bank
    */
   public boolean setHoursOfOperation(Date startTime, Date closeTime)
   {
      if (this.startTime != null || this.closeTime != null)
      {
          startTime = this.startTime;
          closeTime = this.closeTime;
          return true;
      } 
      else
      {
          startTime = this.startTime;
          closeTime = this.closeTime;
          return false;
       } 
   }
   
   public void printCustomers()
   {
       for (Customer a : Customers) 
       {
           if (a!=null)
           System.out.println(a);
       }
   }
   
}
