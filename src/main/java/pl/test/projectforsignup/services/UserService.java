package pl.test.projectforsignup.services;


import org.springframework.stereotype.Service;
import pl.test.projectforsignup.models.UserClass;
import pl.test.projectforsignup.repositories.UserRepository;

import java.util.List;

@Service
public class UserService {

    UserRepository userRepository;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserClass> getUsers(){
       return userRepository.findAll();
    }

    public UserClass addUser(UserClass userClass){
       return userRepository.save(userClass);
    }

    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }

    public UserClass updateUser(UserClass userClass){
        return userRepository.save(userClass);
    }

}
