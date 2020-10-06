package domain.model;

import java.util.List;
import java.util.Properties;

public class ContactService {

    PersonRepository personRepository = new PersonRepository();;

    public ContactService(){
    }
    public List<Person> getPersons(){
        return personRepository.getPersons();
    }
}
