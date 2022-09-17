package top.meethigher.entity;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import top.meethigher.entity.multipk.MajorMultiKey;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.util.Date;

/**
 * 专业
 *
 * @author chenchuancheng
 * @since 2022/9/13 15:39
 */
@Entity
@EntityListeners(AuditingEntityListener.class)
@IdClass(MajorMultiKey.class)
public class Major {

    @Id
    private String schoolId;

    @Id
    private String majorId;

    private String majorName;

    private Date createTime;

    public String getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(String schoolId) {
        this.schoolId = schoolId;
    }

    public String getMajorId() {
        return majorId;
    }

    public void setMajorId(String majorId) {
        this.majorId = majorId;
    }

    public String getMajorName() {
        return majorName;
    }

    public void setMajorName(String majorName) {
        this.majorName = majorName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
