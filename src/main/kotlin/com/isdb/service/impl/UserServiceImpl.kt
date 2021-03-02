package com.isdb.service.impl

import com.isdb.model.User
import com.isdb.repository.UserRepository
import com.isdb.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserServiceImpl(@Autowired private val userRepository: UserRepository): UserService {
    override fun findAllUsers(): MutableList<User?> = this.userRepository.findAll()

    override fun saveUser(user: User): User = this.userRepository.save(user)

    override fun deleteAllUser() {
        this.userRepository.deleteAll()
    }

}