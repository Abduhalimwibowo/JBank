import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.*;
import java.util.*;

/**
 * Kelas CustomerFileReader yang berisi method dan variabel yang digunakan.
 * 
 * @author Abdu Halim Wibowo
 * @version 24.04.2016
 */
public class CustomerFileReader 
 {
    private FileInputStream fileInputStream;
    private ObjectInputStream objectInputStream;
    private File objectFile;
    private File fileObject;
    //private ObjectInputStream objectInputStream;

  public void readCustomer()
    {
        System.out.println("coba");
        try
        {
           System.out.println("coba2");
           FileInputStream fin = new FileInputStream("abdu.dat");
		   ObjectInputStream ois = new ObjectInputStream(fin);
		   System.out.println("akhir");
		   Object object = ois.readObject();
		   System.out.println("coba3");
		   System.out.println(object);
		   System.out.println("coba4");
        } 
        catch (ClassNotFoundException e) 
        {
            e.printStackTrace();
        } 
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        } 
        finally 
        {

        }   
    }

   /* public ArrayList<Customer> readCustomer()  throws IOException, ClassNotFoundException
   {
   ArrayList<Customer> custs = null;
        try {
            fileObject = new File("Abdubank.dat");
            fileInputStream = new FileInputStream(fileObject);
            objectInputStream = new ObjectInputStream(fileInputStream);
            custs = (ArrayList<Customer>) objectInputStream.readObject();
            objectInputStream.close();}
        catch (Exception e) {
            System.out.println("There is an Exception  :" + e.getMessage());
        }
        
        return custs;
        }
    }*/
}

