import java.util.regex.*;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.text.ParseException;

/**
 * Kelas ini akan menghasilkan Object Customer yang memodelkan nasabah 
 * @author Abdu Halim Wibowo
 * @version 16 April 2016
 */
public class Customer
{
    /**
    * deklarasi class variable
    */
    private Date DOB;
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
     * Constructor customer dengan parameter
     * @param String fname adalah nama depan nasabah
     * @param String lname adalah nama belakang nasabah
     */
    public Customer(String fname, String lname) {
        this(fname,lname,null);
    }
    
    /**
     * Method Constructor Customer
     * @param String fname adalah nama depan nasabah
     * @param String lname adalah nama belakang nasabah
     * @param String dob adalah tanggal lahir nasabah
     */
    public Customer(String firstName, String lastName, Date DOB) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.DOB = DOB;
        custId = Bank.getNextID();
    }
    
    /**
     * Method Constructor Customer
     * @param String fname adalah nama depan nasabah
     * @param String lname adalah nama belakang nasabah
     * @param String dob adalah tanggal lahir nasabah
     * @param  int custId adalah ID nasabah
     */
    
    public Customer(String firstName, String lastName, String DOB, int custId){
       
        
    }
    
   /**
     * Method toString
     */
    public String toString() {
        SimpleDateFormat ft = new SimpleDateFormat ("dd/MM/yyyy");
        System.out.println("Customer ID   :   " + custId);
        System.out.println("First Name    :   " + firstName);
        System.out.println("Last Name     :   " + lastName);
        System.out.println("City Address  :   " + cityAddress);
        System.out.println("Stret Address :   " + stAddress);
        System.out.println("Email         :   " + email);
        System.out.println("Phone Number  :   " + phone);
        System.out.println("Zip / Postal  :   " + zipOrPostalCode);
        if (DOB != null)
            System.out.println("DOB           :   " + ft.format(DOB));
        System.out.println("Account       :");
        /*
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
        }*/
        return "";
        //return firstName +", " + lastName + ", " + DOB;
    }
    
    /**
     * Method addAccount untuk menambahkan objek akun ke suatu customer
     * @param True or False
    */
    public boolean addAccount(Account acct) throws AccountTypeAlreadyExistException {
        boolean accountAdded = false, sameType = false;
        int index = -1, i= 0;
        if ( numOfAccounts < 5 ) {
            for (Account a: accounts) {
                if (accounts[i] == null && index == -1) {
                    index = i;
                } else if (accounts[i] != null ) {
                    if (accounts[i].getClass().equals( acct.getClass() )){
                        throw new AccountTypeAlreadyExistException(acct);
                    }
                }
                i++;
            }
            if (!sameType && index != -1){
                accounts[index] = acct;
                accountAdded = true;
                numOfAccounts++;
                indexArrayAccount++;
            }
        }
        return accountAdded;
    }
    
    /**
     * Method untuk endapatkan address
     */
    public String getAddress() {
        return stAddress + ", " + cityAddress + ", " + zipOrPostalCode;
    }
    
    /**
     * Method untuk mendapatkan tangga lahir
     */
    public Date getDOB() {
        return DOB;
    }
    
    /**
     * Method untuk mendapatkan akun pengguna
     */
    public Account getAccount(char type) throws AccountTypeNotFoundException {
        Account acct = null;
        for (Account a: accounts ) {
            switch (type) {
                case 'S' : if( (a instanceof Savings) && !(a instanceof Investment) ) {
                    acct = a;
                    return acct;
                }
                break;
                case 'L' : if(a instanceof LineOfCredit) {
                    acct = a;
                    return acct;
                }
                break;
                case 'O' : if(a instanceof OverDraftProtect) {
                    acct = a;
                    return acct;
                }
                break;
                case 'I' : if(a instanceof Investment) {
                    acct = a;
                    return acct;
                }
                break;
                   
            }   
        }
         throw  new AccountTypeNotFoundException(type);
    }
    
    /**
     * Method untuk mendapatkan nomor pelanggan
     */
    public int getCustID() {
        return custId;
    }
    
    /**
     * Method untuk mendapatkan email
     */
    public String getEmail() {
        return email;
    }
    
    /**
     * Method mendapakan nama
     */
    public String getName() {
        return lastName + "," + firstName;
    }
    
    /**
     * Method getNumOfAccounts
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
    * Method memasukkan alamat rumah nasabah
    * @param String street adalah nama jalan
    * @param String city adalah nama kota
    * @param String code adalah kode pos
    */
    public void setAddress(String street, String city, String code) {
        stAddress = street;
        cityAddress = city;
        zipOrPostalCode = code;
    }
    
    /**
     * Method setEmail mendaftarkan alamat email dari nasabah
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
     * Method setName mendaftarkan nama nsabah
     * @param fname Nama Panjang nasabah 
     * @param lname Nama Belakang nasabah
     */
    public void setName(String lname, String fname) {
        firstName = fname;
        lastName = lname;
    }
    
    /**
     * Method untuk mengisi tanggal lahir
     */
    public void setDOB(Date birthDate) {
        DOB = birthDate;
    }
    
    /**
     * Method untuk menisi nomor telepon
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
     * Method mendaftarkan akun yang milik customer
     */
    /*
    public void setAccount(Account accounts) {
        this.accounts[indexArrayAccount] = accounts; //Mengassign nilai global variable accounts dengan local variable accounts
        if ( ( Bank.maxNumofAcctsPerCustomer - 1) != indexArrayAccount)
            indexArrayAccount++;
    }*/
    
    /**
     * Method untuk menghapus objek akun milik customer
     * @param True or False
     */
    public boolean removeAccount(char type) {
        Account a = null;
        boolean accountRemoved = false;
        for (int i = 0; i<=3; i++) {
            switch (type) {
                case 'S' : if ( accounts[i] instanceof Savings && !(accounts[i] instanceof Investment)) {
                    accounts[i] = null;
                    indexArrayAccount--;
                    numOfAccounts--;
                    accountRemoved = true;
                }
                break;
                case 'L' : if ( accounts[i] instanceof LineOfCredit) {
                    accounts[i] = null;
                    indexArrayAccount--;
                    numOfAccounts--;
                    accountRemoved = true;
                }
                break;
                case 'O' : if ( accounts[i] instanceof OverDraftProtect) {
                    accounts[i] = null;
                    indexArrayAccount--;
                    numOfAccounts--;
                    accountRemoved = true;
                }
                break;
                case 'I' : if ( accounts[i] instanceof Investment) {
                    accounts[i] = null;
                    indexArrayAccount--;
                    numOfAccounts--;
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
    
    public void printAllAccounts() {
        for (Account a : accounts) {
            if (a!=null)
                System.out.println(a);
        }
    }
}
