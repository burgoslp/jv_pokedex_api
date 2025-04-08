/*tipos de pokemon*/
INSERT INTO `types` (`id`,`name`,`description`) VALUES (NULL, 'Acero', 'Tipo de Pokémon que es fuerte contra Hielo, Roca y Hada, y débil contra Fuego, Lucha y Tierra.');
INSERT INTO `types` (`id`,`name`,`description`) VALUES (NULL, 'Agua', 'Tipo de Pokémon que es fuerte contra Fuego, Roca y Tierra, y débil contra Agua, Dragón y Planta.');
INSERT INTO `types` (`id`,`name`,`description`) VALUES (NULL, 'Bicho', 'Tipo de Pokémon que es fuerte contra Planta, Psíquico y Siniestro, y débil contra Acero, Fantasma, Fuego, Hada, Lucha y Volador.');
INSERT INTO `types` (`id`,`name`,`description`) VALUES (NULL, 'Dragón', 'Tipo de Pokémon que es fuerte contra Dragón, y débil contra Acero y Hada.');
INSERT INTO `types` (`id`,`name`,`description`) VALUES (NULL, 'Eléctrico', 'Tipo de Pokémon que es fuerte contra Agua y Volador, y débil contra Dragón, Eléctrico y Planta.');
INSERT INTO `types` (`id`,`name`,`description`) VALUES (NULL, 'Fantasma', 'Tipo de Pokémon que es fuerte contra Fantasma y Psíquico, y débil contra Normal y Siniestro.');
INSERT INTO `types` (`id`,`name`,`description`) VALUES (NULL, 'Fuego', 'Tipo de Pokémon que es fuerte contra Acero, Bicho, Hielo y Planta, y débil contra Agua, Dragón, Fuego y Roca.');
INSERT INTO `types` (`id`,`name`,`description`) VALUES (NULL, 'Hada', 'Tipo de Pokémon que es fuerte contra Dragón, Lucha y Siniestro, y débil contra Acero, Fuego y Veneno.');
INSERT INTO `types` (`id`,`name`,`description`) VALUES (NULL, 'Hielo', 'Tipo de Pokémon que es fuerte contra Dragón, Planta, Tierra y Volador, y débil contra Acero, Agua, Fuego e Hielo.');
INSERT INTO `types` (`id`,`name`,`description`) VALUES (NULL, 'Lucha', 'Tipo de Pokémon que es fuerte contra Normal, y débil contra Bicho, Fantasma, Hada, Psíquico y Volador.');
INSERT INTO `types` (`id`,`name`,`description`) VALUES (NULL, 'Normal', 'Tipo de Pokémon que no tiene ventajas ni desventajas específicas contra otros tipos.');
INSERT INTO `types` (`id`,`name`,`description`) VALUES (NULL, 'Planta', 'Tipo de Pokémon que es fuerte contra Agua, Roca y Tierra, y débil contra Acero, Bicho, Dragón, Fuego, Planta, Veneno y Volador.');
INSERT INTO `types` (`id`,`name`,`description`) VALUES (NULL, 'Psíquico', 'Tipo de Pokémon que es fuerte contra Lucha y Veneno, y débil contra Acero, Psíquico y Siniestro.');
INSERT INTO `types` (`id`,`name`,`description`) VALUES (NULL, 'Roca', 'Tipo de Pokémon que es fuerte contra Bicho, Fuego, Hielo y Volador, y débil contra Acero, Lucha y Tierra.');
INSERT INTO `types` (`id`,`name`,`description`) VALUES (NULL, 'Siniestro', 'Tipo de Pokémon que es fuerte contra Fantasma y Psíquico, y débil contra Hada, Lucha y Siniestro.');
INSERT INTO `types` (`id`,`name`,`description`) VALUES (NULL, 'Tierra', 'Tipo de Pokémon que es fuerte contra Acero, Eléctrico, Fuego, Roca y Veneno, y débil contra Bicho, Planta y Volador.');
INSERT INTO `types` (`id`,`name`,`description`) VALUES (NULL, 'Veneno', 'Tipo de Pokémon que es fuerte contra Hada y Planta, y débil contra Acero, Fantasma, Roca, Tierra y Veneno.');
INSERT INTO `types` (`id`,`name`,`description`) VALUES (NULL, 'Volador', 'Tipo de Pokémon que es fuerte contra Bicho, Lucha y Planta, y débil contra Acero, Eléctrico y Roca.');


