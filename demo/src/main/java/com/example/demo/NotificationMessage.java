package com.example.demo;

public class NotificationMessage {

	private String message;

	private String channelType;

	private String routingKey;

	public NotificationMessage() {}

	public NotificationMessage(String message, String channelType, String routingKey) {
		this.message = message;
		this.channelType = channelType;
		this.routingKey = routingKey;
	}


	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getChannelType() {
		return channelType;
	}

	public void setChannelType(String channelType) {
		this.channelType = channelType;
	}

	public String getRoutingKey() {
		return routingKey;
	}

	public void setRoutingKey(String routingKey) {
		this.routingKey = routingKey;
	}

}

