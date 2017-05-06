/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

/**
 *
 * @author Xristos Aslamagidis
 */
public class Event {
    int event_id; //primary key
    String title;
    String type;
    String eventLocation;
    String description;
    Municipallity munincipality; 

    public int getEvent_id() {
        return event_id;
    }

    public String getTitle() {
        return title;
    }

    public String getType() {
        return type;
    }

    public String getEventLocation() {
        return eventLocation;
    }

    public String getDescription() {
        return description;
    }

    public Municipallity getMunincipality() {
        return munincipality;
    }

    public void setEvent_id(int event_id) {
        this.event_id = event_id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setEventLocation(String eventLocation) {
        this.eventLocation = eventLocation;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setMunincipality(Municipallity munincipality) {
        this.munincipality = munincipality;
    }
    
    
    
    
    
    
}
