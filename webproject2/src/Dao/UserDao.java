package Dao;

import user.User;
import utils.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//数据访问层，实现与数据库的交互
public class UserDao {
    public User select(String name) throws SQLException {
        //初始化连接
        ResultSet resultset =null;
        Connection connection=null;
        PreparedStatement preparedstatement=null;
        DBUtil util= new DBUtil();
        User user = new User();

        //建立连接，键入sql语句，根据名字将数据库对应信息赋值给user实体
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
