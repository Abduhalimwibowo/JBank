import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.*;
import java.text.*;
import java.io.*;

/**
 * Kelas ini akan menghasilkan Object Customer yang memodelkan nasabah 
 * @author Abdu Halim Wibowo
 * @version 2016.04.10
 */
public class Customer
{
  /**
    * deklarasi class variable
    */
   private Account[] accounts = new Account[4];
   private Account a;
   private String cityAddress;
   private int custId;
   public Date dob;
   private String email;
   public String firstName;
   public String lastName;
   private int numOfCurrentAccounts;
   private int accountsIndexArray = 0;
   private String streetAddress;
   private String phoneNumber;
   private String zipOrPostalCode;
   private String checkEmail;
   private String emailRegEx = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
   private Boolean checkBoole;
   private Date date;
   
   /**
    * Constructor customer dengan parameter
    * @param String fname adalah nama depan nasabah
    * @param String lname adalah nama belakang nasabah
    */
   public Customer(String firstName, String lastName)
    {
        this(firstName, lastName, null);
    }
    
   /**
    * Constructor customer dengan parameter
    * @param String fname adalah nama depan nasabah
    * @param String lname adalah nama belakang nasabah
    * @param String dob adalah tanggal lahir nasabah
    */
    public Customer(String firstName, String lastName, Date dob)
    {
        this.firstName = firstName; 
        this.lastName = lastName;
        this.dob = dob;
        custId = Bank.getNextID();
    }
    
   /**
    * Constructor customer dengan parameter
    * @param String fname adalah nama depan nasabah
    * @param String lname adalah nama belakang nasabah
    * @param String dob adalah tanggal lahir nasabah
    * @param  int custId adalah ID nasabah
    */
    public Customer(String firstName, String lastName, Date dob, int custId)
    {
        
    }
   
   /**
     * method untuk menunjukkan data-data nasabah
     */
   /*
    public String toString()
    {
        SimpleDateFormat DOB = new SimpleDateFormat ("dd/MM/yyyy");
        System.out.println("==========================================================");
        System.out.println("JBANK - INFO AKUN ANDA");
        System.out.println("- Nomor ID Anda       : " + custId);
        System.out.println("- Nama Depan Anda     : " + firstName);
        System.out.println("- Nama Belakang Anda  : " + lastName);
        System.out.println("- Alamat Jalan Anda   : " + streetAddress);
        System.out.println("- Alamat Kota Anda    : " + cityAddress);
        System.out.println("- Kode Pos Anda       : " + zipOrPostalCode);
        System.out.println("- Nomor Telepon Anda  : " + phoneNumber);
        System.out.println("- Alamat Email Anda   : " + email);
        System.out.println("- Tanggal Lahir Anda  : " + DOB.format(dob));
        System.out.println("- Jenis Akun Anda     : ");
        System.out.println("==========================================================");
        for (Account a : accounts) //bentuk for each untuk me-loop array sesuai isinya sampai habis, tanpa perlu tahu panjang array 
        {
            if ( a!= null) 
            {
                switch (a.getAcctType()) 
                {
                    case 'S': System.out.println("Savings dengan saldo        : " + a.getBalance());
                              break;
                    case 'O': System.out.println("Overdraft dengan saldo      : " + a.getBalance());
                              break;
                    case 'C': System.out.println("Line Of Credit dengan saldo : " + a.getBalance());
                              break;
                    case 'I': System.out.println("Investment dengan saldo     : " + a.getBalance());
                              break;
                    default : System.out.println("Belum Membuat Akun");
                }
            }
        }
        return "";
    }
   */
   
   /**
    * method untuk mendapatkan id nasabah
    */
   public int getCustomerId()
    {
       return custId;
    }
   
