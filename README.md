# RookMotionChallenge
Android Test 2021
--------------------

Puedes encontrar el proyecto completo en la rama DEV

En este repositorio encontraras mi proyecto en donde desarrollo una aplicacion utilizando las siguientes herramientas:

	ºArquitectura MVP
	ºFirebase auth
	ºRetrofit
	ºView Binding
	ºRoom Database 
	ºCoroutines
	ºPicasso
	ºNavigation View


Principalmente estas son las implementaciones de mi proyecto.
Mas especificamente las implemente de la siguiente manera:


  º MVP - Arquitectura principal en mi proyecto
  
  º Firebase auth - Para realizar el login de la misma app
  
  º Retrofit - Obtencion de los datos consumidos mediante la API https://reqres.in/api/users?page=2
  
  º Room database - Base de datos local. Se genera una vez que se obtienen la conexion hacia el servidor y se guardan en local. Asi, de no tener internet, pero habiendo descargado antes los datos, los podras seguir visualizando sin conexión
  
  º View Binding - Se utilizó para poder interactuar las vistas con la logica de negocio
  
  º Coroutines - Implementadas para no saturar el hilo principal de ejecucion, aqui, se usa para hacer conseguir los datos de la API y guardarlos en la base de datos local (Room)
  
  º Picasso - Interpretar las imagenes mediante enlaces
  
  º Navigation View - Pasar datos con Safe Args y tener una estructura mas clara de la aplicación

