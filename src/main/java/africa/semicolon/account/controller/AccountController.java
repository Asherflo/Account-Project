package africa.semicolon.account.controller;

import africa.semicolon.account.dto.request.LoginRequest;
import africa.semicolon.account.dto.request.RegisterAccountRequest;
import africa.semicolon.account.dto.response.ApiResponse;
import africa.semicolon.account.dto.response.LoginResponse;
import africa.semicolon.account.dto.response.RegisterAccountResponse;
import africa.semicolon.account.exception.DuplicateAccountException;
import africa.semicolon.account.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @PostMapping("/register")
    public ResponseEntity<?> registerAccount(@RequestBody RegisterAccountRequest request) {
        try{
            RegisterAccountResponse registerAccountResponse = accountService.registerAccount(request);
            ApiResponse response = new ApiResponse(true,registerAccountResponse);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        }
        catch (DuplicateAccountException ar){
            ApiResponse response = new ApiResponse(false,ar.getMessage());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("login")
    public LoginResponse login(@RequestBody LoginRequest request) {
        return accountService.login(request);
    }

}
