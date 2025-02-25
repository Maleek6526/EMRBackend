package EMRApp.services;

import EMRApp.dtos.request.LogInRequest;
import EMRApp.dtos.request.SignUpRequest;
import EMRApp.dtos.response.LogInResponse;
import EMRApp.dtos.response.SignUpResponse;

public interface UserInterface {
    SignUpResponse signUp(SignUpRequest signUpRequest);
    LogInResponse logIn(LogInRequest logInRequest);
}
