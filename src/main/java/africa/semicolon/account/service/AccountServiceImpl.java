package africa.semicolon.account.service;

import africa.semicolon.account.data.model.Account;
import africa.semicolon.account.data.repository.AccountRepository;
import africa.semicolon.account.dto.request.LoginRequest;
import africa.semicolon.account.dto.request.RegisterAccountRequest;
import africa.semicolon.account.dto.response.LoginResponse;
import africa.semicolon.account.dto.response.RegisterAccountResponse;
import africa.semicolon.account.exception.AccountDoesNotExistException;
import africa.semicolon.account.exception.DuplicateAccountException;
import africa.semicolon.account.utils.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService{

    @Autowired
    private AccountRepository accountRepository;
    @Override
    public RegisterAccountResponse registerAccount(RegisterAccountRequest request) {
        if(accountRepository.existsByEmail(request.getEmail())) throw new DuplicateAccountException("Account already exist!");
        Account account = new Account();
        Mapper.map(request,account);

       Account savedAccount =  accountRepository.save(account);

       RegisterAccountResponse response = new RegisterAccountResponse();

       Mapper.map(savedAccount,response);
       return  response;
    }

    @Override
    public LoginResponse login(LoginRequest request) {
        //Account foundAccount = accountRepository.findByEmail(request.getEmail()).orElseThrow(()-> new AccountDoesNotExistException("Account not found! Kindly register!"));
        Optional<Account> foundAccount = accountRepository.findByEmail(request.getEmail());
        if(foundAccount.isEmpty()) throw new AccountDoesNotExistException("Account not found! Kindly register!");
        Account account = foundAccount.get();
        LoginResponse response = new LoginResponse();

        if(request.getAccountNumber().equals(account.getAccountNumber())){
            response.setMessage("Successfully logged in!");
        }
        else{
            response.setMessage("Login Unsuccessful!");
        }
        response.setFirstName(account.getFirstName());
        response.setLastName(account.getLastName());
        return response;



    }


}
