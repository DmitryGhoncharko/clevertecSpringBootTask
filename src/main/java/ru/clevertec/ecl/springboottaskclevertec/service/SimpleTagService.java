package ru.clevertec.ecl.springboottaskclevertec.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.clevertec.ecl.springboottaskclevertec.dto.TagDto;
import ru.clevertec.ecl.springboottaskclevertec.exception.DuplicateNameError;
import ru.clevertec.ecl.springboottaskclevertec.model.Tag;
import ru.clevertec.ecl.springboottaskclevertec.repository.TagRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SimpleTagService implements TagService {
    private final TagRepository tagRepository;

    @Autowired
    public SimpleTagService(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    @Override
    public Optional<TagDto> findByName(String name) {
        Optional<Tag> tagOptional = tagRepository.findByName(name);
        return tagOptional.map(tag -> TagDto.builder().id(tag.getId()).name(tag.getName()).build());
    }

    @Override
    public List<TagDto> findByNameContains(String name) {
        List<Tag> tags = tagRepository.findByNameContains(name);
        List<TagDto> tagDtos = new ArrayList<>();
        tags.forEach(tag -> tagDtos.add(TagDto.builder().id(tag.getId()).name(tag.getName()).build()));
        return tagDtos;
    }

    @Override
    public TagDto save(TagDto tagDto) {
        if (tagRepository.findByName(tagDto.getName()).isPresent()) {
            throw new DuplicateNameError();
        }
        Tag tag = new Tag();
        tag.setName(tagDto.getName());
        tag = tagRepository.save(tag);
        return TagDto.builder().id(tag.getId()).name(tag.getName()).build();
    }

    @Override
    public void remove(TagDto tagDto) {
        Tag tag = new Tag();
        tag.setId(tagDto.getId());
        tag.setName(tagDto.getName());
        tagRepository.delete(tag);
    }

    @Override
    public TagDto update(TagDto tagDto) {
        Tag tag = new Tag();
        tag.setId(tagDto.getId());
        tag.setName(tagDto.getName());
        tagRepository.save(tag);
        return tagDto;
    }

    @Override
    public String findMostPopularTag() {
        return tagRepository.findMostPopularTagName();
    }
}
