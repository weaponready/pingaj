<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>那片阳光</title>
    <meta name="viewport" content="width=device-width,initital-scale=1.0"/>
    <style type="text/css">

        img {
            max-width: 100%;
        }
        .title{
            text-align: center;
        }
    </style>
</head>
<body>
<c:forEach var="item" items="${list.items}">
    <h3 class="title">${item.title}</h3>
    <c:if test="${not empty item.url}">
        <c:choose>
            <c:when test="${fn:endsWith(item.url, '.flv') or fn:containsIgnoreCase(item.url, '.MP4')}">
                <video src="${fn:replace(item.url,'.flv','.mp4')}"
                       width="100%" height="240" controls autobuffer>
                </video>
            </c:when>
            <c:when test="${fn:endsWith(item.url, '.mp3')}">
                <audio src="${item.url}" controls="controls">
                </audio>
            </c:when>
            <c:otherwise>
                <c:if test="${!fn:containsIgnoreCase(item.content, '<img')}">
                <img src="${item.url}">
                </c:if>
            </c:otherwise>
        </c:choose>
    </c:if>
    <br>
    ${item.content}
    <hr>
</c:forEach>
<script src="${ctx}/static/js/html5media.min.js"/>
</body>
</html>
