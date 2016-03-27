/**
 * Kelas Teller
 * @author Abdu Halim Wibowo
 * @version 27 maret 2016
 */

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

public class Teller
{
    private static Date ctime, stime; 
    private static MathContext mc = new MathContext(3);
    //private Customer[] newCustomer = new Customer(Bank.maxNumOfCustomers);
    
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
        c.addAccount(s);
        c.addAccount(i);
        c.addAccount(o);
        c.addAccount(l);
        System.out.println("Jumlah Sebelum Penarikan\n");
        c.printAllAccounts();
        o.withdraw(1000);
        o.withdraw(800);
        l.withdraw(2000);
        l.withdraw(2000);
        System.out.println("Jumlah Setelah Penarikan\n");
        c.printAllAccounts();
    }
    
    /*
    public void sessionMod5 () {
           Bank b = new Bank();
       Scanner s = new Scanner(System.in);
       String input = "",fname,lname,phone,addr,city,email,zip;
       Customer c = null;
       Date DOB;
       char acctType;
       boolean loopState,customerAdded;
       int customerCreated = 0;
       double balance;
       Bank.getCreditRate();
       System.out.println("");
       for (int i = 0; i <= Bank.getMaxNumOfCustomers(); i++) {
           fname = null;
           lname = null;
           phone = null;
           city = null;
           DOB = null;
           acctType = '\0';
           loopState = false;
           email = null;
           zip = null;
           addr = null;
           input = "";
           balance = 0;
           do {
               System.out.println("Apakah ingin membuat Customer? (Y/N)");
               input = s.nextLine();
               if ( ( input.equals("y") ) || ( input.equals("Y")) ) {
                   loopState = true;
                   break;
               } else if ( ( input.equals("n") ) || ( input.equals("N") ) ) {
                   loopState = false;
                   break;
               } else {
                   System.out.println("Input Terbatas Y Atau N Saja\n");
               } 
           } while (!loopState);
           

           if(loopState) {
               System.out.print("Masukkan nama depan: ");
               input = s.nextLine();
               fname = input;
               System.out.print("Masukkan nama belakang: ");
               input = s.nextLine();
               lname = input;
               System.out.print("Masukkan nama kota: ");
               input = s.nextLine();
               city = input;
               System.out.print("Masukkan alamat jalan: ");
               input = s.nextLine();
               addr = input;
               System.out.print("Masukkan alamat email: ");
               input = s.nextLine();
               email = input;
               System.out.print("Masukkan nomor telepon: ");
               input = s.nextLine();
               phone = input;
               System.out.print("Masukkan kode pos / zip: ");
               input = s.nextLine();
               zip = input;
               System.out.print("Masukkan tanggal lahir (Format DD-MM-YY): ");
               input = s.nextLine();
               try {
                   DOB = new SimpleDateFormat("dd-MM-yyyy").parse(input);
                  
               } catch (ParseException e) {
                System.out.println("Tidak Sesuai");
               }
              System.out.println("S: Savings; O: Overdraft; I:Investment; L: Credit Checking; T: Tidak Membuat");
              System.out.print("Masukkan jenis akun (S/O/I/L/T): ");
              input = s.nextLine();
              if (input.equals("T")) {
                  
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
              c = new Customer(fname, lname, DOB);
              c.setAddress(addr, city, zip);
              c.setEmail(email);
              c.setPhone(phone);
              c.addAccount(balance, acctType);

           } else {
               break;
            }
           if (c!= null) {
               System.out.println( b.addCustomer(c)?"Customer ditambahkan": "Customer tidak ditambahkan" );
               customerCreated++;
           }
       }
       if (c!= null) {
            b.printAllCustomers();
            c = Bank.getCustomer(1000);
            Account acc = new Account(c,1000,'C');
            System.out.println("Account Type: " + acc.getAcctType());
            System.out.println("Balance     : " + acc.getBalance());
            System.out.println("ID          : " + acc.getID());
        }
    }*/
    /*
    public void sessionMod4 () {
        Customer cust1 = new Customer();
        Account saving = new Account (cust1, 1000,'S');
        Account invest = new Account (cust1 , 1000, 'I');
        Account creditline = new Account (cust1, 500, 'L');
        double iS, iI;
        System.out.println("Present Saving Value: US$" + saving.getBalance());
        iS = new BigDecimal(futureValue(saving.getBalance(),0.03,360,1)).subtract(new BigDecimal(saving.getBalance()),mc.DECIMAL32).doubleValue();
        System.out.println("Saving Interest Rate  (1 year): US$" + iS);
        saving.deposit(iS);
        System.out.println("Future Saving Value: US$" + saving.getBalance());
        System.out.println("\nPresent Investment Value : US$" + invest.getBalance());
        iI = new BigDecimal(futureValue(invest.getBalance(),0.07,360,1)).subtract(new BigDecimal(invest.getBalance()),mc.DECIMAL32).doubleValue();
        System.out.println("Investment Interest Rate (12 Months - Term): US$" + iI);
        invest.deposit(iI);
        System.out.println("Future Investment Value : US$" + invest.getBalance());
        saving.setBalance(500);
        double withdraw = 750;
        double financeCharge = 0;
        System.out.println("\nSaving Value: US$" + saving.getBalance());
        System.out.println("Line-of-Credit Value: US$" + creditline.getBalance());
        System.out.println("Withdrawal : US$" + withdraw);
        if (saving.getBalance()<withdraw) {
            financeCharge = withdraw - saving.getBalance();
            saving.withdraw(withdraw-financeCharge);
            creditline.withdraw(financeCharge);
        }
        System.out.println("\nSaving Value: US$" + saving.getBalance());
        System.out.println("Line-of-Credit Value: US$" + creditline.getBalance());
        double iC = futureValue(financeCharge,0.18,360,1) - financeCharge;
        System.out.println("Line-of-Credit Interest Rate (1 year) : US$" + iC);
        financeCharge += iC;
        System.out.println("Total Finance Charge: US$" + financeCharge);
    }
    */
   
    /**
     * Kelas untuk membuat session pembuatan Customer beserta Account
     */
    /*
    public void Session() {
        double balance;
        Scanner s = new Scanner(System.in);
        String input = "",fname,lname,phone;
        Customer cust1 = new Customer();
        Date DOB = null;
        char acctType;
        List<Customer> customers = new ArrayList<Customer>();
       /*
       Customer c1 = new Customer(); //Pembuatan objek Customer baru dengan nama c1
       Account a1 = new Account(), acc; //Pembuatan objek Account baru dengan nama a1 juga acc sebagai variable referensi
       c1.setName("Sanadhi","Sutandi"); //Assign nama pada object c1
       System.out.println(c1.getName()); //print nama c1
       a1.setBalance(1000000); //Assign nilai balance pada object a1
       c1.setAccount(a1); //Assign object Account a1 pada object Customer c1
       acc = c1.getAccount(); //acc mengambil referensi object Account dari object Customer c1
       System.out.println(acc.getBalance()); //print nilai balance account a1 yang dimiliki oleh customer c1
      do {
            System.out.println("Apakah ingin membuat Customer? (Y/N)");
            input = s.next();
        if ( ( input.equals("y") ) || ( input.equals("Y")) ) {
            break;
        } else if ( ( input.equals("n") ) || ( input.equals("N") ) ) {
             System.out.println("System Berhenti"); 
             break;
        } else {
            System.out.println("Input Terbatas Y Atau N Saja\n");
        }
      } 
      while(true);
      
      if ( ( input.equals("n") ) || ( input.equals("N") ) ) {
        } else {
          outerloop:
          do {
              acctType = '\0';
              System.out.print("Masukkan nama depan: ");
              input = s.next();
              fname = input;
              System.out.print("Masukkan nama belakang: ");
              input = s.next();
              lname = input;
              System.out.print("Masukkan tanggal lahir (Format DD-MM-YY): ");
              input = s.next();
              try {
                  DOB = new SimpleDateFormat("dd-MM-yyyy").parse(input);
                  
                }
            catch (ParseException e) {
                System.out.println("Tidak Sesuai");
            }
              System.out.print("Masukkan nomor telepon: ");
              input = s.next();
              phone = input;
               
              Customer c = new Customer(fname,lname,DOB);
              customers.add(c);
              c.setPhone(phone);
               
              System.out.println("S: Savings; O: Overdraft; I:Investment; L: Credit Checking; T: Tidak Membuat");
              System.out.print("Masukkan jenis akun (S/O/I/L/T): ");
              input = s.next();
              if (input.equals("T")) {
                  
              } else {
                  acctType = input.charAt(0);
                  do {
                    System.out.print("Memasukkan nilai saldo awal: ");
                    input = s.next();
                    balance = Integer.parseInt(input);
                    if (balance<=0) {
                        System.out.println("Masukkan nilai yang benar!");
                    } else {
                        break;
                    }
                  } while(true);
                  if (customers != null && !customers.isEmpty()) {
                  c.setAccount(balance,acctType);
                  }
              }
              
              System.out.println("Berikut adalah informasi pengguna");
              System.out.println(c);
              /*System.out.println("Customer ID   :   " + c.getCustId());
              System.out.println("First Name    :   " + fname);
              System.out.println("Last Name     :   " + lname);
              System.out.println("DOB           :   " + DOB);
              if (acctType != '\0')
                System.out.print(c.getAccount(acctType));
              /*System.out.println("\nAccount Type  :   " + acctType);
              System.out.println("ID            :   " + c.getAccount(acctType).getId() );
              System.out.println("Balance       :   " + balance);
              
              do {
                   System.out.println("Ingin membuat Customer lagi (Y/N)");
                   input = s.next();
                if ( ( input.equals("y") ) || ( input.equals("Y")) ) {
                    continue outerloop;
                } else if ( ( input.equals("n") ) || ( input.equals("N") ) ) {
                     System.out.println("System Berhenti"); 
                     break outerloop;
                } else {
                    System.out.println("Input Terbatas Y Atau N Saja\n");
                }
              } 
              while(true);
              
          } while(true);
        }
    }*/
    
     /**
     * Constructor Teller
     */
    public Teller() {
    }
    
    public Customer createNewCustomer(String fname, String lname, Date DOB) {
        return new Customer(fname, lname, DOB);
    }
    
    public Customer getCustomer(int customerID) {
        return new Customer();
    }
    
    public static double futureValue(double balance, double rate, double compound, double period) {
        BigDecimal bal = new BigDecimal (balance);
        BigDecimal r = new BigDecimal (rate);
        BigDecimal n = new BigDecimal (compound);
        BigDecimal t = new BigDecimal (period);
        BigDecimal f1 = r.divide(n, mc.DECIMAL32).add(new BigDecimal(1));
        BigDecimal f2 = n.multiply(t, mc.DECIMAL32);
        BigDecimal f3 = new BigDecimal (Math.pow(f1.doubleValue(), f2.doubleValue()),mc.DECIMAL32);
        BigDecimal f4 = f3.multiply(bal, mc.DECIMAL32);
        return f4.doubleValue();
    }
    
    /**
     * Method getCloseTime Mendapatkan waktu tutup
     * @return Waktu tutup
     */
    public static Date getCloseTime() {
        return ctime;
    }
   
    /**
     * Method getStartTime Mendapatkan waktu mulai
     * @return Waktu buka
     */
    public static Date getStartTime() {
        return stime;
    }
    
    /**
     * Method setCloseTime Menentukan waktu tutup
     * @param hour Satuan Jam
     * @param min Satuan Menit
     */
    public static void setCloseTime(int year,int month,int day,int hour, int min) {
        ctime = new GregorianCalendar(year, month, day, hour, min).getTime();
    }
   
    /**
     * Method setStartTime Menentukan waktu mulai
     * @param hour Satuan Jam
     * @param min Satuan Menit
     */
    public static void setStartTime(int year,int month,int day, int hour, int min) {
        stime = new GregorianCalendar(year, month, day, hour, min).getTime();
    }
    
    /**
     * Method setStartTime Menentukan waktu mulai
     * @param hour Satuan Jam
     * @param min Satuan Menit
     */
    public static void printTime() {
        System.out.println(Bank.getHoursOfOperation());
    }
    
    
}
