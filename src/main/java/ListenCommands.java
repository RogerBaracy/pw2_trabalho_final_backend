import java.util.List;

import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import model.ListenCommand;

@Path("/listen")
@Transactional
public class ListenCommands {   

    @GET
    @Path("create")      
    @Produces(MediaType.APPLICATION_JSON)
    public void setListenCommand(@QueryParam("user_id") String userId, @QueryParam("command") String command) {
        ListenCommand cmd = new ListenCommand();
        cmd.create(userId, command);
    }

    @GET
    @Path("list/last")       
    @Produces(MediaType.APPLICATION_JSON)
    public String getListenCommand(@QueryParam("user_id") String userId) {
        ListenCommand cmd = new ListenCommand();
        return cmd.getLastCommand(userId);
    }
}    
