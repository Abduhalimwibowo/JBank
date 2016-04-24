
/**
 * Kelas AccountTypeNotFoundException berisi method dan variabel yang digunakan.
 * 
 * @author Abdu Halim Wibowo
 * @version 20.04.2016
 */
public class AccountTypeNotFoundException extends Exception
{
    public char acctType;
    public String message;
    private Account accountType;

    public AccountTypeNotFoundException(char acct)
    {
        super("Account not found");
        acctType = acct;
    }

    /**
     * Constructor for objects of class AccountTypeNotFoundException
     */
    public String getMessage()
    {
        switch (acctType)
        {
            case 'S':
            {
                message = "Savings";
                return message+super.getMessage();
            }
            case 'I':
            {
                message = " Investment ";
                return message+super.getMessage();
            }
            case 'L':
            {
                message = " LineOfCredit ";
                return message+super.getMessage();
            }
            case 'O':
            {
                message = " OverDraftProtection ";
                return message+super.getMessage();
            }
            default :
            {
                message = "Try Another Account";
                return message;
            }
        }
    }
    
    /*/**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    /*public void AccountTypeAlreadyExists(char acctType)
    {
        // put your code here
        //return x + y;
    }*/
}
