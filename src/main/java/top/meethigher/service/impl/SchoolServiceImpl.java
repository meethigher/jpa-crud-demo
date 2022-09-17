package top.meethigher.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import top.meethigher.entity.School;
import top.meethigher.repository.SchoolRepository;
import top.meethigher.service.SchoolService;
import top.meethigher.utils.IdGenerate;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;
import java.util.Set;

/**
 * 学校
 *
 * @author chenchuancheng
 * @since 2022/9/13 16:54
 */
@Service
public class SchoolServiceImpl implements SchoolService {

    @Resource
    private SchoolRepository schoolRepository;

    /**
     * 校验名称是否重复
     *
     * @param schoolId   学校编号
     * @param schoolName 学校名称
     */
    private void checkNameRepeat(String schoolId, String schoolName) {
        Set<String> set = schoolRepository.duplicateNameCheck(schoolId, schoolName);
        if (!ObjectUtils.isEmpty(set)) {
            throw new IllegalArgumentException(String.format("编号%s的学校名称%s与编号%s的名称重复", schoolId, schoolName, set));
        }
    }


    /**
     * 通过id进行校验是否存在
     *
     * @param schoolId 学校编号
     */
    private School verifyById(String schoolId) {
        Optional<School> optional = schoolRepository.findById(schoolId);
        if (!optional.isPresent()) {
            throw new IllegalArgumentException(String.format("编号为%s的学校不存在", schoolId));
        }
        return optional.get();
    }

    @Override
    public void addSchool(School school) {
        checkNameRepeat(null, school.getSchoolName());
        school.setSchoolId(IdGenerate.nextId());
        schoolRepository.saveAndFlush(school);
    }

    @Override
    public void updateSchool(School school) {
        verifyById(school.getSchoolId());
        checkNameRepeat(school.getSchoolId(), school.getSchoolName());
        schoolRepository.save(school);
    }

    @Override
    public void deleteSchool(String schoolId) {
        verifyById(schoolId);
        schoolRepository.deleteById(schoolId);
    }

    @Override
    public List<School> search(String keywords) {
        return schoolRepository.findBySchoolNameLikeOrSchoolId(keywords, keywords);
    }
}
