
import java.awt.*; 
 import java.awt.event.*; 
 import javax.swing.*; 
 import javax.swing.event.*;
import java.io.*;
import java.net.*;
import java.util.*;
import java.sql.*;
import javax.sql.*;
import java.lang.*;
import java.util.Vector;
import java.awt.Toolkit;
import java.util.Timer;
import java.util.TimerTask;
import java.util.StringTokenizer;
import javax.naming.*;
import javax.naming.directory.*;
import java.util.Calendar;


class server1 extends JFrame
{
	 
	 long delay,time;
	 static int i=0,st1,counter;
	 String mesg,act="active",ss1;

	ServerSocket ss=new ServerSocket(2222);

	 Connection con;
	 Statement st;
	 DefaultListModel model1;
	 private JLabel jLabel1; 
 	 private JLabel jLabel2; 
 	 private JLabel jLabel3; 
 	 private JLabel jLabel4; 
 	 private JList jList1; 
 	 private JScrollPane jScrollPane1; 
 	 private JTextArea jTextArea1; 
 	 private JScrollPane jScrollPane2; 
 	 private JButton jButton1; 
 	 private JButton jButton2; 
     private JButton jButton3; 
 	 private JButton jButton4; 
	 private JButton jButton5;
	 private JButton jButton6; 
 	 private JPanel contentPane;
     Vector data=new Vector();
	 ArrayList a1=new ArrayList();
	 ArrayList a2=new ArrayList();
	 ArrayList allname=new ArrayList();
	 String logsys,log,sname,all,desname,smesg;
	 Thread t1;
	 String source,destination,state,smsg,srcname,msgtime;
	 FileOutputStream output,op1;
	 String fd;
     boolean sta=true,stak;
     int end;
	 

	 Socket  cs,cs1,cs2;
	 ObjectInputStream in,in1,in2;
	 ObjectOutputStream ois1,ois2,ois3;
	 
	 String res1;
 	 int  staa=0,che;
	 String hh;
     Vector v1,v2;
	 String name[]=new String[100];
	 String allsta;
	 int portno;
	 int numWarningBeeps=10 ;
     boolean sss;
	 Vector pic=new Vector();
	 Vector text=new Vector();
	 Vector allfile=new Vector();
	 server1()throws Exception
	 {
			JLabel bg; 
			bg = new JLabel(new ImageIcon("bg1.gif"));


			v1=new Vector();
			setResizable(false);
			allsta="allow";
			jLabel1 = new JLabel("Server Loaded"); //new ImageIcon("bg2.gif")
			jLabel2 = new JLabel(); 
			jLabel3 = new JLabel(); 
			jLabel4 = new JLabel(); 
			model1=new DefaultListModel();
			jList1 = new JList(); 
			jScrollPane1 = new JScrollPane(); 
			jTextArea1 = new JTextArea(); 
			jScrollPane2 = new JScrollPane(); 
			jButton1 = new JButton(); 
			jButton2 = new JButton(); 
			jButton3 = new JButton(); 
			jButton4 = new JButton(); 
			jButton5 = new JButton();
			jButton6 = new JButton(); 
			contentPane = (JPanel)this.getContentPane(); 
			op1=new FileOutputStream("msgbackup.txt");
			output=new FileOutputStream("msgbackup.txt",true);

			jTextArea1.setText("Server Started ....");
			 
			jLabel2.setText("Message Details ..."); 
			jLabel3=new JLabel(new ImageIcon("OCGRR.jpg"));
			//	jLabel4.setText("jLabel4"); 
			JLabel jLabel7=new JLabel(new ImageIcon("server1.jpg"));
			jList1.addListSelectionListener(new ListSelectionListener() 
				{ 
 			
				public void valueChanged(ListSelectionEvent e) 
				{ 
					//jList1_valueChanged(e); 
				} }); 
 		
 			jScrollPane1.setViewportView(jList1); 
	 		jScrollPane2.setViewportView(jTextArea1); 

			//--------Changed---------down--------->
 			jButton1.setText("Blocked"); 
	 		jButton1.addActionListener(new ActionListener() { 
 			
			public void actionPerformed(ActionEvent e) 
 			{ 
				 act="dactive";
 				jButton5.setEnabled(true);
				jButton1.setEnabled(false);
				//System.out.println(" Allow clicked ...."+allsta);
 			} }); 

			jButton5.setText("Non Blocked"); 
	 		jButton5.addActionListener(new ActionListener() { 
 			
			public void actionPerformed(ActionEvent e) 
 			{ 
				act="active";
				jButton1.setEnabled(true);
				jButton5.setEnabled(false);
				
 			} }); 

            //--------Changed---------up--------->


			jButton2.setText("BackLog Allow"); 
 			jButton2.addActionListener(new ActionListener() { 
 			
			public void actionPerformed(ActionEvent e) 
 			{ 
 				allsta="allow";
				jButton3.setEnabled(true);
				jButton2.setEnabled(false);
				System.out.println(" Allow clicked ...."+allsta);
			} }); 
 		 
			jButton3.setText("BackLog Not Allow"); 
	 		jButton3.addActionListener(new ActionListener() { 
 	
			public void actionPerformed(ActionEvent e) 
 			{ 
 				allsta="notallow";
				jButton2.setEnabled(true);
				jButton3.setEnabled(false);
				System.out.println(" Not Allow clicked ...."+allsta);
				
 			} }); 
			//*****************************************************
			jButton6.setText("Send Blocked Msg"); 
	 		jButton6.addActionListener(new ActionListener() { 
 	
			public void actionPerformed(ActionEvent e) 
 			{ 
 					

				
 			} }); 
			//*****************************************************
			jButton4.setText("Stop Server & Exit"); 
 			jButton4.addActionListener(new ActionListener() { 
 		
			public void actionPerformed(ActionEvent e) 
 			{ 
 				//jButton4_actionPerformed(e); 
				System.exit(0);
 			} }); 

			addWindowListener(new WindowAdapter()
			{
				public void windowClosing(WindowEvent e)
				{
					System.exit(0);
				}
			});

			String rew="";
		
			op1.write(rew.getBytes());
 		
 			contentPane.setLayout(null); 
			
 			
			addComponent(contentPane, jButton4, 175,175,120,30); 
			addComponent(contentPane, jLabel1, 175,50,300,200);
			addComponent(contentPane, jLabel7, 10,0,470,120);
			
 	
			
		 
				 MouseListener mouseListener = new MouseAdapter() {
			     public void mouseClicked(MouseEvent mouseEvent) {
			     JList jList1 = (JList) mouseEvent.getSource();
			    if (mouseEvent.getClickCount() == 2) {
				  int index = jList1.locationToIndex(mouseEvent.getPoint());
			    if (index >= 0) {
			    Object o = jList1.getModel().getElementAt(index);
				//System.out.println(">>" + ((o==null)? "null" : o.toString()) + " is selected."); 
			
				String tatext=jTextArea1.getText();
			
				}
				}
				}
			 };
			
				jButton2.setEnabled(false);
				jButton5.setEnabled(false);
				this.setTitle("Server Cluster 1 is Running ..."); 
				this.setLocation(new Point(100, 100)); 
				this.setSize(new Dimension(500, 300)); 
				//this.setSize(new Dimension(540, 490)); 
				this.setVisible(true); 


	
	
		} // Constructor class closed ..........
		
