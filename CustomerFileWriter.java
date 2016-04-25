import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.*;

/**
 * Kelas CustomerFileWriter yang berisi method dan variabel yang digunakan.
 * 
 * @author Abdu Halim Wibowo
 * @version 24.04.2016
 */
public class CustomerFileWriter implements Serializable 
   {
    private File fileObject;
    private static FileOutputStream fileOutputStream;
    private static ObjectOutputStream objectOutputStream;
    
    /**
     * Konstruktor kosong kelas CustomerFileWriter
     */
    public CustomerFileWriter() 
    {
        
    }
    

    /**
     * method saveCustomer untuk menyimpan data yang sudah ditulis
     */
    public void saveCustomers(ArrayList<Customer> custs) 
    {
        try {
            fileObject.createNewFile();
            fileOutputStream = new FileOutputStream("abdu.ser");
            BufferedOutputStream buffer = new BufferedOutputStream(fileOutputStream);
            objectOutputStream.writeObject(custs);
            }
        catch (FileNotFoundException e) {
            System.out.println("There is an Exception  :" + e.getMessage());
            } 
        catch (IOException e) 
        {
        }finally 
        {
            
        }    
   
  }
 }


