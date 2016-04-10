
/**
 * Kelas untuk membuat Account Overdraft
 * @author Abdu Halim Wibowo
 * @version 2016.04.10
 */
public class OverdraftProtect extends Checking
{
    private Savings savingsAccount;

    /**
     * Constructor for objects of class OverdraftProtect
     * @param customer adalah customer yang memiliki account
     * @param amount adalah jumlah saldo 
     * @param savingsAccount adalah account yang akan dimasukkan ke savings account
     */
    public OverdraftProtect(Customer customer, double amount, Savings savingsAccount)
    {
       super();
       id = Double.toString(customer.getCustomerId());
       balance = amount;
       savingsAccount = savingsAccount;
    }

     /**
     * method yang digunakan untuk perhitungan biaya proteksi Overdraft
     */
     public void feeAssessment()
    {
        monthlyFee = monthlyFee - 3;
        balance = balance - 3;
    }

    /**
     * method withdraw untuk menarik sejumlah saldo dari Overdraft Account
     * @param amount adalah jumlah saldo
     */
    public boolean withdraw(double amount) 
    {
        if (( balance + savingsAccount.getBalance()) - amount > 10) 
        {
            if (amount > balance ) 
            {
                balance = balance - amount;
            } 
            else 
            {
                balance = 0;
                savingsAccount.withdraw(amount - balance);
                feeAssessment();
            }
            return true;
        } 
        else 
        {
            return false;
        }
        
    }
}
