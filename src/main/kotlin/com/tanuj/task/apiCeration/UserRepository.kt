package com.tanuj.task.apiCeration

import org.springframework.data.mongodb.repository.MongoRepository

import org.springframework.stereotype.Repository

@Repository
interface UserRepository : MongoRepository<User, String> {
}