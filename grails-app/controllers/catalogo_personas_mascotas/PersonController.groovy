package catalogo_personas_mascotas
import static org.springframework.http.HttpStatus.NOT_FOUND
import static org.springframework.http.HttpStatus.OK
import static org.springframework.http.HttpStatus.CREATED
import catalogo_personas_mascotas.Person
import grails.gorm.transactions.Transactional

class PersonController {
    static allowedMethods = [save: 'POST', update: 'PUT', delete: 'DELETE']

    // metodo para mostrar lista de todos los datos registrados en la tabla Person
    def index() {
       // params.max = Math.min(max ?: 10, 100)
        // devuelve la lista de personas al arreglo personList
        return [personList:Person.list()]
    }
    def show(Long id){
        def person=Person.get(id)
        return [person:person]

    }
    def create(){}
    def save(){
        def person= new Person(params)
        //si todas las validaciones fallan entonces mandamos un render
        if (!person.validate()) {
            render('Ha fallado el poder guardar los datos')
        }else{
            person.save()
            render('Se guardaron correctamente los datos')
        }
        

    }

}
