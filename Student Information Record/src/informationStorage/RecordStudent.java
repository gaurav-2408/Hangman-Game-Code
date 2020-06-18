package informationStorage;
import javax.swing.*; 
import java.awt.Color;
import java.awt.event.*; 
import java.io.*; 
public class RecordStudent
{
	public static void studentInfo()
	{
		//Creation of a new frame
		final JFrame f = new JFrame("Student Information Handler");
		f.getContentPane().setBackground( Color.lightGray );
		JLabel l1,l2,l3,l4,l5,l6;	//labels
		final JTextField t1;	//student name,email id,mobile no.
		final JTextField t2;
		final JTextField t3;
		final JTextField t4;
		final JComboBox j1;
		final JComboBox j2;
		final JButton b1;	//b1-save button,b2-close button
		JButton b2;
		
		//naming and positioning of labels
		l1 = new JLabel("Name of Student : ");
		l1.setBounds(50, 50, 150, 30);
		l2 = new JLabel("Your Email Id : ");
		l2.setBounds(50, 120, 120, 30);
		l3 = new JLabel("Branch : ");
		l3.setBounds(50, 190, 50, 30);
		l4 = new JLabel("Section : ");
		l4.setBounds(420, 50, 70, 30);
		l5 = new JLabel("Mobile no : ");
		l5.setBounds(420, 120, 100, 30);
		l6 = new JLabel("Enter your Roll No. : ");
		l6.setBounds(420, 190, 130, 30);
		
		// Creating the textfield and 
        // setting the bounds for textfield 
        t1 = new JTextField(); 
        t1.setBounds(150, 50, 130, 30); 
        t2 = new JTextField(); 
        t2.setBounds(160, 120, 130, 30); 
        t3 = new JTextField(); 
        t3.setBounds(490, 120, 130, 30); 
        t4 = new JTextField();
        t4.setBounds(530, 190, 50, 30);
        
        String s1[] = {" ","ECE","CSE","CIVIL","MECH","AUTO","Others"};		// s1- branches
        String s2[] = {" ","Section-A","Secion-B","Section-C","Section-D","Section-E","Section-F"};//s2-sections
        
        // Creating two JComboBoxes one for 
        // selecting branch and other for 
        // selecting the section 
        // and setting the bounds
        j1 = new JComboBox(s1);
        j1.setBounds(120, 190, 100, 30);
        j2 = new JComboBox(s2);
        j2.setBounds(470, 50, 140, 30);
        
        //creating 2 buttons 1 for saving and other for closing
        b1 = new JButton("Save");
        b1.setBounds(150, 300, 70, 30);
        b2 = new JButton("Close");
        b2.setBounds(420, 300, 70, 30);
        
        // adding action listener
        b1.addActionListener(new ActionListener() 
        {
			
			public void actionPerformed(ActionEvent e) 
			{
				// TODO Auto-generated method stub
				String s1 = t1.getText(); 
                String s2 = t2.getText(); 
                String s3 = j1.getSelectedItem() + ""; 
                String s4 = j2.getSelectedItem() + ""; 
                String s5 = t3.getText(); 
                String s6 = t4.getText();
                
                if(e.getSource()==b1)
                {
                	try
                	{
                		// Creating a file and 
                        // writing the data 
                        // into a Textfile. 
                        FileWriter w 
                            = new FileWriter( 
                                "studentInfo.txt", true); 
  
                        w.write("Name: "+s1 + "\n"); 
                        w.write("Email Id: "+s2 + "\n"); 
                        w.write("Branch: "+s3 + "\n"); 
                        w.write("Section: "+s4 + "\n"); 
                        w.write("Mobile No.: "+s5 + "\n");
                        w.write("Roll No.: "+s6 + "\n-----------------------------------------------------------------------------------------------------------------------\n");
                        w.close(); 
                	}
                	catch(Exception ae)
                	{
                		System.out.println(ae);
                	}
                	
                }
                JOptionPane.showMessageDialog(f,"Sucessfully saved the details");	
			}
		});
        // Action listener to close the form 
        b2.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) 
            { 
                f.dispose(); 
            } 
        }); 
  
        // Default method for closing the frame 
        f.addWindowListener(new WindowAdapter() { 
            public void windowClosing(WindowEvent e) 
            { 
                System.exit(0); 
            } 
        });
        // finally adding all the details
        f.add(l1); 
        f.add(t1); 
        f.add(l2); 
        f.add(t2); 
        f.add(l3); 
        f.add(j1); 
        f.add(l4); 
        f.add(j2); 
        f.add(l5); 
        f.add(t3); 
        f.add(l6);
        f.add(t4);
        f.add(b1); 
        f.add(b2); 
        f.setLayout(null); 
        f.setSize(700, 600); 
        f.setVisible(true); 
	}
	public static void main(String[] args)
	{
		studentInfo();
	}

}
