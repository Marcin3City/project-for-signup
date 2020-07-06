package pl.test.projectforsignup.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import pl.test.projectforsignup.models.UserClass;
import pl.test.projectforsignup.models.UserRoles;
import pl.test.projectforsignup.repositories.UserRepository;

@SpringBootTest
class UserClassRepositoryTest {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Test
    void testAddUserMethod() {
        UserClass userClass = new UserClass();
        userClass.setUserName("anotherone");
        userClass.setPassword(passwordEncoder.encode("anotherone"));
        userClass.setUserRoles(UserRoles.USER);
        userRepository.save(userClass);
    }


    @Test
    void testDeleteUserMethod() {
        userRepository.deleteById(userRepository.findAll().get(0).getId());
    }

    @Test
    void testUpdateUserMethod() {

    }

    @Test
    void testGetUserMethod() {

    }


}