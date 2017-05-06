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
public class Announcements {
    int annoncements_id; //primar key
    String title;
    String reliability;
    String type;
    String description;
    String postcode;
    String road;

    Municipallity munincipality; 

    public int getAnnoncements_id() {
        return annoncements_id;
    }

    public String getTitle() {
        return title;
    }

    public String getReliability() {
        return reliability;
    }

    public String getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }

    public String getPostcode() {
        return postcode;
    }

    public String getRoad() {
        return road;
    }



    public Municipallity getMunincipality() {
        return munincipality;
    }

    public void setAnnoncements_id(int annoncements_id) {
        this.annoncements_id = annoncements_id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setReliability(String reliability) {
        this.reliability = reliability;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public void setRoad(String road) {
        this.road = road;
    }

   

    public void setMunincipality(Municipallity munincipality) {
        this.munincipality = munincipality;
    }
    
    
    
    

    
}
