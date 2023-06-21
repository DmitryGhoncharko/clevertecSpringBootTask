package ru.clevertec.ecl.springboottaskclevertec.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.clevertec.ecl.springboottaskclevertec.model.GiftCertificate;
import ru.clevertec.ecl.springboottaskclevertec.model.Tag;
import ru.clevertec.ecl.springboottaskclevertec.repository.GiftCertificateRepository;
import ru.clevertec.ecl.springboottaskclevertec.repository.TagRepository;

import java.util.List;
import java.util.Optional;
@Service
public class SimpleGiftCertificateService implements GiftCertificateService {
    private final GiftCertificateRepository giftCertificateRepository;
    private final TagRepository tagRepository;
    @Autowired
    public SimpleGiftCertificateService(GiftCertificateRepository giftCertificateRepository, TagRepository tagRepository) {
        this.giftCertificateRepository = giftCertificateRepository;
        this.tagRepository = tagRepository;
    }

    @Override
    @Transactional
    public GiftCertificate save(GiftCertificate giftCertificate) {
        List<Tag> tagSet = giftCertificate.getTags();
        for(Tag tag : tagSet){
            Optional<Tag> tagOptional = tagRepository.findByName(tag.getName());
            if(tagOptional.isPresent()){
                Tag tagFromOptional = tagOptional.get();
                tagSet.remove(tag);
                tagSet.add(tagFromOptional);
            }
        }
        return giftCertificateRepository.save(giftCertificate);
    }

    @Override
    public List<GiftCertificate> findByNameContains(String name) {
        return giftCertificateRepository.findByNameContains(name);
    }

    @Override
    public List<GiftCertificate> findByNameContainsOrderByNameAsc(String name) {
        return giftCertificateRepository.findByNameContainsOrderByNameAsc(name);
    }

    @Override
    public List<GiftCertificate> findByNameContainsOrderByNameDesc(String name) {
        return giftCertificateRepository.findByNameContainsOrderByNameDesc(name);
    }

    @Override
    public List<GiftCertificate> findByDescriptionContains(String name) {
        return giftCertificateRepository.findByDescriptionContains(name);
    }

    @Override
    public List<GiftCertificate> findByDescriptionContainsOrderByCreateDateAsc(String name) {
        return giftCertificateRepository.findByDescriptionContainsOrderByCreateDateAsc(name);
    }

    @Override
    public List<GiftCertificate> findByDescriptionContainsOrderByCreateDateDesc(String name) {
        return giftCertificateRepository.findByDescriptionContainsOrderByCreateDateDesc(name);
    }
}

