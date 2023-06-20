let index = {
	init : function() {
		$('#btn-save').on("click", () => {
			this.save();
		});
	},
	
	save : function() {
		let data = {
			username : $('#username').val(),
			password : $('#password').val(),
			email : $('#email').val()
		};
		
		$.ajax({
			// 회원가입
			type : 'POST',
			url : '/auth/joinProc',
			data : JSON.stringify(data), // http body 데이터
			contentType : 'application/json;charset=utf-8', // body 데이터의 타입 지정
			dataType : 'json' // 응답 데이터의 타입 지정
		}).done(function(resp) {
			alert("회원가입이 완료되었습니다.");
			location.href = '/';
		}).fail(function(error) {
			aler(JSON.stringify(error));
		});
	}
}

index.init();