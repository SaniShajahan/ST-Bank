
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
public class Cash_Withdrawl extends JFrame
{
	double Money;
	String S;
	JCheckBox cb,cb2;
	public Cash_Withdrawl(String I)
	{
		super("Cash_Withdrawl");
		
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
		
		JLabel label1=new JLabel("Enter Your Ammount :");
		Font f2=new Font("Arial",Font.BOLD,25);
		label1.setFont(f2);
		
		JTextField textField1=new JTextField("XXXXXXXX");
		textField1.setFont(f2);
		textField1.setForeground(Color.RED);
		
		JButton Button1=new JButton("Cash Out");
		Font f1=new Font("Arial",Font.BOLD,25);
		Button1.setFont(f1);
		Button1.setBackground(Color.blue);
		Button1.setForeground(Color.WHITE);
		
		JButton Button2=new JButton("Back");
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
		p.add(textField1,gbc);  //textField1
		gbc.gridx=0;
		gbc.gridy=4;
		p.add(Button1,gbc);  //Button1
		gbc.gridx=0;
		gbc.gridy=5;
		p.add(Button2,gbc);  //Button2
		
		
		
		
		add(p,BorderLayout.NORTH);
	
		Button1.addActionListener(new ActionListener() //Button1
				{
					
					@Override
					public void actionPerformed(ActionEvent e)
					{
						Money=Double.parseDouble(textField1.getText());
						
						if(Money>499 & Money <=50000)
						{

							try
							{ 
								Connection myConn=DriverManager.getConnection( "jdbc:mysql://localhost:3306/stbank","root","root"); 
						
								Statement myStmt=myConn.createStatement(); 
							
								ResultSet myRs=myStmt.executeQuery("select * from STBank.CustomerData where CId='"+I+"'");
								while(myRs.next()) 
								{ 
									double D1=myRs.getDouble("Balance")-Money;
									if(D1>499)
									{
										//JOptionPane.showMessageDialog(null,"okk");
										double D=myRs.getDouble("Balance")-Money;
										myStmt.executeUpdate("update STBank.CustomerData set Balance='"+D+"' where CId='"+I+"'");
										
										JOptionPane.showMessageDialog(null,"Please Collect Your Money");
										Customer_Window CW=new Customer_Window(I);
										setVisible(false);
										dispose();
										CW.setVisible(true);
									}
									else
									{
										JOptionPane.showMessageDialog(null,"Insufficient Amount");
									}
							    }
									
								
								myConn.close();    
							}
						catch(Exception exc)
							{
								exc.printStackTrace();
							}
	
						}
					
						
						else
						{
							JOptionPane.showMessageDialog(null,"Wrong Amount");
						}

					}
				});
		
		Button2.addActionListener(new ActionListener() //Button2
				{
					
					@Override
					public void actionPerformed(ActionEvent e)
					{
						Customer_Window CW=new Customer_Window(I);
						setVisible(false);
						dispose();
						CW.setVisible(true);

					}
				});
		
	}

}
