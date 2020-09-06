package ca.ucareer.computerfactory.user;

import ca.ucareer.computerfactory.ResponseBody;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserService userService;

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
}
