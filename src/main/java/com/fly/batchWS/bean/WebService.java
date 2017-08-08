package com.fly.batchWS.bean;

public class WebService {
	
	private Integer idWS;
	private Integer idUrl;
	private String name;
	private String desc;
	private String methode;
	private String domaine;
	private String msgEntree;
	private String msgRetour;
	
	private String typeUrl;
	private String urlDirect;
	private String urlBroker;
	private Integer idServer;
	private Integer idDataBase;
	
	public Integer getIdWS() {
		return idWS;
	}
	public void setIdWS(Integer idWS) {
		this.idWS = idWS;
	}
	public Integer getIdUrl() {
		return idUrl;
	}
	public void setIdUrl(Integer idUrl) {
		this.idUrl = idUrl;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getMethode() {
		return methode;
	}
	public void setMethode(String methode) {
		this.methode = methode;
	}
	public String getDomaine() {
		return domaine;
	}
	public void setDomaine(String domaine) {
		this.domaine = domaine;
	}
	public String getMsgEntree() {
		return msgEntree;
	}
	public void setMsgEntree(String msgEntree) {
		this.msgEntree = msgEntree;
	}
	public String getMsgRetour() {
		return msgRetour;
	}
	public void setMsgRetour(String msgRetour) {
		this.msgRetour = msgRetour;
	}
	public String getTypeUrl() {
		return typeUrl;
	}
	public void setTypeUrl(String typeUrl) {
		this.typeUrl = typeUrl;
	}
	public String getUrlDirect() {
		return urlDirect;
	}
	public void setUrlDirect(String urlDirect) {
		this.urlDirect = urlDirect;
	}
	public String getUrlBroker() {
		return urlBroker;
	}
	public void setUrlBroker(String urlBroker) {
		this.urlBroker = urlBroker;
	}
	public Integer getIdServer() {
		return idServer;
	}
	public void setIdServer(Integer idServer) {
		this.idServer = idServer;
	}
	public Integer getIdDataBase() {
		return idDataBase;
	}
	public void setIdDataBase(Integer idDataBase) {
		this.idDataBase = idDataBase;
	}
	@Override
	public String toString() {
		return "WebService [idWS=" + idWS + ", idUrl=" + idUrl + ", name=" + name + ", desc=" + desc + ", methode="
				+ methode + ", domaine=" + domaine + ", msgEntree=" + msgEntree + ", msgRetour=" + msgRetour
				+ ", typeUrl=" + typeUrl + ", urlDirect=" + urlDirect + ", urlBroker=" + urlBroker + ", idServer="
				+ idServer + ", idDataBase=" + idDataBase + "]";
	}
	
	
	
}
