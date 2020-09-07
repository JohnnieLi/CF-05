package ca.ucareer.computerfactory.model.user;

import ca.ucareer.computerfactory.core.JWT;
import ca.ucareer.computerfactory.response.LoginRequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    JWT jwt;

    public User createUser(User userBody){
        User savingUser = new User();
        savingUser.setUsername(userBody.getUsername());
        savingUser.setPassword(userBody.getPassword());

        return userRepository.save(savingUser);
    }

    public User retrieve(Integer id){
        return userRepository.findById(id).orElse(null);
    }

    public String retrievePassword(String username){
        User foundUser = userRepository.findByUsername(username).orElse(null);
        if(foundUser != null){
            return foundUser.getPassword();
        }
        else{
            return null;
        }
    }

    public List<User> listUsers(){
        return userRepository.findAll();
    }

    // here is something that need to be tested
    public User updateUser(User userBody){
        User changingUser = userRepository.findById(userBody.getId()).orElse(null);
        try{
            // need to te tested
            changingUser.setUsername(userBody.getUsername());
            return changingUser;
        }
        catch(Exception exception){
            return null;
        }
    }

    public User deleteUser(Integer id){
        User targetUser = userRepository.findById(id).orElse(null);
        if(targetUser != null){
            User deletedUser = new User();
            deletedUser.setUsername(targetUser.getUsername());
            deletedUser.setId(targetUser.getId());
            deletedUser.setCreated_at(targetUser.getCreated_at());
            deletedUser.setModified_at(targetUser.getModified_at());
            deletedUser.setCreated_by(targetUser.getCreated_by());
            userRepository.deleteById(id);
            return deletedUser;
        }
        else{
            return null;
        }
    }

    public String userLogin(LoginRequestBody userBody) throws Exception{
        // authentication
        System.out.println(userBody.getUsername());
        User foundUser = userRepository.findByUsername(userBody.getUsername()).orElse(null);
        System.out.println("userService " + foundUser.getUsername());
        if(foundUser != null && foundUser.getPassword().equals(userBody.getPassword())){
            return jwt.createToken(userBody.getUsername());
        }
        else{
            /** tips: if throw Exception, you must use try, catch when call this function*/
            throw new Exception("user or password is wrong");
        }
    }

}
