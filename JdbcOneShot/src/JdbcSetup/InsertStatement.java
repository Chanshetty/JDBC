package JdbcSetup;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertStatement {
	
	DbConfigration dbConfigration;
	Connection	connection;

	
   public InsertStatement(DbConfigration dbConfigration) {
		super();
		this.dbConfigration = dbConfigration;
		connection= dbConfigration.getConnection();
	  }


   
   public void insertStatement() {
	   
	   try {
		Statement st1= connection.createStatement();
		String query1="INSERT INTO classroom (StudentId, StudentName, Marks) VALUES (10145, 'rock', 68)";
		int rowEffectedbyInsert=st1.executeUpdate(query1);
		System.out.println(rowEffectedbyInsert);
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
   }
   
   
   public void insertStatement2() {
	   
	   
	   try {
		Statement st2=connection.createStatement();
		st2.addBatch( "INSERT INTO CLASSROOM(StudentId, StudentName, Marks) VALUES (1017,'boss',88)");
		st2.addBatch( "INSERT INTO CLASSROOM(StudentId, StudentName, Marks) VALUES (10196,'poke',78)");
		st2.addBatch( "INSERT INTO CLASSROOM(StudentId, StudentName, Marks) VALUES (10178,'mla',87)");
		int [] rowEffectedBYBatch=st2.executeBatch();
		System.out.println(rowEffectedBYBatch);
		for (int rows : rowEffectedBYBatch) {
            System.out.println("Rows affected: " + rows);
        }
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   
   }
   
   
   
  public void  prepareInsertStatement() {
	  
	  String query="INSERT INTO CLASSROOM(StudentId, StudentName, Marks) VALUES (?,?,?)";
	  
	  try {
		PreparedStatement ps= connection.prepareStatement(query);
		ps.setInt(1,161);
		ps.setString(2, "laddu");
		ps.setInt(3, 74);
		ps.addBatch();
		
		ps.setInt(1,162);
		ps.setString(2, "amay");
		ps.setInt(3, 74);
		ps.addBatch();
		
		ps.setInt(1,163);
		ps.setString(2, "anish");
		ps.setInt(3, 74);
		ps.addBatch();
		
		int[] roweffected=ps.executeBatch();
		
		for(int row: roweffected) {
			System.out.println("roweffected :" +row);
		}
		
		
		ps.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  }
}


