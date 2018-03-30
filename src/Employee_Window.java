
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
public class Employee_Window extends JFrame
{
	
	public Employee_Window(String I)
	{
		super("Employee_Window");
		
		setSize(500,600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JPanel p4=new JPanel(new GridBagLayout());
		p4.setBackground(Color.darkGray);
		
		JLabel label4=new JLabel(" ");
		Image img4 =new ImageIcon(this.getClass().getResource("/EMP.png")).getImage();
		label4.setIcon(new ImageIcon(img4));
		
		
		
		JLabel label10=new JLabel(" ");
		Image img10 =new ImageIcon(this.getClass().getResource("/LOGO.png")).getImage();
		label10.setIcon(new ImageIcon(img10));
				
		JButton Button1=new JButton("Creat An Employee Account");
		Image img =new ImageIcon(this.getClass().getResource("/em.png")).getImage();
		Button1.setIcon(new ImageIcon(img));
		Font f1=new Font("Arial",Font.BOLD,25);
		Button1.setFont(f1);
		Button1.setBackground(Color.blue);
		Button1.setForeground(Color.WHITE);
		
		JButton Button2=new JButton("Creat An Customer Account");
		Image img2 =new ImageIcon(this.getClass().getResource("/us.png")).getImage();
		Button2.setIcon(new ImageIcon(img2));
		Button2.setFont(f1);
		//Button2.setBounds(115, 245, 270, 70);
		Button2.setBackground(Color.blue);
		Button2.setForeground(Color.WHITE);
		
		JButton Button3=new JButton("Change Pin");
		Button3.setFont(f1);
		//Button3.setBounds(115, 245, 270, 70);
		Button3.setBackground(Color.blue);
		Button3.setForeground(Color.WHITE);
		
		JButton Button5=new JButton("Add Money");
		Button5.setFont(f1);
		//Button5.setBounds(125, 245, 270, 70);
		Button5.setBackground(Color.blue);
		Button5.setForeground(Color.WHITE);
		
		JButton Button4=new JButton("Log Out");
		Image img1 =new ImageIcon(this.getClass().getResource("/Logoff.png")).getImage();
		Button4.setIcon(new ImageIcon(img1));
		Button4.setFont(f1);
		//Button4.setBounds(150, 250, 170, 50);
		Button4.setBackground(Color.WHITE);
		Button4.setForeground(Color.BLACK);

		
		
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
		p4.add(Button1,gbc);
		gbc.gridx=0;
		gbc.gridy=3;
		p4.add(Button2,gbc);
		gbc.gridx=0;
		gbc.gridy=4;
		p4.add(Button3,gbc);
		gbc.gridx=0;
		gbc.gridy=5;
		p4.add(Button5,gbc);
		gbc.gridx=0;
		gbc.gridy=6;
		p4.add(Button4,gbc);
		
		add(p4,BorderLayout.NORTH);
		
		Button1.addActionListener(new ActionListener() //
				{
					
					@Override
					public void actionPerformed(ActionEvent e)
					{
						Create_Employee_Account CEA=new Create_Employee_Account(I);
						setVisible(false);
						dispose();
						CEA.setVisible(true);

					}
				});
		Button2.addActionListener(new ActionListener() //
				{
					
					@Override
					public void actionPerformed(ActionEvent e)
					{
						Create_Customer_Account CCA=new Create_Customer_Account(I);
						setVisible(false);
						dispose();
						CCA.setVisible(true);

					}
				});
		Button3.addActionListener(new ActionListener() //
				{
					
					@Override
					public void actionPerformed(ActionEvent e)
					{
						Pin_Change_Employee PCE=new Pin_Change_Employee(I);
						setVisible(false);
						dispose();
						PCE.setVisible(true);

					}
				});
		Button4.addActionListener(new ActionListener() //
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
		Button5.addActionListener(new ActionListener() //
				{
					
					@Override
					public void actionPerformed(ActionEvent e)
					{
						Add_Money AM=new Add_Money(I);
	    				setVisible(false);
	    				dispose();
	    				AM.setVisible(true);

					}
				});	
		
	}

}
