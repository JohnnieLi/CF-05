package ca.ucareer.computerfactory.controller;

import ca.ucareer.computerfactory.core.JWT;
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

    @Autowired
    JWT jwt;

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

    @GetMapping("/me")
    public ResponseEntity<ResponseBody>
    checkUserInfo(@RequestHeader("token") String token){
        try{
            String username = jwt.verifyToken(token);
            if(username != null){
                User me = userService.retrieveUser(username);
                ResponseBody<User> responseBody =
                        new ResponseBody(
                                me,
                                "find out my information", null);
                return ResponseEntity.ok(responseBody);
            }
            else{
                ResponseBody responseBody =
                        new ResponseBody(null, "no username", null);
                return ResponseEntity.ok(responseBody);
            }
        }
        catch (Exception e){
            ResponseBody responseBody =
                    new ResponseBody(null, e.getMessage(), null);
            return ResponseEntity.ok(responseBody);
        }
    }


    @PostMapping("/me")
    public ResponseEntity<ResponseBody>
    updateUserInfo(@RequestHeader("token") String token,
                   @RequestBody String newPassword){
        try{
            String username = jwt.verifyToken(token);
            if(username != null){
                ResponseBody responseBody =
                        new ResponseBody(
                                userService.updateUser(newPassword, username),
                                "update me", null);
                return ResponseEntity.ok(responseBody);
            }
            else{
                ResponseBody responseBody =
                        new ResponseBody(null, "no username", null);
                return ResponseEntity.ok(responseBody);
            }
        }
        catch (Exception e){
            ResponseBody responseBody =
                    new ResponseBody(null, e.getMessage(), null);
            return ResponseEntity.ok(responseBody);
        }
    }
}
