package Looks;

public class PersonTable {
    private final Integer id;
    private final String jobTitle;
    private final String firstNameLastName;
    private final String phone;
    private final String email;
    private final Integer domainsNumber;

    public PersonTable(Integer id, String jobTitle, String firstNameLastName, String phone, String email, Integer domainsNumber) {
        this.id = id;
        this.jobTitle = jobTitle;
        this.firstNameLastName = firstNameLastName;
        this.phone = phone;
        this.email = email;
        this.domainsNumber = domainsNumber;
    }

    public Integer getId() {
        return id;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public String getFirstNameLastName() {
        return firstNameLastName;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public Integer getDomainsNumber() {
        return domainsNumber;
    }


    @Override
    public String toString() {
        return "PersonTable{" + "id=" + id + ", jobTitle=" + jobTitle + ", firstNameLastName=" + firstNameLastName + ", phone=" + phone + ", email=" + email + ", idDomain=" + domainsNumber + '}';
    }

}


