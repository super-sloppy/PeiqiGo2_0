<%--
  Created by IntelliJ IDEA.
  User: 锴
  Date: 2018/3/1
  Time: 15:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>PeiqiGo智能客服系统</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="keywords" content="Peiqi,智能"/>
    <meta name="description" content="PeiqiGo智能客服系统">
    <link rel="stylesheet" href="static/css/test.css">
</head>
<body>
    <div class="header" >
        <div class="logo">
            <a href="">
                <img src="static/images/peiqigo.png"  />
            </a>

        </div>
        <div class="profile">
            <img src="static/images/user.jpg" />
        </div>
    </div>
    <div id="fixed">
        <dl>
            <dd>
                <a href="" class="intro">&nbsp;产品介绍</a>
            </dd>
            <dd>
                <a href="" class="analysis">&nbsp;数据分析</a>
            </dd>
            <dd>
                <a href="" class="question">&nbsp;常见问题</a>
            </dd>
            <dd>
                <a href="" class="connect">&nbsp;联系我们</a>
            </dd>
        </dl>
    </div>
    <div id="box">
        <div id="box1">

        </div>
        <div id="box2">

        </div>
    </div>
    <div id="chat">
        <div id="chat-box" class="chat-box">
            <div class="chat-left" >
                <img src="static/images/peiqi.jpg" alt="Peiqi机器人" width="50" height="50"/>
                hello!
            </div>
            <!--<div class="chat-right">
                nice!&nbsp;<img src="img/user.jpg" alt="user" width="50" height="50"/>
            </div>-->
        </div>
        <div id="evaluation">
            <a href="" class="satisfaction">
                        <span>
                            满意度评价
                        </span>
            </a>
            <a href="" class="problems">
                        <span>
                            常见问题
                        </span>
            </a>
        </div>
        <div id="message">
            <div class="chat-message" contenteditable="true">

            </div>
            <div class="send">
                <input type="button" id="btn" value="发送" />
            </div>
        </div>
    </div>
    <script src="static/js/jquery.js" type="text/javascript" charset="utf-8"></script>
    <script type="text/javascript">
        $(document).ready(function () {
            $("#btn").click(function () {
                var value = $(".chat-message").text();
                //消息不能为空
                if (value.trim()!=""){
                    $(".chat-box").append("<div class='chat-right'>"+
                        value+"<img src='static/images/user.jpg' alt='user' width='50' height='50'/>"+
                        "</div>");
                    //清空聊天输入框内容
                    $(".chat-message").html("");
                    //发送ajax请求
                    $.ajax({
                        type:"post",
                        url:"data.jsp",
                        data:{info:value},
                        success: function (data) {
                            var json = JSON.parse(data);
                            $(".chat-box").append("<div class='chat-left'>"+
                                "<img src='static/images/peiqi.jpg' alt='Peiqi机器人' width='50' height='50'/>"+
                                json.text+
                                "</div>");
                            //使滚动条始终在底部
                            $('#chat-box').scrollTop($('#chat-box')[0].scrollHeight);
                        }
                    });
                }else {
                    alert("消息不能为空");
                }
            })
        });
    </script>
</body>
</html>
