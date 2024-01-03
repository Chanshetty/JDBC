package JdbcSetup;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SelectStatement {
/*=============================================================
	DbConfigration dbconfigration;

	public SelectStatement(DbConfigration dbconfigration) {
		super();
		this.dbconfigration = dbconfigration;
	}
	
	Connection connection=dbconfigration.getConnection();
	===========================================================*/	
	
  DbConfigration dbConfi = new DbConfigration();
  Connection connection=dbConfi.getConnection();

  
  
  public void selectMethode1() {
	  try {
		Statement st1=connection.createStatement();
		String query1="Select * from classroom";
		ResultSet rs1=st1.executeQuery(query1);
		
		while(rs1.next()) {
			int rollNo=rs1.getInt(1);
			int id =rs1.getInt("StudentId");  /* can retrive with index and exact column name as in db*/
			String name=rs1.getString("StudentName");
			int marks =rs1.getInt(4);
			System.out.println("Roll No: " + rollNo + ", ID: " + id + ", Name: " + name + ", Marks: " + marks);
		}
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  }
	  
	  
  public List selectMethode2(){
	  List rowData = new ArrayList<>();   /* Here i m storing all datatype in generic that is Object */

		  Statement st2;
		try {
			st2 = connection.createStatement();
			String query2="select * from classroom";
			  ResultSet rs2= st2.executeQuery(query2);
			  while(rs2.next()) {
			  rowData.add(rs2.getInt(1));
			  rowData.add(rs2.getInt("StudentId"));
			  rowData.add(rs2.getString("StudentName"));
			  rowData.add(rs2.getInt(4));
			  }
			  
			  
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		finally {
//			  for (Object result : rowData) {
//			        System.out.println(result);
//			    }
//		}
		  
		  return rowData;
		  
	  }
  
  
	  
	  
  }

	
  

