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
    private FileOutputStream fileOutputStream;
    private ObjectOutputStream objectOutputStream;
    
    /**
     * Konstruktor kosong kelas CustomerFileWriter
     */
    public CustomerFileWriter() 
    {
        
    }
    

    /**
     * Method untuk menyimpan customer dlam arraylist
     */
    public void saveCustomers(ArrayList<Customer> custs) throws IOException
    {
        try {
            fileObject = new File("Abdu.dat");
            fileObject.createNewFile();
            fileOutputStream = new FileOutputStream(fileObject);
            BufferedOutputStream buffer = new BufferedOutputStream(fileOutputStream);
            objectOutputStream = new ObjectOutputStream(buffer);
            try{
                objectOutputStream.writeObject(custs);
            }
            finally{
                objectOutputStream.close();
            }

            }
        catch (Exception e) {
            System.out.println("There is an Exception  :" + e.getMessage());
    }
  }
}

