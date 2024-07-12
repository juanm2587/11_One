## Para saber más: errores de puertos
Al intentar ejecutar el proyecto, puedes obtener el siguiente error:
```java

***************************
APPLICATION FAILED TO START
***************************

Description:

Web server failed to start. Port 8080 was already in use.

Action:

Identify and stop the process that's listening on port 8080 or configure this application to listen on another port.

Process finished with exit code 1
```
Este error indica que estás intentando acceder al puerto 8080, pero ya está en uso. Spring Boot ya sube el servidor por defecto en el puerto 8080, pero podemos cambiar ese puerto para continuar sin errores. Para hacerlo, basta con agregar la siguiente línea en el archivo application.properties:
```properties
server.port=8081
```
En este caso, estamos cambiando el puerto a 8081, pero puedes intentar utilizar algún otro también. Así, tu proyecto se ejecutará normalmente y podremos continuar.
## Para saber más: conociendo HTTP, API REST y comunicación web
Al trabajar con Spring Web estamos levantando un servidor en un puerto de nuestra computadora. Pero, ¿qué es un servidor?

Servidor es justamente algo que ofrece recursos a los clientes. En nuestro caso, el recurso ofrecido serán las series que están en nuestra base de datos. Ofrecemos estos recursos con el uso de nuestra API, o "Interface de Programación de Aplicaciones", traduciendo la sigla.

Para que eso sea posible, necesitamos usar Spring Web como dependencia de nuestra aplicación. Con esto, a diferencia de como se hacía anteriormente, Spring inicia automáticamente un servidor TomCat en el puerto 8080, lo que facilita el trabajo del desarrollador.

Estamos desarrollando una API que se comunicará con el mundo externo a través del protocolo HTTP. Una vez que entendemos la relación entre servidor y cliente y conocemos HTTP, necesitamos pensar en cómo nuestros datos serán transmitidos.

Durante el curso, trabajaremos con una API REST (Representational State Transfer, o Transferencia de Estado Representacional). Cuando hablamos de este concepto, nos referimos a un conjunto de principios de arquitectura que especifican cómo las solicitudes y respuestas deben ser construidas en una API.

Los datos en una API REST son generalmente enviados y recibidos en el formato JSON (JavaScript Object Notation). No obstante, también pueden ser enviados en otros formatos, como XML.

La arquitectura REST sugiere el uso de métodos HTTP estandarizados para realizar tareas específicas, incluyendo:

- GET para obtener datos.
- POST para enviar nuevos datos.
- PUT para actualizar datos existentes.
- DELETE para eliminar datos.

Teniendo un estándar, la comunicación es mucho más eficiente. Además, las APIs REST deben ser stateless, lo que significa que las solicitudes del cliente pueden ser procesadas independientemente unas de otras. Esto las hace altamente escalables, facilitando la vida de los desarrolladores que trabajan en grandes proyectos web, ya que facilita la gestión, el mantenimiento y la prueba del software.

A lo largo del curso hablaremos más sobre todos estos conceptos y los veremos en la práctica. ¡Así, vamos a profundizar cada vez más! :D
## Para saber más: el patrón MVC
MVC es un concepto muy importante en el mundo de la programación. Esta es una sigla que significa Model-View-Controller, o Modelo-Vista-Controlador en español. Se utiliza para organizar el código de muchos tipos de software, facilitando el desarrollo y haciendo el programa más fácil de ser mantenido y actualizado. Vamos a entender mejor cómo todo esto funciona.

#### ¿Por qué el Modelo MVC es importante?
¡Imagina que estás construyendo una casa! Si simplemente comienzas a construir sin un plan, puedes terminar con habitaciones extrañas o estructuras mal posicionadas. Pero, si defines bien los proyectos antes de empezar, tu casa será mejor organizada y será más fácil de vivir. Lo mismo se aplica al código de un programa, donde la casa es equivalente a tu aplicativo y el plan es el modelo MVC.

Al seguir el modelo MVC, dividimos el código de nuestra aplicación en tres partes:

1 - El Modelo, que es donde todos los datos y las reglas de negocio son procesados.

2 - La Vista, que es la interfaz de usuario, donde ves los resultados de las operaciones.

3 - Y el Controlador, que es como el cerebro que opera las otras dos partes, recibiendo entradas del usuario y enviando comandos para el Modelo y la Vista.

#### ¿Cómo el Modelo, la Vista, y el Controlador interactúan?
Vamos a utilizar un simple ejemplo de un sitio web de registro de libros para explicar cómo funciona el modelo MVC.

En el caso del Modelo, piensa en él como el repositorio de todos los libros que están registrados en el sitio. Guarda toda la información, como título, autor y género del libro. También tiene todas las reglas, como verificar si el libro ya está registrado o no.

La Vista es la Página que ves en tu navegador. Presenta un formulario para agregar un nuevo libro y una lista de todos los libros ya registrados.

Y finalmente, tenemos el Controlador. Digamos que quieres agregar un nuevo libro. Escribes la información en el formulario y haces clic en 'Enviar'. Aquí es donde el Controlador entra en acción. Él “toma” la información que escribiste, verifica con el Modelo si el libro ya existe (si esa es la regla) y, si todo está correcto, pide al Modelo agregar el nuevo libro. Luego, instruye a la Vista para mostrar la nueva lista de libros con lo que acabas de agregar.

¿Ves cómo todo trabaja junto? Cada parte hace un trabajo específico, pero todas se comunican para mantener las cosas funcionando a la perfección.

¿Cómo el Modelo MVC ayuda en la organización del código y en el mantenimiento de la aplicación?

Cuando el código está bien organizado, es mucho más fácil identificar problemas, hacer actualizaciones y agregar nuevas funcionalidades. Por ejemplo, si un día decides que quieres cambiar el color de fondo de tu sitio, solo necesitas ir a la Vista y hacer el cambio. Si decides cambiar las reglas para agregar un nuevo libro, vas directo al Modelo.

Esta organización también facilita mucho la vida de cualquier otra persona que pueda trabajar en tu código en el futuro. Y si decides ofrecer tu sitio en diferentes idiomas, por ejemplo, puedes simplemente agregar una nueva Vista, sin necesidad de tocar el Modelo o el Controlador.

Entonces, el Modelo MVC es un gran aliado a la hora de desarrollar una aplicación. Además de facilitar el entendimiento y el mantenimiento del código, ayuda a prepararlo para los cambios y mejoras que siempre surgen con el tiempo.

#### MVC en Java
En Java, el patrón MVC era comúnmente aplicado utilizando las tecnologías JSP o Thymeleaf. Con JSP (Java Server Pages), es posible mezclar códigos Java y HTML para crear páginas web dinámicas. Con Thymeleaf, los códigos no se mezclan, pero tenemos páginas HTML dentro de la carpeta resources del proyecto. Estas páginas se comunican con el código Java y hacen que podamos visualizar la información en el navegador.

Estas tecnologías hacían que la Vista del MVC estuviera dentro de la aplicación Java. Sin embargo, actualmente lo más común en el mercado es tener una separación entre front-end y back-end. En el back-end, tenemos el Modelo y el Controlador. El back-end proporciona información que será utilizada por el front-end, que será responsable por la parte de la Vista.

Ahora que sabes la teoría, es hora de poner manos a la obra y empezar a practicar. Y recuerda: cada nuevo concepto aprendido es un paso adelante en tu trayectoria como desarrollador. ¡Buena suerte!

## 








