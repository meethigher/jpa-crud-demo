package top.meethigher.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import top.meethigher.entity.Major;
import top.meethigher.entity.multipk.MajorMultiKey;

/**
 * 专业Repository
 *
 * @author chenchuancheng
 * @since 2022/9/13 16:09
 */
public interface MajorRepository extends JpaRepository<Major, MajorMultiKey>,
        JpaSpecificationExecutor<Major> {
}
