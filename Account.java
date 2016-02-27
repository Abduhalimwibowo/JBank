/**
 * Punya Abdu Halim Wibowo 1306447392
 * Modul1
 */
public class Account
{
    private char acctType;
	private double balance;
	private String id;
	
	/**
	 * Metode untuk mengubah data akun
	 */
	public Account()
	{
		
	}
	
	/**
	 * mengubah data akun
	 * @param type tipe akun amount jumlah uang dalam akun
	 */
	public Account(char type, double amount)
	{
		
	}
	
	/**
	 * melakukan deposit
	 * @param amount jumlah uang yang akan disimpan
	 */
	private void deposit(double amount)
	{
		
	}
	
	/**
	 * Metodemendapatkan tipe akun
	 */
	public char getAcctType()
	{
		return acctType;
	}
	
	/**
	 * mendapatkan jumlah uang dalam akun
	 */
	public double getBalance()
	{
		return balance;
	}
	
	/**
	 * mendapatkan ID akun
	 */
	public String getId()
	{ 
	   return id;
	}
	
	/**
	 * menset jumlah uang kedalam akun
	 */
	public void setBalance(double amount)
	{
		balance = amount;
	}
	
	/**
	 * menset no ID pada akun
	 */
	public void setID(String acctId)
	{
		id = acctId;
	}
	
	/**
	 * Metode untuk menset tipe akun
	 */
	public void setAcctType(char type)
	{
		acctType = type;
	}
	
	/**
	 * melakukan pengambilan uang
	 */
	public void withdraw(double amount)
	{
		
	}
}
