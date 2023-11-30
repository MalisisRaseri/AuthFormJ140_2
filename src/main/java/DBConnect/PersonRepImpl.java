package DBConnect;

import DBInfo.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonRepImpl implements PersonRep {
    @Override
    public List<Person> getPersons() {
        List<Person> list = new ArrayList<>();
        try(Connection connection = getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM person")){
            while(resultSet.next()){
                int id = resultSet.getInt(1);
                String jobTitle = resultSet.getString(2);
                String firstNameLastName = resultSet.getString(3);
                String phone = resultSet.getString(4);
                String email = resultSet.getString(5);
                Person person = new Person(id, jobTitle, firstNameLastName, phone, email);
                list.add(person);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Person getPersonById(int id) {
        List<Person> list = new ArrayList<>();
        try(Connection connection = getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM person WHERE id=" + id)){
            while(resultSet.next()){
                String jobTitle = resultSet.getString(2);
                String firstNameLastName = resultSet.getString(3);
                String phone = resultSet.getString(4);
                String email = resultSet.getString(5);
                Person person = new Person(id, jobTitle, firstNameLastName, phone, email);
                list.add(person);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return list.isEmpty() ? null : list.get(0);
    }
    private Connection getConnection() throws SQLException{
        String url = DBProperties.get().getProperty("db.url");
        String dbUser = DBProperties.get().getProperty("db.user");
        String dbPassword = DBProperties.get().getProperty("db.password");
        return DriverManager.getConnection(url, dbUser, dbPassword);
    }


}

