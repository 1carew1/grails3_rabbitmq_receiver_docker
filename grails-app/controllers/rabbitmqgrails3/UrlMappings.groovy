package rabbitmqgrails3

class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/"(controller: "connect", action: "index")
        "500"(view:'/error')
        "404"(view:'/notFound')
    }
}
