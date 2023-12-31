package startline.server.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import startline.server.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepositoryInterface extends JpaRepository<User, String> {
    Optional<User> findByUsername(String username);
    Optional<String> findUsernameByUsername(String usename);

    @Query("SELECT u.isEnabled FROM User u WHERE u.username = :username")
    boolean checkUserEnableStatus(@Param("username") String username);
    @Modifying
    @Query("UPDATE User u SET u.isEnabled = :status WHERE u.username = :username")
    void changeUserEnableStatus(@Param("username") String username, @Param("status") boolean status);
}
