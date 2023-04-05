<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	//목록 추가
	function add(f) {
		f.action = "add.do";
		f.submit();
	}

	//목록 수정
	function modify(f) {
		f.action = "modify.do";
		f.submit();
	}

	//목록 삭제
	function del(f) {
		f.action = "delete.do";
		f.submit();
	}
</script>

</head>
<body>
	<table border="1" align="center">
		<caption>USER-LIST</caption>

		<tr>
			<th>회원번호</th>
			<th>회원명</th>
			<th>아이디</th>
			<th>비밀번호</th>
			<th>email</th>
			<th>회원주소</th>
			<th>비고</th>

		</tr>
		<c:forEach var="vo" items="${list}">
			<tr>
				<td>${vo.idx}</td>
				<td>${vo.name}</td>
				<td>${vo.id}</td>
				<td>${vo.pwd}</td>
				<td>${vo.email}</td>
				<td>${vo.addr}</td>
				<td>
					<form>
						<input type="hidden" name="idx" value="${ vo.idx }" />
						<input type="hidden" name="name" value="${ vo.name }" />
						<input type="hidden" name="id" value="${ vo.id }" />
						<input type="hidden" name="pwd" value="${ vo.pwd }" />
						<input type="hidden" name="email" value="${ vo.email }" />
						<input type="hidden" name="addr" value="${ vo.addr }" />
						<input type="button" value="수정" onclick="modify(this.form);">
						<input type="button" value="삭제" onclick="del(this.form);">
					</form>
				</td>
			</tr>
		</c:forEach>
		<tr align="center">
			<td colspan="7">
				<input type="button" value="추가" onclick="add(this.form);">
			</td>
		</tr>
	</table>

</body>
</html>