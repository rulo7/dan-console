package es.raul.app.domain.model;

import java.io.Serializable;

public class Example implements Serializable{
    private int id;

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }
}
