package begin.builder.adapter;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserDatePost {

	private String photoUrl;
	private int userId;
	private String description;
	private int likesQuantity;
	private LocalDate publishDate;

	@Override
	public String toString() {
		return "UserPost{" + "photoUrl='" + photoUrl + '\'' + ", publishDate=" + publishDate + ", userId=" + userId
				+ ", description='" + description + '\'' + ", likesQuantity=" + likesQuantity + '}';
	}
}