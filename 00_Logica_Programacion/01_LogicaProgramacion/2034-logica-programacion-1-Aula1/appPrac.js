alert("¡Bienvenida y bievenido a nuestro sitio web!")
let nombre = "luna";
let edad = 25;
let numerodeVentas = 50;
let saldoDisponible = 1000;
alert("¡Error! Completa todos los campos");
let mensajeDeError = "¡Error! Completa todos los campos";
alert(mensajeDeError)
let nombre2 = prompt("como te llamas?: ");
console.log("Hola " + nombre2);
let edad2 = prompt("cual es tu edad?: ");
console.log("tu edad es : " + edad2);
if(edad2>=18){
  alert("¡Puedes obtener tu licencia de conducir!");
}

//segunda tarea
/*Pregunta al usuario qué día de la semana es.Si la respuesta es "Sábado" o "Domingo", muestra "¡Buen fin de semana!".De lo contrario, muestra "¡Buena semana!".
*/
let diaDeLaSemana = prompt("Que dia de la semana es: ")
if (diaDeLaSemana === "Sabado" || diaDeLaSemana === "Sabado") {
  alert("Buen fin de semana")
} else {
  alert("Buena semana")
}

/*Verifica si un número ingresado por el usuario es positivo o negativo. Muestra una alerta informativa.*/
let numero=prompt("ingrese un numero positivo o negativo")
if (numero < 0) {
  alert(`el numero ${numero} es negativo`)
} else {
  alert(`el numero ${numero} es positivo`);
}

/*Crea un sistema de puntuación para un juego. Si la puntuación es mayor o igual a 100, muestra "¡Felicidades, has ganado!". En caso contrario, muestra "Intenta nuevamente para ganar.".*/
let puntuacion = 105;
if (puntuacion >= 100) {
  console.log("¡Felicidades, has ganado!");
} else {
  console.log("Intenta nuevamente para ganar.");
}

/*Crea un mensaje que informe al usuario sobre el saldo de su cuenta, utilizando un template string para incluir el valor del saldo.*/
let saldoCuenta = 500; // Ejemplo de saldo
alert(`Tu saldo es de $${saldoCuenta}.`);
/*Pide al usuario que ingrese su nombre mediante un prompt. Luego, muestra una alerta de bienvenida usando ese nombre.
*/
let nombre3 = prompt("Por favor, ingresa tu nombre");
alert(`¡Bienvenido, ${nombre}!`);

/*
Crea un contador que comience en 1 y vaya hasta 10 usando un bucle 'while'. Muestra cada número.
*/
let contador2 = 1;
while (contador <= 10) {
  console.log(contador);
  contador++;
}
//Crea un contador que comience en 10 y vaya hasta 0 usando un bucle 'while'. Muestra cada número.
let contador3 = 10;
while (contador >= 0) {
  console.log(contador);
  contador--;
}

//Crea un programa de cuenta regresiva. Pide un número y cuenta desde 0 hasta ese número utilizando un bucle 'while' en la consola del navegador.
let numeroMaximo2 = prompt("Ingresa un número para la cuenta regresiva:");

while (numeroMaximo >= 0) {
  console.log(numeroMaximo);
  numeroMaximo--;
}
//Crea un programa de cuenta progresiva. Pide un número y cuenta desde 0 hasta ese número utilizando un bucle 'while' en la consola del navegador.
let numeroMaximo = prompt("Ingresa un número para la cuenta progresiva:");;
let contador = 0;

while (contador <= numeroMaximo) {
console.log(contador);
contador++
}
