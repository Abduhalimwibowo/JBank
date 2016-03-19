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
 * @author Abdu Halim Wibowo 
 * @version 19 Maret 2016
 */

public class Teller
{
    private static MathContext mc = new MathContext(3); // Membuat suatu objek math
	private static Date closeTime, startTime; 
    
    /**
     * Main method dari class Teller 
     * @param args Command-Line Arguments
     */
    public static void main(String[] args) {
	   char acctType;
       boolean loopState,customerAdded;
       int customerCreated = 0;
       double balance;
	   Date dateofBirthday;
       Bank b = new Bank();
       Scanner s = new Scanner(System.in);
       String input = "",fname,lname,phone,addr,city,email,zip;
       Customer c = null;
       
       Bank.getCreditRate();
       System.out.println("");
       for (int i = 0; i <= Bank.getMaxNumOfCustomers(); i++) {
           
           acctType = '\0';
		   input = "";
           balance = 0;
		   fname = null;
           lname = null;
           phone = null;
           city = null;
           dateofBirthday = null;
           loopState = false;
           email = null;
           zip = null;
           addr = null;
           
           do {
               System.out.println("Apakah anda ingin membuat ID? (y/n)");
               input = s.nextLine();
               if ( ( input.equals("y") ) || ( input.equals("Y")) ) {
                   loopState = true;
                   break;
               } else if ( ( input.equals("n") ) || ( input.equals("N") ) ) {
                   loopState = false;
                   break;
               } else {
                   System.out.println("Input Salah (y/n)\n");
               } 
           } while (!loopState);
           

           if(loopState) {
               System.out.print("Isikan nama depan: ");
               input = s.nextLine();
               fname = input;
               System.out.print("Isikan nama belakang: ");
               input = s.nextLine();
               lname = input;
               System.out.print("Isikan nama hometown: ");
               input = s.nextLine();
               city = input;
               System.out.print("Isikan nama homestreet: ");
               input = s.nextLine();
               addr = input;
               System.out.print("Isikan e-mail: ");
               input = s.nextLine();
               email = input;
               System.out.print("Isikan phone number: ");
               input = s.nextLine();
               phone = input;
               System.out.print("Isikan postal code: ");
               input = s.nextLine();
               zip = input;
               System.out.print("Isikan birthday (Format DD-MM-YY): ");
               input = s.nextLine();
               try {
                   dateofBirthday = new SimpleDateFormat("dd-MM-yyyy").parse(input);
                  
               } catch (ParseException e) {
                System.out.println("Ulang Tahun salah.");
               }
              System.out.println("S: Savings; O: Overdraft; I:Investment; L: Credit Checking; T: I don't want to create any");
              System.out.print("Choose an account type (S/O/I/L/T): ");
              input = s.nextLine();
              if (input.equals("T")) {
                  
              } else {
                  acctType = input.charAt(0);
                  do {
                    System.out.print("Isikan jumlah balance: ");
                    input = s.nextLine();
                    balance = Integer.parseInt(input);
                    if (balance<=0) {
                        System.out.println("Input Salah!");
                    } else {
                        break;
                    }
                  } while(true);
              }
              c = new Customer(fname, lname, dateofBirthday);
              c.setAddress(addr, city, zip);
              c.setEmail(email);
              c.setPhone(phone);
              c.addAccount(balance, acctType);

           } else {
               break;
            }
           if (c!= null) {
               System.out.println( b.addCustomer(c)?"Account anda telah ditambahkan": "Account anda tidak ditambahkand" );
               customerCreated++;
           }
       }
       
        
       
    }
    
    
   
    
     /**
     * Constructor Teller
     */
    public Teller() {
    }
    
    public Customer createNewCustomer(String fname, String lname, Date dateofBirthday) {
        return new Customer(fname, lname, dateofBirthday);
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
        return closeTime;
    }
   
    /**
     * Method getStartTime Mendapatkan waktu mulai
     * @return Waktu buka
     */
    public static Date getStartTime() {
        return startTime;
    }
    
    /**
     * Method setCloseTime Menentukan waktu tutup
     * @param hour Satuan Jam
     * @param min Satuan Menit
     */
    public static void setCloseTime(int year,int month,int day,int hour, int min) {
        closeTime = new GregorianCalendar(year, month, day, hour, min).getTime();
    }
   
    /**
     * Method setStartTime Menentukan waktu mulai
     * @param hour Satuan Jam
     * @param min Satuan Menit
     */
    public static void setStartTime(int year,int month,int day, int hour, int min) {
        startTime = new GregorianCalendar(year, month, day, hour, min).getTime();
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