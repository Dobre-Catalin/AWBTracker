package org.example.awbtrackerproject.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jdk.jfr.Enabled;

@Entity
public class Test{
    String test;
    @Id
    private Long id;

    public Test(String test) {
        this.test = test;
    }

    public Test() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
