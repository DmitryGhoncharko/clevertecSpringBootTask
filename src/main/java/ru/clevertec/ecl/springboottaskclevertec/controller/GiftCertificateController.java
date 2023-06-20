package ru.clevertec.ecl.springboottaskclevertec.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.clevertec.ecl.springboottaskclevertec.model.GiftCertificate;
import ru.clevertec.ecl.springboottaskclevertec.service.GiftCertificateService;

import java.util.Set;

@RestController
@RequestMapping(value = "/gift")
public class GiftCertificateController {
    private final GiftCertificateService giftCertificateService;

    @Autowired
    public GiftCertificateController(GiftCertificateService giftCertificateService) {
        this.giftCertificateService = giftCertificateService;
    }

    @PostMapping(value = "/save")
    public ResponseEntity<String> saveGiftCertificate(@RequestBody GiftCertificate giftCertificate) {
        giftCertificateService.save(giftCertificate);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @GetMapping(value = "/findByNameContains/{name}")
    public ResponseEntity<Set<GiftCertificate>> findGiftCertificateByName(@PathVariable(value = "name")String name){
       return new ResponseEntity<>(giftCertificateService.findByNameContains(name),HttpStatus.OK);
    }
    @GetMapping(value = "/findByNameContainsOrderByNameAsc/{name}")
    public ResponseEntity<Set<GiftCertificate>> findByNameContainsOrderByNameAsc(@PathVariable(value = "name") String nane){
        return new ResponseEntity<>(giftCertificateService.findByNameContainsOrderByNameAsc(nane),HttpStatus.OK);
    }
    @GetMapping(value = "/findByNameContainsOrderByNameDesc/{name}")
    public ResponseEntity<Set<GiftCertificate>> findByNameContainsOrderByNameDesc(@PathVariable(value = "name")String name){
        return new ResponseEntity<>(giftCertificateService.findByDescriptionContainsOrderByCreateDateDesc(name),HttpStatus.OK);
    }
    @GetMapping(value = "/findByDescriptionContains/{description}")
    public ResponseEntity<Set<GiftCertificate>> findByDescriptionContains(@PathVariable(value = "description") String description){
        return new ResponseEntity<>(giftCertificateService.findByDescriptionContains(description),HttpStatus.OK);
    }
    @GetMapping(value = "/findByDescriptionContainsOrderByCreateDateAsc/{description}")
    public ResponseEntity<Set<GiftCertificate>> findByDescriptionContainsOrderByCreateDateAsc(@PathVariable(value = "description") String description){
        return new ResponseEntity<>(giftCertificateService.findByDescriptionContainsOrderByCreateDateAsc(description),HttpStatus.OK);
    }
    @GetMapping(value = "/findByDescriptionContainsOrderByCreateDateDesc/{description}")
    public ResponseEntity<Set<GiftCertificate>>findByDescriptionContainsOrderByCreateDateDesc(@PathVariable(value = "description") String description){
        return new ResponseEntity<>(giftCertificateService.findByDescriptionContainsOrderByCreateDateDesc(description),HttpStatus.OK);
    }
}
