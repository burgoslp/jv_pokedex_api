<h1>🐾 API POKEDEX</h1>
Esta es una API REST construida con Java y el framework Spring Boot, diseñada para proporcionar información detallada sobre Pokémons.

<h2>📖 Descripción general</h2>
Esta API Pokedex ofrece una interfaz para acceder a datos completos sobre Pokémon, incluyendo sus estadisticas, tipos, debilidades y evoluciones. 
Creada con Java 17 y Spring Boot, la API destaca por su eficiencia y facilidad de uso. Se utilizan las librerías Lombok y Maven para mejorar la productividad y la gestión del proyecto.

<h2>✨ Características</h2>
<ul>
  <li><strong>Información Detallada:</strong> Accede a datos exhaustivos de cada Pokémon, como tipos, debilidades, estadísticas, evoluciones.</li>
  <li><strong>🔗 Arquitectura REST:</strong> Diseño basado en principios REST para una integración sencilla, respuestas con formatos estadarizados y un rendimiento óptimo.</li>
  <li><strong>🔍 Fácil de Usar:</strong> Endpoints intuitivos que facilitan la consulta y manipulación de la información.</li>
  <li><strong>📄 JsonApiResponse</strong> La aplicacion maneja el standard JsonApiResponse lo que permite al Client-APP optener una respuesta de los endpoint estandarizada para su consumo.</li>
  
</ul>

<h2>🛠️ Requisitos</h2>
<ul>
  <li><strong>Java 17</strong> Asegurate de instalar la versión correcta del <a href="https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html">JDK</a></li>
  <li><strong>📦 MySQL</strong> Esta API utiliza una base de datos MySQL para almacenar y gestionar la información de los Pokémon. Se emplean las librerías del conector MySQL para facilitar la persistencia de las entidades y la carga inicial de datos mediante el archivo `import.sql`.</li>
</ul>

<h2>🔍 Funcionamiento de la API</h2>
La API de Pokedex está diseñada para administrar información completa sobre Pokémon, sus evoluciones, tipos, debilidades y sus estadisticas. Utiliza diversas relaciones para conectar estos elementos: 
<h3>🔗 Relaciones:</h3>
<ul>
  <li><strong>Uno a Muchos (Pokémon - Evoluciones):</strong> Un Pokémon puede tener múltiples evoluciones, pero cada evolución pertenece a un Pokémon específico.</li>
  <li><strong>Muchos a Muchos (Pokémon - Tipos):</strong> Un Pokémon puede tener múltiples tipos (ej. Agua/Volador), y un tipo puede ser compartido por muchos Pokémon.</li>
  <li><strong>Muchos a Muchos (Pokémon - Debilidades):</strong> Un Pokémon puede tener múltiples debilidades, y una debilidad puede afectar a múltiples Pokémon.</li>
  <li><strong>Muchos a Muchos (Evolución - Tipos):</strong>Una Evolución puede tener múltiples tipos (ej. Agua/Volador), y un tipo puede ser compartido por muchas Evoluciones.</li>
  <li><strong>Muchos a Muchos (Evolución - Debilidades):</strong> Una Evolución puede tener múltiples debilidades, y una debilidad puede afectar a múltiples Evoluciones.</li>
  <li><strong>Uno a uno (Pokémon - Estadisticas):</strong> Un pokémon puede tener una estadistica (ataque, defesa,velocidad,vida), y una estadistica tener solo un Pokémon.</li>
  <li><strong>Uno a uno (Evolución - Estadisticas):</strong> Una evolución puede tener una estadistica (ataque, defesa,velocidad,vida), y una estadistica tener solo un Pokémon.</li>
</ul>
<h3>♻️ Comportamiento en cascada:</h3>
 La API implementa un comportamiento en cascada para la eliminación de Pokémon. Esto significa que si se elimina un Pokémon, todas sus evoluciones y estadisticas asociadas también se eliminarán automáticamente.
Esta función garantiza la integridad de los datos, evitando evoluciones y estadisticas huérfanas en la base de datos.

<h2>Diagrama de la base de datos:</h2>

