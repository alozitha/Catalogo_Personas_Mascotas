package catalogo_personas_mascotas

import grails.gorm.transactions.Transactional

@Transactional
class PersonService {

    Pet listPEt(Person person){
         Pet.findAllByPerson(person)// devuelve la lista buscada
    }
}
