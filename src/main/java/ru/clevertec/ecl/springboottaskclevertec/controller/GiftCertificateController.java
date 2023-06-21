package ru.clevertec.ecl.springboottaskclevertec.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.clevertec.ecl.springboottaskclevertec.dto.GiftCertificateDto;
import ru.clevertec.ecl.springboottaskclevertec.model.GiftCertificate;
import ru.clevertec.ecl.springboottaskclevertec.service.GiftCertificateService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/gift")
public class GiftCertificateController {
    private final GiftCertificateService giftCertificateService;

    @Autowired
    public GiftCertificateController(GiftCertificateService giftCertificateService) {
        this.giftCertificateService = giftCertificateService;
    }

    @PostMapping(value = "/save")
    public ResponseEntity<String> saveGiftCertificate(@RequestBody GiftCertificateDto giftCertificateDto) {
        giftCertificateService.save(giftCertificateDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @GetMapping(value = "/findByNameContains/{name}")
    public ResponseEntity<List<GiftCertificate>> findGiftCertificateByName(@PathVariable(value = "name")String name){
       return new ResponseEntity<>(giftCertificateService.findByNameContains(name),HttpStatus.OK);
    }
    @GetMapping(value = "/findByNameContainsOrderByNameAsc/{name}")
    public ResponseEntity<List<GiftCertificate>> findByNameContainsOrderByNameAsc(@PathVariable(value = "name") String nane){
        return new ResponseEntity<>(giftCertificateService.findByNameContainsOrderByNameAsc(nane),HttpStatus.OK);
    }
    @GetMapping(value = "/findByNameContainsOrderByNameDesc/{name}")
    public ResponseEntity<List<GiftCertificate>> findByNameContainsOrderByNameDesc(@PathVariable(value = "name")String name){
        return new ResponseEntity<>(giftCertificateService.findByDescriptionContainsOrderByCreateDateDesc(name),HttpStatus.OK);
    }
    @GetMapping(value = "/findByDescriptionContains/{description}")
    public ResponseEntity<List<GiftCertificate>> findByDescriptionContains(@PathVariable(value = "description") String description){
        return new ResponseEntity<>(giftCertificateService.findByDescriptionContains(description),HttpStatus.OK);
    }
    @GetMapping(value = "/findByDescriptionContainsOrderByCreateDateAsc/{description}")
    public ResponseEntity<List<GiftCertificate>> findByDescriptionContainsOrderByCreateDateAsc(@PathVariable(value = "description") String description){
        return new ResponseEntity<>(giftCertificateService.findByDescriptionContainsOrderByCreateDateAsc(description),HttpStatus.OK);
    }
    @GetMapping(value = "/findByDescriptionContainsOrderByCreateDateDesc/{description}")
    public ResponseEntity<List<GiftCertificate>>findByDescriptionContainsOrderByCreateDateDesc(@PathVariable(value = "description") String description){
        return new ResponseEntity<>(giftCertificateService.findByDescriptionContainsOrderByCreateDateDesc(description),HttpStatus.OK);
    }
    @GetMapping(value = "/findByName/{name}")
    public ResponseEntity<GiftCertificate> findByName(@PathVariable(value = "name") String name){
        Optional<GiftCertificate> giftCertificateOptional = giftCertificateService.findByName(name);
        return giftCertificateOptional.map(giftCertificate -> new ResponseEntity<>(giftCertificate, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @PutMapping(value = "/update")
    public ResponseEntity<GiftCertificate>update(@RequestBody GiftCertificateDto giftCertificateDto){
        return new ResponseEntity<>(giftCertificateService.save(giftCertificateDto),HttpStatus.OK);
    }
    @DeleteMapping(value = "/delete")
    public ResponseEntity delete(@RequestBody GiftCertificate giftCertificate){
        giftCertificateService.remove(giftCertificate);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
