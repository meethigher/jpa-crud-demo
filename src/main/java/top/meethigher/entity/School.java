package top.meethigher.entity;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import java.lang.reflect.Field;
import java.util.Date;

/**
 * 学校
 *
 * @author chenchuancheng
 * @since 2022/9/13 15:37
 */
@Entity
@EntityListeners(AuditingEntityListener.class)
public class School {

    @Id
    private String schoolId;

    private String schoolName;

    /**
     * jpa会自动将枚举，入库时存成整型，取时转为枚举
     */
    private SchoolState schoolState;

    private Date createTime;

    public String getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(String schoolId) {
        this.schoolId = schoolId;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public SchoolState getSchoolState() {
        return schoolState;
    }

    public void setSchoolState(SchoolState schoolState) {
        this.schoolState = schoolState;
    }

}
