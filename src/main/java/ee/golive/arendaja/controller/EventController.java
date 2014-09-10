package ee.golive.arendaja.controller;


import ee.golive.arendaja.model.Event;
import ee.golive.arendaja.repository.EventRepository;
import ee.golive.arendaja.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
public class EventController {

    @Autowired
    private EventService eventService;

    @Autowired
    private EventRepository eventRepository;

    @RequestMapping("/events")
    public ModelAndView eventList() {
        ModelAndView modelAndView = new ModelAndView("events");
        List<Event> events = eventService.getAllActive();
        modelAndView.addObject("events", events);
        return modelAndView;
    }

    @RequestMapping("/events/event/{someID}")
    public ModelAndView singleAd(@PathVariable(value="someID") Long id) {
        ModelAndView mv = new ModelAndView("single-event");
        Event event = eventRepository.findOne(id);
        mv.addObject("event", event);
        return mv;
    }

    @RequestMapping(value = "/events/new", method = RequestMethod.GET)
    public ModelAndView addNewAd() {
        return new ModelAndView("new-event", "event", new Event());
    }

    @RequestMapping(value = "/events/new", method = RequestMethod.POST)
    public ModelAndView saveAd (@Valid Event event, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ModelAndView("new-event", "event", event);
        }
        eventRepository.save(event);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("single-event");
        modelAndView.addObject("event", event);
        return modelAndView;
    }
}
