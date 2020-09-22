package ca.ucareer.computerfactory.model.user;

import ca.ucareer.computerfactory.core.JWT;
import ca.ucareer.computerfactory.model.loginrequest.LoginRequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        savingUser.setStatus("registered");

        return userRepository.save(savingUser);
    }

    public List<User> listUser(){
        return userRepository.findAll();
    }

    public User retrieveUser(String username){

        return userRepository.findUserByUsername(username).orElse(null);
    }

    public User updateUser(String password, String username){
        User updatedUser =
                userRepository.findUserByUsername(username)
                .orElse(null);
        if(updatedUser != null){
            updatedUser.setStatus("modified password");
            updatedUser.setPassword(password);
            return userRepository.save(updatedUser);
        }
        else return null;

    }

    public User deleteUser(Integer id){
        User deletedUser = new User();
        User userBody = userRepository.findById(id).orElse(null);
        if(userBody != null){
            deletedUser.setId(userBody.getId());
            deletedUser.setUsername(userBody.getUsername());
            deletedUser.setPassword(userBody.getPassword());
            deletedUser.setStatus(userBody.getStatus());
            deletedUser.setCreate_at(userBody.getCreate_at());
            deletedUser.setModified_at(userBody.getModified_at());
            deletedUser.setModified_by(userBody.getModified_by());

            userRepository.deleteById(id);
            return deletedUser;
        }
        else{
            return null;
        }
    }

    /** if we use throw, we need to use try - catch out side this method*/
    public String createToken (LoginRequestBody loginRequestBody) throws Exception{
        String loginPassword = loginRequestBody.getPassword();
        User targetUser = userRepository
                .findUserByUsername(loginRequestBody.getUsername()).orElse(null);
        if(targetUser != null){
            if(loginPassword.equals(targetUser.getPassword())){
                // create token
                return jwt.createToken(loginRequestBody.getUsername());

            }
            else{
                throw new Exception("password and username is not match");
            }
        }
        else{
            throw new Exception("no such user");
        }
    }

}
