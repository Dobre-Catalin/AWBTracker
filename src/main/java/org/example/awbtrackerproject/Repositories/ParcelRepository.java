package org.example.awbtrackerproject.Repositories;

import org.example.awbtrackerproject.Model.Parcel.Parcel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParcelRepository extends JpaRepository<Parcel, Integer> {
}
