
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
public class Create_Employee_Account extends JFrame
{
	String N;
	String I;
	String P;
	String A;
	String D;
	String G;
	public Create_Employee_Account(String C)
	{
		super("Create_Employee_Account");
		
		setSize(700,700);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		/*JPanel p2=new JPanel(new GridBagLayout());*/
		JPanel p4=new JPanel(new GridBagLayout());
		p4.setBackground(Color.darkGray);
		
		JLabel label4=new JLabel(" ");
		Image img4 =new ImageIcon(this.getClass().getResource("/EMP.png")).getImage();
		label4.setIcon(new ImageIcon(img4));
		JLabel label10=new JLabel(" ");
		Image img10 =new ImageIcon(this.getClass().getResource("/LOGO.png")).getImage();
		label10.setIcon(new ImageIcon(img10));
		
		JLabel label=new JLabel("Name :");
		Font f2=new Font("Arial",Font.BOLD,25);
		label.setFont(f2);
		label.setForeground(Color.blue);
		JLabel label2=new JLabel("Employee ID :");		
		label2.setFont(f2);
		label2.setForeground(Color.blue);
		JLabel label3=new JLabel("Password :");		
		label3.setFont(f2);
		label3.setForeground(Color.blue);
		JLabel label5=new JLabel("Address :");		
		label5.setFont(f2);
		label5.setForeground(Color.blue);
		JLabel label6=new JLabel("Date Of Birth :");		
		label6.setFont(f2);
		label6.setForeground(Color.blue);
		JLabel label7=new JLabel("Gender :");
		label7.setFont(f2);
		label7.setForeground(Color.blue);
		
		
		
		JTextField textField=new JTextField("XXXXXXXXXXXXXXXXXXXXXXXX");
		textField.setFont(f2);
		textField.setForeground(Color.RED);
		JTextField textField2=new JTextField("X-X-XX-X");
		textField2.setFont(f2);
		textField2.setForeground(Color.RED);
		JTextField textField3=new JTextField("XXXXXXXX");
		textField3.setFont(f2);
		textField3.setForeground(Color.RED);
		JTextField textField4=new JTextField("XXXXXXXXXXXXXXXXXXXXXXXX");
		textField4.setFont(f2);
		textField4.setForeground(Color.RED);
		JTextField textField5=new JTextField("XX-XX-XXXX");
		textField5.setFont(f2);
		textField5.setForeground(Color.RED);
		JTextField textField6=new JTextField("                ");
		textField6.setFont(f2);
		textField6.setForeground(Color.RED);
		
		String[] Gender={"Male","Femail"};
		JComboBox ComboBox1=new JComboBox(Gender);
		Font f1=new Font("Arial",Font.BOLD,25);
		ComboBox1.setFont(f1);
		ComboBox1.setBounds(75, 70, 175,50);
		
		JButton Button1=new JButton("");
		Image img =new ImageIcon(this.getClass().getResource("/Cont.png")).getImage();
		Button1.setIcon(new ImageIcon(img));
		Button1.setFont(f1);
		Button1.setBackground(Color.blue);
		Button1.setForeground(Color.WHITE);
		
		JButton Button2=new JButton("Back");
		Image img13 =new ImageIcon(this.getClass().getResource("/bk.png")).getImage();
		Button2.setIcon(new ImageIcon(img13));
		Font f3=new Font("Arial",Font.BOLD,20);
		Button2.setFont(f3);
		Button2.setBackground(Color.WHITE);
		Button2.setForeground(Color.BLACK);
		
		
		GridBagConstraints gbc =new GridBagConstraints();
		gbc.insets=new Insets(15,15,15,15);
	
		
		gbc.gridx=0;
		gbc.gridy=0;
		p4.add(label10,gbc);
		gbc.gridx=0;
		gbc.gridy=1;
		p4.add(label4,gbc);
		
		gbc.gridx=0;
		gbc.gridy=2;
		p4.add(label,gbc);  //Name
		gbc.gridx=1;
		gbc.gridy=2;
		p4.add(textField,gbc);  
		
		gbc.gridx=0;
		gbc.gridy=3;
		p4.add(label2,gbc);  //Employee ID
		gbc.gridx=1;
		gbc.gridy=3;
		p4.add(textField2,gbc);
		
		gbc.gridx=0;
		gbc.gridy=4;
		p4.add(label3,gbc);  //Password
		gbc.gridx=1;
		gbc.gridy=4;
		p4.add(textField3,gbc);
		
		gbc.gridx=0;
		gbc.gridy=5;
		p4.add(label5,gbc);  //Address
		gbc.gridx=1;
		gbc.gridy=5;
		p4.add(textField4,gbc);
		
		gbc.gridx=0;
		gbc.gridy=6;
		p4.add(label6,gbc);  //Date Of Birth
		gbc.gridx=1;
		gbc.gridy=6;
		p4.add(textField5,gbc);
		
		gbc.gridx=0;
		gbc.gridy=7;
		p4.add(label7,gbc);  
		gbc.gridx=1;
		gbc.gridy=7;
		p4.add(textField6,gbc);  //Gender
		
		
		gbc.gridx=0;
		gbc.gridy=8;
		p4.add(Button2,gbc);
		gbc.gridx=1;
		gbc.gridy=8;
		p4.add(Button1,gbc);
		
		add(p4,BorderLayout.NORTH);
		
		Button1.addActionListener(new ActionListener()   //CONTINUE
				{
					
					@Override
					public void actionPerformed(ActionEvent e)
					{
						
						
						N=textField.getText();
						I=textField2.getText();
						P=textField3.getText();
						A=textField4.getText();
						D=textField5.getText();
						G=textField6.getText();
						try
							{ 
								Connection myConn=DriverManager.getConnection( "jdbc:mysql://localhost:3306/stbank","root","root"); 
						
								Statement myStmt=myConn.createStatement(); 
							
								myStmt.executeUpdate("insert into STBank.EmployeeData(name,EId,Password,Address,DOB,Gender)values('"+N+"','"+I+"','"+P+"','"+A+"','"+D+"','"+G+"')");
								myConn.close();    
							}
						catch(Exception exc)
							{
								exc.printStackTrace();
							}
						
						
						
						
						JOptionPane.showMessageDialog(null,"Employee account has been created!!!");
						Employee_Window EW=new Employee_Window(C);
						setVisible(false);
						dispose();
						EW.setVisible(true);
					}
				});
		Button2.addActionListener(new ActionListener() //BACK
				{
					
					@Override
					public void actionPerformed(ActionEvent e)
					{
						
						Employee_Window EW=new Employee_Window(C);
						setVisible(false);
						dispose();
						EW.setVisible(true);

					}
				});
		
		
	}

}

