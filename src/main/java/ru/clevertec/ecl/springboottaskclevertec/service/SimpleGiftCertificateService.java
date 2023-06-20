package ru.clevertec.ecl.springboottaskclevertec.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.clevertec.ecl.springboottaskclevertec.model.GiftCertificate;
import ru.clevertec.ecl.springboottaskclevertec.model.Tag;
import ru.clevertec.ecl.springboottaskclevertec.repository.GiftCertificateRepository;
import ru.clevertec.ecl.springboottaskclevertec.repository.TagRepository;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

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
        Set<Tag> tagSet = giftCertificate.getTags();
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
    public Set<GiftCertificate> findByNameContains(String name) {
        return giftCertificateRepository.findByNameContains(name);
    }

    @Override
    public Set<GiftCertificate> findByNameContainsOrderByNameAsc(String name) {
        return giftCertificateRepository.findByNameContainsOrderByNameAsc(name);
    }

    @Override
    public Set<GiftCertificate> findByNameContainsOrderByNameDesc(String name) {
        return giftCertificateRepository.findByNameContainsOrderByNameDesc(name);
    }

    @Override
    public Set<GiftCertificate> findByDescriptionContains(String name) {
        return giftCertificateRepository.findByDescriptionContains(name);
    }

    @Override
    public Set<GiftCertificate> findByDescriptionContainsOrderByCreateDateAsc(String name) {
        return giftCertificateRepository.findByDescriptionContainsOrderByCreateDateAsc(name);
    }

    @Override
    public Set<GiftCertificate> findByDescriptionContainsOrderByCreateDateDesc(String name) {
        return giftCertificateRepository.findByDescriptionContainsOrderByCreateDateDesc(name);
    }
}

