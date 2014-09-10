package ee.golive.arendaja.model;

import ee.golive.arendaja.helper.DateTimeHelper;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name="ad")
public class Ad {

    @Id
    @GeneratedValue
    private Long id;

    private String active;

    @Size(min=5, max=60)
    private String title;

    @Size(min=100, max=1000)
    private String content;

    @Size(min=5, max=30)
    private String company_city;

    @Size(min=5, max=30)
    private String company_country;

    @Size(min=5, max=50)
    private String company_title;

    @Column(name="date_created")
    private Date dateCreated;

    @Column(name="info_url")
    private String info_url;

    public String getCompany_title() {
        return company_title;
    }

    public void setCompany_title(String company_title) {
        this.company_title = company_title;
    }

    public String getCompany_country() {
        return company_country;
    }

    public void setCompany_country(String company_country) {
        this.company_country = company_country;
    }

    public String getCompany_city() {
        return company_city;
    }

    public void setCompany_city(String company_city) {
        this.company_city = company_city;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getInfo_url() {
        return info_url;
    }

    public void setInfo_url(String info_url) {
        this.info_url = info_url;
    }

    @PrePersist
    public void prePersist() {
        setDateCreated(new Date());
        setActive("1");
    }

    public String getSummary() {
        String content = this.getContent();
        if (content.length() > 200) {
            return content.substring(0,200) + "...";
        }
        return content;
    }

    public String getRelativeDateTime() {
        return DateTimeHelper.relativeDateTime(getDateCreated(), true);
    }
}
