/**
 * Write a description of class AmountOverDrawnException here.
 * 
 * @author Abdu Halim Wibowo
 * @version 16.04.2016
 */

public class AccountTypeAlreadyExistException extends java.lang.Exception
{
    // instance variables - replace the example below with your own
    public Account akun;
    public AccountTypeAlreadyExistException (Account akun){
        super ("Unable to crate duplicate account of type ");
        this.akun=akun;
    }

    /**
     * Constructor for objects of class AccountTypeAlreadyExists
     */
    public String getMessage(){
        String messageOut= "Error!!!";
        if(this.akun instanceof Savings && akun instanceof Investment==false){
            messageOut= "Savings";
        }
        else if (this.akun instanceof Investment && akun instanceof Investment== true){
            messageOut="Investment";
        }
        else if (this.akun instanceof LineOfCredit){
            messageOut="Line-Of-Credit";
        }
        else if (this.akun instanceof OverDraftProtection){
            messageOut="Overdraft";
        }
        return super.getMessage () + messageOut;
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
