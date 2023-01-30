package ee.biceps.api.db.dao;

import ee.biceps.api.db.model.Account;
import org.jdbi.v3.sqlobject.locator.UseClasspathSqlLocator;

import java.util.List;

public interface AccountDao {
    Account selectAccountById(Long id);
    Account selectAccountByUsername(String username);
    List<Account> selectAccounts();
    Long createAccount(Account account);
    boolean updateAccountById(Long id, Account account);
    boolean updateAccountByUsername(String username, Account account);
    boolean updateAccountFieldByUsername(String username, String fieldName, Object fieldValue, Class<?> fieldClass);
    boolean deleteAccountById(Long id);
    boolean deleteAccountByUsername(String username);

}
