package demo.Controller

import demo.Model.User
import org.springframework.web.bind.annotation.RestController
import org.springframework.beans.factory.annotation.Autowired
import demo.Repository.UserRepository
import demo.Status
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import javax.validation.Valid
import org.springframework.web.bind.annotation.DeleteMapping

@RestController
class UserController @Autowired constructor(val userRepository: UserRepository) {
    @PostMapping("/users/register")
    fun registerUser(@RequestBody newUser: @Valid User?): Status {
        println(newUser)
        val users = userRepository.findAll()
        if (newUser!!.email == null) return Status.FAILURE
        for (user in users) {
            if (user!!.equals(newUser) && user.email == newUser.email) {
                println("User Already exists!")
                return Status.USER_ALREADY_EXISTS
            }
        }
        userRepository.save(newUser)
        return Status.SUCCESS
    }

    @PostMapping("/users/login")
    fun loginUser(@RequestBody user: @Valid User?): Status {
        val users = userRepository.findAll()
        println(user)
        for (other in users) {
            println(other)
            if (other!!.equals(user)) {
                user!!.isLoggedIn = true
                userRepository.save(user)
                return Status.SUCCESS
            }
        }
        return Status.FAILURE
    }

    @PostMapping("/users/logout")
    fun logUserOut(@RequestBody user: @Valid User?): Status {
        val users = userRepository.findAll()
        for (other in users) {
            if (other!!.equals(user)) {
                user!!.isLoggedIn = false
                userRepository.save(user)
                return Status.SUCCESS
            }
        }
        return Status.FAILURE
    }

    @DeleteMapping("/users/all")
    fun deleteUsers(): Status {
        userRepository.deleteAll()
        return Status.SUCCESS
    }
}