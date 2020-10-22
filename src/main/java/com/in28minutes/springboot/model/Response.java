package com.in28minutes.springboot.model;

public class Response {
    private boolean sucess;

    public Response(boolean sucess) {
        this.sucess = sucess;
    }

    public boolean isSucess() {
        return sucess;
    }

    public void setSucess(boolean sucess) {
        this.sucess = sucess;
    }
}
