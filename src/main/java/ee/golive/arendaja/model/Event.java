package ee.golive.arendaja.model;

import ee.golive.arendaja.helper.DateTimeHelper;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name="event")
public class Event {

    @Id
    @GeneratedValue
    private Long id;

    private String active;

    @Size(min=5, max=60)
    private String title;

    @Size(min=100, max=1000)
    private String content;

    @Size(min=5, max=30)
    private String location_city;

    @Size(min=5, max=30)
    private String location_country;

    @Size(min=5, max=50)
    private String location_title;

    @NotNull
    @DateTimeFormat(pattern="YYYY-MM-dd HH:mm")
    @Column(name="date_start")
    private Date dateStart;

    @Column(name="date_created")
    private Date dateCreated;

    @Column(name="info_url")
    private String info_url;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLocation_city() {
        return location_city;
    }

    public void setLocation_city(String location_city) {
        this.location_city = location_city;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getLocation_country() {
        return location_country;
    }

    public void setLocation_country(String location_country) {
        this.location_country = location_country;
    }

    public String getLocation_title() {
        return location_title;
    }

    public void setLocation_title(String location_title) {
        this.location_title = location_title;
    }

    public Date getDateStart() {
        return dateStart;
    }

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
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
