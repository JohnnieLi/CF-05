package ca.ucareer.computerfactory.model.memory;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="memory")
public class MemoryCard {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String label;

    @Column(nullable = true)
    private double price = 0.0;

    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date created_at;

    @Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp
    private Date modified_at;

    @CreatedBy
    private String created_by;

    public MemoryCard() {
    }

    public MemoryCard(Integer id, String label, double price, Date created_at, Date modified_at, String created_by) {
        this.id = id;
        this.label = label;
        this.price = price;
        this.created_at = created_at;
        this.modified_at = modified_at;
        this.created_by = created_by;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getModified_at() {
        return modified_at;
    }

    public void setModified_at(Date modified_at) {
        this.modified_at = modified_at;
    }

    public String getCreated_by() {
        return created_by;
    }

    public void setCreated_by(String created_by) {
        this.created_by = created_by;
    }
}
