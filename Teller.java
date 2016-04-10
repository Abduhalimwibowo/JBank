import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.text.ParseException;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import java.text.SimpleDateFormat;
import java.math.BigDecimal;
import java.lang.Math;
import java.math.MathContext;
import java.math.RoundingMode;

/**
 * Kelas ini merupakan kelas utama dari program JBank.
 * Kelas ini memodelkan teller dalam suatu bank
 * @author Abdu Halim Wibowo
 * @version 2016.04.10
 */
public class Teller
{
    private static MathContext mc = new MathContext(8), mc1 = new MathContext(3);
    private static Date startTime;
    private static Date closeTime;
    private Account acc;
    private int balance;
    public Account[] a1 = new Account [4];
    
    /**
     * Constructor Teller
     */
    public Teller()
    {
        
    } 
   
    /**
     * method untuk membuat customer baru
     * @param String firstName adalah nama depan nasabah
     * @param String lastName adalah nama belakang nasabah
     * @param Date dob adalah tanggal lahir nasabah
     */
    public Customer createNewCustomer(String firstName, String lastName, Date dob)
    {
        return new Customer(firstName, lastName, dob);
    }
    
    /**
     * method untuk customer
     * @param int custId adalah ID nasabah
     */
    public Customer getCustomer(int custId)
    {
        return null;
    }
    
    /**
     * method main termodifikasi untuk menghitung interest rate
     */
    /*
    public static void main()
    {
        //setting amount
        Account savings = new Account ('S', 1000);
        Account investment = new Account ('I', 1000);
        Account creditLine = new Account ('L', 500);
        
        //setting balance
        BigDecimal balanceSavings = new BigDecimal (savings.getBalance());
        BigDecimal balanceInvestment = new BigDecimal (investment.getBalance());
        BigDecimal balanceCreditLine = new BigDecimal (250);
        
        //setting rate
        BigDecimal rateSavings = new BigDecimal (.03);      //bunga 3% per hari
        BigDecimal rateInvestment = new BigDecimal (.07);   //laju investasi
        BigDecimal rateCreditLine = new BigDecimal (.18);   //besar kredit
        BigDecimal compoundDaily = new BigDecimal (360);    //compound hari
        BigDecimal rateYear = new BigDecimal (1.0);         //rate per tahun
        
        //function 1
        BigDecimal f1Savings = rateSavings.divide(compoundDaily, mc).add(new BigDecimal(1.0));
        BigDecimal f1Investment = rateInvestment.divide(compoundDaily, mc).add(new BigDecimal(1.0));
        BigDecimal f1creditLine = rateCreditLine.divide(compoundDaily, mc).add(new BigDecimal(1.0));
        
        //function 2
        BigDecimal f2 = compoundDaily.multiply(rateYear, mc);
        
        //function 3
        BigDecimal f3Savings = new BigDecimal (Math.pow(f1Savings.doubleValue(), f2.doubleValue()),mc);
        BigDecimal f3Investment = new BigDecimal (Math.pow(f1Investment.doubleValue(), f2.doubleValue()),mc);
        BigDecimal f3creditLine = new BigDecimal (Math.pow(f1creditLine.doubleValue(), f2.doubleValue()),mc);
        
        //function 4
        BigDecimal f4Savings = f3Savings.multiply(balanceSavings, mc);
        BigDecimal f4Investment = f3Investment.multiply(balanceInvestment, mc);
        BigDecimal f4creditLine = f3creditLine.multiply(balanceCreditLine, mc);
        
        //show
        System.out.println("Saldo Tabungan Anda   : " +savings.getBalance());
        System.out.println("Saldo Investasi Anda  : " +investment.getBalance());        
        System.out.println("Saldo Tabungan baru   : " +f4Savings.doubleValue());
        System.out.println("Saldo Investasi baru  : " +f4Investment.doubleValue());
        System.out.println("Saldo Kredit baru     : " +f4creditLine.doubleValue());
    }
    */
    
    /**
     * main method aplikasi
     */
    public static void main(String[] args) 
    {
        Customer c = new Customer("Abdu","Halim");
        Savings s = new Savings(c,500);
        s.addDailyInterest(280);
        Investments i = new Investments(c, 1000, 12);
        i.addDailyInterest(280);
        OverdraftProtect o = new OverdraftProtect(c, 1500, s);
        LineOfCredit l = new LineOfCredit (c, 3000, 1000);
    }
    
