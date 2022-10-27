package com.cursosandroidant.auth

import org.junit.Assert.assertEquals
import org.junit.Assert.assertThrows
import org.junit.Ignore
import org.junit.Test

class AuthTDDTest {

    @Test
    fun login_completeFrom_existUser_returnsSuccessEvent(){
        val isAuthenticated = userAuthenticationTDD("ant@gmail.com", "1234")
        assertEquals(AuthEvent.USER_EXIST, isAuthenticated)
    }

    @Test
    fun login_completeForm_notExistUser_returnsFailEvent(){
        val isAuthenticated = userAuthenticationTDD("otro@gmail.com", "1234")
        assertEquals(AuthEvent.USER_NOT_EXIST, isAuthenticated)
    }

    @Test
    fun login_emptyEmail_returnsFailEvent(){
        val isAuthenticated = userAuthenticationTDD("", "1234")
        assertEquals(AuthEvent.EMPTY_EMAIL, isAuthenticated)
    }

    @Test
    fun login_emptyPassword_returnsFailEvent(){
        val isAuthenticated = userAuthenticationTDD("ant@gmail.com", "")
        assertEquals(AuthEvent.EMPTY_PASSWORD, isAuthenticated)
    }

    @Test
    fun login_emptyForm_returnsFailEvent(){
        val isAuthenticated = userAuthenticationTDD("", "")
        assertEquals(AuthEvent.EMPTY_FORM, isAuthenticated)
    }

    @Test
    fun login_completeForm_invalidEmail_returnsFailEvent(){
        val isAuthenticated = userAuthenticationTDD("invalid.com", "1234")
        assertEquals(AuthEvent.INVALID_EMAIL, isAuthenticated)
    }

    @Test
    fun login_completeForm_invalidPassword_returnsFailEvent(){
        val isAuthenticated = userAuthenticationTDD("ant@gmail.com", "1234e")
        assertEquals(AuthEvent.INVALID_PASSWORD, isAuthenticated)
    }

    @Test
    fun login_completeForm_invalidUser_returnsFailEvent(){
        val isAuthenticated = userAuthenticationTDD("antgmail.com", "1234e")
        assertEquals(AuthEvent.INVALID_USER, isAuthenticated)
    }

    @Test(expected = AuthException::class)
    fun login_nullEmail_returnsException(){
        val isAuthenticated = userAuthenticationTDD(null, "1234")
        assertEquals(AuthEvent.NULL_EMAIL, isAuthenticated)
    }

    @Test
    fun login_nullPassword_returnsException(){
        assertThrows(AuthException::class.java){
            println(userAuthenticationTDD("ant@gmail.com", null))
        }
    }

    @Test
    fun login_nullForm_returnsException(){
        try {
            val isAuthenticated = userAuthenticationTDD(null, null)
            assertEquals(AuthEvent.NULL_FORM, isAuthenticated)
        } catch(e: Exception){
            (e as? AuthException)?.let {
                assertEquals(AuthEvent.NULL_FORM, it.authEvent)
            }
        }
    }

    @Ignore("Falta definir requisitos de cliente")
    @Test
    fun login_completeForm_errorLengthPassword_returnsFailEvent(){
        val isAuthenticated = userAuthenticationTDD("ant@gmail.com", "123")
        assertEquals(AuthEvent.LENGTH_PASSSWORD, isAuthenticated)
    }
}