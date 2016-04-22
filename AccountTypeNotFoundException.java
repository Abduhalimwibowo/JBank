
/**
 * Write a description of class AccountTypeAlreadyExists here.
 * 
 * @author Abdu Halim Wibowo
 * @version 16.04.2016
 */
public class AccountTypeNotFoundException extends java.lang.Exception
{
    // instance variables - replace the example below with your own
    public char akun;
    public AccountTypeNotFoundException (char akun){
        super ("Account does not exit");
        this.akun=akun;
    }

    /**
     * Constructor for objects of class AccountTypeAlreadyExists
     */
    public String getMessage(){
 
        String messageOut= "Error!!!";
        if(this.akun=='S'){
            messageOut= "Savings";
        }
        else if (this.akun=='I'){
            messageOut="Investment";
        }
        else if (this.akun=='L'){
            messageOut="Line-Of-Credit";
        }
        else if (this.akun=='O'){
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
