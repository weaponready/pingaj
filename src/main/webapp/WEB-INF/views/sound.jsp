<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
        .title{
            text-align: center;
        }
    </style>
</head>
<body>
<h3 class="title">${sound.title}</h3>
<c:if test="${fn:endsWith(sound.url, '.flv')}">
    <video src="${fn:replace(sound.url,'.flv','.mp4')}"
           width="100%" height="240" controls autobuffer>
    </video>
</c:if>
<c:if test="${fn:endsWith(sound.url, '.mp3')}">
    <audio src="${sound.url}" controls="controls">
    </audio>
</c:if>
${sound.content}
<script src="${ctx}/static/js/html5media.min.js"/>
</body>
</html>
