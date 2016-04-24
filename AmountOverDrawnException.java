
/**
 * Kelas AmountOverDrawnException berisi method dan variabel yang digunakan.
 * 
 * @author Abdu Halim Wibowo
 * @version 21.04.20168
 */
public class AmountOverDrawnException extends Exception
{
    public Account acctType;

    public AmountOverDrawnException(Account acct)
    {
        super("Insufficeients Fund");
        acctType = acct;
    }

    /**
     * method override sambungan pesan dari main method
     */
    @Override
    public String getMessage()
    {
        if (acctType instanceof Savings && !(acctType instanceof Investment) ){
            return super.getMessage() + "in Account Savings";
        } else if (acctType instanceof Investment){
            return super.getMessage() + "in Account Investments";
        } else if (acctType instanceof OverDraftProtection){
            return super.getMessage() + "in Account OverDraft Protection";
        } else if (acctType instanceof LineOfCredit){
            return super.getMessage() + "in Account LineOfCredit";
        } else {
            return "Another Account ";
        }
    }
}