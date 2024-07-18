package com.tanuj.task.apiCeration

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserService @Autowired constructor(private val userRepository: UserRepository) {
    fun findAll(): List<User> = userRepository.findAll()
}
