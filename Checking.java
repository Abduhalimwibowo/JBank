import java.text.*;
import java.util.*;
import java.io.*;
import java.time.*;
import java.lang.Math;
import java.math.*;

/**
 * Kelas abstract Checking
 * @author Abdu Halim Wibowo
 * @version 2016.04.10
 */
public abstract class Checking extends Account
{
     protected double monthlyFee;
   
    /**
     * Method abstract untuk pengecekan biaya Account
     */
    protected abstract void feeAssessment();
    
 /**
  * method ini digunakan untuk menghapus jumlah monthlyFee.
  * 
  */
    public void resetMonthlyFee(){
        
        monthlyFee = 0;
    }
    
    /**
     * method ini digunakan untuk mengambil banyaknya fee perbulan pada JBank.
     * 
     */
    public double getMonthlyFee()
    {
        return monthlyFee;
    }
    
    
   
}
