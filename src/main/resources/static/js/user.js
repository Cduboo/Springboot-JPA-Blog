let index = {
	init : function() {
		$('#btn-save').on("click", () => {
			this.save();
		});
		$('#btn-update').on("click", () => {
			this.update();
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
			if(resp.status === 500) {
				alert("회원가입이 실패했습니다.");
			} else {
				alert("회원가입이 완료되었습니다.");				
				location.href = '/';
			}
		}).fail(function(error) {
			alert(JSON.stringify(error));
		});
	},
	
	update : function() {
		let data = {
			id : $('#id').val(),
			password : $('#password').val(),
			email : $('#email').val()
		};
		
		$.ajax({
			// 회원수정
			type : 'PUT',
			url : '/api/user',
			data : JSON.stringify(data), // http body 데이터
			contentType : 'application/json;charset=utf-8', // body 데이터의 타입 지정
			dataType : 'json' // 응답 데이터의 타입 지정
		}).done(function(resp) {
			alert("회원수정이 완료되었습니다.");
			location.href = '/logout';
		}).fail(function(error) {
			alert(JSON.stringify(error));
		});
	}
	
}

index.init();