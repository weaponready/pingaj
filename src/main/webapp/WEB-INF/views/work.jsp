<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>${work.title}</title>
    <meta name="viewport" content="width=device-width,initital-scale=1.0"/>
    <style type="text/css">
        @media print {
            img { max-width: 400px; }
        }
    </style>
</head>
<body>
<h3>${work.title}</h3>
<c:if test="${fn:endsWith(work.url, '.flv')}">
<video src="${fn:replace(work.url,'.flv','.mp4')}"
       width="100%" height="240" controls autobuffer>
</video>
</c:if>
<c:if test="${fn:endsWith(work.url, '.mp3')}">
<audio src="${work.url}" controls="controls">
</audio>
</c:if>
${work.content}
<script src="${ctx}/static/js/html5media.min.js"/>
</body>
</html>
