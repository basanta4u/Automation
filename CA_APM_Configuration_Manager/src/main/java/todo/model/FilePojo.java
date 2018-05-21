package todo.model;

import java.util.List;

public class FilePojo {

	String filename;
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	
	List<PropertyPoJo> propertiesList;
	public List<PropertyPoJo> getProperties() {
		return propertiesList;
	}
	public void setProperties(List<PropertyPoJo> properties) {
		this.propertiesList = properties;
	}
	
}
