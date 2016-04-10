import java.text.*;
import java.util.*;
import java.io.*;
import java.time.*;
import java.math.*;
import java.lang.Math;

/**
 * Abstract class Checking digunakan untuk menghitung biaya yang akan ditambahkan perbulan.
 * @author Abdu Halim Wibowo
 * @version 2016.04.10
 */
public abstract class Checking extends Account
{
    protected double monthlyFee;
   
    /**
     * method abstract yang digunakan untuk mengecek biaya Account
     */
    protected abstract void feeAssessment();
    
    /**
     * method yang digunakan untuk me-reset biaya bulanan
     */
    public void resetMonthlyFee()
    {
        monthlyFee = 0;
    }
    
    /**
     * method yang digunakan untuk mendapatkan biaya perbulan
     */
    public double getMonthlyFee()
    {
        return monthlyFee;
    }
}
