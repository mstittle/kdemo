package org.stittlem.kdemo

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest

@DataMongoTest
class RepositoriesTests @Autowired constructor(
        val userRepository: UserRepository,
        val articleRepository: ArticleRepository) {

    @Test
    fun `When findByIdOrNull then return Article`() {
        val juergen = User("springjuergen", "Juergen", "Hoeller")
        userRepository.save(juergen)
        val article = Article("Spring Framework 5.0 goes GA", "Dear Spring community ...", "Lorem ipsum", juergen)
        articleRepository.save(article)
        val found = articleRepository.findById(article._id!!)
        assertThat(found).isEqualTo(article)
    }

    @Test
    fun `When findByLogin then return User`() {
        val juergen = User("springjuergen", "Juergen", "Hoeller")
        userRepository.save(juergen)

        val user = userRepository.findByLogin(juergen.login)
        assertThat(user).isEqualTo(juergen)
    }
}