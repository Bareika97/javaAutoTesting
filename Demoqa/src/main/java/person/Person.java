package person;

import java.io.File;
import java.util.Date;

public class Person {
    private String name;

    public Person() {
    }

    public Person(String name, String email, String gender, int mobile, Date dateOfBirth,
                  String subjects, File file, String address, String stateAndCity) {
        this.name = name;
        this.email = email;
        this.gender = gender;
        this.mobile = mobile;
        this.dateOfBirth = dateOfBirth;
        Subjects = subjects;
        this.file = file;
        this.address = address;
        this.stateAndCity = stateAndCity;
    }

    private String email;
    private String gender;
    private int mobile;
    private Date dateOfBirth;
    private String Subjects;
    private File file;

    private String address;
    private String stateAndCity;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getMobile() {
        return mobile;
    }

    public void setMobile(int mobile) {
        this.mobile = mobile;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getSubjects() {
        return Subjects;
    }

    public void setSubjects(String subjects) {
        Subjects = subjects;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStateAndCity() {
        return stateAndCity;
    }

    public void setStateAndCity(String stateAndCity) {
        this.stateAndCity = stateAndCity;
    }


}
