package DBConnect;

import DBInfo.Domain;
import DBInfo.Person;

import java.util.List;

public interface DomainRep {
        List<Domain> getDomains();
        List<Domain> getDomainByPerson(Person person);
        List<Domain> getDomainByPersonId(Integer personId);

    }

