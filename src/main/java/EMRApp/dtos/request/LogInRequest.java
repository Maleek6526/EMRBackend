package EMRApp.dtos.request;

import lombok.Data;


@Data
public class LogInRequest {
    private String email;
    private String password;
}
