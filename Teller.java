import java.util.*;
import java.math.BigDecimal;
import java.math.MathContext;
import java.text.*;
import java.awt.*;
import java.lang.*;
import java.io.*;

/**
 * Merepresentasikan Akun teller, yang dapat berinteraksi dengan bank, kustomer dan akun dengan GUI.
 * 
 * @author Abdu Halim Wibowo
 * @version 24.04.2016
 */
public class Teller {
   private static MathContext mc = new MathContext(3);
   private static Date ctime ;
   private static Date stime ;
   private ArrayList<Customer> custs = new ArrayList<Customer>();
   private static SortedSet<Customer> custs1 = new TreeSet<>(Comparator.comparing(Customer::getCustID));
   

    /**
     * Main Method 
     */
     public static void main (String[] args){      
       Scanner scan = new Scanner(System.in);
       Scanner cycle = new Scanner(System.in);
       ArrayList array = new ArrayList();
       ATMGUI atm = new ATMGUI();
       atm.showATM();
        CustomerFileWriter custWriter = new CustomerFileWriter();
        CustomerFileReader custReader = new CustomerFileReader();
        Teller teller = new Teller();
        try {
            teller.custs1 = new TreeSet<>(custReader.readCustomer());}
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    
     /**
     * method untuk mengeset jam buka bank
     * @param int hour menunjukkan jam
     * @param int min menunjukkan menit
     */
        public static void setStartTime(int year,int month,int day, int hour, int min)
        {
        stime = new GregorianCalendar(year, month, day, hour, min).getTime();
        }
       
    /*{
      int nextID;
      nextID = nextCustID;
      if (nextCustID == 0)
      {
          lastCustID = 1000;
          numOfCurrentCustomer = numOfCurrentCustomer;
          return nextID;
      }
      else if ( numOfCurrentCustomer == MAX_NUM_OF_CUSTOMERS)
      {  
          return 0;
      }
      else if (nextCustID != 0)
      {
         lastCustID = nextCustID;
         nextCustID += 1;
         numOfCurrentCustomer += 1;
      }
      return nextID;
   }*/
   
    public void createNewCustomer (Customer customer)
    {
        custs.add(customer);
    }
    
     /*
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
    */
    
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
               System.out.print("Masukkan nama depan : ");
               input = s.nextLine();
               firstName = input;
               System.out.print("Masukkan nama belakang : ");
               input = s.nextLine();
               lastName = input;
               System.out.print("Masukkan nama kota : ");
               input = s.nextLine();
               cityAddress = input;
               System.out.print("Masukkan alamat jalan : ");
               input = s.nextLine();
               streetAddress = input;
               System.out.print("Masukkan alamat email : ");
               input = s.nextLine();
               email = input;
               System.out.print("Masukkan nomor telepon : ");
               input = s.nextLine();
               phoneNumber = input;
               System.out.print("Masukkan kode pos : ");
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
                System.out.println("Coba lagi");
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
                    System.out.print("Masukkan saldo awal: ");
                    input = s.nextLine();
                    balance = Integer.parseInt(input);
                    if (balance<=0) 
                    {
                        System.out.println("Masukkan saldo dengan angka!");
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
               System.out.println( b.addCustomer(c)?"Nasabah ditambahkan": "Nasabah tidak ditambahkan" );
               customerCreated++;
           }
       }
       if (c!= null) {
            b.printCustomers();
            //c = Bank.getCustomerId(1000);
            //Account acct = new Account('C', 1000, c);
            //System.out.println("Tipe Akun   : " + acct.getAcctType());
            //System.out.println("Saldo       : " + acct.getBalance());
            //System.out.println("ID Nasabah  : " + acct.getId());
        }
       
    }
    */ 
     /**
    * method untuk mengalokasikan customer ID dengan object customer
    * @param custId
    */
    public static Customer getCustomer(int custId)
    {
        Customer c = null;
        Iterator<Customer> it = custs1.iterator();
        while (it.hasNext()) {
            c = it.next();
            if (c.getCustID() == custId) {
                break;
            }
          }
        return c;
    }
        
        
   
    /**
    * method setter untuk jam tutup bank
    * @param int hour menujukkan jam
    * @param int min menunjukkan menit
    */   
    public static void setCloseTime(int year,int month,int day,int hour, int min)
    {
        ctime = new GregorianCalendar(year, month, day, hour, min).getTime();
    }
        
  
    /**
     * method untuk mengeprint jam operasional bank
     */    
    public static void printTime() 
    {
        System.out.println(Bank.getHoursOfOperation());
    }
    
    /*  public static double futureValue(double balance, double rate, double compound, double period) 
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
    */
    
   /**
     * method getter untuk Account
     * @param customer adalah object pada kelas Customer
     */ 
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





    
