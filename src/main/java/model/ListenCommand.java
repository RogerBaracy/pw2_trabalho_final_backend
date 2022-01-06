package model;

import java.util.List;

import javax.persistence.Entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
public class ListenCommand extends PanacheEntity {
    private String userId;
    private String command;

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

    public void create(String userId, String command){       
        this.setUserId(userId);
        this.setCommand(command); 
        this.persist();       
    }

    public String getLastCommand(String userId) {
     List<ListenCommand> list = this.list("userId", userId);
     if(list.size() >= 1){
        return list.get(list.size()-1).getCommand(); 
     }
     return "Não há comandos";
    }    
}
