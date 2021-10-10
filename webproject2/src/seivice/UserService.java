package seivice;

import Dao.UserDao;
import user.User;

import java.sql.SQLException;

public class UserService {
    UserDao userDao =new UserDao();

    public User select(String name) throws SQLException {
        return userDao.select(name);
    }
}
