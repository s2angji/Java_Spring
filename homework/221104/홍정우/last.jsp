<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>

<style type="text/css">
	h1 {
	color: red;
	}
</style>
<script type="text/javascript">
	function recvFn() {
		mydiv.innerHTML = xhr.responseText
	}
	function fn(uri) {
		mydiv.innerHTML=''
		
		xhr = new XMLHttpRequest()
		xhr.open('GET', uri)
		xhr.onload = recvFn
		xhr.send()
	}
</script>
</head>
<body>
	<h1>Test</h1>
	<button onclick="fn('insertLast.html')">입력</button>
	<button onclick="fn('test/selectProduct')">보기</button>
	<button onclick="fn('search.html')">검색</button>
	<hr>
	<div id="mydiv">
	</div>
</body>
</html>