package ee.golive.arendaja.repository;


import ee.golive.arendaja.model.Ad;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface AdRepository extends PagingAndSortingRepository<Ad, Long> {
    List<Ad> findByActiveOrderByDateCreatedDesc(String active);
}
