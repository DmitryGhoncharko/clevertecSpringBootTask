package ru.clevertec.ecl.springboottaskclevertec;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import ru.clevertec.ecl.springboottaskclevertec.dto.GiftCertificateDto;
import ru.clevertec.ecl.springboottaskclevertec.model.GiftCertificate;
import ru.clevertec.ecl.springboottaskclevertec.repository.GiftCertificateRepository;
import ru.clevertec.ecl.springboottaskclevertec.service.GiftCertificateService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class GifCertificateTest {
    @Autowired
    private GiftCertificateService giftCertificateService;

    @MockBean
    private GiftCertificateRepository giftCertificateRepository;

    @Test
    void save(){
        GiftCertificate giftCertificate = new GiftCertificate();
        giftCertificate.setId(1L);
        giftCertificate.setDuration(2);
        giftCertificate.setPrice(22.2);
        giftCertificate.setName("test");
        GiftCertificateDto giftCertificateDto = GiftCertificateDto.builder().id(1L).duration(2).price(22.2).name("test").build();
        Mockito.when(giftCertificateRepository.save(giftCertificate)).thenReturn(giftCertificate);
        GiftCertificate result = giftCertificateService.save(giftCertificateDto);
        Assertions.assertEquals(giftCertificate,result);
    }
    @Test
    void findByNameContains(){
        GiftCertificate giftCertificate = new GiftCertificate();
        giftCertificate.setId(1L);
        giftCertificate.setDuration(2);
        giftCertificate.setPrice(22.2);
        giftCertificate.setName("test");
        List<GiftCertificate> giftCertificates = new ArrayList<>();
        giftCertificates.add(giftCertificate);
        Mockito.when(giftCertificateRepository.findByNameContains("test")).thenReturn(giftCertificates);
        List<GiftCertificate> result = giftCertificateService.findByNameContains("test");
        Assertions.assertEquals(result,giftCertificates);
    }
    @Test
    void findByNameContainsOrderByNameAsc(){
        GiftCertificate giftCertificate = new GiftCertificate();
        giftCertificate.setId(1L);
        giftCertificate.setDuration(2);
        giftCertificate.setPrice(22.2);
        giftCertificate.setName("test");
        List<GiftCertificate> giftCertificates = new ArrayList<>();
        giftCertificates.add(giftCertificate);
        Mockito.when(giftCertificateRepository.findByNameContainsOrderByNameAsc("test")).thenReturn(giftCertificates);
        List<GiftCertificate> result = giftCertificateService.findByNameContainsOrderByNameAsc("test");
        Assertions.assertEquals(result,giftCertificates);
    }
    @Test
    void findByNameContainsOrderByNameDesc(){
        GiftCertificate giftCertificate = new GiftCertificate();
        giftCertificate.setId(1L);
        giftCertificate.setDuration(2);
        giftCertificate.setPrice(22.2);
        giftCertificate.setName("test");
        List<GiftCertificate> giftCertificates = new ArrayList<>();
        giftCertificates.add(giftCertificate);
        Mockito.when(giftCertificateRepository.findByNameContainsOrderByNameDesc("test")).thenReturn(giftCertificates);
        List<GiftCertificate> result = giftCertificateService.findByNameContainsOrderByNameDesc("test");
        Assertions.assertEquals(result,giftCertificates);
    }
    @Test
    void findByDescriptionContains(){
        GiftCertificate giftCertificate = new GiftCertificate();
        giftCertificate.setId(1L);
        giftCertificate.setDuration(2);
        giftCertificate.setPrice(22.2);
        giftCertificate.setName("test");
        List<GiftCertificate> giftCertificates = new ArrayList<>();
        giftCertificates.add(giftCertificate);
        Mockito.when(giftCertificateRepository.findByDescriptionContains("test")).thenReturn(giftCertificates);
        List<GiftCertificate> result = giftCertificateService.findByDescriptionContains("test");
        Assertions.assertEquals(result,giftCertificates);
    }
    @Test
    void findByDescriptionContainsOrderByCreateDateAsc(){
        GiftCertificate giftCertificate = new GiftCertificate();
        giftCertificate.setId(1L);
        giftCertificate.setDuration(2);
        giftCertificate.setPrice(22.2);
        giftCertificate.setName("test");
        List<GiftCertificate> giftCertificates = new ArrayList<>();
        giftCertificates.add(giftCertificate);
        Mockito.when(giftCertificateRepository.findByDescriptionContainsOrderByCreateDateAsc("test")).thenReturn(giftCertificates);
        List<GiftCertificate> result = giftCertificateService.findByDescriptionContainsOrderByCreateDateAsc("test");
        Assertions.assertEquals(result,giftCertificates);
    }
    @Test
    void findByDescriptionContainsOrderByCreateDateDesc(){
        GiftCertificate giftCertificate = new GiftCertificate();
        giftCertificate.setId(1L);
        giftCertificate.setDuration(2);
        giftCertificate.setPrice(22.2);
        giftCertificate.setName("test");
        List<GiftCertificate> giftCertificates = new ArrayList<>();
        giftCertificates.add(giftCertificate);
        Mockito.when(giftCertificateRepository.findByDescriptionContainsOrderByCreateDateDesc("test")).thenReturn(giftCertificates);
        List<GiftCertificate> result = giftCertificateService.findByDescriptionContainsOrderByCreateDateDesc("test");
        Assertions.assertEquals(result,giftCertificates);
    }
    @Test
    void findByName(){
        GiftCertificate giftCertificate = new GiftCertificate();
        giftCertificate.setId(1L);
        giftCertificate.setDuration(2);
        giftCertificate.setPrice(22.2);
        giftCertificate.setName("test");
        Mockito.when(giftCertificateRepository.findByName("test")).thenReturn(Optional.of(giftCertificate));
        Optional<GiftCertificate> result = giftCertificateService.findByName("test");
        Assertions.assertEquals(result,giftCertificate);
    }
}
