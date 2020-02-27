package catalogo_personas_mascotas

class Pet {

    Person person
    String name
    Date birthday
    Date adoption
    Date dateCreated
    Date lastUpdated
    //static belongsTo = [person: Person]

    static constraints = {


        name(nullable: false,blank: false,maxSize: 255)
        birthday(nullable: true,validator: {val ->
           // println(val)
            if(val!=null)
             val<=new Date()
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
    }

}
