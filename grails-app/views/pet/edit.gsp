<!DOCTYPE html>
<html>
<body>

<h2>Datos personales de ${pet?.name}</h2>

<g:form action="update" method="PUT" id="${pet.id}">
    Nombre:<g:field type="text" name="name" required="" value="${pet?.name}"/><br/>
    Cumpleaños:<g:field type="date"  name="birthday"  required="" value="${pet?.birthday?.format('yyyy-MM-dd')}" /><br/>
    Fecha adopción:<g:field type="date" name="adoption" value="${pet?.adoption?.format('yyyy-MM-dd')}"/><br/>
    Dueño:
    <g:select optionKey = "id" optionValue = "${{it.name +' '+it.lastnameP +' '+ (it.lastnameM ?: ' ' )}}"
              name="person" from = "${personList}" value="${pet?.person?.id}"/><br/>
    <input type="submit" class="button" value="Editar" />
    <g:eachError bean="${pet}">
        <li><g:message error="${it}"/></li>
    </g:eachError>
</g:form>
</body>
</html>