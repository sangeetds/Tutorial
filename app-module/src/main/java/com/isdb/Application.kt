package com.isdb

import com.isdb.controller.UserLoginController
import com.isdb.model.Song
import com.isdb.model.User
import com.isdb.repository.SongsRepository
import com.isdb.repository.UserRepository
import com.isdb.service.UserService
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication(scanBasePackageClasses = [UserService::class, UserLoginController::class])
@EntityScan(basePackageClasses = [User::class, Song::class])
@EnableJpaRepositories(basePackageClasses = [UserRepository::class, SongsRepository::class])
open class Application

fun main(args: Array<String>) {
    SpringApplication.run(Application::class.java, *args)
}