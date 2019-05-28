<%@ page language="java"
	contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>課題３</title>
</head>

<body>

IDは数字で入力してください。
<form  method="POST" action="IdInputServlet">
ログインします。<br>
あなたのIDを入力してください。<br><br>
	id<input name="id" type="text" ><br>

	<input type="submit" value="ログイン">
</form>


</body>
</html>