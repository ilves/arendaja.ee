package ee.golive.arendaja.repository;


import ee.golive.arendaja.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {

}
