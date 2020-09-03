package ca.ucareer.computerfactory.model.cpu;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;


import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name="cpus")
public class CPU {

    @Id
//    MySql doesn't support the standard sequence type natively. If you use strategy="AUTO" , Hibernate will generate a table called hibernate_sequence to provide the next number for the ID sequence.
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String status;

    private String label;

    private String description;

    @Column(nullable = true)
    private double price = 0;

    private int core = 0;

    private String speed;

    @Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp
    private Date modified_at;

    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date created_at;

    @CreatedBy
    private String created_by;

    public CPU(){

    }

    public CPU(Integer id, String status, String label, String description, double price, int core, String speed) {
        this.id = id;
        this.status = status;
        this.label = label;
        this.description = description;
        this.price = price;
        this.core = core;
        this.speed = speed;
    }

    public CPU(Integer id, String status, String label, String description, double price, int core, String speed, Date modified_at, Date created_at, String created_by) {
        this.id = id;
        this.status = status;
        this.label = label;
        this.description = description;
        this.price = price;
        this.core = core;
        this.speed = speed;
        this.modified_at = modified_at;
        this.created_at = created_at;
        this.created_by = created_by;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCore() {
        return core;
    }

    public void setCore(int core) {
        this.core = core;
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    public Date getModified_at() {
        return modified_at;
    }

    public void setModified_at(Date modified_at) {
        this.modified_at = modified_at;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public String getCreated_by() {
        return created_by;
    }

    public void setCreated_by(String created_by) {
        this.created_by = created_by;
    }
}
