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
            if(valueBirthday!=null)
                valueBirthday<=new Date()
        }
        adoption nullable: false,validator: { valueAdoption, pet ->
            if(pet.birthday!=null){
                if(valueAdoption<=new Date()+1){
                    valueAdoption>pet.birthday//despues de la fecha de nacimiento
                }else{
                    valueAdoption<=new Date()+1
                }
            }else{
                valueAdoption<=new Date()+1 // pero antes de una fecha futura
            }
        }
    }

}
