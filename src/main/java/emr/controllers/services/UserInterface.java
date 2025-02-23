package emr.controllers.services;

import emr.controllers.dtos.request.LogInRequest;
import emr.controllers.dtos.request.SignUpRequest;
import emr.controllers.dtos.response.LogInResponse;
import emr.controllers.dtos.response.SignUpResponse;

public interface UserInterface {
    SignUpResponse signUp(SignUpRequest signUpRequest);
    LogInResponse logIn(LogInRequest logInRequest);
}
