<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script src="js/httpRequest.js"></script>

<script>
<!-- 브라우저 실행시 가장 먼저 호출되는 메서드 영역 -->
	window.onload = function() {
		//var url = "list.do";
		var url = "http://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json?key=f5eef3421c602c6cb7ea224104795888&targetDt=20120101";
		sendRequest(url, null, resultFn, "Get");
	}

	function resultFn() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			var data = xhr.responseText; //서버에서 도착한 json형태의 문자열
			
			//data를 실제 json구조로 변경
			var json = (new Function('return' + "["+data+"]"))();

			var result = json[0].boxOfficeResult.dailyBoxOfficeList[0].movieNm;
			
			var disp = document.getElementById("disp");
			disp.innerHTML = result;
			
		}//if
	}//resultFn()
</script>

</head>
<body>
	<div id="disp"></div>
</body>
</html>