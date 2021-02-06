package demo.Model

import java.util.*
import javax.persistence.*
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank

@Entity
@Table(name = "users")
class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long = 0
    var username: @NotBlank String? = null
    var password: @NotBlank String? = null
    var email: @Email String? = null
    var isLoggedIn = false

    constructor()

    constructor(username: @NotBlank String?,
                password: @NotBlank String?) {
        this.username = username
        this.password = password
        isLoggedIn = false
    }

    constructor(username: @NotBlank String?,
                password: @NotBlank String?,
                email: @NotBlank String?) {
        this.username = username
        this.password = password
        this.email = email
        isLoggedIn = false
    }

    override fun equals(o: Any?): Boolean {
        if (this === o) return true
        if (o == null || javaClass != o.javaClass) return false
        val user = o as User
        return username == user.username && password == user.password
    }

    override fun hashCode(): Int {
        return Objects.hash(id, username, password, email, isLoggedIn)
    }

    override fun toString(): String {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", loggedIn=" + isLoggedIn +
                '}'
    }
}