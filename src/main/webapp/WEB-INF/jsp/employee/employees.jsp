<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <link href="<s:url value='/css/main.css'/>" rel="stylesheet" type="text/css"/>
    <title><s:text name="label.employees"/></title>
</head>
<body>
<div class="titleDiv"><s:text name="application.title"/></div>
<h1><s:text name="label.employees"/></h1>
<a href="<s:url action="inputEmployee" />"><s:text name="label.employee.add"/></a>
<br/><br/>
<table class="borderAll">
    <tr>
        <th><s:text name="label.employeeId"/></th>
        <th><s:text name="label.firstName"/></th>
        <th><s:text name="label.lastName"/></th>
        <th><s:text name="label.salary"/></th>
        <th>   </th>
    </tr>
    <s:iterator value="employees" status="status">
        <tr class="<s:if test="#status.even">even</s:if><s:else>odd</s:else>">
            <td class="nowrap"><s:property value="employeeId"/></td>
            <td class="nowrap"><s:property value="firstName"/></td>
            <td class="nowrap"><s:property value="lastName"/></td>
            <td class="nowrap"><s:property value="salary"/></td>
            <td class="nowrap">
                <a href="<s:url action="inputEmployee">
                    <s:param name="employee.employeeId" value="employeeId"/>
                </s:url>"><s:text name="label.employee.edit"/></a>
                   
                <a href="<s:url action="deleteEmployee">
                    <s:param name="employee.employeeId" value="employeeId"/>
                </s:url>"><s:text name="label.employee.delete"/></a>
            </td>
        </tr>
    </s:iterator>
    </table>
</body>
</html>
