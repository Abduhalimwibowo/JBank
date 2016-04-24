import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.*;
import java.awt.*;

/**
 * Kelas yang merepresentaskan GUI Merupakan child dari JFrame
 * 
 * @author Abdu Halim Wibowo
 * @version 16.04.2016
 */

public class ATMGUI extends JPanel
{
   private JFrame Frame;
   private JTextField custIdText, amountText;
   public JTextArea text;
   private JLabel custIdLabel, amountLabel;
   private JButton buttonDeposit ;
   private JButton buttonWithdraw ;
   private JButton buttonExit ;
   private JRadioButton savings ;
   private JRadioButton investment ;
   private JRadioButton lineofcredit ;
   private JRadioButton overdraft ;
   private ButtonGroup buttonGroup;

    /**
     * Constructor bagi objek pada kelas ATMGUI
     */
     public ATMGUI()
   {
       BuildGUI();
   }
    
    /**
     * Method untuk membangun GUI 
     */
    private void BuildGUI(){
       Frame = new JFrame("ATMGUI");
       Frame.setSize(650,350);
       
        Frame.addWindowListener(new WindowHandler() 
        {
         public void windowClosing(WindowHandler WindowEvent){
            System.exit(0);
         }        
      });
      Frame.setVisible(true);
    }
 
    
     public void showATM(){
       JPanel thePanel = new JPanel();
       thePanel.setLayout(new BoxLayout(thePanel, BoxLayout.Y_AXIS));
       
       custIdLabel = new JLabel("Enter Customer ID :");
       custIdText = new JTextField(7);
       amountLabel = new JLabel("Enter Amount here:");
       amountText = new JTextField(7);
       savings = new JRadioButton("Savings");
       investment = new JRadioButton("Investment");
       lineofcredit = new JRadioButton("Line Of Credit");
       overdraft = new JRadioButton("Overdraft");
       JPanel panelType = new JPanel();
       panelType.setLayout(new BoxLayout(panelType, BoxLayout.Y_AXIS));
       ButtonGroup buttonGroup = new ButtonGroup();
       buttonGroup.add(savings);
       buttonGroup.add(investment);
       buttonGroup.add(lineofcredit);
       buttonGroup.add(overdraft);
       savings.setSelected(true);
       
       panelType.add(savings);
       panelType.add(investment);
       panelType.add(lineofcredit);
       panelType.add(overdraft);
       
       JPanel infoPanel = new JPanel();
       infoPanel.setPreferredSize(new Dimension(600, 150));
       infoPanel.setBorder(BorderFactory.createTitledBorder("Information Account :"));
       
       infoPanel.add(custIdLabel);
       infoPanel.add(custIdText);
       infoPanel.add(panelType);
       infoPanel.add(amountLabel);
       infoPanel.add(amountText);
       
       thePanel.add(infoPanel);
       
       JPanel buttonPanel = new JPanel();
       buttonPanel.setLayout(new GridLayout(3,1));
       
       buttonDeposit = new JButton("Deposit");
       buttonWithdraw = new JButton("Withdraw");
       buttonExit = new JButton("Exit");
       buttonDeposit.addActionListener(new ButtonHandler(this));
       buttonWithdraw.addActionListener(new ButtonHandler(this));
       buttonExit.setActionCommand("Exit");
       buttonExit.addActionListener(new ButtonHandler(this));

       buttonPanel.add(buttonDeposit, BorderLayout.PAGE_START);
       buttonPanel.add(buttonWithdraw, BorderLayout.CENTER);
       buttonPanel.add(buttonExit, BorderLayout.PAGE_END);
       
       JPanel textPanel = new JPanel();
       textPanel.setPreferredSize(new Dimension(800,450));
       textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.X_AXIS));
       
       text = new JTextArea(20, 50);
       text.setFont(new Font("Times New Roman", Font.BOLD, 12));
       text.setBackground(Color.white);
       text.setEditable(false);
       text.setForeground(Color.black);
       text.setText("Welcome Dear Customer");
       
       JScrollPane scrollText = new JScrollPane (text, 
       JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
       JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
       
       textPanel.add(scrollText);
       textPanel.add(buttonPanel);
       
       thePanel.add(textPanel);
       
       Frame.add(thePanel);
       Frame.setVisible(true);
   }
    
   public static void main(String[] args)
   {
       ATMGUI atm = new ATMGUI();
       atm.showATM();
    }
    
     /**
     * Method untuk melakukan return Apa yang ada dalam Text Area
     * 
     * @return ID kustomer
     */
    public String getTextArea(){

       String textDisplay = text.getText();
       return textDisplay;
    }
    
   /**
     * Method untuk melakukan return ID yang dituliskan dalam GUI
     * 
     * @return ID kustomer
     */
    public String getIDcostumer(){
       String id = custIdText.getText();
       return id;
    }
    
     /**
     * Method untuk melakukan return Nominal yang dituliskan dalam GUI
     * 
     * @return Nominal yang ditulis
     */
    public String getNominal(){
       String amount = amountText.getText();
       return amount;
    }
    
}