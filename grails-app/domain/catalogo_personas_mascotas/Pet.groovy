package catalogo_personas_mascotas

class Pet {

    Person person
    String name
    Date birthday
    Date adoption
    Date dateCreated
    Date lastUpdated
    //static belongsTo = [person: Person] // esta opcion tambien funciona para poder hacer una relacion funcional
    static constraints = {
        name nullable: false,blank: false,maxSize: 255
        birthday nullable: true,validator: {valueBirthday ->
            if(valueBirthday && valueBirthday<=new Date()) return 'not.future'
        }
        adoption nullable: false,validator: { valueAdoption, pet ->
            if(pet.birthday && valueAdoption>pet.birthday && valueAdoption<=new Date()+1 ) return 'not.beforeBirthday'
        }
    }
}
