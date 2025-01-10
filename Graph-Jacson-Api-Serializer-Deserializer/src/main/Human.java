package main;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "type", visible = true)
@JsonSubTypes({ @JsonSubTypes.Type(value = User.class, name = "USER") })
public interface Human {

//	public void setType(String type);
//
//	public String getType();

	public String getId();

	public void setId(String id);

	public String getName();

	public void setName(String name);
}
