let index={
		init: function() {
			
			$("#btn-save").on("click", ()=>{
				this.save(); // 콜백되는 스택
			});					
		},
		
		save: function(){
			let data = {
					title: $("#title").val(),
					content: $("#content").val(),
					userId: $("#userId").val()
			}
			
			$.ajax({
				type: "POST",
				url: "/post",
				data: JSON.stringify(data),
				contentType: "application/json; charset=utf-8",
				dataType: "json"
			}).done(function(resp){
				console.log(resp);
				alert("글쓰기 성공");
				location.href="/";
				console.log(resp);
			}).fail(function(error){
				alert("글쓰기 실패");
				console.log(error);
			})
		}
	}

index.init();