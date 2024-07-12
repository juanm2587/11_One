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

### Para saber mas: JPA e Hibernate
Al trabajar con programación web, a menudo es necesario utilizar bases de datos para almacenar los datos de la aplicación desarrollada, ya sean datos de usuarios, direcciones o cualquier información que deba guardarse para el funcionamiento del programa.

Por lo tanto, es muy interesante que los lenguajes de programación orientados a la web tengan formas de conectarse con la base de datos para poder realizar operaciones de crear, eliminar, consultar y actualizar registros almacenados en la base de datos. Es decir, que permitan realizar un CRUD directamente desde el lenguaje.

Con esto, la mayoría de los lenguajes adoptaron soluciones nativas para manejar conexiones en bases de datos, como es el caso de JDBC (Java Database Connector) en Java. Sin embargo, el uso de este tipo de solución comenzó a ser un poco tedioso, ya que la configuración no era simple ni pequeña y debía realizarse repetidamente de manera idéntica.

Por este motivo, comenzaron a surgir alternativas al uso de estas soluciones nativas, que en lugar de ofrecer una conexión "cruda" con la base de datos, es decir, que requiera la escritura manual de consultas y comandos SQL, comenzaron a presentar código encapsulado que ya incluye gran parte de lo que hacemos a diario con bases de datos, con funciones disponibles en el propio lenguaje, sin la necesidad de mezclarlo con SQL en cada nueva conexión con la base de datos. A este tipo de herramienta, le llamamos ORM, que en español significa Mapeamiento Objeto-Relacional.

Dentro del ecosistema Java, la herramienta ORM más conocida es JPA, o Java Persistence API, que es una especificación creada con el objetivo de simplificar la conexión de bases de datos en aplicaciones Java, a partir de la definición de una interfaz común para la persistencia de datos en el lenguaje.

JPA surge con el propósito de ofrecer una manera más fácil y estandarizada de mapear objetos y tablas de una base de datos relacional, y proporcionar una API para realizar operaciones CRUD utilizando Java.

Para comprender mejor su funcionamiento, es importante familiarizarse con algunos conceptos clave de la especificación, como:

 - Entidad: es una clase Java creada para representar un objeto almacenado en una base de datos. Cada entidad se mapea a una tabla de la base de datos.

 - EntityManager: es la interfaz central de JPA, que se utiliza para realizar operaciones de persistencia, es decir, el CRUD. Es el EntityManager el que gestiona el ciclo de vida de las entidades dentro de una aplicación Java.

 - JPQL: es el lenguaje de consulta de JPA, que permite escribir consultas personalizadas aprovechando la orientación a objetos, es decir, es como una mezcla de Java y SQL, o un lenguaje SQL orientado a objetos. La utilización de JPQL es interesante porque encapsula la llamada real a la base de datos y permite incluso cambiar la base de datos de la aplicación sin necesidad de modificar el código fuente.

Es importante señalar, sin embargo, que JPA es solo una especificación entregada por el lenguaje y no una implementación real de conexión a la base de datos. JPA proporciona una interfaz que debe seguirse para las conexiones de bases de datos utilizando ORM, de manera que la conexión con la base de datos esté encapsulada para reducir el acoplamiento del código.

Por lo tanto, hay varias implementaciones de JPA que realizan conexiones con bases de datos basándose en la especificación y que facilitan la vida del desarrollador, ya que solo es necesario entender JPA, y no necesariamente cómo funciona cada detalle de todas sus implementaciones.

Una de las implementaciones más populares de JPA es Hibernate, que se utilizará durante el transcurso de este curso. Hibernate proporciona una biblioteca basada en JPA que permite el acceso a la base de datos de manera simplificada, mejorando la productividad en el ciclo de desarrollo y ofreciendo funciones avanzadas para la modelación de datos complejos y la gestión de persistencia, como el soporte para herencia y asociaciones y la integración con el proyecto Spring.

Además, Hibernate se distribuye como Open Source y cuenta con una gran comunidad de desarrolladores que mantienen la herramienta, además de mucha documentación disponible para su consulta.

### Para saber más: anotaciones de Hibernate
Hibernate es una de las implementaciones más utilizadas de JPA y proporciona varias anotaciones para la utilización del Mapeo Objeto-Relacional.

¿Conocemos las principales?

- @Entity

Esta anotación se utiliza para marcar una clase como una entidad que debe ser mapeada a una tabla de la base de datos. Cada entidad corresponde a una tabla en la base de datos.

- @Table

