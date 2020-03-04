<!DOCTYPE html>
<html>
<body>

<h2>Nueva Mascota Datos</h2>

<g:form action="save" method="POST">
    Nombre:<g:field type="text" name="name" required="" value="${pet?.name}"/><br/>
    Cumpleaños:<g:field type="date"  name="birthday"  required="" value="${pet?.birthday?.format('yyyy-MM-dd')}" /><br/>
    Fecha adopción:<g:field type="date" name="adoption" value="${pet?.adoption?.format('yyyy-MM-dd')}"/><br/>
    Dueño:
    <g:select optionKey = "id" optionValue ="fullName"
              name="person" from = "${personList}" value="${pet?.person?.id}"/><br/>
    <input type="submit" class="button" value="Guardar" />

    <g:eachError bean="${pet}">
        <li><g:message error="${it}"/></li>
    </g:eachError>
</g:form>
</body>
</html>