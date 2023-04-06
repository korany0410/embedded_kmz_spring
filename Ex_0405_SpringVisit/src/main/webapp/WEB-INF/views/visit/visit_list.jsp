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
	//삭제 함수
	function del(f) {
		//원래비밀번호랑 비교
		let pwd = f.pwd.value; //원본비밀번호
		let c_pwd = f.c_pwd.value; //입력 비밀번호

		if (pwd != c_pwd) {
			alert("비밀번호 불일치");
			return;
		}

		//삭제확인
		if (!confirm("정말로 삭제할거야?ㅠ-ㅠ")) {
			return;
		}
		//삭제를 위한 url매핑 호출 ajax
		var url = "delete.do";
		var param = "idx=" + f.idx.value;
		sendRequest(url, param, resFn, "get");

	}

	//del 함수 ajax의 콜백 메서드
	function resFn() {
		if (xhr.readyState == 4 && xhr.status == 200) {

			//data = "no" 또는 data = "yes"
			var data = xhr.responseText;
			if (data == 'no') {
				alert("삭제 실패");
			} else {
				alert("삭제 성공");
			}
			location.href = "list.do"; //전체목록 갱신
		}
	}

	//modify함수
	function modify(f) {
		//수정시 기존 비밀번호와 일치하는지 검사
		let pwd = f.pwd.value;
		let c_pwd = f.c_pwd.value;

		if (pwd != c_pwd) {
			alert("비밀번호 불일치!");
			return;
		}
		//수정을 위한 url호출 ajax
		f.action = "modify.do";
		f.method = "post";
		
		//modify.do?idx=10&pwd=111&c_pwd=1111
		f.submit();
	}


	function change(idx) {
		var el_input = document.getElementById("type_input_content" + idx);
		if(el_input.style.display == "none"){		
		el_input.style.display = "block";
		} else {
		el_input.style.display = "none";
		}
		var el_text = document.getElementById("type_content" + idx);
		if(el_text.style.display == "none"){
		el_text.style.display = "block";
		} else {
		el_text.style.display = "none";
		}
	}

</script>
</head>
<body>
	<div id="main_box">
		<h1>방명록</h1>
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
				<form>
					<div id="type_input_content${ vo.idx }" style="display: none;">
						<textarea placeholder="${ vo.content }" name="content" cols="50"
							rows="5" style="width: 100%"></textarea>
						<br>
						<input type="button" value="취소" onclick="change(${vo.idx});" />
					</div>
					<div id="type_content${ vo.idx }" onclick="change(${vo.idx});"
						style="min-height: 100px; /* 최소 높이 */ height: auto; display: block;">
						<pre>${vo.content}</pre>
						<!-- 첨부된 파일이 있는경우에만 img태그를 사용하겠습니다 -->
						<c:if test="${vo.filename ne 'no_file'}">
							<img alt="" src="/visit/resources/upload/${vo.filename }"
								width="200" />
						</c:if>
					</div>
					<div class="type_name">${vo.name}(${vo.ip})</div>
					<div class="type_regdate">작성일 : ${vo.regdate}</div>

					<input type="hidden" name="idx" value="${vo.idx}"> <input
						type="hidden" name="pwd" value="${vo.pwd}"> <input
						type="password" name="c_pwd" placeholder="비밀번호">

					<!-- c_pwd:방금입력받은 비밀번호 -->

					<input type="button" value="수정" onclick="modify(this.form)">
					<input type="button" value="삭제" onclick="del(this.form)">

				</form>
			</div>

		</c:forEach>

	</div>




</body>
</html>