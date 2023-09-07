package top.meethigher.test.onetomany.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import top.meethigher.test.onetomany.Unit;

public interface UnitRepository extends JpaRepository<Unit, Integer> {
}
