package com.alura.screenmatch.modelos;
//creamos un DTO para el acceso a los datos
public record TituloOmdb(String title,String year,String runtime) {
  //esta clase crea automaticamente los get,set y toString
  /*
  una de los problemas es que las variables del objeto local tienen que ser iguales a las de la API
  por Ej: en nuestra clase tenemos:"String title,String year,String runtime" pero en la API
  tenemos:"String Title,String Year,String Runtime". Para solucionar esto vamos a usar
  el metodo UPPER_CAMEL_CASE  en el main para poder llamar a TituloOmdb en el objeto Gson

   */
  //TODO investigar inmutabilidad ("redord")
}
