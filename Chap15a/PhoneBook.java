//Giancarlo Massoni
//5/11/20
//Phonebook
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PhoneBook {

	public static void main(String[] args) {
		
		final String DB_URL ="jdbc:derby:Personnel;create=true";
		 
		try
	      {
		         
		         Connection conn = DriverManager.getConnection(DB_URL);
		         
		         dropTables(conn);
		         
		         buildEntriesTable(conn);
		         
		         Statement stmt = conn.createStatement();
		         
		         
		         String sqlStatement = "SELECT * FROM Entries";
		         
	
		         ResultSet result = stmt.executeQuery(sqlStatement);
		         
		         System.out.println("Entries Found in the Database");
		         System.out.println("-----------------------------");
		       
		         while (result.next())
		         {
		            System.out.println(result.getString("Name") + result.getString("PhoneNum"));
		                              
		         }
		         
		         
		         conn.close();
		      }
		      catch(Exception ex)
		      {
		         System.out.println("ERROR: " + ex.getMessage());
		      }
		
		
		
		try
	      {
		         
		         Connection conn = DriverManager.getConnection(DB_URL);
		         
		         dropTables(conn);
		         
		         buildEntriesTable(conn);
		         
		         Statement stmt = conn.createStatement();
		         
		         
		         String sqlStatement = "SELECT * FROM Entries ORDER BY Name";
		         
	
		         ResultSet result = stmt.executeQuery(sqlStatement);
		         
		         System.out.println("Phone Book Sorted by Name");
		         System.out.println("-----------------------------");
		       
		         while (result.next())
		         {
		            System.out.println(result.getString("Name") + result.getString("PhoneNum"));
		                              
		         }
		         
		         
		         conn.close();
		      }
		      catch(Exception ex)
		      {
		         System.out.println("ERROR: " + ex.getMessage());
		      }
		
		
		
		
		
		   }
	

	public static void dropTables(Connection conn)
	{
		
		
		
		
		try
		{
			
			Statement stmt  = conn.createStatement();;
		
			
			try
			{
	         
	         stmt.execute("DROP TABLE Entries");
				
				
				
			}
		
			catch(SQLException ex)
			{
	      	
			}
			
	      	
		}catch(SQLException ex)
		
		{
			      System.out.println("ERROR: " + ex.getMessage());
					ex.printStackTrace();}
				}
	
	
	public static void buildEntriesTable(Connection conn)
	{
		try
		{
     
         Statement stmt = conn.createStatement();
         
			
         stmt.execute("CREATE TABLE Entries" + "( Name CHAR(25), " + " PhoneNum CHAR(10) NOT NULL PRIMARY KEY )");
							 
			
			stmt.execute("INSERT INTO Entries VALUES (" + "'Buster', " + "'555-1234' )");

			
			stmt.execute("INSERT INTO Entries VALUES (" + "'Chester'," + "'555-4444' ) " );

			
			stmt.execute("INSERT INTO Entries VALUES (" + "'Belle'," + "'555-5678' ) " );


			
			stmt.execute("INSERT INTO Entries VALUES (" + "'Sammy'," + "'555-9211' )" );


			stmt.execute("INSERT INTO Entries VALUES (" + "'Elektra'," + "'555-8754' )" );

			
			
		}
		catch (SQLException ex)
      {
         System.out.println("ERROR: " + ex.getMessage());
      }
		
	}
	




}
