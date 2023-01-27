package io.management.hospital.entities.dto.response;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class MessageResponse {
	private LocalDateTime timestamp;
	private String message;
	private String status;

	public MessageResponse(String message, String status) {
		this.timestamp = LocalDateTime.now();
		this.message = message;
		this.status = status;
	}
}
