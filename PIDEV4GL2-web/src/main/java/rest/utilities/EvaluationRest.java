package rest.utilities;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
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

import entities.Evaluation;
import entities.Mission;
import entities.TypeEvaluation;
import serviceEvaluation.ServiceEvaluation;

@Path("aaaa")
@RequestScoped
public class EvaluationRest {
	@EJB
	ServiceEvaluation evalService;
	
	
	

/*	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getListEvaluations() {
		if (evalService.getListEvaluations() != null) {
			return Response.status(Response.Status.ACCEPTED).entity(evalService.getListEvaluations()).build();
		} else {
			return Response.status(Response.Status.NO_CONTENT).build();
		}
	}*/
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getListEvaluations() {
		if (evalService.getListEvaluations() != null) {
			return Response.status(Response.Status.ACCEPTED).entity(evalService.getListEvaluations()).build();
		} else {
			return Response.status(Response.Status.NO_CONTENT).build();
		}
	}

	
	/*@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response AjoutEvaluation(Evaluation eval) {
		
		return Response.ok(evalService.addeval(eval)).build();
	}
	*/
	
	@DELETE
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public void deleteEval(@PathParam("id") int id)
	{
		
		this.evalService.deleteEvaluationById(id);
	}
	
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public  Response AjoutEvaluation(Evaluation eval) {
	if (evalService.addeval(eval) == 1) {
	return Response.status(Response.Status.CREATED).build();
	} else {
	return Response.status(Response.Status.NOT_FOUND).build();
	}
	}
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateMission(Evaluation eval) {

	try{evalService.updateEvaluation(eval);
	return Response.status(Response.Status.ACCEPTED).build();}
	catch(Exception e)
	{
	return Response.status(Response.Status.NOT_FOUND).build();
	}
	}
	
	
}
