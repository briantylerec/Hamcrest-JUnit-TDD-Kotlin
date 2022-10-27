package com.cursosandroidant.auth

import org.hamcrest.Matchers.*
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Assert.assertThrows
import org.junit.Ignore
import org.junit.Test

class AuthHamcrestTest {

    //given_when_then

    @Test
    fun loginUser_correctData_returnsSuccessEvent(){
        val result = userAuthenticationTDD("ant@gmail.com", "1234")
        assertThat(AuthEvent.USER_EXIST, `is`(result))
    }

    @Test
    fun loginUser_wrongData_returnsFailEvent(){
        val result = userAuthenticationTDD("otro@gmail.com", "1234")
        assertThat(AuthEvent.USER_NOT_EXIST, `is`(result))
    }

    @Test
    fun loginUser_emptyEmail_returnsFailEvent(){
        val result = userAuthenticationTDD("", "1234")
        assertThat(AuthEvent.EMPTY_EMAIL, `is`(result))
    }

    @Test
    fun loginUser_emptyPassword_returnsFailEvent(){
        val result = userAuthenticationTDD("ant@gmail.com", "")
        assertThat(AuthEvent.EMPTY_PASSWORD, `is`(result))
    }

    @Test
    fun loginUser_emptyForm_returnsFailEvent(){
        val result = userAuthenticationTDD("", "")
        assertThat(AuthEvent.EMPTY_FORM, `is`(result))
    }

    @Test
    fun loginUser_invalidEmail_returnsFailEvent(){
        val result = userAuthenticationTDD("invalid.com", "1234")
        assertThat(AuthEvent.INVALID_EMAIL, `is`(result))
    }

    @Test
    fun loginUser_invalidPassword_returnsFailEvent(){
        val result = userAuthenticationTDD("ant@gmail.com", "1234e")
        assertThat(AuthEvent.INVALID_PASSWORD, `is`(result))
    }

    @Test
    fun loginUser_invalidUser_returnsFailEvent(){
        val result = userAuthenticationTDD("antgmail.com", "1234e")
        assertThat(AuthEvent.INVALID_USER, `is`(result))
    }

    @Test(expected = AuthException::class)
    fun loginUser_nullEmail_returnsException(){
        val result = userAuthenticationTDD(null, "1234")
        assertThat(AuthEvent.NULL_EMAIL, `is`(result))
    }

    @Test
    fun loginUser_nullPassword_returnsException(){
        assertThrows(AuthException::class.java) {
            println(userAuthenticationTDD("ant@gmail.com", null))
        }
    }

    @Test
    fun login_nullForm_returnsException(){
        try {
            val result = userAuthenticationTDD(null, null)
            assertThat(AuthEvent.NULL_FORM, `is`(result))
        } catch(e: Exception){
            (e as? AuthException)?.let {
                assertThat(AuthEvent.NULL_FORM, `is`(it.authEvent))
            }
        }
    }

    @Test
    fun login_completeForm_errorLengthPassword_returnsFailEvent(){
        val result = userAuthenticationTDD("ant@gmail.com", "123")
        assertThat(AuthEvent.LENGTH_PASSSWORD, `is`(result))
    }

    @Test
    fun checkNames_differentUsers_match(){
        assertThat("Maria", both(containsString("a")).and(containsString("i")))
    }

    @Test
    fun chechData_passwordEmail_notMatch(){
        val email = "ant@gmail.com"
        val password = "1234"
        assertThat(email, not(`is`(password)))
    }

    @Test
    fun checkExist_newEmail_returnsString(){
        val oldEmail = "ant@gmail.com"
        val newEmail = "ant@monksoft.com"
        val emails = arrayOf(oldEmail, newEmail)

        assertThat(emails, hasItemInArray(newEmail))
    }

    @Test
    fun checkDomain_arrayEmails_returnsString(){
        val nextEmail = "brian@monksoft.com"
        val oldEmail = "ant@gmail.com"
        val newEmail = "ant@monksoft.com"
        val emails = arrayListOf(oldEmail, newEmail, nextEmail)
        val newEmails = arrayListOf(newEmail, nextEmail)

        assertThat(newEmails, everyItem(endsWith("monksoft.com")))
    }
}