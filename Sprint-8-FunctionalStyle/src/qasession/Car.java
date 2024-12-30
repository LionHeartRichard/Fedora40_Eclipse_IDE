package qasession;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Car {
	
	private String mark;

	@Override
	public String toString() {
		return "Car [mark=" + mark + "]";
	}
}
