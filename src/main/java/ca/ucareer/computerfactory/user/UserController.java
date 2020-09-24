package ca.ucareer.computerfactory.user;

import ca.ucareer.computerfactory.ResponseBody;
import ca.ucareer.computerfactory.core.JWT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1")
@CrossOrigin(origins = "*")
public class UserController {


    @Autowired
    private  UserService userService;

    @Autowired
    private JWT jwt;

    @GetMapping("/test")
    public ResponseEntity<ResponseBody> test() {
        try {
            User savedOne = new User();
            savedOne.setEmail("test@email.com");
            ResponseBody responseBody = new ResponseBody(savedOne, "", null);
            return ResponseEntity.ok(responseBody);
        }catch (Exception e){
            ResponseBody responseBody = new ResponseBody(null, e.getMessage(), e);
            return ResponseEntity.ok(responseBody);
        }
    }


    @GetMapping("/users/me")
    public ResponseEntity<ResponseBody> getMe(@RequestHeader("Authorization") String token) {
        try {
            String username = jwt.verifyLoginToken(token);
            User foundUser = userService.findUser(username);
            foundUser.getComputers();
            ResponseBody responseBody = new ResponseBody(foundUser, "", null);
            return ResponseEntity.ok(responseBody);
        }catch (Exception e){
            ResponseBody responseBody = new ResponseBody(null, e.getMessage(), e);
            return ResponseEntity.ok(responseBody);
        }
    }


    @PostMapping("/register")
    public ResponseEntity<ResponseBody> register(@RequestBody User userBody) {
       try {
           User savedOne = userService.createUser(userBody);
           ResponseBody responseBody = new ResponseBody(savedOne, "", null);
           return ResponseEntity.ok(responseBody);
       }catch (Exception e){
           ResponseBody responseBody = new ResponseBody(null, e.getMessage(), e);
           return ResponseEntity.ok(responseBody);
       }
    }

    @PostMapping("/login")
    public ResponseEntity<ResponseBody> login(@RequestBody LoginRequestBody userBody) {
        try {
            String token = userService.userLogin(userBody);
            ResponseBody responseBody = new ResponseBody(token, "", null);
            return ResponseEntity.ok(responseBody);
        }catch (Exception e){
            ResponseBody responseBody = new ResponseBody(null, e.getMessage(), e);
            return ResponseEntity.ok(responseBody);
        }
    }

}
