package org.example.awbtrackerproject.Model.Parcel;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import org.example.awbtrackerproject.Model.Hub.Hub;
import org.example.awbtrackerproject.Model.User.User;

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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "userSending")
    @JsonBackReference
    private User userSending;


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
        this.userSending = user;
    }

    public Parcel() {

    }


    public String getAWB() {
        return AWB;
    }

    public void setAWB(String AWB) {
        this.AWB = AWB;
    }

    public Double getMass() {
        return mass;
    }

    public void setMass(Double mass) {
        this.mass = mass;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getWidth() {
        return width;
    }

    public void setWidth(Double width) {
        this.width = width;
    }

    public Double getLength() {
        return length;
    }

    public void setLength(Double length) {
        this.length = length;
    }

    public Boolean getFragile() {
        return fragile;
    }

    public void setFragile(Boolean fragile) {
        this.fragile = fragile;
    }

    public Double getUrgency() {
        return urgency;
    }

    public void setUrgency(Double urgency) {
        this.urgency = urgency;
    }

    public Integer getSourceZIP() {
        return sourceZIP;
    }

    public void setSourceZIP(Integer sourceZIP) {
        this.sourceZIP = sourceZIP;
    }

    public Integer getDestinationZIP() {
        return destinationZIP;
    }

    public void setDestinationZIP(Integer destinationZIP) {
        this.destinationZIP = destinationZIP;
    }

    public String getSourceAddress() {
        return sourceAddress;
    }

    public void setSourceAddress(String sourceAddress) {
        this.sourceAddress = sourceAddress;
    }

    public String getDestinationAddress() {
        return destinationAddress;
    }

    public void setDestinationAddress(String destinationAddress) {
        this.destinationAddress = destinationAddress;
    }

    public String getSenderPhoneNumber() {
        return senderPhoneNumber;
    }

    public void setSenderPhoneNumber(String senderPhoneNumber) {
        this.senderPhoneNumber = senderPhoneNumber;
    }

    public String getRecepientPhoneNumber() {
        return recepientPhoneNumber;
    }

    public void setRecepientPhoneNumber(String recepientPhoneNumber) {
        this.recepientPhoneNumber = recepientPhoneNumber;
    }

    public User getUserSending() {
        return userSending;
    }

    public void setUserSending(User userSending) {
        this.userSending = userSending;
    }

    public Integer getId() {
        return id;
    }
}
