

import java.util.List;

import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.PathParam;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import model.Command;

@Path("/commands")
@Transactional
public class Commands {
    @GET
    @Path("/create")
    @Produces(MediaType.APPLICATION_JSON)
    public Command create(@QueryParam("user_id") String userId, @QueryParam("command") String command) {
        Command cmd = new Command();
        return cmd.create(userId, command);
    }

    @GET
    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Command> getCommandsByUser(@QueryParam("user_id") String userId) {
        Command cmd = new Command();
        return cmd.getCommandsByUser(userId);
    }

    @PUT
    @Path("/update/{id}/{command}")
    @Produces(MediaType.APPLICATION_JSON)
    public Command update(@PathParam("id") String id, @PathParam("command") String command) {        
        Command cmd = new Command();
        return cmd.update(Long.parseLong(id), command);
    }

    @DELETE
    @Path("/delete")
    @Produces(MediaType.APPLICATION_JSON)
    public void delete(@QueryParam("id") String id) {
        Command cmd = new Command();
        cmd.delete(Long.parseLong(id));
    }
}