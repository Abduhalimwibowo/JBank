
/**
 * Write a description of class OverDraftProtection here.
 * 
 * @author Abdu Halim Wibowo
 * @version 16.04.2016
 */
public class OverDraftProtection extends Checking
{
    private Savings savingsAccount;

    /**
    * konstruktor dari kelas OverDraftProtection
    * 
    * @param cust akun kustomer
    * @param amount jumlah yang akan di set
    * @param saving akun saving
    */
    public OverDraftProtection(Customer cust, double amount, Savings save) {
        super();
        id = Integer.toString(cust.getCustID());
        balance = amount;
        savingsAccount = save;
    }
    
    /**
    * method untuk menambah fee dengan tiga jika penarikan berhasil
    */
    public void feeAssessment () {
        monthlyFee += 3;
        balance -= 3;
    }
    
    /**
    * Method penarikan overdraft
    * 
    * @param amount jumlah yang akan ditarik
    */
    public boolean withdraw (double amount) {
        if ( ( balance + savingsAccount.getBalance() ) - amount >= 10) {
            if (balance >= amount) {
                balance -= amount;
            } else {
                savingsAccount.withdraw(amount - balance);
                balance = 0;
                feeAssessment();
            }
            return true;
        } else {
            return false;
        }
    }
}
