package entity;
import types.UserType;
import java.time.LocalDate;
import java.util.UUID;

public class User {

    private UUID Id;
    private String name;
    private String email;
    private float balance;
    private UserType type;
    private LocalDate createdAt;

    public User(String name, String email, float balance, UserType type, LocalDate createdAt) {
        this.Id = UUID.randomUUID();
        this.name = name;
        this.email = email;
        this.balance = balance;
        this.type = type;
        this.createdAt = createdAt;
    }

    public UUID getId() {
        return Id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public float getBalance() {
        return balance;
    }

    public UserType getType() {
        return type;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setBalance(Float newBalance) {
        this.balance = newBalance;
    }
}
