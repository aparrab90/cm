package modelo;

public class DatosContacto {

    private String telefonoContacto;
    private String correoElectronico;
    
    public DatosContacto(String telefonoContacto, String correoElectronico) {
        this.telefonoContacto = telefonoContacto;
        this.correoElectronico = correoElectronico;
    }

    public String getTelefonoContacto() {
        return telefonoContacto;
    }

    public void setTelefonoContacto(String telefonoContacto) {
        this.telefonoContacto = telefonoContacto;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }
}
