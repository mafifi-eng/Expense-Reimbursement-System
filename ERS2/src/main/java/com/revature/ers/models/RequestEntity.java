package com.revature.ers.models;

public class RequestEntity {
	
	private int id;
	private int requestId;
	private String status;
	private String position;
	
	public RequestEntity(int id, int requestId, String status, String position) {
		this.id = id;
		this.requestId = requestId;
		this.status = status;
		this.position = position;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRequestId() {
		return requestId;
	}

	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	@Override
	public String toString() {
		return "RequestEntity [id=" + id + ", requestId=" + requestId + ", status=" + status + ", position=" + position
				+ "]";
	}



}
