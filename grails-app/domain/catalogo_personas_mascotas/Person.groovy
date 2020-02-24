package catalogo_personas_mascotas

class Person {
    String nombre
    String apellidoPaterno
    String apellidoMaterno
    String telefono
    String direccion
    Date fechaAlta
    Date fechaModificacion

    static constraints = {
        nombre(blank: false, nullable: false, maxSize: 255)
        apellidoPaterno(blank: false, nullable: false,maxSize: 255)
        apellidoMaterno(nullable: true,maxSize: 255)
        telefono(blank: false)
        direccion(blank: false, nullable: false,maxSize: 255)
    }
}