Por defecto, Hibernate utiliza el nombre de la clase como el nombre de la tabla en la base de datos, realizando solo la conversión del formato de nomenclatura de PascalCase a SnakeCase, que es el formato utilizado en la base de datos. Sin embargo, si es necesario que el nombre de la clase sea diferente al nombre de la tabla en la base de datos, es posible utilizar esta anotación que permite personalizar el mapeo entre la clase de entidad y la tabla de la base de datos. Con ella, puedes especificar el nombre de la tabla, el esquema y las restricciones de la clave primaria.
```java
@Entity
@Table(name = "mi_tabla")
public class MiEntidad { ... }
```

- @Id

Marca un campo como la clave primaria de la entidad. Hibernate utiliza esta anotación para identificar de manera única los registros en la base de datos.

- @GeneratedValue

Utilizada en conjunto con @Id, esta anotación específica cómo se genera automáticamente la clave primaria. Puede utilizarse con estrategias como AUTO, IDENTITY, SEQUENCE o TABLE, según el tipo de base de datos.

```java
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
```
- @Column

Similar a lo que sucede con la anotación @Table, Hibernate utiliza los nombres de los atributos y los considera idénticos a los nombres de las columnas en la base de datos. En caso de que sea necesario utilizar nombres diferentes, puedes configurar el nombre de la columna, así como su tipo y si es obligatoria.
```java
@Column(name = "nombre_completo", nullable = false)
private String nombre;
```
- @OneToMany y @ManyToOne

Se utilizan para mapear relaciones uno a muchos y muchos a uno entre entidades. Definen las asociaciones entre las tablas en la base de datos.
```java
@Entity
public class Autor {
    @OneToMany(mappedBy = "autor")
    private List<Libro> libros;
}

@Entity
public class Libro {
    @ManyToOne
    @JoinColumn(name = "autor_id")
    private Autor autor;
}
```
- @ManyToMany

La anotación @ManyToMany se utiliza para mapear relaciones muchos a muchos entre entidades.

- @OneToOne

La anotación @OneToOne se utiliza para mapear relaciones uno a uno entre entidades.

- @JoinColumn

La anotación @JoinColumn se utiliza para especificar la columna que se utilizará para representar una relación entre entidades. Se utiliza con frecuencia en conjunto con @ManyToOne y @OneToOne.
```java
@ManyToOne
@JoinColumn(name = "autor_id")
private Autor autor;
```
- @JoinTable

La anotación @JoinTable se utiliza para mapear tablas de unión en relaciones muchos a muchos. Especifica la tabla intermedia que conecta dos entidades.
```java
@Entity
public class Estudiante {
    @ManyToMany
    @JoinTable(name = "inscripcion",
               joinColumns = @JoinColumn(name = "estudiante_id"),
               inverseJoinColumns = @JoinColumn(name = "curso_id"))
    private List<Curso> cursos;
}
```
- @Transient

La anotación @Transient se utiliza para marcar una propiedad como no persistente. Esto significa que la propiedad no se mapeará a una columna en la base de datos.
```java
@Transient
private transientProperty;
```
- @Enumerated

La anotación @Enumerated se utiliza para mapear campos enumerados (enum) a columnas de la base de datos.

```java
@Enumerated(EnumType.STRING)
private Status status;
```
- @NamedQuery

Esta anotación se utiliza para definir consultas JPQL (Java Persistence Query Language) nombradas que pueden reutilizarse en varias partes del código.
```java
@Entity
@NamedQuery(name = "Cliente.findAll", query = "SELECT c FROM Cliente c")
public class Cliente { ... }
```
- @Cascade

La anotación @Cascade se utiliza para especificar el comportamiento de cascada de operaciones de persistencia, como guardar y eliminar, en relaciones. Por ejemplo, puedes configurar para que las operaciones de guardado en cascada afecten a entidades relacionadas.
```java
@OneToMany(mappedBy = "departamento")
@Cascade(CascadeType.SAVE_UPDATE)
private List<Empleado> empleados;
```
- @Embeddable y @Embedded

Estas anotaciones se utilizan para representar tipos integrados (embeddable types) que pueden ser utilizados como componentes en entidades.





```java
@Embeddable
public class Direccion{ ... }

@Entity
public class Cliente {
    @Embedded
    private Direccion direccion;
}
```
Además de estas anotaciones, hay muchas otras que se pueden consultar en la documentación de anotaciones de Hibernate, y que facilitan mucho la vida diaria de los desarrolladores que utilizan el ORM.

### Para saber más: estrategias de generación de ID
Al trabajar con tablas en bases de datos, las claves primarias son esenciales. Por lo general, creamos un identificador único o ID para representar estas claves de la mejor manera posible.

