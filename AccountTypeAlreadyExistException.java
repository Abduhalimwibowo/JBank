
/**
 * Kelas Account Type Exist Exception 
 * @author Abdu Halim Wibowo
 * @version 16 April 2016
 */
public class AccountTypeAlreadyExistException extends Exception
{
    private Account accountType;

    /**
     * Constructor untuk objek dari kelas AccountTypeAlreadyExistException
     */
    public AccountTypeAlreadyExistException(Account acct)
    {
        super("Unable to create a duplicate account of type ");
        accountType = acct;
    }

    
    public String getMessage()
    {
        if (accountType instanceof Savings && !(accountType instanceof Investment) ){
            return super.getMessage() + "Savings";
        } else if (accountType instanceof Investment){
            return super.getMessage() + "Investments";
        } else if (accountType instanceof OverDraftProtect){
            return super.getMessage() + "OverDraft Protection";
        } else if (accountType instanceof LineOfCredit){
            return super.getMessage() + "Line of Credit";
        } else {
            return "No account";
        }        
    }
}
