package objectRepositories;

public class TestConfig{
//DB URL username password - Read only select

	
	public static String server="smtp.gmail.com";
	public static String from = "priyankatripathi065@gmail.com";
	public static String password = "priya1416414025";
	public static String[] to ={"priyankatripathi065@gmail.com"};
	public static String subject = "Test Report";
	
	public static String messageBody ="TestMessage";
	
	
	
	//SQL DATABASE DETAILS	
	public static String driver="net.sourceforge.jtds.jdbc.Driver"; 
	public static String dbConnectionUrl="jdbc:jtds:sqlserver://192.101.44.22;DatabaseName=monitor_eval"; 
	public static String dbUserName="sa"; 
	public static String dbPassword="$ql$!!1"; 
	
	
	//MYSQL DATABASE DETAILS
	public static String mysqldriver="com.mysql.cj.jdbc.Driver";
	public static String mysqluserName = "root";
	public static String mysqlpassword = "priyanka25";
	public static String mysqlurl = "jdbc:mysql://localhost:3306/8dec2020";
	
	
	
	
	
	
	
	
	
}
