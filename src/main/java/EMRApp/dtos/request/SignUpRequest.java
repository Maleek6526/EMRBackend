package EMRApp.dtos.request;

import EMRApp.Enum.Gender;
import lombok.Data;

import java.time.LocalDate;

@Data
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
