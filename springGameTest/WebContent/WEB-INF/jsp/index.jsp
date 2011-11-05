<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
   <head>
      <link rel="stylesheet" href="./public_html/css/world.css" type="text/css"/>
      <title><spring:message code="application.name"/>
      </title>
   </head>
   <body class="primary">
      <%@ include file="snippet/mainSnippet.jsp"%>
      <%@ include file="snippet/eventSnippet.jsp"%>
      <%@ include file="snippet/homeSnippet.jsp"%>
      <%@ include file="snippet/footerSnippet.jsp"%>
   </body>
</html>