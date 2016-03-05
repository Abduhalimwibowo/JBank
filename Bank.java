import java.util.Date;
/**
 * Punya Abdu Halim Wibowo 1306447392
 * @version Modul3
 */
public class Bank
{
   private static double cInterestRate;
    private static Date ctime;
    private static double iInterestRate;
    private static int lastCustID;
    private static int nextCustID;
    private static String phone;
    private static double pInterestRate;
    private static Date stime;
	private static int numOfCurrentCustomer;
    private static int nextID;
	public static String website;
	public static String Address = "1234 JavaStreet, AnyCity, ThisState, 34567";
	public static int maxNumOfCustomers = 20;
	public static int maxNumOfAcctPerCustomer = 4;
	public static String Name = "JBANK";
	

	/**
     * Method untuk constructor Bank
     */
    private Bank()
    {
        
    }
    
	/**
	 * mendapatkan alamat bank
	 */
	/*public static String getAddress()
	{
	    String getAddress = "";
	    
		return getAddress;
	}
	*/
	/**
	 * mendapatkan credit rate dalam desimal
	 */
	public static double getCreditRate()
	{
		return 0;
	}
	
	/**
	 * mendapatkan investment rate dalam desimal
	 */
	public static double getInvestmentRate()
	{
		return 0;
	}
	
	/**
	 * mendapatkan waktu kerja bank
	 */
	public static String getHoursOfOperation()
	{
	    String getHoursOfOperation = "";
	    
		return getHoursOfOperation;
	}
	
	/**
	 * mendapatkan nomor ID terakhir
	 */
	public static int getLastID()
	{
		return 0;
	}
	
	/**
	 * mendapatkan jumlah maksimum customer bank
	 */
	/*public static int getMaxCustomer()
    {
        return 0;
    }*/
    
    
	/**
	 * mendapatkan nama bank
	 */
	  /*public static String getName()
    {
        String getName = "";
        
        return getName;
    }*/
	
	/**
     * Metode accessor mendapat jumlah customer sekarang 
     * @return jumlah customer
     */
    public static int getNumOfCurrentCustomer()
    {
        return numOfCurrentCustomer;
    }
    
	/**
	 * mendapatkan nomor ID selanjutnya
	 */
	public static int getNextID()
	{
        if(nextCustID == 0) {
            nextCustID = 1000;
            lastCustID = 1000;
            numOfCurrentCustomer++;
            
            return nextCustID;
        }
        else if(numOfCurrentCustomer == maxNumOfCustomers) {
            return 0;
        }
        else {
            lastCustID = nextCustID;
            nextCustID = lastCustID + 1;
            numOfCurrentCustomer++;
            
            return nextCustID;
        }
    }
	
	/**
	 * mendapatkan alamat website bank
	 */
	public static String getWebsite()
	{
	    String getWebsite = "";
	    
		return getWebsite;
	}
	
	/**
	 * Metode mendapatkan premium rate 
	 * @return suku bunga premium rate 
	 */
	public static double getPremiumRate()
	{
		return 0;
	}
	
	/**
	 * Metode untuk mendapatkan nomor telpon 
	 * @return no telpon
	 */
	public static String getPhone()
	{
	    String getPhone = "";
	    
		return getPhone;
	}
	
	/**
	 * Metode menentukan besar credit rate akhir
	 * @param rate persen suku bunga
	 */
	public static void setCreditRate(double rate)
	{
		
	}
	
	/**
	 * menentukan besar investment rate akhir
	 * @param rate persen investasi 
	 */
	public static void setInvestmentRate(double rate)
	{
		
	}
	
	/**
	 * menentukan besar premium rate akhir
	 * @param rate persen suku bunga premium
	 */
	public static void setPremium(double rate)
	{
		
	}
}
