package africa.semicolon.account.exception;

public class DuplicateAccountException extends AccountException{
    public DuplicateAccountException(String message) {
        super(message);
    }
}
