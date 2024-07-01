## ¿Qué es el Optional?

`Optional` es un contenedor de un solo valor introducido en Java 8. Puede contener un valor único o ningún valor. El principal uso de `Optional` es proporcionar un tipo de retorno alternativo cuando un método puede no devolver un valor.

Usar `null` es una práctica común, pero puede llevar a errores como `NullPointerException`. `Optional` ayuda a evitar estos errores proporcionando una manera más segura de manejar valores que pueden o no estar presentes.

## ¿Cómo usar el Optional?

Creemos un método que puede devolver un valor `null`. Sin `Optional`, podría causar errores no deseados, pero con `Optional`, es más seguro:

```java
public Optional<String> getNombre() {
		// El nombre puede ser null
		return Optional.ofNullable(nombre);
		}
```
Aquí, Optional.ofNullable(nombre) creará un Optional que contiene el valor de nombre si no es null. Si es null, creará un Optional vacío.

Ahora, para acceder al valor dentro de Optional, podemos usar ifPresent y orElse así:

```java
Optional<String> optionalNombre = getNombre();

optionalNombre.ifPresent(System.out::println); // Imprimirá el nombre solo si no es null

String nombre = optionalNombre.orElse("Nombre no disponible"); // Devolverá "Nombre no disponible" si nombre es null

```
## Mejores prácticas
Aunque Optional es un aliado útil, hay algunas cosas que deben tenerse en cuenta para usarlo de manera efectiva:

- Prefiera el retorno de Optional en lugar de devolver null: Esto hace que sus intenciones sean claras y evita errores.
- No use Optional.get() sin Optional.isPresent(): Optional.get() lanzará un error si el valor no está presente. Por lo tanto, es mejor verificar antes si el valor está presente.
- No use Optional para campos de la clase o parámetros del método: Optional debe usarse principalmente para retornos de métodos que pueden no tener valor.

Comprender y usar Optional correctamente puede llevar a un código más limpio y menos propenso a errores, así que vale la pena invertir tiempo para aprenderlo.


## Trabajar en actividades paralelas
Trabajar en actividades paralelas es una práctica esencial en programación, ya que permite ejecutar varias tareas simultáneamente, aumentando la eficiencia del código. Una de las formas de lograr la programación paralela en Java es mediante el uso de threads.

Las threads son unidades independientes de ejecución que pueden crearse dentro de un programa. Permiten que diferentes partes del código se ejecuten al mismo tiempo, mejorando el rendimiento y la capacidad de respuesta del programa.

### findAny

Una operación útil para trabajar con threads es el método `findAny` en colecciones de datos. Este método se utiliza para encontrar cualquier elemento que cumpla con una condición específica en una colección. Devuelve un `Optional`, que puede contener el elemento encontrado o estar vacío si ningún elemento cumple con la condición.

Al utilizar `findAny` en una colección con threads, cada thread puede buscar un elemento de la colección de manera paralela, haciendo que la búsqueda sea más rápida y eficiente. Es importante destacar que `findAny` no garantiza que siempre se devolverá el mismo elemento, ya que el orden de búsqueda puede variar entre las threads.

Para utilizar `findAny` con threads, puedes crear una implementación de `Predicate` que defina la condición que los elementos deben cumplir. Luego, puedes utilizar el método `parallelStream` en una colección para crear un stream paralelo y llamar a `findAny`, pasando el `Predicate` como argumento. Veamos un ejemplo:

```java
public class EjemploFindAnyParallelStream {
    public static void main(String[] args) {
        List<Integer> numeros = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            numeros.add(i);
        }

        // Utilizando parallelStream para encontrar un elemento cualquiera en paralelo
        Optional<Integer> numeroCualquiera = numeros.parallelStream()
                .filter(numero -> numero % 10 == 0) // Filtra los números que son múltiplos de 10
                .findAny();

        if (numeroCualquiera.isPresent()) {
            System.out.println("Encontrado: " + numeroCualquiera.get());
        } else {
            System.out.println("Ningún número encontrado.");
        }
    }
}
```
En este ejemplo, tenemos una lista de números del 1 al 100. Utilizando `parallelStream`, filtramos los números que son múltiplos de 10 y luego utilizamos `findAny` para encontrar cualquier elemento que cumpla con esta condición.

Dado que la búsqueda se realiza en paralelo, el resultado puede variar en cada ejecución del programa, ya que diferentes threads pueden encontrar elementos diferentes del stream. La salida en la consola podría ser, por ejemplo:

- `Encontrado: 70`
- `Encontrado: 50`
- O cualquier otro número que sea múltiplo de 10 dentro de la lista.

Cabe destacar que, para algunos tipos de streams, como streams de listas o arrays, se mantiene el orden de los elementos. Sin embargo, en un stream paralelo, la búsqueda se realizará de manera concurrente y el resultado puede ser cualquier elemento que cumpla con la condición de filtrado. Por lo tanto, en streams paralelos, el método `findAny` puede ser más útil para obtener cualquier elemento sin garantía de un resultado específico.


## Para saber más: clases que facilitan la generación de estadísticas

Cuando se trata de generar estadísticas en Java, hay clases que pueden simplificar considerablemente el trabajo. Dos de ellas son `DoubleSummaryStatistics` e `IntSummaryStatistics`, que se utilizan para calcular estadísticas básicas en colecciones de valores de tipo `double` e `int`, respectivamente.

La clase `DoubleSummaryStatistics` es una clase de utilidad que permite calcular estadísticas como suma, promedio, valor mínimo y máximo, además del total de elementos en una colección de valores de tipo `double`. Tiene métodos como `getSum()`, `getAverage()`, `getMin()`, `getMax()` y `getCount()`, que devuelven los respectivos valores estadísticos.

