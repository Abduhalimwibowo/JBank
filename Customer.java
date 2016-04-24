import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Date;
import java.text.*;
import java.io.*;
import java.util.*;

/**
 * Mewakili Kelas Kustomer yang berisi informasi tentang Kustomer serta akun
 * 
 * @author Abdu Halim Wibowo
 * @version 16.04.2016
 */
public class Customer implements Serializable
{   public Account[] accounts = new Account [4];
    private Account a;
    private int custId;
    private int numOfAcc;
    private int numberOfCurrentAccounts;
    private String cityAddress,email,firstName,lastName ;
    private String streetAddress,phoneNumber,zipOrPostalCode,cityName;
    private Bank bank;
    private Pattern pattern;
    private Matcher matcher; 
    private Date dateOfBirth = new Date();
    private int indexArrayAcc= 0;
    private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
          
    /**
    * constructor kosong
    */
    public Customer(){}
    
    /**
    * Constructor customer dengan parameter
    * @param String fname adalah nama depan nasabah
    * @param String lname adalah nama belakang nasabah
    */
    public Customer(String fname,String lname)
    {
         this(fname,lname,null);
    }
    

    /**
     * Metode untuk string
     * @return ""
     */
    public String toString() {
        SimpleDateFormat ft = new SimpleDateFormat ("dd/MM/yyyy");
        System.out.println("ID Customer   :   " + custId);
        System.out.println("Nama Depan    :   " + firstName);
        System.out.println("Nama Belakang    :   " + lastName);
        System.out.println("Alamat Kota  :   " + cityAddress);
        System.out.println("Alamat Jalan :   " + streetAddress);
        System.out.println("Email         :   " + email);
        System.out.println("Nomor Telepon  :   " + phoneNumber);
        System.out.println("Kode ZipPostal  :   " + zipOrPostalCode);
        System.out.println("DOB           :   " + ft.format(dateOfBirth));
        System.out.println("Akun       :");
        return "";
    }
    
    
    /**
    * Constructor customer dengan parameter
    * @param String fname adalah nama depan nasabah
    * @param String lname adalah nama belakang nasabah
    * @param String dob adalah tanggal lahir nasabah
    */
    public Customer(String firstName,String lastName, Date dob)
    {
        this.firstName = firstName ;
        this.lastName = lastName;
        this.dateOfBirth = dob;
        this.custId = Bank.nextCustID;
    }
    
    
    /**
     * Method mendapatkan akun customer
     */
    public Account getAccount(char type){
     Account acct = null;
        for (Account a: accounts ) {
            switch (type) {
                case 'S' : if( (a instanceof Savings) && !(a instanceof Investment) ) {
                    acct = a;
                }
                break;
                case 'L' : if(a instanceof LineOfCredit) {
                    acct = a;
                }
                break;
                case 'O' : if(a instanceof OverDraftProtection) {
                    acct = a;
                }
                break;
                case 'I' : if(a instanceof Investment) {
                    acct = a;
                }
                break;
            }   
        }
        return acct;
    }
    
     /*public boolean removeAccount(char type) 
   {
       Account a = null;
        boolean accountRemoved = false;
        for (int i = 0; i<=3; i++) 
        {
            switch (type) 
            {
                case 'S' : 
                if ( accounts[i] instanceof Savings && !(accounts[i] instanceof Investments)) 
                {
                    accounts[i] = null;
                    accountsIndexArray--;
                    numOfCurrentAccounts--;
                    accountRemoved = true;
                }
                break;
                
                case 'L' : 
                if ( accounts[i] instanceof LineOfCredit) 
                {
                    accounts[i] = null;
                    accountsIndexArray--;
                    numOfCurrentAccounts--;
                    accountRemoved = true;
                }
                break;
                
                case 'O' : 
                if ( accounts[i] instanceof OverdraftProtect) 
                {
                    accounts[i] = null;
                    accountsIndexArray--;
                    numOfCurrentAccounts--;
                    accountRemoved = true;
                }
                break;
                
                case 'I' :
                if ( accounts[i] instanceof Investments) 
                {
                    accounts[i] = null;
                    accountsIndexArray--;
                    numOfCurrentAccounts--;
                    accountRemoved = true;
                }
                break;
         
            }
        }
        return accountRemoved;
    }*/
    
    /**
    * method untuk mendapatkan alamat nasabah
    * @return streetAddress + cityName + zipOrPostalCode
    */ 
    public String getAddress()
    {
     return streetAddress+","+cityName+","+zipOrPostalCode; 
    }
    
