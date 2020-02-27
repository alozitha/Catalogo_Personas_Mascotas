package catalogo_personas_mascotas

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class PetSpec extends Specification implements DomainUnitTest<Pet> {

    def setup() {
    }

    def cleanup() {
    }

    void 'Validar que los datos no sean nulos'() {
        when:
        domain.name = null

        domain.adoption=null


        then:
        !domain.validate(['name'])

        !domain.validate(['adoption'])

    }

    void 'Validar datos en blanco'() {
        when:
        domain.name = ''

        then:
        !domain.validate(['name'])

    }

    void 'Validar que solo tenga un maximo de 255 caracteres'() {
        when: 'string de 256 caracteres'
        String str = 'a' * 256
        domain.name = str
        then:
        !domain.validate(['name'])

        when: ' string of 255 caracteres'
        str = 'a' * 255
        domain.name = str

        then: 'name validation passes'
        domain.validate(['name'])

    }

    void 'Validar fechas futuras'(){
        when:
        Date date= new Date() + 1
        domain.birthday= date
        domain.adoption=date

        then:
        !domain.validate(['birthday'])
        !domain.validate(['adoption'])

    }

    void 'Validar fecha antes que la de nacimiento'(){
        when:
        domain.birthday= new Date()
        domain.adoption= new Date() - 1
        then:
        domain.validate(['birthday'])
        !domain.validate(['adoption'])
    }
    void 'Validar fechas correctas'(){
        when:
        domain.birthday= new Date() - 5
        domain.adoption= new Date()
        then:
        domain.validate(['birthday'])
        domain.validate(['adoption'])
    }
}
