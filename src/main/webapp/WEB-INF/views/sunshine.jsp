<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>flv</title>
    <meta name="viewport" content="width=device-width,initital-scale=1.0"/>
    <%--<script src="http://libs.baidu.com/jquery/1.9.0/jquery.js"></script>--%>
    <style type="text/css">
        @media print {
            img { max-width: 400px; }
        }
    </style>
</head>
<body>
<c:forEach var="item" items="${list.items}">
    <h3>${item.title}</h3>
    ${item.content}
</c:forEach>
<script src="${ctx}/static/js/html5media.min.js"/>
</body>
</html>
