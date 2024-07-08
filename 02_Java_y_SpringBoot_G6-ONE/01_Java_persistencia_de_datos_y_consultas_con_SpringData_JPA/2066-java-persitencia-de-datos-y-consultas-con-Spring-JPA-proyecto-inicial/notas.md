## Preparando el ambiente: método utilizado en el enum categoría

En el siguiente video, necesitaremos crear un Enum y utilizar un método específico para realizar la conversión entre la información de OMDB y la de nuestra aplicación. Puedes copiar el código a continuación para poder continuar:
```java
public static Categoria fromString (String text) {
        for (Categoria categoria : Categoria.values()) {
            if (categoria.categoriaOmdb.equalsIgnoreCase(text)) {
                return categoria;
            }
        }
        throw new IllegalArgumentException("Ninguna categoria encontrada: " + text);
    }

```
## Para saber más: un tipo diferente de modelar datos
Anteriormente, utilizamos un nuevo tipo de representación de datos, el Enum.

Enum es una abreviatura de "enumerados" y es un tipo especial de clase en Java que tiene un número fijo de constantes. Utilizar un Enum puede ser muy útil en programación para almacenar valores que sabemos que nunca cambiarán, como los días de la semana o las fases de la luna.

Vamos a empezar creando nuestro propio Enum. Imagina que estamos construyendo una aplicación sobre el sistema solar y queremos un Enum para los planetas.

A continuación, te muestro un ejemplo de cómo podrías implementarlo:
```java
public enum Planetas{
    MERCURIO,
    VENUS,
    TIERRA,
    MARTE,	
    JÚPITER,
    SATURNO,
    URANO,
    NEPTUNO
}
```
Como puedes ver, un Enum en Java es muy similar a una clase. Sin embargo, en lugar de usar la palabra clave 'class', usamos 'enum'. También debemos representar las constantes, que están separadas por comas y escritas en mayúsculas.

Ahora que hemos creado nuestro Enum, podemos empezar a usarlo en nuestro código. En el ejemplo a continuación, definimos un método que recibe un planeta como argumento e imprime un mensaje. Échale un vistazo:

```java
public void cualPlaneta(Planetas planeta){
    switch(planeta){
        case Tierra:
            System.out.println(“Usted está en la tierra”);
        default:
            System.out.println(“Usted no está en la tierra”);
        break;
            
   }
}
```
En la función cualPlaneta, podemos pasar cualquier planeta definido en nuestro Enum. Si pasamos TIERRA, la función imprimirá "Usted está en la Tierra!", de lo contrario, imprimirá "Usted no está en la Tierra!".

Manejo de Datos Categóricos

Uno de los usos más prácticos de Enums es para el manejo de datos categóricos. Los datos categóricos son tipos de datos que pueden dividirse en varios grupos o categorías. La ventaja de usar Enums es que pueden ayudar a garantizar que solo utilizaremos los valores predefinidos, evitando la ocurrencia de errores.

Por ejemplo, si estamos creando una aplicación sobre animales y tenemos una categoría llamada 'TipoAnimal', podríamos usar un Enum para definir esa categoría:
```java
public enum tipoAnimal(){
    MAMÍFERO,
    REPTIL,
    AVE,
    PEZ
}
```
Ahora, en nuestro código, sólo podemos elegir entre esas cuatro opciones cuando definimos un tipo de animal, lo que hace que nuestro código sea más seguro y fácil de entender.

En resumen, los Enums en Java son una manera útil y efectiva de manejar información estática y categórica en nuestros programas. Además, hacen que nuestro código sea más seguro, ya que solo permitimos los valores que ya han sido definidos en el Enum, evitando errores o confusiones.

## Para saber más: trabajando con métodos estáticos
En Java, un método estático es un método que pertenece a la clase y no a un objeto específico de esa clase. En términos sencillos, un método estático es aquel que puede ser utilizado incluso si no has creado ningún objeto de la clase.

Si necesitas un método que no tenga que interactuar con los atributos u otros métodos de un objeto, crear un método estático puede ser una solución elegante y eficiente. Por ejemplo, podrías crear un método estático para calcular el promedio de un conjunto de números.

Además, los métodos estáticos se utilizan ampliamente en bibliotecas auxiliares, como la clase Math y la clase Arrays de Java. En lugar de requerir que el usuario cree un objeto para usar los métodos, los métodos son estáticos y, por lo tanto, se pueden acceder directamente desde la clase.

### ¿Cómo los utilizo en Java?

Veamos un código de ejemplo para entender esto mejor:
```java
public class MathUtils {
    public static int add(int a, int b) {
        return a + b;
    }
}
```
En el código anterior, tenemos un método estático llamado "add" que suma dos números. Observa que usamos la palabra clave 'static' para definirlo. ¿Cómo lo utilizamos? Aquí tienes:
```java
int result = MathUtils.add(5, 10);
```
¿Viste? No necesitamos crear un objeto de MathUtils para usar el método "add".

