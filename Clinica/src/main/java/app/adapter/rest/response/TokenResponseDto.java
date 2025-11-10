package app.adapter.rest.response;

public class TokenResponseDto {
	private String token;
	private String role; // AGREGADO: Campo para el rol

	public TokenResponseDto() {
	}

	public TokenResponseDto(String token) {
		this.token = token;
	}

	public TokenResponseDto(String token, String role) {
		this.token = token;
		this.role = role;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
}
