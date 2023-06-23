let index = {
	init : function() {
		$('#btn-save').on("click", () => {
			this.save();
		});
		$('#btn-delete').on("click", () => {
			this.deleteById();
		});
		$('#btn-update').on("click", () => {
			this.update();
		});
		$('#btn-reply-save').on("click", () => {
			this.replySave();
		});
	},
	
	save : function() {
		let data = {
			title : $('#title').val(),
			content : $('#content').val()
		};
		
		$.ajax({
			// 글쓰기
			type : 'POST',
			url : '/api/board',
			data : JSON.stringify(data), // http body 데이터
			contentType : 'application/json;charset=utf-8', // body 데이터의 타입 지정
			dataType : 'json' // 응답 데이터의 타입 지정
		}).done(function(resp) {
			alert("글쓰기가 완료되었습니다.");
			location.href = '/';
		}).fail(function(error) {
			alert(JSON.stringify(error));
		});
	},
	
	deleteById : function() {
		var id = $('#id').text(); 
		$.ajax({
			// 글 삭제
			type : 'DELETE',
			url : '/api/board/'+id,
			dataType : 'json' // 응답 데이터의 타입 지정
		}).done(function(resp) {
			alert("글 삭제가 완료되었습니다.");
			location.href = '/';
		}).fail(function(error) {
			alert(JSON.stringify(error));
		});
	},
	
	update : function() {
		let id = $('#id').val();
		let data = {
			title : $('#title').val(),
			content : $('#content').val()
		};
		
		$.ajax({
			// 글 수정
			type : 'PUT',
			url : '/api/board/'+id,
			data : JSON.stringify(data), // http body 데이터
			contentType : 'application/json;charset=utf-8', // body 데이터의 타입 지정
			dataType : 'json' // 응답 데이터의 타입 지정
		}).done(function(resp) {
			alert("글 수정이 완료되었습니다.");
			location.href = '/';
		}).fail(function(error) {
			alert(JSON.stringify(error));
		});
	},
	
	replySave : function() {
		let data = {
			userId : $('#userId').val(),
			boardId : $('#boardId').val(),
			content : $('#reply-content').val()
		};
		
		$.ajax({
			// 댓글 쓰기
			type : 'POST',
			url : `/api/board/${data.boardId}/reply`,
			data : JSON.stringify(data), // http body 데이터
			contentType : 'application/json;charset=utf-8', // body 데이터의 타입 지정
			dataType : 'json' // 응답 데이터의 타입 지정
		}).done(function(resp) {
			alert("댓글 작성이 완료되었습니다.");
			location.href = `/board/${data.boardId}`;
		}).fail(function(error) {
			alert(JSON.stringify(error));
		});
	},
	
	replyDelete : function(boardId, replyId) {
		$.ajax({
			// 댓글 삭제
			type : 'DELETE',
			url : `/api/board/${boardId}/reply/${replyId}`,
			contentType : 'application/json;charset=utf-8', // body 데이터의 타입 지정
			dataType : 'json' // 응답 데이터의 타입 지정
		}).done(function(resp) {
			alert("댓글 삭제가 완료되었습니다.");
			location.href = `/board/${boardId}`;
		}).fail(function(error) {
			alert(JSON.stringify(error));
		});
	}
}

index.init();