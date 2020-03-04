package catalogo_personas_mascotas

import grails.testing.gorm.DataTest
import grails.testing.gorm.DomainUnitTest
import grails.testing.web.controllers.ControllerUnitTest
import spock.lang.Specification

class PetControllerSpec extends Specification implements ControllerUnitTest<PetController>, DomainUnitTest<Pet>, DataTest {
    private static final List httpMethods = ['GET', 'POST', 'PUT']
    def setup() {
        mockDomains(Pet,Person)
        Person person= new Person(name:'Alondra',phone:'7772345678',address: 'Flores #4',lastnameM:'Ulloa',lastnameP:'Valdez')
        person.save()
        //print(person.id)

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
        params['person']=1
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

}