Feature: Registrar Cliente Nuevo

Background:
	Given Ingreso al aplicativo TPIDO Web
	And ingreso a la ventana registrar nuevo cliente

Scenario: Registrar nuevo cliente flujo basico 1
	Given ingreso los datos "Martin9", "Casas9", "mcasas9@gmail.com", "123456"
	And selecciono la opcion guardar
	Then el sistema muestra el mensaje "Se guardó de manera correcta el Cliente"
	
Scenario: Registrar nuevo cliente flujo basico 2
	Given ingreso los datos "Maria3", "Torres3", "mtorres3@gmail.com", "123456"
	And se presiono la tecla enter
	Then el sistema muestra el mensaje "Se guardó de manera correcta el Cliente"
	
Scenario: Registrar nuevo cliente flujo basico 3
	Given ingreso los datos "Romina1", "Torres1", "rtorres1@gmail.com", "123456"
	And se presiono el link volver a inicio
	Then el sistema retorna al login "AUTENTICACIÓN DEL USUARIO"
	
	
Scenario: Registrar nuevo cliente flujo alternativo 1
	Given ingreso los datos "Martin4", "Casas4", "mcasas3@gmail.com", "123456"
	And selecciono la opcion guardar
	Then el sistema muestra el mensaje "Ya existe un Cliente con el mismo correo"
	

Scenario: Registrar nuevo cliente flujo alternativo 2
	Given ingreso los datos "Fiorella", "Francia", "ffrancia", "123456"
	And selecciono la opcion guardar
	Then el sistema muestra el mensaje "Formato de correo no valido"


	