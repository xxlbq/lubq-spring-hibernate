<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="spring"
            uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>注册页面</title>
<style>  
.error {  
    color: #ff0000;  
    font-weight: bold;  
}  
</style> 
</head>
<body>

<h1>  <spring:message code="welcome.title" 
                              arguments="用户注册,表单"/></h1>
                        
<sf:form  modelAttribute="customer" action="/lubqtest/doReg.do" method="POST">
<%-- <sf:errors path="*" cssClass="error" /> --%>
<table>
	<tr>
		<td><p>姓名</p></td>
		<td><sf:input path="username"/></td>
		<td><sf:errors path="username" cssClass="error" /></td>
	</tr>
	<tr>
		<td><p>地址</p></td>
		<td><sf:input path="address"/></td>
		<td><sf:errors path="address" cssClass="error" /></td>
	</tr>
	<tr>
		<td><p>电话</p></td>
		<td><sf:input path="tel"/></td>
		<td><sf:errors path="tel" cssClass="error" /></td>
	</tr>
		<tr>
		<td><p>电子邮件</p></td>
		<td><sf:input path="email"/></td>
		<td><sf:errors path="email" cssClass="error" /></td>
	</tr>
	<tr>
		<td><p>备注</p></td>
		<td><sf:input path="memo"/></td>
		<td><sf:errors path="memo" cssClass="error" /></td>
	</tr>

	
	
	<tr>
		<td colspan="3"><input type="submit" value="注册" /></td>
	</tr>
	
</table>
</sf:form>







</body>
</html>