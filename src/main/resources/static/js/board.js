let index = {
	init : function() {
		$('#btn-save').on("click", () => {
			this.save();
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
	}
}

index.init();