package login.service.impl

import login.model.User
import login.repository.UserRepository
import login.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserServiceImpl(@Autowired private val userRepository: UserRepository): UserService {
    override fun findAllUsers(): MutableList<User?> = this.userRepository.findAll()

    override fun saveUser(user: User) {
        this.userRepository.save(user)
    }

    override fun deleteAllUser() {
        this.userRepository.deleteAll()
    }

}