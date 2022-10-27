package com.cursosandroidant.auth

import org.junit.Assert
import org.junit.Before
import org.junit.Test

class AuthAlTest {

    //esta es una forma para procar cambiando los calores del email y pass, y deberia solo funcionar una prueba cada vez.

    private var email : String? = null
    private var password : String? = null

    @Before
    fun setup(){
        email = "ant@gmail.com"
        password = "1234"
    }

    @Test
    fun login_completeFrom_existUser_returnsSuccessEvent(){
        val isAuthenticated = userAuthenticationTDD(email, password)
        Assert.assertEquals(AuthEvent.USER_EXIST, isAuthenticated)
    }

    @Test
    fun login_completeForm_notExistUser_returnsFailEvent(){
        val isAuthenticated = userAuthenticationTDD(email, password)
        Assert.assertEquals(AuthEvent.USER_NOT_EXIST, isAuthenticated)
    }

    @Test
    fun login_emptyEmail_returnsFailEvent(){
        val isAuthenticated = userAuthenticationTDD(email, password)
        Assert.assertEquals(AuthEvent.EMPTY_EMAIL, isAuthenticated)
    }

    @Test
    fun login_emptyPassword_returnsFailEvent(){
        val isAuthenticated = userAuthenticationTDD(email, password)
        Assert.assertEquals(AuthEvent.EMPTY_PASSWORD, isAuthenticated)
    }

    @Test
    fun login_emptyForm_returnsFailEvent(){
        val isAuthenticated = userAuthenticationTDD(email, password)
        Assert.assertEquals(AuthEvent.EMPTY_FORM, isAuthenticated)
    }

    @Test
    fun login_completeForm_invalidEmail_returnsFailEvent(){
        val isAuthenticated = userAuthenticationTDD(email, password)
        Assert.assertEquals(AuthEvent.INVALID_EMAIL, isAuthenticated)
    }

    @Test
    fun login_completeForm_invalidPassword_returnsFailEvent(){
        val isAuthenticated = userAuthenticationTDD(email, password)
        Assert.assertEquals(AuthEvent.INVALID_PASSWORD, isAuthenticated)
    }

    @Test
    fun login_completeForm_invalidUser_returnsFailEvent(){
        val isAuthenticated = userAuthenticationTDD(email, password)
        Assert.assertEquals(AuthEvent.INVALID_USER, isAuthenticated)
    }

    @Test//(expected = AuthException::class)
    fun login_nullEmail_returnsException(){
        try {
            val isAuthenticated = userAuthenticationTDD(email, password)
            Assert.assertEquals(AuthEvent.NULL_EMAIL, isAuthenticated)
        } catch(e: Exception){
            (e as? AuthException)?.let {
                Assert.assertEquals(AuthEvent.NULL_EMAIL, it.authEvent)
            }
        }
    }

    @Test
    fun login_nullPassword_returnsException(){
        try {
            val isAuthenticated = userAuthenticationTDD(email, password)
            Assert.assertEquals(AuthEvent.NULL_PASSWORD, isAuthenticated)
        } catch(e: Exception){
            (e as? AuthException)?.let {
                Assert.assertEquals(AuthEvent.NULL_PASSWORD, it.authEvent)
            }
        }
    }

    @Test
    fun login_nullForm_returnsException(){
        try {
            val isAuthenticated = userAuthenticationTDD(email, password)
            Assert.assertEquals(AuthEvent.NULL_FORM, isAuthenticated)
        } catch(e: Exception){
            (e as? AuthException)?.let {
                Assert.assertEquals(AuthEvent.NULL_FORM, it.authEvent)
            }
        }
    }

    @Test
    fun login_completeForm_errorLengthPassword_returnsFailEvent(){
        val isAuthenticated = userAuthenticationTDD(email, password)
        Assert.assertEquals(AuthEvent.LENGTH_PASSSWORD, isAuthenticated)
    }
}