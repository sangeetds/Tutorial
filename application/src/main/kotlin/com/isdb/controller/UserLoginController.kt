package com.isdb.controller

import login.enums.Status
import login.model.User
import login.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
class UserLoginController
    (@Autowired private val userService: UserService) {

    @PostMapping("/users/register")
    fun registerUser(@RequestBody newUser: @Valid User?): Status {
        val users = this.userService.findAllUsers()

        for (user in users) {
            if (user!! == newUser && user.email == newUser.email) {
                println("User Already exists!")
                return Status.USER_ALREADY_EXISTS
            }
        }
        println(this.userService.saveUser(newUser!!))

        return Status.SUCCESS
    }

    @PostMapping("/users/login")
    fun loginUser(@RequestBody user: @Valid User?): Status {
        val users = this.userService.findAllUsers()

        for (other in users) {
            if (other!! == user) {
                user.isLoggedIn = true
                this.userService.saveUser(user)
                return Status.SUCCESS
            }
        }

        return Status.FAILURE
    }

    @PostMapping("/users/logout")
    fun logUserOut(@RequestBody user: @Valid User?): Status {
        val users = this.userService.findAllUsers()

        for (other in users) {
            if (other!! == user) {
                user.isLoggedIn = false
                this.userService.saveUser(user)
                return Status.SUCCESS
            }
        }

        return Status.FAILURE
    }

    @DeleteMapping("/users/all")
    fun deleteUsers(): Status {
        this.userService.deleteAllUser()

        return Status.SUCCESS
    }

    @GetMapping("/users")
    fun getAllUsers() {
        print(this.userService.findAllUsers())
    }
}