Las claves primarias se utilizan para garantizar que cada entidad se guarde de manera única. Si cuando trabajamos con Java, la JVM se encarga de asignar a cada objeto un lugar en la memoria, en la base de datos esto debe configurarse. Utilizar un ID suele ser una buena forma de hacerlo.

Existen varias formas de generar IDs en la base de datos, y JPA también nos ayuda con esto. Solo necesitas utilizar la anotación GeneratedValue y elegir la estrategia de generación del ID. ¡Posteriormente hablaremos sobre estas diversas estrategias existentes, ¿de acuerdo?!

Estrategia AUTO

La estrategia AUTO es la estrategia predeterminada de generación de ID en JPA. Cuando se utiliza esta estrategia, es JPA la que determina la mejor estrategia a utilizar, basándose en la base de datos específica que estás utilizando.

Aquí tienes un ejemplo de cómo implementar la estrategia AUTO en un código:
```java
@Entity
public class Entidad {
 
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

}
```
Esta estrategia es bastante práctica, ya que JPA se encarga de toda la lógica de generación de ID. Sin embargo, puede ser poco flexible si necesitas un mayor control sobre la generación de ID.

Estrategia SEQUENCE

La estrategia SEQUENCE utiliza una secuencia de la base de datos para generar IDs. Con esta estrategia, la secuencia se incrementa cada vez que se genera un ID, asegurando que cada ID sea único.

Aquí tienes un ejemplo de cómo implementar la estrategia SEQUENCE:
```java
@Entity
public class Entidad {
 
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long id;

}
```
Esta estrategia es especialmente útil para bases de datos que admiten secuencias, ya que es muy eficiente y evita la posibilidad de colisiones de ID.

Estrategia IDENTITY

La estrategia IDENTITY hace uso de columnas de autoincremento proporcionadas por algunas bases de datos. Cada vez que se inserta una nueva entidad en la base de datos, la columna de ID autoincrementado se actualiza para generar un nuevo ID.

Ejemplo de implementación de esta estrategia:
```java
@Entity
public class Entidad {
 
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

}
```
Esta estrategia es útil si estás utilizando una base de datos que admite columnas de autoincremento, como PostgreSQL, MySQL o SQL Server.

Estrategia TABLE

Por último, tenemos la estrategia TABLE. Esta estrategia utiliza una tabla de base de datos separada para generar IDs. Es menos eficiente que las otras estrategias, pero tiene la ventaja de ser portátil entre diferentes proveedores de bases de datos.

Ejemplo de implementación de esta estrategia:
```java
@Entity
public class Entidad {
 
    @Id
    @GeneratedValue(strategy=GenerationType.TABLE)
    private Long id;

}
```
Comprender estas estrategias y saber cuándo utilizar cada una de ellas te permitirá utilizar JPA de manera más eficiente, asegurando que tus datos se persistan de manera confiable y segura. Recuerda, la elección de la estrategia de ID correcta puede tener un gran impacto en la eficiencia de tu aplicación.

### Para saber más: tipos de relaciones en JPA
Cuando hablamos de relaciones en bases de datos, nos referimos a la forma en que diferentes tablas de una base de datos interactúan entre sí. A través de estas relaciones, podemos crear asociaciones lógicas entre diferentes conjuntos de información, facilitando la organización y comprensión de estos datos.

Tenemos tres tipos principales de relaciones:

One-To-Many (Uno-A-Muchos): En este tipo de relación, un registro en una tabla puede relacionarse con muchos registros en otra tabla. Por ejemplo, un profesor puede dar clases a muchos estudiantes, creando una relación uno-a-muchos entre el profesor y los estudiantes.

Many-To-One (Muchos-A-Uno): Aquí, muchos registros en una tabla pueden relacionarse con un registro en otra tabla. Usando el ejemplo anterior, muchos estudiantes pueden tener clases con un mismo profesor, estableciendo una relación muchos-a-uno.

Many-To-Many (Muchos-A-Muchos): En esta relación, muchos registros en una tabla pueden relacionarse con muchos registros en otra tabla. Bien, un estudiante puede tener clases con varios profesores y viceversa, ¿verdad? Esta es una relación muchos-a-muchos.

Para mapear estas relaciones en nuestra aplicación, utilizamos anotaciones específicas de JPA. Pueden ser:

1 - One-To-Many: Utilizamos la anotación @OneToMany para representar este tipo de relación. Veamos un ejemplo:
```java
@Entity
public class Profesor {
    @Id
    private Long id;
    private String nombre;
    
    @OneToMany(mappedBy = "profesor")
    private List<Alumno> alumnos;
}
```
En este código, estamos indicando que un profesor puede tener muchos estudiantes. La propiedad mappedBy se utiliza para señalar el campo que representa al profesor en la entidad Alumno.