![imagen](https://github.com/user-attachments/assets/cd5d9c05-c418-4f6e-803a-f5b2bc6b86c7)


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
 <span>PUT:</span> <strong>api/pokedex/pokemon/update/{id}</strong>
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
 <span>Validación del pokemon id</span>
 <pre>
   {
    "code": 400,
    "message": "Bad Request",
    "data": "El ID ingresado no pertenece a ningun pokemon existente"
  }
 </pre>
<h3>3. Agregar tipos al pokemon</h3>
<hr>
<span>POST:</span> <strong>api/pokedex/pokemon/add/{id}/type</strong>
<pre>
  [9,6]
</pre>
<span>Respuesta:</span>
<pre>
  {
    "code": 201,
    "message": "Created",
    "data": "Los tipos se han agregado correctamente"
  }
</pre>
<span>Validacion:</span>
<pre>
  {
    "code": 400,
    "message": "Bad Request",
    "data": "La lista de valores se encuentran vacios o no existen"
}
</pre>
<span>Validación del pokemon id</span>
 <pre>
   {
    "code": 400,
    "message": "Bad Request",
    "data": "El ID ingresado no pertenece a ningun pokemon existente"
  }
 </pre>
<span>Pokemon con tipos agregados:</span>
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
        "evolutions": [],
        "types": [
            {
                "id": 9,
                "name": "Hielo",
                "description": "Tipo de Pokemon que es fuerte contra Dragon, Planta, Tierra y Volador, y debil contra Acero, Agua, Fuego e Hielo."
            },
            {
                "id": 6,
                "name": "Fantasma",
                "description": "Tipo de Pokemon que es fuerte contra Fantasma y PsÃ­quico, y debil contra Normal y Siniestro."
            }
        ],
        "weaknesses": [],
        "statistic": null
    }
}
</pre>
 <h3>4. Agregar debilidades al pokemon:</h3>
 <hr>
 <span>GET:</span> <strong>api/pokedex/pokemon/add/{id}/weakness</strong>
 <pre>
   [1,4]
 </pre>
 <span>Respuesta:</span>
 <pre>
   {
      "code": 201,
      "message": "Created",
      "data": "Las debilidades se han agregado correctamente"
  }
 </pre>
 <span>Validacion:</span>
<pre>
  {
    "code": 400,
    "message": "Bad Request",
    "data": "La lista de valores se encuentran vacios o no existen"
}
</pre>
<span>Validación del pokemon id</span>
 <pre>
   {
    "code": 400,
    "message": "Bad Request",
    "data": "El ID ingresado no pertenece a ningun pokemon existente"
  }
 </pre>
 <span>
   Pokemon con debilidades agregadas:
 </span>
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
          "evolutions": [],
          "types": [
              {
                  "id": 9,
                  "name": "Hielo",
                  "description": "Tipo de Pokemon que es fuerte contra Dragon, Planta, Tierra y Volador, y debil contra Acero, Agua, Fuego e Hielo."
              },
              {
                  "id": 6,
                  "name": "Fantasma",
                  "description": "Tipo de Pokemon que es fuerte contra Fantasma y PsÃ­quico, y debil contra Normal y Siniestro."
              }            
          ],
          "weaknesses": [
              {
                  "id": 1,
                  "name": "Acero",
                  "description": "Tipo de Pokemon que es fuerte contra Hielo, Roca y Hada, y debil contra Fuego, Lucha y Tierra."
              },
              {
                  "id": 4,
                  "name": "Electrico",
                  "description": "Tipo de Pokemon que es fuerte contra Agua y Volador, y debil contra Dragon, Electrico y Planta."
              }
          ],
          "statistic": null
      }
  }
 </pre>
 <h3>5. Agregar Estadisticas al Pokemon</h3>
 <hr>
 <span>POST: <strong>api/pokedex/statistic/create/pokemon</strong></span>
 <pre>
   {
    "attack":20,
    "defence":60,
    "velocity":80,
    "life":50,
    "pokemonId":6
  }
 </pre>
<span>Respuesta:</span>
 <pre>
   {
       "code": 201,
       "message": "Created",
       "data": "Se han creado las estadisticas del pokemon"
    }
 </pre>
 <span>validación:</span>
 <pre>
   {
      "code": 400,
      "message": "Bad Request",
      "data": [
          "defence: no debe ser nulo",
          "velocity: no debe ser nulo",
          "attack: no debe ser nulo",
          "pokemonId: no debe ser nulo",
          "life: no debe ser nulo"
      ]
  }
 </pre>
 <span>Validación del pokemon id:</span>
 <pre>
   {
      "code": 400,
      "message": "Bad Request",
      "data": "El ID ingresado no pertenece a ningun pokemon existente"
  }
 </pre>
 <h3>6. Listar todos los pokemons</h3>
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

<h3>7. Listar pokemon por id:</h3>
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
<h3>8. Listar pokemon por nombre o codigo:</h3>
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