/*pokemon 1*/
INSERT INTO `pokemons` (`id`,`name`,`description`,`height`, `weight`,`code`, `image`) VALUES (NULL, 'pichu','Pichu está basado en un roedor. Pichu tiene una piel de color amarillo pálido, con las mejillas rosadas, una cola corta negra y orejas grandes, con bordeados de color negro. Su pequeño tamaño puede despistar a cualquier entrenador novato, pero puede paralizar incluso a humanos adultos si no se tiene cuidado.','1.00', '4.4', '#0172','pichu.png')
INSERT INTO `pokemons_types` (`pokemons_id`, `types_id`) VALUES (1, (SELECT id FROM types WHERE name = 'Eléctrico'));

INSERT INTO `evolutions` (`id`, `pokemon_id`, `name`,`description`,`height`, `weight`, `code` ,`image`) VALUES (NULL, 1, 'pikachu','Pikachu es un pequeño Pokémon cuya morfología se encuentra basada en un roedor. Aunque su nombre y su categoría hagan alusión a un ratón, según su diseñadora, sus mejillas están basadas en las de una ardilla. Su cuerpo es de color amarillo con dos rayas marrones en su espalda y en la base de la cola. La punta de sus orejas de color negro, y presenta un gran círculo rojo en cada una de sus mejillas. Tiene una cola con forma de rayo si es macho y en forma de corazón si es hembra.', '1.04', '13.2','#0025','pikachu.png')
INSERT INTO `evolutions_types` (`evolutions_id`, `types_id`) VALUES (1, (SELECT id FROM types WHERE name = 'Eléctrico'));

INSERT INTO `evolutions` (`id`, `pokemon_id`, `name`,`description`,`height`, `weight`, `code` ,`image`) VALUES (NULL, 1, 'raichu','Este Pokémon es un gran roedor bípedo. Tiene un pelaje anaranjado, una cola oscura y gruesa como un cable de tendido eléctrico que termina en forma de rayo y totalmente plano, que además puede soportar grandes cargas.','2.07', '66.1', '#0026', 'raichu.png')
INSERT INTO `evolutions_types` (`evolutions_id`, `types_id`) VALUES (2, (SELECT id FROM types WHERE name = 'Eléctrico'));
/*pokemon 2*/
INSERT INTO `pokemons` (`id`,`name`,`description`,`height`, `weight`,`code`, `image`) VALUES (NULL, 'bulbasaur', 'Bulbasaur es un Pokémon de tipo planta y veneno. Es conocido por tener una planta en su espalda que crecerá a medida que evoluciona. Tiene un cuerpo de color verde y unas manchas más oscuras en su piel. Es pequeño pero muy fuerte y ágil, y a menudo es considerado un excelente compañero por los entrenadores.', '2.04', '15.2','#0001','bulbasaur.png');
INSERT INTO `pokemons_types` (`pokemons_id`, `types_id`) VALUES (2, (SELECT id FROM types WHERE name = 'Planta'));
INSERT INTO `pokemons_types` (`pokemons_id`, `types_id`) VALUES (2, (SELECT id FROM types WHERE name = 'Veneno'));

