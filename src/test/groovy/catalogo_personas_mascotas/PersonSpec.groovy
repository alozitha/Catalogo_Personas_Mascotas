package catalogo_personas_mascotas

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class PersonSpec extends Specification implements DomainUnitTest<Person> {

    def setup() {
    }

    def cleanup() {
    }



    void 'Validar que los datos no sean nulos'() {
        when:
        domain.name = null
        domain.address=null
        domain.lastnameP=null
        domain.date=null
        domain.modificationDate=null
        domain.phone=null

        then:
        !domain.validate(['name'])
        !domain.validate(['address'])
        !domain.validate(['lastnameP'])
        !domain.validate(['date'])
        !domain.validate(['modificationDate'])
        !domain.validate(['phone'])
    }

    void 'Validar datos en blanco'() {
        when:
        domain.name = ''
        domain.address=''
        domain.phone=''
        domain.lastnameP=''

        then:
        !domain.validate(['name'])
        !domain.validate(['address'])
        !domain.validate(['lastnameP'])
        !domain.validate(['phone'])
    }

    void 'Validar que solo tenga un maximo de 255 caracteres'() {
        when: 'string de 256 caracteres'
        String str = 'a' * 256
        domain.name = str
        domain.lastnameP=str
        domain.lastnameM=str
        domain.address=str

        then:
        !domain.validate(['name'])
        !domain.validate(['lastnameP'])
        !domain.validate(['lastnameM'])
        !domain.validate(['address'])
        //domain.errors['name'].code == 'maxSize.exceeded'

        when: ' string of 255 caracteres'
        str = 'a' * 255
        domain.name = str
        domain.address=str
        domain.lastnameM=str
        domain.lastnameP=str

        then: 'name validation passes'
        domain.validate(['name'])
        domain.validate(['lastnameP'])
        domain.validate(['lastnameM'])
        domain.validate(['address'])
    }

    void 'logitud de 10 digitos'(){
        when:'cuando son mas de 10 digitos '
        String str ='1'*11
        domain.phone=str
        then:
        !domain.validate(['phone'])

        when:
        str= '1'*10
        //println(str)
        domain.phone=str
        then:
        domain.validate(['phone'])

    }

    void 'validacion de solo numeros'(){
        when:
        String str='1'*9+'a'
        domain.phone=str
        then:
        !domain.validate(['phone'])
        when:
        str='0123456789'
        domain.phone=str
        then:
        domain.validate(['phone'])

    }
}
