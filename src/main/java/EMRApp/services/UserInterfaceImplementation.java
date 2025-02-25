package EMRApp.services;


import EMRApp.data.model.User;
import EMRApp.data.repository.UserRepository;
import EMRApp.dtos.request.LogInRequest;
import EMRApp.dtos.request.SignUpRequest;
import EMRApp.dtos.response.LogInResponse;
import EMRApp.dtos.response.SignUpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;



@Service
public class UserInterfaceImplementation implements UserInterface {
    @Autowired
    private UserRepository userRepository;

    public UserInterfaceImplementation(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public SignUpResponse signUp(SignUpRequest signUpRequest) {
        LocalDate dob = signUpRequest.getDob();
        User user = new User();
        user.setFirstName(signUpRequest.getFirstName());
        user.setMiddleName(signUpRequest.getMiddleName());
        user.setLastName(signUpRequest.getLastName());
        user.setDob(dob);
        user.setGender(signUpRequest.getGender());
        user.setEmail(signUpRequest.getEmail());
        user.setPhoneNumber(signUpRequest.getPhoneNumber());
        user.setPassword(signUpRequest.getPassword());
        userRepository.save(user);
        SignUpResponse response = new SignUpResponse();
        response.setMessage("User has been successfully registered");
        return response;
    }

    @Override
    public LogInResponse logIn(LogInRequest logInRequest) {
        if (logInRequest == null || logInRequest.getEmail() == null || logInRequest.getPassword() == null) {
            LogInResponse response = new LogInResponse();
            response.setMessage("Email or Password cannot be null");
            return response;
        }

        String email = logInRequest.getEmail();
        String password = logInRequest.getPassword();
        User user = userRepository.findByEmail(email).orElse(null);

        LogInResponse response = new LogInResponse();

        if (user != null) {
            if (user.getPassword().equals(password)) {
                response.setMessage("Login successful");
                response.setUserId(user.getUserID());
                response.setEmail(user.getEmail());
            } else {
                response.setMessage("Invalid credentials");
            }
        } else {
            response.setMessage("Invalid credentials");
        }

        return response;
    }
}