<h3>9. Listar pokemons por mayor peso:</h3>
<hr>
<span>GET:</span> <strong>api/pokedex/pokemon/weight/desc</strong><br>
<h3>10. Listar pokemons por menor peso:</h3>
<hr>
<span>GET:</span> <strong>api/pokedex/pokemon/weight/asc</strong><br>
<h3>11. Listar pokemons por mayor altura:</h3>
<hr>
<span>GET:</span> <strong>api/pokedex/pokemon/height/desc</strong><br>
<h3>12. Listar pokemons por menor altura:</h3>
<hr>
<span>GET:</span> <strong>api/pokedex/pokemon/height/asc</strong><br>
<h3>13. Crear Evolución:</h3>
<hr>
<span>POST:</span> <strong>api/pokedex/evolution/create</strong><br>
<pre>
  {
     "name": "lucario",
     "description":"descripción aquí",
     "weight": 80,
     "height": 2.5,
     "image": "lucario.png",
     "code": "#1111",
     "pokemonId":1
  }
</pre>
<span>Validaciones: </span>
<pre>
  {
        "code": 400,
        "message": "Bad Request",
        "data": [
            "name: no debe estar vacío",
            "pokemonId: no debe ser nulo",
            "weight: no debe ser nulo",
            "image: no debe estar vacío",
            "code: no debe ser nulo",
            "height: no debe ser nulo",
            "description: no debe estar vacío"
        ]
}
</pre>
<span>Validación pokemon id: </span>
<pre>
  {
      "code": 400,
      "message": "Bad Request",
      "data": "El ID ingresado no pertenece a ningun pokemon existente"
  }
</pre>
<span>Respuesta: </span>
<pre>
  {
        "code": 201,
        "message": "Created",
        "data": {
            "id": 14,
            "name": "lucario",
            "description": "descripción aquí",
            "height": 2.5,
            "weight": 80.0,
            "code": "#8888",
            "image": "lucario.png",
        }
  }
</pre>
<h3>14. Actualizar Evolución:</h3>
<hr>
<span>PUT:</span> <strong>api/pokedex/evolution/update/{id}</strong><br>
<pre>
  {
      "name": "lucario",
      "code": "#0056",
      "description": "description",
      "weight": 85,
      "image": "lucario.png",
      "height": 70  
  }
</pre>
<span>Validaciones: </span>
<pre>
  {
      "code": 400,
      "message": "Bad Request",
      "data": [
          "image: no debe estar vacío",
          "height: no debe ser nulo",
          "code: no debe ser nulo",
          "description: no debe estar vacío",
          "name: no debe estar vacío",
          "weight: no debe ser nulo"
      ]
  }
</pre>
<span>Validación evolución id:</span>
<pre>
  {
      "code": 400,
      "message": "Bad Request",
      "data": "El ID ingresado no pertenece a ninguna evolución existente"
  }
</pre>
<h3>15. Agregar tipos a la evolución</h3>
<hr>
<span>POST:</span> <strong>api/pokedex/evolution/add/{id}/type</strong>
<pre>
  [9,6]
</pre>
<span>Respuesta:</span>
<pre>
  {
    "code": 201,
    "message": "Created",
    "data": "Los tipos se han agregado correctamente"
  }
</pre>
<span>Validacion:</span>
<pre>
  {
    "code": 400,
    "message": "Bad Request",
    "data": "La lista de valores se encuentran vacios o no existen"
}
</pre>
<span>Validación del evolución id</span>
 <pre>
   {
    "code": 400,
    "message": "Bad Request",
    "data": "El ID ingresado no pertenece a ninguna evolución existente"
  }
 </pre>
<span>Evolución con tipos agregados:</span>
<pre>
  {
    "code": 200,
    "message": "OK",
    "data": {
        "id": 8,
        "name": "lucario",
        "description": "descripción aquí",
        "height": 2.5,
        "weight": 80.0,
        "code": "#1111",
        "image": "lucario.png",
        "pokemon": [],
        "types": [
            {
                "id": 9,
                "name": "Hielo",
                "description": "Tipo de Pokemon que es fuerte contra Dragon, Planta, Tierra y Volador, y debil contra Acero, Agua, Fuego e Hielo."
            },
            {
                "id": 6,
                "name": "Fantasma",
                "description": "Tipo de Pokemon que es fuerte contra Fantasma y PsÃ­quico, y debil contra Normal y Siniestro."
            }
        ],
        "weaknesses": [],
        "statistic": null
    }
}
</pre>
 <h3>16. Agregar debilidades a la evolución:</h3>
 <hr>
 <span>GET:</span> <strong>api/pokedex/evolution/add/{id}/weakness</strong>
 <pre>
   [1,4]
 </pre>
 <span>Respuesta:</span>
 <pre>
   {
      "code": 201,
      "message": "Created",
      "data": "Las debilidades se han agregado correctamente"
  }
 </pre>
 <span>Validacion:</span>
