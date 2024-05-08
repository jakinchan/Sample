<%@ page contentType="text/html;charset=Shift_JIS"%>
<%@ include file="/WEB-INF/jsp/jsp_header.jsp"%>
<html>
<head>
<title>???O?C?????</title>
</head>
<body>
<div align="center" class="body">
<h2>???O?C?????</h2>
<form:form modelAttribute="user" method="post" action="login.html">
	<spring:hasBindErrors name="user">
		<font color="red"><c:forEach items="${errors.globalErrors}"
			var="error">
			<spring:message code="${error.code}"  />
		</c:forEach> </font>
	</spring:hasBindErrors>
	<table>
		<tr height="40px">
			<td>???[?U?[ID</td>
			<td><form:input path="userId" cssClass="userId" /><font color="red"><form:errors
				path="userId" /></font></td>
		</tr>
		<tr height="40px">
			<td>?p?X???[?h</td>
			<td><form:password path="password" cssClass="password" /><font color="red"><form:errors
				path="password" /></font></td>
		</tr>
	</table>
	<table>
		<tr>
			<td align="center"><input type="submit" value="???O?C??"></td>
			<td align="center"><input type="reset" value="???Z?b?g"></td>
		</tr>
	</table>
</form:form></div>
</body>
</html>