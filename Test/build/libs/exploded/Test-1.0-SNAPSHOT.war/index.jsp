<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2018/3/20
  Time: 14:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <s:form action="answersSave.action">
    <s:textfield name="name"></s:textfield><!--方法2 使用ui标签库使用 将name存入值栈中 进行访问-->
    <s:submit/>
  </s:form>
  </body>
</html>
