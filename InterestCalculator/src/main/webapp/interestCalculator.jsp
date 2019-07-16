<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Interest Calculator</title>
</head>
<body>
<form action="cal" method="get">
       
     
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>Interest calculator</h2></caption>
            <tr>
                <th>Account No</th>
                <th>Balance</th>
                <th>Interest Rate</th>
                <th>Interest</th>
            </tr>
            
            <c:forEach items="${inf}" var="temp">
                <tr>
                    <td><c:out value="${temp.accountNo}" /></td>
                    <td><c:out value="${temp.balance}" /></td>
                    <td><c:out value="${temp.interestRate}" /></td>
                    <td><c:out value="${temp.interest}" /></td>
                </tr>
            </c:forEach>
                </table>
             
         <input type="button"  onclick="location.href='calculate'" value="Calculate" > 
         <input type="button"  onclick="location.href='clear'" value="Clear" >       
    </div>
    
    </form>
</body>
</html>