2 - Many-To-One: Para este tipo de relación, utilizamos la anotación @ManyToOne. Veamos el ejemplo:
```java
@Entity
public class Alumno {
    @Id
    private Long id;
    private String nombre;
    
    @ManyToOne
    private Profesor profesor;
}
```
Aquí estamos indicando que varios estudiantes pueden ser enseñados por un profesor.

3 - Many-To-Many: Esta relación es un poco más compleja, ya que requiere una tabla intermedia para su implementación. Utilizamos la anotación @ManyToMany para representar esta relación. Echa un vistazo al ejemplo:
```java
@Entity
public class Alumno {
    @Id
    private Long id;
    private String nombre;
    
    @ManyToMany
    private List<Profesor> profesores;
}

@Entity
public class Profesor {
    @Id
    private Long id;
    private String nombre;

    @ManyToMany(mappedBy = "profesores")
    private List<Alumno> alumnos;
}
```
En este caso, estamos diciendo que un estudiante puede tener muchos profesores y un profesor puede tener muchos estudiantes. La tabla intermedia se crea automáticamente por JPA.

Con esta comprensión de las relaciones de bases de datos y cómo representarlas en JPA, podrá modelar sus bases de datos de manera eficiente y lógica.

### Para saber más: relaciones unidireccionales y multidireccionales con JPA
Al trabajar con bases de datos, existen relaciones con diferentes tipos de direcciones. Hay relaciones unidireccionales y bidireccionales. Las relaciones unidireccionales dejan la relación visible solo en un lado, mientras que las relaciones bidireccionales permiten que los objetos de ambos lados accedan y/o modifiquen el objeto del otro lado. Esto es muy útil cuando se desea tener un control más preciso sobre los objetos y las operaciones que se pueden realizar en ellos, como se muestra en el video.

Veamos cómo podemos definir, configurar y controlar estas relaciones.

Definir una Relación Bidireccional

Para definir una relación bidireccional, necesitamos tener dos entidades que estén de alguna manera conectadas. Por ejemplo, consideremos un simple sistema de blogs donde tenemos publicaciones y comentarios. Cada publicación puede tener varios comentarios.

```java
@Entity
public class Post {
    @Id
    @GeneratedValue
    private Long id;
    private String titulo;
    private String contenido;

    @OneToMany(mappedBy = "post")
    private List<Comment> comments = new ArrayList<>();
}

@Entity
public class Comentario {
    @Id
    @GeneratedValue
    private Long id;
    private String contenido;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;
}
```
En el ejemplo anterior, hemos definido una relación "OneToMany" de Post a Comentarios y una relación "ManyToOne" inversa de Comentarios a Post. mappedBy = "post" en Post se refiere al campo post en la clase Comentario.

Errores comunes al configurar mapeos bidireccionales

Error 1: Problemas de mapeo bidireccional

Cuando se tiene una relación bidireccional entre dos entidades, como, por ejemplo, una relación entre los objetos "Alumno" y "Disciplina", donde un alumno puede inscribirse en varias disciplinas y una disciplina puede tener varios alumnos, es necesario prestar atención al mapeo en ambos lados de la relación.

Ejemplo práctico:
```java
@Entity
public class Alumno {
    @OneToMany(mappedBy = "alumno")
    private List<Disciplina> disciplinas;
}

@Entity
public class Disciplina {
    @ManyToOne
    private Alumno alumno;
}
```
En este ejemplo, la entidad "Disciplina" está mapeando a la entidad "Alumno". Sin embargo, la entidad "Alumno" también debe mapear de vuelta a la "Disciplina". La falta de este mapeo bidireccional es una causa común de errores.

Para solucionarlo, incluya el mapeo en el lado "Alumno" de la relación:
```java
@Entity
public class Alumno {
    @OneToMany(mappedBy = "alumno")
    private List<Disciplina> disciplinas;
    
    // incluir este método

    public void addDisciplina(Disciplina disciplina) {
        this.disciplinas.add(disciplina);
        disciplina.setAlumno(this);
    }
}
```
Error 2: Falla al elegir el lado de la propiedad correctamente

En una asociación bidireccional, uno de los lados es el propietario y el otro es el lado inverso. En JPA, el lado propietario siempre se utiliza al actualizar la relación en la base de datos.

