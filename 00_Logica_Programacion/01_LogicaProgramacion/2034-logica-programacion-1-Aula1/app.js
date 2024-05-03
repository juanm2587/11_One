let numeroSecreto = 6;
let numeroUsuario = prompt("Me indicas un numero por favor:");
console.log(numeroUsuario);

if (numeroUsuario == numeroSecreto) {
  //comilla invertida acepta texto string  mas la variable incluida
    alert(`Acertaste, el numero es: ${numeroUsuario}`);
} else {
  alert("Lo siento no hacertaste el numero");
}