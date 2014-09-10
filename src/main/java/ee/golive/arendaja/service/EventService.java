package ee.golive.arendaja.service;

import ee.golive.arendaja.model.Event;
import ee.golive.arendaja.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    public List<Event> getAll() {
        List<Event> events = (List<Event>) eventRepository.getList();

        return events;
    }

    public List<Event> getAllActive() {
        List<Event> events = (List<Event>) eventRepository.getList();
        return events;
    }

    public Event getById(Long id) {
        return eventRepository.findOne(id);
    }
}
