import java.util.Date;
import java.util.GregorianCalendar;
import java.time.Duration;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Scanner;
/**
 * @author Abdu Halim Wibowo 
 * @version 19 Maret 2016
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
        System.out.print("\nEnter the maximum costumer: ");
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
     * Method addCustomer Menambahkan objek customer ke array Customers
     * @param customer Objek dari kelas Customer
     * @return True atau False
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
     * Method getCustomer 
     * @param custID Customer ID
     * @return Objek Customer atau Null
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
     * Method getMaxNumOfCustomers 
     * @return Jumlah maksimum customer
     */
    public static int getMaxNumOfCustomers () {
        return MAX_NUM_OF_CUSTOMERS;
    }

    /**
     * Method getCreditRate 
     * @return Rasio Bunga Kredit
     */
    public static double getCreditRate() {
        return creditInterestRate;
    }
    
    /**
     * Method getInvestmentRate 
     * @return Ratio Bunga Investasi
     */
    public static double getInvestmentRate() {
        return investmentInterestRate;
    }
    
    /**
     * Method getPremiumRate 
     * @return Ratio Bunga Premium
     */
    public static double getPremiumRate() {
        return premiumInterestRate;
    }
    
    
    /**
     * Method getHoursOfOperation 
     */
    public static String getHoursOfOperation() {
        
        SimpleDateFormat ft= new SimpleDateFormat("hh:mm a");
        return "test";
        //return new Date(closeTime.getTime() - startTime.getTime()); 
    }
    
    /**
     * Method getLastID Mendapatkan nomor pelanggan sebelumnya
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
     * Method getNumOfCurrentCustomers Mendapatkan jumlah pelanggan sekarang
     * @return Jumlah pelanggan Saat Ini
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
     * Method getNextID Mendapatkan nomor pelanggan berikutnya. Jika jumlah pelanggan
     * sekarang sama dengan jumlah pelanggan maksimum atau total maka penomoran akan di ulang.
     * @return Nomor ID selanjutnya
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
     * Method getWebsite 
     * @return Alamat Website
     */
    public static String getWebsite() {
        return website;
    }
    

    /**
     * Method getPhone 
     * @return Nomor Handphone
     */
    public static String getPhone() {
        return phone;
    }
    
    /**
     * Method getCloseTime 
     * @return Waktu tutup
     */
    public static Date getCloseTime() {
        return closeTime;
    }
   
    /**
     * Method getStartTime
     * @return Waktu buka
     */
    public static Date getStartTime() {
        return startTime;
    }
    
    /**
     * Method setCreditRate 
     * @param rate Rasio Kredit
     */
    public static void setCreditRate(double rate) {
    }
    
    /**
     * Method setInvestmentRate 
     * @param rate Rasio Investment
     */
    public static void setInvestmentRate(double rate) {
    }
    
    /**
     * Method setPremium 
     * @param rate Rasio Kredit
     */
    public static void setPremium(double rate) {
    }
    
    /**
     * Method setCloseTime 
     * @param hour Satuan Jam
     * @param min Satuan Menit
     */
    public static void setCloseTime(int hour, int min) {
        closeTime = new GregorianCalendar(0,0,0,hour, min).getTime();
    }
   
    /**
     * Method setStartTime 
     * @param hour Satuan Jam
     * @param min Satuan Menit
     */
    public static void setStartTime(int hour, int min) {
        startTime = new GregorianCalendar(0,0,0,hour, min).getTime();
    }
    
    /**
     * Method setHoursOfOperation 
     * @return True atau False
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