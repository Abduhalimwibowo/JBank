import java.io.*;
import java.util.*;

/**
 * Kelas CustomerFileReader yang berisi method dan variabel yang digunakan.
 * 
 * @author Abdu Halim Wibowo
 * @version 24.04.2016
 */
public class CustomerFileReader implements Serializable {
    private File fileObject;
    private FileInputStream fileInputStream;
    private ObjectInputStream objectInputStream;

    /**
     * Konstruktor kosong kelas CustomerFileReader
     */
   public CustomerFileReader()
   {
       
   }

    public ArrayList<Customer> readCustomer()  throws IOException, ClassNotFoundException
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
    }


