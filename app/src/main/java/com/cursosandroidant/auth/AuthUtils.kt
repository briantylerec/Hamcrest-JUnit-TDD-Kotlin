package com.cursosandroidant.auth

fun userAuthentication(email: String, password: String): Boolean {
    if (email == "ant@gmail.com" && password == "1234") return true
    return false
}

fun userAuthenticationTDD(email: String?, password: String?): AuthEvent {

    if (password == null && email == null) throw AuthException(AuthEvent.NULL_FORM)

    if (email == null) throw AuthException(AuthEvent.NULL_EMAIL)

    if (password == null) throw AuthException(AuthEvent.NULL_PASSWORD)

    //
    if(password.isNotEmpty() && password.length<4) return AuthEvent.LENGTH_PASSSWORD

    //
    if (password.isNotEmpty() && !isNumeric(password) && email.isNotEmpty() && !isEmailValid(email)) return AuthEvent.INVALID_USER

    if (email.isNotEmpty() && !isEmailValid(email)) return AuthEvent.INVALID_EMAIL

    if (password.isNotEmpty() && !isNumeric(password)) return AuthEvent.INVALID_PASSWORD

    //
    if (password.isEmpty() && email.isEmpty()) return AuthEvent.EMPTY_FORM

    if (email.isEmpty()) return AuthEvent.EMPTY_EMAIL

    if (password.isEmpty()) return AuthEvent.EMPTY_PASSWORD


    if (email == "ant@gmail.com" && password == "1234") return AuthEvent.USER_EXIST

    return AuthEvent.USER_NOT_EXIST
}

fun isNumeric(password: String): Boolean {
    return try {
        val pass = password.toInt()
        true
    } catch (e: Exception){
        false
    }
}

fun isEmailValid(email: String): Boolean {
    val EMAIL_REGEX = "^[A-Za-z](.*)([@]{1})(.{1,})(\\.)(.{1,})"
    return EMAIL_REGEX.toRegex().matches(email);
}