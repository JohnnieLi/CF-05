package ca.ucareer.computerfactory.user;

import ca.ucareer.computerfactory.core.JWT;
import ca.ucareer.computerfactory.cpu.CPUService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    public Object verify;
    @Autowired
    UserRepository userRepository;

    @Autowired
    JWT jwt;

    @Autowired
    CPUService cpuService;

    //Create a function to handle registration
    User createUser(User userBody) throws Exception{
        User foundUser = userRepository.findUserByUsername(userBody.getUsername()).orElse(null);
        if(foundUser == null){
            User savingUser = new User();
            savingUser.setUsername(userBody.getUsername());
            savingUser.setPassword(userBody.getPassword());
            savingUser.setEmail(userBody.getEmail());
            return userRepository.save(savingUser);
        }else{
            throw new Exception("user already exist");
        }
    }

    //Ask users to do authentication. If pass, return json web token back.
    String userLogin(LoginRequestBody userBody) throws Exception{
        User foundUser = userRepository.findUserByUsername(userBody.getUsername()).orElse(null);
        if(foundUser != null){
            if(foundUser.getPassword().equals(userBody.getPassword())){
                return jwt.creatLoginToken(foundUser.getUsername());
            }else{
                throw new Exception("username or password wrong");
            }
        }else{
            throw new Exception("user not exist");
        }
    }

    User findUser(String username) throws Exception{
        User foundUser = userRepository.findUserByUsername(username).orElse(null);
        if(foundUser!=null){
            return foundUser;
        }else{
            throw new Exception("No such a user");
        }
    }

    String verifiedCpu(String token) throws Exception{
        if(jwt.verifyLoginToken(token) != null){
            return jwt.verifyLoginToken(token);
        }else{
            throw new Exception("Something is wrong");
        }
    }
}
