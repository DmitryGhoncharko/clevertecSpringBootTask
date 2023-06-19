package ru.clevertec.ecl.springboottaskclevertec.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.clevertec.ecl.springboottaskclevertec.model.GiftCertificate;
import ru.clevertec.ecl.springboottaskclevertec.model.Tag;
import ru.clevertec.ecl.springboottaskclevertec.repository.GiftCertificateRepository;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Component
public class Test {
    private final GiftCertificateService giftCertificateService;
    @Autowired
    public Test(GiftCertificateService giftCertificateService) {
        this.giftCertificateService = giftCertificateService;
    }

    public void rs() {
        Set<Tag> tags = new HashSet<>();
        tags.add(Tag.builder().name("test1").build());
        tags.add(Tag.builder().name("test45").build());
        giftCertificateService.save(GiftCertificate.builder().
                name("tes12t").
                description("descriptio21n3").
                duration(2).
                createDate(new Date()).
                lastUpdateDate(new Date()).
                tags(tags).
                build());
    }
}
