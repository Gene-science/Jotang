package Dao;

import user.User;
import utils.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
    public User select(String name) throws SQLException {
        ResultSet resultset =null;
        Connection connection=null;
        PreparedStatement preparedstatement=null;
        DBUtil util= new DBUtil();
        User user = new User();


        try {
            connection=util.getConnection();
            preparedstatement=connection.prepareStatement("select * from user where username =? ");
            preparedstatement.setString(1,name);
            resultset =preparedstatement.executeQuery();

            while (resultset.next()){
                user.setUsername(resultset.getString(1));
                user.setPassword(resultset.getString(2));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            try {
                util.closeAll(resultset,preparedstatement,connection);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }return user;
    }

}
