<%@ page import="java.util.Locale" %>
<%--
  Created by IntelliJ IDEA.
  User: Hwang
  Date: 10/26/15
  Time: 6:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="ex" uri="/WEB-INF/tlds/custom.tld" %>
<%@ taglib prefix="ex2" uri="/WEB-INF/tlds/custom2.tld" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>>
    <title>Tag Demo</title>
  </head>
  <body>
    <ex:Hello />
    <ex2:advHello username="Jeffrey" />

  </body>
</html>
