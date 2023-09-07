package top.meethigher.test.onetomany;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="t_unit")
public class Unit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "unit_id")
    private Integer unitId;
    @Column(name = "unit_name")
    private String unitName;
    @Column(name="unit_address")
    private String unitAddress;

    //配置单位和员工的关系，一对多
    @OneToMany(targetEntity = Person.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "p_u_id",referencedColumnName = "unit_id")
//    @OneToMany(mappedBy = "unit")//放弃对外键的维护权
    private Set<Person> persons=new HashSet<>();


    public Integer getUnitId() {
        return unitId;
    }

    public void setUnitId(Integer unitId) {
        this.unitId = unitId;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public String getUnitAddress() {
        return unitAddress;
    }

    public void setUnitAddress(String unitAddress) {
        this.unitAddress = unitAddress;
    }

    public Set<Person> getPersons() {
        return persons;
    }

    public void setPersons(Set<Person> persons) {
        this.persons = persons;
    }
}
