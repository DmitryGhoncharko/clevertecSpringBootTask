package ru.clevertec.ecl.springboottaskclevertec.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.clevertec.ecl.springboottaskclevertec.model.Tag;
import ru.clevertec.ecl.springboottaskclevertec.repository.TagRepository;

import java.util.Optional;
import java.util.Set;

@Service
public class SimpleTagService implements TagService{
    private final TagRepository tagRepository;
    @Autowired
    public SimpleTagService(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    @Override
    public Optional<Tag> findByName(String name) {
        return tagRepository.findByName(name);
    }

    @Override
    public Set<Tag> findByNameContains(String name) {
        return tagRepository.findByNameContains(name);
    }
}
