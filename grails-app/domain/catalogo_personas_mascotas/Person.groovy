package catalogo_personas_mascotas

class Person  {
    String name
    String lastnameP
    String lastnameM
    String phone
    String address
    Date dateCreated
    Date lastUpdated

    //static hasMany=[pets:Pet]

    static mapping = {
       // id generator: 'increment'
        version false
    }

    static constraints = {
        name(blank: false, nullable: false, maxSize: 255)
        lastnameP(blank: false, nullable: false,maxSize: 255)
        lastnameM(blank: true, nullable: true,maxSize: 255)
        phone(blank: false,matches:'(\\d{10})')
        address(blank: false, nullable: false,maxSize: 255)

    }


}
