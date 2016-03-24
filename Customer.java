import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Date;
/**
 * @author Abdu Halim Wibowo
 * @version 19 maret 2016
 */
public class Customer
{
    private Account[] accounts = new Account[4];
    
    private String cityAddress;
    private int custID;
    private Date DOB;
    private String email;
    private String firstName;
    private String lastName;
    private int numOfAccounts;
    private String stAddress;
    private String phone;
    private String zipOrPostalCode;
    private Pattern pattern;
    private Matcher matcher;
    private static final String emailPattern = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    
    /**
     * Metode untuk data nasabah
     */
    public Customer()
    {
        
    }
    
    /**
     * Metode untuk data nasabah
     * @param fname nama depan nasabah
     * @param lname nama belakang nasabah
     */
    public Customer(String fname, String lname)
    {
        this("firstName", "lastName", null);
    }
    
    /**
     * Metode untuk data nasabah
     * @param firstName nama depan nasabah
     * @param lastName nama belakang nasabah
     * @param DOB tanggal lahir nasabah
     */
    public Customer(String firstName, String lastName, Date DOB)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.DOB = DOB;
        this.custID = Bank.getNextID();
    }
    
    /**
     * Metode untuk menambahkan account
     */
    public boolean addAccount(double balance, char type)
    {
        boolean accountAdded = false;
        int i = 0;
        if(numOfAccounts < 5) {
            int notUsed = -1;
            for(i = 0; i < accounts.length; i++) {
                if(accounts[i] == null && notUsed == -1) {
                    notUsed = i;
                }
                else if(accounts[i].getId().endsWith(Character.toString(type))) {
                    accountAdded = false;
                }
            }
            if(notUsed != -1) {
                accounts[notUsed] = new Account(this, balance, type);
                accountAdded = true;
                numOfAccounts++;
            }
        }
        return accountAdded;
    }
    
    /**
     * Metode untuk mendapatkan informasi akun
     * @return informasi akun
     */
    public Account getAccount(char type)
    {
        int i = 0;
        for(i = 0; i < accounts.length; i++) {
            Account a = accounts[i];
            String ID = a.getId();
            if(ID.lastIndexOf(type) != -1) {
                return a;
            }
        }
        return null;
    }
    
    /**
     * Metode untuk menghapus account
     */
    public boolean removeAccount(char type)
    {
        boolean accountRemoved = false;
        int i = 0;
        for(i = 0; i < accounts.length; i++) {
            if(accounts[i] != null && accounts[i].getId().endsWith(Character.toString(type))) {
                accounts[i] = null;
                accountRemoved = true;
                numOfAccounts--;
            }
            else {
                accountRemoved = false;
            }
        }
        return accountRemoved;
    }
    
    /**
     * Metode untuk mendapatkan alamat nasabah
     * @return alamat
     */
    public String getAddress()
    {
        String address = stAddress + " " + cityAddress + " " + zipOrPostalCode;
        
        return address;
    }
    
    /**
     * Metode untuk mendapatkan ID nasabah
     * @return nomor ID
     */
    public int getCustID()
    {
        return custID;
    }
    
    /**
     * Metode untuk mendapatkan email nasabah
     * @return alamat email
     */
    public String getEmail()
    {
        return email;
    }
    
    /**
     * Metode untuk mendapatkan nama nasabah
     * @return nama
     */
    public String getName()
    {
        String name = firstName + " " + lastName;
        
        return name;
    }
    
    /**
     * Metode untuk mendapatkan jumlah akun
     * @return jumlah akun
     */
    public int getNumOfAccounts()
    {
        return numOfAccounts;
    }
    
    /**
     * Metode untuk mendapatkan nomor telpon nasabah
     * @return no telpon
     */
    public String getPhone()
    {
        return phone;
    }
    
    /**
     * Metode untuk mendapatkan DOB
     */
    public Date getDOB()
    {
        return DOB;
    }
    
    /**
     * Metode untuk menambahkan informasi DOB
     */
    public void setDOB(Date DOB)
    {
        this.DOB = DOB;
    }
    
    /**
     * Metode untuk memasukkan informasi alamat kedalam akun
     * @param street alamat jalan
     * @param city kota tinggal
     * @param code kode daerah
     */
    public void setAddress(String street, String city, String code)
    {
        this.stAddress = street;
        this.cityAddress = city;
        this.zipOrPostalCode = code;
    }
    
    /**
     * Metode untuk memasukkan informasi email kedalam akun
     * @param emailAddress alamat email
     */
    public void setEmail(String emailAddress)
    {
        pattern = Pattern.compile(emailPattern);
        matcher = pattern.matcher(emailAddress);
        
        if(matcher.matches()) {
            this.email = emailAddress;
        }
    }
    
    /**
     * Metode untuk memasukkan informasi nama nasabah kedalam akun
     * @param lname nama belakang
     * @param fname nama depan
     */
    public void setName(String lname, String fname)
    {
        this.lastName = lname;
        this.firstName = fname;
    }
    
    /**
     * Metode untuk memasukkan informasi nomor telpon kedalam akun
     * @param phoneNum nomor telpon
     */
    public void setPhone(String phonenum)
    {
        this.phone = phonenum;
    }
    
    /**
     * Metode untuk mengeset no ID
     */
    public void setCustID(int id)
    {
        this.custID = id;
    }
    
    public String toString()
    {
        return null;
    }
}
