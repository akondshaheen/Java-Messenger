package com.akond.rest.messenger.resources;

import java.util.List;

import com.akond.rest.messenger.model.Profile;
import com.akond.rest.messenger.service.ProfileService;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/profiles")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProfileResource {

	private ProfileService profileServices = new ProfileService();
	
	@GET
	public List<Profile> getAllprofileServices(){
		return profileServices.getAllProfile();
	}
	
	@POST
	public Profile addProfile(Profile profile) {
		return profileServices.addProfile(profile);
	}
	
	@GET
	@Path("/{profileName}")
	public Profile getProfile(@PathParam("profileName") String profileName) {
		return profileServices.getProfile(profileName);
		
	}
	
	@PUT
	@Path("/{profileName}")
	public Profile updateProfile(@PathParam("profileName") String profileName, Profile profile) {
		profile.setProfileName(profileName);
		return profileServices.updateProfile(profile);
	}
	
	@DELETE
	@Path("/{profileName}")
	public Profile removeProfile(@PathParam("profileName") String profileName) {
		return profileServices.removeProfile(profileName);
		
	}
	
	
}
