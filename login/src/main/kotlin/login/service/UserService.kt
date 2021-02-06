package login.service

import login.model.User

interface UserService {
    fun findAllUsers(): MutableList<User?>
    fun saveUser(user: User)
    fun deleteAllUser()
}