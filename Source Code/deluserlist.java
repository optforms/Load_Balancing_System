import java.net.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import java.util.*;
import java.sql.*;
class  deluserlist
{
	public static void main(String[] args) 
	{
		
		try
		{
						//JOptionPane.showMessageDialog(dest.this," You are Logout ... ", "Message ...",JOptionPane.INFORMATION_MESSAGE);
						//System.out.println(" window closed");
						
							Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
							Connection con1=DriverManager.getConnection("jdbc:odbc:SIPClusterDB");
							Statement st1=con1.createStatement();
							
										String app="delete * from UserAllocate ";
										st1.executeUpdate(app);
										System.out.println(" User List are Deleted ....");

										 app="delete * from ttime ";
										st1.executeUpdate(app);					
										System.out.println(" User List are Deleted ....");
							
								
		}
		catch (Exception a12)
		{
			System.out.println(a12);
		}
						
	}
}
