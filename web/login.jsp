<%--
  Created by IntelliJ IDEA.
  User: yao
  Date: 2020/11/27
  Time: 10:24 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="description" content="xxxxx">
    <meta name="author" content="xxxxx">
    <meta name="keyword" content="xxxxx">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>xxxxx</title>
    <!-- start: Css -->
    <link rel="stylesheet" type="text/css" href="asset/css/bootstrap.min.css">
    <!-- plugins -->
    <link rel="stylesheet" type="text/css" href="asset/css/plugins/font-awesome.min.css"/>
    <link rel="stylesheet" type="text/css" href="asset/css/plugins/simple-line-icons.css"/>
    <link rel="stylesheet" type="text/css" href="asset/css/plugins/animate.min.css"/>
    <link rel="stylesheet" type="text/css" href="asset/css/plugins/icheck/skins/flat/aero.css"/>
    <link href="asset/css/style.css" rel="stylesheet">
    <!-- end: Css -->
    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="asset/js/html5shiv.min.js"></script>
    <script src="asset/js/respond.min.js"></script>
    <![endif]-->
</head>

<body id="mimin" class="dashboard form-signin-wrapper">
<div class="container">
    <form action="/login" method="post" class="form-signin">
        <div class="panel periodic-login"> <span class="atomic-number">V3.0</span>
            <div class="panel-body text-center">

                <p class="atomic-mass">xxxxx</p>
                <p class="element-name">xxxxx</p>
                <i class="icons icon-arrow-down"></i>
                <div class="form-group form-animate-text" style="margin-top:40px !important;">
                    <input type="text" id="name" name="name" class="form-text" required>
                    <span class="bar"></span>
                    <label>账号</label>
                </div>
                <div class="form-group form-animate-text" style="margin-top:40px !important;">
                    <input type="password" id="password" name="password" class="form-text" required>
                    <span class="bar"></span>
                    <label>密码</label>
                </div>

                <input type="submit" class="btn col-md-12" value="登 录"/>
            </div>
            <div class="text-center" style="padding:5px;"> 版权所有：xxxxxx </div>
        </div>
    </form>
</div>

<script src="asset/js/main.js"></script>
<c:if test="${message} != null">
    <script type="text/javascript">
        alert("${message}")
    </script>
</c:if>
</body>
</html>
