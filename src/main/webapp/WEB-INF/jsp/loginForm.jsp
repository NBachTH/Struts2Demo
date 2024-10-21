<%--
  Created by IntelliJ IDEA.
  User: bach.nguyenthanh
  Date: 10/21/2024
  Time: 2:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <link href="<s:url value='/css/main.css'/>" rel="stylesheet" type="text/css"/>
    <title>Login Form</title>
</head>
<body>
<form class="my-form">
    <div class="login-welcome-row">
        <h1>Welcome</h1>
        <p>Please enter your information</p>
    </div>
    <div class="input__wrapper">
        <label for="email" class="input__label">Email:</label>
        <input type="text" id="email" name="email" class="input__field" placeholder="Your Account Name" required>
        <!-- svg -->
    </div>
    <div class="input__wrapper">
        <label for="password" class="input__label">Password:</label>
        <input id="password" type="password" class="input__field" placeholder="Your Password"
               title="Minimum 6 characters at least 1 Alphabet, 1 Number and 1 Symbol"
               pattern="^(?=.*[A-Za-z])(?=.*\d)(?=.*[\W_])[A-Za-z\d\W_]{6,}$" required>
        <!-- svg -->
    </div>
    <button type="submit" class="my-form__button">
        Login
    </button>
    <div class="socials-row">
        <a href="#" title="Use Google">
            <%--            <img src="assets/google.png" alt="Google">--%>
            Log in with Google
        </a>
    </div>
    <div class="my-form__actions">
        <div class="my-form__row">
            <span>Don't have an account?</span>
            <a href="#" title="Create Account">
                Sign Up
            </a>
        </div>
    </div>

</form>
</body>
</html>