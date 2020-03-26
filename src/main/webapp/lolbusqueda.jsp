<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
 <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="l.css" />
<meta charset="ISO-8859-1">
<title>GameShup : PUBG</title>
</head>
<body>

<div id="divlp">
<img id="logopubg" src="img/logol.png">
</div>

<div id="errorp">${mensaje}</div>




<form  id="forp" class="w-50" action="/lol" method="post">
<div class="form-group">
 
  <input id="name" name="name" type="text" class="form-control" aria-label="Introduce el nick del jugador" placeholder ="Introduce el nick del jugador" value="${user}">
</div>
  
  <div class="form-group">
    <label for="exampleFormControlSelect1">Selecciona una región</label>
    <select class="form-control" id="regionp" name="regionp" value="${region}">
      <option value="EU">Europa</option>
      <option value="AS">Asia</option>
      <option value="NA">Norte América</option>
      <option value="OC">Oceanía</option>
      
    </select>
  </div>
  
  <button type="submit" class="btn btn-primary mb-2">¡Ver estadísticas!</button>
</form>

<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
</body>
</html>