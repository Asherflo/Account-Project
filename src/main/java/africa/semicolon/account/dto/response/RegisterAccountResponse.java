package africa.semicolon.account.dto.response;

import lombok.Data;
import org.springframework.cglib.core.Local;

@Data
public class RegisterAccountResponse {
    private  String firstName;
    private String lastName;
    private String accountNumber;
    private String dateCreated;

}
