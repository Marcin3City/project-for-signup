package pl.test.projectforsignup.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import pl.test.projectforsignup.models.UserClass;
import pl.test.projectforsignup.models.UserRoles;
import pl.test.projectforsignup.services.UserService;

public class AddUsersClass {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserService userService;


    @EventListener(ApplicationReadyEvent.class)
    public void addUsersToDatabase() {
        UserClass userClass = new UserClass();
        userClass.setUserName("test_user");
        userClass.setPassword(passwordEncoder.encode("test_user"));
        userClass.setUserRoles(UserRoles.USER);
        userService.addUser(userClass);
    }




}
