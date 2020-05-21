function login() {
    var tel = $("#tel").val();
    var pass = $("#pass").val();

    $.ajax({
        url:"/login/do_login",
        type:"POST",
        data:{
            Mobile:tel,
            Password:pass
        },
        success:function (data) {
            if(null != data.msg){
                alert(data.msg)
            }
            if(data.code == 200){
                var r = confirm("登陆成功，点击确定跳转页面！")
                if(r == true){
                    window.location.href = "/login/login_success";
                }else {
                    window.location.reload();
                }
            }else if(data.code == 400){
                alert(data.msg);
                window.location.reload();
            }
        },
        error:function (data) {
            alert("服务器错误，请稍后重试！");
        }
    })
}




function findNum() {
    var num = $("#tel").val();
    var notice = $("#check");
    $.ajax({
        url:"/login/check_tel",
        type:"POST",
        data:{
            Mobile:num
        },
        success:function (data) {
            notice.html(data.msg);
        },
        error:function (data) {
            alert("服务器异常！！！！")
        }
    })
}