Por ejemplo:
```java
@Entity
public class Carro {
    @ManyToOne
    private Duenio duenio;
}

@Entity
public class Duenio {
    @OneToMany(mappedBy = "duenio")
    private List<Carro> carros;
}
```
"En este caso, Carro es la entidad propietaria. Si olvidamos actualizar realmente el lado del propietario, JPA no podrá sincronizar correctamente la asociación con la base de datos.

Para corregirlo, siempre debes actualizar el lado propietario de la relación:"
```java
Duenio duenio= new Duenio();
Carro carro = new Carro();
carro.setDuenio(duenio); // Carro es la entidad proprietária, entonces actualizamos este lado
duenio.getCarros().add(carro);
entityManager.persist(duenio);
```
"Estos son solo dos ejemplos de errores comunes que pueden ocurrir al configurar los mapeos en JPA. Otros errores también pueden suceder, pero la clave para resolverlos es entender bien cómo funciona JPA y siempre analizar y probar cuidadosamente su código."
### Para saber más: operaciones en cascada
Al utilizar el parámetro 'cascade' de una relación, observamos que existen muchas variaciones de operaciones. Veremos en la práctica cómo se puede utilizar cada una de ellas.

Imagina que tenemos dos entidades: Post y Comentario. Un Post puede tener muchos Comentarios. Si eliminamos un Post, ¿qué sucede con los Comentarios relacionados a él? Los tipos de cascada tienen el objetivo de responder a este tipo de preguntas.

Los diferentes tipos de cascada son:

- PERSIST: si persistes la entidad Post, los Comments relacionados también se persistirán.
- MERGE: si fusionas los detalles de un Post, los Comments relacionados también se fusionarán.
- REMOVE: si eliminas un Post, los Comments relacionados también se eliminarán.
- REFRESH: si actualizas el Post, también se actualizarán los Comments relacionados.
- DETACH: si un Post ha sido desanexado, todos los Comments relacionados también se desanexarán.
- ALL: si realizas cualquiera de las operaciones anteriores en un Post, esa operación se propagará a todos los Comments relacionados.
Para aclarar estas definiciones, veamos cómo se ve esto en el código:
```java
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private List<Comment> comments = new ArrayList<>();

    //getters and setters
}

@Entity
public class Comentario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "post_id", nullable = false)
    private Post post;

    //getters and setters
}
```
En este ejemplo, utilizamos CascadeType.ALL, por lo que todas las operaciones se aplicarán a los Comments cuando se realicen las operaciones correspondientes en el Post. Es importante tener conocimiento de estas variaciones para entender cuál de ellas se aplica al programa que estamos desarrollando.

### Para saber más: tipos de busqueda “Eager” or “Lazy”
Estudio detallado sobre Fetch Types: Lazy y Eager

Aprendimos que generalmente encontramos dos tipos de carga de datos: "lazy" y "eager". Estos dos conceptos se refieren principalmente a cuándo y cómo se recuperan los datos de la base de datos para ser utilizados en nuestras aplicaciones.

¿Qué es Fetch Type?

De manera simple, Fetch Type define qué estrategia se utilizará para cargar los datos de la base de datos a su aplicación.

Para facilitar nuestra comprensión, me gusta usar la analogía del desayuno. Imagina que tienes una mesa de desayuno y puede haber varios elementos en ella, como pan, café, leche, frutas, etc.

La forma en que tomas estos elementos, cuándo y cuántos a la vez, es básicamente el concepto detrás del fetch type, que veremos a continuación.

Lazy Fetch Type

Lazy, en inglés, significa perezoso. En términos de programación, Lazy Fetch Type es cuando obtienes solo lo que necesitas en el momento que lo necesitas.

Volviendo a nuestra analogía del desayuno, sería como tomar solo el café primero. Cuando estés listo para comer algo, luego tomas una fruta o un pan. Es decir, solo obtienes los otros elementos cuando realmente los necesitas.

Tomemos como ejemplo la relación entre un usuario y sus publicaciones en una aplicación de blog. Si optamos por el fetch type lazy, al cargar el usuario, sus publicaciones no se cargarán automáticamente. Se pospondrán hasta que se soliciten explícitamente, como se muestra a continuación:
```java
@Entity
public class Usuario {
    @OneToMany(fetch = FetchType.LAZY)
    private List<Post> posts;
}
```
Fetch Type Eager

"Ansioso" en inglés se traduce como "eager". En programación, Eager Fetch Type es más rápido, ya que recupera todos los datos relacionados al mismo tiempo.

Volviendo a la analogía del desayuno, Eager Fetch Type sería como tomar todo lo que está en la mesa de una sola vez. Agarras el café, el pan, la leche, las frutas, todo de una sola vez.

