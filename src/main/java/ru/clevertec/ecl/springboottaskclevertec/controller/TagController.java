package ru.clevertec.ecl.springboottaskclevertec.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.clevertec.ecl.springboottaskclevertec.dto.TagDto;
import ru.clevertec.ecl.springboottaskclevertec.service.TagService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/tag")
@RequiredArgsConstructor
public class TagController {
    private final TagService tagService;


    @GetMapping(value = "/find-by-name/{name}")
    public ResponseEntity<TagDto> findByName(@PathVariable(value = "name") String name) {
        Optional<TagDto> tagOptional = tagService.findByName(name);
        return tagOptional.map(tag -> new ResponseEntity<>(tag, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


    @GetMapping(value = "/find-by-name-contains/{name}")
    public ResponseEntity<List<TagDto>> findByNameContains(@PathVariable(value = "name") String name) {
        return new ResponseEntity<>(tagService.findByNameContains(name), HttpStatus.OK);
    }


    @PostMapping(value = "/save")
    public ResponseEntity<TagDto> save(@RequestBody TagDto tagDto) {
        return new ResponseEntity<>(tagService.save(tagDto), HttpStatus.CREATED);
    }


    @DeleteMapping(value = "/remove")
    public ResponseEntity remove(@RequestBody TagDto tagDto) {
        tagService.remove(tagDto);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @PutMapping(value = "/update")
    public ResponseEntity<TagDto> update(@RequestBody TagDto tagDto) {
        tagService.update(tagDto);
        return new ResponseEntity<>(tagDto, HttpStatus.OK);
    }


    @GetMapping(value = "/popular")
    public ResponseEntity<String> findMostPopularTagName() {
        return new ResponseEntity<>(tagService.findMostPopularTag(), HttpStatus.OK);
    }
}