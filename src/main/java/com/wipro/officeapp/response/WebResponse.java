package com.wipro.officeapp.response;




import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@AllArgsConstructor
public class WebResponse {
	
	
	@Getter @Setter
	private boolean status;
	private Object data;
	
	
	

}
