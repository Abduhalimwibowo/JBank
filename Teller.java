import java.util.*;
import java.math.BigDecimal;
import java.math.MathContext;
import java.text.*;

/**
 * Kelas Teller ini merupakan proses awal dari aplikasi JBank pada saat akan dijalankan.
 * @author Abdu Halim Wibowo
 * @version 10 April 2016
 */
public class Teller {
   /*
    * Tugas Modul 2
   {
    private Customer c1 = new Customer ();
    private Account a1 = new Account ();
    private String fullname;
    private Account acc;
    private double balance;
    */
 
    /**
     * Constructor for objects of class Teller
     */
    public Teller()
    {
       
    }
    
    private static MathContext mc = new MathContext(3);
    private static Date ctime, stime; 
   
    
        /*Modul 2
        Customer c1 = new Customer();       //membuat object customer c1
        c1.setName("Sanadhi", "Sutandi");   //memasukkan nama pada customer dengan method setName()
        System.out.println(c1.getName());   //me-print namanya
        
        Account a1 = new Account();     //membuat object account a1
        a1.setBalance(1000);            //memasukkan balance customer
        c1.setAccount(a1);              //meset account a1 ke object c1
        
        Account c1a1 = c1.getAccount(); //mengakses object account dari c1        
        System.out.println(c1a1.getBalance());  //me-print balance dari customer c1 dengan account a1
        */
        
  
        String useracc;
        String firstname;
        String lastname;
        String dob;
        String telpnum;
        String accttype;
        String startTime;
        String closeTime;
        int day2;
        int month2;
        int year2;
        int hour;
        int minute;
        int second;
        int day;
        int month;
        int year;
        int bal;
        double startBalance, iSaving, iInvest, deposite;
        double withdraw = 750;
        double financeCharge = 0;
        
