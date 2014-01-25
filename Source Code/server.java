// refer line 257

import java.awt.*;
import java.awt.event.*; 
import javax.swing.*;
import javax.swing.event.*;
import java.io.*;
import java.net.*;
import java.util.*;
import java.sql.*;
import java.lang.*;
import java.util.Vector;
import java.awt.Toolkit;
import java.util.Timer;
import java.util.TimerTask;
import java.util.StringTokenizer;
import java.util.concurrent.*;

class server extends JFrame
{
	
	String systemName="localhost";
     int change;
	Vector system=new Vector();
	int curport,thtime,restime;
	 int sto,ttime=0;
	 String mesg,process,file,sysname;
	
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
	 int numWarningBeeps=1 ;
     boolean sss;

     //--------------------------------
	 Vector p2=new Vector();
	 Vector text=new Vector();
	 Vector allfile=new Vector();
	 // Socket cs=new Socket();
	 //Socket	cs1=new Socket();
	 ServerSocket ss=new ServerSocket(1111);
	
     //--------------------------------
		server()throws Exception
		{
			JLabel bg; 
			bg = new JLabel(new ImageIcon("bg1.gif"));
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection con=DriverManager.getConnection("jdbc:odbc:SIPClusterDB");
			Statement st=con.createStatement();
			String app="SELECT * FROM userallocate";
			portno=6666;
			v1=new Vector();
			JLabel jLabel7=new JLabel(new ImageIcon("load.jpg"));
	        allsta="allow";
			jLabel1 = new JLabel(); 
 			jLabel2 = new JLabel(); 
			jLabel3=new JLabel(new ImageIcon("OCGRR.jpg"));
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
 			contentPane = (JPanel)this.getContentPane(); 
			setResizable(false);
			op1=new FileOutputStream("msgbackup.txt");
			output=new FileOutputStream("msgbackup.txt",true);
			jTextArea1.setText("Server Started ....");
	 		jLabel1.setText("Available Files ..."); 
 			jLabel2.setText("Message Details ..."); 
 			jLabel3.setText("jLabel3"); 
	 		jLabel4.setText("jLabel4"); 

			jList1.addListSelectionListener(new ListSelectionListener() { 
 			
			public void valueChanged(ListSelectionEvent e) 
 			{ 
 				jList1_valueChanged(e); 
 			} }); 
 		
 			jScrollPane1.setViewportView(jList1); 
	 		jScrollPane2.setViewportView(jTextArea1); 
 			jButton1.setText("VIEW"); 
	 		jButton1.addActionListener(new ActionListener() { 
 			
			public void actionPerformed(ActionEvent e) 
 			{ 
 				//jButton1_actionPerformed(e); 
				Object o = jList1.getSelectedValue(); 
 				//System.out.println(">>" + ((o==null)? "null" : o.toString()) + " is selected."); 
				//view v1=new view(o.toString());
 			} }); 
			jButton2.setText("Allow"); 
 			jButton2.addActionListener(new ActionListener() { 
 			
			public void actionPerformed(ActionEvent e) 
 			{ 
 				allsta="allow";
				jButton3.setEnabled(true);
				jButton2.setEnabled(false);
				//System.out.println(" b1 clicked ....");
			} }); 
 		 
			jButton3.setText("Not Allow"); 
	 		jButton3.addActionListener(new ActionListener() { 
 	
			public void actionPerformed(ActionEvent e) 
 			{ 
 				allsta="notallow";
				jButton2.setEnabled(true);
				jButton3.setEnabled(false);
				//System.out.println(" b2 clicked ....");
				
 			} }); 

			jButton4.setText("EXIT"); 
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
			addComponent(contentPane, jLabel7, 70,0,422,120); 
			
	 		addComponent(contentPane, jLabel1, 351,110,183,18); 
	 		addComponent(contentPane, jLabel2, 24,112,210,18); 
	 		
 			addComponent(contentPane, jScrollPane1, 360,135,150,325); 
 			addComponent(contentPane, jScrollPane2, 12,136,333,373); 
	 		
	 		addComponent(contentPane, jButton4, 360,480,150,28); 
 			addComponent(contentPane, bg, 0,0,560,550);
			
		 
				 MouseListener mouseListener = new MouseAdapter() {
			     public void mouseClicked(MouseEvent mouseEvent) {
			     JList jList1 = (JList) mouseEvent.getSource();
			    if (mouseEvent.getClickCount() == 2) {
				  int index = jList1.locationToIndex(mouseEvent.getPoint());
			    if (index >= 0) {
			    Object o = jList1.getModel().getElementAt(index);
				//System.out.println(">>" + ((o==null)? "null" : o.toString()) + " is selected."); 
			
				String tatext=jTextArea1.getText();
				//view v1=new view(o.toString());
				//System.out.println("Double-clicked on: " + o.toString());
				}
				}
				}
			 };
				
				jList1.addMouseListener(mouseListener);
				jButton2.setEnabled(false);
				this.setTitle(" Load Balancing : Server ..."); 
				this.setLocation(new Point(100, 100)); 
				this.setSize(new Dimension(560, 550)); 
				this.setVisible(true); 
	
				
				 
	
		} // Constructor class closed ..........
		

				private void addComponent(Container container,Component c,int x,int y,int width,int height) 
				{ 
					c.setBounds(x,y,width,height); 
					container.add(c); 
				} 
	 
