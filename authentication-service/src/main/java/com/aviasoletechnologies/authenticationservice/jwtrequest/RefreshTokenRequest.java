package com.aviasoletechnologies.authenticationservice.jwtrequest;

import com.sun.istack.NotNull;

public class RefreshTokenRequest {
    @NotNull
    private String refreshToken;

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }
}
