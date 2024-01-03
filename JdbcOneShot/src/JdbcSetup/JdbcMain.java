package JdbcSetup;

public class JdbcMain {

	public static void main(String[] args) {
	DbConfigration dbConfi= new DbConfigration();
	dbConfi.getConnection();
	SelectStatement selectStatement=new SelectStatement();
	selectStatement.selectMethode1();
	System.out.println(selectStatement.selectMethode2());
	InsertStatement insertStatement=new InsertStatement(dbConfi);
//	insertStatement.insertStatement();
//	insertStatement.insertStatement2();
//	insertStatement.prepareInsertStatement();
	
	UpdateStatement updateStatement= new UpdateStatement(dbConfi);
//	updateStatement.updateStatement();
//	updateStatement.preparedupdateStatement();
//	updateStatement.prepareStatement1bySet();
	updateStatement.delete();
	
	
	
	

	}

}
