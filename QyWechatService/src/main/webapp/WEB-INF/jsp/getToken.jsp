<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>填写corpId和agentId</title>
</head>

<body>

<form action="/qywxServer/api/qywx/showUserId" method="post">

    <h1>请在5min内填写corpId和agentId</h1>
    <input type="text" name="code" value="${code}" readonly="readonly"><br>
    corpId:<input type="text" name="corpId"><br>
    agentId:<input type="text" name="agentId"><br>
    <button type="submit">获取userId</button>


</form>

</body>
</html>