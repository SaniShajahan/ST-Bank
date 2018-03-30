
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
public class Log_In_Window extends JFrame
{
	
	public Log_In_Window()
	{
		super("Login Panel");
		setSize(500,500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JPanel p=new JPanel(new GridBagLayout());
		p.setBackground(Color.BLACK);
		p.setLayout(null);
		JPanel p10=new JPanel();
		p10.setBackground(Color.BLACK);
		JLabel label10=new JLabel(" ");
		Image img4 =new ImageIcon(this.getClass().getResource("/LOGO.png")).getImage();
		label10.setIcon(new ImageIcon(img4));
		p10.add(label10);
		
		
		
		JButton b=new JButton("Employee");
		Image img =new ImageIcon(this.getClass().getResource("/em.png")).getImage();
		b.setIcon(new ImageIcon(img));
		Font f1=new Font("Arial",Font.BOLD,35);
		b.setFont(f1);
		b.setBounds(115, 150, 275, 70);
		b.setBackground(Color.blue);
		b.setForeground(Color.WHITE);
		JButton b2=new JButton("Customer");
		Image img2 =new ImageIcon(this.getClass().getResource("/us.png")).getImage();
		b2.setIcon(new ImageIcon(img2));
		Font f2=new Font("Arial",Font.BOLD,35);
		b2.setFont(f2);
		b2.setBounds(115, 245, 270, 70);
		b2.setBackground(Color.GREEN);
		b2.setForeground(Color.WHITE);
		
		JButton b3=new JButton("");
		Image img3 =new ImageIcon(this.getClass().getResource("/Exit.jpg")).getImage();
		b3.setIcon(new ImageIcon(img3));
		Font f3=new Font("Arial",Font.BOLD,20);
		b3.setFont(f3);
		b3.setBounds(380, 365, 65, 35);
		//b3.setBackground(Color.GREEN);
		b3.setForeground(Color.BLACK);
		
		GridBagConstraints gbc =new GridBagConstraints();
		gbc.insets=new Insets(15,15,15,15);
		
		
		
		p.add(b,gbc);
		p.add(b2,gbc);
		p.add(b3,gbc);
		add(p10,BorderLayout.NORTH);
		add(p,BorderLayout.CENTER);
		
		b.addActionListener(new ActionListener() 
		{
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				Employee_Log_In_Window ELIW=new Employee_Log_In_Window();
				setVisible(false);
				dispose();
				ELIW.setVisible(true);
				
			}
		});
		b2.addActionListener(new ActionListener() 
		{
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				Customer_Log_In_Window CLIW=new Customer_Log_In_Window();
				setVisible(false);
				dispose();
				CLIW.setVisible(true);
			}
		});
		b3.addActionListener(new ActionListener() 
		{
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				dispose();
			}
		});
	}

}

