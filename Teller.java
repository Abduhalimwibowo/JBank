import java.util.Scanner;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.lang.Character;
import java.util.GregorianCalendar;
import java.util.Calendar;
import java.math.BigDecimal;
import java.lang.Math;
import java.math.MathContext;
import java.math.RoundingMode;
/**
 *@author Abdu Halim Wibowo 1306447392
 *@version Modul4
 */
public class Teller
{
    private static MathContext mc = new MathContext(3);
    /**
     *main method
     */
    /**
     * Main function
     */
    public static void main(String[] args)
    {
        /*modul2*/ 
        /*Customer c1 = new Customer(); //Membuat object customer dengan nama c1
        c1.setName("Sanadhi", "Sutandi"); //Mengganti nama c1 jadi Sanadhi Sutandi
        System.out.println(c1.getName()); //Menampilkan output c1
        Account a1 = new Account(), account; //Membuat object account dengan nama a1 dengan variabel account menjadi referensinya
        a1.setBalance(1000000); //Mengubah nilai saldo pada a1
        c1.setAccount(a1); //mengassign object dari account a1 ke account c1
        account = c1.getAccount(); //Mengambil dan menyimpan data pada Account a1 ke variabel account
        System.out.println(account.getBalance()); //Menampilkan jumlah saldo dengan variabel account*/
        
        String firstname;
        String lastname;
        String userResponse;
        String accountType;
        double startBalance, iSaving, iInvest;
        double financeCharge = 0;
        double withdraw = 750;
        
        
        Account saving = new Account ('S', 1000);
        Account invest = new Account ('I', 1000);
        Account creditline = new Account ('L', 1000);
        System.out.println("Jumlah simpanan Anda saat ini: " + saving.getBalance());
        iSaving = new BigDecimal(futureValue(saving.getBalance(),0.03,360,1)).subtract(new BigDecimal(saving.getBalance()),mc.DECIMAL32).doubleValue();
        System.out.println("Suku bunga tabungan Anda dalam 1 tahun: " + iSaving);
        saving.deposite(iSaving);
        System.out.println("Jumlah simpanan masa depan Anda : " + invest.getBalance());
        System.out.println("Nilai investasi Anda sekarang : " + invest.getBalance());
        iInvest = new BigDecimal(futureValue(invest.getBalance(),0.07,360,1)).subtract(new BigDecimal(invest.getBalance()),mc.DECIMAL32).doubleValue();
        System.out.println("Suku bunga investasi Anda dalam 12 Bulan: " + iInvest);
        invest.deposite(iInvest);
        System.out.println("Nilai investasi masa depan Anda : " + invest.getBalance());
        saving.setBalance(500);
        creditline.setBalance(500);
        System.out.println("\nJumlah Simpanan: " + saving.getBalance());
        System.out.println("LOC: " + creditline.getBalance());
        System.out.println("Penarikan: " + withdraw);
        if (saving.getBalance()<withdraw) {
            financeCharge = withdraw - saving.getBalance();
            saving.withdraw(withdraw-financeCharge);
            creditline.withdraw(financeCharge);
        }
        System.out.println("\nJumlah Simpanan: " + saving.getBalance());
        System.out.println("LOC: " + creditline.getBalance());
        double iCredit = futureValue(financeCharge,0.18,360,1) - financeCharge;
        System.out.println("Suku bunga LOC dalam 1 tahun : " + iCredit);
        financeCharge += iCredit;
        System.out.println("Total: " + financeCharge);
        
        do {
            Scanner scan = new Scanner(System.in);
            System.out.println("Apakah saudara mau menjadi customer kami? (y/n) ");
            String choice = scan.nextLine();
            
            if(choice.equalsIgnoreCase("y")) {
                System.out.println("Isikan nama depan: ");
                String firstName = scan.nextLine();
                System.out.println("Isikan nama belakang: ");
                String lastName = scan.nextLine();
                System.out.println("Isikan tanggal lahir (yyyy-mm-dd): ");
                String dob = scan.nextLine();
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
                Date DOB = null;
                try {
                    DOB = dateFormat.parse(dob);
                    System.out.println("Isikan nomor telepon: ");
                    String phone = scan.nextLine();
                    
                    System.out.println("Isikan tipe akun yang saudara inginkan (S/O/I/L/T): ");
                    System.out.println("S = Saving\nO = Overdraft\nI = Investment\nL = Line of Credit Checking\nT = Tidak membuat");
                    char type = scan.next().charAt(0);
                    char acctType = Character.toUpperCase(type);
                    
                    if(acctType == 'T') {
                        System.out.println("Terima kasih saudara telah menggunakan JBank");
              
                    }
                    else if(acctType == 'S' || acctType == 'O' || acctType == 'I' || acctType == 'L') {
                        System.out.println("Isikan jumlah penyimpanan awal: ");
                        double balance = scan.nextDouble();
                        String year = "1995", month = "3", day = "23";
                        
                        Customer c1 = new Customer(firstName, lastName, (new GregorianCalendar(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day)).getTime()));
                        c1.setPhone(phone); 
                        Account a1 = new Account(acctType, balance);
                        
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
                        
                        Bank bank = new Bank();
                    
                        System.out.println("Informasi Akun");
                        System.out.println("Nama        : " + c1.getName());
                        System.out.println("ID Customer : " + c1.getCustID());
                        System.out.println("DOB         : " + c1.getDOB());
                        System.out.println("No Telepon  : " + c1.getPhone());
                        System.out.println("Tipe Akun   : " + a1.getAcctType());
                        System.out.println("Saldo       : " + a1.getBalance());
                        System.out.println(bank.getHoursOfOperation());
                    }
                    else {
                        System.out.println("Pilihan yang diinput salah. Isikan karakter S/O/I/L/T");
                    }
                } catch (ParseException e) {
                    System.out.println("Isian tanggal salah. Isikan dalam format yyyy-mm-dd");
                }
            }
            else if(choice.equalsIgnoreCase("n")) {
                System.out.println("Terima kasih saudara telah menggunakan JBank");
                System.exit(0);
            }
            else {
                System.out.println("Pilihan input salah. Pilih y atau n untuk melanjutkan program");
            }            
        } while(true);
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
    
    /**
     * Method Constructor Teller
     */
    public Teller()
    {
        
    }
    
}
