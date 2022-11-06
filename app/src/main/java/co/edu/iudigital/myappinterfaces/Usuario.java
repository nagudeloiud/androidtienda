package co.edu.iudigital.myappinterfaces;

import com.orm.SugarRecord;

public class Usuario extends SugarRecord<Usuario> {
    private String documento;
    private String nombre;
    private String ciudad;
    private String correo;
    private String password;

    public Usuario() {
    }

    public Usuario(String documento, String nombre, String ciudad, String correo, String password) {
        this.documento = documento;
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.correo = correo;
        this.password = password;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
