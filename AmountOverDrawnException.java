
/**
 * Kelas AmountOverDrawnexception
 * @author Abdu Halim Wibowo
 * @version 16 April 2016
 */
public class AmountOverDrawnException extends Exception
{
    private int x;
    private Account accountType;
    /**
     * Constructor untuk objek dari kelas AmountOverDrawnException
     */
    public AmountOverDrawnException(Account acct)
    {
        super("Insufficient Funds ");
        accountType = acct;
    }

    public String getMessage()
    {
        if (accountType instanceof Savings && !(accountType instanceof Investment) ){
            return super.getMessage() + "in Savings Account";
        } else if (accountType instanceof Investment){
            return super.getMessage() + "in Investments Account";
        } else if (accountType instanceof OverDraftProtect){
            return super.getMessage() + "in OverDraft Protection Account";
        } else if (accountType instanceof LineOfCredit){
            return super.getMessage() + "in LineOfCredit Account";
        } else {
            return "No account";
        }
    }
}
