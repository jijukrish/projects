package com.environment.manage;

import javax.ws.rs.core.Link;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlRootElement(name="Environment")
@XmlAccessorType(XmlAccessType.FIELD)
public class Environment {
	
	@XmlAttribute
	private Integer id;
	@XmlJavaTypeAdapter(Link.JaxbAdapter.class)
	@XmlElement
	private Link link;
	@XmlElement
	private String envName;
	@XmlElement
	private String appServer;
	@XmlElement
	private String dbServer;
	@XmlElement
	private String fileServer;
	@XmlElement
	private String status;
	
	public Environment(){ }
	public Integer getId() {
		return id;
	}
	public Link getLink() {
		return link;
	}
	public String getEnvName() {
		return envName;
	}
	public String getAppServer() {
		return appServer;
	}
	public String getDbServer() {
		return dbServer;
	}
	public String getFileServer() {
		return fileServer;
	}
	public String getStatus() {
		return status;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setLink(Link link) {
		this.link = link;
	}
	public void setEnvName(String envName) {
		this.envName = envName;
	}
	public void setAppServer(String appServer) {
		this.appServer = appServer;
	}
	public void setDbServer(String dbServer) {
		this.dbServer = dbServer;
	}
	public void setFileServer(String fileServer) {
		this.fileServer = fileServer;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
