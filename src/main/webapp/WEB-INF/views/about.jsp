<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>关于平安俊</title>
    <meta name="viewport" content="width=device-width,initital-scale=1.0"/>
    <style type="text/css">
        img {
            max-width: 100%;
        }
    </style>
</head>
<body>
${profile.content}
</body>
</html>
