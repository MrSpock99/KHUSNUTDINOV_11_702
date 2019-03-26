<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
    <link type="text/css" href="static/css/styles.css" rel="stylesheet">
    <script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
</head>
<body>

<div class="login-page">
    <div class="form">
        <form class="register-form" method="post">
            <input type="text" placeholder="name" name="name"/>
            <input type="password" placeholder="password" name="password"/>
            <input type="text" placeholder="email address" name="email"/>
            <button>create</button>
            <p class="message">Already registered? <a href="#">Sign In</a></p>
        </form>
        <form class="login-form" method="post">
            <input type="text" placeholder="email" name="email"/>
            <input type="password" placeholder="password" name="password"/>
            <button>login</button>
            <p onclick="onMessageClick()" class="message">Not registered? <a href="#">Create an account</a></p>
        </form>

        <script>
            function onMessageClick() {
                $('form').animate({height: "toggle", opacity: "toggle"}, "slow");
            }
        </script>
    </div>
</div>

</body>
</html>
