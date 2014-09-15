<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>flv</title>
    <script src="http://libs.baidu.com/jquery/1.9.0/jquery.js"></script>
    <script type="text/javascript">
        $(document).ready(function () {
            $('body').append('<div id="mediaplayer"></div>');
            $.getScript('${ctx}/static/js/jwplayer.js', function () {
                jwplayer("mediaplayer").setup({
                    flashplayer: "${ctx}/static/player.swf",
                    file: '${url}',
                    autostart: "true",
                    width: "100%",
                    aspectratio: "4:3"
                });
                //$('#mediaplayer_wrapper').css('z-index', '107').css('width', '853px').css('height', '505px').css('padding', '10px').addClass('bg_one').center();
            });

        });
    </script>
</head>
<body>

</body>
</html>