    /**
    * method untuk mendapatkan nama nasabah
    * @return lastName + firstName 
    */
    public String getName () 
    {
    return lastName + "," + firstName;
    }
    
   /**
    * method untuk mendapatkan id nasabah
    */
    public int getCustomer()
    {
    return custId; 
    }
    
    /**
     * Mendapatkan email nasabah
     */
    public String getEmail()
    {
     return email; 
    }
      
    
    /**
     * Mendapatkan banyaknya akun nasabah
     */
    public int getNumOfAccounts()
    {
    return numberOfCurrentAccounts; 
    }
    
    /**
     * Mendapatkan nomor telepon nasabah
     */
    public String getPhoneNumber()
    {
     return phoneNumber;
    }
    
       /**
     * Mendapatkan tangggal lahir nasabah
     */
    public Date getdateOfBirth() 
    {
    return dateOfBirth; 
    }  
    
    /**
    * method memasukkan alamat rumah nasabah
    * @param String street adalah nama jalan
    * @param String city adalah nama kota
    * @param String code adalah kode pos
    */
    public void setAddress(String street, String city, String code) 
    {
        this.streetAddress = street; 
        this.cityName = city; 
        this.zipOrPostalCode = code; 
    }
    
        
    /**
     * Mengatur email nasabah
     */
    public boolean setEmail(String emailAddress)
    {
        pattern = Pattern.compile(EMAIL_PATTERN);
        matcher = pattern.matcher(emailAddress);
        if (matcher.matches()) {
            email = emailAddress;
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * Mendapatkan nomor ID
     */
    public int getCustID() {
        return custId;
    }
        
       
    /**
    * method memasukkan nomor telepon nasabah
    * @param String phoneNum adalah nomor telepon nasabah
    */  
    public void setPhoneNumber(String phoneNum) 
    {
        this.phoneNumber = phoneNum; 
    }
    
        /**
    * method memasukkan nama nasabah
    * @param String lastName memasukkan nama belakang nasabah
    * @param String firstName memasukkan nama depan nasabah
    */
    public void setName(String lname, String fname) 
    {
        this.lastName = lname;
        this.firstName = fname; 
    }
    
     /**
     * method untuk mengeset akun pada nasabah baru
     */
      public boolean addAccount(Account account) {
        boolean accountAdded = false, sameType = false;
        int index = -1;
        if ( numOfAcc < 5 ) {
            for (int i = indexArrayAcc; i < 4; i++) {
                if (accounts [i] == null && index == -1) {
                    index = i;
                } else if (accounts[i] != null ) {
                     if (accounts[i].getClass().equals( account.getClass() )){
                        sameType = true;
                        break;
                    }
                }
            }
            if (!sameType && index != -1){
                accounts[index] = account;
                accountAdded = true;
                numOfAcc++;
                indexArrayAcc++;
            }
        }
        return accountAdded;
    }
     
    /**
    * Metode untuk menghapus akun pada nasabh
     */
    public boolean removeAccount(char type) {
       Account a = null;
        boolean accountRemoved = false;
        for (int i = 0; i<=3; i++) {
            switch (type) {
                case 'S' : if ( accounts[i] instanceof Savings && !(accounts[i] instanceof Investment)) {
                    accounts[i] = null;
                    indexArrayAcc--;
                    numOfAcc--;
                    accountRemoved = true;
                }
                break;
                case 'L' : if ( accounts[i] instanceof LineOfCredit) {
                    accounts[i] = null;
                    indexArrayAcc--;
                    numOfAcc--;
                    accountRemoved = true;
                }
                break;
                case 'O' : if ( accounts[i] instanceof OverDraftProtection) {
                    accounts[i] = null;
                    indexArrayAcc--;
                    numOfAcc--;
                    accountRemoved = true;
                }
                break;
                case 'I' : if ( accounts[i] instanceof Investment) {
                    accounts[i] = null;
                    indexArrayAcc--;
                    numOfAcc--;
                    accountRemoved = true;
                }
                break;
            }
            
            if (accounts[i] == null && accountRemoved) {
                if ( i != 3) {
                    a = accounts[i];
                    accounts[i] = accounts [i+1];
                    accounts [i+1] = a;
                }
            }
        }
        return accountRemoved;
    }
    
    /**
    * Metode untuk mencetak seluruh akun nasbah 
    */   
     public void printAllAccounts() {
        for (Account a : accounts) {
            if (a!=null)
                System.out.println(a);
        }
    }
    
    
    
}
    
    