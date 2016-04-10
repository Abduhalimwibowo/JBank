import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.Border;
import javax.swing.*;

public class ATMGUI extends JFrame {

	private JMenuBar menuBar;
	private JButton button1;
	private JButton button2;
	private JButton button4;
	private JLabel label1;
	private JLabel label2;
	private JRadioButton radiobutton2;
	private JRadioButton radiobutton3;
	private JRadioButton radiobutton4;
	private JRadioButton radiobutton5;
	private JTextArea textarea3;
	private JTextField textfield1;
	private JTextField textfield2;

	public ATMGUI(){

		this.setTitle("ATMGUI");
		this.setSize(796,440);
		//menu generate method
		
		this.setJMenuBar(menuBar);

		//pane with null layout
		JPanel contentPane = new JPanel(null);
		contentPane.setPreferredSize(new Dimension(796,440));
		contentPane.setBackground(new Color(102,102,102));


		button1 = new JButton();
		button1.setBounds(612,130,95,58);
		button1.setBackground(new Color(214,217,223));
		button1.setForeground(new Color(0,0,0));
		button1.setEnabled(true);
		button1.setFont(new Font("sansserif",0,12));
		button1.setText("Deposit");
		button1.setVisible(true);

		button2 = new JButton();
		button2.setBounds(616,199,96,61);
		button2.setBackground(new Color(214,217,223));
		button2.setForeground(new Color(0,0,0));
		button2.setEnabled(true);
		button2.setFont(new Font("sansserif",0,12));
		button2.setText("Withdraw");
		button2.setVisible(true);

		button4 = new JButton();
		button4.setBounds(620,270,93,61);
		button4.setBackground(new Color(214,217,223));
		button4.setForeground(new Color(0,0,0));
		button4.setEnabled(true);
		button4.setFont(new Font("sansserif",0,12));
		button4.setText("Exit");
		button4.setVisible(true);

		label1 = new JLabel();
		label1.setBounds(9,34,108,27);
		label1.setBackground(new Color(214,217,223));
		label1.setForeground(new Color(0,0,0));
		label1.setEnabled(true);
		label1.setFont(new Font("sansserif",0,12));
		label1.setText("Enter customer id");
		label1.setVisible(true);

		label2 = new JLabel();
		label2.setBounds(441,35,104,24);
		label2.setBackground(new Color(214,217,223));
		label2.setForeground(new Color(0,0,0));
		label2.setEnabled(true);
		label2.setFont(new Font("sansserif",0,12));
		label2.setText("Enter amount here");
		label2.setVisible(true);

		radiobutton2 = new JRadioButton();
		radiobutton2.setBounds(219,11,90,35);
		radiobutton2.setBackground(new Color(214,217,223));
		radiobutton2.setForeground(new Color(0,0,0));
		radiobutton2.setEnabled(true);
		radiobutton2.setFont(new Font("sansserif",0,12));
		radiobutton2.setText("Savings");
		radiobutton2.setVisible(true);

		radiobutton3 = new JRadioButton();
		radiobutton3.setBounds(221,33,90,35);
		radiobutton3.setBackground(new Color(214,217,223));
		radiobutton3.setForeground(new Color(0,0,0));
		radiobutton3.setEnabled(true);
		radiobutton3.setFont(new Font("sansserif",0,12));
		radiobutton3.setText("Investement");
		radiobutton3.setVisible(true);

		radiobutton4 = new JRadioButton();
		radiobutton4.setBounds(223,50,100,35);
		radiobutton4.setBackground(new Color(214,217,223));
		radiobutton4.setForeground(new Color(0,0,0));
		radiobutton4.setEnabled(true);
		radiobutton4.setFont(new Font("sansserif",0,12));
		radiobutton4.setText("Line of Credit");
		radiobutton4.setVisible(true);

		radiobutton5 = new JRadioButton();
		radiobutton5.setBounds(223,70,90,35);
		radiobutton5.setBackground(new Color(214,217,223));
		radiobutton5.setForeground(new Color(0,0,0));
		radiobutton5.setEnabled(true);
		radiobutton5.setFont(new Font("sansserif",0,12));
		radiobutton5.setText("Overdraft");
		radiobutton5.setVisible(true);

		textarea3 = new JTextArea();
		textarea3.setBounds(5,132,592,265);
		textarea3.setBackground(new Color(255,255,255));
		textarea3.setForeground(new Color(0,0,0));
		textarea3.setEnabled(true);
		textarea3.setFont(new Font("sansserif",0,12));
		textarea3.setText("Welcome");
		textarea3.setBorder(BorderFactory.createBevelBorder(1));
		textarea3.setVisible(true);

		textfield1 = new JTextField();
		textfield1.setBounds(110,36,104,24);
		textfield1.setBackground(new Color(255,255,255));
		textfield1.setForeground(new Color(0,0,0));
		textfield1.setEnabled(true);
		textfield1.setFont(new Font("sansserif",0,12));
		textfield1.setText("");
		textfield1.setVisible(true);

		textfield2 = new JTextField();
		textfield2.setBounds(553,34,116,26);
		textfield2.setBackground(new Color(255,255,255));
		textfield2.setForeground(new Color(0,0,0));
		textfield2.setEnabled(true);
		textfield2.setFont(new Font("sansserif",0,12));
		textfield2.setText("");
		textfield2.setVisible(true);

		//adding components to contentPane panel
		contentPane.add(button1);
		contentPane.add(button2);
		contentPane.add(button4);
		contentPane.add(label1);
		contentPane.add(label2);
		contentPane.add(radiobutton2);
		contentPane.add(radiobutton3);
		contentPane.add(radiobutton4);
		contentPane.add(radiobutton5);
		contentPane.add(textarea3);
		contentPane.add(textfield1);
		contentPane.add(textfield2);

		
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
				new ATMGUI();
			}
		});
	}

}