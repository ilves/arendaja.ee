package ee.golive.arendaja.service;

import ee.golive.arendaja.model.User;
import ee.golive.arendaja.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User getById(Integer id) {
        return userRepository.findOne(id);
    }
}
