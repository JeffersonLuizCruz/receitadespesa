package event;

import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationEvent;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class EventLocationHeader extends ApplicationEvent{
	private static final long serialVersionUID = 1L;
	
	private HttpServletResponse httpServletResponse;
	private Long id;
	
	public EventLocationHeader(Object source, HttpServletResponse httpServletResponse, Long id) {
		super(source);
		this.httpServletResponse = httpServletResponse;
		this.id = id;	
	}



}
