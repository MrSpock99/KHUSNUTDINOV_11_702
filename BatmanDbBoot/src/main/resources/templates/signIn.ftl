<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
    <link href="http://localhost:8080/css/styles.css" type="text/css" rel="stylesheet">
    <script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
</head>
<body>

<div class="login-page">
    <#if error??>
        <h1>Неправильный логин или пароль</h1>
    </#if>
    <div class="form">
        <form action="/signIn" class="login-form" method="post">
            <input type="text" placeholder="email" name="email"/>
            <input type="password" placeholder="password" name="password"/>
            <tr>
                <td>Remember Me:</td>
                <td><input type="checkbox" name="remember-me" /></td>
            </tr>
            <button>login</button>
            <p class="message">Not registered? <a href="/signUp">Create an account</a></p>
        </form>
    </div>
</div>
</body>
</html>
