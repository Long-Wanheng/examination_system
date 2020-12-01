<%--
  Created by IntelliJ IDEA.
  User: yao
  Date: 2020/12/1
  Time: 9:07 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>在线答题</title>

    <link rel="stylesheet" type="text/css" href="style.css" />

    <style type="text/css">
        .demo{width:760px; margin:60px auto 10px auto}
    </style>

    <script type="text/javascript" src="jquery.min.js"></script>
    <script type="text/javascript" src="quiz.js"></script>
    <script type="text/javascript">
        var init={'questions':[{'question':'jQuery是什么？','answers':['JavaScript库','CSS库','PHP框架','以上都不是'],'correctAnswer':1},{'question':'找出不同类的一项?','answers':['写字台','沙发','电视','桌布'],'correctAnswer':3},{'question':'国土面积最大的国家是：','answers':['美国','中国','俄罗斯','加拿大'],'correctAnswer':3},{'question':'月亮距离地球多远？','answers':['18万公里','38万公里','100万公里','180万公里'],'correctAnswer':2}]};

        $(function(){
            $('#quiz-container').jquizzy({
                questions: init.questions
            });
        });
    </script>
</head>

<body>

<div class="demo">
    <div id='quiz-container'></div>
</div>

</body>
</html>

