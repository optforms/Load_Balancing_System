import javax.swing.*;
import javax.swing.JOptionPane;
import java.io.*;
import java.net.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*; 
import org.gui.JDirectoryDialog; // External Tool for Jfile Chooser
class login extends JFrame 
 {  	
 	private JLabel jLabel1; 
 	private JLabel jLabel2; 
 	private JLabel jLabel3; 
 	private JTextField jTextField1; 
 	private JPasswordField jTextField2; 
 	private JButton jButton1; 
 	private JButton jButton2; 
 	private JPanel contentPane;  	
 	public login() 
 	{ 
 		super(); 
 		initializeComponent();  		
 		this.setVisible(true); 
 	}   
 	private void initializeComponent() 
 	{ 
	try
	{
		JLabel bgr;
		System.out.println("Login Object Opened");
		bgr = new JLabel(new ImageIcon("bg1.jpg"));

 		jLabel1 = new JLabel(); 
 		jLabel2 = new JLabel(); 
 		jLabel3 = new JLabel(); 
 		jTextField1 = new JTextField(); 
 		jTextField2 = new JPasswordField(); 
 		jButton1 = new JButton(); 
 		jButton2 = new JButton(); 


 

		
		contentPane = (JPanel)this.getContentPane(); 	
 		jLabel1.setText(" User Name : ");  		
 		jLabel2.setText("  Password : ");  		
 		jLabel3.setText("User Login");  
		//new LBSample();
		System.out.println("login");
		//System.out.println("LBSample$1 Called");
 		jTextField1.addActionListener(new ActionListener() { 
 			public void actionPerformed(ActionEvent e) 
 			{ 
 				jTextField1_actionPerformed(e); 
 			}   
 		});  		
 		jTextField2.addActionListener(new ActionListener() { 
 			public void actionPerformed(ActionEvent e) 
 			{ 
 				jTextField2_actionPerformed(e); 
 			}   
 		});  		
 		jButton1.setText("Login"); 
 		jButton1.addActionListener(new ActionListener() { 
 			public void actionPerformed(ActionEvent e) 
 			{ 
				try
				{
					String s1=jTextField1.getText();
					String s2=jTextField2.getText();
					if((s1.equals("lb"))&&(s2.equals("lb")))
					{
						dispose();
						new source();
					}
					else
					{
						String ccd="Invalid Username or Password ....";
						JOptionPane.showMessageDialog(login.this,ccd , "Login...",JOptionPane.INFORMATION_MESSAGE);
						jTextField1.setText("");
 						jTextField2.setText("");
					}
				}
				catch (Exception ex)
				{
				}
 			} 
  
 		});  		
 		jButton2.setText("Reset"); 
		//new LBSample();
 		jButton2.addActionListener(new ActionListener() { 
 			public void actionPerformed(ActionEvent e) 
 			{ 
 				jTextField1.setText("");
 				jTextField2.setText("");
				//jTextFiled1.setFocus();

 			} 
  
 		});  	
		addWindowListener(new WindowAdapter()
			{
				public void windowClosing(WindowEvent e)
				{
							System.exit(0);
				
				}
			}
		);
 		contentPane.setLayout(null);
		addComponent(contentPane, bgr,70,0,422,120); 
 		addComponent(contentPane, jLabel1, 139,184,80,18); 
 		addComponent(contentPane, jLabel2, 142,221,80,18); 
 		addComponent(contentPane, jLabel3, 212,140,102,18); 
 		addComponent(contentPane, jTextField1, 225,184,100,21); 
 		addComponent(contentPane, jTextField2, 226,219,100,22); 
 		addComponent(contentPane, jButton1,149,273,83,28); 
 		addComponent(contentPane, jButton2, 244,273,83,28);  		
 		this.setTitle("Load Balancing : UserLogin ..."); 
 		this.setLocation(new Point(200, 200)); 
 		this.setSize(new Dimension(560, 380)); 
		this.setVisible(true);
 	}  
	catch(Exception e)
	{
			System.out.println(""+e);
	}
	}
	
 	private void addComponent(Container container,Component c,int x,int y,int width,int height) 
 	{ 
 		c.setBounds(x,y,width,height); 
 		container.add(c); 
 	}   
 	private void jTextField1_actionPerformed(ActionEvent e) 
 	{ 
 		//System.out.println("\njTextField1_actionPerformed(ActionEvent e) called.");  		 
 	} 
  
 	private void jTextField2_actionPerformed(ActionEvent e) 
 	{ 
 		//System.out.println("\njTextField2_actionPerformed(ActionEvent e) called.");  	
 	} 
  
 	private void jButton1_actionPerformed(ActionEvent e) 
 	{ 
 		//System.out.println("\njButton1_actionPerformed(ActionEvent e) called.");  		
 	} 
  
 	private void jButton2_actionPerformed(ActionEvent e) 
 	{ 
 		//System.out.println("\njButton2_actionPerformed(ActionEvent e) called.");  	  
 	}  
public static void main(String[] args) 
 	{
		System.out.println("Login Object craeted");
 		new login();
 	}  
 } 
  

