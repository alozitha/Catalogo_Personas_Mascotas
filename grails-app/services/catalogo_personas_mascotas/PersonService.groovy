package catalogo_personas_mascotas

import grails.gorm.transactions.Transactional

@Transactional
class PersonService {

    def listPEt(Person person){
        def petList=Pet.findAllByPerson(person) //busca todos los relacionados a esa persona
        return petList// devuelve la lista buscada
    }
}
