package ru.clevertec.ecl.springboottaskclevertec.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GiftCertificate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private Integer duration;
    @Column(nullable = false)
    private Date createDate;
    @Column(nullable = false)
    private Date lastUpdateDate;

    @OneToMany(mappedBy = "tag")
    private List<Tag> tags;
}
