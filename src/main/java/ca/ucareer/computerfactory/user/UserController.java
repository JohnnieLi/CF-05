package ca.ucareer.computerfactory.user;

import ca.ucareer.computerfactory.ResponseBody;
import ca.ucareer.computerfactory.core.JWT;
import ca.ucareer.computerfactory.cpu.CPU;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1")
@CrossOrigin(origins = "*")
public class UserController {


    @Autowired
    private UserService userService;

    @Autowired
    private JWT jwt;

    @PostMapping("/register")
    public ResponseEntity<ResponseBody>register(@RequestBody User userBody){

        try {
            User savedName = userService.createUser(userBody);
            ResponseBody responseBody = new ResponseBody(savedName, "New user Created",null);
            return ResponseEntity.ok(responseBody);
        }catch(Exception e){
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

    @GetMapping("/users/me")
    public ResponseEntity<ResponseBody> userInformation(@RequestHeader("Authorization") String token) {
        try {
            String username = jwt.verifyLoginToken(token);
            User foundUser = userService.findUser(username);
            ResponseBody responseBody = new ResponseBody(foundUser, "", null);
            return ResponseEntity.ok(responseBody);
        }catch (Exception e){
            ResponseBody responseBody = new ResponseBody(null, e.getMessage(), e);
            return ResponseEntity.ok(responseBody);
        }
    }

    @PostMapping("/users/me")
    public ResponseEntity<ResponseBody> update(@RequestHeader("Authorization") String token,@RequestBody User userBody) {
        try {
            String username = jwt.verifyLoginToken(token);
            User foundUser = userService.findUser(username);
            String finalMessage = "";
                foundUser = userService.update(username, userBody);
                finalMessage = "user information has been updated.";
            ResponseBody responseBody = new ResponseBody(foundUser, finalMessage, null);
            return ResponseEntity.ok(responseBody);
        }catch (Exception e){
            ResponseBody responseBody = new ResponseBody(null, e.getMessage(), e);
            return ResponseEntity.ok(responseBody);
        }
    }

}