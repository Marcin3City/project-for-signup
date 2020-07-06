package pl.test.projectforsignup.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;


// TODO: no todo actually, made it to make sure security works on credentials
@RestController
public class TestController {

// tojest test czy działa

    @GetMapping("/")
    public String sayHi() {
        return "Hi";
    }


    @RequestMapping(method = RequestMethod.OPTIONS, path ="/options")
    public ResponseEntity tellMeOptions(HttpServletResponse response){
        response.setHeader("Allow", "POST, PUT, GET, DELETE");
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
