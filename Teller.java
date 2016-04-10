import java.text.*;
import java.util.*;
import java.io.*;
import java.time.*;
import java.lang.Math;
import java.math.*;

/**
 * Kelas ini merupakan kelas utama dari program JBank.
 * Kelas ini memodelkan teller dalam suatu bank
 * @author Abdu Halim Wibowo
 * @version 2016.04.10 
 */
public class Teller
{
    
    public Account[] a1 = new Account [4];
    private String fullname;
    private String firstName;
    private String lastName;
    private Account acc;
    private Date startTime;
    private Date closeTime;
    private int balance;
    public static Date stm, ctm;
    private static MathContext mc = new MathContext(5), mc1 = new MathContext(2);
    
    /**
     * Main method dari class Teller yang berusaha membuat object meng-assign object a1 ke c1
     * mengisi nilai balance dan nama lalu menampilkan keduanya.
     * @param args Command-Line Arguments
     */
    public static void main(String[] args) {
        Customer c = new Customer("Abdu","Halim");
        Savings s = new Savings(c,500);
        s.addDailyInterest(280);
        Investment i = new Investment(c, 1000, 12);
        i.addDailyInterest(280);
        OverDraftProtect o = new OverDraftProtect(c, 1500, s);
        LineOfCredit l = new LineOfCredit (c, 3000, 1000);
       
          
        }
       
  /*  
  public static void main()
  {
  Bank b = new Bank();
       Scanner s = new Scanner(System.in);
       String input = "",fname,lname,no_telp,address,city,email,zip;
       int year = GregorianCalendar.YEAR; 
       int month = GregorianCalendar.MONTH;
       int day = GregorianCalendar.DAY_OF_MONTH;
       Date dob;
       char acctType;
       Customer c=null;
       boolean cek,customerAdded;
       int customerCreated = 0;
       double balance;
       Bank.getCreditRate();
       System.out.println("");
       for (int i = 0; i <= Bank.getMaxNumOfCustomers(); i++) {
           fname= null;
           lname = null;
           no_telp = null;
           city = null;
           dob = null;
           acctType = '\0';
           cek = false;
           email = null;
           zip = null;
           address = null;
           input = "";
           balance = 0;
           do {
               System.out.println("------------------------------");
               System.out.println("Selamat Datang di JBank!");
               System.out.println("------------------------------");
               System.out.println("Apakah ingin membuat Customer? (Y/N)");
               input = s.nextLine();
               if ( ( input.equals("y") ) || ( input.equals("Y")) ) {
                   cek = true;
                   break;
               } else if ( ( input.equals("n") ) || ( input.equals("N") ) ) {
                   cek = false;
                   break;
               } else {
                   System.out.println("Maaf input anda salah\n");
                   System.out.println("Masukkan hanya Y atau N\n");
               } 
           } while (!cek);
           

           if(cek) {
               System.out.print("Masukkan nama depan anda: ");
               fname = s.nextLine();
               System.out.print("Masukkan nama belakang anda : ");
               lname = s.nextLine();
               System.out.println("Masukkan tanggal lahir anda (MM/dd/yyyy): ");
               input = s.nextLine();
               try {
                    dob = new SimpleDateFormat("MM/dd/yyyy").parse(input);
                  
               } catch (ParseException e) {
                System.out.println("input salah");
               }
               System.out.print("Masukkan alamat email Anda: ");
               email = s.nextLine();
               System.out.print("Masukkan Alamat kota anda: ");
               city = s.nextLine();
               System.out.print("Masukkan alamat anda : ");
               address = s.nextLine();
               System.out.print("Masukkan kode pos anda : ");
               zip = s.nextLine();
               System.out.print("Masukkan nomor telepon anda : ");
               no_telp = s.nextLine();
               System.out.println("S: Savings; O: Overdraft; I:Investment; L: Credit Checking; N: Tidak Membuat");
               System.out.print("Masukkan jenis akun (S/O/I/L/N): ");
               input = s.nextLine();
               if (input.equals("N")) {
                  
              } else {
                  acctType = input.charAt(0);
                  do {
                    System.out.print("Memasukkan nilai saldo awal: ");
                    input = s.nextLine();
                    balance = Integer.parseInt(input);
                    if (balance<=0) {
                        System.out.println("Masukkan nilai yang benar!");
                    } else {
                        break;
                    }
                  } while(true);
              }
              c = new Customer(fname, lname, dob);
              c.setAddress(address, city, zip);
              c.setEmail(email);
              c.setPhoneNumber(no_telp);
              c.addAccount(balance, acctType);


           } else {
               break;
            }
           if (c!= null) {
               System.out.println( b.addCustomer(c)?"Account Berhasil dibuat": "Account tidak berhasil di tambahkan" );
               customerCreated++;
           }
       }
       
       if (c!= null) {
           SimpleDateFormat ft = new SimpleDateFormat ("dd/MM/yyyy");
        System.out.println("First Name    :   " + fname);
        System.out.println("Last Name     :   " + lname);
        System.out.println("Customer ID   :   " + Bank.getNextID());
        System.out.println("Email         :   " + email);
        System.out.println("City Address  :   " + city);
        System.out.println("Stret Address :   " + address);
        System.out.println("Phone Number  :   " + no_telp);
        System.out.println("Zip / Postal  :   " + zip);
        System.out.println("Tempat,Tanggal Lahir         :   " + ft.format(dob));
        System.out.println("Account       :"+acctType);
        System.out.println("Saldo         : " +balance);
        
        }
    }
    */
    
