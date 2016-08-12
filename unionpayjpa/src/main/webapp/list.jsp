<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%--
  Created by IntelliJ IDEA.
  User: 焦一平
  Date: 2014/12/27
  Time: 9:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  String basePath = request.getContextPath();
  String MethodURL=basePath+"/sourcecode/list.action?pageNumber=";
%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8"/>
  <title>源代码列表</title>

  <link href="http://libs.baidu.com/bootstrap/3.0.3/css/bootstrap.min.css" rel="stylesheet"/>
  <script type="text/javascript" src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>


  <script type="text/javascript">
    $(document).ready(function(){
      var totalNumber = Number(${totalPageNumber});
      var pageSize = Number(${pageSize});
      var pageCount = totalNumber/pageSize;
      var html = "";
      for(var i = 0;i<pageCount;i++){
        var link_Url = "<li><a href=\"<%=MethodURL%>"+(i+1)+"\">"+(i+1)+"</a></li>";
        html += link_Url;
      }
      var fenyeDiv = document.getElementById("link");
      fenyeDiv.innerHTML=html;
    });
  </script>
</head>
<body>
<a href="#" class="list-group-item active">
  源代码列表
</a>
    <c:forEach items="${sourceCodeList}" var="sourceCode">
      <a href="<%=request.getContextPath()%>/sourcecode/detail.action?id=<c:out value="${sourceCode.id}" />" class="list-group-item"><c:out value="${sourceCode.title}" /></a>
    </c:forEach>
<!-- 列表分页的DIV,由JS动态填充内容-->
<ul class="pagination pagination-lg" id="link">

</ul><br>

</body>
</html>