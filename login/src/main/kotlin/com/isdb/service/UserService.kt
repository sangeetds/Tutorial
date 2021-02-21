package com.isdb.service

import com.isdb.model.User

interface UserService {
    fun findAllUsers(): MutableList<User?>
    fun saveUser(user: User): User
    fun deleteAllUser()
}