Comprender cómo funcionan los métodos estáticos en Java es de gran importancia, ya que permiten realizar operaciones sin la necesidad de crear objetos y también se utilizan ampliamente en las bibliotecas de Java.

###  Preparando el ambiente: clase y dependencia de la API de OpenA
Enseguida vamos a consumir la API de ChatGPT para trabajar con la traducción de la sinopsis. Para ello, vamos a utilizar la clase ConsultaChatGPT en el paquete service. El código de la clase es el siguiente:
```java
package com.aluracursos.screenmatch.service;

import com.theokanning.openai.completion.CompletionRequest;
import com.theokanning.openai.service.OpenAiService;

public class ConsultaChatGPT {
    public static String obtenerTraduccion(String texto) {
        OpenAiService service = new OpenAiService("TU-API-KEY");

        CompletionRequest requisicion = CompletionRequest.builder()
                .model("gpt-3.5-turbo-instruct")
                .prompt("traduce a español el siguiente texto: " + texto)
                .maxTokens(1000)
                .temperature(0.7)
                .build();

        var respuesta = service.createCompletion(requisicion);
        return respuesta.getChoices().get(0).getText();
    }
}
```
también necesitaremos adicionar una dependencia a nuestro “pom.xml”
```java
<dependency>
<groupId>com.theokanning.openai-gpt3-java</groupId>
<artifactId>service</artifactId>
<version>0.14.0</version>
</dependency>
```
### Para saber más: diferentes tipos de bases de datos
Las bases de datos son como grandes armarios donde almacenamos toda la información que una aplicación necesita para funcionar correctamente: datos sobre usuarios, productos, ventas, etc.

¿Pero todas las bases de datos son iguales? ¡No! Hay diferentes tipos de bases de datos y se definen por la forma en que organizan esa información. Imagina, por ejemplo, que hay armarios con diferentes tamaños de cajones y tipos de compartimentos. Vamos a comprender más sobre dos tipos: las bases de datos relacionales y las bases de datos orientadas a documentos.

¿Qué son las bases de datos relacionales?

Las bases de datos relacionales (RDBMS) son como armarios con muchos cajones de tamaños específicos que almacenan información organizada en tablas con filas y columnas. Cada fila representa un registro único y cada columna representa un campo de ese registro. Es como si organizaras tu ropa separándola por color y tipo: camisas blancas en un cajón, pantalones vaqueros en otro, etc.

La característica principal de un RDBMS es que permite establecer relaciones entre las tablas, es decir, se pueden asociar registros de una tabla con registros de otra. Por ejemplo, una tabla de "Clientes" podría relacionarse con una tabla de "Pedidos", mostrando todos los pedidos realizados por un cliente específico.

Un ejemplo de código en SQL, el lenguaje utilizado en los RDBMS:
```roomsql
CREATE TABLE clientes (
   id INT PRIMARY KEY,
   nombre VARCHAR(100),
   email VARCHAR(100)
);

CREATE TABLE pedidos (
   id INT PRIMARY KEY,
   id_cliente INT,
   producto VARCHAR(100),
   FOREIGN KEY (id_cliente) REFERENCES clientes(id)
);
```
¿Qué son las bases de datos orientadas a documentos?

Las bases de datos orientadas a documentos son como armarios con compartimentos flexibles que permiten almacenar objetos de tamaños diferentes en el mismo lugar. Almacenan la información en formato de documentos, generalmente en JSON, que es un formato de datos liviano, fácil de leer y trabajar, capaz de representar estructuras de datos complejas.

Los documentos pueden contener diferentes campos y estructuras de datos, y los campos pueden contener diferentes tipos de datos. El conjunto de documentos es flexible, es decir, los documentos en la misma base de datos no necesitan tener la misma estructura.

Por ejemplo, podrías tener un documento para un usuario que tiene un campo de dirección, y otro documento para un usuario que no lo tiene.

Un ejemplo de código en MongoDB, una base de datos orientada a documentos:
```roomsql
var miCliente = {
   nombre: "Juan",
   email: "juan@email.com",
   pedidos: [
      { producto: "Camiseta", inscripcion: 2 },
      { producto: "Calza", cantidad: 1 },
   ]
}

db.clientes.insert(miCliente);
```
Al trabajar con bases de datos, es importante comprender las diferencias entre los modelos para elegir la opción que mejor se adapte a las necesidades de tu proyecto. Las bases de datos relacionales son excelentes para datos estructurados y relaciones complejas, que es nuestro caso. Por lo tanto, optamos por un tipo de RDBMS, PostgreSQL.

Por otro lado, las bases de datos orientadas a documentos son ideales para almacenar datos semi-estructurados o no estructurados, ofreciendo escalabilidad y flexibilidad.

Existen otros tipos de bases de datos, por lo tanto, te invitamos a investigar más sobre el tema si deseas profundizar en él.






