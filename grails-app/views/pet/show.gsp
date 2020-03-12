<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/html">
<head>
    <meta name="layout" content="header" />
</head>

<body>

<div class="container contact-form  justify-content-center">
    <div class="contact-image">
        <asset:image src="icon.png"/>
    </div>

    <h3 class="contact-head"> ${pet.name}</h3>
    <h5 class="contact-head">Nacimiento ${pet.birthday.dateString}</h5>
    <h5 class="contact-head">Adopcion ${pet.adoption.dateString}</h5>
    <h5 class="contact-head">Dueño ${pet.person.name} ${pet.person.lastnameP} ${pet?.person?.lastnameM}</h5>
    <a href="/pet/edit/${pet?.id}" class="btn btn-primary col-md-12">Editar</a>
    <br><br>
</div>
</body>
</html>
