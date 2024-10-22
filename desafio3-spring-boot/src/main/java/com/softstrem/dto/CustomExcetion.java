package com.softstrem.dto;

import java.time.Instant;

public class CustomExcetion {

	private Instant timestamp;
	private Integer status;
	private String messege;
	private String path;

	public CustomExcetion(Instant timestamp, Integer status, String messege, String path) {
		super();
		this.timestamp = timestamp;
		this.status = status;
		this.messege = messege;
		this.path = path;
	}

	public Instant getTimestamp() {
		return timestamp;
	}

	public Integer getStatus() {
		return status;
	}

	public String getMessege() {
		return messege;
	}

	public String getPath() {
		return path;
	}

}
