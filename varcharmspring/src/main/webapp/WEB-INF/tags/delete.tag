<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ attribute name="type"%>
<%@ attribute name="bnum"%>
<%@ attribute name="rid"%>

<c:choose>
	<c:when test="${type=='content'}">
		<c:if test="${mrole=='admin'}">
			<a href="deleteB.do?bnum=${bnum}">[삭제]</a>

		</c:if>
	</c:when>

	<c:when test="${type=='reply'}">
		<c:if test="${mrole=='admin'}">
			<a href="deleteMR.do?&rid=${rid}">[삭제]</a>

		</c:if>
	</c:when>

</c:choose>