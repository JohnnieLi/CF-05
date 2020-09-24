package ca.ucareer.computerfactory.memory_card;

import ca.ucareer.computerfactory.computer.Computer;
import ca.ucareer.computerfactory.user.User;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.ManyToAny;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "memory_cards")
public class MemoryCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="status_test")
    private String status;

    private String label;

    private String description;


    @ManyToOne()
    private Computer computer;

    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    @CreationTimestamp
    @Column(name="created_at")
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="modified_at")
    @UpdateTimestamp
    private Date modifiedAt;

    MemoryCard(){}


//    public Computer getComputer() {
//        return computer;
//    }
//
//    public void setComputer(Computer computer) {
//        this.computer = computer;
//    }

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
