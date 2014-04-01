<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>用户列表</title>
</head>
<body>
<table bordercolor="black" border="1" >
	<tr> 
	<td>userId</td>
	<td>username</td>
	<td>tel</td> 
	<td>email</td>
	<td>delete</td>
	</tr> 

	<c:forEach var="customer" items="${customerList}" > 
	
	      <tr> 
          <td> <c:out value="${customer.userId}" default=""/> 
          </td>

          <td> <c:out value="${customer.username}" default=""/> 
          </td> 
               
          <td> 
           <c:out value="${customer.tel}" default=""/> 
          </td> 
          
          <td> 
           <c:out value="${customer.email}" default=""/> 
          </td>
          
          <td> 
           <a href="/lubqtest/customerDel.do?userId=<c:out value="${customer.userId}"/>">Del</a> 
          </td>
          
          </tr> 
       </c:forEach> 

</table>
</body>
</html>