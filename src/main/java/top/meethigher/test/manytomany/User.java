package top.meethigher.test.manytomany;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name ="user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_id")
    private Integer userId;
    @Column(name="user_name")
    private String userName;
    @Column(name="user_age")
    private Integer userAge;

    @ManyToMany(targetEntity = Role.class,cascade = CascadeType.ALL)
    @JoinTable(name="user_role",
            joinColumns = {@JoinColumn(name ="user_id",referencedColumnName = "user_id")},
            inverseJoinColumns = {@JoinColumn(name="role_id",referencedColumnName = "role_id")})
    private Set<Role> roles=new HashSet<>();

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getUserAge() {
        return userAge;
    }

    public void setUserAge(Integer userAge) {
        this.userAge = userAge;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public User(String userName, Integer userAge) {
        this.userName = userName;
        this.userAge = userAge;
    }

    public User() {
    }
}
