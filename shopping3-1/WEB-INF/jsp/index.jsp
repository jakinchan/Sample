<%@ page contentType="text/html;charset=Shift_JIS"%>
<%@ page session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" type="text/css" href="css/shopping3-1.css">
<html>
<head>
<title>商品一覧画面</title>
</head>
<body>
<div align="center" class="body">
<h2>商品一覧画面</h2>
<table border="1">
	<tr class="header">
		<th align="center" width="80">商品ID</th>
		<th align="center" width="320">商品名</th>
		<th align="center" width="100">価格</th>
	</tr>
	<c:forEach items="${itemList}" var="item">
		<tr class="record">
			<td align="center">${item.itemId}</td>
			<td align="left">${item.itemName}</td>
			<td align="right">${item.price}円</td>
		</tr>
	</c:forEach>
</table>
</div>
</body>
</html>