				private void addComponent(Container container,Component c,int x,int y,int width,int height) 
				{ 
					c.setBounds(x,y,width,height); 
					container.add(c); 
				} 
	 
					
				  
					private void jButton1_actionPerformed(ActionEvent e) 
					{ 
						
					} 
				  
					private void jButton2_actionPerformed(ActionEvent e) 
					{ 
						//System.out.println("\njButton2_actionPerformed(ActionEvent e) called."); 
						// TODO: Add any handling code here 
				  
					} 
				  
					private void jButton3_actionPerformed(ActionEvent e) 
					{ 
						//System.out.println("\njButton3_actionPerformed(ActionEvent e) called."); 
						// TODO: Add any handling code here 
				  
					} 
				  
					private void jButton4_actionPerformed(ActionEvent e) 
					{ 
						//System.out.println("\njButton4_actionPerformed(ActionEvent e) called."); 
						// TODO: Add any handling code here 
				  
					} 


public void msg() throws Exception
	{
		// ss=new ServerSocket(portno);

					
		try
		{
					
	
					while(true)
					{
							System.out.println(" server is listening ...");
							jLabel1.setText("Server Is Listening ...");
							cs=ss.accept();

							in=new ObjectInputStream(cs.getInputStream());
							String resu=(String)in.readObject();

							System.out.println(" receive req from server  "+resu);
							jLabel1.setText("Receiving Request From Server : "+resu);
							Thread.sleep(2000);
							if(resu.equals("requestTime()"))
							{
									ObjectOutputStream oos=new ObjectOutputStream(cs.getOutputStream());
									oos.writeObject("responseTime()");
							}
							else if(resu.equals("fileList"))
							{
								allfile.removeAllElements();
								text.removeAllElements();
								pic.removeAllElements();
								File dir = new File(".","//share" );
								String[] files = dir.list();
								System.out.println( "Files in this directory are:" );

								for ( String file : files )
									{
											allfile.add(file);
				
									}								
									ObjectOutputStream oos=new ObjectOutputStream(cs.getOutputStream());
									oos.writeObject(allfile);
							}
							else 
							{

								ObjectOutputStream oos=new ObjectOutputStream(cs.getOutputStream());
								FileInputStream input = new FileInputStream(resu);
								//FileInputStream input = new FileInputStream("bbb.txt");
								byte[] b=new byte[input.available()];
								input.read(b);
								oos.writeObject(b);
								System.out.println("Files List Send to Server : "+b);
								jLabel1.setText("Sending Files List to Server : "+b);
								Thread.sleep(2000);
							}


					}
		}
		catch (Exception e4)
		{
			System.out.println(e4);
		}
		
		
	}



	public static void main(String[] args) throws Exception
	{
		
		try
		{
		UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		}
		catch (Exception e)
		{
		e.printStackTrace();
		}

		server1 se=new server1();
		se.msg();
		
	}
}



