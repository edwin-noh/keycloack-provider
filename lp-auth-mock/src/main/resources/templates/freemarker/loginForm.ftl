<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
<h2>로그인</h2>
<form action="${doLogin}" method="post">
    <div class="login">
        <label for="uname"><b>Username</b></label>
        <input type="text" placeholder="Enter Username" name="id" required>
        <br><br>
        <label for="psw"><b>Password</b></label>
        <input type="password" placeholder="Enter Password" name="password" required>
        <br><br>
        <button type="submit">로그인</button>
    </div>
</form>
</body>
</html>