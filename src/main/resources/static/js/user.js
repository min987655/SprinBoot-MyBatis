let index={
//		한페이지 안에서 일어나는 이벤트를 index에 다 작성
//		충돌 일어날 확률 낮추고 깔끔해짐		
//		자바스크립트 오브젝트 생성 
		init: function() {
			
//			리스너 등록 됨(리스너가 이벤트를 지켜보고 이벤트가 일어나면 OS가 이벤트의 모든 컨텍스트를 가지고 감
//			화살표함수를 사용하여 부모를 바로 찾아가게 함
//			함수의 이름이 없어도 실행되어야 하는 함수 : 화살표 함수 사용
			$("#btn-save").on("click", ()=>{
				this.save(); // 콜백되는 스택
			});
			
//			리스너2
			$("#btn-login").on("click", ()=>{
				this.login(); // 콜백되는 스택
			});
		
		},
		
//		init 클릭하면 save 실행 됨
		save: function(){
			let data = {
					username: $("#username").val(),
					password: $("#password").val(),
					email: $("#email").val()
			}
			
			$.ajax({
				type: "POST",
				url: "/auth/joinProc",
//				json으로 데이터 주고받을거기 때문에 하단  공식임
//				js 문법 : 자바스트립트 오브젝트를 jsonString으로 바꿔즘
				data: JSON.stringify(data),
//				스프링은 데이터 받아서 오브젝트로 들고있기 때문에 json이 들어온다는 것을 메세지 컨버터에게 contentType으로 알려줘야 오브젝트 변활할 수 있음
				contentType: "application/json; charset=utf-8",
//				서버가 응답하는 데이터 타입
				dataType: "json"
			}).done(function(resp){
				alert("회원가입 성공");
				location.href="/";
				console.log(resp);
			}).fail(function(error){
				alert("회원가입 실패");
				console.log(error);
			})
		},

		login: function(){
			let data = {
					username: $("#username").val(),
					password: $("#password").val()
			}
			
			$.ajax({
				type: "POST",
				url: "/auth/loginProc",
				data: JSON.stringify(data),
				contentType: "application/json; charset=utf-8",
				dataType: "json"
			}).done(function(resp){
				if(resp.statusCode == 1){
					alert("로그인 성공");
					location.href="/";
				} else {
					alert("아이디와 패스워드를 다시 입력하세요.");
					console.log(resp);
				}				
			}).fail(function(error){
				alert("로그인 실패");
				console.log(error);
			})
		},
	}

index.init();