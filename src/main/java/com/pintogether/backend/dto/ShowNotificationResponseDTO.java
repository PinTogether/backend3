package com.pintogether.backend.dto;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pintogether.backend.exception.CustomException;
import com.pintogether.backend.model.StatusCode;
import com.pintogether.backend.websocket.NotificationType;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class ShowNotificationResponseDTO {
    private String subject;
    private NotificationType notificationType;
    private String object;

    @Override
    public String toString() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            throw new CustomException(StatusCode.INTERNAL_SERVER_ERROR, "JSON 파싱 중 예기치 않은 오류가 발생했습니다.");
        }
    }
}
