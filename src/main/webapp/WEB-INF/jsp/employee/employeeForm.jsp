<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<s:if test="employee==null || employee.employeeId == null">
	<s:set value="%{'Add new employee'}" var="title"/>
</s:if>
<s:else>
	<s:set value="%{'Update employee'}" var="name: title"/>
</s:else>

<html>
<head>
    <link href="<s:url value='/css/main.css'/>" rel="stylesheet" type="text/css"/>
    <style>td { white-space:nowrap; }</style>
    <title><s:property value="#title"/></title>
</head>
<body>
<div class="titleDiv"><s:text name="application.title"/></div>
<h1><s:property value="#title"/></h1>
<s:actionerror />
<s:actionmessage />
<s:form action="saveEmployee" method="post" cssStyle="width: 300px">
    <s:textfield name="employee.firstName" value="%{employee.firstName}" label="%{getText('label.firstName')}" size="40"/>
    <s:textfield name="employee.lastName" value="%{employee.lastName}" label="%{getText('label.lastName')}" size="40"/>
    <s:textfield name="employee.salary" value="%{employee.salary}" label="%{getText('label.salary')}" size="20"/>
    <s:hidden name="employee.employeeId" value="%{employee.employeeId}"/>
    <s:submit value="%{getText('button.label.submit')}"/>
    <s:submit value="%{getText('button.label.cancel')}" action="index"/>
</s:form>
</body>
</html>
