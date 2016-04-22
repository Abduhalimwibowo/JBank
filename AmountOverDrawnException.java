
/**
 * Write a description of class AmountOverDrawnException here.
 * 
 * @author Abdu Halim Wibowo
 * @version 16.04.20168
 */
public class AmountOverDrawnException extends java.lang.Exception
{
    // instance variables - replace the example below with your own
    private char acctType;
    public Account akun;
    public AmountOverDrawnException (Account akun){
        super ("Insufficient funds");
        this.akun=akun;
    }

    /**
     * Constructor for objects of class AmountOverDrawnException
     */
    /*/public AmountOverDrawnException(char acctType)
    {
        
        // initialise instance variables
    /}
    
    /**
     * Constructor for objects of class AmountOverDrawnException
     */
    /*public AmountOverDrawnException(char acctType, double balance, String id)
    {
        
        // initialise instance variables
        //x = 0;
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    /*public void AmountOverDrawnException(char acctType)
    {
        
        // put your code here
        //return x + y;
    }*/
    
    public String getMessage(){
        String messageOut="Error!!!";
        if(this.akun instanceof Savings && akun instanceof Investment==false){
            messageOut= "In savings Account";
        }
        else if (this.akun instanceof Investment && akun instanceof Investment== true){
            messageOut="In Investment Account";
        }
        else if (this.akun instanceof LineOfCredit){
            messageOut="In Line-Of-Credit Account";
        }
        else if (this.akun instanceof OverDraftProtection){
            messageOut="In Overdraft Protect Account";
        }
        return super.getMessage () + messageOut;
    }
}

