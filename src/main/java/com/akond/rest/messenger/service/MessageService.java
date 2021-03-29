package com.akond.rest.messenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.akond.rest.messenger.database.DBManager;
import com.akond.rest.messenger.model.Message;


public class MessageService {
	private Map<Long, Message> messages = DBManager.getMessages();

	public MessageService() {
		messages.put(1L, new Message(1, "Hello Messenger", "Akond"));
		messages.put(2L, new Message(2, "Hello Messenger two", "Akond"));

	}
	
	public Message getMessage(long id) {
		return messages.get(id);
	}
	
	public List<Message> getAllMessages(){

		return new ArrayList <Message>(messages.values());
	}

	public Message addMessage(Message message) {
		message.setId(messages.size()+1);
		
		messages.put(message.getId(), message);
		return message;
	}
	
	public Message updateMessage( Message message) {
		if(message.getId()<=0) {
			return null;
		}
		messages.put(message.getId(), message);
		return message;
	}
	
	public Message removeMessage(long id) {
		return messages.remove(id);
	}
}
