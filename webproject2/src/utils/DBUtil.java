package utils;

import java.sql.*;

import static java.lang.Class.forName;
//database工具类
public class DBUtil {
    //建立连接；
    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/database?useSSL=false","root","lqh20011021");
        return connection;
    }
    //释放资源；
    public static void closeAll(ResultSet resultset,Statement statement,Connection connection) throws SQLException {
        if(resultset!=null){
            resultset.close();
        }
        if(statement!=null){
            statement.close();
        }
        if(connection!=null){
            connection.close();
        }
    }
}
