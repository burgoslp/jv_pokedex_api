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

<h2>Diagrama de la base de datos:</h2>

![db_pokedex](https://github.com/user-attachments/assets/e508cdc8-52a3-4625-9d05-ac2ae1bd3c91)

<h2>Listado de endpoints:</h2>
la api cuenta con multiples rutas que nos permite la creación, eliminación, actualización y lectura de los pokemons y sus evoluciones, ademas cuenta con rutas aparte para agregar tipos, debilidades y estadisticas.

<h3>1. Creación del pokemon</h3>
<hr>
<span>POST:</span> <strong>api/pokedex/pokemon/create</strong>
 <pre>
   {
      "name": "pikachu",
      "description":"descripción aquí",
      "weight": 80,
      "height": 2.5,
      "image": "pikachu.png",
      "code": "#1111"
    }
 </pre>
 <span>Respuesta:</span>
 <pre>
   {
        "code": 200,
        "message": "OK",
        "data": {
            "id": 6,
            "name": "lucario",
            "description": "descripción aquí",
            "height": 2.5,
            "weight": 80.0,
            "code": "#1111",
            "image": "lucario.png",
            "evolutions": null,
            "types": null,
            "weaknesses": null,
            "statistic": null
        }
    }
 </pre>
 <span>Validaciones:</span>
 <pre>
   {
      "code": 400,
      "message": "Bad Request",
      "data": [
          "name: no debe estar vacío",
          "weight: no debe ser nulo",
          "image: no debe estar vacío",
          "height: no debe ser nulo",
          "code: no debe ser nulo",
          "description: no debe estar vacío"
      ]
  }
 </pre>
<h3>2. Actualizar pokemon</h3>
 <hr>
 <span>GET:</span> <strong>api/pokedex/pokemon/update/{id}</strong>
<pre>
  {
    "name": "lucario",
    "description":"descripción aquí",
    "weight": 80,
    "height": 2.5,
    "image": "lucario.png",
    "code": "#1111"
  }
</pre>
 <span>Validaciones:</span>
 <pre>
   {
    "code": 400,
    "message": "Bad Request",
    "data": [
        "image: no debe estar vacío",
        "height: no debe ser nulo",
        "weight: no debe ser nulo",
        "name: no debe estar vacío",
        "code: no debe ser nulo",
        "description: no debe estar vacío"
    ]
}
 </pre>

 <h3>3. Listar todos los pokemons</h3>
 <hr>
 <span>GET:</span> <strong>api/pokedex/pokemon</strong>
<pre>
  {
    "code": 200,
    "message": "OK",
    "data": [
                {
                    "id": 1,
                    "name": "pichu",
                    "description": "Pichu estÃ¡ basado en un roedor. Pichu tiene una piel de color amarillo pÃ¡lido, con las mejillas rosadas, una cola corta negra y orejas grandes, con bordeados de color negro. Su pequeÃ±o tamaÃ±o puede despistar a cualquier entrenador novato, pero puede paralizar incluso a humanos adultos si no se tiene cuidado.",
                    "height": 1.0,
                    "weight": 4.4,
                    "code": "#0172",
                    "image": "pichu.png",
                    "evolutions": [
                        {
                            "id": 1,
                            "name": "pikachu",
                            "description": "Pikachu es un pequeÃ±o PokÃ©mon cuya morfologÃ­a se encuentra basada en un roedor. Aunque su nombre y su categorÃ­a hagan alusiÃ³n a un ratÃ³n, segÃºn su diseÃ±adora, sus mejillas estÃ¡n basadas en las de una ardilla. Su cuerpo es de color amarillo con dos rayas marrones en su espalda y en la base de la cola. La punta de sus orejas de color negro, y presenta un gran cÃ­rculo rojo en cada una de sus mejillas. Tiene una cola con forma de rayo si es macho y en forma de corazÃ³n si es hembra.",
                            "height": 1.04,
                            "weight": 13.2,
                            "code": "#0025",
                            "image": "pikachu.png"
                        } ................................................
          ]
  }
</pre>

<h3>4. Listar pokemon por id:</h3>
<hr>
<span>GET:</span> <strong>api/pokedex/pokemon/{id}</strong>
<pre>
  {
    "code": 200,
    "message": "OK",
    "data": {
        "id": 1,
        "name": "pichu",
        "description": "Pichu estÃ¡ basado en un roedor. Pichu tiene una piel de color amarillo pÃ¡lido, con las mejillas rosadas, una cola corta negra y orejas grandes, con bordeados de color negro. Su pequeÃ±o tamaÃ±o puede despistar a cualquier entrenador novato, pero puede paralizar incluso a humanos adultos si no se tiene cuidado.",
        "height": 1.0,
        "weight": 4.4,
        "code": "#0172",
        "image": "pichu.png",
        "evolutions": [
            {
                "id": 1,
                "name": "pikachu",
                "description": "Pikachu es un pequeÃ±o PokÃ©mon cuya morfologÃ­a se encuentra basada en un roedor. Aunque su nombre y su categorÃ­a hagan alusiÃ³n a un ratÃ³n, segÃºn su diseÃ±adora, sus mejillas estÃ¡n basadas en las de una ardilla. Su cuerpo es de color amarillo con dos rayas marrones en su espalda y en la base de la cola. La punta de sus orejas de color negro, y presenta un gran cÃ­rculo rojo en cada una de sus mejillas. Tiene una cola con forma de rayo si es macho y en forma de corazÃ³n si es hembra.",
                "height": 1.04,
                "weight": 13.2,
                "code": "#0025",
                "image": "pikachu.png"
            }.......................................................
      ]
    }
}
</pre>
<span>Excepción: En caso de no existir el pokemon solicitado se mostrará un mensaje 400.</span>
<pre>
    {
      "code": 400,
      "message": "Bad Request",
      "data": "El ID ingresado no pertenece a ningun pokemon existente"
    }
</pre>
<h3>5. Listar pokemon por nombre o codigo:</h3>
<hr>
<span>GET:</span> <strong>api/pokedex/pokemon/{nameorcode}</strong><br>
PD: esta es una busqueda de tipo like %""% que busca por el nombre o por el codigo (campo unico) puede arrojar un unico registro o varios
<pre>
  {
    "code": 200,
    "message": "OK",
    "data": {
        "id": 1,
        "name": "pichu",
        "description": "Pichu estÃ¡ basado en un roedor. Pichu tiene una piel de color amarillo pÃ¡lido, con las mejillas rosadas, una cola corta negra y orejas grandes, con bordeados de color negro. Su pequeÃ±o tamaÃ±o puede despistar a cualquier entrenador novato, pero puede paralizar incluso a humanos adultos si no se tiene cuidado.",
        "height": 1.0,
        "weight": 4.4,
        "code": "#0172",
        "image": "pichu.png",
        "evolutions": [
            {
                "id": 1,
                "name": "pikachu",
                "description": "Pikachu es un pequeÃ±o PokÃ©mon cuya morfologÃ­a se encuentra basada en un roedor. Aunque su nombre y su categorÃ­a hagan alusiÃ³n a un ratÃ³n, segÃºn su diseÃ±adora, sus mejillas estÃ¡n basadas en las de una ardilla. Su cuerpo es de color amarillo con dos rayas marrones en su espalda y en la base de la cola. La punta de sus orejas de color negro, y presenta un gran cÃ­rculo rojo en cada una de sus mejillas. Tiene una cola con forma de rayo si es macho y en forma de corazÃ³n si es hembra.",
                "height": 1.04,
                "weight": 13.2,
                "code": "#0025",
                "image": "pikachu.png"
            }.......................................................
      ]
    }
}
</pre>

 <span>Excepción: En caso de no existir un pokemon con el valor ingresado:</span>
<pre>
    {
      "code": 400,
      "message": "Bad Request",
      "data": "El valor ingresado no pertenece a algun pokemon"
    }
</pre>

<h3>6. Listar pokemons por mayor peso:</h3>
<hr>
<span>GET:</span> <strong>api/pokedex/pokemon/weight/desc</strong><br>
<h3>7. Listar pokemons por menor peso:</h3>
<hr>
<span>GET:</span> <strong>api/pokedex/pokemon/weight/asc</strong><br>
<h3>8. Listar pokemons por mayor altura:</h3>
<hr>
<span>GET:</span> <strong>api/pokedex/pokemon/height/desc</strong><br>
<h3>9. Listar pokemons por menor altura:</h3>
<hr>
<span>GET:</span> <strong>api/pokedex/pokemon/height/asc</strong><br>
