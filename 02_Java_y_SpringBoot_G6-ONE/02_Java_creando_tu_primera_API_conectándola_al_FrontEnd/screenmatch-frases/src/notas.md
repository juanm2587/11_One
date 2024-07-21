## Preparando el ambiente: Script para adicionar datos a la base
Como mostramos en el vídeo anterior, abrimos la aplicación PG Admin y ejecutamos a través de Query Tools un script para ya poblar la base de datos con las frases aleatorias.

El script utilizado fue este abajo:
```roomsql
insert into frases(id, frase, personaje, titulo, poster) values (1, 'Amigos no mienten', 'Eleven', 'Stranger things', 'https://m.media-amazon.com/images/M/MV5BMDZkYmVhNjMtNWU4MC00MDQxLWE3MjYtZGMzZWI1ZjhlOWJmXkEyXkFqcGdeQXVyMTkxNjUyNQ@@._V1_SX300.jpg');
insert into frases(id, frase, personaje, titulo, poster) values (2, 'Bienvenida al mundo real. Es una droga. Te va a encantar', 'Monica', 'Friends', 'https://m.media-amazon.com/images/M/MV5BNDVkYjU0MzctMWRmZi00NTkxLTgwZWEtOWVhYjZlYjllYmU4XkEyXkFqcGdeQXVyNTA4NzY1MzY@._V1_SX300.jpg');
insert into frases(id, frase, personaje, titulo, poster) values (3, 'No es una mentira si crees en ella', 'George Contanza', 'Seinfeld', 'https://m.media-amazon.com/images/M/MV5BZjZjMzQ2ZmUtZWEyZC00NWJiLWFjM2UtMzhmYzZmZDcxMzllXkEyXkFqcGdeQXVyNTA4NzY1MzY@._V1_SX300.jpg');
insert into frases(id, frase, personaje, titulo, poster) values (4, 'Somos solo personas. Nos equivocamos, perdemos el rumbo. Incluso los mejores tienen sus malos días. Aún así seguimos adelante', 'Meredith Grey', 'Grey''s Anatomy', 'https://m.media-amazon.com/images/M/MV5BODA2Mjk0N2MtNGY0Mi00ZWFjLTkxODEtZDFjNDg4ZDliMGVmXkEyXkFqcGdeQXVyMzAzNTY3MDM@._V1_SX300.jpg');
insert into frases(id, frase, personaje, titulo, poster) values (5, 'Yo no estoy en peligro, yo soy el peligro', 'Walter White', 'Breaking Bad', 'https://m.media-amazon.com/images/M/MV5BYTU3NWI5OGMtZmZhNy00MjVmLTk1YzAtZjA3ZDA3NzcyNDUxXkEyXkFqcGdeQXVyODY5Njk4Njc@._V1_SX300.jpg');
insert into frases(id, frase, personaje, titulo, poster) values (6, 'No importa lo que hagas en la vida. No va a ser legendario a menos que tus amigos estén allí para verlo', 'Barney', 'How I met your Mother', 'https://m.media-amazon.com/images/M/MV5BNjg1MDQ5MjQ2N15BMl5BanBnXkFtZTYwNjI5NjA3._V1_SX300.jpg');
insert into frases(id, frase, personaje, titulo, poster) values (7, 'No importa cuánto golpees, sino cuánto puedas aguantar y seguir adelante. Cuánto puedes soportar y seguir adelante. Así es como se gana.', 'Rocky Balboa', 'Rocky', 'https://m.media-amazon.com/images/M/MV5BNWIyNmQyNjctYmVmMS00MGI4LWIxMmUtNjA0ODYzOTA0Yjk0L2ltYWdlXkEyXkFqcGdeQXVyNTAyODkwOQ@@._V1_SX300.jpg');
insert into frases(id, frase, personaje, titulo, poster) values (8, '¡Que la fuerza te acompañe!', 'Obi Wan Kenobi', 'Star Wars', 'https://m.media-amazon.com/images/M/MV5BOTA5NjhiOTAtZWM0ZC00MWNhLThiMzEtZDFkOTk2OTU1ZDJkXkEyXkFqcGdeQXVyMTA4NDI1NTQx._V1_SX300.jpg');
insert into frases(id, frase, personaje, titulo, poster) values (9, 'Me salvaste de todas las formas que alguien puede ser salvado.', 'Rose Dawson', 'Titanic', 'https://m.media-amazon.com/images/M/MV5BMDdmZGU3NDQtY2E5My00ZTliLWIzOTUtMTY4ZGI1YjdiNjk3XkEyXkFqcGdeQXVyNTA4NzY1MzY@._V1_SX300.jpg');
insert into frases(id, frase, personaje, titulo, poster) values (10, 'Me diste una eternidad dentro de nuestros días contados, y estoy muy agradecida por eso.', 'Hazel', 'Bajo la misma estrella', 'https://m.media-amazon.com/images/M/MV5BNTVkMTFiZWItOTFkOC00YTc3LWFhYzQtZTg3NzAxZjJlNTAyXkEyXkFqcGdeQXVyODE5NzE3OTE@._V1_SX300.jpg');
```
Si quieres incluir nuevas frases, solo tienes que crear una línea similar, como abajo:
```roomsql
insert into frases(id, frase, personaje, titulo, poster) values (dato1, dato2, dato3, dato4, dato5);
```
Donde cada uno de los datos deberán ser informados de la siguiente forma:

- dato1: es el id, entonces debe ser numérico y se informa sin comillas, ejemplo: 11
- dato2: es la frase, entonces debe ser informado con comillas simples, ejemplo: ‘La vida pasa muy rápido. Si no nos detenemos para disfrutarla de vez en cuando, pasa y ni la ves!’
- dato3: es el personaje que citó la frase, también debe ser informado con comillas simples, ejemplo: ‘Ferris Bueller’
- dato4: es el título de la serie o película, como es un texto, también debe ser informado entre comillas simples, ejemplo: ‘Viviendo la vida loca’
- dato5: aquí es la imagen del póster, también debe ser informada en comillas simples. Nuestra recomendación es buscar la imagen en el sitio omdb, para que al exhibir en el front, todas las imágenes tengan la misma configuración de tamaño. La búsqueda debe ser por el nombre de la película en inglés. Esta película por ejemplo, cuyo nombre en inglés es Ferris Bueller’s Day Off, la búsqueda debe ser así:
```roomsql
https://www.omdbapi.com/?t=ferris+bueller’s+day+off&apikey=<tu_clave>
```
En el retorno del json, encontrarás el enlace para el póster, que en este caso es:
```roomsql
https://m.media-amazon.com/images/M/MV5BMDA0NjZhZWUtNmI2NC00MmFjLTgwZDYtYzVjZmNhMDVmOTBkXkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1_SX300.jpg
```
Así que, para montar el script e insertar esa frase, se utiliza:
```roomsql
insert into frases(id, frase, personaje, titulo, poster) values (11, 'La vida pasa muy rápido. Si no nos detenemos para disfrutarla de vez en cuando, pasa y ni la ves!', 'Ferris Bueller', 'viviendo la vida loca', 'https://m.media-amazon.com/images/M/MV5BMDA0NjZhZWUtNmI2NC00MmFjLTgwZDYtYzVjZmNhMDVmOTBkXkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1_SX300.jpg');
```
Con eso, la frase comienza a aparecer entre las frases aleatorias ya registradas.



