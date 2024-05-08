<%@ page contentType="text/html;charset=Shift_JIS"%>
<%@ include file="/WEB-INF/jsp/jsp_header.jsp"%>
<html>
<head>
<title>商品詳細画面</title>
</head>
<body>
<div align="center" class="body">
<h2>商品詳細画面</h2>
<table>
	<tr>
		<td><img src="img/${item.pictureUrl}"></td>
		<td align="center">
		<table>
			<tr height="50">
				<td width="80">商品名</td>
				<td width="160">${item.itemName}</td>
			</tr>
			<tr height="50">
				<td width="80">価格</td>
				<td width="160">${item.price}円</td>
			</tr>
			<tr height="50">
				<td width="80">コメント</td>
				<td width="160">${item.description}</td>
			</tr>
			<tr>
				<td colspan="2" align="center" width="240"><a href="index.html">■一覧に戻る</a></td>
			</tr>
		</table>
		</td>
	</tr>
</table>
</div>
</body>
</html>