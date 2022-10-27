package com.cursosandroidant.auth

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class AuthTest {

    @Test
    fun login_complete_returnsTrue(){
        val isAuthentificated = userAuthentication("ant@gmail.com","1234")
        assertTrue(isAuthentificated)
    }

    @Test
    fun login_complete_returnsFalse(){
        val isAuthentificated = userAuthentication("test@gmail.com","1234")
        assertFalse(isAuthentificated)
    }

//    @Test
//    fun login_emptyEmail_returnsFalse(){
//        val isAuthentificated = userAuthenticationTDD("","1234")
//        assertFalse(isAuthentificated)
//    }
//
//    @Test
//    fun login_nullEmail_returnsFalse(){
//        val isAuthentificated = userAuthenticationTDD(null,"1234")
//        assertFalse(isAuthentificated)
//    }
//
//    @Test
//    fun login_nullPassword_returnsFalse(){
//        val isAuthentificated = userAuthenticationTDD("ant@gmail.com",null)
//        assertFalse(isAuthentificated)
//    }
}