import java.util.Scanner;
import java.util.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.lang.Character;
import java.math.BigInteger;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.math.MathContext;
import java.io.Console;
/**
 * Kelas ini merupakan kelas utama dari program JBank.
 * Kelas ini memodelkan teller dalam suatu bank
 * @author Abdu Halim Wibowo
 * @version 19 maret 2016
 */
public class Teller
{
    /**
     * Main function
     */
    public static void main(String[] args)
    {
        Bank bank = new Bank();
        bank.getHoursOfOperation();
        
        do {
            Scanner scan = new Scanner(System.in);
            System.out.println("y = iya\nn = tidak\ns = cari");
            System.out.println("Apakah anda ingin menjadi nasabah? (y/n/s) ");
            String choice = scan.nextLine();
            
            if(choice.equalsIgnoreCase("y")) {
                System.out.println("Masukkan nama depan Anda: ");
                String firstName = scan.nextLine();
                System.out.println("Masukkan nama belakang Anda: ");
                String lastName = scan.nextLine();
                System.out.println("Masukkan tahun lahir Anda (yyyy): ");
                String y = scan.nextLine();
                System.out.println("Masukkan bulan lahir Anda (MM): ");
                String m = scan.nextLine();
                System.out.println("Masukkan tanggal lahir Anda (dd): ");
                String d = scan.nextLine();
                
                Date DOB = null;
                try {
                    int year = Integer.parseInt(y);
                    int month = Integer.parseInt(m) - 1;
                    int day = Integer.parseInt(d);
                    DOB = new GregorianCalendar(year, month, day).getTime();
                    
                    System.out.println("Masukkan nomor telepon Anda: ");
                    String phone = scan.nextLine();
                    
                    System.out.println("Masukkan email Anda: ");
                    String email = scan.nextLine();
                    
                    System.out.println("Masukkan alamat Anda: ");
                    String street = scan.nextLine();
                    
                    System.out.println("Masukkan kota Anda: ");
                    String city = scan.nextLine();
                    
                    System.out.println("Masukkan kode zip Anda: ");
                    String code = scan.nextLine();
                    
                    System.out.println("S = Saving\nO = Overdraft\nI = Investment\nL = Line of Credit\nT = Tidak membuat");
                    System.out.println("Masukkan tipe akun yang anda inginkan (S/O/I/L/T): ");
                    char type = scan.next().charAt(0);
                    char acctType = Character.toUpperCase(type);
                    
                    if(acctType == 'T') {
                        System.out.println("Terima kasih telah menggunakan program JBank");
                    }
                    else if(acctType == 'S' || acctType == 'O' || acctType == 'I' || acctType == 'L') {
                        System.out.println("Masukkan jumlah uang penyimpanan awal: ");
                        double balance = scan.nextDouble();
                        
                        Customer c1 = new Customer(firstName, lastName, DOB);
                        c1.setPhone(phone);
                        c1.setEmail(email);
                        c1.setAddress(street, city, code);
                        Account a1 = new Account(c1, balance, acctType);
                        //Account a1 = new Account(c1, 1000, 'C'); //pengecekan modul 5 task 3
                        bank.addCustomer(c1);
                        
                        Calendar start = new GregorianCalendar();
                        start.set(Calendar.DAY_OF_WEEK, 2);
                        start.set(Calendar.HOUR_OF_DAY, 9);
                        start.set(Calendar.MINUTE, 0);
                        Date startTime = start.getTime();
                        Calendar close = new GregorianCalendar();
                        close.set(Calendar.DAY_OF_WEEK, 6);
                        close.set(Calendar.HOUR_OF_DAY, 17);
                        close.set(Calendar.MINUTE, 0);
                        Date closeTime = close.getTime();
                        
                        SimpleDateFormat startclose = new SimpleDateFormat("k:mm");
                        SimpleDateFormat dobFormat = new SimpleDateFormat("dd MMM yyyy");
                        
                        System.out.println("Informasi Akun");
                        System.out.println("Nama            : " + c1.getName());
                        System.out.println("ID Customer     : " + a1.getId());
                        System.out.println("DOB             : " + dobFormat.format(c1.getDOB()));
                        System.out.println("No Telepon      : " + c1.getPhone());
                        System.out.println("Address         : " + c1.getAddress());
                        System.out.println("Email           : " + c1.getEmail());
                        System.out.println("Tipe Akun       : " + a1.getAcctType());
                        System.out.println("Saldo           : " + a1.getBalance());
                        System.out.println("Jam Operasional : " + bank.getHoursOfOperation());
                    }
                    else {
                        System.out.println("Input salah. Masukkan karakter S/O/I/L/T");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Format tanggal salah. Masukkan dalam format yyyy MM dd");
                }
            }
            else if(choice.equalsIgnoreCase("n")) {
                System.out.println("Terima kasih telah menggunakan program JBank");
                System.exit(0);
            }
            else if(choice.equalsIgnoreCase("s")) {
                System.out.println("Masukkan ID kostumer untuk dicari: ");
                int custID = scan.nextInt();
                String found = "Customer ditemukan";
                String notfound = "Customer tidak ditemukan";
                
                String result = bank.getCustomer(custID) != null? found : notfound;
                
                System.out.println(result);
            }
            /*else if(choice.equalsIgnoreCase("a")) {
                System.out.println("Masukkan ID kostumer: ");
                int custID = scan.nextInt();
                
            }
            else if(choice.equalsIgnoreCase("d")) {
                System.out.println("Masukkan ID kostumer: ");
                int custID = scan.nextInt();
                
            }*/
            else {
                System.out.println("Input salah. Masukkan y atau n untuk melanjutkan program");
            }            
        } while(true);
    }
    
    /**
     * Modul 4 no 3
     */
    /*public static void main() 
    {
        
        Account saving = new Account('S',1000);
        Account invest = new Account('I',1000);
        Account creditline = new Account('L',500);
        
        MathContext mc = new MathContext(10, RoundingMode.HALF_UP);
        
        BigDecimal balS = new BigDecimal(saving.getBalance());
        BigDecimal balI = new BigDecimal(invest.getBalance());
        BigDecimal balL = new BigDecimal(creditline.getBalance());
        BigDecimal credit = new BigDecimal(250);
        
        BigDecimal nd = new BigDecimal(360.0); //compound harian
        BigDecimal nm = new BigDecimal(12.0); //compound bulanan
        BigDecimal t1 = new BigDecimal(1.0); //untuk 1 tahun
        BigDecimal t2 = new BigDecimal(.5); //untuk 6 bulan
        BigDecimal rs = new BigDecimal(.03); //tingkat suku bunga saving
        BigDecimal ri1 = new BigDecimal(.05); //tingkat suku bunga invest 6 bulan
        BigDecimal ri2 = new BigDecimal(.07); //tingkat suku bunga invest 12 bulan
        BigDecimal rl = new BigDecimal(.18); //tingkat rate creditline
        
        //balance saving
        BigDecimal f1S = rs.divide(nd, mc).add(new BigDecimal(1.0));
        BigDecimal f2S = nd.multiply(t1, mc);
        BigDecimal f3S = new BigDecimal(Math.pow(f1S.doubleValue(), f2S.doubleValue()), mc);
        BigDecimal balanceS = f3S.multiply(balS, mc);
        
        //balance invest 6 bulan pertama
        BigDecimal f1I6 = ri1.divide(nm, mc).add(new BigDecimal(1.0));
        BigDecimal f2I6 = nm.multiply(t2, mc);
        BigDecimal f3I6 = new BigDecimal(Math.pow(f1I6.doubleValue(), f2I6.doubleValue()), mc);
        BigDecimal balanceI6 = f3I6.multiply(balI, mc);
        //balance invest satu tahun
        BigDecimal f1I = ri2.divide(nm, mc).add(new BigDecimal(1.0));
        BigDecimal f2I = nm.multiply(t1, mc);
        BigDecimal f3I = new BigDecimal(Math.pow(f1I.doubleValue(), f2I.doubleValue()), mc);
        BigDecimal balanceI = f3I.multiply(balanceI6, mc);
        
        //balance creditline
        BigDecimal f1L = rl.divide(nd, mc).add(new BigDecimal(1.0));
        BigDecimal f2L = nd.multiply(t1, mc);
        BigDecimal f3L = new BigDecimal(Math.pow(f1L.doubleValue(), f2L.doubleValue()), mc);
        BigDecimal creditL = f3I.multiply(credit, mc);
        BigDecimal balanceL = balL.subtract(creditL, mc);
        
        System.out.println("Balance Saving awal                     : " + balS.doubleValue());
        System.out.println("Balance Saving setelah interest         : " + balanceS.doubleValue());
        System.out.println("Balance Investment awal                 : " + balI.doubleValue());
        System.out.println("Balance Investment setelah interest     : " + balanceI.doubleValue());
        System.out.println("Balance Line of Credit awal             : " + balL.doubleValue());
        System.out.println("Balance Line of Credit setelah interest : " + balanceL.doubleValue());
    }*/
    
    /**
     * Method Constructor Teller
     */
    public Teller()
    {
        
    }
}
