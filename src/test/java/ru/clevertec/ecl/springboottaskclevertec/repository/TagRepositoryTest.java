package ru.clevertec.ecl.springboottaskclevertec.repository;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import ru.clevertec.ecl.springboottaskclevertec.model.Tag;

import java.util.List;
import java.util.Optional;

@SpringBootTest(properties = {
        "spring.datasource.url=jdbc:h2:mem:testdb",
        "spring.datasource.username=sa",
        "spring.datasource.password=",
        "spring.jpa.show-sql=true"
}, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Transactional
@Sql(scripts = "/initTagDB.sql")
class TagRepositoryTest {
    @Autowired
    private TagRepository tagRepository;

    @Test
    void findByNameContains() {
        List<Tag> tags = tagRepository.findByNameContains("te");
        Assertions.assertTrue(tags.size() > 0);
    }

    @Test
    void findByName() {
        Optional<Tag> tag = tagRepository.findByName("test");
        Assertions.assertTrue(tag.isPresent());
    }

    @Test
    void save() {
        Tag tag = new Tag();
        tag.setName("test111");
        Tag result = tagRepository.save(tag);
        Assertions.assertNotNull(result.getId());
    }

    @Test
    void update() {
        Optional<Tag> tag = tagRepository.findByName("test");
        if (tag.isPresent()) {
            Tag tag1 = tag.get();
            tag1.setName("test678");
            Tag result = tagRepository.save(tag1);
            Assertions.assertEquals(result, tag1);
        }
        Assertions.fail();
    }
}
