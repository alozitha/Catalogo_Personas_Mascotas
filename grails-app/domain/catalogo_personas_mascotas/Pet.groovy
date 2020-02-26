package catalogo_personas_mascotas

class Pet {

    Person person
    String name
    Date birthday
    Date adoption
    Date date
    Date dateModification
    static belongsTo = [person: Person]

    static constraints = {
        name(nullable: false,blank: false,maxSize: 255)
        birthday(nullable: true,validator: {val ->
           // println(val)
            if(val!=null)
            val.before(new Date()+1)

        })
        adoption(nullable: false,validator: { val, obj ->
            if(obj.birthday!=null){
                if(val.before(new Date()+1)){
                    val.after(obj.birthday)//despues de la fecha de nacimiento
                }else{
                    val.before(new Date()+1)
                }


            }else{
                val.before(new Date()+1) // pero antes de una fecha futura
            }


        })
        date(nullable: false)
    }

}
