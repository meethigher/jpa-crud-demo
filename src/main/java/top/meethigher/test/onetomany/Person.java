package top.meethigher.test.onetomany;

import javax.persistence.*;

@Entity
@Table(name = "t_person")
public class Person {
    @Id
    @Column(name="p_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer pId;
    @Column(name="person_name")
    private String personName;
    @Column(name="person_address")
    private String personAddress;

    //配置个人和单位的多对一关系
    @ManyToOne(targetEntity = Unit.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "p_u_id",referencedColumnName = "unit_Id")
    private Unit unit;

    public Person() {

    }

    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }


    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getPersonAddress() {
        return personAddress;
    }

    public void setPersonAddress(String personAddress) {
        this.personAddress = personAddress;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    public Person(String personName, String personAddress, Unit unit) {
        this.personName = personName;
        this.personAddress = personAddress;
        this.unit = unit;
    }

    public Person(String personName, String personAddress) {
        this.personName = personName;
        this.personAddress = personAddress;
    }
}
