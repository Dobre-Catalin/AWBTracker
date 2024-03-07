package Model;

import jakarta.persistence.*;

@Entity
public class Hub {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    String zipcode;
    String address;

    @ManyToOne
    @JoinColumn(name = "hub_id", nullable = false)
    private Hub hub;

    public Hub(){

    }

    public Hub(String zipcode, String address){
        this.zipcode = zipcode;
        this.address=address;
    }

    public String getZipcode(){
        return this.zipcode;
    }

    public String getAddress(){
        return this.address;
    }
}
