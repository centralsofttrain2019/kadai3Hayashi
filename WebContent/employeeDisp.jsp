<%@ page language="java"
	contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean
		id="bean"
		class="jp.co.central_soft.train2019.bean.EmployeeDispBean"
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

EmployeeID: <%=bean.getEmployeeID() %> <br>
EmployeeName:<%=bean.getEmployeeName() %> <br>
BloodType:<%=bean.getBloodType() %> <br>
eMail:<%=bean.geteMail() %> <br>
HireFiscalYear:<%=bean.getHireFiscalYear() %> <br>
Birthday:<%=bean.getBirthday() %> <br>
Height:<%=bean.getHeight() %> <br>
Weight:<%=bean.getWeight() %> <br>





</body>
</html>