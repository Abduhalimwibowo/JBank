/**
 * Kelas untuk membuat Account Overdraft
 * @author Abdu Halim Wibowo
 * @version 16 April 2016
 */
public class OverDraftProtect extends Checking {
    private Savings savingsAccount;

    /**
     * Constructor for objects of class OverdraftProtect
     * @param customer adalah customer yang memiliki account
     * @param amount adalah jumlah saldo 
     * @param savingsAccount adalah account yang akan dimasukkan ke savings account
     */
    public OverDraftProtect(Customer cust, double amount, Savings save) {
        super();
        ID = Integer.toString(cust.getCustID());
        balance = amount;
        savingsAccount = save;
    }
    
    /**
     * Method yang digunakan untuk perhitungan biaya proteksi Overdraft
     */
    public void feeAssessment () {
        monthlyFee += 3;
        balance -= 3;
    }
    
    /**
     * Method withdraw untuk Menarik sejumlah Saldo dari Akun Overdraft 
     * @param amount adalah Jumlah Saldo
     */
    public boolean withdraw (double amount) throws AmountOverDrawnException{
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
            throw new AmountOverDrawnException(this);
        }
    }
}
