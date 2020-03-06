package catalogo_personas_mascotas

import grails.gorm.transactions.Transactional

@Transactional
class PersonService {

    def listPEt(Person person){
        return Pet.findAllByPerson(person)// devuelve la lista buscada
    }
}
