<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>
<div class="container">
	<form action="/auth/loginProc" method="post">
		<div class="form-group">
			<label for="username">이메일:</label>
			<input type="text" name="email" id="email" class="form-control" placeholder="Enter username">
		</div>
		<div class="form-group">
			<label for="pwd" >패스워드:</label>
			<input type="password" name="password" id="password" class="form-control" placeholder="Enter password">
		</div>
		<button type="submit" id="btn-login" class="btn btn-primary">로그인</button>
	</form>
</div>
<%@ include file="../layout/footer.jsp"%>
<script>
	let queryString = window.location.search;
	let urlParams = new URLSearchParams(queryString);
	let hasError = urlParams.has('error');
	
	if(hasError) {
		alert('로그인 실패');
	}
</script>