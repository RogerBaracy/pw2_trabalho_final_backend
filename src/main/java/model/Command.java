package model;

import java.util.List;

import javax.persistence.Entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
public class Command extends PanacheEntity {

    private String command;
    private String userId; 

    public String getCommand() {
        return this.command;
    }

    public void setCommand(String command) {
        this.command = command;
    } 

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    } 

    public Command create(String userId, String command){       
        this.setUserId(userId);
        this.setCommand(command); 
        this.persist();
        return this;
    }

    public List<Command> getCommandsByUser(String userId) {        
        return this.list("userId", userId);
    }

    public Command update(long id, String command){
        Command cmd = this.findById(id);
        cmd.setCommand(command);
        return cmd;
       

    }

    public void delete(long id) {
        this.delete("id", id);
    }
}    

