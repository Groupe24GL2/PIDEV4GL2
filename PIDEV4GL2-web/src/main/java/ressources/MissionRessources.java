package ressources;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import entities.Mission;

import serviceMissionExpenses.MissionService;

@Path("mission")
@RequestScoped
public class MissionRessources {
	
	
	
	@EJB
	MissionService missionService;
	
	@Path("all")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response MissionsList() {
		
		//return Response.ok(missionService.getListMissions()).build();
		if (missionService.getListMissions() != null)
			return Response.status(Status.FOUND).entity(missionService.getListMissions()).build();
		return Response.status(Status.NOT_FOUND).build();
	}
	
	
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/delete/{missionID}")
	public Response deleteMission(@PathParam("missionID")int missionID) {
	missionService.deleteById(missionID);
		return Response.status(Status.OK).entity("mission removed").build();
	}
	
	
	
	@POST
	@Path("add")
	@Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
	public Response ajoutMission(Mission m)
	{
	 missionService.addMissionSer(m);;
	 return Response.status(Status.CREATED).entity(m).build();
		
	}


	
	  @PUT
	  @Path("update/{id}")
	  @Consumes(MediaType.APPLICATION_JSON)
	  @Produces(MediaType.APPLICATION_JSON)
	  public Response UpdateUser(@PathParam("id") int id, 	Mission m) {
	  	m.setId(id);
	  	missionService.updateMission(m, id);
	  	
	  	return Response.status(Status.OK).entity(m).build();
	  	
	  }

}
