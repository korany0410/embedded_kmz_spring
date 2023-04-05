<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	function send1(f) {
		//유효성 체크
		
		f.action = "insert1.do"; //insert1.do는 컨트롤러에서 만듬
		f.method = "post"; 
		/* 포스트로 보내면 한글이 깨질 가능성 높음 
			web.xml에서 post로 보내도 한글이 깨지지 않게 설정해두기 */
		f.submit();
	}
	
	
	//묶어서 파라미터 보내기
	function send2(f) {
		f.action = "insert2.do";
		f.submit();
	}

</script>
</head>
<body>
	<form>
		<table border="1">
			<tr>
				<th>이름</th>
				<td><input name="name"></td>
			</tr>
			<tr>
				<th>나이</th>
				<td><input name="age"></td>
			</tr>
			<tr>
				<th>전화번호</th>
				<td><input name="tel"></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="button" value="낱개로 전송" onclick="send1(this.form);">
					<input type="button" value="객체로 전송" onclick="send2(this.form);">
				</td>
			</tr>
			
		</table>
	</form>
	
	
	
</body>
</html>

























