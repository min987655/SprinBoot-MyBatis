let index={
		init: function() {
			
			$("#btn-save").on("click", ()=>{
				this.save(); // 콜백되는 스택
			});
			
			$("#btn-delete").on("click", ()=>{
				this.deleteById(); // 콜백되는 스택
			});
			
			$("#btn-update-mode").on("click", ()=>{
				this.updateMode(); // 콜백되는 스택
			});
			
			$("#btn-update").on("click", ()=>{
				this.update(); // 콜백되는 스택
			});
			
			$("#btn-update").hide();
		},
		
		update: function(){
			
			let data = {
					id: $("#id").val(),
					title: $("#title").val(),
					content: $("#content").val()
			}
			
			$.ajax({
				type: "PUT",
				url: "/post/"+data.id,
				data: JSON.stringify(data),
				contentType: "application/json; charset=utf-8",
				dataType: "json"
			}).done(function(resp){
				console.log(resp);
				alert("글수정 성공");
				location.href="/post/"+data.id;
				console.log(resp);
			}).fail(function(error){
				alert("글수정 실패");
				console.log(error);
			})
		},
		
		updateMode: function() {
			$("#btn-update-mode").hide();
			$("#btn-update").show();
			
			$("#title").attr("readOnly",false);
			$("#content").attr("readOnly",false);
		},
		
		deleteById: function(){
			let data = {
					id: $("#id").val()
			}
			
			// 가지고 가는 데이터가 없기 때문에 컨텐트타입 적지 않기
			$.ajax({
				type: "DELETE",
				url: "/post/"+data.id,
				dataType: "json"
			}).done(function(resp){
				console.log(resp);
				alert("글삭제 성공");
				location.href="/";
				console.log(resp);
			}).fail(function(error){
				alert("글삭제 실패");
				console.log(error);
			})
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