En la relación usuario/publicaciones, si optamos por el fetch type eager, al cargar el usuario, todas sus publicaciones se cargarán simultáneamente.
```java
public class Usuario {
    @OneToMany(fetch = FetchType.EAGER)
    private List<Post> posts;
}
```
Impacto en el Rendimiento de la Aplicación

La estrategia de carga afecta directamente el rendimiento de la aplicación. Una carga Eager puede parecer eficiente, ya que todo se carga de una vez. Sin embargo, si la relación involucra muchos datos, esto puede causar problemas de rendimiento, además de consumir mucha más memoria, ya que estamos cargando más datos de los que realmente necesitamos.

Por otro lado, Lazy Fetch Type puede parecer una estrategia más eficaz, ya que carga los datos bajo demanda. Sin embargo, si no se administra cuidadosamente, puede resultar en múltiples llamadas a la base de datos, aumentando el tiempo de respuesta.

Elegir entre Lazy y Eager no es una decisión trivial y debe basarse en las necesidades de la aplicación. Un buen punto de partida es comenzar con Lazy Fetch Type y optar por Eager cuando la carga completa sea necesaria con frecuencia.

El alcance de la aplicación, la cantidad de datos, la frecuencia de acceso y muchos otros factores serán determinantes para esta elección. Siempre es importante analizar el contexto y probar el rendimiento para lograr la mejor estrategia.

Comprender los conceptos de Fetch Types, lazy y eager, es un paso muy importante para mejorar el rendimiento de tu aplicación. Por lo tanto, siempre busca mejorar y perfeccionar tu conocimiento en esta área.
### Para saber más: consultas derivadas (derived queries)
JPA tiene diversos recursos, y uno de los más interesantes que podemos utilizar son las "derived queries" (consultas derivadas), donde trabajamos con métodos específicos que consultan la base de datos de manera personalizada. Estos métodos se crean en la interfaz que hereda de JpaRepository. En ellos, utilizaremos palabras clave en inglés para indicar qué búsqueda queremos realizar.

La estructura básica de una consulta derivada en JPA consiste en:

verbo introductorio + palabra clave "By" + criterios de búsqueda

Como verbos introductorios, tenemos find, read, query, count y get. Los criterios son variados. Veremos algunos ejemplos en el video, pero puedes explorar mucho la práctica para entenderlos mejor.

Los criterios más simples involucran solo los atributos de la clase mapeada en el Repository. En nuestro caso, un ejemplo de este criterio sería findByTitulo, donde realizamos una búsqueda de series con un atributo específico de la clase Serie. Pero podemos agregar condiciones a estos criterios. Es aquí donde surge findByTituloContainingIgnoreCase(). Para aplicar filtros, podríamos usar varias otras palabras. Entre ellas, podemos mencionar:

Palabras relativas a la igualdad:

Is, para verificar igualdades

Equals, para verificar igualdades (esta palabra clave y la anterior tienen los mismos principios y se utilizan más para la legibilidad del método).

IsNot, para verificar desigualdades

IsNull, para verificar si un parámetro es nulo

Palabras relativas a la similitud:

Containing, para palabras que contengan un fragmento

StartingWith, para palabras que comiencen con un fragmento

EndingWith, para palabras que terminen con un fragmento

Estas palabras se pueden concatenar con otras condiciones, como ContainingIgnoreCase, para evitar problemas de sensibilidad a mayúsculas y minúsculas.

Palabras relacionadas con la comparación:

LessThan, para buscar registros menores que un valor

LessThanEqual, para buscar registros menores o iguales a un valor

GreaterThan, para identificar registros mayores que un valor

GreaterThanEqual, para identificar registros mayores o iguales a un valor

Between, para saber qué registros están entre dos valores

Estas son solo algunas de las palabras que podemos utilizar, ¡y podemos combinarlas de muchas formas! A lo largo de los próximos videos, vamos a ejercitar nuestros conocimientos realizando varias búsquedas con estas palabras clave, ¡pero también te invitamos a probar con varios ejemplos para ver cómo funciona en la práctica!
### Para saber más: ordenaciones y otras palabras claves de las consultas derivadas
Para trabajar con la ordenación de registros buscados, también existen algunas palabras clave. Podemos utilizar OrderBy para ordenar los registros por algún atributo de ellos, como la serie por la evaluación. También podemos encadenar atributos. Si una Serie tiene un Actor y queremos ordenar por el nombre del actor, podemos utilizar OrderByActorName, por ejemplo.

Además de OrderBy, aún existen algunos otros recursos de filtros que pueden ser utilizados:

Distinct, para eliminar datos duplicados

