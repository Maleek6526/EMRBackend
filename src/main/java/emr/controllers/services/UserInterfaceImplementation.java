package emr.controllers.services;


import emr.controllers.data.model.User;
import emr.controllers.data.repository.UserRepository;
import emr.controllers.dtos.request.LogInRequest;
import emr.controllers.dtos.request.SignUpRequest;
import emr.controllers.dtos.response.LogInResponse;
import emr.controllers.dtos.response.SignUpResponse;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;


@Service
public class UserInterfaceImplementation implements UserInterface{

    private final UserRepository userRepository;

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
        return null;
    }
}