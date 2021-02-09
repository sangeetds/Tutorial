package com.isdb

import com.isdb.controller.UserLoginController
import login.model.User
import login.repository.UserRepository
import login.service.UserService
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication(scanBasePackageClasses = [UserService::class, UserLoginController::class])
@EntityScan(basePackageClasses = [User::class])
@EnableJpaRepositories(basePackageClasses = [UserRepository::class])
class DemoApplication

fun main(args: Array<String>) {
    SpringApplication.run(DemoApplication::class.java, *args)
}