   /**
    * method memasukkan/menambahkan akun baru
    * @param char type adalah tipe akun
    * @param double balance adalah saldo awal
    */
   /*
   public boolean addAccount(char type, double balance)
   {
       boolean accountsAdded = false, sameType = false;
       int index = -1;
        if ( numOfCurrentAccounts < 5 ) 
        {
            for (int i = accountsIndexArray; i < 4; i++) 
            {
                if(accounts[i] == null && index == -1) 
                {
                    index = i;
                } 
                else if(accounts[i] != null ) 
                {
                    if(accounts[i].getId().endsWith( Character.toString(type) ) ) 
                    {
                        sameType = true;
                        break;
                    }
                }
            }
            if (!sameType && index != -1)
            {
                accounts[index] = new Account (type,balance,this);
                accountsAdded = true;
                numOfCurrentAccounts++;
                accountsIndexArray++;
            }
        }
       return accountsAdded;
   }
   */
    
   /**
    * method untuk mendapatkan address
    */ 
    public String getAddress()
    {
       return streetAddress+ ", " +cityAddress+ ", " +zipOrPostalCode;
    }
    
   /**
    * method untuk mendapatkan akun
    */
   /*
    public Account getAccount(char type)
    {
       for (Account a: accounts ) 
       {
            if ( a.getAcctType() == type ) 
            {
                return a;
            }   
        }
       return null;
    }
    */
    
   /**
    * method untuk mendapatkan email nasabah
    */
    private String getEmail()
    {
       return email;
    }
    
   /**
    * method untuk mendapatkan nama nasabah
    */
    public String getName()
    {
       return lastName+ ", " +firstName+ ", " +dob;
    }
    
   /**
    * method untuk mendapatkan number akun
    */
    public int getNumOfAccounts()
    {
       return numOfCurrentAccounts;
    }
    
   /**
    * method untuk mendapatkan nomer telepon
    */
    public String getPhoneNumber()
    {
       return phoneNumber;
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
        this.cityAddress = city;
        this.zipOrPostalCode = code;
    }
    
   /**
    * method untuk memasukkan alamat email nasabah
    * @param String emailAddress adalah alamat email nasabah
    */
    public void setEmail(String emailAddress)
    {
        checkEmail = emailAddress;
        checkBoole = checkEmail.matches(emailRegEx);
            
            if (checkBoole == false)
            {
                System.out.println("FALSE");
            }
            else if(checkBoole == true)
            {
                System.out.println("TRUE");
                email = emailAddress;
            }
    }
    
   /**
    * method memasukkan nama nasabah
    * @param String lastName memasukkan nama belakang nasabah
    * @param String firstName memasukkan nama depan nasabah
    */
    public void setName(String lastName, String firstName)
    {
        this.lastName = lastName;
        this.firstName = firstName;
    }
   
   /**
    * method memasukkan tanggal lahir nasabah
    * @param Date dob adalah tanggal lahir nasabah
    */
   public void setDateOfBirth(Date dob)
   {
       //this.dob = dob;
       
       Date date = new Date();
       SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
   }
   
   /**
    * method untuk mendapatkan tanggal lahir nasabah bertipe date
    */
   public Date getDateOfBirth(Date dob)
   {
       String dateToString = DateFormat.getInstance().format(date);
       return dob;
   }
    
   /**
    * method memasukkan nomor telepon nasabah
    * @param String phoneNum adalah nomor telepon nasabah
    */
    public void setPhoneNumber(String phoneNum)
    {
        phoneNumber = phoneNum;
    }
    
   /**
    * method penerima input berupa referensi terhadap objek dari kelas Account
    * @param Account akun adalah akun nasabah
    */
   /*
    public void setAccount(Account akun)
    {
        accounts = akun;
    }
   */
    
   /**
    * method memasukkan ID nasabah
    * @param int custId adalah ID nasabah
    */
   public void setCustId(int custId)
   {
       custId = custId;
   }
   
   
   /**
    * method untuk menghapus akun
    * @param char type adalah tipe akun
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
                numOfCurrentAccounts--;
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
   }
   */
}
