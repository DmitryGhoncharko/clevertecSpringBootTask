package ru.clevertec.ecl.springboottaskclevertec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.clevertec.ecl.springboottaskclevertec.dto.TagDto;
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

    /**
     *
     * @param name fint ta by name
     * @return
     */
    @GetMapping(value = "/findByName/{name}")
    public ResponseEntity<TagDto> findByName(@PathVariable(value = "name") String name){
        Optional<TagDto> tagOptional = tagService.findByName(name);
        return tagOptional.map(tag -> new ResponseEntity<>(tag, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /**
     *
     * @param name find tag by name contains
     * @return
     */
    @GetMapping(value = "/findByNameContains/{name}")
    public ResponseEntity<List<TagDto>> findByNameContains(@PathVariable(value = "name") String name){
        return new ResponseEntity<>(tagService.findByNameContains(name),HttpStatus.OK);
    }

    /**
     *
     * @param tagDto save tag
     * @return
     */
    @PostMapping(value = "/save")
    public ResponseEntity<TagDto> save(@RequestBody TagDto tagDto) {
        return new ResponseEntity<>(tagService.save(tagDto), HttpStatus.CREATED);
    }

    /**
     *
     * @param tagDto remove tag
     * @return
     */
    @DeleteMapping(value = "/remove")
    public ResponseEntity remove(@RequestBody TagDto tagDto){
        tagService.remove(tagDto);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /**
     *
     * @param tagDto update tag
     * @return
     */
    @PutMapping(value = "/update")
    public ResponseEntity<TagDto> update(@RequestBody TagDto tagDto){
        tagService.update(tagDto);
        return new ResponseEntity<>(tagDto,HttpStatus.OK);
    }

    /**
     * get most popular tag
     * @return
     */
    @GetMapping(value = "/popular")
    public ResponseEntity<Tag> findMostPopularTag(){
        return new ResponseEntity<>(tagService.findMostPopularTag(),HttpStatus.OK);
    }
}