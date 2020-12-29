<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- String view = request.getparameter("rp"); -->
<c:set var="view" value="${param.rp }"/>
<c:choose>
<c:when test="${view eq null || view eq '' }">
	<c:set var="jsp" value="common/20_main.jsp"/>
</c:when>
<c:when test="${view eq 'iReg' }">
	<c:set var="jsp" value="ins/regist.jsp"/>
</c:when>
<c:when test="${view eq 'iList' }">
	<c:set var="jsp" value="ins/list.jsp"/>
</c:when>
<c:when test="${view eq 'iDetail' }">
	<c:set var="jsp" value="ins/detail.jsp"/>
</c:when>
<c:when test="${view eq 'iUpdate' }">
	<c:set var="jsp" value="ins/update.jsp"/>
</c:when>
<c:when test="${view eq 'rList' }">
	<c:set var="jsp" value="report/list.jsp"/>
</c:when>


<c:when test="${view eq 'prejoin' }">
		<c:set var="jsp" value="member/prejoin.jsp"/>
	</c:when>
	<c:when test="${view eq 'join' }">
		<c:set var="jsp" value="member/join.jsp"/>
	</c:when>
	<c:when test="${view eq 'sjoin' }">
		<c:set var="jsp" value="member/sjoin.jsp"/>
	</c:when>
	<c:when test="${view eq 'mList' }">
		<c:set var="jsp" value="member/list.jsp"/>
	</c:when>
	<c:when test="${view eq 'login' }">
		<c:set var="jsp" value="member/login.jsp"/>
	</c:when>
	<c:when test="${view eq 'mModify' }">
		<c:set var="jsp" value="member/modify.jsp"/>
	</c:when>
	<c:when test="${view eq 'board' }">
		<c:set var="jsp" value="board/board.jsp"/>
	</c:when>
	<c:when test="${view eq 'write' }">
		<c:set var="jsp" value="board/write.jsp"/>
	</c:when>
	<c:when test="${view eq 'bInfo' }">
		<c:set var="jsp" value="board/detail.jsp"/>
	</c:when>
	<c:when test="${view eq 'bMod' }">
		<c:set var="jsp" value="board/rewrite.jsp"/>
	</c:when>
	
	
<c:when test="${view eq 'preg' }">
		<c:set var="jsp" value="product/regist.jsp"/>
	</c:when>
	<c:when test="${view eq 'pli' }">
		<c:set var="jsp" value="product/list.jsp"/>
	</c:when>
	<c:when test="${view eq 'pmod' }">
		<c:set var="jsp" value="product/modify.jsp"/>
	</c:when>
	<c:when test="${view eq 'sli' }">
		<c:set var="jsp" value="support/list.jsp"/>
	</c:when>
</c:choose>
<jsp:include page="views/common/11_header.jsp"></jsp:include>
<jsp:include page="views/${jsp }"></jsp:include>
<jsp:include page="views/common/90_footer.jsp"></jsp:include>