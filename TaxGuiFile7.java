import java.awt.event.*;
import javax.swing.*;
import java.awt.GridLayout;
import java.io.FileInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Vector;

public class TaxGuiFile7 extends JFrame implements ActionListener {
    JLabel lblGrIncome;
    JTextField txtGrossIncome = new JTextField(15);
    JLabel lblDependents=new JLabel("Number of Dependents:");
    JTextField txtDependents = new JTextField(2);
    JLabel lblState = new JLabel("State: ");
    
    //Define a data model for the ComboBox chState
    Vector states = new Vector(50); 
    
    //Create a combobox to get data from the model 
    JComboBox chState = new JComboBox(states);

    JLabel lblTax = new JLabel("State Tax: ");
    JTextField txtStateTax = new JTextField(10);
    JButton bGo = new JButton("Go");
    JButton bReset = new JButton("Reset");
    
    TaxGuiFile7() {
        lblGrIncome = new JLabel("Gross Income: ");
        GridLayout gr = new GridLayout(5,2,1,1);
        setLayout(gr);

        add(lblGrIncome);
        add(txtGrossIncome);
        add(lblDependents);
        add(txtDependents);
        add(lblState);
        add(chState);
        add(lblTax);
        add(txtStateTax);
        add(bGo);
        add(bReset);

        // Populate states from a file
        populateStates();
        
        chState.setSelectedIndex(0);

        txtStateTax.setEditable(false);

        bGo.addActionListener(this);
        bReset.addActionListener(this);

        // Define, instantiate and register a WindowAdapter
        // to process windowClosing Event of this frame

	this.addWindowListener(new WindowAdapter() {
	    public void windowClosing(WindowEvent e) {
                 System.out.println("Good bye!");
		    System.exit(0);
	    }});
    }

    public void actionPerformed(ActionEvent evt) {
       Object source = evt.getSource();
        if (source == bGo ){
           // The Button Go processing
             try{
               int grossInc =Integer.parseInt(txtGrossIncome.getText());
               int dependents = Integer.parseInt(txtDependents.getText());
               String state = (String)chState.getSelectedItem();

               Tax tax=new Tax(grossInc,state,dependents);
               String sTax =Double.toString(tax.calcTax());
               txtStateTax.setText(sTax);
             }catch(NumberFormatException e){
                 txtStateTax.setText("Non-Numeric Data");
             }catch (Exception e){
                txtStateTax.setText(e.getMessage());
             }
         }
         else if (source == bReset ){
            // The Button Reset processing
		txtGrossIncome.setText("");
		txtDependents.setText("");
        chState.setSelectedIndex(0);
		txtStateTax.setText("");
             }
    }
   // The code below will read the file states.txt and  
   // populate the dropdown chStates
    private void populateStates(){
      
        states.add("Select State");
        
        try ( FileInputStream myFile = new FileInputStream("states.txt");
        	  InputStreamReader inputStreamReader = 
                      new InputStreamReader(myFile, "UTF8");
        	  BufferedReader reader = new BufferedReader(inputStreamReader);) {
    	  
          String nextLine;
          boolean eof = false;
          while (!eof) {
        	  nextLine = reader.readLine();
        	   if (nextLine == null){
                   eof = true;  
        	   } else {
                   // Populate the model	
                   states.add(nextLine);
        	   }  
          }
          
        }catch (IOException e){
            txtStateTax.setText("Can't read states.txt");
        }
    }

    public static void main(String args[]){
       TaxGuiFile7 taxFrame = new TaxGuiFile7();
       taxFrame.setSize(400,150);
       taxFrame.setVisible(true);
    }
}
