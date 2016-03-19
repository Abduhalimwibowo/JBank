import java.util.regex.*;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.text.ParseException;
/**
 * @author Abdu Halim Wibowo 
 * @version 19 Maret 2016
 */
public class Customer
{
    private Date dateofBirthday;
    private Account[] accounts = new Account[4];
    private Account a;
    private String cityAddress,email,firstName,lastName,stAddress,phone,zipOrPostalCode;
    private int custId;
    private int numOfAccounts;
    private int indexArrayAccount = 0;
    private Pattern pattern;
    private Matcher matcher;
    private static final String testPattern = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    
    /**
     * Method Constructor Customer
     */
    
    public Customer() {
    }
    
    
    /**
     * Method Constructor Customer
     * @param fname Nama Panjang
     * @param lname Nama Belakang
     */
    public Customer(String fname, String lname) {
        this(fname,lname,null);
    }
    
    /**
     * Method Constructor Customer
     * @param fname Nama Panjang
     * @param lname Nama Belakang
     * @param dateofBirthday Tanggal Lahir
     */
    public Customer(String firstName, String lastName, Date dateofBirthday) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateofBirthday = dateofBirthday;
        custId = Bank.getNextID();
    }
    
    /**
     * Method Constructor Customer
     * @param firstName Nama Panjang
     * @param lastName Nama Belakang
     * @param dateOfBirth Tanggal Lahir
     * @param custID ID customer
     */
    
    public Customer(String firstName, String lastName, String dateofBirthday, int custId){
       
        
    }
    
   /**
     * Method toString
     */
    public String toString() {
        SimpleDateFormat ft = new SimpleDateFormat ("dd/MM/yyyy");
        System.out.println("Customer ID   :   " + custId);
        System.out.println("Nama Depan    :   " + firstName);
        System.out.println("Nama Belakang    :   " + lastName);
        System.out.println("City Address  :   " + cityAddress);
        System.out.println("Stret Address :   " + stAddress);
        System.out.println("Email         :   " + email);
        System.out.println("Phone Number  :   " + phone);
        System.out.println("Zip / Postal  :   " + zipOrPostalCode);
        System.out.println("dateofBirthday:   " + ft.format(dateofBirthday));
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
        //return firstName +", " + lastName + ", " + dateofBirthday;
    }
    
    /**
     * Method addAccount Menambahkan objek akun pada suatu customer
     * @param True or False
     */
    public boolean addAccount(double balance, char type) {
        boolean accountAdded = false, sameType = false;
        int index = -1;
        if ( numOfAccounts < 5 ) {
            for (int i = indexArrayAccount; i < 4; i++) {
                if (accounts[i] == null && index == -1) {
                    index = i;
                } else if (accounts[i] != null ) {
                    if (accounts[i].getID().endsWith( Character.toString(type) ) ) {
                        sameType = true;
                        break;
                    }
                }
            }
            if (!sameType && index != -1){
                accounts[index] = new Account (this, balance, type);
                accountAdded = true;
                numOfAccounts++;
                indexArrayAccount++;
            }
        }
        return accountAdded;
    }
    
    /**
     * Method getAddress untuk mendapatkan lokasi alamat
     * @return Data Lokasi Tempat Tinggal (Nama Jalan, Nama Kota, Kode Pos)
     */
    public String getAddress() {
        return stAddress + ", " + cityAddress + ", " + zipOrPostalCode;
    }
    
    /**
     * Method getdateofBirthday Mendapatkan tangga lahir
     * @return megembalikan Tanggal lahir
     */
    public Date getdateofBirthday() {
        return dateofBirthday;
    }
    
    /**
     * Method getAccount Mendapatkan akun pengguna
     * @return Semua akun yang dimiliki suatu Customer
     */
    public Account getAccount(char type) {
        for (Account a: accounts ) {
            if ( a.getAcctType() == type ) {
                return a;
            }   
        }
        return null;
    }
    
    /**
     * Method getCustomerId Mendapatkan nomor pelanggan
     * @return Nomor Idenditas yang dimiliki suatu Customer
     */
    public int getCustID() {
        return custId;
    }
    
    /**
     * Method getEmail Mendapatkan alamat email
     * @return Nama email yang dimiliki suatu Customer
     */
    public String getEmail() {
        return email;
    }
    
    /**
     * Method getName
     * @return Nama lengkap dari Customer (Nama Belakang,Nama Depan)
     */
    public String getName() {
        return lastName + "," + firstName;
    }
    
    /**
     * Method getNumOfAccounts
     * @return Jumlah akun yang dimiliki suatu Customer
     */
    public int getNumOfAccounts() {
        return numOfAccounts;
    }
    
    /**
     * Method getPhoneNumber
     * @return Nomor telepon yang dimiliki suatu Customer
     */
    public String getPhone() {
        return phone;
    }
    
    /**
     * Method setAddress 
     * @param street Nama Jalan
     * @param city Nama Kota
     * @param code Nomor Kode Pos
     */
    public void setAddress(String street, String city, String code) {
        stAddress = street;
        cityAddress = city;
        zipOrPostalCode = code;
    }
    
    /**
     * Method setEmail 
     * @param emailAddress Alamat Email
     */
    public boolean setEmail(String emailAddress) {
        pattern = Pattern.compile(testPattern);
        matcher = pattern.matcher(emailAddress);
        if (matcher.matches()) {
            email = emailAddress;
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * Method setName 
     * @param fname Nama lengkap
     * @param lname Nama Belakang
     */
    public void setName(String lname, String fname) {
        firstName = fname;
        lastName = lname;
    }
    
    /**
     * Method setdateofBirthday 
     * @param birthDate Tanggal lahir
     */
    public void setdateofBirthday(Date birthDate) {
        dateofBirthday = birthDate;
    }
    
    /**
     * Method setPhone 
     * @param phoneNum Nomor Telepon
     */
    public void setPhone(String phonenum) {
        phone = phonenum;
    }
    /*
    public void setCustID(int custId){
        this.custId = custId;
    }
    */
    /**
     * Method setAccount 
     */
    /*
    public void setAccount(Account accounts) {
        this.accounts[indexArrayAccount] = accounts; //Mengassign nilai global variable accounts dengan local variable accounts
        if ( ( Bank.maxNumofAcctsPerCustomer - 1) != indexArrayAccount)
            indexArrayAccount++;
    }*/
    
    /**
     * Method removeAccount 
     * @param True or False
     */
    public boolean removeAccount(char type) {
        boolean accountRemoved = false;
        for (int i = 0; i<=3; i++) {
            if ( accounts[i].getAcctType() == type) {
                accounts[i] = null;
                indexArrayAccount--;
                numOfAccounts--;
                accountRemoved = true;
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
    
}