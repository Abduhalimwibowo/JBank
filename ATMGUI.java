import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.*;
import java.awt.*;

/**
 * kelas ATMGUI yang menjadi antarmuka bagi pengguna.
 * @author Abdu Halim Wibowo
 * @version 10 April 2016
 */

public class ATMGUI extends JFrame
{
     public JLabel amountLabel;
    public JLabel customerLabel;
    public JRadioButton SavingacctType;
    public JRadioButton InvestmentacctType;
    public JRadioButton LineOfCreditacctType;
    public JRadioButton OverdraftacctType;
    public JButton deposit;
    public JButton withdraw;
    public JTextField customerText;
    public JTextField amountText;
    public JTextArea textAreaMain;
    public JButton exit;
    public ButtonGroup radioGroup;

    /**
     * Constructor bagi objek pada kelas ATMGUI
     */
    
    public ATMGUI ()
    {
        super("ATMGUI"); 
        buildGUI();
        setVisible(true);
    }
    
    public void buildGUI()
    {
        Container contentPane= getContentPane();
        
        JFrame mainframe    = new JFrame ("ATMGUI");
        mainframe.setSize(500,300);
        mainframe.setLayout (new BoxLayout (mainframe, BoxLayout.Y_AXIS));        
        
        JPanel buttonPanel= new JPanel();
        buttonPanel.setLayout (new BoxLayout (buttonPanel, BoxLayout.Y_AXIS));
        JPanel checkboxPanel= new JPanel();
        checkboxPanel.setLayout(new FlowLayout());
        JPanel infoPanel= new JPanel();
        infoPanel.setLayout(new FlowLayout ());
         JPanel textPanel= new JPanel ();
        textPanel.setLayout(new FlowLayout());
        JPanel mainPanel= new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        
        customerLabel   = new JLabel ("Enter Customer ID :");
        amountLabel     = new JLabel ("Enter amount :");
        
        SavingacctType      = new JRadioButton ("Savings");
        InvestmentacctType  = new JRadioButton ("Investment");
        LineOfCreditacctType= new JRadioButton ("Line Of Credit");
        OverdraftacctType   = new JRadioButton ("Overdraft");
        
        deposit     =new JButton("Deposit");
        withdraw    =new JButton("Withdraw");
        exit        =new JButton("Exit");
        
        customerText    = new JTextField(20);
        amountText      = new JTextField(20);
        textAreaMain    = new JTextArea(20,40);
        
        buttonPanel.add(deposit, BorderLayout.PAGE_START);
        buttonPanel.add(withdraw, BorderLayout.CENTER);
        buttonPanel.add(exit, BorderLayout.PAGE_END);
        
        checkboxPanel.add(SavingacctType);
        checkboxPanel.add(InvestmentacctType);
        checkboxPanel.add(LineOfCreditacctType);
        checkboxPanel.add(OverdraftacctType);
        
       infoPanel.add(customerLabel);
       infoPanel.add(customerText);
       infoPanel.add(checkboxPanel);
       infoPanel.add(amountLabel);
       infoPanel.add(amountText);
       
       textPanel.add(textAreaMain);
       textPanel.add(buttonPanel);
       
       this.add(infoPanel);
       this.add(textPanel);
       
        contentPane.add(mainPanel);
        pack();
       deposit.addActionListener(new ButtonHandler(this));
       withdraw.addActionListener(new ButtonHandler(this));
       addWindowListener(new WindowHandler());
        
    }
    
     /**
     * Method getTextArea digunakan untuk mengembalikan isi teks pada GUI
     * 
     * @return ID sebagai ID dari customer
     */
    public String getTextArea(){
        return textAreaMain.getText();
    }
    
    /**
     * Method getIDcust digunakan untuk mengembalikan ID Customer pada GUI
     * 
     * @return ID kustomer
     */
    public int getIDcust(){
        return Integer.parseInt(customerText.getText());
    }
    
     /**
     * Method getNominal digunakan untuk mendapatkan nominal uang yang ditulis customer dalam GUI
     * 
     * @return Nominal sebagai jumlah uang yang ditulis
     */
    public double getNominal(){
        return Double.parseDouble(amountText.getText());
    }
   
    
    /**
     * Method setTextArea digunakan untuk memasukan teks ke dalam area pada GUI
     * 
     * @param Text  sebagai input yang akan ditulis dalam TextArea di GUI
     */
    public void setTextArea(String input){
        textAreaMain.setText(input);
    }
    
}