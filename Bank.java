import java.util.*;
import java.text.*;
import java.io.*;
import java.time.*;
/**
 * Merepresentasikan kelas Bank yang berisi informasi mengenai Bank
 * 
 * @author Abdu Halim Wibowo
 * @version 16.04.2016
 */
public class Bank 
{   private static double creditInterestRate; 
    private static double investmentInterestRate;
    private static double premiumInterestRate;
    private static String phone;
    private static String strDateFormat;
    private static Date closeTime;
    private static Date startTime;
    public static int lastCustID;
    public static int nextCustID = 0 ;
    public static int numOfCurrentCustomer = 0 ;
    public static int nextID;
    public static int MAX_NUM_OF_CUSTOMERS;
    public static int maxNumOfAccForCustomer = 4;
    public static String website, Address = "1234 JavaStreet, AnyCity, ThisState, 34567", Name= "JBANK";
    private static Customer[] Customers = new Customer[MAX_NUM_OF_CUSTOMERS];
     
    static {
        Scanner s = new Scanner(System.in);
        System.out.print("\n Masukan Maksimum Kustomer: ");
        int y = s.nextInt();
        MAX_NUM_OF_CUSTOMERS = y;
    }
  
    
    /**
     * Constructor kelas Bank
     */
    public Bank()
    {
        
    }
    
    /**
     * Metode untuk mendapatkan alamat customer
     */
    /*public static String getAddress() {
        return ""; }*/
    /**
     * Method untuk menambahkan objek customer ke dalam array
     * 
     * @param cust kustomer yang akan ditambahkan
     * @return status dari method, true jika ditambakan, false jika tidak
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
     * Method to get customer objek based on ID
     * 
     * @param custID cust di yang akan dicari.
     * @return akun kustomer dengan id yang sama dengan parameter
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
     * method untuk ambil nilai integer dari maxNumOfCustomer
     * 
     * @return jumlah maksimum kustomer yang dapat dibuat
     */
    public static int getMaxNumOfCustomers() 
    {
        return MAX_NUM_OF_CUSTOMERS;
    }
    
    /**
     * Mengambil data  persenan bunga
     * 
     * @return double   bunga bank
     */
    public static double getCreditRate() 
    {
        return creditInterestRate; 
    }
    
    /**
     * Mengambil data bunga bank tipe akun Investment 
     * 
     * @return double   bunga bank tipe Investment
     */
    public static double getInvestmentRate()
    {
        return investmentInterestRate; 
    }
    
    /**
     * Mereturn jam operasional Bank dalam bentuk string
     * 
     * @return String   jam operasi bank
     */
    public static String getHoursOfOperation() {
        String start, close;
        SimpleDateFormat sdf = new SimpleDateFormat (strDateFormat);
        start = sdf.format(startTime);
        close = sdf.format(closeTime);
        return start+" TO "+close;
    }
        
    /**
     * Mengambil ID terakhir
     * 
     * @return int  ID terakhir
     */ 
    public static int getLastID() 
    {
        return 0;
    }
        
 
   /**
     * Menunjukkan ID kustomer berikutnya. semua akun dimulai dari angka 1000.
     * customer ke -n akan mendapatkan id 1000+n
     * jika jumlah kustomer sudah penuh, maka tidak akan membuat id lagi
     * 
     * @return int  ID kustomer berikutnya
     */     
    public static int getNextID() {
    nextCustID=lastCustID+1;
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
     * Menunjukkan data website dari bank
     * 
     * @return String   untuk alamat website bank
     */ 
    public static String getWebsite() 
    {
        return website; 
    }
    
    /**
     * Mengembalikan Persen bunga untuk akun tipe Premium
     * 
     * @return persen   bunga dari premium 
     */   
    public static double getPremiumRate() 
    {
        return premiumInterestRate; 
    }
    
    /**
     * Mengembalikan data Nomor telepon Bank
     * 
     * @return Nomor    Telepon Bank
     */    
    public static String getPhone()
    {
        return phone; 
    }
        
    
    public static int getNumOfCurrentCustomers() 
    {
        return numOfCurrentCustomer;
    }
    
    /**
     * Mengeset Bunga kredit, dimasukkan dalam variabel creditInterestRate
     * 
     * @param rate  bunga kredit dalam bentuk decimal
     */
    public static void setCreditRate(double rate)
    {
        return;
    }
    
    /**
     * Mengeset Persen Bunga dari tipe akun Investment, dimasukkan kedalam
     * variabel investInterestRate
     * 
     * @param rate  persen bunga investment
     */   
    public static void setInvestmentRate(double rate) 
    {
        return; 
    }
        
    /**
     * Metode untuk mengatur premium rate pelanggan
     */    
    public static void setPremium(double rate) 
    {
        return; 
    }
    
     /**
     * Method untuk mengeset Waktu tutup Bank. Dengan parameter jam dan menit dalam bentuk integer.
     * Misal: jika bank tutup jam 21:30, maka jam=21, menit=30
     * 
     * @param jam jam berapa bank tutup 
     * @param menit Menit keberapa akan tutup 
     */
    public static void setcloseTime(int jam, int menit) {
        closeTime = new GregorianCalendar(0,0,0, jam, menit).getTime();
        }
        
    /**
     * Method untuk mengeset Waktu buka Bank. Dengan parameter jam dan menit dalam bentuk integer.
     * 
     * @param jam jam berapa bank buka 
     * @param menit Menit keberapa dia akan buka 
     */
    public static void setstartTime(int jam, int menit ) {
        startTime = new GregorianCalendar(0,0,0, jam, menit).getTime();
        }
        
     /**
     * Method untuk mengembalikan Waktu tutup Bank dalam bentuk date
     * 
     * @return waktu jam tutup
     */
        public static Date getcloseTime() 
        {
        return closeTime;
        }
        
     
    /**
     * Method untuk mennampilkan seluruh nasabah
     */
    public void printAllCustomers() {
        for (Customer c : Customers) {
            if (c!=null)
                System.out.println(c);
        }
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
    
     /**
     * Method untuk mengembalikan Waktu buka Bank dalam bentuk date
     * 
     * @return waktu jam buka
     */
    public static Date getstartTime() 
    {
     return startTime; 
    }

}
   
