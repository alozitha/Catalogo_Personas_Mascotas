<!DOCTYPE html>
<html>
<body>

<h2>Nueva Mascota Datos</h2>

<g:form action="save" method="POST" id="${idperson}">
    Nombre:<g:field type="text" name="name"  value="${pet?.name}"/><br/>
    Cumpleaños:<g:field type="date"  name="birthday"  required="" value="${pet?.birthday?.format('yyyy-MM-dd')}" /><br/>
    Fecha adopción:<g:field type="date" name="adoption" value="${pet?.adoption?.format('yyyy-MM-dd')}"/><br/>
    Dueño:
    <input type="submit" class="button" value="Guardar" />

    <g:renderErrors bean = "${pet}"/>
</g:form>
</body>
</html>