package emr.controllers.dtos.request;

import emr.controllers.Enum.Gender;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
public class SignUpRequest {
    private String firstName;
    private String middleName;
    private String lastName;
    private Gender gender;
    private LocalDate dob;
    private String email;
    private String phoneNumber;
    private String password;
}
