package catalogo_personas_mascotas

class Pet {
    String name
    Date birthday
    Date adoption
    Person person
    Date dateCreated
    Date lastUpdated
    //static belongsTo = [person: Person] // esta opcion tambien funciona para poder hacer una relacion funcional
    static constraints = {
        name nullable: false,blank: false,maxSize: 255
        birthday nullable: true,validator: {valueBirthday ->
            if(valueBirthday && valueBirthday>new Date()) return 'not.future'
        }
        adoption nullable: false,validator: { valueAdoption, pet ->
            if(pet.birthday && valueAdoption<pet.birthday) return 'not.beforeBirthday'
            if(valueAdoption>new Date()) return 'not.future'
        }
    }
}
