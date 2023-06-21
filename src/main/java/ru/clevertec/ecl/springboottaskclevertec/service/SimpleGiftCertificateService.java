package ru.clevertec.ecl.springboottaskclevertec.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.clevertec.ecl.springboottaskclevertec.dto.GiftCertificateDto;
import ru.clevertec.ecl.springboottaskclevertec.exception.CannotFoundByIdError;
import ru.clevertec.ecl.springboottaskclevertec.model.GiftCertificate;
import ru.clevertec.ecl.springboottaskclevertec.model.Tag;
import ru.clevertec.ecl.springboottaskclevertec.repository.GiftCertificateRepository;
import ru.clevertec.ecl.springboottaskclevertec.repository.TagRepository;

import java.util.Date;
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
    public GiftCertificate save(GiftCertificateDto giftCertificateDto) {
        List<Tag> tagSet = giftCertificateDto.getTags();
        for (Tag tag : tagSet) {
            Optional<Tag> tagOptional = tagRepository.findByName(tag.getName());
            if (tagOptional.isPresent()) {
                Tag tagFromOptional = tagOptional.get();
                tagSet.remove(tag);
                tagSet.add(tagFromOptional);
            }
        }
        GiftCertificate giftCertificate = new GiftCertificate();
        giftCertificate.setName(giftCertificateDto.getName());
        giftCertificate.setDescription(giftCertificate.getDescription());
        giftCertificate.setPrice(giftCertificateDto.getPrice());
        giftCertificate.setCreateDate(new Date());
        giftCertificate.setLastUpdateDate(new Date());
        giftCertificate.setTags(tagSet);
        giftCertificate.setDuration(giftCertificateDto.getDuration());
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

    @Override
    public Optional<GiftCertificate> findByName(String name) {
        return giftCertificateRepository.findByName(name);
    }

    @Override
    public void remove(GiftCertificate giftCertificate) {
        giftCertificateRepository.delete(giftCertificate);
    }

    @Override
    @Transactional
    public GiftCertificate update(GiftCertificateDto giftCertificateDto) {
        Optional<GiftCertificate> giftCertificateOptional = giftCertificateRepository.findAllById(giftCertificateDto.getId());
        if (giftCertificateOptional.isPresent()) {
            GiftCertificate giftCertificate = new GiftCertificate();
            List<Tag> tagSet = giftCertificateDto.getTags();
            for (Tag tag : tagSet) {
                Optional<Tag> tagOptional = tagRepository.findByName(tag.getName());
                if (tagOptional.isPresent()) {
                    Tag tagFromOptional = tagOptional.get();
                    tagSet.remove(tag);
                    tagSet.add(tagFromOptional);
                }
            }
            giftCertificate.setName(giftCertificateDto.getName());
            giftCertificate.setDescription(giftCertificate.getDescription());
            giftCertificate.setPrice(giftCertificateDto.getPrice());
            giftCertificate.setLastUpdateDate(new Date());
            giftCertificate.setTags(tagSet);
            giftCertificate.setDuration(giftCertificateDto.getDuration());
            return giftCertificateRepository.save(giftCertificate);
        }
        throw new CannotFoundByIdError();
    }
}