    /*
    public static void main(String[] args)
    {
       Bank b = new Bank();
       Scanner s = new Scanner(System.in);
       String input = "",firstName,lastName,phoneNumber,streetAddress,cityAddress,email,zipOrPostalCode;
       Customer c = null;
       Date dob;
       char acctType;
       boolean loopCondition,customersAdded;
       int customerCreated = 0;
       double balance;
       Bank.getCreditRate();
       System.out.println("");
       for (int i = 0; i <= Bank.getMaxCustomer(); i++) {
           firstName = null;
           lastName = null;
           phoneNumber = null;
           cityAddress = null;
           dob = null;
           acctType = '\0';
           loopCondition = false;
           email = null;
           zipOrPostalCode = null;
           streetAddress = null;
           input = "";
           balance = 0;
           do 
           {
               System.out.println("Apakah Anda ingin menjadi Nasabah? (Y/N)");
               input = s.nextLine();
               if ( ( input.equals("y") ) || ( input.equals("Y")) ) 
               {
                   loopCondition = true;
                   break;
               } 
               else if ( ( input.equals("n") ) || ( input.equals("N") ) ) 
               {
                   loopCondition = false;
                   break;
               } 
               else 
               {
                   System.out.println("Input Terbatas Y Atau N Saja\n");
               } 
           } while (!loopCondition);

           if(loopCondition) {
               System.out.print("Masukkan nama depan Anda: ");
               input = s.nextLine();
               firstName = input;
               System.out.print("Masukkan nama belakang Anda: ");
               input = s.nextLine();
               lastName = input;
               System.out.print("Masukkan nama kota Anda: ");
               input = s.nextLine();
               cityAddress = input;
               System.out.print("Masukkan alamat jalan Anda: ");
               input = s.nextLine();
               streetAddress = input;
               System.out.print("Masukkan alamat email Anda: ");
               input = s.nextLine();
               email = input;
               System.out.print("Masukkan nomor telepon Anda: ");
               input = s.nextLine();
               phoneNumber = input;
               System.out.print("Masukkan kode pos Anda: ");
               input = s.nextLine();
               zipOrPostalCode = input;
               System.out.print("Masukkan tanggal lahir Anda(Format DD-MM-YYYY): ");
               input = s.nextLine();
               try 
               {
                   dob = new SimpleDateFormat("dd-MM-yyyy").parse(input);
                  
               } 
               catch (ParseException e) 
               {
                System.out.println("Tidak Sesuai");
               }
              System.out.println("S: Savings / O: Overdraft / I:Investment / L: Credit Checking / T: Tidak Membuat");
              System.out.print("Masukkan jenis akun yang akan Anda buat (S/O/I/L/T): ");
              input = s.nextLine();
              if (input.equals("T")) 
              {    
              } 
              else 
              {
                  acctType = input.charAt(0);
                  do 
                  {
                    System.out.print("Masukkan nilai saldo awal: ");
                    input = s.nextLine();
                    balance = Integer.parseInt(input);
                    if (balance<=0) 
                    {
                        System.out.println("Masukkan saldo yang tepat!");
                    } 
                    else 
                    {
                        break;
                    }
                  } 
                  while(true);
              }
              c = new Customer(firstName, lastName, dob);
              c.setAddress(streetAddress, cityAddress, zipOrPostalCode);
              c.setEmail(email);
              c.setPhoneNumber(phoneNumber);
              c.addAccount(acctType, balance);
           }
           else 
           {
               break;
           }
           if (c!= null) 
           {
               System.out.println( b.addCustomer(c)?"Nasabah telah ditambahkan": "Nasabah tidak ditambahkan" );
               customerCreated++;
           }
       }
       if (c!= null) {
            b.printCustomers();
            //c = Bank.getCustomerId(1000);
            //Account acct = new Account('C', 1000, c);
            //System.out.println("Tipe Akun Anda  : " + acct.getAcctType());
            //System.out.println("Saldo Anda      : " + acct.getBalance());
            //System.out.println("ID Nasabah Anda : " + acct.getId());
        }
       
    }
    */
    
    /**
     * method untuk mengeset jam buka bank
     */
    public static void setStartTime(int hour, int min)
    {
       Bank.setStartTime(hour,min);
    }
    
