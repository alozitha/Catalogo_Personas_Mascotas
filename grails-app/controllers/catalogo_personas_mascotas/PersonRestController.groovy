package catalogo_personas_mascotas

import grails.converters.JSON

class PersonRestController implements ControllerUtils  {
    static allowedMethods = [list:'GET', showDetails:'GET',
                             save:'POST']
    PersonService personService
    PetService petService

    /** Return list of person */
    def list() {
       List<Person> personList = Person.list()
        [personList:personList]
    }
    /** Get info person with list of pets */
    def showDetails(Long id) {
        Person person=Person.get(id)
        List<Pet> petList=personService.listPEt(person)

        if (!id || !petList) {
            response.status = 404 //error not found
            return
        }

        [person:person,personList:petList]
    }

    /** Creates a new pet for a person */
    def save(Long personID) {
        if (!personID ) {
            response.status = 404
            return
        }

        Pet pet = new Pet()
        bindData(pet, params)
        pet.personId = personID

        if (!pet.validate()) {
            response.status = 400 //request incorrect
            render errorMap(pet) as JSON
            return
        }

        petService.save(pet)
        render view:'show', model:[pet:pet]
    }
}
