package catalogo_personas_mascotas

import java.text.SimpleDateFormat

import static org.springframework.http.HttpStatus.NOT_FOUND
import static org.springframework.http.HttpStatus.OK
import static org.springframework.http.HttpStatus.CREATED
import catalogo_personas_mascotas.Person
class PetController {
    static allowedMethods = [save: 'POST', update: 'PUT', delete: 'DELETE']
    def index() {
        return [petList:Pet.list()]
    }
    def show(Long id){
        def pet=Pet.get(id)
        
        return [pet:pet]

    }
    def create(){


        return [personList:Person.list()]
    }
}
