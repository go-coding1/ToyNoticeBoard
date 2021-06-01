package com.gocoding.noticeboard.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")  //이거는 of라는 이름의 static 팩토리 메서드 생성
public class BoardDto {
    @NotBlank(message="이름은 필수값입니다.")
    private String name;
}
