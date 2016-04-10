

/**
 * Kelas untuk membuat Account Overdraft
 * @author Abdu Halim Wibowo
 * @version 2016.04.10
 */
public class OverDraftProtect extends Checking
{
    private Savings savingsAccount;
    /**
     * Constructor for objects of class OverDraftProtection
     * @param cust customer yang memiliki account
     * @param amount jumlah saldo 
     * @param saveingsAccount account akan dimasukkan ke savings account
     */
    public OverDraftProtect(Customer cust, double amount, Savings savingsAccount)
    {
        super();
        id = Double.toString(cust.getCustID());
        balance = amount;
       savingsAccount = savingsAccount;
    }
    
    /**
     * Method feeAssessment Perhitungan biaya proteksi Overdraft
     */
     public void feeAssessment()
     {
        
        monthlyFee = monthlyFee -3;
        balance = balance - 3;
    }

     
    /**
     * Method withdraw Menarik sejumlah Saldo dari Overdraft Account
     * @param amount Jumlah Saldo
     */
    public boolean withdraw (double amount) {
        if (( balance + savingsAccount.getBalance() ) - amount > 10) {
            if (amount > balance ) {
                balance = balance - amount;
            } else {
                balance = 0;
                savingsAccount.withdraw(amount - balance);
                feeAssessment();
            }
            return true;
        } else {
            return false;
        }
        
    }
    
}
