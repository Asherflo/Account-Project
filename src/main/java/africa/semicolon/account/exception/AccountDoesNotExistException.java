package africa.semicolon.account.exception;

public class AccountDoesNotExistException extends AccountException{
    public AccountDoesNotExistException(String message) {
        super(message);
    }
}