First, para obtener el primer registro

Top, para limitar el número de datos

Todavía hay una infinidad de palabras clave y recursos que podemos utilizar con las derived queries. Sugerimos que leas la documentación y practiques.

La documentación de Spring Data JPA está en el enlace.

link: https://spring.io/projects/spring-data-jpa

¡Buena lectura!
### Para saber más: SQL, queries nativas y JPQL
Cuando comenzamos a aprender sobre el desarrollo web con Java, en algún momento nos encontramos con la necesidad de interactuar con bases de datos. Dentro de este universo, podemos realizar varios tipos de búsquedas, como las derived queries, la JPQL (Java Persistence Query Language) y el propio SQL nativo.

Pero, ¿cuál es la diferencia entre ellas y cómo afecta la portabilidad entre diferentes bases de datos? Vamos a analizar aquí las queries nativas y la JPQL.

La JPQL es un lenguaje de consulta orientado a objetos que se definió como parte de la especificación JPA (Java Persistence API). Se utiliza para realizar consultas en bases de datos relacionales de manera similar a SQL, pero con una diferencia fundamental: en lugar de trabajar con tablas y columnas, como en SQL, la JPQL trabaja con clases y atributos que forman parte de su modelo de dominio.

```roomsql
// Exemplo de Query JPQL
String jpql = "select c from Customer c where c.name like :name";
```
Comprendiendo el SQL Nativo

Por otro lado, el SQL Nativo es el lenguaje estándar utilizado para interactuar con bases de datos relacionales. Con él, escribes consultas que son específicas para la estructura y sintaxis de la base de datos que estás utilizando.
```roomsql
SELECT * FROM Customer WHERE name LIKE '%John%';
```
Para utilizarlas en el repositorio, debemos usar el atributo nativeQuery de la anotación @Query, como se muestra en el video.

La principal diferencia entre JPQL y SQL Nativo es, por lo tanto, el nivel de abstracción. JPQL abstrae los detalles de la base de datos, permitiéndote trabajar en el nivel del modelo de dominio. Esto puede hacer que el código sea más legible y fácil de mantener.

SQL Nativo, por otro lado, permite un control más detallado y directo sobre las consultas a la base de datos. Esto puede ser útil si necesitas optimizar tus consultas para una base de datos específica.

Sin embargo, existe la cuestión de la portabilidad. Como JPQL es una abstracción de alto nivel, es compatible con cualquier base de datos que admita la especificación JPA. Si necesitas cambiar tu aplicación de una base de datos a otra, la mayoría de tus consultas JPQL seguirán funcionando sin cambios.

Por otro lado, con SQL Nativo, si decides cambiar de una base de datos a otra, es probable que tengas que reescribir parte de tus consultas, ya que cada base de datos tiene sus particularidades de sintaxis y funcionamiento.

La elección entre JPQL y SQL Nativo a menudo depende de las necesidades de tu proyecto. Si la portabilidad es una prioridad y tu modelo de dominio es complejo y rico en información, JPQL puede ser la mejor opción. Si el rendimiento es una prioridad y necesitas un control detallado sobre tus consultas, SQL Nativo puede ser la mejor opción.

Comprender estos conceptos te permitirá tomar decisiones más acertadas, minimizando problemas futuros y optimizando el rendimiento de tus aplicaciones. ¡Así que sigue estudiando y profundizando tus conocimientos!
### Para saber más: los comandos LIKE y ILIKE
LIKE es un comando SQL utilizado en la cláusula WHERE para buscar un patrón específico en una columna. En otras palabras, es una forma de realizar una búsqueda en una tabla, similar a cómo se utiliza un filtro de búsqueda en una hoja de cálculo de Excel o el método contains() en Java.

Puede que te estés preguntando: "¿Por qué debería aprender sobre LIKE si puedo buscar directamente la información que quiero en mi tabla?". Bueno, imagina que tienes una tabla con miles de registros y necesitas encontrar todos los nombres que comienzan con la letra 'A'. Hacerlo manualmente llevaría mucho tiempo, ¿verdad? ¡Aquí es donde el comando LIKE resulta realmente útil!

Con el comando LIKE, puedes simplificar esta tarea realizando una consulta que devuelva solo los registros que coincidan con el patrón que defines.

La sintaxis básica para utilizar el comando LIKE es la siguiente:
```roomsql
SELECT column1, column2, ...
FROM table_name
WHERE column LIKE pattern;
```
El 'pattern' es el patrón que estás buscando. Para definir este patrón, utilizas los caracteres comodín % y _. El % sustituye a cero o más caracteres, mientras que _ sustituye a un solo carácter.

