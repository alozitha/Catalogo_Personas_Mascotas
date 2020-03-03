package catalogo_personas_mascotas

import grails.web.databinding.DataBinder

import java.text.DateFormat
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
    def save(){
        def pet= new Pet(params)
        if (pet.validate()) {
            pet.save()
            flash.message='Se guardo correctamente'
            redirect action: 'index'
        }
        else {

            render( view:'create',model:[pet:pet,personList:Person.list()])
        }

    }
    def edit(Long id){
        def pet=Pet.get(id)
        return [pet:pet,personList:Person.list()]
    }
    def update(Long id){
        Pet pet= Pet.get(id)
        pet.properties= params
        if(pet.validate()){
            pet.save(flush : true) // se utiliza el flush para que se conserve el dato y no genere otro
            flash.message='Se edito correctamente el dato con el nombre '+pet.name
            redirect action: 'index'
        }else{
            render( view:'edit',model:[pet:pet,personList:Person.list()])
        }

    }

}
