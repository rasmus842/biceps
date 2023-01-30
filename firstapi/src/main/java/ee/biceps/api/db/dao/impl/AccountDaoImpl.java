package ee.biceps.api.db.dao.impl;

import ee.biceps.api.db.DbUtil;
import ee.biceps.api.db.dao.AccountDao;
import ee.biceps.api.db.model.Account;
import org.jdbi.v3.core.Jdbi;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;

public class AccountDaoImpl implements AccountDao {
    private Jdbi jdbi;

    public AccountDaoImpl() {
        this.jdbi = DbUtil.getJdbi();
        jdbi.registerRowMapper(Account.class, (rs, ctx) -> Account.builder()
                .id(rs.getLong("id"))
                .username(rs.getString("username"))
                .passwordHash(rs.getString("password_hash"))
                .createdAt(rs.getTimestamp("created_at"))
                .status(rs.getString("status"))
                .build());
    }

    public AccountDaoImpl(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    @Override
    public Account selectAccountById(Long id) {
        return jdbi.withHandle(h -> {
            return h.createQuery("SELECT * from account WHERE id=:id")
                    .bind("id", id)
                    .mapTo(Account.class)
                    .findOne()
                    .orElse(null);
        });
    }

    @Override
    public Account selectAccountByUsername(String username) {
        return jdbi.withHandle(h -> {
            return h.createQuery("SELECT * from account WHERE username=:username")
                    .bind("username", username)
                    .mapTo(Account.class)
                    .findOne()
                    .orElse(null);
        });
    }

    @Override
    public List<Account> selectAccounts() {
        return jdbi.withHandle(h -> {
            return h.createQuery("SELECT * FROM account")
                    .mapTo(Account.class)
                    .list();
        });
    }

    @Override
    public Long createAccount(Account account) {
        return jdbi.withHandle(h -> {
            return h.createUpdate("INSERT INTO " +
                            "account(username, password_hash, created_at, status) " +
                            "VALUES(:username, :passwordHash, :createdAt, :status)")
                    .bindBean(account)
                    .executeAndReturnGeneratedKeys()
                    .mapTo(Account.class)
                    .findOne()
                    .map(Account::getId)
                    .orElse(null);
        });
    }

    @Override
    public boolean updateAccountById(Long id, Account account) {
        return jdbi.withHandle(h -> {
            return h.createUpdate("UPDATE account " +
                            "SET username=:a.username, password_hash=:a.passwordHash, created_at=:a.createdAt, status=:a.status " +
                            "WHERE id=:id")
                    .bindBean("a", account)
                    .bind("id", id)
                    .execute() == 1;
        });
    }

    @Override
    public boolean updateAccountByUsername(String username, Account account) {
        return jdbi.withHandle(h -> {
            return h.createUpdate("UPDATE account " +
                            "SET username=:a.username, password_hash=:a.passwordHash, created_at=:a.createdAt, status=:a.status " +
                            "WHERE username=:username")
                    .bindBean("a", account)
                    .bind("username", username)
                    .execute() == 1;
        });
    }

    @Override
    public boolean updateAccountFieldByUsername(String username, String fieldName,
                                                Object fieldValue, Class<?> fieldClass) {
        return jdbi.withHandle(h -> {
            return h.createUpdate("UPDATE account " +
                            "SET " + fieldName + "=:fieldValue " +
                            "WHERE username=:username")
                    .bind("fieldValue", fieldClass.cast(fieldValue))
                    .bind("username", username)
                    .execute() == 1;
        });
    }

    @Override
    public boolean deleteAccountById(Long id) {
        return jdbi.withHandle(h -> {
            return h.createUpdate("DELETE FROM account WHERE id=:id")
                    .bind("id", id)
                    .execute() == 1;
        });
    }

    @Override
    public boolean deleteAccountByUsername(String username) {
        return jdbi.withHandle(h -> {
            return h.createUpdate("DELETE FROM account WHERE username=:username")
                    .bind("username", username)
                    .execute() == 1;
        });
    }
}
