package ru.clevertec.ecl.springboottaskclevertec.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;



@Entity
@Data
@Table(name = "tag")
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String name;

    @ManyToMany(mappedBy = "tags",fetch = FetchType.EAGER)
    @JsonBackReference
    private List<GiftCertificate> giftCertificates;
}
