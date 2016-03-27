
/**
 * Kelas Saving merupakan extended kelas dari Account. Kelas ini merupakan berfungsi sebagai
 * akun penyimpanan standar.
 * @author Abdu Halim Wibowo
 * @version 27 maret 2016
 */
public class Savings extends Account
{
    // instance variables - replace the example below with your own
    protected double interestEarned;

    /**
     * Method Constructor dari Savings
     * @param cust Obyek Customer sebagai referensi
     * @param amount Balance yang ingin dimasukkan
     * @return True or False
     */
    public Savings(Customer cust, double amount){
        super();
        ID = Integer.toString(cust.getCustID());
        super.balance = amount;
    }
    
    /**
     * Method withdraw Mengambil sejumlah uang dari suatu akun 
     * @param amount Jumlah Nilai Kas
     */
    public boolean withdraw(double amount) {
        if (balance - amount >= 10) {
            balance -= amount;
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * Method addDailyInterest Menghitung bunga yang didapat sesuai banyaknya hari 
     * @param numberOfDays Banyaknya hari
     */
    public void addDailyInterest(int numOfDays) {
        double A, period;
        period = (double)numOfDays / 365;
        A = futureValue(balance, 0.03, 360, period);
        interestEarned = A - balance;
        balance = A;
    }
    
    public double getInterestEarned() {
        return interestEarned;
    }
}
