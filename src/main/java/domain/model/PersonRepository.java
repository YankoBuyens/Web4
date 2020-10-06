package domain.model;

import java.util.ArrayList;
import java.util.List;

public class PersonRepository {

    private List<Person> persons = new ArrayList<Person>();

    public PersonRepository() {
        super();
        Person person = new Person("Rik","Blob","17-02-2000","17","Rik@gmail.com","0469130232");
        persons.add(person);
        Person person1 = new Person("Zelt","Alter","18-02-2000","18","Zelt@gmail.com","0462130232");
        persons.add(person1);
        Person person2 = new Person("Zork","Blist","17-02-2001","19","Zork@gmail.com","0469131002");
        persons.add(person2);
        Person person3 = new Person("Meir","Werlt","17-02-2010","20","Meir@gmail.com","0425130518");
        persons.add(person3);
        Person person4 = new Person("Welt","Mope","17-02-2023","21","Welt@gmail.com","0434120212");
        persons.add(person4);
    }

    public void addPerson (Person person) {
        persons.add(person);
    }

    public List<Person> getPersons(){
        return persons;
    }
}
