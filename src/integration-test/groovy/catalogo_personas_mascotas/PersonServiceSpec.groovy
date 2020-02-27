package catalogo_personas_mascotas

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class PersonServiceSpec extends Specification {

    PersonService personService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Person(...).save(flush: true, failOnError: true)
        //new Person(...).save(flush: true, failOnError: true)
        //Person person = new Person(...).save(flush: true, failOnError: true)
        //new Person(...).save(flush: true, failOnError: true)
        //new Person(...).save(flush: true, failOnError: true)
        // assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //person.id
    }


}
