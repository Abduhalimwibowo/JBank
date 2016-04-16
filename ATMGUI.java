import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.layout.*;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * Kelas ATM GUI 
 * @author Abdu Halim Wibowo
 * @version 16 April 2016
 */
public class ATMGUI extends Application
{
    private Button withdBtn;
    private TextField custID, amnt;
    private TextArea comment;
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("ATM");
        Scene scene = new Scene(addGridPane(), 700, 320);
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();


    }

    private GridPane addGridPane() {

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(15);
        grid.setPadding(new Insets(20,10,10,20));
        grid.addRow(0,addTopFlow());
        grid.addRow(1, addBottomFlow());
        //grid.addRow();
        return grid;
    }

    private FlowPane addTopFlow() {
        FlowPane flow = new FlowPane();
        custID = new TextField();
        custID.setPrefColumnCount(9);
        amnt = new TextField();
        amnt.setPrefColumnCount(9);

        Label custLbl = new Label("Enter Customer ID");
        Label amntLbl = new Label("Enter Amount Here:");

        flow = new FlowPane(15,5);
        flow.setPadding(new Insets(0,0,0,35));
        flow.setPrefWrapLength(700);

        ToggleGroup toggle = new ToggleGroup();
        RadioButton savBtn = new RadioButton("Savings");
        savBtn.setToggleGroup(toggle);
        RadioButton invBtn = new RadioButton("Investment");
        invBtn.setToggleGroup(toggle);
        RadioButton locBtn = new RadioButton("Line Of Credit");
        locBtn.setToggleGroup(toggle);
        RadioButton ovBtn = new RadioButton("Overdraft");
        ovBtn.setToggleGroup(toggle);
        VBox radBox = new VBox(5,savBtn,invBtn,locBtn,ovBtn);

        flow.getChildren().addAll(custLbl,custID,radBox,amntLbl,amnt);

        return flow;
    }

    private FlowPane addBottomFlow() {
        FlowPane flow = new FlowPane();
        flow = new FlowPane(5,10);
        flow.setPrefWrapLength(700);

        comment = new TextArea("Welcome");
        comment.setEditable(false);
        comment.setPrefColumnCount(45);
        comment.setPrefRowCount(10);
        ScrollPane scrollPane = new ScrollPane(comment);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);

        VBox inputBox = new VBox();
        Button depBtn = new Button("Deposit");
        depBtn.setOnAction(event -> {
                    comment.setText("Welcome \nCustomer: "+custID.getText()+" deposits an amount of money: Rp"+amnt.getText());

                }
        );
        withdBtn = new Button("Withdraw");
        withdBtn.setMaxSize(Double.MAX_VALUE,Double.MAX_VALUE);
        withdBtn.setOnAction(event -> {
                comment.setText("Welcome \nCustomer: "+custID.getText()+" withdraws an amount of money: Rp"+amnt.getText());

            });
        Button totBtn = new Button("Total");
        totBtn.setMaxSize(Double.MAX_VALUE,Double.MAX_VALUE);
        Button exBtn = new Button("Exit");
        exBtn.setMaxSize(Double.MAX_VALUE,Double.MAX_VALUE);
        exBtn.setOnAction(e -> {
            Alert alert = new Alert(Alert.AlertType.WARNING,"Windows Closing",ButtonType.CLOSE);
            alert.showAndWait();
            Platform.exit();
        });
        depBtn.setPrefSize(100,50);
        withdBtn.setPrefSize(100,50);
        totBtn.setPrefSize(100,50);
        exBtn.setPrefSize(100,50);
        inputBox.getChildren().addAll(depBtn,withdBtn,totBtn,exBtn);
        flow.getChildren().addAll(scrollPane,inputBox);
        return flow;
    }

    /*
    private JFrame mainFrame;
    private JLabel idLbl,amntLbl;
    private JPanel empty = new JPanel();
    private JPanel submit = new JPanel();
    private Box box = Box.createVerticalBox();
    private JPanel emptySpace = new JPanel();
    private Box panelRow = Box.createVerticalBox();
    private JPanel panelColumn = new JPanel();
    private TextArea output = new TextArea("Welcome\n", 10, 70);
    private TextField idField = new TextField(12);
    private TextField amntField = new TextField(12);

    public ATMGUI()
    {
        buildGUI();
    }
    
    private void buildGUI()
    {
        this.column();
        this.buttons();
        this.submitButtons();
        mainFrame = new JFrame ("ATM");
        mainFrame.setMinimumSize(new Dimension(650, 350));
        mainFrame.setResizable(false);
        mainFrame.setLayout(new FlowLayout(FlowLayout.LEADING, 10, 5));
        mainFrame.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        mainFrame.addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent windowEvent){
                    JOptionPane.showMessageDialog(mainFrame, "You are exitting, goodbye!"); 
                    System.exit(0);
                }        
            });
        mainFrame.add(panelRow);
        mainFrame.setVisible(true);
    }

    private void row(JPanel panel) {
        panelRow.add(panel);
    }

    private void column() {
        JPanel upperPanel = new JPanel();
        empty.setPreferredSize(new Dimension(15,50));
        upperPanel.setLayout(new FlowLayout(FlowLayout.LEADING, 10, 5));
        JPanel lowerPanel = new JPanel();
        lowerPanel.setLayout(new FlowLayout(FlowLayout.LEADING, 10, 5));
        idLbl = new JLabel("Enter customer id ");
        amntLbl = new JLabel("Enter amount here:");

        upperPanel.add(empty);
        upperPanel.add(idLbl);
        upperPanel.add(idField);
        upperPanel.add(box);
        upperPanel.add(amntLbl);
        upperPanel.add(amntField);
        row(upperPanel);
        output.setEditable(false);
        lowerPanel.add(output);
        lowerPanel.add(submit);
        row(lowerPanel);
    }

    private void buttons() {
        JRadioButton jrb1 = new JRadioButton("Savings");
        JRadioButton jrb2 = new JRadioButton("Investment");
        JRadioButton jrb3 = new JRadioButton("Line Of Credit");
        JRadioButton jrb4 = new JRadioButton("Overdraft");
        ButtonGroup bg = new ButtonGroup();
        box.add(jrb1);
        box.add(jrb2);
        box.add(jrb3);
        box.add(jrb4);
        jrb1.addItemListener(new ButtonClickListener()); 
        jrb2.addItemListener(new ButtonClickListener());
        jrb3.addItemListener(new ButtonClickListener());
        jrb4.addItemListener(new ButtonClickListener());
        bg.add(jrb1);
        bg.add(jrb2);
        bg.add(jrb3);
        bg.add(jrb4);
    }

    private void submitButtons() {
        GridLayout gl = new GridLayout(3,1);
        submit.setLayout(gl);
        JButton jb1 = new JButton ("Deposit");
        JButton jb2 = new JButton ("Withdraw");
        JButton jb3 = new JButton ("Exit");
        jb1.setPreferredSize(new Dimension(80,60));
        submit.add(jb1);
        submit.add(jb2);
        submit.add(jb3);
        jb1.setActionCommand("Deposit");
        jb2.setActionCommand("Withdraw");
        jb3.setActionCommand("Exit");
        jb1.addActionListener(new ButtonClickListener()); 
        jb2.addActionListener(new ButtonClickListener()); 
        jb3.addActionListener(new ButtonClickListener()); 
    }

    public class ButtonClickListener implements ActionListener, ItemListener{
        String customerID, moneyAmount;
        public void itemStateChanged(ItemEvent e) {

        }

        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            output.setText("Welcome\n");
            customerID = idField.getText();
            moneyAmount = amntField.getText();
            if( command.equals( "Deposit" ))  {
                output.append("Customer :" + customerID + " saves an amount of money : Rp " + moneyAmount +".");
            }
            else if( command.equals( "Withdraw" ) )  {
                output.append("Customer :" + customerID + " withdraw an amount of money : Rp " + moneyAmount +"."); 
            }
            else  if( command.equals( "Exit" ) ){
                JOptionPane.showMessageDialog(mainFrame, "You are exitting, goodbye!"); 
                System.exit(0);    
            }      
        }     
    }
    */
}
