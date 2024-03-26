package org.example.awbtrackerproject.Model.User;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import org.example.awbtrackerproject.Model.Parcel.Parcel;

import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.CascadeType.ALL;
@Entity
@Table(name = "\"user\"") // Using quotes to escape reserved keyword "user"
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    String email;
    String password;
    Boolean isAdmin;
    Boolean isSender;
    Boolean isViewOnly;

    @OneToMany(
            mappedBy = "userSending",
            cascade = ALL
    )
    @JsonManagedReference
    private List<Parcel> parcels = new ArrayList<>();

    public User(){

    }

    public User(String email, String password, Boolean isAdmin, Boolean isSender, Boolean isViewOnly) {
        this.email = email;
        this.password = password;
        this.isAdmin = isAdmin;
        this.isSender = isSender;
        this.isViewOnly = isViewOnly;
        this.parcels = new ArrayList<>();
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getAdmin() {
        return isAdmin;
    }

    public Boolean getSender() {
        return isSender;
    }

    public Boolean getViewOnly() {
        return isViewOnly;
    }

    public void setAdmin(Boolean admin) {
        isAdmin = admin;
    }

    public void setSender(Boolean sender) {
        isSender = sender;
    }

    public void setViewOnly(Boolean viewOnly) {
        isViewOnly = viewOnly;
    }

    public Integer getId() {
        return id;
    }

    public List<Parcel> getParcels() {
        return parcels;
    }

    public void setParcels(List<Parcel> parcels) {
        this.parcels = parcels;
    }

    public void addParcel(Parcel parcel) {
        parcels.add(parcel);
    }

    public void removeParcel(Parcel parcel) {
        parcels.remove(parcel);
    }

    public void clearParcels() {
        parcels.clear();
    }

    public void setId(Integer integer) {
        this.id = integer;
    }
}
