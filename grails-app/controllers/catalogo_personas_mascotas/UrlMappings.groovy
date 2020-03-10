package catalogo_personas_mascotas

class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        get             "/api/people"(controller: 'personRest', action: 'index')
        get             "/api/people/$id?"(controller: 'personRest', action: 'show')
        post            "/api/people/$id?/pets"(controller: 'personRest', action: 'save')

        "/"(view:"/index")
        "500"(view:'/error')
        "404"(view:'/notFound')
    }
}
