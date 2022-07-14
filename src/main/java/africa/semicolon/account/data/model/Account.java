package africa.semicolon.account.data.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@Document("Accounts")
public class Account {
    @Id
    private String id;
    private  String firstName;
    private String lastName;
    private String accountNumber;
    private String pin;
    private  String email;
    private LocalDateTime dateCreated =  LocalDateTime.now();
    private static int count;

    public Account(){
        accountNumber = "0"+count;
        count++;

    }


}
