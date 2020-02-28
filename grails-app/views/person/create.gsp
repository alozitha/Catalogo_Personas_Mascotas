<!DOCTYPE html>
<!DOCTYPE html>
<html>
<body>

<h2>Nueva Persona Datos</h2>

<g:form action="save" method="POST">
    Nombre:<g:field type="text" name="name" min="10" required="" value="${params.name}"/><br/>
    Apellido Paterno:<g:field type="text" name="lastnameP"  required="" value="${params.lastnameP}"/><br/>
    Apellido Materno:<g:field type="text" name="lastnameM" value="${params.lastnameM}"/><br/>
    Direccion:<g:field type="text" name="address"  required="" value="${params.address}"/><br/>
    Telefono:<g:field type="text" name="phone" min="10" required="" value="${params.phone}"/><br/><br/>
        <input type="submit" class="button" value="Guardar" />

</g:form>
</body>
</html>