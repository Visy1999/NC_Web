package ConSQL;


import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {
    private static final String name ="root";
    private static final String pass ="root";
    private static final String url ="jdbc:mysql://localhost:3306/datesql?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";


    public static Connection getConnection() throws SQLException, IOException{

         Connection connection = null;

            try
            {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(url,name,pass);
            } catch(Exception ex){

                System.out.println("Connection failed...");

            }

        return connection;
    }
}
