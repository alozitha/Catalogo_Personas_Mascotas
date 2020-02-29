<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/html">
<head>
    <title>Show contact</title>
</head>
<body>
<h1>Mostrar Mascota</h1>
Nombre: ${pet.name}<br/>
Cumpleaños:${pet.birthday.dateString}<br/>
Adopcion:${pet.adoption.dateString}<br/>
Dueño:${pet.person.name} ${pet.person.lastnameP} ${pet.person.lastnameM}</br>
<g:link action="edit" id="${pet.id}">Editar</g:link><br/>
</body>
</html>
