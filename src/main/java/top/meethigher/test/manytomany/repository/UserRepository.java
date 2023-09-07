package top.meethigher.test.manytomany.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import top.meethigher.test.manytomany.User;

public interface UserRepository extends JpaRepository<User,Integer> {
}
