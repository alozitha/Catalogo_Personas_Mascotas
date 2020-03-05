<!DOCTYPE html>
<html>
<body>

<h2>Datos personales de ${person?.name}</h2>

<g:form action="update" method="PUT" id="${person.id}">
    Nombre:<g:field type="text" name="name" min="10"  value="${person?.name}"/><br/>
    Apellido Paterno:<g:field type="text" name="lastnameP"  value="${person?.lastnameP}"/><br/>
    Apellido Materno:<g:field type="text" name="lastnameM" value="${person?.lastnameM}"/><br/>
    Direccion:<g:field type="text" name="address"   value="${person?.address}"/><br/>
    Telefono:<g:field type="text" name="phone" min="10"  value="${person?.phone}"/><br/><br/>
    <input type="submit" class="button" value="Editar" />
    <g:renderErrors bean = "${person}"/>
</g:form>
</body>
</html>
