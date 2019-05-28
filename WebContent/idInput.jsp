<%@ page language="java"
	contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean
		id="bean"
		class="jp.co.central_soft.train2019.bean.IdInputBean"
		scope="request" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>課題３</title>
</head>

<body>
ログイン者氏名：<%=bean.getName()  %> ログイン日時：<%=bean.getLoginDateTime() %><br>

<%=bean.getMessage() %>

<form  method="POST" action="EmployeeDispServlet">
指定のIDの従業員情報を表示します。<br>
IDを入力してください。<br><br>
	id<input name="id" type="text" ><br>
	<input type="submit" value="従業員表示">
</form>

<form  method="POST" action="EmployeeListDispServlet">
すべての従業員情報を表示します。<br>

	<input type="submit" value="全従業員表示">
</form>


</body>
</html>