INSERT INTO `evolutions` (`id`, `pokemon_id`, `name`,`description`,`height`, `weight`, `code` ,`image`) VALUES (NULL, 2, 'ivysaur', 'Ivysaur es la evolución de Bulbasaur y es de tipo planta y veneno. Tiene una planta más grande que bulbasaur en su espalda, y su cuerpo se ha vuelto un poco más robusto. Ivysaur es conocido por tener un temperamento más fuerte y un poder más notable en batalla.', '3.03', '28.7', '#0002', 'ivysaur.png');
INSERT INTO `evolutions_types` (`evolutions_id`, `types_id`) VALUES (3, (SELECT id FROM types WHERE name = 'Planta'));
INSERT INTO `evolutions_types` (`evolutions_id`, `types_id`) VALUES (3, (SELECT id FROM types WHERE name = 'Veneno'));

INSERT INTO `evolutions` (`id`, `pokemon_id`, `name`,`description`,`height`, `weight`, `code` ,`image`) VALUES (NULL, 2, 'venusaur', 'Venusaur es la forma final de Bulbasaur. Se ha convertido en un Pokémon considerablemente más grande, con una enorme planta en su espalda que ha florecido en una hermosa flor. Venusaur es poderoso y capaz de controlar el entorno a su alrededor a través de sus habilidades de tipo planta.', '6.07', '220.5', '#0003', 'venusaur.png');
INSERT INTO `evolutions_types` (`evolutions_id`, `types_id`) VALUES (4, (SELECT id FROM types WHERE name = 'Planta'));
INSERT INTO `evolutions_types` (`evolutions_id`, `types_id`) VALUES (4, (SELECT id FROM types WHERE name = 'Veneno'));

/*pokemon 3*/
INSERT INTO `pokemons` (`id`,`name`,`description`,`height`, `weight`,`code`, `image`) VALUES (NULL, 'charmander', 'Charmander es un Pokémon de tipo fuego. Su cuerpo es de color naranja y tiene una llama en la punta de su cola que muestra su estado emocional y salud. Charmander es un Pokémon popular y adora la luz y el calor, lo que le permite crecer en uno de los Pokémon más poderosos si evoluciona correctamente.', '2.00', '18.7','#0004','charmander.png');
INSERT INTO `pokemons_types` (`pokemons_id`, `types_id`) VALUES (3, (SELECT id FROM types WHERE name = 'Fuego'));

INSERT INTO `evolutions` (`id`, `pokemon_id`, `name`,`description`,`height`, `weight`, `code` ,`image`) VALUES (NULL, 3, 'charmeleon', 'Charmeleon es la evolución de Charmander. Se distingue por su temperamento más feroz y su capacidad para controlar mejor el fuego, lo que le hace un adversario formidable en batalla. Su cola sigue ardiendo intensamente, y se vuelve más poderoso al crecer.', '3.07', '41.9', '#0005', 'charmeleon.png');
INSERT INTO `evolutions_types` (`evolutions_id`, `types_id`) VALUES (5, (SELECT id FROM types WHERE name = 'Fuego'));

INSERT INTO `evolutions` (`id`, `pokemon_id`, `name`,`description`,`height`, `weight`, `code` ,`image`) VALUES (NULL, 3, 'charizard', 'Charizard es la evolución final de Charmander. Es un Pokémon de tipo fuego y volador, con la capacidad de volar a altas altitudes. Su cuerpo ha crecido significativamente y sus alas son fuertes y poderosas, lo que le permite lanzar potentes ataques de fuego.', '5.07', '199.5', '#0006', 'charizard.png');
INSERT INTO `evolutions_types` (`evolutions_id`, `types_id`) VALUES (6, (SELECT id FROM types WHERE name = 'Fuego'));
INSERT INTO `evolutions_types` (`evolutions_id`, `types_id`) VALUES (6, (SELECT id FROM types WHERE name = 'Volador'));

