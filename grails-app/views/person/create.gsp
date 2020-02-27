<!DOCTYPE html>
<!DOCTYPE html>
<html>
<body>

<h2>Nueva Persona Datos</h2>

<g:form action="save" method="POST">
    Nombre:<g:field type="text" name="name" min="10" required=""/><br/>
    Apellido Paterno:<g:field type="text" name="lastnameP"  required=""/><br/>
    Apellido Materno:<g:field type="text" name="lastnameM" value=''/><br/>
    Direccion:<g:field type="text" name="address"  required=""/><br/>
    Telefono:<g:field type="text" name="phone" min="10" required=""/><br/>
    <fieldset class="buttons">
        <input type="submit" value="Guardar" />
    </fieldset>
</g:form>
</body>
</html>