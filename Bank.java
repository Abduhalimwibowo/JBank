import java.util.Date;
import java.util.GregorianCalendar;
import java.time.Duration;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Scanner;

/**
 * kelas bank yang akan menghasilkan object customer
 * @author Abdu Halim Wibowo
 * @version 16 April 2016
 */
public class Bank
{
    private static double creditInterestRate, investmentInterestRate,premiumInterestRate;
    private static BigDecimal cRate, iRate,pRate;
    private static int lastCustID, nextCustID = 0, numOfCurrentCustomers = 0, nextID;
    public static int MAX_NUM_OF_CUSTOMERS, maxNumofAcctsPerCustomer = 4;
    private static Date closeTime = null, startTime = null; 
    public static String phone, website, NAME= "JBANK", ADDRESS = "1234 JavaStreet, AnyCity, ThisState, 34567";
    static {
        Scanner s = new Scanner(System.in);
        System.out.print("\nMasukkan jumlah maksimum customer: ");
        int x= s.nextInt();
        MAX_NUM_OF_CUSTOMERS = x;
    }
    private static Customer[] Customers = new Customer[MAX_NUM_OF_CUSTOMERS];

    public Bank() {
    }
    
    /**
     * Method getAddress
     */
    /*
    public static String getAddress() {
        return Address;
    }*/
    public void setMax() {

    }
    
    /**
    * Method untuk membuat objek custommer
    * @param customer
     */
    public static boolean addCustomer (Customer customer) {
        for (int i = 0; i < Customers.length; i++){
            if (Customers[i] == null) {
                Customers[i] = customer;
                return true;
            } 
        }
        return false;
    }
    
    /**
    * Method untuk mengalokasikan customer ID dengan objek customer
    * @param custId
     */
    public static Customer getCustomer (int custID) {
        for (int i = 0; i < Customers.length; i++){
            if (Customers[i].getCustID() == custID) {
                return Customers[i];
            } 
        }
        return null;
    }
    
    /**
     * Method getMaxNumOfCustomers Mendapatkan jumlah maksimum customer
     * @return Jumlah maksimum customer
     */
    public static int getMaxNumOfCustomers () {
        return MAX_NUM_OF_CUSTOMERS;
    }

    /**
     * Method getCreditRate untuk mendapatkan nilai bunga kredit
     */
    public static double getCreditRate() {
        return creditInterestRate;
    }
    
    /**
     * Method getInvestmentRate untuk mendapatkan nilai bunga investment

     */
    public static double getInvestmentRate() {
        return investmentInterestRate;
    }
    
    /**
     * Method getPremiumRate untuk mendapatkan bunga premi
     */
    public static double getPremiumRate() {
        return premiumInterestRate;
    }
    
    
    /**
     * Method getHoursOfOperation untuk mendapatkan jumlah jam operasi
     */
    public static String getHoursOfOperation() {
        
        SimpleDateFormat ft= new SimpleDateFormat("hh:mm a");
        return "test";
        //return new Date(ctime.getTime() - stime.getTime()); 
    }
    
    /**
     * Method getLastID mendapatkan nomor pelanggan 
     */
    public static int getLastID() {
        return 0;
    }
    
    /**
     * Method getMaxCustomers
     */
    /*
    public static int getMaxCustomers() {
        return maxNumOfCustomers;
    }*/
    
    /**
     * Method getNumOfCurrentCustomers  untuk mendapatkan jumlah pelanggan sekarang
     */
    public static int getNumOfCurrentCustomers() {
        return numOfCurrentCustomers;
    }
    
    
    /**
     * Method getName
     */
    /*
    public static String getName() {
        return Name;
    }*/
    
    /**
     * Method getNextID untuk mengisi nomor antrian selanjutnya
     */
    public static int getNextID() {
        int nextID;
        if (numOfCurrentCustomers == MAX_NUM_OF_CUSTOMERS) {
            nextID = 0;
            nextCustID = nextID;
        } else {
            if (nextCustID == 0)  {
                lastCustID = 1000;
                nextID = 1000;
                nextCustID = nextID;
            }else {
                lastCustID = nextCustID;
                nextID = lastCustID + 1;
                nextCustID = nextID;
            }
            numOfCurrentCustomers++;
        }
        return nextID;
    }
    
    
    /**
     * Method mengsisi Website
     */
    public static String getWebsite() {
        return website;
    }
    

    /**
     * Method untuk mendapatkan nomor telefon
     */
    public static String getPhone() {
        return phone;
    }
    
    /**
     * Method untuk mendapatkan waktu tutup
     */
    public static Date getCloseTime() {
        return closeTime;
    }
   
    /**
     * Method mendapatkan waktu mulai
     */
    public static Date getStartTime() {
        return startTime;
    }
    
    /**
     * Method mendapatkan  jumlah rata kredit
     */
    public static void setCreditRate(double rate) {
    }
    
    /**
     * Method untuk mendapatkan jumlah bunga investment

     */
    public static void setInvestmentRate(double rate) {
    }
    
    /**
     * Method untuk mendapatkan jumlah premi
     */
    public static void setPremium(double rate) {
    }
    
    /**
     * Method mendapatkan waktu tutup
     */
    public static void setCloseTime(int hour, int min) {
        closeTime = new GregorianCalendar(0,0,0,hour, min).getTime();
    }
   
    /**
     * Method mendapatkan waktu mulai
     */
    public static void setStartTime(int hour, int min) {
        startTime = new GregorianCalendar(0,0,0,hour, min).getTime();
    }
    
    /**
     * Method mendapatkan waktu operasi
     * @return True or False
     */

    public boolean setHoursOfOperation(Date startTime, Date closeTime) {
        if (this.startTime != null || this.closeTime != null) {
            startTime = this.startTime;
            closeTime = this.closeTime;
            return true;
        } else {
            startTime = this.startTime;
            closeTime = this.closeTime;
            return false;
        }
    }
    
    public void printAllCustomers() {
        for (Customer c : Customers) {
            if (c!=null)
                System.out.println(c);
        }
    }
}
