import java.lang.String;
import java.net.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.Vector;
import java.sql.*;
import java.awt.Toolkit;
import java.util.Timer;
import java.util.TimerTask;
import java.util.*;
import java.lang.*;
import org.gui.JDirectoryDialog; // External Tool for Jfile Chooser
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

 
 public class source extends JFrame 
 { 
	String desdir;

 	private JLabel jLabel1; 
 	private JLabel jLabel2; 
	InetAddress in1,inet;
	 private	JDirectoryDialog directoryDialog; // External Tool for Jfile Chooser
	//JTextField tf=new JTextField(25);
	//JTextField des=new JTextField(25);
	private JList jList1; 
 	//private JTextField jTextField2; 
 	private JList jList2; 
 	private JScrollPane jScrollPane1,jScrollPane2;  
 	private JButton jButton1; 
 	private JButton jButton2; 
	private JButton jButton3; 
 	private JPanel contentPane; 
   // JTextField jTextField1;
	//JButton jButton3;  
//	 private JScrollPane jScrollPane1;
	private JLabel jLabel3; 
	private JLabel jLabel4; 
	private JLabel jLabel5; 
	private JLabel jLabel6; 
	private JLabel jLabel7; 
	private JLabel jTextField1; 
	private JLabel des; 
	private JLabel tf; 
	private JComboBox jComboBox1;
 	//private JRadioButton jRadioButton1;                                    
 	//private JRadioButton jRadioButton2; 
 	//private JRadioButton jRadioButton3; 


	FileDialog fd;
	int ww,portno;
	String filename,choice,ack,send,msg,desti,host,downfile;
	int ps,pactot,rr,len,length,port,start,end;

	Socket soc,s,s1,s2;
	ButtonGroup bg;
	ObjectOutputStream out1,out2,oos,oos1,oos2;
	ObjectInputStream oin1,oin2,ois1,ois2,ois3;

	Vector data;
   
	

	 public source()
	      {
				JLabel bgr; 
				bgr = new JLabel(new ImageIcon("bg1.jpg")); //new ImageIcon("bg1.gif")
				
			
			System.out.println("Source Constructor");
			//*************
			data=new Vector();
			fd=new FileDialog(this," Select the File",FileDialog.LOAD);
			fd.setFile("*.txt");
			
			jLabel1 = new JLabel(); 
 			jLabel2 = new JLabel(); 
			jLabel4 = new JLabel(); 
			jLabel5 = new JLabel(" Available File Formats ..."); 
			jLabel6 = new JLabel(" Destination Directory :");
			jLabel7=new JLabel(new ImageIcon("agent.jpg"));
		  
			jTextField1 = new JLabel(); 
 			des = new JLabel(); 
			tf = new JLabel(); 
			Border border = LineBorder.createGrayLineBorder();
			des.setBorder(border);
			tf.setBorder(border);
			jTextField1.setBorder(border);
			
			jList1 = new JList(); 
 			//jTextField1 = new JTextField("bct-13"); 
			jComboBox1 = new JComboBox(); 

			//jTextField1=new JTextField();
 			
 			jScrollPane1 = new JScrollPane(); 

			jList2 = new JList(); 
 			jScrollPane2 = new JScrollPane(); 
			 
 			jButton1 = new JButton(); 
 			jButton2 = new JButton();
			jButton3 = new JButton();
 			contentPane = (JPanel)this.getContentPane(); 
  
			//JCheckBoxGroup cg=new JCheckBoxGroup();
		
			

 		jLabel3 = new JLabel(); 
 		/*jRadioButton1 = new JRadioButton(); 
 		jRadioButton2 = new JRadioButton(); 
 		jRadioButton3 = new JRadioButton(); 
		*/

		 /* jRadioButton1.setActionCommand("HIGH");
		  jRadioButton2.setActionCommand("MEDIUM");
		  jRadioButton3.setActionCommand("LOW");*/

		bg=new ButtonGroup();
		/* bg.add(jRadioButton1);
 	     bg.add(jRadioButton2);
	     bg.add(jRadioButton3);
		 */
 		// 
 		// jLabel1 
 		// 
 		jLabel1.setText("Selected File Format :"); 
 		// 
 		// jLabel2 
 		// 
 		jLabel2.setText("Files List :"); 
		jLabel3.setText("Selected File Name:"); 
		//jLabel4.setText("    Traffic Class Type :"); 
		
		
 		jList1.addListSelectionListener(new ListSelectionListener() { 
 			
			public void valueChanged(ListSelectionEvent e) 
 			{ 
 				//jList1_valueChanged(e);
				System.out.println(" Hai ...");
				Object o = jList1.getSelectedValue(); 
				des.setText(o.toString());
 			} }); 
		jList2.addListSelectionListener(new ListSelectionListener() { 
 			
			public void valueChanged(ListSelectionEvent e) 
 			{ 
 				//jList2_valueChanged(e); 

				System.out.println(" list 2 ...");
				Object o = jList2.getSelectedValue(); 
				downfile=o.toString();
				jTextField1.setText(downfile);

 				System.out.println(o.toString() + " is selected.");

 			} }); 
 		// 
 		// jTextArea1 
 		// 

 		// 
 		// jScrollPane1 
 		// 
		
		jList1.addListSelectionListener(new ListSelectionListener() 
			{ 
 			
			public void valueChanged(ListSelectionEvent e) 
 			{ 
 				jList1_valueChanged(e); 
 			} }); 
 		jScrollPane1.setViewportView(jList2); 
		jScrollPane2.setViewportView(jList1); 
 		// 
 		// 
		jButton3.setText("Browse"); 
 		jButton3.addActionListener(new ActionListener() { 
 			public void actionPerformed(ActionEvent e) 
 			{ 
				
				if(directoryDialog == null)
				{
					directoryDialog = new JDirectoryDialog(source.this);
				}
				if(directoryDialog.showDirectoryDialog())
				{
					File destFile = directoryDialog.getSelectedFolder();
					desdir=destFile.getAbsolutePath();
					tf.setText(desdir);
				}
				
				
 				//send();
 			} 
  
 		}); 
 		// jButton1 
 		// 
 		jButton1.setText("Download"); 
 		jButton1.addActionListener(new ActionListener() { 
 			public void actionPerformed(ActionEvent e) 
 			{ 
				try
				{
					String res;
						if(des.getText()=="")
						{
							res="Select the File Format....";
							JOptionPane.showMessageDialog(source.this,res, " Information ...",JOptionPane.INFORMATION_MESSAGE);	
						}
						else if(jTextField1.getText()=="")
						{
							res="Select the File From the List ....";
							JOptionPane.showMessageDialog(source.this,res, " Information ...",JOptionPane.INFORMATION_MESSAGE);	
						}
						else if(tf.getText()=="")
						{	
							res="Select The Destination Directory....";
							JOptionPane.showMessageDialog(source.this,res, " Information ...",JOptionPane.INFORMATION_MESSAGE);	
						}
						else
						{
					
						InetAddress inet=InetAddress.getLocalHost();
						host=inet.getHostName().toUpperCase();
						res="The ' "+downfile+" ' file Download is now started...";
						JOptionPane.showMessageDialog(source.this,res, " Information ...",JOptionPane.INFORMATION_MESSAGE);		
						
						//REquest to Server
						s1=new Socket("localhost",1111);
						oos1=new ObjectOutputStream(s1.getOutputStream());
						oos1.writeObject("download$"+downfile+"$"+host);
						System.out.println("Download Request : "+downfile );

						//****
						ObjectInputStream ins=new ObjectInputStream(s1.getInputStream());
						String portdetails=(String)ins.readObject();
						System.out.println(" port details : "+portdetails);
						String portid=null;
						if(portdetails.equals("2222"))
						{
							portid="Server 1 ...";
						}
						else if(portdetails.equals("3333"))
						{
							portid="Server 2 ...";
						}
						else if(portdetails.equals("4444"))
						{
							portid="Server 3 ...";
						}

						res="The ' "+downfile+" ' file Download is now started..from "+portid;
						JOptionPane.showMessageDialog(source.this,res, " Information ...",JOptionPane.INFORMATION_MESSAGE);		
						//***

						//Receiving Server response
						
						 ins=new ObjectInputStream(s1.getInputStream());
						byte[] dfile=(byte[])ins.readObject();
						System.out.println(" Server Download req  Msg : "+dfile);
						new BackgroundBorderExample();

						//String fn="1"+downfile;
						//String df=".//downloaded_files";
						//FileOutputStream out=new FileOutputStream(df);
						  
						
						//String df=".//downloaded_files/"+downfile;
						 File f = new File( desdir,downfile );

						  // does the file exist
							if ( f.exists() )
							   {
								   System.out.println( "file exists" );
								   res="File Already Exists in the same Directory.Do You want Overwrite...";
									if(JOptionPane.showConfirmDialog(source.this,res, " Information ...",JOptionPane.OK_CANCEL_OPTION)==0)
								   {
										String df=desdir+"/"+downfile;
										FileOutputStream out=new FileOutputStream(df);
										out.write(dfile);
										System.out.println(" Server Download req  Msg : "+dfile);
										Thread.sleep(1000);
										res="The ' "+downfile+" ' File Download is Completed..from.."+portid;
										JOptionPane.showMessageDialog(source.this,res, " Information ...",JOptionPane.INFORMATION_MESSAGE);	
										out.close();
								   }
								   else
								   {
									   	res="Downloading process is cancelled....";
										JOptionPane.showMessageDialog(source.this,res, " Information ...",JOptionPane.INFORMATION_MESSAGE);	
								   }
							   }
							   else
							  {

									String df=desdir+"/"+downfile;
									FileOutputStream out=new FileOutputStream(df);
									out.write(dfile);
									System.out.println(" Server Download req  Msg : "+dfile);
									Thread.sleep(1000);
									res="The ' "+downfile+" ' File Download is Completed..from.."+portid;
									JOptionPane.showMessageDialog(source.this,res, " Information ...",JOptionPane.INFORMATION_MESSAGE);	
									out.close();									
							  }
						}// All Input condition failed then that else part closed
				}//try closed
				catch (Exception ew3)
				{
					System.out.println(ew3);
				}
					
 			} 
  
 		}); 
 		// 


 		// jButton2 
 		// 
 		jButton2.setText("Exit"); 
 		jButton2.addActionListener(new ActionListener() { 
 			public void actionPerformed(ActionEvent e) 
 			{ 
				
 				try
				{
					//JOptionPane.showMessageDialog(source.this," You are Exit ... ", "Message ...",JOptionPane.INFORMATION_MESSAGE);
					//Thread.sleep(2000);
					System.exit(0);
				
				}
				catch (Exception eryt)
				{
					String ccd="Your Request is not Processed. Non Blocked is occur. ....";
				JOptionPane.showMessageDialog(source.this,ccd , "Message ...",JOptionPane.INFORMATION_MESSAGE);
					
				}
				
				//oos2=new ObjectOutputStream(s1.getOutputStream());
				//oos2.writeObject("");
				
 			} 
  
 		}); 

		 Vector ext=new Vector();
		ext.add("Text Files(*.txt)");
		ext.add("Image Files(*.jpg)");
		ext.add("MsWord Files(*.doc)");
		ext.add("Pdf Files(*.pdf)");
		ext.add("PowerPoint Files(*.ppt)");
		ext.add("Gif Files(*.gif)");
		ext.add("All Files(*.*)");
		jList1.setListData(ext);
 		contentPane.setLayout(null); 

		
		addComponent(contentPane, jLabel7, 0,0,793,100); 
		/*addComponent(contentPane, jLabel5, 359,108,142,35); //available file
 		addComponent(contentPane, jLabel2, 75,192,151,29); //files list
 		addComponent(contentPane, jScrollPane1, 188,176,159,71); 
		addComponent(contentPane, jScrollPane2, 359,140,150,130); 
		*/
		addComponent(contentPane, jLabel5, 35,125,200,30);  //Avaialable File formats label
		addComponent(contentPane, jLabel1, 35,250,200,30); //Selected file format label

		addComponent(contentPane, jLabel2, 415,125,200,30);  //Files List Label
 		

 		addComponent(contentPane, jScrollPane2, 175,135,200,100); //File Types List
		addComponent(contentPane, jScrollPane1, 525,135,200,100); //File Names list
		
		addComponent(contentPane, des, 175,250,200,25); //selected file format textbox
		
		addComponent(contentPane, jLabel6, 35,300,200,30); //Dest Directory Label
 		addComponent(contentPane, jLabel3, 415,250,200,30); //Selected Filename Label
 		addComponent(contentPane, jTextField1, 525,250,200,25); //Dest Dir textbox
 		
		addComponent(contentPane, tf, 175,300,400,25); //Selected Filename textbox
 		addComponent(contentPane, jButton3, 600,300,125,25); // Browse button

 		addComponent(contentPane, jButton1, 200,350,100,30); 
 		addComponent(contentPane, jButton2,350,350,100,30); 

	//	addComponent(contentPane, bgr, 0,0,560,450);

/*
	string[]
	char[]
	char.lenth<100
	
	
	>100
	string=""
	while()
	string+=char[i]
 		//userupdate();
	*/	
 		// 
		 addWindowListener(new WindowAdapter()
			{
				public void windowClosing(WindowEvent e)
				{
				try
				{
					
					
					
							String ccd="You are Exit....";
							//JOptionPane.showMessageDialog(source.this,ccd, "Message ...",JOptionPane.INFORMATION_MESSAGE);	
							//Thread.sleep(1000);
							System.exit(0);


					
				}
				catch (Exception eryt)
				{
					String ccd="Your Request is not Processed. Non Blocked is occur. ....";
					JOptionPane.showMessageDialog(source.this,ccd , "Message ...",JOptionPane.INFORMATION_MESSAGE);
					
				}
					//System.exit(0);
				}
			}
		);
 		// c1 
 		// 
 			System.out.println("--------------------------Window Loading Time----------------");

		MouseListener mouseListener = new MouseAdapter() {
			     public void mouseClicked(MouseEvent mouseEvent) 
					 {
					 }
			 };

		
			//------------------------------------
			 jList1.addMouseListener(mouseListener);
			  jList2.addMouseListener(mouseListener);
			  //jTextField1.setText("111111111111111111");
			
		this.setTitle("User Source CLients"); 
 		this.setLocation(new Point(50, 50)); 
 		this.setSize(new Dimension(800, 450)); 
		this.setResizable(false);
		this.setVisible(true);
		///////////// Window Load....................
		
}
private void jList1_valueChanged(ListSelectionEvent e) 
 	{ 
 		System.out.println("\njList1_valueChanged(ListSelectionEvent e) called."); 
 		if(!e.getValueIsAdjusting()) 
 		{ 
 			Object o = jList1.getSelectedValue(); 
 			System.out.println(o.toString() + " is selected."); 

			try
				{
				
					System.out.println("Source send the request to server");
					
					s1=new Socket("localhost",1111);
					try
					{
						int i;
						String ss=o.toString();
						i=ss.length();
						String exten=ss.substring(i-5,i-1);

						InetAddress inet=InetAddress.getLocalHost();
						host=inet.getHostName().toUpperCase();
					
					oos1=new ObjectOutputStream(s1.getOutputStream());
					oos1.writeObject("select$"+exten+"$"+host);
					System.out.println("First Request : "+o.toString() );
					}
					catch (Exception e3)
					{
						System.out.println(e3);
						//String ccd="Source File Type Request Not Send To Server....";
						//JOptionPane.showMessageDialog(source.this,ccd , "Message ...",JOptionPane.INFORMATION_MESSAGE);
					}

						ObjectInputStream ins=new ObjectInputStream(s1.getInputStream());
						Vector file=(Vector)ins.readObject();
						jList2.setListData(file);
						//jTextField1.setText("");
					
 			  }
			catch (NullPointerException e45)
			{
				System.out.println(e45);
				//String ccd="Centralized Server is not Working ...."+e45;
				//JOptionPane.showMessageDialog(source.this,ccd , "Message ...",JOptionPane.INFORMATION_MESSAGE);
				
			}
			catch (Exception e3)
					{
						System.out.println(e3);
						String ccd="LB Server is not Started ....";
						JOptionPane.showMessageDialog(source.this,ccd , "Message ...",JOptionPane.INFORMATION_MESSAGE);
					}
 		} 
 	} 
private void jList2_valueChanged(ListSelectionEvent e) 
 	{
	if(!e.getValueIsAdjusting()) 
 		{ 
 			Object o = jList2.getSelectedValue(); 
			jTextField1.setText(o.toString());
 			System.out.println(o.toString() + " is selected."); 
		}
	
	}
private void addComponent(Container container,Component c,int x,int y,int width,int height) 
				{ 
					c.setBounds(x,y,width,height); 
					container.add(c); 
				} 
	 
					
				  
					private void jButton1_actionPerformed(ActionEvent e) 
					{ 
						
					} 
				  
					/*private void jButton2_actionPerformed(ActionEvent e) 
					{ 
						//System.out.println("\njButton2_actionPerformed(ActionEvent e) called."); 
						// TODO: Add any handling code here 
				  
					} */
				  
					/*private void jButton3_actionPerformed(ActionEvent e) 
					{ 
						//System.out.println("\njButton3_actionPerformed(ActionEvent e) called."); 
						// TODO: Add any handling code here 
				  
					}*/ 
				  
					/*private void jButton4_actionPerformed(ActionEvent e) 
					{ 
						//System.out.println("\njButton4_actionPerformed(ActionEvent e) called."); 
						// TODO: Add any handling code here 
				  
					} */
	
   
 


	public static void main(String args[])throws Exception
	{
		try
		{
		UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		}
		catch (Exception e)
		{
		e.printStackTrace();
		}
		source sf=new source();
		 
			
		  
       }
     }

