package EMRApp.controllers;


import EMRApp.dtos.request.LogInRequest;
import EMRApp.dtos.request.SignUpRequest;
import EMRApp.dtos.response.LogInResponse;
import EMRApp.dtos.response.SignUpResponse;
import EMRApp.services.UserInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserInterface userInterface;

    @Autowired
    public UserController(UserInterface userInterface) {
        this.userInterface = userInterface;
    }

    @PostMapping("/signup")
    public ResponseEntity<SignUpResponse> signUp(@RequestBody SignUpRequest signUpRequest) {
        SignUpResponse response = userInterface.signUp(signUpRequest);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<LogInResponse> logIn(@RequestBody LogInRequest logInRequest) {
        LogInResponse response = userInterface.logIn(logInRequest);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