Por ejemplo, para encontrar todos los nombres en una tabla de clientes que comienzan con 'A', usarías:
```roomsql
SELECT nombre
FROM clientes
WHERE nombre LIKE 'A%';
```
Esto devolverá todos los registros en la columna 'nome' que comienzan con 'A'.

Si deseas todos los nombres que contienen 'A' en cualquier parte del nombre, utilizarías:
```roomsql
SELECT nombre
FROM clientes
WHERE nombre LIKE '%A%';
```
El comando ILIKE es una extensión específica de algunos sistemas de gestión de bases de datos, como PostgreSQL, que proporciona una coincidencia insensible a mayúsculas y minúsculas en el patrón de búsqueda, similar al comando LIKE.

Entonces, ¿dónde encaja el comando ILIKE que usamos en clase? El comando LIKE es sensible a mayúsculas y minúsculas en algunos sistemas de gestión de bases de datos. Por lo tanto, si desea una búsqueda que no tenga en cuenta esto, similar a IgnoreCase en Java, debe utilizar ILIKE.

Nuevamente, es importante que entendamos el uso de estos dos comandos para poder compararlos y elegir el que mejor se adapte a nuestra realidad como desarrolladores.
### Para saber más: unión en SQL
Si quieres explorar más sobre qué son las uniones, cómo ocurren en la base de datos y qué tipos existen, te recomendamos leer el artículo Uniones y sus tipos:

link: https://www.aluracursos.com/blog/sql-join-aprenda-inner-left-right-full-e-cross

¡Feliz buceo!
### Desafío: consolidando los conocimientos (desafío extra)
Hola, ¿cómo estás? ¿Te gustó el contenido presentado en el curso?

En esta actividad, propondremos un nuevo desafío para que puedas consolidar los conocimientos y utilizar gran parte de los conceptos y recursos vistos a lo largo del curso. Trabajar con la integración de bases de datos será una tarea muy común en tu día a día como desarrollador, así que es crucial practicar y realizar ejercicios para afianzar el conocimiento.

La propuesta es crear una nueva aplicación diferente a ScreenMatch para que tengas la oportunidad de ejercitar tus conocimientos. No solo los que has adquirido en este curso, sino también otros conceptos previos que has estado practicando a lo largo de otras formaciones.

Vamos a colocarnos manos a la obra, la idea principal es que consigas crear una aplicación con el tema de tu elección que permita a sus usuarios interactuar a través de un menú por consola, para ilustrarlo mejor voy a sugerir trabajar con un ejemplo de música, entonces este menú debe permitir:

- Registrar datos de cantantes
- Registrar datos de canciones
- Buscar canciones por cantantes
- Y como adicional si lo deseas puedes integrar con ChatGPT y obtener información sobre un cantante de elección de nuestro usuario.
Recuerda que para lograr todo esto debemos:

Crear nuestra base de datos

En nuestro archivo pom.xml, adicionar las dependencias necesarias para que nuestra aplicación funcione correctamente.

Conectar nuestra aplicación a la base de datos configurando nuestro archivo application.properties.

Modelar y mapear las entidades que serán representadas como tablas en nuestra base de datos (cantantes y canciones por ejemplo) En este punto tu puedes escoger cuáles datos mapear en tu aplicación pues no estamos trabajando consumiendo ninguna API así que tendrás que llenar los datos manualmente.

Establecer la relación entre tablas: recuerda que debes mapear muy bien la relación que existe entre las tablas de tu aplicación, volviendo a nuestro ejemplo de música podemos pensar que (1) un artista puede tener (n) varias canciones así que no te olvides de adicionar las anotaciones correspondientes en cada una de las clases e de relacionar correctamente la llave extranjera para cada uno de los registros, una vez hecho esto estarás listo para guardar satisfactoriamente las informaciones en la base de datos.

Ahora es momento de realizar algunas búsquedas, puedes optar por utilizar el tipo de consulta que desees, sea usando Derived Querys, Native Querys o JPQL.

Y como extra opcional puedes intentar realizar una integración con la API de ChatGPT para buscar información sobre un asunto determinado, en caso de nuestro ejemplo informaciones sobre un cantante :D

Una vez finalizado tu proyecto no olvides subirlo a tu GitHub y adicionarlo a tu portafolio de proyectos, ah y como tip adicional conmemora tu conquista compartiendo tus resultados en tu LinkedIn y de esta forma mostrar a tu red de contactos en lo que estás trabajando.

solucion: https://github.com/alura-es-cursos/2066-desafio-persistiendo-datos-artistas-canciones





