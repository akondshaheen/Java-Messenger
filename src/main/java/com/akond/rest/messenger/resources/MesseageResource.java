package com.akond.rest.messenger.resources;

import java.util.List;

import com.akond.rest.messenger.model.Message;
import com.akond.rest.messenger.service.MessageService;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/messages")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MesseageResource {

	MessageService messageService = new MessageService();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Message> getMessages() {
		return messageService.getAllMessages();
	}

	@POST
	public Message addMessage(Message message) {
		return messageService.addMessage(message);
	}

	@DELETE
	@Path("/{messageID}")
	public void deleteMessage(@PathParam("messageID") long id) {
		messageService.removeMessage(id);
	}

	@PUT
	@Path("/{messageID}")
	public Message updateMessage(@PathParam("messageID") long id, Message message) {
		message.setId(id);
		return messageService.updateMessage(message);
	}

	@GET
	@Path("/{messageID}")
	public Message getMessageWithID(@PathParam("messageID") long ID) {
		return messageService.getMessage(ID);
	}

}
