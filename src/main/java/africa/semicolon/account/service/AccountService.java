package africa.semicolon.account.service;

import africa.semicolon.account.dto.request.LoginRequest;
import africa.semicolon.account.dto.request.RegisterAccountRequest;
import africa.semicolon.account.dto.response.LoginResponse;
import africa.semicolon.account.dto.response.RegisterAccountResponse;
import org.springframework.stereotype.Service;

public interface AccountService {
    RegisterAccountResponse registerAccount(RegisterAccountRequest request);
     LoginResponse login(LoginRequest request);


}
