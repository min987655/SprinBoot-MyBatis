package com.cos.blog.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// 원래는 Enum으로 만들어야 함
// 어떤오브젝트일지 모르기 때문에 제네릭 오브젝트 사용
// 공통적인 응답
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommonRespDto<T> {
	private int statusCode; // 1정상, -1실패, 0변경안됨
	private T data;
}
