<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>새 글 입력</title>
<!--경로설정이 jsp와 다름 
	=> 패키지 이름의 마지막 'Artifact id: visit' 으로 올라가서 거기서부터 경로를 지정한다 -->
<script type="text/javascript">
	function send(f) {
		
		let name = f.name.value.trim();
		let content = f.content.value.trim();
		
		f.action="modify.do";
		f.method="post";
		f.submit();
	}
</script>


</head>
<body>
	<form>
		<table border="1" align="center">
		<caption>글 수정</caption>
		<tr>
			<th>작성자</th>
			<td><input name="name"></td>
		</tr>
		<tr>
			<th>내용</th>
			<td>
			<!-- wrap="on" : 글 쓰다 길어지면 자동으로 줄바꿈 -->
				<textarea row="5" cols="50" name="content" style="resize:none;" wrap="on"></textarea>
			</td>
		</tr>
		<tr>
			<td colspan="2" align="center">
			<input type="button" value="취소" onclick="location.href='list.do'">
			<input type="button" value="완료" onclick="send(this.form)">
			</td>
		</tr>
		</table>
		
	</form>
</body>
</html>