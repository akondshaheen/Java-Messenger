package com.akond.rest.messenger.database;

import java.util.HashMap;
import java.util.Map;

import com.akond.rest.messenger.model.Message;
import com.akond.rest.messenger.model.Profile;

public class DBManager {

	private static Map<Long, Message> messages = new HashMap<>();
	private static Map<String, Profile> profiles = new HashMap<>();
	
	
	public static Map<Long, Message> getMessages() {
		return messages;
	}
	public static Map<String, Profile> getProfiles() {
		return profiles;
	}
	
	
}