					private void jList1_valueChanged(ListSelectionEvent e) 
					{ 
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
 

  public void msg()
	{
	  // Here Put the listen and forward coding 
		//File dir = new File(".");
		try
		{
			
	
			allfile.removeAllElements();
			Socket s2=new Socket("localhost",2222);
			ObjectOutputStream	oos1=new ObjectOutputStream(s2.getOutputStream());
			oos1.writeObject("fileList");
			in=new ObjectInputStream(s2.getInputStream());
			allfile=(Vector)in.readObject();
			System.out.println(" File List Receive from server 1 \n\n\n-----\n\n"+allfile+"\n\n--------\n\n");
			
		//-------------
		
				jList1.setListData(allfile);
				
				System.out.println( "\nFiles in this directory are:" );
				System.out.println( allfile );
			}
		catch (Exception e34)
		{
			System.out.println(e34);
		}
		//------------------------------------------------------
		curport=2222;
		int oldrestime=0;
		int newrestime=0;
		while(true)
		{
			System.out.println("Server is listening........");
			try
			{
				cs=ss.accept();
				in=new ObjectInputStream(cs.getInputStream());
				String resu=(String)in.readObject();
				System.out.println(" First Client Request  :"+resu);

				StringTokenizer tokens = new StringTokenizer(resu,"$");
					while(tokens.hasMoreTokens())
					{
						//System.out.println(tokens.nextToken());
						process=tokens.nextToken();
						file=tokens.nextToken();
						sysname=tokens.nextToken();
					}
				if(process.equals("select"))
				{	
					//jTextArea1.setText(jTextArea1.getText()+"\n"+process +" : "+ file+ " : "+process);
						change=0;
						p2.removeAllElements();
						text.removeAllElements();
						for(int count=0;count<allfile.size();count++)
						{
							String che=(String)allfile.elementAt(count);
							p2.add(che);
							//System.out.println(count+" == "+che+"\n\n");
							if(che.endsWith(file))
							{
								text.add(che);
							}
							if(file.equals("(*.*"))
							{
								text.removeAllElements();
								change=1;
							}
						}
						
						ois1=new ObjectOutputStream(cs.getOutputStream());
						if(change==0)
						{
						ois1.writeObject(text);
						}
						else
						{
							ois1.writeObject(p2);
						}
						//System.out.println(" Inside the Text file "+text);	
					
				}
				else
				{
						long start=System.nanoTime();
						Socket s2=new Socket(systemName,curport);
						ObjectOutputStream oos1=new ObjectOutputStream(s2.getOutputStream());
						oos1.writeObject("requestTime()");
						in=new ObjectInputStream(s2.getInputStream());
						String req=(String)in.readObject();
						System.out.println(" Receive from server 1 "+req);

						long end=System.nanoTime();
						long resdelay=end-start;
						newrestime=(int)resdelay;

						System.out.println("\n\n-------new : "+newrestime+"  * old : "+oldrestime+"\n\n");
						//------------------------------------------------------------------
							if(oldrestime==0)
							{
								curport=curport;
							}
							else if(oldrestime>newrestime)
							{
								curport=curport;
							}
							else if(newrestime>oldrestime)
							{
								if(curport==2222)
								{
									curport=3333;
								}
								else if(curport==3333)
								{
									curport=4444;
								}
								else if(curport==4444)
								{
									curport=2222;
								}
								
							}
						
								System.out.println("\n\n-------new : "+newrestime+"  * old : "+oldrestime+" Curport : "+curport+"\n\n");
								Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
							Connection con=DriverManager.getConnection("jdbc:odbc:SIPClusterDB");
							Statement st=con.createStatement();
							String app="SELECT * FROM UserAllocate";
							String query = "insert into UserAllocate values('"+sysname+"','"+file+"',"+curport+","+newrestime+","+oldrestime+")";
							st.executeUpdate(query);
							//------------------------------------------------------------------
					// send to server1 
						oldrestime=newrestime;
					String ht=".//share/"+file;
					//**

					ObjectOutputStream oos=new ObjectOutputStream(cs.getOutputStream());
					oos.writeObject(String.valueOf(curport));
					//***
					String portid=null;
					if(curport==2222)
						{
							portid="Server 1";
						}
						else if(curport==3333)
						{
							portid="Server 2";
						}
						else if(curport==4444)
						{
							portid="Server 3";
						}

					jTextArea1.setText(jTextArea1.getText()+"\n Request From : "+sysname+" To : "+portid+" : "+process +" : "+ file);
					cs1=new Socket(systemName,curport);
					 oos=new ObjectOutputStream(cs1.getOutputStream());
					oos.writeObject(ht);
					System.out.println(" send to server 1 "+ht);

					in=new ObjectInputStream(cs1.getInputStream());
					byte[] pict=(byte[])in.readObject();
					System.out.println(" Receive from server 1 "+pict);

					oos=new ObjectOutputStream(cs.getOutputStream());
					oos.writeObject(pict);
					Thread.sleep(1000);
					jTextArea1.setText(jTextArea1.getText()+"\n Response To : "+sysname+" From : "+portid+" : "+process +" : "+ file);

					oos=new ObjectOutputStream(cs.getOutputStream());
					oos.writeObject(String.valueOf(curport));
					System.out.println(" send to source "+pict);
									
				//	System.out.println(" Inside the All file "+allfile);
		
					//**********
				}

				//------------------------

			}
			catch (Exception er1)
			{
				//System.out.println(er1);
			}
			
		}
		
	  //-------------------------------------------

	}
	public static void main(String[] args) throws Exception
	{
		//JFrame.setDefaultLookAndFeelDecorated(true); 
 		//JDialog.setDefaultLookAndFeelDecorated(true); 
 		try 
 		{ 
 			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel"); 
 		} 
 		catch (Exception ex) 
 		{ 
 			//System.out.println("Failed loading L&F: "); 
 			//System.out.println(ex); 
 		} 
		//timer t=new timer(10);
		
		server se=new server();
		se.msg();
		 
		
	}
}