       public static void main(String[] args) {
        Customer c = new Customer("Abdu","Halim");
        Savings s = new Savings(c,500);
        s.addDailyInterest(280);
        Investment i = new Investment(c, 1000, 12);
        i.addDailyInterest(280);
        OverDraftProtection o = new OverDraftProtection(c, 1500, s);
        LineOfCredit l = new LineOfCredit (c, 3000, 1000);
        c.addAccount(s);
        c.addAccount(i);
        c.addAccount(o);
        c.addAccount(l);
        System.out.println("Before Withdraw\n");
        c.printAllAccounts();
        o.withdraw(1000);
        o.withdraw(800);
        l.withdraw(2000);
        l.withdraw(2000);
        System.out.println("After Withdraw\n");
        c.printAllAccounts();
    }
       /*Bank b = new Bank();
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
               System.out.println("Apakah anda ingin membuat akun Customer baru? (Y/N)");
               input = s.nextLine();
               if ( ( input.equals("y") ) || ( input.equals("Y")) ) {
                   loopState = true;
                   break;
               } else if ( ( input.equals("n") ) || ( input.equals("N") ) ) {
                   loopState = false;
                   break;
               } else {
                   System.out.println("Input hanya Y atau N saja\n");
               } 
           } while (!loopState);
           

           if(loopState) {
               System.out.print("Input nama depan: ");
               input = s.nextLine();
               fname = input;
               System.out.print("Input nama belakang: ");
               input = s.nextLine();
               lname = input;
               System.out.print("Input nama kota: ");
               input = s.nextLine();
               city = input;
               System.out.print("Input alamat jalan: ");
               input = s.nextLine();
               addr = input;
               System.out.print("Input email: ");
               input = s.nextLine();
               email = input;
               System.out.print("Input nomor telepon: ");
               input = s.nextLine();
               phone = input;
               System.out.print("Input kode pos / zip: ");
               input = s.nextLine();
               zip = input;
               System.out.print("Input tanggal lahir (Format DD-MM-YY): ");
               input = s.nextLine();
               try {
                   DOB = new SimpleDateFormat("dd-MM-yyyy").parse(input);
                  
               } catch (ParseException e) {
                System.out.println("Maaf, data yang anda masukkan tidak sesuai, silahkan mencoba lagi");
               }
              System.out.println("S: Savings; O: Overdraft; I:Investment; L: Credit Checking; T: Tidak Membuat");
              System.out.print("Input tipe akun yang akan dibuat (S/O/I/L/T): ");
              input = s.nextLine();
              if (input.equals("T")) {
                  
              } else {
                  acctType = input.charAt(0);
                  do {
                    System.out.print("Input nilai saldo awal: ");
                    input = s.nextLine();
                    balance = Integer.parseInt(input);
                    if (balance<=0) {
                        System.out.println("Input nilai yang benar!");
                    } else {
                        break;
                    }
                  } while(true);
              }
              c = new Customer(fname, lname, DOB);
              c.setAddress(addr, city, zip);
              c.setEmail(email);
              c.setPhoneNumber(phone);
              c.addAccount(balance, acctType);

           } else {
               break;
            }
           if (c!= null) {
               System.out.println( b.addCustomer(c)?"Customer bertambah.": "Customer tidak terbuat." );
               customerCreated++;
           }
       }
       if (c!= null) {
            b.printAllCustomers();
            c = Bank.getCustomer(1000);
            Account acc = new Account(c,1000,'C');
            System.out.println("Account Type: " + acc.getAcctType());
            System.out.println("Balance     : " + acc.getBalance());
            System.out.println("ID          : " + acc.getId());
        }
       
    }
        
        //Menghitung Interest Rate
        /*Account saving = new Account ('S', 1000);
        Account invest = new Account ('I', 1000);
        Account creditline = new Account ('L', 1000);
        System.out.println("Current Savings: " + saving.getBalance());
        iSaving = new BigDecimal(futureValue(saving.getBalance(),0.03,360,1)).subtract(new BigDecimal(saving.getBalance()),mc.DECIMAL32).doubleValue();
        System.out.println("1 year interest rate : " + iSaving);
        saving.deposite(iSaving);
        System.out.println("Future Savings : " + invest.getBalance());
        System.out.println("Current Investment Value : " + invest.getBalance());
        iInvest = new BigDecimal(futureValue(invest.getBalance(),0.07,360,1)).subtract(new BigDecimal(invest.getBalance()),mc.DECIMAL32).doubleValue();
        System.out.println("1 year investment interest rate : " + iInvest);
        invest.deposite(iInvest);
        System.out.println("Future Investment Value: " + invest.getBalance());
        saving.setBalance(500);
        creditline.setBalance(500);
        System.out.println("\nSavings Value: " + saving.getBalance());
        System.out.println("Line-of-Credit: " + creditline.getBalance());
        System.out.println("Withdraw: " + withdraw);
        
        if (saving.getBalance()<withdraw) {
            financeCharge = withdraw - saving.getBalance();
            saving.withdraw(withdraw-financeCharge);
            creditline.withdraw(financeCharge);
        }
        System.out.println("\nNew savings value: " + saving.getBalance());
        System.out.println("Line-of-Credit: " + creditline.getBalance());
        double iCredit = futureValue(financeCharge,0.18,360,1) - financeCharge;
        System.out.println("Line-of-Credit's Interest rate (1 year) : " + iCredit);
        financeCharge += iCredit;
        System.out.println("Total Bill: " + financeCharge);*/
 
   
        Scanner scan = new Scanner(System.in);
        Scanner cycle = new Scanner(System.in);
        ArrayList array = new ArrayList();
    
        //Untuk mengatur waktu buka 
        public static void setStartTime(int year,int month,int day, int hour, int min) {
        stime = new GregorianCalendar(year, month, day, hour, min).getTime();
    }
       
        //Untuk mengatur waktu tutup
    public Customer createNewCustomer(String fname, String lname, Date DOB) {
        return new Customer(fname, lname, DOB);
    }
    
        //Mendapatkan data customer
    public Customer getCustomer(int customerID) {
        return new Customer();
    }
    
