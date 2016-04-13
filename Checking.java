import java.lang.Math;
/**
 * Kelas abstrak Checking 
 * @author Abdu Halim Wibowo
 * @version 10 April 2016
 */

public abstract class Checking extends Account {
    protected double monthlyFee;
    
    /**
     * Metode abstrak feeAssessment yang digunakan untuk mengecek biaya Checking Account
     */
    protected abstract void feeAssessment();
    
    /**
     * Metode abstrak reseMonthlyFee yang digunakan untuk mengatur ulang biaya bulanan
     */
    public void resetMonthlyFee() {
        monthlyFee = 0;
    }
    
    /**
     * Metode yang digunakan untuk mendapatkan biaya Checking bulanan
     * @return monthlyfee sebagai biaya bulanan
     */
    public double getMonthlyFee() {
        return monthlyFee;
    }
}
