package ru.clevertec.ecl.springboottaskclevertec.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TagGiftCertificate {
    @Id
    private Long id;


    @ManyToOne
    @JoinColumn(name = "cert_id",referencedColumnName = "id")
    private GiftCertificate giftCertificate;


    @ManyToOne
    @JoinColumn(name = "tag_id",referencedColumnName = "id")
    private Tag tag;
}
