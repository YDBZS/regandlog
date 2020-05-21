//验证密码是否一致
function check() {
    //首先验证两次输入密码是否一致
    var pass = $("#pass").val();
    var repass = $("#repass").val();
    var info = $("#info");
    if(pass != null && repass != null) {
        if (pass == repass) {
            info.html("两次密码一致");
        } else {
            info.html("两次密码不一致");
            $("#repass").val('')
        }
    }else {
        alert("请输入密码以及确认密码");
    }
}

//用户注册操作
function doLogin() {
    //前端进行md5盐值加密明文密码
    /*
    var salt = "1a2b3c4d";
    var str = "" + salt.charAt(0) + salt.charAt(2) + pass + salt.charAt(5) + salt.charAt(4);
    //把经过盐值的密码进行加密
    var password = md5(str);

    alert(password);
    */
    $.ajax({
        url:"/register/do_regist",
        type:"POST",
        data:{
            Name:$("#name").val(),
            Mobile:$("#mobile").val(),
            Password:$("#repass").val()
        },
        success:function (data) {
            if(null != data.msg){
                alert(data.msg);
            }
            if(null != data.data.Mobile) {
                alert(data.data.Mobile);
            }
            if(null != data.data.Name) {
                alert(data.data.Name);
            }
            if(null != data.data.Password) {
                alert(data.data.Password)
            }
            if(data.code == 200){
                //参数没有问题的话，跳转注册成功页面
                window.location.href = "/register/reg_success";
            }
        },
        error:function () {
            window.location.href = "/register/regerror";
        }
    })
}


//验证用户手机号是否已经注册
function check_tel() {
    var tel = $("#mobile").val();
    $.ajax({
        url:"/login/check_tel",
        type:"POST",
        data:{
            Mobile:tel
        },
        success:function (data) {
            if (data.code == 200){
                alert("此手机号已经存在注册，请更换！")
                var cf = confirm("点击确认");
                if (cf == true){
                    window.location.reload();
                }else {
                    window.location.reload();
                }
            }
        },
        error:function (data) {
            alert("服务器出现错误，请稍后重试！")
        }
    })
}



//获取验证码
function getCode() {
    $.ajax({
        url:"/register/getCode",
        type:"POST",
        success:function (data) {
            alert(data.data);
        }
    })
}

//离焦事件
function checkCode() {

}