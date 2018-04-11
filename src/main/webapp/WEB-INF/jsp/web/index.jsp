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
    <link rel="stylesheet" href="../../../static/css/style1.css">
</head>
<body>
    <div class="header" >
        <div class="logo">
            <a href="">
                <img src="../../../static/images/peiqigo.png"  />
            </a>

        </div>
        <div class="profile">
            <img src="../../../static/images/user.jpg" />
        </div>
    </div>
    <div id="fixed">
        <dl>
            <dd>
                <a href="" class="intro">&nbsp;产品介绍</a>
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
            <div class="content">
                <div class="big"  style="width: 20px; height: 20px;bottom: 20px;"></div>
                <div class="big" style="width: 40px; height: 40px;bottom: 50px;"></div>
                <div class="big" style="width: 60px; height: 60px;bottom: 100px;"></div>
                <div class="big" style="width: 80px; height: 80px;bottom: 170px;"></div>
                <div class="big2" style="width: 20px; height: 20px;bottom: 30px;"></div>
                <div class="big2" style="width: 40px; height: 40px;bottom: 60px;"></div>
                <div class="big2" style="width: 60px; height: 60px;bottom: 110px;"></div>
                <div class="big2" style="width: 80px; height: 80px;bottom: 180px;"></div>
            </div>
            <div class="content1">
                <div class="main" style="margin-top: 10px;background-image: url(../../../static/images/left1.png)"></div>
                <div class="main" style="float: right;background-image: url(../../../static/images/right1.png)" ></div>

            </div>
        </div>
    </div>
    <div id="chat">
        <div id="chat-box" class="chat-box">

            <div class="chat-left" >
                <img src="../../../static/images/peiqi.jpg" alt="Peiqi机器人" width="50" height="50"/>
                <div class="myfont"><p>hello</p></div>
            </div>


            <!--<div class="chat-right">
                nice!&nbsp;<img src="img/user.jpg" alt="user" width="50" height="50"/>
            </div>-->
        </div>
        <div id="evaluation">
            <div class="satisfaction">
                        <span style="float: right; width: 60px;height: 40px;float: left">
                            <img src="../../../static/images/满意.png" height="30px" style="margin-top:5px;margin-left:15px  "/>
                        </span>
                        <span style="float: right; width: 80px">
                            满意度评价
                        </span>
                <div class="eva_hidden">
                    <div class="pjs">
                        <div class="pj">
                            <img src="/static/images/非常满意.png" width="100%"/>
                        </div>
                        <div class="pj">
                            <img src="/static/images/满意.png" width="100%"/>
                        </div>
                        <div class="pj">
                            <img src="/static/images/不满意.png" width="100%"/>
                        </div>

                        <%--<p>&nbsp;&nbsp;谢谢您的评价，我们会继续努力的</p>--%>
                    </div>


                </div>
            </div>
            <div class="problems">

                        <span style="float: right;">
                            常见问题
                        </span>
                <div class="pro_hidden">
                    <div class="hidden_content" align="center">
                        <div class="term" id="term1">
                            第一类

                        </div>
                        <div class="term" id="term2">
                            第二类
                        </div>
                        <div class="term" id="term3">
                            第三类
                        </div>
                        <div class="term" id="term4">
                            第四类
                        </div>
                    </div>


                </div>
            </div>
        </div>
        <div id="message">
            <div class="chat-message" contenteditable="true">

            </div>
            <div class="send">
                <input type="button" id="btn" value="发送" />
            </div>
        </div>
    </div>
    <script src="../../../static/js/jquery.js" type="text/javascript" charset="utf-8"></script>
    <script type="text/javascript" src="../../../static/js/show.js"></script>
</body>
</html>
