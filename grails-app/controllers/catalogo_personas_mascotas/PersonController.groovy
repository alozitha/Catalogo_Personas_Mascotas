package catalogo_personas_mascotas
import static org.springframework.http.HttpStatus.NOT_FOUND
import static org.springframework.http.HttpStatus.OK
import static org.springframework.http.HttpStatus.CREATED
import catalogo_personas_mascotas.Person
import grails.gorm.transactions.Transactional

class PersonController {
    static allowedMethods = [save: 'POST', update: 'PUT', delete: 'DELETE']
    def personService

    // metodo para mostrar lista de todos los datos registrados en la tabla Person
    def index() {
        // devuelve la lista de personas al arreglo personList
        List <Person> personList=Person.list()
        return [personList:personList]
    }
    def show(Long id){
        Person person=Person.get(id)
        // llamada al metodo de servicio que enlista las mascotas
       List<Pet> petList=personService.listPEt(person)
        if(!person){
            flash.message="El identificador de la persona es incorrecto"
            redirect(action: 'index')
            return
        }
        return [person:person,petList:petList]
    }
    def create(){}
    void save(){
        Person person= new Person(params)
        if (!person.validate()) {
            render( view:'create',model:[person:person])
            return
        }
        person.save()
        flash.message='Se guardo correctamente'
        redirect action: 'index'
    }

    def edit(Long id){
        Person person=Person.get(id)
        if(!person){
            flash.message="El identificador de la persona es incorrecto"
            redirect(action: 'index')
            return
        }
        return [person:person]
    }

    void update(Long id){
        Person person= Person.get(id)
        bindData(person,params)
        if(!person.validate()){
            render( view:'edit',model:[person:person])
            return
        }
        person.save(flush : true) // se utiliza el flush para que se conserve el dato y no genere otro
        flash.message='Se edito correctamente el dato con el nombre '+person.name
        redirect action: 'index'

    }


}
