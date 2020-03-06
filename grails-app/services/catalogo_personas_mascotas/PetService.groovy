package catalogo_personas_mascotas

import grails.gorm.transactions.Transactional

@Transactional
class PetService {

    void save(Pet pet) { // recibe el objeto pet
        pet.save(failOnError:true,flush:true) //lo guarda con failOnError and flash

    }


}
