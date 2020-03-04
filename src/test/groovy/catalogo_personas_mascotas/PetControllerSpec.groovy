package catalogo_personas_mascotas

import grails.testing.gorm.DataTest
import grails.testing.gorm.DomainUnitTest
import grails.testing.web.controllers.ControllerUnitTest
import spock.lang.Specification

class PetControllerSpec extends Specification implements ControllerUnitTest<PetController>, DomainUnitTest<Pet>, DataTest {

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

    def 'save with information is incorrect'(){
        when:
        request.method = 'POST'
        request.contentType = FORM_CONTENT_TYPE
        params['name'] ="Firulais"
        params['birthday'] ='2020-03-05'
        params['adoption']='2020-02-25'
        params['person']=10
        controller.save()

        then:
        model.pet
        model.personList
        view =='/pet/create'



    }
    def 'save with information correct'(){
        when:
        request.method = 'POST'
        request.contentType = FORM_CONTENT_TYPE
        params['name'] ="Firulais"
        params['birthday'] ='2020-02-23'
        params['adoption']='2020-02-25'
        params['person']=1
        controller.save()

        then: 'a message indicating that has been saved '
        flash.message
        and:  'the user is redirected'
        response.redirectedUrl =='/pet/index'
        // print(response.redirectedUrl)

    }

    def 'edit send id'(){
        when:
        controller.edit(1)
        then:
        view =='/pet/edit'
        model.pet
        model.personList

    }
    def 'edit send id incorrect'(){
        when:
        controller.edit(2)
        then:
        flash.message
        and:
        response.redirectedUrl=='/pet/index'

    }

    def'update with information correct'(){
        when:
        request.method = 'POST'
        request.contentType = FORM_CONTENT_TYPE
        params['name'] ="Lucifer"
        params['birthday'] ='2020-02-21'
        params['adoption']='2020-02-25'
        params['person']=1
        controller.update(1)
        then:
        flash.message
        and:
        response.redirectedUrl=='/pet/index'



    }
    def'update with information incorrect'(){
        when:
        request.method = 'POST'
        request.contentType = FORM_CONTENT_TYPE
        params['name'] =""
        params['birthday'] ='2020-02-21'
        params['adoption']='2020-02-25'
        params['person']=2
        controller.update(1)
        then:
        view=='/pet/edit'
        model.pet
        model.personList
    }

    def 'index'(){
        when:
        controller.index()
        then:
        view =='/pet/index'
        model.petList

    }
    def 'show'(){
        when:
        controller.show(1)
        then:
        view=='/pet/show'
        model.pet
    }
    def 'create'(){
        when:
        controller.create()
        then:
        view=='/pet/create'
        model.personList
    }

}