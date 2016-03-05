import java.util.Scanner;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.lang.Character;
/**
 *@author Abdu Halim Wibowo 1306447392
 *@version Modul3
 */
public class Teller
{
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
                Date DOB = null;
                try {
                    DOB = new SimpleDateFormat("yyyy-mm-dd").parse(dob);
                    System.out.println("Isikan nomor telepon: ");
                    String phone = scan.nextLine();
                    
                    System.out.println("Isikan tipe akun yang saudara inginkan (S/O/I/L/T): ");
                    System.out.println("S = Saving\nO = Overdraft\nI = Investment\nL = Line of Credit Checking\nT = Tidak membuat");
                    char type = scan.next().charAt(0);
                    char acctType = Character.toUpperCase(type);
                    
                    if(acctType == 'T') {
                        System.out.println("Terima kasih saudara telah menggunakan JBank");
                        System.exit(0);
                    }
                    else if(acctType == 'S' || acctType == 'O' || acctType == 'I' || acctType == 'L') {
                        System.out.println("Isikan jumlah penyimpanan awal: ");
                        double balance = scan.nextDouble();
                        
                        Customer c1 = new Customer(firstName, lastName, DOB);
                        c1.setPhone(phone);
                        Account a1 = new Account(acctType, balance);
                    
                        System.out.println("Informasi Akun");
                        System.out.println("Nama        : " + c1.getName());
                        System.out.println("ID Customer : " + c1.getCustID());
                        System.out.println("No Telepon  : " + c1.getPhone());
                        System.out.println("Tipe Akun   : " + a1.getAcctType());
                        System.out.println("Saldo       : " + a1.getBalance());
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
    
    /**
     * Method Constructor Teller
     */
    public Teller()
    {
        
    }
}
