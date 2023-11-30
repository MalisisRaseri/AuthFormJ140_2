package DBConnect;

import DBInfo.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepImpl implements UserRep{
    @Override
    public List<User> getUsers(){
        List<User> list = new ArrayList<>();
        try(Connection connection = getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM users")){
            while(resultSet.next()){
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String password = resultSet.getString(3);
                User user = new User(id, name, password);
                list.add(user);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return list;
    }

    private Connection getConnection() throws SQLException{
        String url = DBProperties.get().getProperty("db.url");
        String dbUser = DBProperties.get().getProperty("db.user");
        String dbPassword = DBProperties.get().getProperty("db.password");
        return DriverManager.getConnection(url, dbUser, dbPassword);
    }
}
