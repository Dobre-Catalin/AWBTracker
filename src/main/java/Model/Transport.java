package Model;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

enum blacklist{

}

enum whitelist{

}

@Entity
public class Transport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne
    Hub sourceHub;
    @OneToOne
    Hub destinationHub;
    LocalDateTime departureTime;
    Integer estimatedDurationHours;
    double estiamtedFuelUsage;
    @Nullable
    Integer intervalNext;
    String status;

}