        /*System.out.println("Do you want to make a new account ? Yes or No");
        useracc = scan.nextLine();
        if(useracc.equalsIgnoreCase("Yes")){
            //Array untuk objek customer
            Customer[] c = new Customer[20];
            Account[] a = new Account[20];
            Date[] date = new Date[20];
            int i = 0;
            do{
                //Memasukan data customer 
                System.out.println("First Name :");
                firstname = scan.nextLine();
                System.out.println("Last Name :");
                lastname = scan.nextLine();
                System.out.println("Date Of Birth (DD/MM/YYYY):");
                dob = scan.nextLine();
 
                day = Integer.parseInt(dob.substring(0,2));
                month = Integer.parseInt(dob.substring(2,4)) + 1;
                year = Integer.parseInt(startTime.substring(4,8));
                
                date[i] = new GregorianCalendar(year, month, day).getTime();
                System.out.println("Telephone Number :");
                telpnum= scan.nextLine();
                
                //Membuat objek customer
                c[i] = new Customer(firstname, lastname, date[i]);
                c[i].setPhoneNumber(telpnum);
                
                System.out.println("Input your account type : Savings(S), Overdraft (O), Credit (C), Investment (I)");
                accttype = scan.nextLine();
                if(accttype.equalsIgnoreCase("Savings")){
                    System.out.println("Input Your Balance :");
                    bal = scan.nextInt();
                    a[i] = new Account('S', bal);
                }
                else if(accttype.equalsIgnoreCase("Overdraft")){
                    System.out.println("Input Your Balance :");
                    bal = scan.nextInt();
                    a[i] = new Account('O', bal);
                }
                else if(accttype.equalsIgnoreCase("Credit")){
                    System.out.println("Input Your Balance :");
                    bal = scan.nextInt();
                    a[i] = new Account('L', bal);
                }
                else if(accttype.equalsIgnoreCase("Investment")){
                    System.out.println("Input Your Balance :");
                    bal = scan.nextInt();
                    a[i] = new Account('I', bal);
                }
                else{
                    a[i] = new Account();
                }
                // Menampilkan informasi customer 
                System.out.println("# Name\t\t: "+c[i].getName());
                System.out.println("# Phone\t\t:"+c[i].getPhoneNumber());
                System.out.println("# ID\t\t:"+c[i].getCustomer());
                System.out.println("# Balance\t:"+a[i].getBalance());
                System.out.println("# Account\t:"+a[i].getAcctType());
                System.out.println("# DOB\t\t:"+c[i].getdateOfBirth());
                
                //Membuat akun customer baru
                System.out.println("Do you want to make another customer account ? Yes or No");
                useracc = cycle.nextLine();
                
                i++;
                if(i==20){
                    break;
                }
            }while(useracc.equalsIgnoreCase("Yes"));
        }
        else{
            System.out.println("Shutting Down");
        }System.out.println("Thank You For Stoping By !");*/
        
        
        //Memasukan waktu tutup program
       public static void setCloseTime(int year,int month,int day,int hour, int min) {
        ctime = new GregorianCalendar(year, month, day, hour, min).getTime();
    }
        
        //Menampilkan waktu tutup dan buka program 
        public static void printTime() {
        System.out.println(Bank.getHoursOfOperation());
    }
    
      public static double futureValue(double balance, double rate, double compound, double period) 
    {
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
    
    public static void getAccount(Customer customer)
    {
        for (int x = 0; x < customer.accounts.length; x++)
        {
            if (customer.accounts[x] != null)
            {
                System.out.println("Account : " + customer.accounts[0].getId());
                System.out.println("Balance : " + customer.accounts[0].getBalance());
            }
        }
    }
}              



    /*
     * Tugas Modul 2
     * {   c1.setName("Sutandi", "Sanadhi"); //nama customer c1
        fullname = c1.getName();//full name akan berisi nama customer c1
        System.out.println(fullname);//memperlihatkan nama dari customer c1 pada layar
        
        a1.setBalance(20000); //membuat deposit dari customer c1
        c1.setAccount(a1); //membuat akun a1 dengan informasi mengenai customer c1
        
        acc = c1.getAccount();//akun a1 akan menerima informasi dari customer c1
        balance = acc.getBalance();//memasukan jumlah saldo ke akun a1
        
        System.out.println(balance);//memperlihatkan jumlah saldo akun a1 pada layar
      
        }*/
        
      




    
