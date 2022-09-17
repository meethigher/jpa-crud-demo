package top.meethigher.entity.multipk;

import java.io.Serializable;
import java.util.Objects;

/**
 * 专业的联合主键
 *
 * @author chenchuancheng
 * @see [Jpa联合主键_P城执法官的博客-CSDN博客_jpa 联合主键](https://blog.csdn.net/qq_40192304/article/details/120143955)
 * @since 2022/9/13 16:13
 */
public class MajorMultiKey implements Serializable {

    private String schoolId;

    private String majorId;

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

    @Override
    public int hashCode() {
        return Objects.hash(schoolId, majorId);
    }

    @Override
    public boolean equals(Object key) {
        if (this == key) {
            return true;
        }
        if (key == null || getClass() != key.getClass()) {
            return false;
        }
        MajorMultiKey that = (MajorMultiKey) key;

        return Objects.equals(this.schoolId, that.schoolId) &&
                Objects.equals(this.majorId, that.majorId);
    }
}