<pre>
  {
    "code": 400,
    "message": "Bad Request",
    "data": "La lista de valores se encuentran vacios o no existen"
}
</pre>
<span>Validación del evolución id</span>
 <pre>
   {
    "code": 400,
    "message": "Bad Request",
    "data": "El ID ingresado no pertenece a ninguna evolución existente"
  }
 </pre>
 <span>
   evolución con debilidades agregadas:
 </span>
 <pre>
   {
      "code": 200,
      "message": "OK",
      "data": {
          "id": 8,
          "name": "lucario",
          "description": "descripción aquí",
          "height": 2.5,
          "weight": 80.0,
          "code": "#1111",
          "image": "lucario.png",
          "evolutions": [],
          "types": [
              {
                  "id": 9,
                  "name": "Hielo",
                  "description": "Tipo de Pokemon que es fuerte contra Dragon, Planta, Tierra y Volador, y debil contra Acero, Agua, Fuego e Hielo."
              },
              {
                  "id": 6,
                  "name": "Fantasma",
                  "description": "Tipo de Pokemon que es fuerte contra Fantasma y PsÃ­quico, y debil contra Normal y Siniestro."
              }            
          ],
          "weaknesses": [
              {
                  "id": 1,
                  "name": "Acero",
                  "description": "Tipo de Pokemon que es fuerte contra Hielo, Roca y Hada, y debil contra Fuego, Lucha y Tierra."
              },
              {
                  "id": 4,
                  "name": "Electrico",
                  "description": "Tipo de Pokemon que es fuerte contra Agua y Volador, y debil contra Dragon, Electrico y Planta."
              }
          ],
          "statistic": null
      }
  }
 </pre>
 <h3>17. Agregar Estadisticas a la evolución</h3>
 <hr>
 <span>POST: <strong>api/pokedex/statistic/create/evolution</strong></span>
 <pre>
   {
    "attack":20,
    "defence":60,
    "velocity":80,
    "life":50,
    "evolutionId":8
  }
 </pre>
<span>Respuesta:</span>
 <pre>
   {
       "code": 201,
       "message": "Created",
       "data": "Se han creado las estadisticas de la evolución"
    }
 </pre>
 <span>validación:</span>
 <pre>
   {
      "code": 400,
      "message": "Bad Request",
      "data": [
          "defence: no debe ser nulo",
          "velocity: no debe ser nulo",
          "attack: no debe ser nulo",
          "evolutionId: no debe ser nulo",
          "life: no debe ser nulo"
      ]
  }
 </pre>
 <span>Validación del evolución id:</span>
 <pre>
   {
      "code": 400,
      "message": "Bad Request",
      "data": "El ID ingresado no pertenece a ninguna evolución existente"
  }
 </pre>
