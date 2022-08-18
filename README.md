# evaluadorProposiciones
Realizar un programa que realiza las tablas de verdad e indique el resultado de la proposicion logica dada por el usuario.

## Consideraciones
1. El usuario solo podra usar p, q y r
2. El usuario solo podra usar las conectivas AND, OR, y NOT.
3. Cada operacion podra recibir operaciones como atributos o simplemente p, q y r.

## Proposicones de ejemplo
### p or r y !q or !p
((p or r) y !q) or !p

(p and (r or q))

- si como segundo parametro se da q, q o r, esa operacion se cierra
- si despues de que se cierra, el usuario selecciona and o or, se crea otra operacion en la que como primer parametro tenga la operacion recien cerrada.
  
- Si cuando una operacion se esta escribiendo, el usuario coloca ( se crea otra operacion, la cual sera pasada como parametro

- si cuando una operacion se esta escribiendo, el usuario coloca ! se crea una negacion, la cual sera pasada como parametro.


## Pantallas

### Pantalla 1
Bienvenido al evaluador de proposiciones logicas.
P:_
Selecciona tipo de operacion para crear

4. ∧
5. v
6. ¬

### Pantalla 2

P:_ (operacion)

Selecciona una opcion para añadir
1. p
2. q
3. r
4. ∧
5. v
6. ¬
7. (

### Pantalla 3

P:(seleccion)(operacion) _

Selecciona una opcion para añadir
1. p
2. q
3. r
4. ∧
5. v
6. ¬
7. (

### Pantalla 4

P:(seleccion)(operacion) (seleccion) _

Selecciona una opcion para añadir
4. ∧
5. v
8. )

### Pantalla 5

P:( (seleccion)(operacion) (seleccion) ) _

Selecciona una opcion para añadir
4. ∧
5. v
9. Treminar


