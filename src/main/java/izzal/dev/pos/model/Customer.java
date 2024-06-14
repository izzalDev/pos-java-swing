package izzal.dev.pos.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @NoArgsConstructor
public class Customer {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String address;
    private String city;

    public Customer(String name, String address, String city){
        this.name = name;
        this.address = address;
        this.city = city;
    }

    public void setId(Long id){
        if (this.id == null) {
             this.id = id;
         } else {
             throw new IllegalStateException("ID can only be set once.");
         }
    }
}
