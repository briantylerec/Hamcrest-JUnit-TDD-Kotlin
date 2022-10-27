package com.cursosandroidant.auth

class AuthException(var authEvent: AuthEvent, msg: String? = null) : Exception (msg) {
}