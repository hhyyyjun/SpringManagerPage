<%@ tag language="java" pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<nav class="navbar navbar-expand-lg navbar-dark ftco_navbar bg-dark ftco-navbar-light" id="ftco-navbar">
	    <div class="container">
	      <a class="navbar-brand" href="main.do">VAR<span>CHAR</span></a>
	      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#ftco-nav" aria-controls="ftco-nav" aria-expanded="false" aria-label="Toggle navigation">
	        <span class="oi oi-menu"></span> Menu
	      </button>

	      <div class="collapse navbar-collapse" id="ftco-nav">
	        <ul class="navbar-nav ml-auto">
	        
	          <li class="nav-item active"><a href="main.do" class="nav-link">메인화면</a></li>
	        <c:choose>
	        	<c:when test="${userId!=null}">
	        		<li class="nav-item"><a href="logout.do" class="nav-link">로그아웃</a></li>
	        		<li class="nav-item"><a href="mypage.do" class="nav-link">마이페이지</a></li>
	        		<c:if test="${mrole!='일반회원'}">
	        		<li class="nav-item"><a href="manager.do" class="nav-link">관리자페이지</a></li>
	        		</c:if>
	        		
	        	</c:when>
	        	<c:otherwise>
		          <li class="nav-item"><a href="login.jsp" class="nav-link">로그인</a></li>
		          <li class="nav-item"><a href="signup.jsp" class="nav-link">회원가입</a></li>
	        	</c:otherwise>
	        </c:choose>
	          <li class="nav-item"><a href="boardMain.do" class="nav-link">문의 게시판</a></li>
	     
	         <li class="nav-item"><a href="filter.do" class="nav-link">내 차 사기</a></li>
	        <!-- 일단 주석 
	          <li class="nav-item"><a href="blog.html" class="nav-link">Blog</a></li>
	          <li class="nav-item"><a href="contact.html" class="nav-link">Contact</a></li>
	          -->
	        </ul>
	      </div>
	    </div>
	  </nav>