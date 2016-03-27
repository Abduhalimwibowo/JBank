import java.math.BigDecimal;
import java.lang.Math;
import java.math.MathContext;
/**
 * Kelas Abstract Account berfungsi untuk membentuk object Account berisi method untuk mengolah data seperti ID
 * nilai Balance dari akun kemudian menarik atau menyimpan balance ke suatu akun. Kelas abstarct kali ini akan di extend menjadi bebrapa tipe account
 * @author Abdu Halim Wibowo
 * @version 27 maret 2016
 */
public abstract class Account
{
    //private char acctType;
    protected double balance;
    protected String ID;
    protected MathContext mc = new MathContext(3);

    /*
     * Method Constructor Account
     * @param type Tipe dari Akun
     * @param amount Jumlah Nilai Kas
    public Account(Customer cust, double amount, char type) {
        acctType = type;
        balance = amount;
        ID = cust.getCustID()+ "" + type;
    } */
    
    public String toString() {
        //System.out.println("Account Type  :   " + acctType);
        //if (this.getClass().equals())
        if ( this instanceof Savings && !(this instanceof Investment)) {
            System.out.println("SAVING");
        } else if ( this instanceof LineOfCredit) {
            LineOfCredit l = (LineOfCredit)this;
            System.out.println("Line-Of-Credit");
            System.out.println("    Credit Balance:   "+ l.getCreditBalance());
            System.out.println("    Monthly Fee   :   "+ l.getMonthlyFee());
        } else if ( this instanceof OverDraftProtect) {
            OverDraftProtect o = (OverDraftProtect)this;
            System.out.println("Overdraft Protection");
            System.out.println("    Monthly Fee   :   "+ o.getMonthlyFee());
        } else if ( this instanceof Investment) {
            System.out.println("Investment");
        }
        System.out.println("    Balance       :   " + balance);
        return "";
    }
    
    /**
     * Method deposit untuk mendeposit atau menambahkan sejumlah uang ke akun yang bersangkutan
     * @param amount Jumlah Nilai Kas
     */
    public boolean deposit(double amount) {
        if (amount < 0) {
            return false;
        } else {
            balance += amount;
            return true;
        }   
    }
    
    /*
     * Method getAcctType Mendapatkan tipe akun
     * @return Nama tipe akun

    public char getAcctType() {
        return acctType;
    }*/
    
    /*
     * Method getBalance Mendapatkan nilai saldo
     * @return Jumlah uang/balance yang dimiliki sebuah akun
    public double getBalance() {
        return balance;
    }*/
    
    /**
     * Method getId Mendapatkan nomor
     * @return ID dari akun yang bersangkutan
     */
    public String getID() {
        return ID;
    }
    
    /**
     * Method setBalance Menentukan jumlah uang/balance pada suatu akun 
     * @param amount Jumlah Nilai Kas yang akan 
     */
    public void setBalance(double amount) {
        balance = amount;
    }
    
    /**
     * Method getBalance Menunjukk jumlah saldo pada suatu akun 
     */
    public double getBalance() {
        return balance;
    }
    
    /**
     * Method futureValue Menghitung jumlah saldo setelah dibungakan sesuai dengan Compounded Interest Rate Formula 
     * @param balance Saldo awal
     * @param rate Suku bunga
     * @param compound Perhitungan penambahan bunga per satuan waktu
     * @param period Periode satuan waktu
     */
    protected static double futureValue(double balance, double rate, double compound, double period) {
        MathContext mc = new MathContext(3);
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
    
    /*
     * Method setID Menentukan nama ID dari sebuah akun
     * @param acctID Nama ID Account
    public void setID(String acctId) {
        ID = acctId;
    }*/
    
    /*
     * Method setAcctType Menentukan tipe akun
     * @param type Tipe Akun pelanggan

    public void setAcctType(char type) {
        acctType = type;
    }*/
    
    /**
     * Method withdraw Mengambil sejumlah uang dari suatu akun 
     * @param amount Jumlah Nilai Kas
     */
    public abstract boolean withdraw(double amount); /*{
        if (balance-amount < 0) {
            return false;
        } else {
            balance -= amount;
            return true;
        }
    }*/
   
}
