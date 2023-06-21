package ru.clevertec.ecl.springboottaskclevertec;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import ru.clevertec.ecl.springboottaskclevertec.dto.TagDto;
import ru.clevertec.ecl.springboottaskclevertec.model.Tag;
import ru.clevertec.ecl.springboottaskclevertec.repository.TagRepository;
import ru.clevertec.ecl.springboottaskclevertec.service.TagService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class TagServiceTest {
    @Autowired
    TagService tagService;
    @MockBean
    TagRepository tagRepository;

    @Test
    void findByName(){
        Tag tag = new Tag();
        tag.setName("test");
        tag.setId(1L);
        TagDto tagDto = TagDto.builder().id(1L).name("test").build();
        Mockito.when(tagRepository.findByName("test")).thenReturn(Optional.of(tag));
        Optional<TagDto> result = tagService.findByName("test");
        Assertions.assertEquals(result,Optional.of(tagDto));
    }
    @Test
    void findByNameContains(){
        Tag tag = new Tag();
        tag.setName("test");
        tag.setId(1L);
        List<Tag> tags = new ArrayList<>();
        tags.add(tag);
        TagDto tagDto = TagDto.builder().id(1L).name("test").build();
        List<TagDto> tagDtos = new ArrayList<>();
        tagDtos.add(tagDto);
        Mockito.when(tagRepository.findByNameContains("test")).thenReturn(tags);
        List<TagDto> result = tagService.findByNameContains("test");
        Assertions.assertEquals(result,tagDtos);
    }
    @Test
    void save(){
        Tag tag = new Tag();
        tag.setName("test");
        tag.setId(1L);
        TagDto tagDto = TagDto.builder().id(1L).name("test").build();
        Mockito.when(tagRepository.save(tag)).thenReturn(tag);
        TagDto result = tagService.save(tagDto);
        Assertions.assertEquals(result,tagDto);
    }
    @Test
    void update(){
        Tag tag = new Tag();
        tag.setName("test");
        tag.setId(1L);
        TagDto tagDto = TagDto.builder().id(1L).name("test").build();
        Mockito.when(tagRepository.save(tag)).thenReturn(tag);
        TagDto result = tagService.update(tagDto);
        Assertions.assertEquals(result,tagDto);
    }
    @Test
    void findMostPopularTag(){
        Tag tag = new Tag();
        tag.setName("test");
        tag.setId(1L);
        Mockito.when(tagRepository.findMostPopularTag()).thenReturn(tag);
        Tag result = tagService.findMostPopularTag();
        Assertions.assertEquals(result,tag);
    }
}
