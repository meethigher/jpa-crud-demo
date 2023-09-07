package top.meethigher.test;

import java.util.HashSet;

import org.springframework.transaction.annotation.Transactional;
import top.meethigher.test.manytomany.Role;
import top.meethigher.test.manytomany.User;
import top.meethigher.test.onetomany.Person;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import top.meethigher.test.manytomany.repository.RoleRepository;
import top.meethigher.test.manytomany.repository.UserRepository;
import top.meethigher.test.onetomany.Unit;
import top.meethigher.test.onetomany.repository.PersonRepository;
import top.meethigher.test.onetomany.repository.UnitRepository;

import javax.annotation.Resource;

@Component
public class InitRunner implements CommandLineRunner {

    @Resource
    RoleRepository roleRepository;

    @Resource
    UserRepository userRepository;

    @Resource
    PersonRepository personRepository;

    @Resource
    UnitRepository unitRepository;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void run(String... args) throws Exception {
        Unit unit = new Unit();
        unit.setUnitName("测试部门");
        unit.setUnitAddress("北京");
        unit.getPersons().add(new Person("小明", "北京", unit));
        unit.getPersons().add(new Person("小红", "上海", unit));


        unitRepository.save(unit);

        Unit unit1 = new Unit();
        unit1.setUnitName("无人部门");
        unit1.setUnitAddress("上海");
        unitRepository.save(unit1);

        Role role1 = new Role("角色1");
        Role role2 = new Role("角色2");
        User user1 = new User("大明", 10);
        user1.getRoles().add(role1);
        user1.getRoles().add(role2);
        User user2 = new User("大白", 10);
        user2.getRoles().add(role2);

        userRepository.save(user1);
        userRepository.save(user2);
    }
}
