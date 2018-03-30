
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
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
public class Balance_Inquiry extends JFrame
{
	String S;
	JCheckBox cb,cb2;
	public Balance_Inquiry(String C)
	{
		super("Balance_Inquiry");
		
		setSize(500,500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JPanel p=new JPanel(new GridBagLayout());
		//p.setBackground(Color.darkGray);
		
		JLabel label4=new JLabel(" ");
		Image img4 =new ImageIcon(this.getClass().getResource("/cus.png")).getImage();
		label4.setIcon(new ImageIcon(img4));
		
		JLabel label10=new JLabel(" ");
		label10.setBounds(10, 45, 200, 70);
		Image img10 =new ImageIcon(this.getClass().getResource("/LOGO.png")).getImage();
		label10.setIcon(new ImageIcon(img10));
		
		JLabel label1=new JLabel("Your Current Balance is :");
		Font f2=new Font("Arial",Font.BOLD,25);
		label1.setFont(f2);
		
		
		JLabel label2=new JLabel("");
		label2.setFont(f2);
		
		JButton Button2=new JButton("Back");
		Font f1=new Font("Arial",Font.BOLD,25);
		Image img13 =new ImageIcon(this.getClass().getResource("/bk.png")).getImage();
		Button2.setIcon(new ImageIcon(img13));
		Button2.setFont(f1);
		Button2.setBackground(Color.blue);
		Button2.setForeground(Color.WHITE);
		
		GridBagConstraints gbc =new GridBagConstraints();
		gbc.insets=new Insets(15,15,15,15);
		
	
		gbc.gridx=0;
		gbc.gridy=0;
		p.add(label10,gbc);  //label0
		gbc.gridx=0;
		gbc.gridy=1;
		p.add(label4,gbc);  //label4
		gbc.gridx=0;
		gbc.gridy=2;
		p.add(label1,gbc);  //label1
		gbc.gridx=0;
		gbc.gridy=3;
		p.add(label2,gbc);  //textField1
		gbc.gridx=0;
		gbc.gridy=4;
		p.add(Button2,gbc);  //Button2
		
		
		add(p,BorderLayout.NORTH);
		
		
		try
		{ 
			Connection myConn=DriverManager.getConnection( "jdbc:mysql://localhost:3306/stbank","root","root"); 
	
			Statement myStmt=myConn.createStatement(); 
		
			ResultSet myRs=myStmt.executeQuery("select * from STBank.CustomerData where CId like '"+C+"'");
			
			
			while(myRs.next()) 
			{ 
				label2.setText(String.valueOf(myRs.getDouble("Balance")));
			}
			
			myConn.close();    
		}
	catch(Exception exc)
		{
			exc.printStackTrace();
		}
		
		
		Button2.addActionListener(new ActionListener() //Button2
				{
					
					@Override
					public void actionPerformed(ActionEvent e)
					{
						Customer_Window CW=new Customer_Window(C);
						setVisible(false);
						dispose();
						CW.setVisible(true);

					}
				});
		
	}

}

