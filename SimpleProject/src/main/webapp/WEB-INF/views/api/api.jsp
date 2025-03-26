<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공공데이터 활용하기</title>
</head>
<body>
	<jsp:include page="../include/header.jsp" />
	<h1> 병원데이터를 출력하자</h1>
	
	<button class="btn btn-sm btn-info" onclick="callHospitals();">병원정보</button>
	<div id="resultKey" style="width : 800px; height :600px; margin:auto;">
	 	<table class="table">
	 		<thead>
	 			<tr>
	 				<th width="200">병원명(INST_NM)</th>
	 				<th width="300">주소지(ADDR)</th>
	 				<th width="300">오시는길(ESNS_RGHMP)</th>
	 				<th width="150">전화번호(RPRS_TLHN_1)</th>
	 				
	 			</tr>
	 		</thead>
	 		<tbody>
	 		
	 		</tbody>
	 	</table>
	</div>
	<script>
		function callHospitals() {
			$.ajax({
				url : 'hospitals',
				type :'get',
				success : result =>{
					//console.log(result);
					const hospitals =result.body;
					
					const resultEl = hospitals.map(e=>
					`<tr>
			 				<td>\${e.INST_NM}</th>
			 				<td>\${e.ADDR}</th>
			 				<td>\${e.ESNS_RGHMP}</th>
			 				<td>\${e.RPRS_TLHN_1}</th>
	 				
	 				 </tr>`).join('');
					
					document.querySelector('tbody').innerHTML = resultEl;
					
					
					
				}
				
			})
		}
	
	</script>
	
	
	<br><br><br><br><br><br><br><br><br><br><br><br><br><br>
	<jsp:include page="../include/footer.jsp" />
</body>
</html>