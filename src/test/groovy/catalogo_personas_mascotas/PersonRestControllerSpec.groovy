package catalogo_personas_mascotas

import grails.converters.JSON
import grails.testing.gorm.DataTest
import grails.testing.gorm.DomainUnitTest
import grails.testing.web.controllers.ControllerUnitTest
import spock.lang.Specification

class PersonRestControllerSpec extends Specification implements ControllerUnitTest<PersonRestController>, DomainUnitTest<Person>, DataTest {
    Closure doWithSpring() {{ ->
        personService(PersonService)
        petService(PetService)
    }}
    def setup() {
        mockDomains(Pet,Person)
        // creacion de una persona como datos
        Person person= new Person(name:'Alondra',phone:'7772345678',address: 'Flores #4',lastnameM:'Ulloa',lastnameP:'Valdez')
        person.save()
        //print(person.id)
        //Creacion de una mascota como datos
        Pet pet= new Pet(name:"Muffin",birthday: '2020-02-02',adoption: '2020-03-01',person: 1)
        pet.save()
    }

    def cleanup() {
    }

    def 'return list of person'(){
        when:
        controller.index()
        then:
        model.personList
    }
    def 'return details person with pets'(){
        when:
        controller.show(1)
        then:
        view=='/personRest/show'
        and:
        model.person
        and:
        model.petList
    }

    def 'save new persons pet'(){
        given:
        request.method = 'POST'
        request.contentType = FORM_CONTENT_TYPE
        params['name'] ="Firulais"
        params['birthday'] ='2020-02-23'
        params['adoption']='2020-02-25'
        when:
        controller.save(1)
        then:
        view=='/personRest/show'
        and:
        model.person
        and:
        model.petList

    }
    def 'save with params incorrect'(){
        given:
        request.method = 'POST'
        request.contentType = FORM_CONTENT_TYPE
        params['name'] =""
        params['birthday'] ='2020-02-23'
        params['adoption']='2020-02-25'
        when:
        controller.save(1)
        then:
        response.status==400
        and:
        response.json.errors==[name:'nullable']


    }
    def 'show without id '(){
        when:
        controller.show()
        then:
        response.status==404
    }
    def 'create without id '(){
        when:
        controller.createPet()
        then:
        response.status==404
    }
    def 'save without id '(){
        when:
        controller.save()
        then:
        response.status==405
    }

}
