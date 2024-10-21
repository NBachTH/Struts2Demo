<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
  <link href="<s:url value='/css/main.css'/>" rel="stylesheet" type="text/css"/>
  <title><s:text name="label.departments"/></title>
</head>
<body>
<div class="titleDiv"><s:text name="application.title"/></div>
<h1><s:text name="label.departments"/></h1>
<a href="<s:url action="inputDepartment" />"><s:text name="label.employee.add"/></a>
<br/><br/>
<table class="borderAll">
  <tr>
    <th><s:text name="label.departmentName"/></th>
    <th><s:text name="label.departmentID"/></th>
    <th>   </th>
  </tr>
  <s:iterator value="departments" status="status">
    <tr class="<s:if test="#status.even">even</s:if><s:else>odd</s:else>">
      <td class="nowrap"><s:property value="departmentName"/></td>
      <td class="nowrap"><s:property value="departmentId"/></td>
      <td class="nowrap">
        <a href="<s:url action="inputDeparment">
                    <s:param name="department.deparmentId" value="deparmentId"/>
                </s:url>"><s:text name="label.employee.edit"/></a>
           
        <a href="<s:url action="deleteDeparment">
                    <s:param name="deparment.deparmentId" value="deparmentId"/>
                </s:url>"><s:text name="label.employee.delete"/></a>
      </td>
    </tr>
  </s:iterator>
</table>
</body>
</html>
