package login.model

import javax.persistence.*
import javax.validation.constraints.Email
import javax.validation.constraints.NotNull

@Entity
@Table(name = "user")
data class User (
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO) var id: Long = 0,
    @NotNull @Column(name = "username") var username: String,
    @NotNull @Column(name = "password") var password:  String,
    @NotNull @Email @Column(name = "email") var email: String,
    @Column(name = "logged_in") var isLoggedIn: Boolean
) {

    constructor() : this(
        0,
        ('a'..'z').random().toString(),
        ('a'..'z').random().toString(),
        "${('a'..'z').random()}@${('a'..'z').random()}",
        false
    )
}