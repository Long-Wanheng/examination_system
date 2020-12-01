<%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="description" content="12">
  <meta name="author" content="12">
  <meta name="keyword" content="12">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>xxxxx</title>
  <!-- start: Css -->
  <link rel="stylesheet" type="text/css" href="asset/css/bootstrap.min.css">
  <!-- plugins -->
  <link rel="stylesheet" type="text/css" href="asset/css/plugins/font-awesome.min.css"/>
  <link rel="stylesheet" type="text/css" href="asset/css/plugins/simple-line-icons.css"/>
  <link rel="stylesheet" type="text/css" href="asset/css/plugins/animate.min.css"/>
  <link rel="stylesheet" type="text/css" href="asset/css/plugins/fullcalendar.min.css"/>
  <link href="asset/css/style.css" rel="stylesheet">
  <!-- end: Css -->
  <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
  <!--[if lt IE 9]>
  <script src="asset/js/html5shiv.min.js"></script>
  <script src="asset/js/respond.min.js"></script>
  <![endif]-->
</head>

<body id="mimin" class="dashboard">
<!-- start: Header -->
<nav class="navbar navbar-default header navbar-fixed-top">
  <div class="col-md-12 nav-wrapper">
    <div class="navbar-header" style="width:100%;">
      <div class="opener-left-menu is-open"> <span class="top"></span> <span class="middle"></span> <span class="bottom"></span> </div>
      <a href="text.html" class="navbar-brand"> <b>欢迎光临</b> </a>
      <ul class="nav navbar-nav navbar-right user-nav">
        <li class="user-name"><span>Admin</span></li>
        <li class="dropdown avatar-dropdown"> <img src="asset/img/avatar.jpg" class="img-circle avatar" alt="user name" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true"/>
          <ul class="dropdown-menu user-dropdown">
            <li><a href="#"><span class="fa fa-power-off"></span> 退出登录</a></li>
          </ul>
        </li>
      </ul>
    </div>
  </div>
</nav>
<!-- end: Header -->
<div class="container-fluid mimin-wrapper">
  <!-- start:Left Menu -->
  <div id="left-menu">
    <div class="sub-left-menu scroll">
      <ul class="nav nav-list">
        <li>
          <div class="left-bg"></div>
        </li>
        <li class="ripple">
          <a class="nav-header" href="index.jsp">
            <span class="fa-home fa"></span> 首页 <span class="fa-angle-right fa right-arrow text-right"></span> </a>
        </li>
        <li class="active ripple">
          <a class="nav-header"  href="list.jsp">
            <span class="fa-diamond fa"></span> 考试 <span class="fa-angle-right fa right-arrow text-right"></span> </a>
        </li>

      </ul>
    </div>
  </div>
  <!-- end: Left Menu -->

  <!-- start: content -->
  <div id="content">
    <div class="panel">
      <div class="panel-body">
        <div class="col-md-6 col-sm-12">
          <h3 class="animated fadeInLeft">欢迎您：admin</h3>
          <p class="animated fadeInDown"><span class="fa  fa-map-marker"></span> 开发部</p>
        </div>
      </div>
    </div>

  </div>
  <!-- end: content -->

</div>

<!-- start: Javascript -->
<script src="asset/js/jquery.min.js"></script>
<script src="asset/js/jquery.ui.min.js"></script>
<script src="asset/js/bootstrap.min.js"></script>
<!-- plugins -->
<script src="asset/js/plugins/jquery.nicescroll.js"></script>
<!-- custom -->
<script src="asset/js/main.js"></script>
<!-- end: Javascript -->

</body>
</html>