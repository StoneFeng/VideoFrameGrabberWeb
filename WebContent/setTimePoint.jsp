<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%Long duration = (Long)request.getSession().getAttribute("duration"); %>
视频总长度是<%=duration %>秒，请输入你想获取的时间点：
<form action="setTimePoint.do" method="post">
<%-- <input type="hidden" name="duration" value="<%=duration %>">
<input type="hidden" name="filePath" value="<%=request.getAttribute("filePath") %>"> --%>
<table>
	<tr>
		<td>时间点</td>
		<td><input name="timePoint" type="text"></td>
		<td><input type="submit" name="Submit" value="抓取时间点上的图片"></td>
	</tr>
</table>
</form>
</body>
</html>