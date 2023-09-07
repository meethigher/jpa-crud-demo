package top.meethigher.test.manytomany.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import top.meethigher.test.manytomany.Role;

public interface RoleRepository extends JpaRepository<Role,Integer> {
}
