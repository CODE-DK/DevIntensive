package ru.skillbranch.devintensive

import org.junit.Assert.assertEquals
import org.junit.Test
import ru.skillbranch.devintensive.extensions.toUserView
import ru.skillbranch.devintensive.models.User
import java.util.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun test_instance() {
        val user1 = User("1")
        val user2 = User("2", "John", "Wick")
        val user3 = User("3", "John", "Silverman", null, lastVisit = Date(), isOnline = true)

        user1.printMe()
        println("$user1 $user2 $user3")
    }

    @Test
    fun test_factory() {
        val user = User.makeUser("John Seen")
        val copyUser = user.copy(id = "2", lastName = "Seen")
        println("$user \n$copyUser")
    }

    @Test
    fun test_decomposition() {
        val user = User.makeUser("John Seen")

        fun getUserInfo() = user

        val (id, firstName, lastName) = getUserInfo()

        println("$id $firstName $lastName")
        println("${user.id} ${user.firstName} ${user.lastName}")
    }

    @Test
    fun test_copy() {
        val user = User.makeUser("John Seen")
        val copyUser = user.copy(lastName = "Maxwell", lastVisit = Date())

        if (user == copyUser) {
            println("equals data and hash \n${user.hashCode()} $user \n${copyUser.hashCode()} $copyUser")
        } else {
            println("not equals data and hash \n${user.hashCode()} $user \n${copyUser.hashCode()} $copyUser")
        }

        if (user === copyUser) {
            println("equals address ${System.identityHashCode(user)} ${System.identityHashCode(copyUser)}")
        } else {
            println("not equals address ${System.identityHashCode(user)} ${System.identityHashCode(copyUser)}")
        }
    }

    @Test
    fun test_data_mapping() {
        val user = User.makeUser("John Seen")
        user.printMe()

        val userView = user.toUserView()
        userView.printMe()
    }
}