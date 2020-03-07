package catalogo_personas_mascotas
/**
 * Contains generic helper methods for controllers
 */
trait ControllerUtils {

    /**
     * Creates a Map containing validation errors of multiple domain instances.
     * Allows a main instance and an optional map of nested instances.
     */
    static Map errorMap(Object mainInstance, Map nestedInstances = [:]) {
        Map errorMap = collectErrors(mainInstance)
        nestedInstances.each { key, instance ->
            if (instance.errors.hasErrors()) errorMap[key] = collectErrors(instance)
        }

        [errors:errorMap]
    }

    /**
     * Creates a Map containing validation errors for one domain instance.
     * Uses field name as key and error code as value.
     */
    private static Map collectErrors(Object domainInstance) {
        domainInstance.errors.allErrors.collectEntries { [(it.field):it.code] }
    }
}
