package ca.ucareer.computerfactory.controller;

import ca.ucareer.computerfactory.model.loginrequest.LoginRequestBody;
import ca.ucareer.computerfactory.model.user.User;
import ca.ucareer.computerfactory.model.user.UserService;
import ca.ucareer.computerfactory.response.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/v1")
@RestController
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/register")
    public ResponseEntity<ResponseBody> createUser(@RequestBody User userBody){
        User newUser = userService.createUser(userBody);
        ResponseBody<User> responseBody = new ResponseBody(newUser
                , "create successful", null);
        return ResponseEntity.ok(responseBody);
    }

    @PostMapping("/login")
    public ResponseEntity<ResponseBody>
    login(@RequestBody LoginRequestBody loginRequestBody){
        try{
            String token = userService.createToken(loginRequestBody);
            ResponseBody responseBody = new ResponseBody(token,
                    "token has been wrapped in it", null);
            return ResponseEntity.ok(responseBody);
        }
        catch(Exception exception){
            ResponseBody responseBody = new ResponseBody("",
                    exception.getMessage(), exception);
            return ResponseEntity.ok(responseBody);
        }
    }
}