/*pokemon 4*/
INSERT INTO `pokemons` (`id`,`name`,`description`,`height`, `weight`,`code`, `image`) VALUES (NULL, 'squirtle', 'Squirtle es un Pokémon de tipo agua que se asemeja a una pequeña tortuga. Es conocido por su caparazón duro y su adorable apariencia. Squirtle es ingenioso y muy hábil en el uso del agua, siendo un compañero confiable para los entrenadores.', '1.08', '19.8','#0007','squirtle.png');
INSERT INTO `pokemons_types` (`pokemons_id`, `types_id`) VALUES (4, (SELECT id FROM types WHERE name = 'Agua'));

INSERT INTO `evolutions` (`id`, `pokemon_id`, `name`,`description`,`height`, `weight`, `code` ,`image`) VALUES (NULL, 4, 'wartortle', 'Wartortle es la evolución de Squirtle y presenta orejas más largas y un pelaje más esponjoso. Es conocido por su gran agilidad y sus habilidades en batalla, además de su capacidad para manipular el agua con gran eficacia.', '3.03', '49.6', '#0008', 'wartortle.png');
INSERT INTO `evolutions_types` (`evolutions_id`, `types_id`) VALUES (7, (SELECT id FROM types WHERE name = 'Agua'));

INSERT INTO `evolutions` (`id`, `pokemon_id`, `name`,`description`,`height`, `weight`, `code` ,`image`) VALUES (NULL, 4, 'blastoise', 'Blastoise es la forma final de Squirtle. Este Pokémon es imponente, con un caparazón resistente y dos cañones de agua en su espalda. Blastoise puede lanzar poderosos chorros de agua, lo que lo convierte en un formidable Pokémon en combate.', '5.03', '188.5', '#0009', 'blastoise.png');
INSERT INTO `evolutions_types` (`evolutions_id`, `types_id`) VALUES (8, (SELECT id FROM types WHERE name = 'Agua'));

/*pokemon 5*/
INSERT INTO `pokemons` (`id`,`name`,`description`,`height`, `weight`,`code`, `image`) VALUES (NULL, 'caterpie', 'Caterpie es un Pokémon de tipo bicho que se asemeja a una oruga. Es conocido por ser uno de los Pokémon más débiles pero también uno de los más abundantes. Su cuerpo es de un verde brillante, y tiene grandes ojos que le permiten ver en todas direcciones.', '1.00', '6.4','#0010','caterpie.png');
INSERT INTO `pokemons_types` (`pokemons_id`, `types_id`) VALUES (5, (SELECT id FROM types WHERE name = 'Bicho')); 

INSERT INTO `evolutions` (`id`, `pokemon_id`, `name`,`description`,`height`, `weight`, `code` ,`image`) VALUES (NULL, 5, 'metapod', 'Metapod es la evolución de Caterpie. Su cuerpo se transforma en una cápsula duradera, y aunque no tiene mucha capacidad de movimiento o ataque, es fuerte defensivamente y está en proceso de convertirse en un Pokémon más potente.', '2.04', '21.8', '#0011', 'metapod.png');
INSERT INTO `evolutions_types` (`evolutions_id`, `types_id`) VALUES (9, (SELECT id FROM types WHERE name = 'Bicho')); 

INSERT INTO `evolutions` (`id`, `pokemon_id`, `name`,`description`,`height`, `weight`, `code` ,`image`) VALUES (NULL, 5, 'butterfree', 'Butterfree es la forma final de Caterpie. Es un hermoso Pokémon de tipo bicho y volador con grandes alas que le permiten volar y libar néctar de las flores. Butterfree es considerado un Pokémon muy elegante y es conocido por sus habilidades en batalla.', '3.07', '70.5', '#0012', 'butterfree.png');
INSERT INTO `evolutions_types` (`evolutions_id`, `types_id`) VALUES (10, (SELECT id FROM types WHERE name = 'Bicho'));
INSERT INTO `evolutions_types` (`evolutions_id`, `types_id`) VALUES (10, (SELECT id FROM types WHERE name = 'Volador'));


