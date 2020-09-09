package ca.ucareer.computerfactory.model.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
/** do not forget <User, Integer>>*/
public interface UserRepository extends JpaRepository<User, Integer> {

    @Query("select u from User u where u.username = :user")
    public Optional<User> findUserByUsername(@Param("user") String username);

}
