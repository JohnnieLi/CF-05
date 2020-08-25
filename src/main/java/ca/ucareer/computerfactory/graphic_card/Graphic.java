package ca.ucareer.computerfactory.graphic_card;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "graphics")
public class Graphic {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private double price;
    private String label;
    private String brand;

    @Temporal(TemporalType.DATE)
    @CreationTimestamp
    private Date createdAt;

    @Temporal(TemporalType.DATE)
    @UpdateTimestamp
    private Date modifiedAt;

    public Graphic(){

    }

    public Graphic(int id, double price, String label, String brand, Date createdAt, Date modifiedAt) {
        this.id = id;
        this.price = price;
        this.label = label;
        this.brand = brand;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
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
