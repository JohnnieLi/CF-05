package ca.ucareer.computerfactory.cpu;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "CPUs")
public class CPU {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "cpu_status")
    private String status;

    @Column(name = "cpu_label")
    private String label;

    @Column(name = "cpu_description")
    private String description;

    @Column(name = "cpu_price")
    private Integer price;

    @Column(name = "cpu_core")
    private String core;

    @Column(name = "cpu_speed")
    private Float speed;

    @Column(name = "created_at")
    @CreatedDate
    @CreationTimestamp
    private Date createdAt;

    @Column(name = "modified_at")
    @LastModifiedDate
    @UpdateTimestamp
    private Date modifiedAt;

    public CPU() {
    }

    public CPU(Integer id, String status, String label, String description, Integer price, String core, Float speed, Date createdAt, Date modifiedAt) {
        this.id = id;
        this.status = status;
        this.label = label;
        this.description = description;
        this.price = price;
        this.core = core;
        this.speed = speed;
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

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getCore() {
        return core;
    }

    public void setCore(String core) {
        this.core = core;
    }

    public Float getSpeed() {
        return speed;
    }

    public void setSpeed(Float speed) {
        this.speed = speed;
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

