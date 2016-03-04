import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Date;
/**
 *@author Abdu Halim Wibowo 1306447392
 *@Modul3
 */
public class Customer

{
    private Account accounts = new Account();
    private String cityAddress;
    private int custID;
    private Date DOB;
    private String email;
    private String firstName;
    private String lastName;
    private int numOfCurrentAccounts;
    private String stAddress;
    private String phone;
    private String zipOrPostalCode;
     private Pattern pattern;
    private Matcher matcher;
    private static final String emailPattern = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        
    /**
     * Method untuk tambah data 
     */
    public Customer()
    {
        
    }
    
   /**
     * Method untuk data customer
     * @param fname nama depan 
     * @param lname nama belakang 
     * @param dob tanggal lahir 
     */
    public Customer(String fname, String lname)
    {
        this("firstName", "lastName", null);
    }
    
    /**
     * Method untuk data 
     * @param firstName nama depan n
     * @param lastName nama belakang 
     * @param dateOfBirth tanggal 
     * @param custId nomor ID 
     */
    public Customer(String firstName, String lastName, Date DOB)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.DOB = DOB;
        this.custID = Bank.getNextID();
    }
    
    /**
     * Mandapatkan alamat
     * @return Address = "";
     */
    public String getAddress()
     {
        String address = stAddress + " " + cityAddress + " " + zipOrPostalCode;
        return address;
    }
    
    /**
     * mendapat informasi akun
     * @return akun info
     */
    public Account getAccount()
    {
        return accounts;
    }
    
    /**
     * mendapat ID 
     * @return custID
     */
    public int getCustID()
    {
        return custID;
    }
    
    /**
     * mendapat email 
     * @return email
     */
    public String getEmail()
    {
        String getEmail = "";
        
        return email;
    }
    
    /**
     * mendapat nama 
     * @return name
     */
    public String getName()
    {
        String name = lastName+", "+firstName;
        
        return name ;
    }
    
    /**
     * mendapat jumlah akun
     * @return jumlah account
     */
    public int getNumOfAccounts()
    {
        return numOfCurrentAccounts;
    }
    
    /**
     * mendapat nomor telpon
     */
    public String getPhone()
    {
        String getPhone = "";
        
        return phone;
    }
    
    /**
     * memasukan informasi alamat kedalam akun
     * @param alamat jalan
     * @param alamat kota
     * @param  zip atau PostalCode
     */
    public void setAddress(String street, String city, String code)
    {
        stAddress = street;
        cityAddress  = city;
        zipOrPostalCode = code;
    }
    
    /**
     * emmasukan informasi email kedalam akun
     * @param emailAddress
     */
    public void setEmail(String emailAddress)
    {
        pattern = Pattern.compile(emailPattern);
        matcher = pattern.matcher(emailAddress);
        
        if(matcher.matches()) {
            email = emailAddress;
        }
    }
    
    /**
     * memasukkan informasi nama nasabah kedalam akun
     * @param lname 
     * @param fname 
     */
    public void setName(String lname, String fname)
    {
       lastName = lname;
       firstName = fname;
    }
    
    /**
     * memasukkan informasi nomor telpon kedalam akun
     */
    public void setPhone(String phonenum)
    {
        phone = phonenum;
    }
   
    public void setAccount(Account account)
    {
        accounts = account;
    }
    
    
    public void setCustId(int id)
    {
        custID = id;
    }
    
    public boolean removeAccount(char type)
    {
        return false;
    }
    
    public String toString()
    {
        return null;
    }
}