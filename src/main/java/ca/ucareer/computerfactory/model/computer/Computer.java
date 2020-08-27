package ca.ucareer.computerfactory.model.computer;

import ca.ucareer.computerfactory.model.graphic.GraphicCard;
import ca.ucareer.computerfactory.model.memory.MemoryCard;
import ca.ucareer.computerfactory.model.cpu.CPU;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="computer")
public class Computer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = true)
    private double price;

    @OneToOne
    @JoinColumn(name = "FK_cpuId")
    private CPU cpu;

    @OneToOne
    @JoinColumn(name = "FK_graphicId")
    private GraphicCard graphicCard;

    @OneToOne
    @JoinColumn(name = "FK_memory")
    private MemoryCard memoryCard;

    private Date modified_at;

    private Date created_at;

    private String created_by;

    public Computer() {
    }

    public Computer(Integer id, double price, CPU cpu, GraphicCard graphicCard, MemoryCard memoryCard, Date modified_at, Date created_at, String created_by) {
        this.id = id;
        this.price = price;
        this.cpu = cpu;
        this.graphicCard = graphicCard;
        this.memoryCard = memoryCard;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public CPU getCpu() {
        return cpu;
    }

    public void setCpu(CPU cpu) {
        this.cpu = cpu;
    }

    public GraphicCard getGraphicCard() {
        return graphicCard;
    }

    public void setGraphicCard(GraphicCard graphicCard) {
        this.graphicCard = graphicCard;
    }

    public MemoryCard getMemoryCard() {
        return memoryCard;
    }

    public void setMemoryCard(MemoryCard memoryCard) {
        this.memoryCard = memoryCard;
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
