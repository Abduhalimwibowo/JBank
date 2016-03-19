/**
 * @author Abdu Halim Wibowo 
 * @version 19 Maret 2016
 */
public class Account
{
    private char acctType;
    private double balance;
    private String ID;
    
    /**
     * Method Constructor Account
     * @param type Tipe dari Akun
     * @param amount Jumlah Nilai Kas
     */
    public Account(Customer cust, double amount, char type) {
        acctType = type;
        balance = amount;
        ID = cust.getCustID()+ "" + type;
    }
    
    public String toString() {
        System.out.println("Account Type  :   " + acctType);
        System.out.println("ID            :   " + ID);
        System.out.println("Balance       :   " + balance);
        return "";
    }
    
    /**
     * Method deposit 
     * @param amount Jumlah Kas
     */
    public boolean deposit(double amount) {
        if (amount < 0) {
            return false;
        } else {
            balance += amount;
            return true;
        }   
    }
    
    /**
     * Method getAcctType 
     * @return Nama tipe akun
     */
    public char getAcctType() {
        return acctType;
    }
    
    /**
     * Method getBalance 
     * @return Jumlah uang/balance 
     */
    public double getBalance() {
        return balance;
    }
    
    /**
     * Method getId 
     * @return ID dari akun 
     */
    public String getID() {
        return ID;
    }
    
    /**
     * Method setBalance 
     * @param amount Jumlah Kas 
     */
    public void setBalance(double amount) {
        balance = amount;
    }
    
    /**
     * Method setID Menentukan nama ID dari sebuah akun
     * @param acctID Nama ID Account
     */
    /*
    public void setID(String acctId) {
        ID = acctId;
    }*/
    
    /**
     * Method setAcctType 
     * @param type Akun pelanggan
     */
    public void setAcctType(char type) {
        acctType = type;
    }
    
    /**
     * Method withdraw 
     * @param amount Jumlah Kas
     */
    public boolean withdraw(double amount) {
        if (balance-amount < 0) {
            return false;
        } else {
            balance -= amount;
            return true;
        }
    }
   
}
