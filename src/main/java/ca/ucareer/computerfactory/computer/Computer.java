package ca.ucareer.computerfactory.computer;

import ca.ucareer.computerfactory.cpu.CPU;
import ca.ucareer.computerfactory.memory_card.MemoryCard;
import ca.ucareer.computerfactory.user.User;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="computers")
public class Computer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "cpu_id")
    private CPU cpu;


    @OneToMany()
    @JoinColumn(name="computer_id")
    private List<MemoryCard> memoryCards = new ArrayList<>();


    @ManyToMany
    private List<User> users = new ArrayList<>();

    @Column(name="status_test")
    private String status;

    private String label;

    private String description;

    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    @CreationTimestamp
    @Column(name="created_at")
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="modified_at")
    @UpdateTimestamp
    private Date modifiedAt;

    Computer(){}

    public CPU getCpu() {
        return cpu;
    }

    public List<MemoryCard> getMemoryCards() {
        return memoryCards;
    }

    public void setMemoryCards(List<MemoryCard> memoryCards) {
        this.memoryCards = memoryCards;
    }

    public void setCpu(CPU cpu) {
        this.cpu = cpu;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
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
