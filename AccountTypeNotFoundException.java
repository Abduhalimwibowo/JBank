
/**
 * Kelas Account Type Not Found Exception 
 * @author Abdu Halim Wibowo
 * @version 16 April 2016
 */
public class AccountTypeNotFoundException extends Exception
{
    private char accType;

    /**
     * Constructor untuk objek dari kelas AccountTypeNotfound
     */
    public AccountTypeNotFoundException(char acct)
    {
        super("Account does not exist ");
        accType = acct;
    }

     public String getMessage()
    {
        switch(accType){
            case 'S':
                return "Savings" + super.getMessage() ;
            case 'I':
                return "Investments" + super.getMessage();
            case 'O':
                return "OverDraft Protection" + super.getMessage();
            case 'L':
                return "Line of Credits" + super.getMessage();
            default:
                return "Wrong type of input";
            }           
    }
}
