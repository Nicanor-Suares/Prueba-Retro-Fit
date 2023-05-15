package models;

public class Propietario {
    private String nombre;
    private String email;
    private String clave;
    private String telefono;
    private int id;

    public Propietario(String nombre, String email, String clave, String telefono, int id) {
        this.nombre = nombre;
        this.email = email;
        this.clave = clave;
        this.telefono = telefono;
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public String getClave() {
        return clave;
    }

    public String getTelefono() {
        return telefono;
    }

    public int getId() {
        return id;
    }
}
