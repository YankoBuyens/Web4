package domain.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Person {
    private String firstName,lastName,date,room,email,gsm;

    public Person (String firstName, String lastName, String date, String room, String email, String gsm){
        super();
        setFirstName(firstName);
        setLastName(lastName);
        setDate(date);
        setRoom(room);
        setEmail(email);
        setGsm(gsm);
    }

    public String getFirstName() {
        return firstName;
    }
    private void setFirstName(String firstName) {
        if(firstName.isEmpty() || firstName == null){
            throw new DomainException("No firstName given");
        }
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }
    private void setLastName(String lastName) {
        if(lastName.isEmpty() || lastName == null){
            throw new DomainException("No lastName given");
        }
        this.lastName = lastName;
    }

    public String getDate() {
        return date;
    }
    private void setDate(String date) {
        if(date.isEmpty() || date == null){
            throw new DomainException("No date given");
        }
        this.date = date;
    }

    public String getRoom() {
        return room;
    }
    private void setRoom(String room) {
        if(room.isEmpty() || room == null){
            throw new DomainException("No room given");
        }
        this.room = room;
    }

    public String getEmail() {
        return email;
    }
    private void setEmail(String email) {
        if(email.isEmpty() || email == null){
            throw new DomainException("No email given");
        }
        String USERID_PATTERN =
                "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        Pattern p = Pattern.compile(USERID_PATTERN);
        Matcher m = p.matcher(email);
        if (!m.matches()) {
            throw new DomainException("Email not valid");
        }
        this.email = email;
    }

    public String getGsm() {
        return gsm;
    }
    private void setGsm(String gsm) {
        if(gsm.isEmpty() || gsm == null){
            throw new DomainException("No GSM given");
        }
        this.gsm = gsm;
    }
}
