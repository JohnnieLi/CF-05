package ca.ucareer.computerfactory.controller;

import ca.ucareer.computerfactory.model.user.User;
import ca.ucareer.computerfactory.model.user.UserService;
import ca.ucareer.computerfactory.response.LoginRequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ca.ucareer.computerfactory.response.ResponseBody;

@RestController
@RequestMapping("/v1")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/login")
    public ResponseEntity<ResponseBody> login(@RequestBody LoginRequestBody loginRequestBody){
        try{
            System.out.println("hello");
            String token = userService.userLogin(loginRequestBody);
            System.out.println(token);
            ResponseBody responseBody = new ResponseBody(token, "", null);
            return ResponseEntity.ok(responseBody);
        }
        catch(Exception exception){
            ResponseBody responseBody = new ResponseBody(null,
                    exception.getMessage(), exception);
            return ResponseEntity.ok(responseBody);
        }
    }

    @PostMapping("/register")
    public ResponseEntity<ResponseBody> register(@RequestBody User userBody){
        User createdUser = userService.createUser(userBody);
        ResponseBody responseBody = new ResponseBody(createdUser,
                "create successful", null);
        return ResponseEntity.ok(responseBody);
    }

}
