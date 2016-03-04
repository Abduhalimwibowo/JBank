/**
 * @author Abdu Halim Wibowo 1306447392
 * @modul3
 */
public class Account
{
    private char acctType;
	private double balance;
	private String id;
	
	/**
	 * Method untuk mengubah data akun
	 */
	public Account()
	{
		acctType = 'S';
        balance = 10.00;
	}
	
	/**
	 * mengubah data akun
	 * @param tipe akun 
	 * @param jumlah uang akun
	 */
	public Account(char type, double amount)
	{
		acctType = type;
		balance = amount; 
	}
	
	/**
     * Method untuk melakukan deposit
     * @param amount jumlah uang disimpan
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
	 * Metodemendapatkan tipe akun
	 * @return type akun
	 */
	public char getAcctType()
	{
		return acctType;
	}
	
	/**
	 * mendapatkan jumlah uang dalam akun
	 * @return balance
	 */
	public double getBalance()
	{
		return balance;
	}
	
	/**
	 * mendapatkan ID akun
	 * @return id
	 */
	public String getId()
	{ 
	   return id;
	}
	
	/**
	 * menset jumlah uang kedalam akun
	 * @param amount
	 */
	public void setBalance(double amount)
	{
		balance = amount;
	}
	
	/**
	 * metode menset no ID pada akun
	 * @param id dan acctId
	 */
	public void setID(String acctId)
	{
		id = acctId;
	}
	
	/**
	 * Metode untuk menset tipe akun
	 * @param tipe akun
	 */
	public void setAcctType(char type)
	{
		acctType = type;
	}
	
	/**
     * Method untuk melakukan penarikan uang
     * @param amount jumlah uang diambil
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
