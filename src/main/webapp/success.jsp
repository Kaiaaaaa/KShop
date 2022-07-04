<%--
  Created by IntelliJ IDEA.
  User: 12690
  Date: 2022/5/27
  Time: 18:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<% String token = (String) request. getRequestURI();
    out.print(token);
%>
</body>
</html>
