package catalogo_personas_mascotas
import static org.springframework.http.HttpStatus.NOT_FOUND
import static org.springframework.http.HttpStatus.OK
import static org.springframework.http.HttpStatus.CREATED
import catalogo_personas_mascotas.Person
import grails.gorm.transactions.Transactional

class PersonController {
    static allowedMethods = [save: 'POST', update: 'PUT', delete: 'DELETE']


    // metodo para mostrar lista de todos los datos registrados en la tabla Person
    def index(Integer max) {
       // params.max = Math.min(max ?: 10, 100)
        respond Person.list(params), model:[personCount: Person.count()]
    }
    //Metodo para agregar una persona
    def create(){
       // Crea un nuevo objeto de contacto con valores predeterminados procedentes
        respond new Person(params)
    }

    def save (Person person){
        // los parametros Flush and Fail actualizan la base de datos y detienen la ejecucion si ocurre un error respectivamente
        person.save flush: true, failOnError: true
        //Luego lo guarda (API de persistencia, basado en Hibernate) y redirige al usuario a la acción index que es la vista de lista.
        redirect action: "index"
    }
}