De manera similar, la clase `IntSummaryStatistics` se utiliza para calcular estadísticas básicas en colecciones de valores de tipo `int`. También tiene métodos como `getSum()`, `getAverage()`, `getMin()`, `getMax()` y `getCount()` para obtener las estadísticas deseadas.

Estas clases son especialmente útiles cuando necesitas realizar cálculos estadísticos en una colección de valores. Por ejemplo, si tienes una lista de precios de productos y deseas calcular el promedio, el valor mínimo y el valor máximo, puedes utilizar la clase `DoubleSummaryStatistics` para obtener esta información de manera simple y eficiente, de manera muy similar a lo que hicimos al obtener estadísticas sobre los episodios con la calificación más alta y más baja, el promedio y el total de elementos considerados en la recopilación de estadísticas.

Para usar estas clases, puedes crear una instancia de ellas y luego recorrer la colección de valores, actualizando las estadísticas según sea necesario. Al final del proceso, puedes llamar a los métodos apropiados para obtener las estadísticas deseadas. Veamos un ejemplo en el que tenemos una lista de estudiantes y queremos obtener datos sobre sus edades.

Para la clase `Alumno`, tendremos el siguiente código:

```java
public class Alumno {
    private String nombre;
    private LocalDate fechaNacimiento;

    public Alumno(String nombre, LocalDate fechaNacimiento) {
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getEdad() {
        Period periodo = Period.between(fechaNacimiento, LocalDate.now());
        return periodo.getYears();
    }

    // getters, setters y toString omitidos
}
```

Hemos creado un método getEdad(), donde estamos utilizando Period, que al igual que LocalDate, es una clase del paquete java.time, para calcular la edad del estudiante según el día en que se está ejecutando la aplicación.

En nuestra clase principal tendremos el siguiente código:

```java
public class Principal {
    public static void main(String[] args) {
        List<Alumno> alumnos = Arrays.asList(
                new Alumno("Alice", LocalDate.of(2002, 10, 20)),
                new Alumno("Bob", LocalDate.of(1980, 8, 9)),
                new Alumno("Carlos", LocalDate.of(2001, 01, 28)),
                new Alumno("David", LocalDate.of(2003, 05, 12)),
                new Alumno("Eva", LocalDate.of(2005, 12, 03))
        );

        IntSummaryStatistics estadisticas = alumnos.stream()
                .mapToInt(Alumno::getEdad)
                .summaryStatistics();

        // Mostrando las estadísticas
        System.out.println("Edad promedio: " + estadisticas.getAverage());
        System.out.println("Edad mínima: " + estadisticas.getMin());
        System.out.println("Edad máxima: " + estadisticas.getMax());
        System.out.println("Total de alumnos: " + estadisticas.getCount());
    }
}
```
En resumen, las clases DoubleSummaryStatistics e IntSummaryStatistics son herramientas útiles para facilitar la generación de estadísticas básicas en colecciones de valores de tipo double e int. Proporcionan métodos simples y eficientes.


## Para saber más: uso avanzado de Java y streams

Java Streams es una característica poderosa que proporciona la capacidad de realizar operaciones de procesamiento de datos complejas de manera eficiente y en paralelo, sobre colecciones, arrays y canales de E/S. Cuando comienzas a comprender mejor Java Streams, te das cuenta de que se puede utilizar de muchas maneras diferentes para hacer que tu código sea más limpio y eficiente. Vamos a profundizar en los usos avanzados de Java Streams y cómo puedes comenzar a integrarlos en tus proyectos.

## Usos Avanzados de Java Streams

Cuando trabajamos con Java Streams, a menudo vamos más allá del uso básico y exploramos conceptos más avanzados y complejos. Veamos algunos ejemplos:

### 1. Streams Infinitos

Los Streams infinitos, o "infinite Streams", son Streams que no tienen un tamaño definido. Son útiles cuando queremos generar una secuencia de números o valores. Aquí tienes un ejemplo de cómo creamos un Stream infinito con el método `iterate`:

```java
    Stream.iterate(0, n -> n + 1)
         .limit(10)
        .forEach(System.out::println);
```

En el ejemplo anterior, comenzamos con el número 0 y agregamos 1 en cada iteración para generar una secuencia numérica. Utilizamos el método limit() para limitar el Stream infinito a 10 elementos y usamos forEach para imprimirlos.

2. FlatMap
   El método flatMap es una operación intermedia que se utiliza para transformar un Stream de colecciones en un Stream de elementos. Aquí tienes un ejemplo de cómo se usa flatMap:

```java
List<List<String>> lista = List.of(
List.of("a", "b"),
List.of("c", "d")
);

Stream<String> stream = lista.stream()
.flatMap(Collection::stream);
stream.forEach(System.out::println);
```

En este ejemplo, transformamos un Stream de Listas en un Stream de Strings.

3. Reducción de Streams
   Stream.reduce() es una operación terminal que se utiliza para reducir el contenido de un Stream a un único valor.

```java
List<Integer> numeros = List.of(1, 2, 3, 4, 5);
		Optional<Integer> resultado = numeros.stream().reduce(Integer::sum);
		resultado.ifPresent(System.out::println); // imprime 15
```
En el ejemplo anterior, sumamos todos los números de la lista utilizando el método reduce().

Recuerda que Java Streams es una herramienta poderosa que puede hacer que tu código sea más elegante y eficiente. Sigue practicando y explorando todas las operaciones y métodos disponibles con Java Streams para volverte más hábil en el manejo de datos en tus aplicaciones.


