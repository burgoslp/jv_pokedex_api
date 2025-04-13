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
