package ca.ucareer.computerfactory.user;

import ca.ucareer.computerfactory.core.JWT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    JWT jwt;

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

}
