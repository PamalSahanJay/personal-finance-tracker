package iit.api.Personal.Finance.Tracker.service;


import iit.api.Personal.Finance.Tracker.dto.LoginDTO;
import iit.api.Personal.Finance.Tracker.entity.User;
import iit.api.Personal.Finance.Tracker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

//    @Autowired
//    private PasswordEncoder passwordEncoder;

    public void registerUser(User user) {
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    public User saveUser(User user) throws Exception{
        return userRepository.save(user);
    }

    public boolean checkUser(LoginDTO loginDTO) {
        User user = userRepository.findByEmail(loginDTO.getEmail());
        if (user != null) {
            return user.getPassword().equals(loginDTO.getPassword());
        }
        return false;
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}

