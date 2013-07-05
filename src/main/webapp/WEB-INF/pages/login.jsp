<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<html>
<head>
  <title>UseThisRoom: Login</title>
  <meta name="apple-mobile-web-app-capable" content="yes">
</head>
<body>
<div>
  Your login attempt was not successful, try again.<br/> Caused :
  ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
</div>
<form name="f" class="form-horizontal" name='f' action="<c:url value='j_spring_security_check' />" method='POST'>
  <label>email<input name="j_username"></label>
  <label>password<input type="password" name="j_password"></label>
  <label><input type='checkbox' name='_spring_security_remember_me' checked="checked"/>Remember Me</label>
  <button type="submit">Submit</button>
</form>
</body>
</html>