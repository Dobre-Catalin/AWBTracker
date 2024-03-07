package Model;

import jakarta.persistence.*;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.ArrayList;
import java.util.List;

enum Permissions {
    VIEWONLY,
    SENDER,
    RECEIVER,
    PARCELADMIN,
    USERADMIN
}

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    String email;
    String password;
    Permissions permissions;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Parcel> parcels = new ArrayList<>();

    public User(){

    }

    public User(String email, String password, String permissions, List<Parcel> parcels) {
        this.email = email;
        this.password = password;
        ///set permissions based on string
        this.setPermissions(permissions);
        this.parcels = parcels;
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

    Boolean isAdmin(){
        return permissions == Permissions.USERADMIN;
    }

    Boolean isParcelAdmin(){
        return permissions == Permissions.PARCELADMIN;
    }

    Boolean isSender(){
        return permissions == Permissions.SENDER;
    }

    Boolean isReceiver(){
        return permissions == Permissions.RECEIVER;
    }

    Boolean isViewOnly(){
        return permissions == Permissions.VIEWONLY;
    }

    public void setPermissions(String permissions) {
        if(permissions.contains("VIEWONLY")){
            this.permissions = Permissions.VIEWONLY;
        }
        else if(permissions.contains("SENDER")){
            this.permissions = Permissions.SENDER;
        }
        else if(permissions.contains("RECEIVER")){
            this.permissions = Permissions.RECEIVER;
        }
        else if(permissions.contains("PARCELADMIN")){
            this.permissions = Permissions.PARCELADMIN;
        }
        else if(permissions.contains("USERADMIN")){
            this.permissions = Permissions.USERADMIN;
        }
    }

public void setPermissions(Permissions permissions) {
        this.permissions = permissions;
    }

    public void setParcels(List<Parcel> parcels) {
        this.parcels = parcels;
    }

    public List<Parcel> getParcels() {
        return parcels;
    }
}
