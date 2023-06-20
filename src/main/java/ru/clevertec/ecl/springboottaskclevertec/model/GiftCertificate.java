package ru.clevertec.ecl.springboottaskclevertec.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import java.util.Date;
import java.util.Set;

@Entity
@DynamicUpdate
@Data
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

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "cert_tag",
            joinColumns = @JoinColumn(name = "gift_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    private Set<Tag> tags;
}
