
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
public class Pin_Change extends JFrame
{
	String OP;
	String NP;
	String RP;
	public Pin_Change(String I)
	{
		super("Pin_Change");
		
		setSize(500,500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JPanel p4=new JPanel(new GridBagLayout());
		//p4.setBackground(Color.darkGray);
		JPanel p3=new JPanel(new GridBagLayout());
		//p4.setBackground(Color.darkGray);
		JPanel p2=new JPanel(new GridBagLayout());
		//p4.setBackground(Color.darkGray);
		
		
		JLabel label10=new JLabel(" ");
		Image img10 =new ImageIcon(this.getClass().getResource("/LOGO.png")).getImage();
		label10.setIcon(new ImageIcon(img10));
		JLabel label4=new JLabel(" ");
		Image img4 =new ImageIcon(this.getClass().getResource("/cus.png")).getImage();
		label4.setIcon(new ImageIcon(img4));
		
		
		JButton C=new JButton("");
		Image img11 =new ImageIcon(this.getClass().getResource("/Cont.png")).getImage();
		C.setIcon(new ImageIcon(img11));
		Font f1=new Font("Arial",Font.BOLD,25);
		C.setFont(f1);
		C.setBackground(Color.blue);
		
		JButton i=new JButton("Back");
		Image img13 =new ImageIcon(this.getClass().getResource("/bk.png")).getImage();
		i.setIcon(new ImageIcon(img13));
		Font f3=new Font("Arial",Font.BOLD,20);
		i.setFont(f3);
		//b.setBounds(10, 45, 200, 70);
		i.setBackground(Color.blue);
		i.setForeground(Color.WHITE);
		
		JLabel label=new JLabel("Old Password :");
		Font f2=new Font("Arial",Font.BOLD,25);
		label.setFont(f2);
		label.setForeground(Color.blue);
		JLabel label2=new JLabel("New Password :");
		//Font f2=new Font("Arial",Font.BOLD,25);
		label2.setFont(f2);
		label2.setForeground(Color.blue);
		JLabel label3=new JLabel("Repeat Password :");
		//Font f2=new Font("Arial",Font.BOLD,25);
		label3.setFont(f2);
		label3.setForeground(Color.blue);
		
		JTextField textField=new JTextField("XXXXXXXX");
		textField.setFont(f2);
		textField.setForeground(Color.RED);
		JTextField textField2=new JTextField("XXXXXXXX");
		textField2.setFont(f2);
		textField2.setForeground(Color.RED);
		JTextField textField3=new JTextField("XXXXXXXX");
		textField3.setFont(f2);
		textField3.setForeground(Color.RED);
		
		
		GridBagConstraints gbc =new GridBagConstraints();
		gbc.insets=new Insets(15,15,15,15);
		
		
		gbc.gridx=0;
		gbc.gridy=0;
		p4.add(label10,gbc);
		gbc.gridx=0;
		gbc.gridy=1;
		p4.add(label4,gbc); 
		
		gbc.gridx=0;
		gbc.gridy=0;
		p2.add(label,gbc);  //Old Password
		gbc.gridx=1;
		gbc.gridy=0;
		p2.add(textField,gbc);  
		
		gbc.gridx=0;
		gbc.gridy=1;
		p2.add(label2,gbc);  //New Password
		gbc.gridx=1;
		gbc.gridy=1;
		p2.add(textField2,gbc);
		
		gbc.gridx=0;
		gbc.gridy=2;
		p2.add(label3,gbc);  //Repeat Password
		gbc.gridx=1;
		gbc.gridy=2;
		p2.add(textField3,gbc);
		
		
		gbc.gridx=0;
		gbc.gridy=0;
		p3.add(C,gbc);
		gbc.gridx=1;
		gbc.gridy=0;
		p3.add(i,gbc);
		
		
		add(p4,BorderLayout.NORTH);
		add(p2,BorderLayout.CENTER);
		add(p3,BorderLayout.SOUTH);
		
		C.addActionListener(new ActionListener() //Continue
				{
					
					@Override
					public void actionPerformed(ActionEvent e)
					{
						

						OP=textField.getText();
						NP=textField2.getText();
						RP=textField3.getText();
						
						try
						{ 
							Connection myConn=DriverManager.getConnection( "jdbc:mysql://localhost:3306/stbank","root","root"); 
					
							Statement myStmt=myConn.createStatement(); 
						
							ResultSet myRs=myStmt.executeQuery("select * from STBank.CustomerData where CId='"+I+"'");
							while(myRs.next()) 
							{ 
								if(OP.equals(myRs.getString("Password")))
								{
									if(NP.equals(RP))
									{
										
										myStmt.executeUpdate("update STBank.CustomerData set Password='"+RP+"' where CId='"+I+"'");
										
										
										JOptionPane.showMessageDialog(null,"Password has been changed");
										Customer_Window CW=new Customer_Window(I);
										setVisible(false);
										dispose();
										CW.setVisible(true);
									}
									else
									{
										JOptionPane.showMessageDialog(null,"New and Repeat Password is not matching");
									}
								}
								else
								{
									JOptionPane.showMessageDialog(null,"Wrong Old Password");
								}

							}
							
							myConn.close();    
						}
					catch(Exception exc)
						{
							exc.printStackTrace();
						}
						

					}
				});
		i.addActionListener(new ActionListener() //Back Button
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


