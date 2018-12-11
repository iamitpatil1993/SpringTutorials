package scopes.prototype;

import java.util.Date;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * 
 * @author amit 
 * This bean has prototype scope. It depicts Notepad. Notepad always creates new note.
 */

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class NotePad {

	private String text;
	private Date createdDate = new Date();
	private Date lastUpdatedDate;
	
	

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public void setLastUpdatedDate(Date lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getLastUpdatedDate() {
		return lastUpdatedDate;
	}

}
