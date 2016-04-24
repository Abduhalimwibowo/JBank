
/**
 * Write a description of class AmountOverDrawnException here.
 * 
 * @author Abdu Halim Wibowo
 * @version 20.04.2016
 */
public class AccountTypeAlreadyExistsException extends Exception
{
    public char acctType;
    private Account accountType;
    
    /**
     * Constructor for objects of class AccountTypeAlreadyExistsException
     */
    public AccountTypeAlreadyExistsException(char acctType)
    {
        super("Cannot duplicate the account");
        this.acctType = acctType;
    }

    /**
     * method sambungan pesan dari main method
     */
    public String getMessage()
    {
       if (accountType instanceof Savings && !(accountType instanceof Investment) ){
            return super.getMessage() + "Savings";
        } else if (accountType instanceof Investment){
            return super.getMessage() + "Investments";
        } else if (accountType instanceof OverDraftProtection){
            return super.getMessage() + "OverDraft Protection";
        } else if (accountType instanceof LineOfCredit){
            return super.getMessage() + "Line of Credit";
        } else {
            return "Account Type Did not Found !";
        }        
    }
}
