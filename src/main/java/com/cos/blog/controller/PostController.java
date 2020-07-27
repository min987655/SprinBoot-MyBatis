package com.cos.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cos.blog.controller.dto.CommonRespDto;
import com.cos.blog.model.Post;
import com.cos.blog.service.PostService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor // DI에 final 걸고 해당 어노테이션 적을 시 @Autowired 한것과 같음 // 생성자 만들어 줌 
public class PostController {

	private final PostService postService;
	
//	@Autowired 한것과 같음
//	public PostController(PostService postService) {
//		this.postService = postService;
//	}
	
	@GetMapping("/post/saveForm")
	public String postForm() {
		return "post/saveForm";
	}
	
	@PostMapping("/post")
	public @ResponseBody CommonRespDto<?> postProc(@RequestBody Post post) {
		postService.글쓰기(post);
		return new CommonRespDto<String>(1, "글쓰기 성공");
	}	
	
	// post 관련된 것은 모두 인증필요하게
	// model : 리퀘스트 디스패쳐
	@GetMapping("/posts")
	public String getPosts(Model model){
		model.addAttribute("posts", postService.목록보기());
		return "index";
	}
	
	// 파라메터로 데이터를 받음(주소에서 데이터를 가져옴)
	// @PathVariable 주소의 데이터를 타입에 맞게 받아 줌
	// ? 주소 : 주소의 쿼리스트링을 받는 것
	// /post/{id} : 주소의 파라메터를 받는 것
	@GetMapping("post/{id}")
	public String getPost(@PathVariable int id, Model model) {
		model.addAttribute("postDetailRespDto", postService.상세보기(id));
		return "post/detail";
	}
	
	@DeleteMapping("/post/{id}")
	public @ResponseBody CommonRespDto<?> deleteById(@PathVariable int id) {
		postService.삭제하기(id);
		return new CommonRespDto<String>(1, "글삭제 성공");
	}

	@PutMapping("/post/{id}")
	public @ResponseBody CommonRespDto<?> update(@RequestBody Post post) {
		postService.수정하기(post);
		return new CommonRespDto<String>(1, "글수정 성공");
	}
}
