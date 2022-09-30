<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="koala"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css"
	rel="stylesheet" />
<link href="css/manager.css" rel="stylesheet" />
<script src="https://use.fontawesome.com/releases/v6.1.0/js/all.js"
	crossorigin="anonymous"></script>
</head>
<body class="sb-nav-fixed">
	<nav class="sb-topnav navbar navbar-expand navbar-dark bg-dark">
		<!-- Navbar Brand-->
		<a class="navbar-brand ps-3" href="main.do">Varchar</a>
		<div id="newInput">
			<a href="managerClear.do">새로 등록하기</a>
		</div>

	</nav>
	<div id="layoutSidenav">
		<div id="layoutSidenav_content">
			<main>
				<div id="addCar" class="px-4">
					<div id="addCarImg">
					<c:set var="imgSrc" value="${data.cimg}"/>
						<img id="preview" src="${imgSrc}" alt="">
					</div>
					<div id="addCarInfo">
						<c:choose>
							<c:when test="${data!=null}">
								<form action="managerUpdate.do" method="post" enctype="multipart/form-data">
									<ul id="addCarInfoUl">
										<li><input type="hidden" name="cnum" value="${data.cnum}"></li>
										<li>차량명<input class="dataTable-input" type="text"
											name="ctitle" required value="${data.ctitle}"
											autocomplete="off"></li>
										<li>상세설명<input class="dataTable-input" type="text"
											name="csubtitle" required value="${data.csubtitle}"
											autocomplete="off"></li>
										<li>연식<input class="dataTable-input" type="text"
											name="cyear" required value="${data.cyear}"
											autocomplete="off"></li>
										<li>연료<input class="dataTable-input" type="text"
											name="cfuel" required value="${data.cfuel}"
											autocomplete="off"></li>
										<li>주행거리<input class="dataTable-input" type="text"
											name="ckm" required value="${data.ckm}" autocomplete="off"></li>
										<li>가격<input class="dataTable-input" type="text"
											name="cprice" required value="${data.cprice}"
											autocomplete="off"></li>
										<li>지역<input class="dataTable-input" type="text"
											name="ccity" required value="${data.ccity}"
											autocomplete="off"></li>
										<li>이미지<input class="dataTable-input" type="file"
											name="file" onchange="loadFile(this);" required
											value="${data.cimg}" autocomplete="off"></li>
										<li><input class="dataTable-input submitBtn"
											type="submit" value="수정하기"></li>
									</ul>
								</form>
							</c:when>
							<c:otherwise>
								<form action="insertCar.do" method="post" enctype="multipart/form-data">
									<ul id="addCarInfoUl">
										<li>차량명<input class="dataTable-input" type="text"
											name="ctitle" required autocomplete="off"></li>
										<li>상세설명<input class="dataTable-input" type="text"
											name="csubtitle" required autocomplete="off"></li>
										<li>연식<input class="dataTable-input" type="text"
											name="cyear" required autocomplete="off"></li>
										<li>연료<input class="dataTable-input" type="text"
											name="cfuel" required autocomplete="off"></li>
										<li>주행거리<input class="dataTable-input" type="text"
											name="ckm" required autocomplete="off"></li>
										<li>가격<input class="dataTable-input" type="text"
											name="cprice" required autocomplete="off"></li>
										<li>지역<input class="dataTable-input" type="text"
											name="ccity" required autocomplete="off"></li>
										<li>이미지<input class="dataTable-input" type="file"
											name="file" onchange="loadFile(this);" required
											autocomplete="off"></li>
										<li><input class="dataTable-input submitBtn"
											type="submit" value="등록하기"></li>
									</ul>
								</form>
							</c:otherwise>
						</c:choose>
					</div>
				</div>
				<div class="container-fluid px-4">
					<div class="card mb-4">
						<div class="card-header">
							<i class="fas fa-table me-1"></i> Car Information
						</div>
						<div class="card-body">
							<table id="datatablesSimple1">
								<thead>
									<tr>
										<th>차량명</th>
										<th>설명</th>
										<th>연료</th>
										<th>주행거리</th>
										<th>가격</th>
										<th>지역</th>
										<th>연식</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="c" items="${cdata}">
										<tr>
											<td><a href="selectCar.do?cnum=${c.cnum}">${c.ctitle}</a></td>
											<td>${c.csubtitle}</td>
											<td>${c.cfuel}</td>
											<td>${c.ckm}</td>
											<td>${c.cprice}</td>
											<td>${c.ccity}</td>
											<td>${c.cyear}</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
				</div>
				<div class="container-fluid px-4">
					<div class="card mb-4">
						<div class="card-header">
							<i class="fas fa-table me-1"></i> User Information
						</div>
						<div class="card-body">
							<table id="datatablesSimple2">
								<thead>
									<tr>
										<th>userId</th>
										<th>userPw</th>
										<th>userName</th>
										<th>userNickname</th>
										<th>useradd</th>
										<th>userphone</th>
										<th>useremail</th>
									</tr>
									<c:forEach var="m" items="${mdata}">
										<tr>
											<td>${m.mid}</td>
											<td>${m.mpw}</td>
											<td>${m.mname}</td>
											<td>${m.mnickname}</td>
											<td>${m.madd}</td>
											<td>${m.mphone}</td>
											<td>${m.memail}</td>
										</tr>
									</c:forEach>
								</thead>
							</table>
						</div>
					</div>
				</div>
			</main>
			<footer class="py-4 bg-light mt-auto">
				<div class="container-fluid px-4">
					<div
						class="d-flex align-items-center justify-content-between small">
						<div class="text-muted">Copyright &copy; Varchar</div>
					</div>
				</div>
			</footer>
		</div>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		crossorigin="anonymous"></script>
	<script src="js/scripts.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js"
		crossorigin="anonymous"></script>
	<script src="assets/demo/chart-area-demo.js"></script>
	<script src="assets/demo/chart-bar-demo.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/simple-datatables@latest"
		crossorigin="anonymous"></script>
	<script src="js/datatables-simple-demo.js"></script>

	<!-- 이미지 미리보기 -->
	<script>
		function loadFile(input) {
			console.log("Ddddd");
			if (input.files && input.files[0]) { //파일이 업로드 되었는지?
				console.log("Dddddsssss");
				var fr = new FileReader();
				fr.onload = function(event) { //파일이 로드 되었을 떄
					console.log("Dddddasdqweqweq");
					document.getElementById("preview").src = event.target.result; //input 대신 js를 이용해 src속성을 부여할 예정
				};
				fr.readAsDataURL(input.files[0]);
			} else {
				document.getElementById("preview").src = "";
			}
		}
	</script>
</body>
</html>