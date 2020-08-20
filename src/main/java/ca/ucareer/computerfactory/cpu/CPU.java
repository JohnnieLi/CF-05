package ca.ucareer.computerfactory.cpu;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="CPUs")
public class CPU {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="status_test")
    private String status;

    private String label;

    private String description;

    private int price = 0;

    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    @CreationTimestamp
    @Column(name="created_at")
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="modified_at")
    @UpdateTimestamp
    private Date modifiedAt;

    private String band;

    public String getBand() {
        return band;
    }

    public void setBand(String band) {
        this.band = band;
    }

    public CPU() {

    }

    public CPU(Integer id, String status, String label, String description, int price, Date createdAt, Date modifiedAt) {
        this.id = id;
        this.status = status;
        this.label = label;
        this.description = description;
        this.price = price;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getModifiedAt() {
        return modifiedAt;
    }

    public void setModifiedAt(Date modifiedAt) {
        this.modifiedAt = modifiedAt;
    }
}