   public Teller()
    {
        Bank.getHoursOfOperation();
    } 

    /**
     * method main
     * membuat object tipe akun tertentu
     * membuat object customer beserta data diri
     */
    
 /* 
    public void main(String[] args) throws ParseException
    {/*
        // initialise instance variables
        c1.setName("Sutandi", "Sanadhi");//nama dari customer c1
        fullname = c1.getName();//assign full name sebagai nama customer c1
        System.out.println(fullname);//print nama customer c1
        
        a1.setBalance(150000);//deposit customer c1
        c1.setAccount(a1);//assign customer c1 sebagai akun a1
        acc = c1.getAccount();//account akan mendapat informasi dari c1
        balance = acc.getBalance();//assign balance account a1
        
        System.out.println(balance);//print
        
 
       Scanner input = new Scanner(System.in);//scan input user
       String fname, lname;
       
       String no_tlp, answer,acct_Type;
       Date d1,d2;
       d1 = new GregorianCalendar(2016, 3, 10, 8, 0).getTime();//buat waktu operational awal
       d2 = new GregorianCalendar(2016, 3, 10, 15, 30).getTime();//buat waktu operational akhir
       System.out.println(d1 + "to" +d2);
       int year = GregorianCalendar.YEAR; 
       int month = GregorianCalendar.MONTH;
       int day = GregorianCalendar.DAY_OF_MONTH;
       Customer c1 = new Customer (firstName,lastName, (new GregorianCalendar(year,month,day).getTime()));
       Account saving = new Account ('S', 1000);//set salod awal saving
       Account invest = new Account ('I', 1000);
       Account creditline = new Account ('C', 500);
       BigDecimal saldoS = new BigDecimal (saving.getBalance());
        BigDecimal saldoI = new BigDecimal (invest.getBalance());
        BigDecimal saldoC = new BigDecimal (creditline.getBalance());
        
        BigDecimal rS = new BigDecimal (.03); //perhitungan bunga 3% per hari
        BigDecimal rI = new BigDecimal (.07);
        BigDecimal rC = new BigDecimal (.18);
        BigDecimal n = new BigDecimal (360); 
        BigDecimal t = new BigDecimal (1.0); //perhitungan rate tahunan
        
        BigDecimal f1Saving = rS.divide(n, mc).add(new BigDecimal(1.0));
        BigDecimal f1Investement = rI.divide(n, mc).add(new BigDecimal(1.0));
        BigDecimal f1Credit = rC.divide(n, mc).add(new BigDecimal(1.0));
        BigDecimal f2 = n.multiply(t, mc);
        
        BigDecimal f3Saving = new BigDecimal (Math.pow(f1Saving.doubleValue(), f2.doubleValue()),mc);
        BigDecimal f3Investement = new BigDecimal (Math.pow(f1Investement.doubleValue(), f2.doubleValue()),mc);
        BigDecimal f3Credit = new BigDecimal (Math.pow(f1Credit.doubleValue(), f2.doubleValue()),mc);
        
        
        
        BigDecimal f4Saving = f3Saving.multiply(saldoS, mc);
        BigDecimal f4Investement = f3Investement.multiply(saldoI, mc);
        BigDecimal f4Credit = f3Credit.multiply(saldoI, mc);
     
        System.out.println("Saldo awal Saving : " +saving.getBalance());
        System.out.println("Saldo awal Investment : "+invest.getBalance());
        System.out.println("Saldo awal Credit : "+creditline.getBalance());
        System.out.println("Saldo Saving : " +f4Saving.doubleValue());
        System.out.println("Saldo Investment : " +f4Investement.doubleValue());
        System.out.println("Saldo Credit : " +f4Credit.doubleValue());
        //mulai pendataan new customer
       
         //selama jawaban yes melakukan hal berikut   
        do {
        System.out.println("Selamat datang di JBank! Apakah anda ingin mendaftar menjadi customer kami? ('yes'/'no') ? ");
        answer = input.nextLine();//scan input
        if (answer.equals("yes"))//apabila jawaban yes
        {
            
            System.out.print("Masukkan nama depan anda: ");
            fname = input.nextLine();
            System.out.print("Masukkan nama belakang anda : ");
            lname = input.nextLine();
            System.out.println("Masukkan tanggal lahir anda  : ");
            String expectedPattern = ("MM/dd/yyyy");
            String tgl = input.nextLine();
            SimpleDateFormat dateOfBirth = new SimpleDateFormat("MM/dd/yyyy");
             Date date = dateOfBirth.parse(tgl);
            Calendar calender = new GregorianCalendar();
            calender.setTime(date);
            c1.setDateOfBirth(date);
           
            
            System.out.print("Masukkan nomor telepon anda : ");
            no_tlp = input.nextLine();
            
            c1.setName(fname,lname);//set customer name
            c1.setPhoneNumber(no_tlp);//set no tekp cutomer
            //c1.setDateOfBirth(dateOfBirth);//set tanggal lahir customer
            int custId = new Bank().getNextID(); //set ID
            c1.setCustID(custId);
            String ID = Integer.toString(custId);
            System.out.println("Masukkan jenis Account yang anda inginkan S,O,I,C ?");
            
           acct_Type = input.nextLine(); //baca input tipe char user
            
             if(acct_Type.equals("S") || acct_Type.equals("O") || acct_Type.equals("I") || acct_Type.equals("C") )
             {
                        do{
                            System.out.println("Masukkan saldo awal yang diinginkan:");
                            balance = input.nextInt();
                            if(balance<=0){
                                System.out.println("Input harus diatas 0");
                        } else {
                                break;
                        }
                        }while(true);
                       
                        a1 = new Account(acct_Type.charAt(0),balance);
                    } else if (acct_Type.equals("N") || acct_Type.equals("n")){
                        //return false;
                               
                    } else {
                        System.out.println("Maaf input anda salah massukan S/O/C/I");
                    }
             
           //print semua informasi yang sudah di input user
            System.out.println("Nama = \t\t:"+c1.getName());
            System.out.println("Customer ID = \t:"+c1.getCustID());
            System.out.println("Tanggal = \t:"+calender.getTime());
            System.out.println("No telepon = \t:"+c1.getPhoneNumber());
            System.out.println("Saldo = \t:"+a1.getBalance());
            System.out.println("Tipe Akun \t:"+a1.getAcctType());
              
        } 
        
         if (answer.equals("No")){
                System.out.println("Terima Kasih");
                System.exit(0);}
    }while(true);
   
    
    
}
*/

    
    public static Date getCloseTime() {
        return ctm;
    }
    
     public static Date getStartTime() {
        return stm;
    }
    
      public static void setCloseTime(int year,int month,int day,int hour, int min) {
        stm = new GregorianCalendar(year, month, day, hour, min).getTime();
    }
    
      public static void setStartTime(int year,int month,int day,int hour, int min) {
        stm = new GregorianCalendar(year, month, day, hour, min).getTime();
    }
    
    public static void printTime() {
        System.out.println(Bank.getHoursOfOperation());
    }

    public Customer createNewCustomer(String fname, String lname, Date DOB) {
        return new Customer(fname, lname, DOB);
    }
    
    public Customer getCustomer(int customerID) {
        return new Customer();
    }
    
    

    
    }
   

 