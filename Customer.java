/**
 * Punya Abdu Halim Wibowo 1306447392
 *Modul1
 */
public class Customer
{
    private Account accounts = new Account();
    private String cityName;
    private int custId;
    private String dateOfBirth;
    private String email;
    private String firstName;
    private String lastName;
    private int numberOfCurrentAccounts;
    private String streetAddress;
    private String phoneNumber;
    private String zipOrPostalCode;
    
    /**
     * Method untuk tambah data 
     */
    public Customer()
    {
        
    }
    
    /**
     * @param fname nama depan nasabah lname nama belakang nasabah dan dob tanggal lahir nasabah
     */
    public Customer(String fname, String lname, String dob)
    {
        
    }
    
    /**
     * @param firstName nama depan nasabah lastName nama belakang nasabah dateOfBirth tanggal lahir nasabah dan custId nomor ID nasabah
     */
    public Customer(String firstName, String lastName, String dateOfBirth, int custId)
    {
        
    }
    
    /**
     * Mandapatkan alamat
     * String getAddress = "";
     */
    private String getAddress()
    {   
        return streetAddress+cityName+zipOrPostalCode;
    }
    
    /**
     * mendapat informasi akun
     */
    private Account getAccount()
    {
        return accounts;
    }
    
    /**
     * mendapat ID 
     */
    private int getCustomerId()
    {
        return 0;
    }
    
    /**
     * mendapat email 
     */
    private String getEmail()
    {
        String getEmail = "";
        
        return getEmail;
    }
    
    /**
     * mendapat nama 
     */
    public String getName()
    {
        String name = lastName+", "+firstName;
        
        return name ;
    }
    
    /**
     * mendapat jumlah akun
     */
    public int getNumOfAccounts()
    {
        return 0;
    }
    
    /**
     * mendapat nomor telpon
     */
    private String getPhoneNumber()
    {
        String getPhoneNumber = "";
        
        return getPhoneNumber;
    }
    
    /**
     * memasukan informasi alamat kedalam akun
     */
    private void setAddress(String street, String city, String code)
    {
        streetAddress = street;
        cityName = city;
        zipOrPostalCode = code;
    }
    
    /**
     * emmasukan informasi email kedalam akun
     */
    private void setEmail(String emailAddress)
    {
        
    }
    
    /**
     * memasukkan informasi nama nasabah kedalam akun
     */
    public void setName(String lname, String fname)
    {
       lastName = lname;
       firstName = fname;
    }
    
    /**
     * memasukkan informasi nomor telpon kedalam akun
     */
    private void setPhoneNumber(String phoneNum)
    {
        
    }
   
    private void setAccount(Account account)
    {
        accounts = account;
    }
}