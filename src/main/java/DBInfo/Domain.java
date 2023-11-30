package DBInfo;

import java.time.LocalDate;

public class Domain {
    private Integer id;
    private String webName;
    private String domainName;
    private String ip;
    private LocalDate registrationDate;
    private String country;
    private Person person;

    public Domain(Integer id, String webName, String domainName, String ip, LocalDate registrationDate, String country, Person person) {
        this.id = id;
        this.webName = webName;
        this.domainName = domainName;
        this.ip = ip;
        this.registrationDate = registrationDate;
        this.country = country;
        this.person = person;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWebName() {
        return webName;
    }

    public void setWebName(String webName) {
        this.webName = webName;
    }

    public String getDomainName() {
        return domainName;
    }

    public void setDomainName(String domainName) {
        this.domainName = domainName;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return "Domains{" + "id=" + id + ", webName=" + webName + ", domainName=" + domainName + ", ip=" + ip + ", registrationDate=" + registrationDate + ", country=" + country + ", person=" + person + '}';
    }


}
