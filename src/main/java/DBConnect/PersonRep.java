package DBConnect;


import DBInfo.Person;

import java.util.List;

public interface PersonRep {
        List<Person> getPersons();
        Person getPersonById(int id);

    }


