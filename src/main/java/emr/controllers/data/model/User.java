package emr.controllers.data.model;

import emr.controllers.Enum.Gender;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Setter
@Getter
@Entity
@Data
@Table(name = "emr_signup")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userID;



    @NotNull(message = "First Name cannot be null")
    @NotBlank(message = "First Name cannot be blank")
    private String firstName;

    private String middleName;

    private String lastName;

    @NotNull(message = "Date of Birth cannot be null")
    @NotBlank(message = "Date of Birth cannot be blank")
    private LocalDate dob;

    private Gender gender;

    @Column(unique = true, nullable = false)
    @Email(message = "Email should be valid")
    private String email;
    @Column(name = "phone_number")
    private String phoneNumber;


    @NotBlank(message = "Password cannot be blank")
    @NotNull(message = "Password cannot be null")
    @Size(min = 5, max = 20, message = "Password should be at least 5  and not more than 20 characters long")
    private String password;
}