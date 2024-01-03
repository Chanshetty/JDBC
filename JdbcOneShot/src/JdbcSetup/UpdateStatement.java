package JdbcSetup;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateStatement {
	
	DbConfigration dbConfigration;
	Connection connection;

	public UpdateStatement(DbConfigration dbConfigration) {
		super();
		this.dbConfigration = dbConfigration;
		this.connection=dbConfigration.getConnection();
	}
	
public void updateStatement() {
	
	try {
		Statement st=connection.createStatement();
		String query="UPDATE `selflearn`.`classroom` SET `Marks` = 99 WHERE `StudentId` = 122 ";
		int roweffected=st.executeUpdate(query);
		System.out.println(roweffected);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}

public void preparedupdateStatement() {
	try {
		Statement st1= connection.createStatement();
		st1.addBatch("UPDATE `selflearn`.`classroom` SET `Marks` = 102  WHERE `StudentId` =10178  ");
		st1.addBatch("UPDATE `selflearn`.`classroom` SET `Marks` = 11  WHERE `StudentId` =1011  ");
		st1.addBatch("UPDATE `selflearn`.`classroom` SET `Marks` = 22  WHERE `StudentId` =1012  ");
		int [] rowEffected= st1.executeBatch();
		for(int row :rowEffected) {
			System.out.println("roweffected  :"+row);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}

public void prepareStatement1bySet() {
	try {
		
		String query= "UPDATE `selflearn`.`classroom` SET `Marks` = ?  WHERE `StudentId` =? ";
		PreparedStatement st2= connection.prepareStatement(query);
		st2.setInt(1, 9);
		st2.setInt(2, 10178);
		st2.addBatch();
		
		st2.setInt(1, 9);
		st2.setInt(2, 1011);
		st2.addBatch();
		
		st2.setInt(1, 9);
		st2.setInt(2, 1012);
		st2.addBatch();
		
		int [] rowEffected= st2.executeBatch();
		for(int row :rowEffected) {
			System.out.println("roweffected  :"+row);
		}
		
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
;
	
}

public void delete() {
	
	try {
		Statement st1= connection.createStatement();
		String query="DELETE FROM `selflearn`.`classroom` WHERE StudentId=1011";
		int roweffected = st1.executeUpdate(query);
		System.out.println(roweffected);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
	
	
}
