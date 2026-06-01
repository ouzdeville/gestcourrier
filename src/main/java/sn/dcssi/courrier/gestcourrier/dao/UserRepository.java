package sn.dcssi.courrier.gestcourrier.dao;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sn.dcssi.courrier.gestcourrier.entity.Role;
import sn.dcssi.courrier.gestcourrier.entity.User;

public interface  UserRepository extends JpaRepository<User, Long> {
    // Spring génère : SELECT * FROM users WHERE email = ?
    User findByEmail(String email);
    User findByUsername(String username);

        // SELECT * FROM users WHERE username = ? AND enabled = ?
    Optional<User> findByUsernameAndEnabled(String username, boolean enabled);
 
    // SELECT * FROM users WHERE role = ?
    List<User> findByRole(Role role);
 
    // Vérification existence
    boolean existsByEmail(String email);
    boolean existsByUsername(String username);
 
    // Requête JPQL personnalisée (objet Java, pas SQL)
    @Query("SELECT u FROM User u WHERE u.createdAt > :date AND u.enabled = true")
    List<User> findActiveUsersCreatedAfter(@Param("date") LocalDateTime date);
 
    // Requête native SQL (utiliser avec précaution)
    @Query(value = "SELECT * FROM users WHERE LOWER(email) = LOWER(:email)",
           nativeQuery = true)
    Optional<User> findByEmailIgnoreCase(@Param("email") String email);
 
    // Pagination et tri intégrés
    Page<User> findByRole(Role role, Pageable pageable);  



}
