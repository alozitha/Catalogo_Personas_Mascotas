<!DOCTYPE html>
<html>
<body>

<h2>Nueva Mascota Datos</h2>

<g:form action="save" method="POST">
    Nombre:<g:field type="text" name="name" min="10" required="" value="${pet?.name}"/><br/>
    Cumpleaños:<g:field type="text" name="lastnameP"  required="" value="${pet?.brithday}"/><br/>
    Fecha adopción:<g:field type="text" name="lastnameM" value="${pet?.adoption}"/><br/>
    Dueño:
    <g:select optionKey = "id" optionValue = "${{it.name +' '+it.lastnameP +' '+ (it.lastnameM ?: ' ' )}}"
              name="person.name" from = "${personList}"/><br/>
    <input type="submit" class="button" value="Guardar" />

    <g:eachError bean="${pet}">
        <li><g:message error="${it}"/></li>
    </g:eachError>
</g:form>
</body>
</html>