/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * @authors  Wilson Suarez, Natalia Escobar, Nicolás Penagos, Valentina Zapata
 * wilsonst.suarez@hotmail.com
 * nataliaescfer@gmail.com
 * nicolas.penagosm98@gmail.com
 * valentinazapataz0306@gmail.com
 **~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package co.natalia.xxiandroid.model;

/*
 * This class will represent each user of the Android nodo.
 */

public class AndroidUsers {

    // -------------------------------------
    // Atributtes
    // -------------------------------------
    private String id;
    private String username;
    private String email;
    private String pass;
    private String passc;

    // -------------------------------------
    // Constructors
    // -------------------------------------
    public AndroidUsers() {
    }

    public AndroidUsers(String id, String username, String email, String pass, String passc) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.pass = pass;
        this.passc = passc;
    }

    // -------------------------------------
    // Getters and setters
    // -------------------------------------
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getPassc() {
        return passc;
    }

    public void setPassc(String passc) {
        this.passc = passc;
    }
}
