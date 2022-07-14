package africa.semicolon.account.data.repository;

import africa.semicolon.account.data.model.Account;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface AccountRepository extends MongoRepository<Account,String> {
    boolean existsByEmail(String email);
    Optional<Account> findByEmail(String email);
}
