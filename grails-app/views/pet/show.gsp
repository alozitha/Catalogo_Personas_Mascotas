<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/html">
    <head>
        <asset:stylesheet src="show.css"/>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
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
