package com.cos.blog.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// 콤포지션 하지 말기 ! (User user 바로 적는 것) : . 으로 찾아들어가야해서 불편
// 필드명 하나하나 다 적기 ! : 쓸 때 편리

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PostDetailRespDto {
	private int id;
	private String title;
	private String content;
	private String username;
}
