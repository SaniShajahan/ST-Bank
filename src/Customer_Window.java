
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
public class Customer_Window extends JFrame
{
	public Customer_Window(String C)
	{
		super("Customer_Window");
		
		setSize(500,500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JPanel p=new JPanel(new GridBagLayout());
		//p.setBackground(Color.darkGray);
		p.setLayout(null);
		
		JPanel p4=new JPanel(new GridBagLayout());
		//p4.setBackground(Color.darkGray);
		
		JLabel label10=new JLabel(" ");
		Image img10 =new ImageIcon(this.getClass().getResource("/LOGO.png")).getImage();
		label10.setIcon(new ImageIcon(img10));
		
		
		JButton b=new JButton("CASH WITHDRAWL");
		Font f1=new Font("Arial",Font.BOLD,17);
		b.setFont(f1);
		b.setBounds(10, 45, 200, 70);
		b.setBackground(Color.blue);
		b.setForeground(Color.WHITE);
		
		JButton c=new JButton("BALANCE INQUIRY");
		c.setFont(f1);
		c.setBounds(275, 45, 200, 70);
		c.setBackground(Color.blue);
		c.setForeground(Color.WHITE);
		
		JButton d=new JButton("FAST CASH");
		d.setFont(f1);
		d.setBounds(10, 175, 200, 70);
		d.setBackground(Color.blue);
		d.setForeground(Color.WHITE);
		
		JButton e=new JButton("PIN CHANGE");
		e.setFont(f1);
		e.setBounds(275, 175, 200, 70);
		e.setBackground(Color.blue);
		e.setForeground(Color.WHITE);
		
		JButton G=new JButton("Log Out");
		Image img =new ImageIcon(this.getClass().getResource("/Logoff.png")).getImage();
		G.setIcon(new ImageIcon(img));
		G.setFont(f1);
		G.setBounds(150, 250, 170, 50);
		G.setBackground(Color.WHITE);
		G.setForeground(Color.BLACK);

		
		JLabel label=new JLabel("Select an option");
		Font f=new Font("Arial",Font.BOLD,35);
		label.setFont(f);
		label.setForeground(Color.BLACK);
		
		
		
		
		GridBagConstraints gbc =new GridBagConstraints();
		gbc.insets=new Insets(15,15,15,15);
		
		
		gbc.gridx=0;
		gbc.gridy=0;
		p4.add(label10,gbc);
		gbc.gridx=0;
		gbc.gridy=1;
		p4.add(label,gbc);
		
		p.add(b,gbc);//CASH WITHDRAWL
		
		p.add(c,gbc);//BALANCE INQUIRY
		
		p.add(d,gbc);//FIRST CASH
		
		p.add(e,gbc);//PIN CHANGE
		
		p.add(G,gbc); //Log Out
		
		add(p4,BorderLayout.NORTH);
		add(p,BorderLayout.CENTER);
		
		b.addActionListener(new ActionListener() //CASH WITHDRAWL
		{
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				Cash_Withdrawl CW=new Cash_Withdrawl(C);
				setVisible(false);
				dispose();
				CW.setVisible(true);


			}
		});
		c.addActionListener(new ActionListener() //BALANCE INQUIRY
		{
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				Balance_Inquiry BI=new Balance_Inquiry(C);
				setVisible(false);
				dispose();
				BI.setVisible(true);

			}
		});
		d.addActionListener(new ActionListener() //FIRST CASH
		{
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				//JOptionPane.showMessageDialog(null,"FIRST CASH");
				First_Cash FC=new First_Cash(C);
				setVisible(false);
				dispose();
				FC.setVisible(true);

			}
		});
		e.addActionListener(new ActionListener() //PIN CHANGE
		{
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				Pin_Change PC=new Pin_Change(C);
				setVisible(false);
				dispose();
				PC.setVisible(true);

			}
		});
		
	   G.addActionListener(new ActionListener() //Log Out
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
