# evaluadorProposiciones
Realizar un programa que realiza las tablas de verdad e indique el resultado de la proposicion logica dada por el usuario.

## Consideraciones
1. El usuario solo podra usar p, q y r
2. El usuario solo podra usar las conectivas AND, OR, y NOT.
3. Cada operacion podra recibir operaciones como atributos o simplemente p, q y r.

## Features
- Evaluar alrededor de 1 millon de operaciones en 1 segundo
- Entrada amigable usando botones
- Mostramos los resultados en una tabla que permite mover de lugar las columnas
- Define si la proposicion es una Tautologia, Contradiccion o Contingencia

## Modelo de datos
Para lograr generar la operacion generamos un arbol binario, dónde, cada operación es un nodo de dicho árbol, lo consideramos así porque facilitaba tanto la entrada de datos como la evaluacion de los datos.

## Flujo de la aplicacion

La aplicacion ocupa dos hilos de trabajo, el primero es el principal de la aplicación, este se encarga de generar la operacion y evaluarla, y el hilo grafico, el cual se encarga de mostrar y leer la entrada de datos, al realizar esto nos surgio un problema, que el hilo principal no esperaba a que el usuario seleccionara una opcion, este problema se resolvio implementando asincronia con la clase `CompletableFuture<T>` permitiendonos utilizar botones.