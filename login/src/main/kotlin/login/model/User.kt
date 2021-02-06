package login.model

import javax.persistence.*
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank

@Entity
@Table(name = "users")
data class User (
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) val id: Long = 0,
    @NotBlank var username: String? = null,
    @NotBlank var password:  String? = null,
    @Email var email: String? = null,
    var isLoggedIn: Boolean = false
)