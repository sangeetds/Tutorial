package demo.Model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
@Table(name = "users")
public class User {
    private @Id @GeneratedValue(strategy = GenerationType.AUTO) long id;
    private @NotBlank String username;
    private @NotBlank String password;
    private @Email String email;
    private boolean loggedIn;

    public User() {
    }

    public User(@NotBlank String username,
                @NotBlank String password) {
        this.username = username;
        this.password = password;
        this.loggedIn = false;
    }

    public User(@NotBlank String username,
                @NotBlank String password,
                @NotBlank String email) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.loggedIn = false;
    }

    public long getId() {
        return this.id;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isLoggedIn() {
        return this.loggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return username.equals(user.username) &&
                password.equals(user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, email, loggedIn);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", loggedIn=" + loggedIn +
                '}';
    }
}
