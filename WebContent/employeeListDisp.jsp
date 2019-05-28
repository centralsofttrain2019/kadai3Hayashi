<%@ page language="java"
	contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean
		id="bean"
		class="jp.co.central_soft.train2019.bean.EmployeeListDispBean"
		scope="request" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>BeanStartWebApp</title>
</head>
<body>
ログイン：ID:<%=bean.getLogIninfo().getUserId() %>, NAME:<%=bean.getLogIninfo().getName() %>
, login date:<%=bean.getLogIninfo().getLoginDateTime() %><br>


従業員情報<br>

<table border="1" width="500" cellspacing="0" cellpadding="5" bordercolor="#333333">
<tr>
	<th>EmployeeID:</th>
	<th>EmployeeName:</th>
	<th>BloodType:</th>
	<th>eMail:</th>
	<th>HireFiscalYear:</th>
	<th>Birthday:</th>
	<th>Height:</th>
	<th>Weight:</th>

</tr>
<% for( jp.co.central_soft.train2019.bean.EmployeeDispBean e  :bean.getEmpList()){ %>
<tr>
	<td><%=e.getEmployeeID() %> </td>
	<td><%=e.getEmployeeName() %> </td>
	<td><%=e.getBloodType() %> </td>
	<td><%=e.geteMail() %> </td>
	<td><%=e.getHireFiscalYear() %> </td>
	<td><%=e.getBirthday() %> </td>
	<td><%=e.getHeight() %> </td>
	<td><%=e.getWeight() %> </td>
</tr>

<%} %>

</table>

</body>
</html>