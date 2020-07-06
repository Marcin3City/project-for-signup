package pl.test.projectforsignup;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import pl.test.projectforsignup.models.UserClass;
import pl.test.projectforsignup.models.UserRoles;
import pl.test.projectforsignup.services.UserService;

@SpringBootTest
@AutoConfigureMockMvc
public class EndpointTest {

    @Autowired
    private PasswordEncoder bCryptPassword;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UserService userService;


    // Todo: no loads just gonna make it simple
    @Test
    void postMappingUserTest() throws Exception {

        UserClass user = new UserClass();
        user.setUserName("admin");
        user.setUserRoles(UserRoles.USER);
        user.setPassword(bCryptPassword.encode("admin"));

        ObjectMapper mapper = new ObjectMapper();
        String data = mapper.writeValueAsString(user);

        mockMvc.perform(MockMvcRequestBuilders.post("/user").content(data).contentType(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().isOk());

    }

    @Test
    void getMappingUserTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/user")).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void deleteMappingUserTest() throws Exception {
        long id = userService.getUsers().get(0).getId();
        mockMvc.perform(MockMvcRequestBuilders.delete("/user/" + id)).andExpect(MockMvcResultMatchers.status().isOk());
    }
}
