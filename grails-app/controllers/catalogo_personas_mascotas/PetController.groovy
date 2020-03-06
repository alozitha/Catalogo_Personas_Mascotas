package catalogo_personas_mascotas

import grails.web.databinding.DataBinder

import java.text.DateFormat
import java.text.SimpleDateFormat

import static org.springframework.http.HttpStatus.NOT_FOUND
import static org.springframework.http.HttpStatus.OK
import static org.springframework.http.HttpStatus.CREATED
import catalogo_personas_mascotas.Person
class PetController {
    static allowedMethods = [save: 'POST', update: 'POST', delete: 'DELETE']
    def petService

    def index() {
        render(view:'index',model:[petList:Pet.list()])
    }

    def show(Long id){
        Pet pet=Pet.get(id)
        if(!pet){
            flash.message="El identificador de la mascota es incorrecto"
            redirect(action: 'index')
            return
        }
        render(view:'show',model:[pet:pet])
    }
    def create(){
        render(view: 'create',model:[personList:Person.list()] )
    }
    def save(){
        Pet pet= new Pet(params)
        //print(params)
        if (!pet.validate()) {
            render( view:'create',model:[pet:pet,personList:Person.list()])
            return
        }
        //llamar al metodo del servicio pet para guardar
       petService.savePet(pet)
       // pet.save()
        flash.message='Se guardo correctamente'
        redirect (action: 'index')

    }
    def edit(Long id){
        Pet pet=Pet.get(id)
        if(!pet){
            flash.message="El identificador de la mascota es incorrecto"
            redirect(action: 'index')
            return
        }
        render(view: 'edit',model:[pet:pet,personList:Person.list()])
    }
    def update(Long id){
        def pet= Pet.get(id)
        bindData(pet,params)
        if(!pet.validate()){
            render( view:'edit',model:[pet:pet,personList:Person.list()])
            return
        }
        //llamar al metodo del servicio pet para guardar
        petService.savePet(pet)
       // pet.save(flush:true) // se utiliza el flush para que se conserve el dato y no genere otro
        flash.message='Se edito correctamente el dato con el nombre '+pet.name
        redirect action: 'index'

    }

}
