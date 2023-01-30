package ee.biceps.api.db.model;

import lombok.Data;
import lombok.Builder;

import java.sql.Timestamp;

@Data
@Builder
public class Account {
    public static final String TABLE_NAME = "account";
    public static final String FIELD_NAMES = "id, username, password_hash, created_at, status";

    private Long id;
    private String username;
    private String passwordHash;
    private Timestamp createdAt;
    private String status;
}
