package ca.ucareer.computerfactory.model.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

    @Query("select u from User u where u.username = :user")
    /** tips: user Optional<User> here then you can use .orElse() in UserService */
    public Optional<User> findByUsername(@Param("user") String username);
}