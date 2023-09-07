package top.meethigher.test.onetomany.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import top.meethigher.test.onetomany.Person;

public interface PersonRepository extends JpaRepository<Person,Integer> {
}
