package pl.example.equipy.components.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByPesel(String pesel);
    List<User> findAllByLastNameContainingIgnoreCase(String lastName);
}