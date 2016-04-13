import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Date;
import java.text.*;
/**
 * Kelas customer ini akan berisi data diri customer aplikasi JBank 
 * @author Abdu Halim Wibowo
 * @version 10 April 2016
 */
public class Customer 
{   public Account[] accounts = new Account [4];
    private Account a;
    private int numOfAcc;
    private int custId,numberOfCurrentAccounts;
    private String cityAddress,email,firstName,lastName,streetAddress,phoneNumber,zipOrPostalCode,cityName;
    private Date dateOfBirth = new Date();
    private int indexArrayAcc= 0;
    private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        
    
    private Bank bank;
    private Pattern pattern;
    private Matcher matcher;    
        /** 
         * Constructor kelas Customer
         */
    public Customer(){}
    
        /**
         * Method Constructor bagi Customer
         * @param fname sebagai first name customer
         * @param lname sebagai last name customer         */
    public Customer(String fname,String lname){
         this(fname,lname,null);
    }
    
        /**
         * Method Constructor bagi Customer
         * @param fname sebagai first name 
         * @param lname sebagai last name 
         * @param dob sebagai dob customer
         * @param custId sebagai id customer selanjutya
         */
    public Customer(String firstName,String lastName, Date dob){
        this.firstName = firstName ;
        this.lastName = lastName;
        this.dateOfBirth = dob;
        this.custId = Bank.nextCustID;
    }
    
    /**
     * Method untuk string
     */
    public String toString() {
        SimpleDateFormat ft = new SimpleDateFormat ("dd/MM/yyyy");
        System.out.println("Customer ID   :   " + custId);
        System.out.println("First Name    :   " + firstName);
        System.out.println("Last Name     :   " + lastName);
        System.out.println("City Address  :   " + cityAddress);
        System.out.println("Stret Address :   " + streetAddress);
        System.out.println("Email         :   " + email);
        System.out.println("Phone Number  :   " + phoneNumber);
        System.out.println("Zip / Postal  :   " + zipOrPostalCode);
        System.out.println("DOB           :   " + ft.format(dateOfBirth));
        System.out.println("Account       :");
        /*
         for (Account a : accounts) {
            if ( a!= null) {
                switch (a.getAcctType()) {
                    case 'S': System.out.println("SAVINGS, " + a.getBalance());
                              break;
                    case 'O': System.out.println("OVERDRAFT, " + a.getBalance());
                              break;
                    case 'I': System.out.println("INVESTMENT, " + a.getBalance());
                              break;
                    case 'L': System.out.println("LINEOFCREDIT, " + a.getBalance());
                              break;
                    default : System.out.println("You Don't Have Any Account Type");
                }
            }
        }*/
        return "";
        //return firstName +", " + lastName + ", " + DOB;
    }
    
    /**
     * Method mendapatkan alamat customer
     * @return alamat jalan, nama kota dan postal code customer
     */
    public String getAddress(){
    return streetAddress+","+cityName+","+zipOrPostalCode; }
    
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
    
    /**
     * Method firstname dan lastname dari customer 
     * @return nama last dan first
     */
    public String getName () {
    return lastName + "," + firstName;
    }
    
    /**
     * Method id customer
     * @return custID 
     */
    public int getCustomer(){
    return custId; 
    }
    
    /**
     * Method email customer
     * @return email 
     */
    public String getEmail(){
    return email; 
    }
    
    /**
     * Method waktu lahir customer
     * @return dob
     */
    public Date getdateOfBirth() {
    return dateOfBirth; 
    }    
    
    /**
     * Method banyaknya akun seorang customer
     * @return jumlah banyaknya akun saat ini
     */
    public int getNumOfAccounts(){
    return numberOfCurrentAccounts;
    }
    
    /**
     * Method nomor telepon customer
     * @return nomor telepon 
     */
    public String getPhoneNumber(){
    return phoneNumber;
    }
    
    /**
     * Method lokasi alamat customer
     * @param street sebagai alamat jalan
     * @param city sebagai nama kota
     * @param code sebagai zip postal code
     */
    public void setAddress(String street, String city, String code) {
        this.streetAddress = street; 
        this.cityName = city; 
        this.zipOrPostalCode = code; 
    }
    
    /**
     * Method email customer
     * @return matcher untuk mencocokan email 
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
     * Method nomor pelanggan
     * @return nomor identitas customer
     */
    public int getCustID() {
        return custId;
    }
    
    /**
     * Method nama lengkap customer
     * @return lname sebagai nama belakang customer
     * @return fname sebagai nama depan customer
     */
    public void setName(String lname, String fname) {
        this.lastName = lname;
        this.firstName = fname; 
    }
        
        
    /**
     * Mengatur jumlah akun customer
     * @param akun customer
     */    
    /*public void setAccount(Account akun){
        accounts = akun ;}*/
   
    /**
     * Method nomor telepon customer
     * @return phoneNum 
     */  
    public void setPhoneNumber(String phoneNum) {
        this.phoneNumber = phoneNum; 
    }
    
     /**
      * Method untuk menambahkan objek akun pada customer
      * @param true or false
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
       * Method untuk menghapus objek akun pada customer
       * @param true or false
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
    
     public void printAllAccounts() {
        for (Account a : accounts) {
            if (a!=null)
                System.out.println(a);
        }
    }
}
    
    