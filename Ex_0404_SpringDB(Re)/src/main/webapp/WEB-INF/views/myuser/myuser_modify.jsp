<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script>

	function update(f) {
		f.action = "update.do";
		f.submit();
	}
</script>
</head>
<body>
	<form>
		<table border="1" align="center">
			<caption>회원 수정</caption>
			
			<tr>
				<th>회원명</th>
				<th>아이디</th>
				<th>비밀번호</th>
				<th>email</th>
				<th>회원주소</th>
				<th>비고</th>
				
			</tr>
			<tr>
				<td><input name="name"></td>
				<td><input name="id"></td>
				<td><input name="pwd"></td>
				<td><input name="email"></td>
				<td><input name="addr"></td>
				<td><input type="button" value="수정" onclick="update(this.form);" ></td>
				
			</tr>		
		</table>
	
	</form>
</body>
</html>