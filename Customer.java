import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.text.*;
import java.io.*;

/**
 * Kelas ini akan menghasilkan Object Customer yang memodelkan nasabah 
 * @author Abdu Halim Wibowo
 * @version 2016.04.10
 */

public class Customer
{
    private Account[] accounts = new Account[4];
    private Account a;
    private String cityAddress;
    public double custID;
    private Account type;
    private Date dob;
    private String email;
    private String firstName;
    private String lastName;
    private String cityName;
    private int accountsIndexArray = 0;
    private int numberOfCurrentAccounts,ind;
    private String streetAddress;
    private String phoneNumber;
    private String zipOrPostalCode;
    private Boolean check;
    private Date date;
    
    private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    
    /**
     * constructor object class
     */
     public Customer() {
        // initialise instance variables
        
    }
    
   
    /**
     * method contructor customer
     * @param fname first name customer
     * @param lname last name customer
     * 
     */
    public Customer(String firstName, String lastName)
    {
      this(firstName,lastName,null);
    }
    
    /**
     * method contructor customer
     * @param fname first name customer
     * @param lname last name customer
     * @param dob date of birth customer
     * @param custId id customer
     */
    public Customer(String firstName, String lastName, Date dob)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        custID = Bank.getNextID();
    }
    
     
    /**
     * untuk mendapatkan alamat customer
     * @return alamat nama dan postalcode customer
     */
    public String getAddress()
    {
        return streetAddress+cityName+zipOrPostalCode;
    }
    
    /*
    /**
     * mendapatkan alamat customer
     * @return all account customer
     */
    /*
    public Account getAccount(char type)
    {
        for (Account a : accounts)
        {
            if (a.getAcctType()==type){
                return a;
            }
        }   
        return null;
    }
    */
   /*
     public boolean addAccount(double balance, char type) {
        boolean accountAdded = false, sameType = false;
        int index = -1;
        if ( numberOfCurrentAccounts < 5 ) {
            for (int i = accountsIndexArray; i < 4; i++) {
                if (accounts[i] == null && index == -1) {
                    index = i;
                } else if (accounts[i] != null ) {
                    if (accounts[i].getId().endsWith( Character.toString(type) ) ) {
                        sameType = true;
                        break;
                    }
                }
            }
            if (!sameType && index != -1){
                accounts[index] = new Account (this, balance, type);
                accountAdded = true;
                numberOfCurrentAccounts++;
                accountsIndexArray++;
            }
        }
        return accountAdded;
    }
    */
    
    public void setCustID(int id)
    {
        custID = id;
    }    
    
    /*
    /**
     * untuk assign update jumlah akun customer
     * @param akun milik customer
     */
    /*
    public void setAccount(Account accounts)
    {
      accounts = akun;
    }
    */
    
    /**
     * untuk mendapatkan ID customer 
     * @return custID nilai id 
     */
    public double getCustID()
    {
        return custID;
    }
    
    /**
     * untuk mendapatkan email customer
     * @return email customer
     */
    private String getEmail()
    {
        return email;
    }
    
    /**
     * method untuk mendapatkan firsname dan lastname dari customer
     * @return nama lengkap customer
     */
    public String getName()
    {    
      return lastName + " " + firstName + "," + dob;
    }
    
    
    /**
     * method untuk mendapatkan banyakya account seorang customer
     * @return nilai banyaknya account
     */
    public int getNumOfAccount()
    {
        return numberOfCurrentAccounts;
    }
    
     
    /**
     * method untuk mendapatkan no telepon customer
     * @return string no telepon
     */
    public String getPhoneNumber()
    {
        return phoneNumber;
    }
    
     
    /**
     * method untuk assign lokasi alamat
     * @param street nama jalan
     * @param city nama kota
     * @param code zip code
     */
    public void setAddress(String street, String city, String code)
    {
        this.streetAddress = street;
        this.cityName = city;
        this.zipOrPostalCode = code;
    }
    
     
    /**
     * method untuk assign email customer
     * @return matcher.matches
     */
    public boolean setEmail(String emailAddress)
    {
       this.email = emailAddress;
                
       Pattern pattern = Pattern.compile(EMAIL_PATTERN);//pattern email dari java 
       Matcher matcher = pattern.matcher(emailAddress);//assign pattern email ke matcher
       return matcher.matches(); // validasi email customer
    }
    
     
    /**
     * method untuk assign nama lengkap customer
     * @return lname nama belakang
     * @return fname nama depan
     */
    public void setName (String lname, String fname)
    {
        this.lastName = lname;
        this.firstName = fname;
        
    }
    
    
    /**
     * method set no telepon customer
     * @return phoneNum telepon customer
     */
    public void setPhoneNumber(String phoneNum)
    {
        this.phoneNumber = phoneNum;
    }
    
    public void setDateOfBirth(Date dateOfBirth)
    {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyy");
       
    }
    
     public Date getDateOfBirth(Date dateOfBirth)
    {
        String dateToStr = DateFormat.getInstance().format(date);
        return dateOfBirth;
    }
    /*
      public String toString() {
        SimpleDateFormat ft = new SimpleDateFormat ("dd/MM/yyyy");
        System.out.println("First Name    :   " + firstName);
        System.out.println("Last Name     :   " + lastName);
        System.out.println("Customer ID   :   " + custID);
        System.out.println("Email         :   " + email);
        System.out.println("City Address  :   " + cityAddress);
        System.out.println("Stret Address :   " + streetAddress);
        System.out.println("Phone Number  :   " + phoneNumber);
        System.out.println("Zip / Postal  :   " + zipOrPostalCode);
        System.out.println("Tempat,Tanggal Lahir         :   " + ft.format(dob));
        System.out.println("Account       :");
        for (Account a : accounts) {
            if ( a!= null) {
                switch (a.getAcctType()) {
                    case 'S': System.out.println("          SAVINGS, " + a.getBalance());
                              break;
                    case 'O': System.out.println("          OVERDRAFT, " + a.getBalance());
                              break;
                    case 'I': System.out.println("          INVESTMENT, " + a.getBalance());
                              break;
                    case 'L': System.out.println("          LINEOFCREDIT, " + a.getBalance());
                              break;
                    default : System.out.println("          Belum Membuat");
                }
            }
        }
        return "";
        
    }
    */
   
   /*
      public boolean removeAccount(char type)
   {
       boolean accountRemoved = false;
        for (int x = 0; x <= 3; x++) 
        {
            if ( accounts[x].getAcctType() == type) 
            {
                accounts[x] = null;
                accountsIndexArray--;
                numberOfCurrentAccounts--;
                accountRemoved = true;
            }
            
            if (accounts[x] == null && accountRemoved) 
            {
                if ( x != 3) 
                {
                    a = accounts[x];
                    accounts[x] = accounts [x+1];
                    accounts [x+1] = a;
                }
            }
        }
       return accountRemoved;
   }*/
}
