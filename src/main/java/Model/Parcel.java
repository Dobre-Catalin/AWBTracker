package Model;

import jakarta.persistence.*;

@Entity
public class Parcel {
    String AWB;
    Double mass;
    Double height;
    Double width;
    Double length;
    Boolean fragile;
    Double urgency;
    Integer sourceZIP;
    Integer destinationZIP;
    String sourceAddress;
    String destinationAddress;
    String senderPhoneNumber;
    String recepientPhoneNumber;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Parcel(String AWB, Double mass, Double height, Double width, Double length, Boolean fragile, Double urgency, Integer sourceZIP, Integer destinationZIP, String sourceAddress, String destinationAddress, String senderPhoneNumber, String recepientPhoneNumber, User user) {
        this.AWB = AWB;
        this.mass = mass;
        this.height = height;
        this.width = width;
        this.length = length;
        this.fragile = fragile;
        this.urgency = urgency;
        this.sourceZIP = sourceZIP;
        this.destinationZIP = destinationZIP;
        this.sourceAddress = sourceAddress;
        this.destinationAddress = destinationAddress;
        this.senderPhoneNumber = senderPhoneNumber;
        this.recepientPhoneNumber = recepientPhoneNumber;
        this.user = user;
    }

    public Parcel(User user) {

        this.user = user;
    }

    public Parcel() {

    }

    public String getAWB() {
        return AWB;
    }

    public Double getMass() {
        return mass;
    }

    public Double getHeight() {
        return height;
    }

    public Double getWidth() {
        return width;
    }

    public Double getLength() {
        return length;
    }

    public Boolean getFragile() {
        return fragile;
    }

    public Double getUrgency() {
        return urgency;
    }

    public Integer getSourceZIP() {
        return sourceZIP;
    }

    public Integer getDestinationZIP() {
        return destinationZIP;
    }

    public String getSourceAddress() {
        return sourceAddress;
    }

    public String getDestinationAddress() {
        return destinationAddress;
    }

    public String getSenderPhoneNumber() {
        return senderPhoneNumber;
    }

    public String getRecepientPhoneNumber() {
        return recepientPhoneNumber;
    }

    public void setAWB(String AWB) {
        this.AWB = AWB;
    }

    public void setMass(Double mass) {
        this.mass = mass;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
