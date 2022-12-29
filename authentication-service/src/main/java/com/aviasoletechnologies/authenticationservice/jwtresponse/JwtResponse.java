package com.aviasoletechnologies.authenticationservice.jwtresponse;

import com.aviasoletechnologies.authenticationservice.model.User;

public class JwtResponse {

    private User user;
    private String jwtToken;
    public JwtResponse() {
        super();
        // TODO Auto-generated constructor stub
    }
    public JwtResponse(User user, String jwtToken) {
        super();
        this.user = user;
        this.jwtToken = jwtToken;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public String getJwtToken() {
        return jwtToken;
    }
    public void setJwtToken(String jwtToken) {
        this.jwtToken = jwtToken;
    }


}
