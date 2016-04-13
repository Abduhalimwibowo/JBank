
/**
 * Kelas OverDraftProtection 
 * @author Abdu Halim Wibowo
 * @version 10 April 2016
 */
public class OverDraftProtection extends Checking
{
    private Savings savingsAccount;

    /**
     * Constructor dari OverDraftProtect dengan beberapa parameter :
     * @param cust Obyek Customer yang bersangkutan
     * @param amount Jumlah saldo yang ingin dimasukkan
     * @param save Obyek Savings Account sebagai acuan
     */
    public OverDraftProtection(Customer cust, double amount, Savings save) {
        super();
        id = Integer.toString(cust.getCustID());
        balance = amount;
        savingsAccount = save;
    }
    
    /**
     * Method feeAssessment untuk perhitungan biaya proteksi Overdraft
     */
    public void feeAssessment () {
        monthlyFee += 3;
        balance -= 3;
    }
    
    /**
     * Method withdraw untuk menarik sejumlah Saldo dari akun Overdraft
     * @param amount sebagai jumlah Saldo
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
