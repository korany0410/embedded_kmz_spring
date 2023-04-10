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
		let pwd = f.pwd.value.trim();
		//유효성 체크
		if(name == ''){
			alert("이름을 입력하세요");
			return;
		}
		
		f.action="insert.do";
		f.method="post";
		f.submit();
	}
</script>


</head>
<body>
	<!-- 파일 전송시 form태그가 반드시 가져야할 두가지 속성 -->
	<form method="post" enctype="multipart/form-data">
		<table border="1" align="center">
		<caption>새 글 쓰기</caption>
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
			<th>비밀번호</th>
			<td><input type="password" name="pwd"></td>
		</tr>
		<tr>
			<th>첨부파일</th>
			<td><input type="file" name="photo" ></td>
		</tr>
		<tr>
			<td colspan="2" align="center">
			<input type="button" value="글쓰기" onclick="send(this.form)">
			<input type="button" value="목록으로" onclick="location.href='list.do'">
			</td>
		</tr>
		</table>
		
	</form>
</body>
</html>