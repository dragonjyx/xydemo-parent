//登录校验
function onSubmit(flag){
    return flag;
}


$(function () {
    $('input').val('');

    $('#submit').on('click', function () {

        var ACCOUNT  = $("#account").val();
        var PASSWORD = $("#password").val();

        $('.username_tip').hide();
        $('.password_tip').hide();

        if(!ACCOUNT || ACCOUNT ==''){
            $('.username_tip').show();
            return onSubmit(false);
        }
        if(!PASSWORD || PASSWORD ==''){
            $('.password_tip').show();
            return onSubmit(false);
        }
        return onSubmit(true);

    });


})