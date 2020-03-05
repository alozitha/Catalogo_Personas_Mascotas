package catalogo_personas_mascotas

import grails.testing.gorm.DataTest
import grails.testing.gorm.DomainUnitTest
import grails.testing.services.ServiceUnitTest
import spock.lang.Specification

class PersonServiceSpec extends Specification implements ServiceUnitTest<PersonService>, DomainUnitTest<Person>, DataTest{
    def setup() {
        mockDomains(Pet,Person)
        Person person= new Person(name:'Alondra',phone:'7772345678',address: 'Flores #4',lastnameM:'Ulloa',lastnameP:'Valdez')
        person.save()
        //Creacion de una mascota como datos
        Pet pet= new Pet(name:"Muffin",birthday: '2020-02-02',adoption: '2020-03-01',person: 1)
        pet.save()
        pet= new Pet(name:"Lucifer",birthday: '2020-01-01',adoption: '2020-03-01',person: 1)
        pet.save()


    }
    def'return list of pets person'(){
        given:'obtain de person'
        def person=Person.get(1)
      when:'called method'
       def petList=service.listPEt(person)
      then:'return list of pets'
        petList

    }


}
