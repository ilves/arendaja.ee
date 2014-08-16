package ee.golive.arendaja.service;

import ee.golive.arendaja.model.Ad;
import ee.golive.arendaja.repository.AdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AdService {

    @Autowired
    private AdRepository adRepository;

    public List<Ad> getAll() {
        List<Ad> ads = (List<Ad>) adRepository.findAll(new Sort(Sort.Direction.DESC, "id"));
        return ads;
    }

    public List<Ad> getAllActive() {
        List<Ad> ads = (List<Ad>) adRepository.findByActiveOrderByDateCreatedDesc("1");
        return ads;
    }

    public Ad getById(Long id) {
        return adRepository.findOne(id);
    }
}
