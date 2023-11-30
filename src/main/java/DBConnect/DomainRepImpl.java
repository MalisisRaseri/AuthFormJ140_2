package DBConnect;

import DBInfo.Domain;
import DBInfo.Person;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DomainRepImpl implements DomainRep{
    private final PersonRep personRepository = new PersonRepImpl();

    @Override
    public List<Domain> getDomains() {
        List<Domain> list = new ArrayList<>();
        try(Connection connection = getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM domains")){
            while(resultSet.next()){
                int id = resultSet.getInt(1);
                String webName = resultSet.getString(2);
                String domainName = resultSet.getString(3);
                String ip = resultSet.getString(4);
                LocalDate registrationDate = resultSet.getDate(5).toLocalDate();
                String country = resultSet.getString(6);
                Person person = personRepository.getPersonById(id);
                Domain domain = new Domain(id, webName, domainName, ip, registrationDate, country, person);
                list.add(domain);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return list;
    }



    @Override
    public List<Domain> getDomainByPerson(Person person) {
        List<Domain> list = new ArrayList<>();
        try(Connection connection = getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM domains WHERE personid=" + person.getId())){
            while(resultSet.next()){
                int id = resultSet.getInt(1);
                String webName = resultSet.getString(2);
                String domainName = resultSet.getString(3);
                String ip = resultSet.getString(4);
                LocalDate registrationDate = resultSet.getDate(5).toLocalDate();
                String country = resultSet.getString(6);
                Domain domain = new Domain(id, webName, domainName, ip, registrationDate, country, person);
                list.add(domain);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Domain> getDomainByPersonId(Integer personId) {
        Person person = personRepository.getPersonById(personId);
        List<Domain> list = new ArrayList<>();
        if(person!=null){
            try(Connection connection = getConnection();
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM domains WHERE personid=" + personId)){
                while(resultSet.next()){
                    int id = resultSet.getInt(1);
                    String webName = resultSet.getString(2);
                    String domainName = resultSet.getString(3);
                    String ip = resultSet.getString(4);
                    LocalDate registrationDate = resultSet.getDate(5).toLocalDate();
                    String country = resultSet.getString(6);
                    Domain domain = new Domain(id, webName, domainName, ip, registrationDate, country, person);
                    list.add(domain);
                }
            }catch(SQLException e){
                e.printStackTrace();
            }
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