    /**
     * method untuk mengeset jam tutup bank
     */
    public static void setCloseTime(int hour, int min)
    {
        Bank.setCloseTime(hour,min);
    }
    
    /**
     * method untuk mendapatkan jam buka bank
     */
    public static Date getStartTime()
    {
        return startTime = Bank.getStartTime();
    }
    
    /**
     * method untuk mendapatkan jam tutup bank
     */
    public static Date getCloseTime()
    {
        return closeTime = Bank.getCloseTime();
    }
    
    /**
     * method untuk mengeprint jam operasional bank
     */
    public static void printTime() 
    {
        System.out.println(Bank.getHoursOfOperation());        
    }
    
        /*
        int userResponse;
        String firstName;
        String lastName;
        Date dob;
        String phoneNum;
        int accountType;
        double balanceInit;
        String random;
        String year, month, day;
        
        Scanner scan = new Scanner(System.in);
        
        
        
        System.out.println("Apakah Anda ingin menjadi Nasabah? 1=Ya/0=Tidak");
        userResponse = scan.nextInt();
        do
        {
            //input data nasabah
            System.out.println("Selamat Datang di Sistem Perbankan Kami");
            random = scan.nextLine();
            System.out.println("Masukkan Nama Depan Anda: ");
            firstName = scan.nextLine();
            System.out.println("Masukkan Nama Belakang Anda: ");
            lastName = scan.nextLine();
            System.out.println("Masukkan Nomor Telepon Anda: ");
            phoneNum = scan.nextLine();
            System.out.println("Masukkan Tanggal Lahir Anda:");
            System.out.println("Tanggal Lahir (angka): ");
            day = scan.nextLine();
            System.out.println("Bulan Lahir (angka): ");
            month = scan.nextLine();
            System.out.println("Tahun Lahir (angka): ");
            year = scan.nextLine();
            
            //membuat objek baru customer
            //String year="1995", month="7", day="10";
            Customer c1 = new Customer(firstName, lastName, (new GregorianCalendar(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day)).getTime()));
            
            c1.setPhoneNumber(phoneNum);
            
            System.out.println("Jenis Akun yang ingin Anda buat adalah?");
            System.out.println("1=Savings/2=Overdraft/3=CreditChecking/4=Investment/0=Tidak");
            accountType = scan.nextInt();
            
            Account a1 = new Account();
            //decision case account
            switch(accountType)
            {
                case 1:
                    System.out.println("Masukkan saldo awal Anda :");
                    balanceInit = scan.nextInt();
                    balanceInit = balanceInit+Account.balance;
                    a1 = new Account('S', balanceInit);
                    break;
                    
                case 2:
                    System.out.println("Masukkan saldo awal Anda :");
                    balanceInit = scan.nextInt();
                    a1 = new Account('O', balanceInit);
                    break;
                    
                case 3:
                    System.out.println("Masukkan saldo awal Anda :");
                    balanceInit = scan.nextInt();
                    a1 = new Account('L', balanceInit);
                    break;
                    
                case 4:
                    System.out.println("Masukkan saldo awal Anda :");
                    balanceInit = scan.nextInt();
                    a1 = new Account('I', balanceInit);
                    break;
                    
                case 0:
                    System.out.println("Terima Kasih Atas Kunjungan Anda");
                    break;
                /*    
                default :
                    System.out.println("Terima Kasih Atas Kunjungan Anda");
                    break;
                
            }*/
            /*
            System.out.println("=====================================================");
            System.out.println("JBANK - INFO AKUN ANDA");
            System.out.println("*Nama Anda          : "+c1.getName());
            System.out.println("*Tanggal Lahir Anda : "+c1.getDateOfBirth());
            System.out.println("*Nomor Telepon Anda : "+c1.getPhoneNumber());
            System.out.println("*Nomor ID Anda      : "+c1.getCustomerId());
            System.out.println("*Jumlah Saldo Anda  : "+a1.getBalance());
            System.out.println("*Tipe Akun Anda     : "+a1.getAcctType());
            System.out.println("*Jam Operasional    : "+Bank.getHoursOfOperation());
            System.out.println("=====================================================\n");
            
            System.out.println("Apakah Anda ingin membuat Akun Nasabah lagi? 1=Ya/2=Tidak");
            userResponse = scan.nextInt();
        }
        while(userResponse==1);
        
        System.out.println("Terima Kasih Atas Kunjungan Anda");
       
    }*/
    
    
}
