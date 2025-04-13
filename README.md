<h1>API POKEDEX</h1>
Esta es una API REST construida con Java y el framework Spring Boot, diseñada para proporcionar información detallada sobre Pokémons.

<h2>Descripción general</h2>
Esta API Pokedex ofrece una interfaz para acceder a datos completos sobre Pokémon, incluyendo sus estadisticas, tipos, debilidades y evoluciones. 
Creada con Java 17 y Spring Boot, la API destaca por su eficiencia y facilidad de uso. Se utilizan las librerías Lombok y Maven para mejorar la productividad y la gestión del proyecto.

<h2>Características</h2>
<ul>
  <li><strong>Información Detallada:</strong> Accede a datos exhaustivos de cada Pokémon, como tipos, debilidades, estadísticas, evoluciones.</li>
  <li><strong>Arquitectura REST:</strong> Diseño basado en principios REST para una integración sencilla, respuestas con formatos estadarizados y un rendimiento óptimo.</li>
  <li><strong>Fácil de Usar:</strong> Endpoints intuitivos que facilitan la consulta y manipulación de la información.</li>
</ul>

<h2>Requisitos</h2>
<ul>
  <li><strong>Java 17</strong> Asegurate de instalar la versión correcta del <a href="https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html">JDK</a></li>
  <li><strong>MySQL</strong> Esta API utiliza una base de datos MySQL para almacenar y gestionar la información de los Pokémon. Se emplean las librerías del conector MySQL para facilitar la persistencia de las entidades y la carga inicial de datos mediante el archivo `import.sql`.</li>
  <li><strong>JsonApiResponse</strong> La aplicacion maneja el standard JsonApiResponse lo que permite al Client-APP optener una respuesta de los endpoint estandarizada para su consumo.</li>
</ul>

<h2>Funcionamiento de la API</h2>
La API de Pokedex está diseñada para administrar información completa sobre Pokémon, sus evoluciones, tipos, debilidades y sus estadisticas. Utiliza diversas relaciones para conectar estos elementos: 
<h3>Relaciones:</h3>
<ul>
  <li><strong>Uno a Muchos (Pokémon - Evoluciones):</strong> Un Pokémon puede tener múltiples evoluciones, pero cada evolución pertenece a un Pokémon específico.</li>
  <li><strong>Muchos a Muchos (Pokémon - Tipos):</strong> Un Pokémon puede tener múltiples tipos (ej. Agua/Volador), y un tipo puede ser compartido por muchos Pokémon.</li>
  <li><strong>Muchos a Muchos (Pokémon - Debilidades):</strong> Un Pokémon puede tener múltiples debilidades, y una debilidad puede afectar a múltiples Pokémon.</li>
  <li><strong>Muchos a Muchos (Evolución - Tipos):</strong>Una Evolución puede tener múltiples tipos (ej. Agua/Volador), y un tipo puede ser compartido por muchas Evoluciones.</li>
  <li><strong>Muchos a Muchos (Evolución - Debilidades):</strong> Una Evolución puede tener múltiples debilidades, y una debilidad puede afectar a múltiples Evoluciones.</li>
  <li><strong>Uno a uno (Pokémon - Estadisticas):</strong> Un pokémon puede tener una estadistica (ataque, defesa,velocidad,vida), y una estadistica tener solo un Pokémon.</li>
  <li><strong>Uno a uno (Evolución - Estadisticas):</strong> Una evolución puede tener una estadistica (ataque, defesa,velocidad,vida), y una estadistica tener solo un Pokémon.</li>
</ul>
<h3>Comportamiento en cascada:</h3>
 La API implementa un comportamiento en cascada para la eliminación de Pokémon. Esto significa que si se elimina un Pokémon, todas sus evoluciones y estadisticas asociadas también se eliminarán automáticamente.
Esta función garantiza la integridad de los datos, evitando evoluciones y estadisticas huérfanas en la base de datos.

<h3>Diagrama de la base de datos:</h3>

![db_pokedex](https://github.com/user-attachments/assets/e508cdc8-52a3-4625-9d05-ac2ae1bd3c91)

 
 
 
