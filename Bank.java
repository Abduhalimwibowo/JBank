import java.util.*;
import java.text.*;
import java.io.*;
import java.time.*;
/**
 * Kelas Bank ini akan berisi status akun dari seorang customer JBank.
 * @author Abdu Halim Wibowo
 * @version 10 April 2016
 */
public class Bank 
{   private static double creditInterestRate, investmentInterestRate, premiumInterestRate;
    private static String phone, strDateFormat;
    private static Date closeTime, startTime;
    public static int lastCustID, nextCustID = 0, numOfCurrentCustomer = 0, nextID;
    public static int MAX_NUM_OF_CUSTOMERS, maxNumOfAccForCustomer = 4;
    public static String website, Address = "1234 JavaStreet, AnyCity, ThisState, 34567", Name= "JBANK";
    static {
        Scanner s = new Scanner(System.in);
        System.out.print("\nInput the number of maximum customer account: ");
        int y = s.nextInt();
        MAX_NUM_OF_CUSTOMERS = y;
    }
    private static Customer[] Customers = new Customer[MAX_NUM_OF_CUSTOMERS];
    
    /**
     * Constructor kelas Bank
     */
    public Bank()
    {
        
    }
    
    /**
     * Method untuk mendapatkan alamat customer
     */
    /*public static String getAddress() {
        return ""; }*/
    /**
     * Method untuk menambah akun customer
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
     * Method untuk mendapatkan customer
     */
    public static Customer getCustomer (int custID) {
        for (int i = 0; i < Customers.length; i++) {
            if (Customers[i].getCustomer() == custID) {
                return Customers[i];
            }
        }
        return null;
    }
    
    /**
     * Method untuk mendapatkan jumlah akun maksimum customer
     */
    public static int getMaxNumOfCustomers() {
        return MAX_NUM_OF_CUSTOMERS;
    }
    
    /**
     * Method untuk mendapatkan interest credit rate 
     */
    public static double getCreditRate() {
        return creditInterestRate; }
    
    /**
     * Method untuk mendapatkan interest investment rate
     */
    public static double getInvestmentRate() {
        return investmentInterestRate; }
    
    /**
     * Method untuk mendapatkan jam operasinal kerja
     */
    public static String getHoursOfOperation() {
        String start, close;
        SimpleDateFormat sdf = new SimpleDateFormat (strDateFormat);
        start = sdf.format(startTime);
        close = sdf.format(closeTime);
        return start+" TO "+close;
    }
        
    /**
     * Method untuk mendapatkan id terakhir customer
     */    
    public static int getLastID() {
        return 0; 
    }
        
    /**
     * Method untuk mendapatkan jumlah maksimum customer
     */
    /*public static int getMaxCustomers() {
        return 0; }*/
    
    /**
     * Method untuk mendapatkan nama customer
     */
    /*public static String getName() {
        return ""; }*/
    
    /**
     * Method untuk mendapatkan id selanjutnya
     * @return nextCustID 
     */    
    public static int getNextID() {
     int nextID;
    if (numOfCurrentCustomer == MAX_NUM_OF_CUSTOMERS) {
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
            numOfCurrentCustomer++;
        }
        return nextID;
    }
    
    /**
     * Method untuk mendapatkan website
     */
    public static String getWebsite() {
        return website; 
    }
    
    /** 
     * Method untuk mendapatkan premium rate customer
     */    
    public static double getPremiumRate() {
        return premiumInterestRate; 
    }
    
    /**
     * Metode untuk mendapatkan nomor telepon 
     */    
    public static String getPhone() {
        return phone; 
    }
        
    /**
     * Method untuk mendapatkan jumlah customer pada saat ini
     * @return nilai jumlah pelanggan
     */
    public static int getNumOfCurrentCustomers() 
    {
        return numOfCurrentCustomer;
    }
    
    /**
     * Method untuk mengatur credit rate customer
     */
    public static void setCreditRate(double rate) {
        return; 
    }
    
    /**
     * Method untuk mengatur investment rate 
     */    
    public static void setInvestmentRate(double rate) {
        return; 
    }
        
    /**
     * Method untuk mengatur premium rate pelanggan
     */    
    public static void setPremium(double rate) {
        return; 
    }
    
        /**
         * Method untuk memasukan waktu tutup
         */
    public static void setcloseTime(int jam, int menit) {
        closeTime = new GregorianCalendar(0,0,0, jam, menit).getTime();
        }
        
        /**
         * Method untuk memasukan waktu buka
         */
    public static void setstartTime(int jam, int menit ) {
        startTime = new GregorianCalendar(0,0,0, jam, menit).getTime();
        }
        
    public static Date getcloseTime() {
        return closeTime; 
    }
        
    public static Date getstartTime() {
        return startTime; 
    }
    
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
   
