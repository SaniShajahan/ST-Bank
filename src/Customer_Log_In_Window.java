
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
public class Customer_Log_In_Window extends JFrame
{
	String I;
	double P;
	String S;
	JCheckBox cb,cb2;
	public Customer_Log_In_Window()
	{
		super("Customer_Log_In_Window");
		
		setSize(500,500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JPanel p=new JPanel();
		JPanel p3=new JPanel(new GridBagLayout());
		JPanel p4=new JPanel(new GridBagLayout());
		JLabel label4=new JLabel(" ");
		Image img4 =new ImageIcon(this.getClass().getResource("/cus.png")).getImage();
		label4.setIcon(new ImageIcon(img4));
		
		JLabel label10=new JLabel(" ");
		Image img10 =new ImageIcon(this.getClass().getResource("/LOGO.png")).getImage();
		label10.setIcon(new ImageIcon(img10));
		
		
		JButton b=new JButton("Login");
		Image img3 =new ImageIcon(this.getClass().getResource("/Lo.png")).getImage();
		b.setIcon(new ImageIcon(img3));
		Font f1=new Font("Arial",Font.BOLD,35);
		b.setFont(f1);
		b.setBackground(Color.WHITE);
		b.setForeground(Color.BLACK);
		
		JButton Button2=new JButton("Back");
		Image img1 =new ImageIcon(this.getClass().getResource("/bk.png")).getImage();
		Button2.setIcon(new ImageIcon(img1));
		Button2.setFont(f1);
		Button2.setBackground(Color.WHITE);
		Button2.setForeground(Color.BLACK);
		
		
		JLabel label=new JLabel("Customer ID :");
		Image img =new ImageIcon(this.getClass().getResource("/Cu.png")).getImage();
		label.setIcon(new ImageIcon(img));
		Font f2=new Font("Arial",Font.BOLD,25);
		label.setFont(f2);
		label.setForeground(Color.blue);
		JLabel label2=new JLabel("Password :");
		Image img2 =new ImageIcon(this.getClass().getResource("/Pu.png")).getImage();
		label2.setIcon(new ImageIcon(img2));
		label2.setFont(f2);
		label2.setForeground(Color.blue);
		JTextField textField=new JTextField("X-X-XX-X");
		textField.setFont(f2);
		textField.setForeground(Color.RED);
		JTextField textField2=new JTextField("XXXXXXXX");
		textField2.setFont(f2);
		textField2.setForeground(Color.RED);
		
		GridBagConstraints gbc =new GridBagConstraints();
		gbc.insets=new Insets(15,15,15,15);
		
		p.add(b);
		p.add(Button2);
	
		gbc.gridx=0;
		gbc.gridy=0;
		p4.add(label10,gbc);
		gbc.gridx=0;
		gbc.gridy=1;
		p4.add(label4,gbc);
		
		
		gbc.gridx=0;
		gbc.gridy=0;
		p3.add(label,gbc);
		gbc.gridx=1;
		gbc.gridy=0;
		p3.add(textField,gbc);
		
		gbc.gridx=0;
		gbc.gridy=1;
		p3.add(label2,gbc);
		gbc.gridx=1;
		gbc.gridy=1;
		p3.add(textField2,gbc);
		
		add(p4,BorderLayout.NORTH);
		add(p,BorderLayout.SOUTH);
		add(p3,BorderLayout.CENTER);
		
		b.addActionListener(new ActionListener() 
		{
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				
				I=textField.getText();
				P=Double.parseDouble(textField2.getText());
				try
				{ 
					Connection myConn=DriverManager.getConnection( "jdbc:mysql://localhost:3306/stbank","root","root"); 
			
					Statement myStmt=myConn.createStatement(); 
				
					ResultSet myRs=myStmt.executeQuery("select * from STBank.CustomerData where CId like '"+I+"' and Password="+P+"");
					if(!myRs.next())
					{
						JOptionPane.showMessageDialog(null,"Wrong Customer ID or Wrong Password");
					}
					else
					{
						Customer_Window CW=new Customer_Window(I);
						setVisible(false);
						dispose();
						CW.setVisible(true);
					}
					myConn.close();    
				}
			catch(Exception exc)
				{
					exc.printStackTrace();
				}
				

			}
		});
		Button2.addActionListener(new ActionListener() 
		{
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				Log_In_Window LIW=new Log_In_Window();
				setVisible(false);
				dispose();
				LIW.setVisible(true);
			}
		});
		
	}

}
