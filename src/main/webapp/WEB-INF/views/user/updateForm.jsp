<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>
<div class="container">
	<form>
		<input type="hidden" id="id" value="${principal.user.id}">
		<div class="form-group">
			<label for="username">이름:</label>
			<input type="text" value="${principal.user.username}" class="form-control" placeholder="Enter username" id="username" readonly="readonly">
		</div>
		<div class="form-group">
			<label for="email">이메일:</label>
			<input type="email" value="${principal.user.email}" class="form-control" placeholder="Enter email" id="email">
		</div>
		<div class="form-group">
			<label for="pwd">패스워드:</label>
			<input type="password" class="form-control" placeholder="Enter password" id="password">
		</div>
	</form>
	<button id="btn-update" class="btn btn-primary">회원수정</button>
</div>
<script src="/js/user.js"></script>
<%@ include file="../layout/footer.jsp"%>