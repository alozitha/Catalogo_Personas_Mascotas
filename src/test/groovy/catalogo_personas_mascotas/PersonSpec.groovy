package catalogo_personas_mascotas

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class PersonSpec extends Specification implements DomainUnitTest<Person> {

    def setup() {
    }

    def cleanup() {
    }
    void 'Test  de name'(){


        when:
        domain.name = value

        then:
        expected == domain.validate(['name'])
        //domain.errors['name']?.code == expectedErrorCode

        where:
        value   | expected
        null    |  false
        ''      |  false
        'a'*255 |  true
        'a'*256 |  false


    }
    void 'Test  de lastnameP'(){

        when:
        domain.lastnameP = value

        then:
        expected == domain.validate(['lastnameP'])
        //domain.errors['name']?.code == expectedErrorCode

        where:
        value   | expected
        null    |  false
        ''      |  false
        'a'*255 |  true
        'a'*256 |  false

    }
    void 'Test  de lastnameM'(){

        when:
        domain.lastnameM = value

        then:
        expected == domain.validate(['lastnameM'])

        where:
        value   | expected
        null    |  true
        'a'*255 |  true
        'a'*256 |  false


    }
    void 'Test  de address'(){
        when:
        domain.address = value

        then:
        expected == domain.validate(['address'])
        //domain.errors['name']?.code == expectedErrorCode

        where:
        value   | expected
        null    |  false
        'a'*255 |  true
        'a'*256 |  false


    }
    void 'Test  de phone'(){

        when:
        domain.phone = value

        then:
        expected == domain.validate(['phone'])
        //domain.errors['name']?.code == expectedErrorCode

        where:
        value     | expected
        null      |  false
        ''        |  false
        '1'*11    |  false
        '1'*9+'a' |  false
        '1'*10    |  true


    }


}
