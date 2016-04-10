import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CustomerGUI extends JFrame {

    private JMenuBar menuBar;
    private JButton button1;
    private JButton button3;
    private JEditorPane editorpane2;
    private JTextField textfield1;
    private JTextField textfield10;
    private JTextField textfield2;
    private JTextField textfield3;
    private JTextField textfield4;
    private JTextField textfield5;
    private JTextField textfield6;
    private JTextField textfield7;
    private JTextField textfield8;
    private JTextField textfield9;

    public CustomerGUI(){

        this.setTitle("CustomerGUI");
        this.setSize(620,415);
        //menu generate method
        
        this.setJMenuBar(menuBar);

        //pane with null layout
        JPanel contentPane = new JPanel(null);
        contentPane.setPreferredSize(new Dimension(620,415));
        contentPane.setBackground(new Color(255,255,255));


        button1 = new JButton();
        button1.setBounds(5,11,78,30);
        button1.setBackground(new Color(102,102,102));
        button1.setForeground(new Color(0,0,0));
        button1.setEnabled(true);
        button1.setFont(new Font("SansSerif",0,12));
        button1.setText("Cancel");
        button1.setVisible(true);

        button3 = new JButton();
        button3.setBounds(86,10,107,32);
        button3.setBackground(new Color(102,102,102));
        button3.setForeground(new Color(0,0,0));
        button3.setEnabled(true);
        button3.setFont(new Font("sansserif",0,12));
        button3.setText("Save & Return");
        button3.setVisible(true);

        editorpane2 = new JEditorPane();
        editorpane2.setBounds(292,110,185,174);
        editorpane2.setBackground(new Color(214,217,223));
        editorpane2.setForeground(new Color(0,0,0));
        editorpane2.setEnabled(true);
        editorpane2.setFont(new Font("sansserif",0,12));
        editorpane2.setText("Checking/OverDraft Line of Credit Savings Investment Other");
        editorpane2.setBorder(BorderFactory.createBevelBorder(1));
        editorpane2.setVisible(true);

        textfield1 = new JTextField();
        textfield1.setBounds(198,10,106,32);
        textfield1.setBackground(new Color(255,255,255));
        textfield1.setForeground(new Color(0,0,0));
        textfield1.setEnabled(true);
        textfield1.setFont(new Font("sansserif",0,12));
        textfield1.setText("1004");
        textfield1.setVisible(true);

        textfield10 = new JTextField();
        textfield10.setBounds(162,171,115,25);
        textfield10.setBackground(new Color(255,255,255));
        textfield10.setForeground(new Color(0,0,0));
        textfield10.setEnabled(true);
        textfield10.setFont(new Font("sansserif",0,12));
        textfield10.setText("DOB");
        textfield10.setVisible(true);

        textfield2 = new JTextField();
        textfield2.setBounds(306,10,169,31);
        textfield2.setBackground(new Color(255,255,255));
        textfield2.setForeground(new Color(0,0,0));
        textfield2.setEnabled(true);
        textfield2.setFont(new Font("sansserif",0,12));
        textfield2.setText("Last Name");
        textfield2.setVisible(true);

        textfield3 = new JTextField();
        textfield3.setBounds(7,46,184,25);
        textfield3.setBackground(new Color(255,255,255));
        textfield3.setForeground(new Color(0,0,0));
        textfield3.setEnabled(true);
        textfield3.setFont(new Font("sansserif",0,12));
        textfield3.setText("First Name");
        textfield3.setVisible(true);

        textfield4 = new JTextField();
        textfield4.setBounds(201,47,277,22);
        textfield4.setBackground(new Color(255,255,255));
        textfield4.setForeground(new Color(0,0,0));
        textfield4.setEnabled(true);
        textfield4.setFont(new Font("sansserif",0,12));
        textfield4.setText("Address");
        textfield4.setVisible(true);

        textfield5 = new JTextField();
        textfield5.setBounds(9,75,162,26);
        textfield5.setBackground(new Color(255,255,255));
        textfield5.setForeground(new Color(0,0,0));
        textfield5.setEnabled(true);
        textfield5.setFont(new Font("sansserif",0,12));
        textfield5.setText("City");
        textfield5.setVisible(true);

        textfield6 = new JTextField();
        textfield6.setBounds(178,76,82,25);
        textfield6.setBackground(new Color(255,255,255));
        textfield6.setForeground(new Color(0,0,0));
        textfield6.setEnabled(true);
        textfield6.setFont(new Font("sansserif",0,12));
        textfield6.setText("State");
        textfield6.setVisible(true);

        textfield7 = new JTextField();
        textfield7.setBounds(265,76,94,25);
        textfield7.setBackground(new Color(255,255,255));
        textfield7.setForeground(new Color(0,0,0));
        textfield7.setEnabled(true);
        textfield7.setFont(new Font("sansserif",0,12));
        textfield7.setText("Zip Code");
        textfield7.setVisible(true);

        textfield8 = new JTextField();
        textfield8.setBounds(361,76,116,25);
        textfield8.setBackground(new Color(255,255,255));
        textfield8.setForeground(new Color(0,0,0));
        textfield8.setEnabled(true);
        textfield8.setFont(new Font("sansserif",0,12));
        textfield8.setText("Phone");
        textfield8.setVisible(true);

        textfield9 = new JTextField();
        textfield9.setBounds(7,172,154,25);
        textfield9.setBackground(new Color(255,255,255));
        textfield9.setForeground(new Color(0,0,0));
        textfield9.setEnabled(true);
        textfield9.setFont(new Font("sansserif",0,12));
        textfield9.setText("Email Address");
        textfield9.setVisible(true);

        contentPane.add(button1);
        contentPane.add(button3);
        contentPane.add(editorpane2);
        contentPane.add(textfield1);
        contentPane.add(textfield10);
        contentPane.add(textfield2);
        contentPane.add(textfield3);
        contentPane.add(textfield4);
        contentPane.add(textfield5);
        contentPane.add(textfield6);
        contentPane.add(textfield7);
        contentPane.add(textfield8);
        contentPane.add(textfield9);

        
        this.add(contentPane);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.pack();
        this.setVisible(true);
    }

   

     public static void main(String[] args){
        System.setProperty("swing.defaultlaf", "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new CustomerGUI();
            }
        });
    }

}