package africa.semicolon.account.utils;

import africa.semicolon.account.data.model.Account;
import africa.semicolon.account.dto.request.LoginRequest;
import africa.semicolon.account.dto.request.RegisterAccountRequest;
import africa.semicolon.account.dto.response.LoginResponse;
import africa.semicolon.account.dto.response.RegisterAccountResponse;

import java.time.format.DateTimeFormatter;

public class Mapper {
    public static void map(RegisterAccountRequest request, Account account){
        account.setFirstName(request.getFirstName());
        account.setLastName(request.getLastName());
        account.setEmail(request.getEmail());
    }

    public static void map(Account savedAccount, RegisterAccountResponse response) {
        response.setFirstName(savedAccount.getFirstName());
        response.setLastName(savedAccount.getLastName());
        response.setAccountNumber(savedAccount.getAccountNumber());
        response.setDateCreated(DateTimeFormatter.ofPattern("EEE, dd/MM/yyyy, hh-mm, a").format(savedAccount.getDateCreated()));
    }
    public static void map(LoginRequest request,Account account){
        account.setEmail(request.getEmail());
        account.setLastName(request.getAccountNumber());
    }
    public static  void map(Account savedAccount, LoginResponse response){
        response.setFirstName(savedAccount.getFirstName());
        response.setLastName(savedAccount.getLastName());
        response.setMessage("successfuly");
    }


}
