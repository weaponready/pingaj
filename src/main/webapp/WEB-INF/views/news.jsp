<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>新闻报道</title>
    <meta name="viewport" content="width=device-width,initital-scale=1.0"/>
    <style type="text/css">
        img {
            max-width: 100%;
        }
    </style>
    <c:set var="currentUrl" value="${requestScope['javax.servlet.forward.request_uri']}"></c:set>
    <c:if test="${!fn:endsWith(requestScope['javax.servlet.forward.request_uri'], '.android')}">
        <link rel="stylesheet" href="${ctx}/static/style/fullscreen.css">
        <script src="http://libs.baidu.com/jquery/1.9.0/jquery.js"></script>
        <script src="${ctx}/static/js/fullscreen.js"></script>
    </c:if>
</head>
<body>
<h2>${news.title}</h2>
<c:if test="${not empty news.url}">
    <c:choose>
        <c:when test="${fn:endsWith(news.url, '.flv') or fn:endsWith(news.url, '.mp4')}">
            <video src="${fn:replace(news.url,'.flv','.mp4')}"
                   width="100%" height="240" controls autobuffer>
            </video>
        </c:when>
        <c:when test="${fn:endsWith(news.url, '.mp3')}">
            <audio src="${news.url}" controls="controls">
            </audio>
        </c:when>
        <c:otherwise>
            <c:if test="${!fn:containsIgnoreCase(item.content, '<img')}">
                <img src="${news.url}">
            </c:if>
        </c:otherwise>
    </c:choose>
</c:if>
${news.content}
</body>
</html>
