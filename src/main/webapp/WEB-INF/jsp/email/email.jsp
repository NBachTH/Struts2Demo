<%--
  Created by IntelliJ IDEA.
  User: bach.nguyenthanh
  Date: 10/15/2024
  Time: 9:54 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
>
<html>
<head>
    <title>Email Form</title>
</head>
<body>
<em>The form below uses Google's SMTP server.
    So you need to enter a gmail username and password.
</em>
<s:form action="emailAction" method="post">
    <label for="from">From</label><br>
    <input type="text" id="from"/>
    <label for="password">Password</label><br/>
    <input type="password" id="password"/><br/>
    <label for="to">To</label><br/>
    <input type="text" id="to"/><br/>
    <label for="subject">Subject</label><br/>
    <input type="text" id="subject"/><br/>
    <label for="body">Body</label><br/>
    <input type="text" id="body"/><br/>
    <input type="submit" value="Send Email"/>
</s:form>
</body>
</html>
