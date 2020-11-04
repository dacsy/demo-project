<%@ taglib prefix="c" uri="http://www.springframework.org/tags"%>
<html>
<body>
<h1>Registry User</h1>
<form action="/registration" method="POST" enctype="utf8">
    <div>
        <label>User Name</label>
        <input id="userName" name="userName"/>
    </div>
    <div>
        <label>Password</label>
        <input id="password" name="password" type="password"/>
    </div>

    <button type="submit">Submit</button>
</form>
<a href="/login">Login</a>
</body>
</html>
