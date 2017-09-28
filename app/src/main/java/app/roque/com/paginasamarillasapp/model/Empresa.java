package app.roque.com.paginasamarillasapp.model;

public class Empresa {

    private Integer id;
    private String nombre;
    private String rubro;
    private Integer logo;
    private String direccion;
    private String telefono;
    private String correo;
    private String url;
    private String info;

    public Empresa(String nombre, String rubro, Integer logo,
                   String direccion, String telefono, String correo, String url, String info,Integer id) {
        this.nombre = nombre;
        this.rubro = rubro;
        this.logo = logo;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correo = correo;
        this.url = url;
        this.info = info;
        this.id = id;
    }

    public Empresa(String nombre, String rubro, Integer logo) {
        this.nombre = nombre;
        this.rubro = rubro;
        this.logo = logo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRubro() {
        return rubro;
    }

    public void setRubro(String rubro) {
        this.rubro = rubro;
    }

    public Integer getLogo() {
        return logo;
    }

    public void setLogo(Integer logo) {
        this.logo = logo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
