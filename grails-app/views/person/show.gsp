<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/html">
<head>
    <title>Show contact</title>
</head>
<body>
<h1>Mostrar Persona</h1>
Nombre: ${person.name}<br/>
Apellidos:
<g:if test="${person.lastnameM!=null}">
    ${person.lastnameP} ${person.lastnameM}<br/>
</g:if>
<g:else>
    ${person.lastnameP}<br/>
</g:else>
Telefono:${person.phone}<br/>
Direccion:${person.address}</br>
Mascotas de la persona:
${pet.name ?: 'Ninguna ' }</br>
<g:link action="edit" id="${person.id}">Editar</g:link><br/>


</body>
</html>
