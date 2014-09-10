package ee.golive.arendaja.repository;


import ee.golive.arendaja.model.Event;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface EventRepository extends PagingAndSortingRepository<Event, Long> {
    @Query("SELECT e FROM Event e WHERE dateStart > NOW() AND active = 1 ORDER BY e.dateStart ASC")
    public List<Event> getList();
}
