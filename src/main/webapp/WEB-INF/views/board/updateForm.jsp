<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>
<div class="container">
	<form>
		<input type="hidden" id="id" value="${board.id}">
		<div class="form-group">
			<label for="title">제목:</label> 
			<input type="text" id="title" class="form-control" value="${board.title}" placeholder="Enter title">
		</div>
		<div class="form-group">
			<label for="content">내용:</label>
			<textarea class="form-control summernote" rows="5" id="content">${board.content}</textarea>
		</div>
	</form>
	<button id="btn-update" class="btn btn-primary">글쓰기</button>
</div>
<script>
	$(document).ready(function() {
		$('.summernote').summernote({
			tabsize : 2,
			height : 300
		});
	});
</script>
<script src="/js/board.js"></script>
<%@ include file="../layout/footer.jsp"%>