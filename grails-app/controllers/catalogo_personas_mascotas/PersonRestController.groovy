package catalogo_personas_mascotas

import grails.converters.JSON

class PersonRestController implements ControllerUtils  {
    static allowedMethods = [list:'GET', showDetails:'GET',
                             save:'POST']
    PersonService personService
    PetService petService

    /** Return list of person */
    def index() {
       List<Person> personList = Person.list()
        render(view:'index',model:[personList:personList])

    }

    /** Get info person with list of pets */
    def show(Long id) {
        if (!id ) {
            response.status = 404 //error not found
            return
        }
        Person person=Person.get(id)
        List<Pet> petList=personService.listPEt(person)
        render(view:'show', model:[person:person,petList: petList])

    }
    def createPet(Long id){
        if (!id ) {
            response.status = 404 //error not found
            return
        }
        render(view: 'createPet',model:[personList:Person.list(),idperson:id] )
    }

    /** Creates a new pet for a person */
    def save(Long id) {
        Person person=Person.get(id)
        if (!person) {
            response.status = 404 //error not found
            return
        }

        Pet pet = new Pet()
        bindData(pet, params)
        pet.person=person
        if (!pet.validate()) {
            response.status = 400 //request incorrect
            render errorMap(pet) as JSON
            return
        }
         petService.save(pet)
         List<Pet> petList=personService.listPEt(person)
        render view:'show', model:[person:person as JSON,petList: petList as JSON]
    }
}
