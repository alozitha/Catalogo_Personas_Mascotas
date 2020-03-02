<!DOCTYPE html>
<html>
<body>

<h2>Datos personales de ${pet?.name}</h2>

<g:form action="update" method="PUT" id="${pet.id}">
    Nombre:<g:field type="text" name="name" min="10" required="" value="${pet?.name}"/><br/>
    Cumpleaños:<g:field type="text" name="lastnameP"  required="" value="${pet?.brithday}"/><br/>
    Fecha adopción:<g:field type="text" name="lastnameM" value="${pet?.adoption}"/><br/>
    Dueño:<g:field type="text" name="address"  required="" value="${pet?.person.name} ${pet?.person.lastnameP} ${pet?.person.lastnameM}"/><br/>
    <input type="submit" class="button" value="Editar" />
    <g:eachError bean="${pet}">
        <li><g:message error="${it}"/></li>
    </g:eachError>
</g:form>
</body>
</html>
