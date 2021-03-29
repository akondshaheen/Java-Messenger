package com.akond.rest.messenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.akond.rest.messenger.database.DBManager;
import com.akond.rest.messenger.model.Message;


public class MessageService {

	private Map<Long, Message> messages = DBManager.getMessages();

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
