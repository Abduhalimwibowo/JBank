import java.util.Scanner;
import java.util.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.text.SimpleDateFormat;
import java.lang.Integer;
import java.io.Console;
/**
 * Kelas ini memodelkan suatu bank
 * @author Abdu Halim Wibowo
 * @version 19 maret 2016
 */
public class Bank
{
    private static double cInterestRate;
    private static Date startTime;
    private static Date closeTime;
    private static double iInterestRate;
    private static int lastCustID;
    private static int nextCustID;
    private static String phone;
    private static double pInterestRate;
    private static int numOfCurrentCustomers;
    private static int nextID;
    public static String website;
    public static String Address = "1234 JavaStreet, AnyCity, ThisState, 34567";
    public static String Name = "JBANK";
    public static int maxNumOfAcctPerCustomer = 4;
    private static int MAX_NUM_OF_CUSTOMERS;
    static {
        Scanner scan = new Scanner(System.in);
        System.out.printf("Masukkan jumlah maksimum kostumer: ");
        int input = scan.nextInt();
        MAX_NUM_OF_CUSTOMERS = input;
    }
    private static Customer[] customers = new Customer[MAX_NUM_OF_CUSTOMERS];

    /**
     * Method constructor Bank
     */
    public Bank()
    {
        
    }
    
    public static boolean addCustomer(Customer customer)
    {
        boolean customerAdded = false;
        int i = 0;
        if(numOfCurrentCustomers <= customers.length) {
            int notUsed = -1;
            for(i = 0; i < customers.length; i++) {
                if(customers[i] == null && notUsed == -1) {
                    notUsed = i;
                }
                else {
                    customerAdded = false;
                }
            }
            if(notUsed != -1) {
                customers[notUsed] = customer;
                System.out.println("Kostumer berhasil ditambahkan");
                customerAdded = true;
            }
        }
        return customerAdded;
    }
    
    public static Customer getCustomer(int custID) {
        int i = 0;
        for(i = 0; i < customers.length; i++) {
            Customer c = customers[i];
            if(c != null && custID == c.getCustID()) {
                return c;
            }
        }
        return null;
    }
    
    public static int getMaxNumOfCustomers() {
        return MAX_NUM_OF_CUSTOMERS;
    }
    
    /**
     * Method accessor untuk mendapatkan alamat bank
     * @return alamat bank
     */
    /*public static String getAddress()
    {
        String getAddress = "";
        
        return getAddress;
    }*/
    
    /**
     * Method accessor untuk mendapatkan credit rate dalam desimal
     * @return suku bunga dalam desimal
     */
    public static double getCreditRate()
    {
        return 0;
    }
    
    /**
     * Method accessor untuk mendapatkan investment rate dalam desimal
     * @return besar tingkat investasi dalam desimal
     */
    public static double getInvestmentRate()
    {
        return 0;
    }
    
    /**
     * Method accessor untuk mendapatkan waktu kerja bank
     * @return waktu kerja
     */
    public static String getHoursOfOperation()
    {
        Calendar start = new GregorianCalendar();
        start.set(Calendar.DAY_OF_WEEK, 2);
        start.set(Calendar.HOUR_OF_DAY, 9);
        start.set(Calendar.MINUTE, 0);
        startTime = start.getTime();
        Calendar close = new GregorianCalendar();
        close.set(Calendar.DAY_OF_WEEK, 6);
        close.set(Calendar.HOUR_OF_DAY, 17);
        close.set(Calendar.MINUTE, 0);
        closeTime = close.getTime();

        SimpleDateFormat hour = new SimpleDateFormat("k:mm");
        SimpleDateFormat day = new SimpleDateFormat("EEE");
        
        String openclose = day.format(startTime) + " TO " + day.format(closeTime) + " " + hour.format(startTime) + " TO " + hour.format(closeTime);
        
        return openclose;
    }
    
    /**
     * Method accessor untuk mendapatkan nomor ID terakhir
     * @return no ID terakhir
     */
    public static int getLastID()
    {
        return 0;
    }
    
    /**
     * Method accessor untuk mendapatkan jumlah maksimum nasabah bank
     * @return jumlah maksimum nasabah
     */
    /*public static int getMaxCustomer()
    {
        return 0;
    }*/
    
    /**
     * Method accessor untuk mendapatkan nama bank
     * @return nama bank
       */
    /*public static String getName()
    {
        String getName = "";
        
        return getName;
    }*/
    
    /**
     * Method accessor untuk mendapatkan jumlah customer saat ini
     * @return jumlah customer
     */
    public static int getNumOfCurrentCustomer()
    {
        return numOfCurrentCustomers;
    }
    
    /**
     * Method accessor untuk mendapatkan nomor ID selanjutnya
     * @return no ID selanjutnya
     */
    public static int getNextID()
    {
        if(nextCustID == 0) {
            nextCustID = 1000;
            lastCustID = 1000;
            numOfCurrentCustomers++;
            
            return nextCustID;
        }
        else if(numOfCurrentCustomers == MAX_NUM_OF_CUSTOMERS) {
            return 0;
        }
        else {
            lastCustID = nextCustID;
            nextCustID = lastCustID + 1;
            numOfCurrentCustomers++;
            
            return nextCustID;
        }
    }
    
    /**
     * Method accessor untuk mendapatkan alamat website bank
     * @return url website
     */
    public static String getWebsite()
    {
        String getWebsite = "";
        
        return getWebsite;
    }
    
    /**
     * Method accessor untuk mendapatkan premium rate dalam desimal
     * @return suku bunga premium dalam desimal
     */
    public static double getPremiumRate()
    {
        return 0;
    }
    
    /**
     * Method accessor untuk mendapatkan nomor telpon bank
     * @return no telpon
     */
    public static String getPhone()
    {
        String getPhone = "";
        
        return getPhone;
    }
    
    /**
     * Method untuk mendapatkan waktu buka bank
     */
    public static Date getStartTime()
    {
        return startTime;
    }
    
    /**
     * Method untuk mendapatkan waktu tutup bank
     */
    public static Date getCloseTime()
    {
        return closeTime;
    }
    
    /**
     * Method untuk mengatur waktu buka bank
     */
    public static void setStartTime(Date hour, Date min)
    {

    }
    
    /**
     * Method untuk mengatur waktu tutup bank
     */
    public static void setCloseTime(Date hour, Date min)
    {

    }
    
    /**
     * Method mutator untuk menentukan besar credit rate akhir
     * @param rate persen suku bunga dalam desimal
     */
    public static void setCreditRate(double rate)
    {
        
    }
    
    /**
     * Method mutator untuk menentukan besar investment rate akhir
     * @param rate persen tingkat investasi dalam desimal
     */
    public static void setInvestmentRate(double rate)
    {
        
    }
    
    /**
     * Method mutator untuk menentukan besar premium rate akhir
     * @param rate persen suku bunga premium dalam desimal
     */
    public static void setPremium(double rate)
    {
        
    }
}
