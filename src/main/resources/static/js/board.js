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
			aler(JSON.stringify(error));
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
			aler(JSON.stringify(error));
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
			aler(JSON.stringify(error));
		});
	}
}

index.init();