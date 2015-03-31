$(document).ready(function(){

    $('img').wrap('<div class="fullscreen html5-fullscreen-api"></div>');
    $('.fullscreen').append('<span class="fs-button"></span>');

    $('.fs-button').on('click', function(){
        var elem = $(this).parent()[0];
        if (document.webkitFullscreenElement) {
            document.webkitCancelFullScreen();
        } else if (elem.requestFullscreen) {
            elem.requestFullscreen();
        } else if (elem.msRequestFullscreen) {
            elem.msRequestFullscreen();
        } else if (elem.mozRequestFullScreen) {
            elem.mozRequestFullScreen();
        } else if (elem.webkitRequestFullscreen) {
            elem.webkitRequestFullscreen();
        }
    });
});