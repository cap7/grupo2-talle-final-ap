Feature: Registrar Pedido

	Scenario:  Registrar Pedido flujo basico
		Given Ingreso al aplicativo TPido
		  And inicio sesion con el usuario "test10@gmail.com" y la clave "123456"
		 When Ingreso a la ventana registrar pedido
		  And Selecciono "5" unidades de COCA COLA
		 Then el sistema muestra el mensaje "Se guardó de manera correcta el Pedido con ID : 8"
		
	

























