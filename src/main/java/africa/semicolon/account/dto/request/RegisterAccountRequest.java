package africa.semicolon.account.dto.request;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
//@NoArgsConstructor
public class RegisterAccountRequest {
    private String firstName;
    private String lastName;
    private String email;


}
