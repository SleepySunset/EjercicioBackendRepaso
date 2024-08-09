package model;

public class Veterinario {
    private Integer id;
    private int nroLicencia;
    private String nombre;
    private String apellido;
    private String especialidad;

    public Veterinario(int nroLicencia, String nombre, String apellido, String especialidad) {
        this.nroLicencia = nroLicencia;
        this.nombre = nombre;
        this.apellido = apellido;
        this.especialidad = especialidad;
    }

    public Veterinario(Integer id, int nroLicencia, String nombre, String apellido, String especialidad) {
        this.id = id;
        this.nroLicencia = nroLicencia;
        this.nombre = nombre;
        this.apellido = apellido;
        this.especialidad = especialidad;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getNroLicencia() {
        return nroLicencia;
    }

    public void setNroLicencia(int nroLicencia) {
        this.nroLicencia = nroLicencia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    @Override
    public String toString() {
        return "Veterinario{" +
                "id=" + id +
                ", nroLicencia=" + nroLicencia +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", especialidad='" + especialidad + '\'' +
                '}';
    }
}
