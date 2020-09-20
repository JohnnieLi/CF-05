package ca.ucareer.computerfactory.user;

import ca.ucareer.computerfactory.ResponseBody;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ca.ucareer.computerfactory.cpu.CPU;
import ca.ucareer.computerfactory.core.JWT;

@RestController
@RequestMapping("/v1")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private JWT jwt;

    @PostMapping("/register")
    public ResponseEntity<ResponseBody> register(@RequestBody User userBody) {
        try {
            User savedOne = userService.createUser(userBody);
            ResponseBody responseBody = new ResponseBody("", savedOne, null);
            return ResponseEntity.ok(responseBody);
        } catch (Exception e) {
            ResponseBody responseBody = new ResponseBody(e.getMessage(), null, null);
            return ResponseEntity.ok(responseBody);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<ResponseBody> login(@RequestBody LoginRequestBody userBody){
        try{
            String token = userService.userLogin(userBody);
            ResponseBody responseBody = new ResponseBody("" ,token, null);
            return ResponseEntity.ok(responseBody);
        }catch (Exception e){
            ResponseBody responseBody = new ResponseBody(e.getMessage(), null, null);
            return ResponseEntity.ok(responseBody);
        }
    }

/*    @PostMapping("/validation")
    public ResponseEntity<ResponseBody> retrieve(@RequestHeader String token){
            String validation = userService.verify(token);
            if (validation != null){
            ResponseBody responseBody = new ResponseBody("" ,validation, null);
            return ResponseEntity.ok(responseBody);}
            else{
            ResponseBody responseBody = new ResponseBody("Failed to validate", null, null);
            return ResponseEntity.ok(responseBody);
            }

    }*/

    @PostMapping("/validation")
    public ResponseEntity<ResponseBody> retrieve(@RequestHeader String token){
        try{
            String validation = userService.verifiedCpu(token);
            ResponseBody responseBody = new ResponseBody("" ,validation, null);
            return ResponseEntity.ok(responseBody);
        }catch (Exception e){
            ResponseBody responseBody = new ResponseBody(e.getMessage(), null, null);
            return ResponseEntity.ok(responseBody);
        }
    }

    @GetMapping("/users/me")
    public ResponseEntity<ResponseBody> getMe(@RequestHeader String token){
        try{
            String username = jwt.verifyLoginToken(token);
            User foundUser = userService.findUser(username);
            ResponseBody responseBody = new ResponseBody("Found the user", foundUser, null);
            return ResponseEntity.ok(responseBody);
        }catch (Exception e) {
            ResponseBody responseBody = new ResponseBody(e.getMessage(), null, null);
            return ResponseEntity.ok(responseBody);
        }

    }


}
