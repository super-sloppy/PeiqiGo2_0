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
    <link rel="stylesheet" href="static/css/style1.css">
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
                <div class="main" style="margin-top: 10px;background-image: url(static/images/left1.png)"></div>
                <div class="main" style="float: right;background-image: url(static/images/right1.png)" ></div>

            </div>
        </div>
    </div>
    <div id="chat">
        <div id="chat-box" class="chat-box">

            <div class="chat-left" >
                <img src="static/images/peiqi.jpg" alt="Peiqi机器人" width="50" height="50"/>
                <div class="myfont"><p>hello</p></div>
            </div>


            <!--<div class="chat-right">
                nice!&nbsp;<img src="img/user.jpg" alt="user" width="50" height="50"/>
            </div>-->
        </div>
        <div id="evaluation">
            <div class="satisfaction">
                        <span style="float: right; width: 60px;height: 40px;float: left">
                            <img src="static/images/满意.png" height="30px" style="margin-top:5px;margin-left:15px  "/>
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
    <script src="static/js/jquery.js" type="text/javascript" charset="utf-8"></script>
    <script type="text/javascript">
        $(document).ready(function () {
            $(".chat-left").each(function() {
                    $(this).height($(this).children(".myfont").height());
                });
            $(".term").click(function () {

                var id = $(this).attr("id");
                switch(id){
                    case "term1":
                        $(".chat-box").append("<div class='chat-left'>"+
                            "<img src='static/images/peiqi.jpg' alt='Peiqi机器人' width='50' height='50'/><div class='myfont'> "+
                            "<p class='choose_pro' id='pro1_1'>存货贷款</p>"+
                            "<p class='choose_pro' id='pro1_2'>客帐贷款</p>"+
                            "<p class='choose_pro' id='pro1_3'>证券贷款</p>"+
                            "<p class='choose_pro' id='pro1_4'>不动产抵押贷款</p>"+
                            "</div></div>");
                        ;break;
                    case "term2":
                        $(".chat-box").append("<div class='chat-left'>"+
                            "<img src='static/images/peiqi.jpg' alt='Peiqi机器人' width='50' height='50'/><div class='myfont'> "+
                            "<p class='choose_pro' id='pro2_1'>能同时办理银行卡和存折吗</p>"+
                            "<p class='choose_pro' id='pro2_2'>能只办理银行卡吗</p>"+
                            "<p class='choose_pro' id='pro2_3'>ATM机单次最多可取多少钱</p>"+
                            "<p class='choose_pro' id='pro2_4'>ATM机单日最多可取多少钱</p>"+
                            "</div></div>");
                        ;break;
                    case "term3":
                        $(".chat-box").append("<div class='chat-left'>"+
                            "<img src='static/images/peiqi.jpg' alt='Peiqi机器人' width='50' height='50'/><div class='myfont'> "+
                            "<p class='choose_pro' id='pro3_1'>银行卡有效期</p>"+
                            "<p class='choose_pro' id='pro3_2'>银行卡磁条损坏</p>"+
                            "<p class='choose_pro' id='pro3_3'>办理使用银行存折和银行卡需要额外的费用吗</p>"+
                            "<p class='choose_pro' id='pro3_4'>银行卡丢失</p>"+
                            "</div></div>");
                        ;break;
                    case "term4":
                        $(".chat-box").append("<div class='chat-left'>"+
                            "<img src='static/images/peiqi.jpg' alt='Peiqi机器人' width='50' height='50'/><div class='myfont'> "+
                            "<p class='choose_pro' id='pro4_1'>负债业务</p>"+
                            "<p class='choose_pro' id='pro4_2'>资产业务</p>"+
                            "<p class='choose_pro' id='pro4_3'>中间业务</p>"+
                            "<p class='choose_pro' id='pro4_4'>金融租赁</p>"+
                            "</div></div>");
                        ;break;
                }
                $("#chat-box").scrollTop(10000);

            })

            $(".choose_pro").live("click",function(){
                var pro_id = $(this).attr("id");
                switch (pro_id){
                    case "pro1_1":$(".chat-box").append("<div class='chat-left'><img src='static/images/peiqi.jpg' alt='Peiqi机器人' width='50' height='50'/><div class='myfont'><p> "+ "您好，存货贷款也称商品贷款，是一种以企业的存贷或商品作为抵您好，存货贷款押品的短期贷款。"+ "</p></div></div>") ;break;
                    case "pro1_2":$(".chat-box").append("<div class='chat-left'><img src='static/images/peiqi.jpg' alt='Peiqi机器人' width='50' height='50'/><div class='myfont'><p> "+ "您好，客帐贷款是银行发放的以应收帐款作为抵押的短期贷款，称为“客帐贷款”。这种贷款一般都为一种持续性的信贷协定。"+ "</p></div></div>")  ;break;
                    case "pro1_3":$(".chat-box").append("<div class='chat-left'><img src='static/images/peiqi.jpg' alt='Peiqi机器人' width='50' height='50'/><div class='myfont'><p> "+ "您好，证券贷款是银行发放的企业借款，除以应收款和存货作为抵押外，也有不少是用各种证券特别是公司企业发行的股票和债券作押的。这类贷款称为“证券贷款”。"+ "</p></div></div>")  ;break;
                    case "pro1_4":$(".chat-box").append("<div class='chat-left'><img src='static/images/peiqi.jpg' alt='Peiqi机器人' width='50' height='50'/><div class='myfont'><p> "+ "您好，不动产抵押贷款通常是指以房地产或企业设备抵押品的贷款。特征有：1.从属性，不动产抵押是为担保债务的偿还而设立的，其从属性是明显的。2.优先受偿性，有关不动产抵押担保制度的立法，通常也是以此为立足点的。3.补充性，只有在债务人不履行合同义务时，才发生要求担保人履行担保责任的问题。4.特定性，包含两个意思：一是抵押担保的数额是一定的，二是抵押标的是特定的。5.不转移占有性，不动产抵押均不转移占有，抵押人对抵押财产仍能继续行使占有、使用收益和处分的权利。这是区别于其他担保的一个显著特点。"+ "</p></div></div>")  ;break;
                    case "pro2_1":$(".chat-box").append("<div class='chat-left'><img src='static/images/peiqi.jpg' alt='Peiqi机器人' width='50' height='50'/><div class='myfont'><p> "+ "您好，可以同时办理银行卡和存折。若您现在已经办了卡，可以去柜台补办存折。"+ "</p></div></div>")  ;break;
                    case "pro2_2":$(".chat-box").append("<div class='chat-left'><img src='static/images/peiqi.jpg' alt='Peiqi机器人' width='50' height='50'/><div class='myfont'><p> "+ "您好，可以只办理银行卡。若您现在已经办了卡，以后也可以去柜台补办存折"+ "</p></div></div>")  ;break;
                    case "pro2_3":$(".chat-box").append("<div class='chat-left'><img src='static/images/peiqi.jpg' alt='Peiqi机器人' width='50' height='50'/><div class='myfont'><p> "+ "您好，ATM机一次可取2000元，单日最多可取2万元（分十次取）"+ "</p></div></div>")  ;break;
                    case "pro2_4":$(".chat-box").append("<div class='chat-left'><img src='static/images/peiqi.jpg' alt='Peiqi机器人' width='50' height='50'/><div class='myfont'><p> "+ "您好，ATM机一次可取2000元，单日最多可取2万元（分十次取）"+ "</p></div></div>")  ;break;
                    case "pro3_1":$(".chat-box").append("<div class='chat-left'><img src='static/images/peiqi.jpg' alt='Peiqi机器人' width='50' height='50'/><div class='myfont'><p> "+ "您好，银行卡没有有效期，如果磁条坏了，可拿着卡和身份证去银行补办一张卡。"+ "</p></div></div>")  ;break;
                    case "pro3_2":$(".chat-box").append("<div class='chat-left'><img src='static/images/peiqi.jpg' alt='Peiqi机器人' width='50' height='50'/><div class='myfont'><p> "+ "您好，如果磁条坏了，可拿着卡和身份证去银行补办一张卡。"+ "</p></div></div>")  ;break;
                    case "pro3_3":$(".chat-box").append("<div class='chat-left'><img src='static/images/peiqi.jpg' alt='Peiqi机器人' width='50' height='50'/><div class='myfont'><p> "+ "您好，银行存折除了小额的账户管理费外不收别的费用，银行卡每年有10元的年费，在你办卡时须先在账户上存够10元以上，不过现在一些小银行是不收年费的，如中信、招商、浦发等。"+ "</p></div></div>")  ;break;
                    case "pro3_4":$(".chat-box").append("<div class='chat-left'><img src='static/images/peiqi.jpg' alt='Peiqi机器人' width='50' height='50'/><div class='myfont'> <p>"+ "请您带着身份证件前往当地银行办理挂失手续"+ "</p></div></div>")  ;break;
                    case "pro4_1":$(".chat-box").append("<div class='chat-left'><img src='static/images/peiqi.jpg' alt='Peiqi机器人' width='50' height='50'/><div class='myfont'> <p>"+ "您好，负债业务是商业银行通过对外负债方式筹措日常工作所需资金的活动，是商业银行资产业务和中间业务的基础，主要由自有资本、存款和借款构成，其中存款和借款属于吸收的外来资金，另外联行存款、同业存款、借入或拆入款项或发行债券等，也构成银行的负债。"+ "</p></div></div>")  ;break;
                    case "pro4_2":$(".chat-box").append("<div class='chat-left'><img src='static/images/peiqi.jpg' alt='Peiqi机器人' width='50' height='50'/><div class='myfont'> <p>"+ "您好，资产业务是指商业银行运用资金的业务，也就是商业银行将其吸收的资金贷放或投资出去赚取收益的活动。商业银行盈利状况如何经营是否成功，很大程度上取决于资金运用的结果 ，商业银行的资产业务一般有以下构成 ，其中以贷款和投资最为重要。"+ "</p></div></div>")  ;break;
                    case "pro4_3":$(".chat-box").append("<div class='chat-left'><img src='static/images/peiqi.jpg' alt='Peiqi机器人' width='50' height='50'/><div class='myfont'> <p>"+ "您好，中间业务是指商业银行代理客户办理收款、付款和其他委托事项而收取手续费的业务。是银行不需动用自己的资金，依托业务、技术、机构、信誉和人才等优势，以中间人的身份代理客户承办收付和其他委托事项，提供各种金融服务并据以收取手续费的业务。银行经营中间业务无须占用自己的资金，是在银行的资产负债信用业务的基础上产生的，并可以促使银行信用业务的发展和扩大。中间业务占银行收入比重逐年加大。"+ "</p></div></div>")  ;break;
                    case "pro4_4":$(".chat-box").append("<div class='chat-left'><img src='static/images/peiqi.jpg' alt='Peiqi机器人' width='50' height='50'/><div class='myfont'> <p>"+ "您好，金融租赁指由出租人根据承租人的请求，按双方的事先合同约定，向承租人指定的出卖人，购买承租人指定的固定资产，在出租人拥有该固定资产所有权的前提下，以承租人支付所有租金为条件，将一个时期的该固定资产的占有、使用和收益权让渡给承租人。金融租赁具有融物和融资的双重功能。金融租赁可以分为2大品种：直接融资租赁和出售回租。"+ "</p></div></div>")  ;break;
                }
                $("#chat-box").scrollTop(10000);
            });

            $(".pj").click(function () {
                $(".pjs").html("<p>&nbsp;&nbsp;谢谢您的评价，我们会继续努力的</p>");
            })


            var int=self.setInterval("big()",1100);
            $("#btn").click(function () {
                $("#chat-box").scrollTop(10000);
                var value = $(".chat-message").text();
                //消息不能为空
                if (value.trim()!=""){
                    $(".chat-box").append("<div class='chat-right'><img src='static/images/user.jpg' alt='user' width='50' height='50'/> <div class='myfont'><p>"+
                        value+"</p></div>"+
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
                                "<img src='static/images/peiqi.jpg' alt='Peiqi机器人' width='50' height='50'/><div class='myfont'> "+
                                json.text+
                                "</div></div>");
                            //使滚动条始终在底部
                            $('#chat-box').scrollTop($('#chat-box')[0].scrollHeight);
                        }
                    });
                }else {
                    alert("消息不能为空");
                }
            })
        });
        function big() {
            $(".big").each(function(){
                var bottom = $(this).css("bottom");
                switch(bottom){
                    case "20px":$(this).animate({bottom:"50px",height:"40px",width:"40px"},1000);break;
                    case "50px":$(this).animate({bottom:"100px",height:"60px",width:"60px"},1000);break;
                    case "100px":$(this).animate({bottom:"170px",height:"80px",width:"80px"},1000);break;
                    case "170px":$(this).animate({bottom:"250px",opacity:"0"},500); $(this).animate({bottom:"20px",height:"0px",width:"0px",opacity:"1"},100);$(this).animate({bottom:"20px",height:"20px",width:"20px"},300);break;
                }

            });
            $(".big2").each(function(){
                var bottom2= $(this).css("bottom");
                switch(bottom2){
                    case "30px":$(this).animate({bottom:"60px",height:"40px",width:"40px"},1000);break;
                    case "60px":$(this).animate({bottom:"110px",height:"60px",width:"60px"},1000);break;
                    case "110px":$(this).animate({bottom:"180px",height:"80px",width:"80px"},1000);break;
                    case "180px":$(this).animate({bottom:"260px",opacity:"0"},500); $(this).animate({bottom:"30px",height:"0px",width:"0px",opacity:"1"},100);$(this).animate({bottom:"30px",height:"20px",width:"20px"},300);break;
                }

            });
        };

    </script>
</body>
</html>
