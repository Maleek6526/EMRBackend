package EMRApp.dtos.response;

import lombok.Data;


@Data
public class LogInResponse {
    private String message;
    private Long userId;
    private String email;
}
