<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.time.LocalDateTime" %>
<!DOCTYPE html>
<html>
<head>
    <title>Home Page</title>
</head>
<body>
<h1>Hello world!</h1>
<c:if test="${isAuthenticated}">
    <h3>Logged by: ${userName}</h3>
</c:if>

<a href="/share-movie/share">Share movie</a>
<h2>
    This is demo page
</h2>
<c:forEach items="${movies}" var="movie">
    <iframe title="YouTube video player" class="youtube-player" type="text/html" width="640"
        height="390" src="http://www.youtube.com/embed/${movie.embedId}" frameborder="0"
            allowFullScreen>
    </iframe>
    <div>
        <div>
            <label>${movie.title}</label>
        </div>
        <div>
            <label>${movie.description}</label>
        </div>
    </div>
</c:forEach>
<c:choose>
    <c:when test="${!isAuthenticated}">
        <a href="/login" name="LogIn">Log In</a>
    </c:when>
    <c:when test="${isAuthenticated}">
        <a href="/logout" name="LogOut">Log Out</a>
    </c:when>
</c:choose>
</body>
</html>
