package ru.clevertec.ecl.springboottaskclevertec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.clevertec.ecl.springboottaskclevertec.model.Tag;
import ru.clevertec.ecl.springboottaskclevertec.service.TagService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/tag")
public class TagController {
    private final TagService tagService;
    @Autowired
    public TagController(TagService tagService) {
        this.tagService = tagService;
    }

    @GetMapping(value = "/findByName/{name}")
    public ResponseEntity<Tag> findByName(@PathVariable(value = "name") String name){
        Optional<Tag> tagOptional = tagService.findByName(name);
        return tagOptional.map(tag -> new ResponseEntity<>(tag, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @GetMapping(value = "/findByNameContains/{name}")
    public ResponseEntity<List<Tag>> findByNameContains(@PathVariable(value = "name") String name){
        return new ResponseEntity<>(tagService.findByNameContains(name),HttpStatus.OK);
    }
}