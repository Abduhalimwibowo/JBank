import java.lang.Math;
/**
 * Abstract class Checking - 
 * 
 * @author Abdu Halim Wibowo
 * @version 16.04.2016
 */

public abstract class Checking extends Account {
    protected double monthlyFee;
    
     /**
     * method abstract yang digunakan untuk mengecek biaya Account
     */
    protected abstract void feeAssessment();
    
    /**
     * method untuk mereset biaya bulanan
     */
    public void resetMonthlyFee() {
        monthlyFee = 0;
    }
    
    /**
     * method untuk mengembalikan biaya bulanan
     * 
     * @return biaya bulanan
     */
    public double getMonthlyFee() {
        return monthlyFee;
    }
}
