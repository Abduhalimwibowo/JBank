/**
 * Kelas ini akan menghasilkan Object Account yang memodelkan 
 * akun bank
 * @author Abdu Halim Wibowo
 * @version 19 maret 2016
 */
public class Account
{
    private char acctType;
    private double balance;
    private String ID;
    
    /**
     * Metode Constructor Account
     * @param customer kostumer bank 
     * @param amount jumlah uang dalam akun
     * @param type tipe akun
     */
    public Account(Customer cust, double amount, char type)
    {
        this.balance = amount;
        this.acctType = type;
        this.ID = Integer.toString(cust.getCustID()) + Character.toString(type);
    }
    
    /**
     * Metode untuk melakukan deposit
     * @param amount jumlah uang yang akan disimpan
     */
    public boolean deposit(double amount)
    {
        if(amount < 0) {
            return false;
        }
        else {
            balance += amount;
            return true;
        }
    }
    
    /**
     * Metode accessor untuk mendapatkan tipe akun
     * @return tipe akun
     */
    public char getAcctType()
    {
        return acctType;
    }
    
    /**
     * Metode accessor untuk mendapatkan jumlah uang dalam akun
     * @return jumlah uang
     */
    public double getBalance()
    {
        return balance;
    }
    
    /**
     * Metode accessor untuk mendapatkan ID akun
     * @return ID
     */
    public String getId()
    {
        return ID;
    }
    
    /**
     * Metode mutator untuk mengeset jumlah uang kedalam akun
     * @param amount jumlah uang
     */
    public void setBalance(double amount)
    {
        this.balance = amount;
    }
    
    /**
     * Metode mutator untuk mengeset tipe akun
     * @param type tipe akun
     */
    public void setAcctType(char type)
    {
        this.acctType = type;
    }
    
    /**
     * Metode untuk melakukan pengambilan uang
     * @param amount jumlah uang yang akan diambil
     */
    public boolean withdraw(double amount)
    {
        if(balance-amount < 0) {
            return false;
        }
        else {
            balance -= amount;
            return true;
        }
    }
}
