package ru.clevertec.ecl.springboottaskclevertec.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.clevertec.ecl.springboottaskclevertec.model.GiftCertificate;
import ru.clevertec.ecl.springboottaskclevertec.service.GiftCertificateService;

@RestController
@RequestMapping(name = "/gift")
public class GiftCertificateController {
    private final GiftCertificateService giftCertificateService;

    @Autowired
    public GiftCertificateController(GiftCertificateService giftCertificateService) {
        this.giftCertificateService = giftCertificateService;
    }

    @PostMapping(name = "/save")
    public ResponseEntity<String> saveGiftCertificate(@RequestBody GiftCertificate giftCertificate) {
        giftCertificateService.save(giftCertificate);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
