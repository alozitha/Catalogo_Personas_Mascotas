package catalogo_personas_mascotas

import grails.testing.gorm.DataTest
import grails.testing.gorm.DomainUnitTest
import grails.testing.web.controllers.ControllerUnitTest
import spock.lang.Specification
class PersonControllerSpec extends Specification implements ControllerUnitTest<PersonController>, DomainUnitTest<Person>,DataTest {

    def setup() {
        mockDomains(Person)
        // creacion de una persona como datos
        Person person= new Person(name:'Alondra',phone:'7772345678',address: 'Flores #4',lastnameM:'Ulloa',lastnameP:'Valdez')
        person.save()
    }

    def cleanup() {
    }

    def 'save with information is incorrect'(){
        given:'recibe information about person'
        request.method = 'POST'
        request.contentType = FORM_CONTENT_TYPE
        params['name'] ="Alondra"
        params['phone'] ='735234j'
        params['address']='Flores #4'
        params['lastnameM']='Ulloa'
        params['lastnameP']='Valdez'
        when:'call the function save'
        controller.save()
        then:'return models and action or view'
        model.person
        view =='/person/create'

    }
    def 'save with information is correct'(){
        given:'recibe information about person'
        request.method = 'POST'
        request.contentType = FORM_CONTENT_TYPE
        params['name'] ="Alondra"
        params['phone'] ='7352347922'
        params['address']='Flores #4'
        params['lastnameM']='Ulloa'
        params['lastnameP']='Valdez'
        when:
        controller.save()
        then: 'a message indicating that has been saved '
        flash.message
        and:  'the user is redirected'
        response.redirectedUrl =='/person/index'

    }

    def 'edit send id'(){
        when:
        controller.edit(1)
        then:
        view=='/person/edit'
        model.person


    }
    def 'edit send id incorrect or null'(){
        when:
        controller.edit()
        then:
        flash.message
        and:
        response.redirectedUrl=='/person/index'

    }

    def'update with information correct'(){
        given:
        request.method = 'POST'
        request.contentType = FORM_CONTENT_TYPE
        params['name'] ="Karla"
        params['phone'] ='7352347922'
        params['address']='Flores #4'
        params['lastnameM']='Ulloa'
        params['lastnameP']='Valdez'
        when:
        controller.update(1)
        then:
        flash.message
        and:
        response.redirectedUrl=='/person/index'

    }
    def'update with information incorrect'(){
        given:
        request.method = 'POST'
        request.contentType = FORM_CONTENT_TYPE
        params['name'] =""
        params['phone'] ='73ff2'
        params['address']='Flores #4'
        params['lastnameM']='Ulloa'
        params['lastnameP']='Lopez'
        when:
        controller.update(1)
        then:
        view=='/person/edit'
        model.person

    }



}
