package IngDelSw.nicoli.model;

import java.time.LocalDateTime;

public class Medic extends User{


    private String email;
    /**
     *
     */

    private String password;
    /**
     *
     */

    private LocalDateTime email_verified_at;
    /**
     *
     */

    public void visits() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getEmail_verified_at() {
        return email_verified_at;
    }

    public void setEmail_verified_at(LocalDateTime email_verified_at) {
        this.email_verified_at = email_verified_at;
    }
}
