/**
 * Kelas Abstrak Checking merupakan extended kelas dari Account. Kelas ini memeriksa apabila
 * Customer ingin menarik saldo melebihi dari jumlah saldo yang disimpan di Saving Account
 * @author Abdu Halim Wibowo
 * @version 27 maret 2016
 */
public abstract class Checking extends Account {
    protected double monthlyFee;
    /**
     * Metode abstrak untuk mengecek biaya Checking Account
     */
    protected abstract void feeAssessment();
    
    /**
     * Metode abstrak untuk mengecek biaya Checking Account
     */
    public void resetMonthlyFee() {
        monthlyFee = 0;
    }
    
    public double getMonthlyFee() {
        return monthlyFee;
    }
}
