package top.meethigher.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import top.meethigher.entity.School;

import java.util.List;
import java.util.Set;

/**
 * 学校Repository
 *
 * @author chenchuancheng
 * @since 2022/9/13 16:08
 */
public interface SchoolRepository extends JpaRepository<School,String>,
        JpaSpecificationExecutor<School> {


    @Query(nativeQuery = true,value="select school_id from school where school_name=:schoolName and school_id <> coalesce (:schoolId,'')")
    Set<String> duplicateNameCheck(@Param("schoolId") String schoolId,@Param("schoolName") String schoolName);

    List<School> findBySchoolNameLikeOrSchoolId(String likeName,String equalId);

}
