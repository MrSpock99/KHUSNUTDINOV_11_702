<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
    <link href="http://localhost:8080/css/styles.css" type="text/css" rel="stylesheet">
    <script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
</head>
<body>

<div class="login-page">
    <div class="form">
        <form action="/signUp" method="post">
            <input type="text" placeholder="name" name="name"/>
            <input type="password" placeholder="password" name="password"/>
            <input type="email" placeholder="email address" name="email"/>
            <button>create</button>
            <p class="message">Already registered? <a href="/signIn">Sign In</a></p>
        </form>
    </div>
</div>

</body>
</html>
