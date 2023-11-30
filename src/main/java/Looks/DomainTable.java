package Looks;

import java.time.LocalDate;

public class DomainTable {
    private final String webName;
    private final String domainName;
    private final String ip;
    private final LocalDate registrationDate;
    private final String country;

    public DomainTable(String webName, String domainName, String ip, LocalDate registrationDate, String country) {
        this.webName = webName;
        this.domainName = domainName;
        this.ip = ip;
        this.registrationDate = registrationDate;
        this.country = country;
    }

    public String getWebName() {
        return webName;
    }

    public String getDomainName() {
        return domainName;
    }

    public String getIp() {
        return ip;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public String getCountry() {
        return country;
    }

    @Override
    public String toString() {
        return "DomainTable{" + "webName=" + webName + ", domainName=" + domainName + ", ip=" + ip + ", registrationDate=" + registrationDate + ", country=" + country + '}';
    }


}
