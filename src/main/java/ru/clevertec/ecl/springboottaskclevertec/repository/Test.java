package ru.clevertec.ecl.springboottaskclevertec.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Test {
    private final TagRepository tagRepository;
    @Autowired
    public Test(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    public void find(){
        System.out.println(tagRepository.findByNameContains("na"));
    }
}
