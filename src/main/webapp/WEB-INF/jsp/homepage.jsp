<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style><%@include file="../static/bootstrap.min.css"%></style>
<header>
    <title>Funny movies</title>
</header>
<div class="d-flex flex-column flex-md-row align-items-center p-3 px-md-4 mb-3 bg-white border-bottom shadow-sm">
    <a href="/" class="my-0 mr-md-auto font-weight-normal text-decoration-none"> <h5 >Funny Movies</h5> </a>
    <nav class="my-2 my-md-0 mr-md-3">
        <c:choose>
            <c:when test="${!isAuthenticated}">
                <a class="p-2 btn btn-outline-primary" href="/login" name="LogIn">Sign In</a>
                <a class="p-2 btn btn-outline-primary" href="/registration" name="LogIn">Sign up</a>
            </c:when>
            <c:when test="${isAuthenticated}">
                <a class="p-2 btn btn-outline-primary" href="/share-movie/share">Share movie</a>
                <a class="p-2 btn btn-outline-primary" href="/logout" name="LogOut">Sign out</a>
            </c:when>
        </c:choose>
    </nav>
</div>
<div class="container">
    <c:forEach items="${movies}" var="movie">
        <div class="row mb-3">
            <div class="col-md-4 order-md-2 mb-4">
                <h4 class="">${movie.title}</h4>
                <label>${movie.description}</label>
            </div>
            <div class="col-md-8 order-md-1">
                <iframe title="YouTube video player" class="youtube-player" type="text/html" width="640"
                        height="390" src="http://www.youtube.com/embed/${movie.embedId}" frameborder="0"
                        allowFullScreen>
                </iframe>
            </div>
        </div>
    </c:forEach>
</div>
