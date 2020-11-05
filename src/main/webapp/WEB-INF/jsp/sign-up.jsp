<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style><%@include file="../static/bootstrap.min.css"%></style>
<header>
    <title>Sign up</title>
</header>

<div class="d-flex flex-column flex-md-row align-items-center p-3 px-md-4 mb-3 bg-white border-bottom shadow-sm">
    <a href="/" class="my-0 mr-md-auto font-weight-normal text-decoration-none"> <h5 >Funny Movies</h5> </a>
    <nav class="my-2 my-md-0 mr-md-3">
        <c:choose>
            <c:when test="${!isAuthenticated}">
                <a class="p-2 btn btn-outline-primary" href="/login" name="LogIn">Sign In</a>
            </c:when>
            <c:when test="${isAuthenticated}">
                <a class="p-2 btn btn-outline-primary" href="/share-movie/share">Share movie</a>
                <a class="p-2 btn btn-outline-primary" href="/logout" name="LogOut">Sign out</a>
            </c:when>
        </c:choose>
    </nav>
</div>
<div class="container">
    <div class="pricing-header px-3 py-3 pt-md-5 pb-md-4 mx-auto text-center">
        <h2 class="display-4">Registry User</h2>
    </div>
    <form action="/registration" method="POST" enctype="utf8">
        <div class="row">
            <div class="col-md-8 mb-3">
                <label class="col-md-3 mb-3">User Name</label>
                <input class="col-md-5 mb-3" id="userName" name="userName"/>
            </div>
        </div>
        <div class="row">
            <div class="col-md-8 mb-3">
                <label class="col-md-3 mb-3">Password</label>
                <input class="col-md-5 mb-3" id="password" name="password" type="password"/>
            </div>
        </div>

        <button class="btn btn-primary btn-lg" type="submit">Submit</button>
    </form>
</div>
