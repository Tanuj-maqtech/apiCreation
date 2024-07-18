package com.tanuj.task.apiCeration

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.PageRequest
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;



@RestController
@RequestMapping("/api/users")
class UserController (@Autowired private val userRepository: UserRepository) {

    @GetMapping
    fun getUsers(
        @RequestParam(defaultValue = "0") page: Int,
        @RequestParam(defaultValue = "10") size: Int
    ): ResponseEntity<Map<String, Any>> {
        val pageable: Pageable = PageRequest.of(page, size)
        val userPage: Page<User> = userRepository.findAll(pageable)

        val response = mapOf(
            "users" to userPage.content,
            "currentPage" to userPage.number,
            "totalItems" to userPage.totalElements,
            "totalPages" to userPage.totalPages
        )

        return ResponseEntity.ok(response)
    }

    @PostMapping
    fun createUser(@RequestBody user: User): User {
        return userRepository.save(user)
    }

    @GetMapping("/{id}")
    fun getUserById(@PathVariable id: String): ResponseEntity<User> {
        return userRepository.findById(id)
            .map { ResponseEntity.ok(it) }
            .orElse(ResponseEntity.notFound().build())
    }

    @GetMapping("/count")
    fun getUserCount(): ResponseEntity<Long> {
        val count = userRepository.count()
        return ResponseEntity.ok(count)
    }
}