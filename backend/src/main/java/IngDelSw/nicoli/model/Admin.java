package IngDelSw.nicoli.model;

import java.time.LocalDateTime;

public class Admin extends User{
    private String first_name;
    /**
     *
     */
    private String last_name;
    /**
     *
     */

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
    public void promoteUser ()  {

    }

    /**
     * GETTERS AND SETTERS
     */
    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public LocalDateTime getEmail_verified_at() {
        return email_verified_at;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail_verified_at(LocalDateTime email_verified_at) {
        this.email_verified_at = email_verified_at;
    }
}
