<%--
  Created by IntelliJ IDEA.
  User: fuzious
  Date: 12/13/2019
  Time: 5:38 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Ethereum-Counter</title>
</head>
<body>
    <form:form action="operation" modelAttribute="operationType">

        Deposit 1 <form:radiobutton path="operationType" value="increment"/>
        Deduct 1 <form:radiobutton path="operationType" value="decrement"/>
        GetBalance  <form:radiobutton path="operationType" value="getValue"/>

        <input type="submit" value="Submit"/>
    </form:form>
</body>
</html>
