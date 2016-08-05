<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>登录</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<script type="text/javascript" src="<%=basePath%>js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="<%=basePath%>js/login.js"></script>
</head>

<body>
	<div style="text-align: center;">
		<h2 align="center">欢迎登录</h2>
		<table align="center">
			<tr>
				<td>UserName:</td>
				<td><input type="text" name="username" /></td>
			</tr>
			<tr>
				<td>PassWord:</td>
				<td><input type="password" name="password" /></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input style="width: 98px;"
					type="submit" id="loginBtn" value="登录" /></td>

			</tr>
		</table>

	</div>
</body>
</html>