<h3>18. Listar todas las evoluciones</h3>
<hr>
<span>GET:</span> <strong>api/pokedex/evolution</strong>
<pre>
  {
    "code": 200,
    "message": "OK",
    "data": [
        {
            "id": 1,
            "name": "pikachu",
            "description": "Pikachu es un pequeÃ±o PokÃ©mon cuya morfologÃ­a se encuentra basada en un roedor. Aunque su nombre y su categorÃ­a hagan alusiÃ³n a un ratÃ³n, segÃºn su diseÃ±adora, sus mejillas estÃ¡n basadas en las de una ardilla. Su cuerpo es de color amarillo con dos rayas marrones en su espalda y en la base de la cola. La punta de sus orejas de color negro, y presenta un gran cÃ­rculo rojo en cada una de sus mejillas. Tiene una cola con forma de rayo si es macho y en forma de corazÃ³n si es hembra.",
            "height": 1.04,
            "weight": 13.2,
            "code": "#0025",
            "image": "pikachu.png"            
        }, ........................
</pre>
<h3>18. Listar evolución por id</h3>
<hr>
<span>GET:</span> <strong>api/pokedex/evolution/{id}</strong>
<pre>
  {
    "code": 200,
    "message": "OK",
    "data": {
        "id": 1,
        "name": "pikachu",
        "description": "Pikachu es un pequeÃ±o PokÃ©mon cuya morfologÃ­a se encuentra basada en un roedor. Aunque su nombre y su categorÃ­a hagan alusiÃ³n a un ratÃ³n, segÃºn su diseÃ±adora, sus mejillas estÃ¡n basadas en las de una ardilla. Su cuerpo es de color amarillo con dos rayas marrones en su espalda y en la base de la cola. La punta de sus orejas de color negro, y presenta un gran cÃ­rculo rojo en cada una de sus mejillas. Tiene una cola con forma de rayo si es macho y en forma de corazÃ³n si es hembra.",
        "height": 1.04,
        "weight": 13.2,
        "code": "#0025",
        "image": "pikachu.png",
        "pokemon": {
            "id": 1,
            "name": "pichu",
            "description": "Pichu estÃ¡ basado en un roedor. Pichu tiene una piel de color amarillo pÃ¡lido, con las mejillas rosadas, una cola corta negra y orejas grandes, con bordeados de color negro. Su pequeÃ±o tamaÃ±o puede despistar a cualquier entrenador novato, pero puede paralizar incluso a humanos adultos si no se tiene cuidado.",
            "height": 1.0,
            "weight": 4.4,
            "code": "#0172",
            "image": "pichu.png",
            "evolutions": null,
            "types": null,
            "weaknesses": null,
            "statistic": null
        },
        "types": [
            {
                "id": 5,
                "name": "Electrico",
                "description": "Tipo de Pokemon que es fuerte contra Agua y Volador, y debil contra Dragon, Electrico y Planta."
            }
        ],
        "weaknesses": [],
        "statistic": {
            "id": 2,
            "attack": 55,
            "defence": 40,
            "velocity": 90,
            "life": 35
        }
    }
}
</pre>
<h3>19. Listar evolución por nombre o codigo</h3>
<hr>
<span>GET:</span> <strong>api/pokedex/evolution/nameorcode/{nameorcode}</strong>
PD: esta es una busqueda de tipo like %""% que busca por el nombre o por el codigo (campo unico) puede arrojar un unico registro o varios
<pre>
  {
    "code": 200,
    "message": "OK",
    "data": [
        {
            "id": 10,
            "name": "butterfree",
            "description": "Butterfree es la forma final de Caterpie. Es un hermoso PokÃ©mon de tipo bicho y volador con grandes alas que le permiten volar y libar nÃ©ctar de las flores. Butterfree es considerado un PokÃ©mon muy elegante y es conocido por sus habilidades en batalla.",
            "height": 3.07,
            "weight": 70.5,
            "code": "#0012",
            "image": "butterfree.png"            
        }
    ]
}
</pre>
<h3>20. Listar evoluciones por mayor peso:</h3>
<hr>
<span>GET:</span> <strong>api/pokedex/evolution/weight/desc</strong><br>
<h3>21. Listar evoluciones por menor peso:</h3>
<hr>
<span>GET:</span> <strong>api/pokedex/evolution/weight/asc</strong><br>
<h3>22. Listar evoluciones por mayor altura:</h3>
<hr>
<span>GET:</span> <strong>api/pokedex/evolution/height/desc</strong><br>
<h3>23. Listar evoluciones por menor altura:</h3>
<hr>
<span>GET:</span> <strong>api/pokedex/evolution/height/asc</strong><br>
<h3>24. Listar todos los tipos</h3>
<hr>
<span>GET:</span> <strong>api/pokedex/type</strong><br>
<pre>
  {
    "code": 200,
    "message": "OK",
    "data": [
        {
            "id": 1,
            "name": "Acero",
            "description": "Tipo de Pokemon que es fuerte contra Hielo, Roca y Hada, y debil contra Fuego, Lucha y Tierra."
        },
        {
            "id": 2,
            "name": "Agua",
            "description": "Tipo de Pokemon que es fuerte contra Fuego, Roca y Tierra, y debil contra Agua, Dragon y Planta."
        },..............................
</pre>
<h3>25. Listar tipos por su id</h3>
<hr>
<span>GET:</span> <strong>api/pokedex/type</strong><br>
<pre>
  {
    "code": 200,
    "message": "OK",
    "data": {
        "id": 1,
        "name": "Acero",
        "description": "Tipo de Pokemon que es fuerte contra Hielo, Roca y Hada, y debil contra Fuego, Lucha y Tierra."
    }
  }
</pre>
<span>Validación del id del tipo:</span>
<pre>
{
    "code": 400,
    "message": "Bad Request",
    "data": "El ID ingresado no pertenece a ningun tipo"
}
</pre>
