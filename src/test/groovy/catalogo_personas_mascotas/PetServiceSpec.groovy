package catalogo_personas_mascotas

import grails.testing.gorm.DataTest
import grails.testing.gorm.DomainUnitTest
import grails.testing.services.ServiceUnitTest
import spock.lang.Specification

class PetServiceSpec extends Specification implements ServiceUnitTest<PetService>, DomainUnitTest<Pet>, DataTest{

    def setup() {
        mockDomains(Pet,Person)
        Person person= new Person(name:'Alondra',phone:'7772345678',address: 'Flores #4',lastnameM:'Ulloa',lastnameP:'Valdez')
        person.save()
        print(person.id)


    }
    def'save pet with flush and failonError'(){
        given:'instance of pet'
        Pet pet= new Pet(name:"Muffin",birthday: '2020-02-02',adoption: '2020-03-01',person: 1)
        when:'call to method'
        service.savePet(pet)
        then:'return pet saved'
        //print(pet.id)
        pet

    }
}
