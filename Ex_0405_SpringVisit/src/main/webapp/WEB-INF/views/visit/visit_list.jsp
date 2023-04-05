<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>방명록</title>

<!--경로설정이 jsp와 다름 
	=> 패키지 이름의 마지막 'Artifact id: visit' 으로 올라가서 거기서부터 경로를 지정한다 -->
<link rel="stylesheet" href="/visit/resources/css/visit.css">

<!-- ajax사용을 위한 js파일 등록  -->
<script src="/visit/resources/js/httpRequest.js"></script>

<script>
	function del(f) {
		//원래비밀번호랑 비교
		let pwd = f.pwd.value; //원본비밀번호
		let c_pwd = f.c_pwd.value; //입력 비밀번호
		
		if( pwd != c_pwd ){
			alert("비밀번호 불일치");
			return;
		}
		
		//삭제확인
		if( !confirm("정말로 삭제할거야?ㅠ-ㅠ") ){
			return;
		}
		//삭제를 위한 url매핑 호출
	}
</script>
</head>
<body>
	<div id="main_box">
		<h1>방명록 리스트</h1>
		<div align="left">
			<!--
		spring에서는 jsp에서 ->jsp로 바로가는게 불가능하고 controller를 무조건 거쳐야 한다!!
	 location.href='insert_form.jsp'로 못씀 -->
			<input type="button" value="글쓰기"
				onclick="location.href='insert_form.do'">
		</div>

		<c:forEach var="vo" items="${list}">
			<div class="visit_box">
			<!-- <pre>: db에서 가져온 내용을 enter값 까지 그대로 저장 -->
				<div class="type_content"><pre>${vo.content}</pre></div>
				<div class="type_name">${vo.name}(${vo.ip})</div>
				<div class="type_regdate">작성일 : ${vo.regdate}</div>
				
				<form>
					<input type="hidden" name="idx" value="${vo.idx}">
					<input type="hidden" name="pwd" value="${vo.pwd}">
					<input type="password" name="c_pwd" placeholder="비밀번호"><!-- c_pwd:방금입력받은 비밀번호 -->
					
					<input type="button" value="수정" onclick="modify(this.form)">
					<input type="button" value="삭제" onclick="del(this.form)">
				
				</form>
			</div>
			
		</c:forEach>

	</div>




</body>
</html>