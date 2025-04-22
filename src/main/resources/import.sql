/*tipos de pokemon*/
INSERT INTO `types` (`id`,`name`,`description`) VALUES (NULL, 'Acero', 'Tipo de Pokemon que es fuerte contra Hielo, Roca y Hada, y debil contra Fuego, Lucha y Tierra.');
INSERT INTO `types` (`id`,`name`,`description`) VALUES (NULL, 'Agua', 'Tipo de Pokemon que es fuerte contra Fuego, Roca y Tierra, y debil contra Agua, Dragon y Planta.');
INSERT INTO `types` (`id`,`name`,`description`) VALUES (NULL, 'Bicho', 'Tipo de Pokemon que es fuerte contra Planta, Psíquico y Siniestro, y debil contra Acero, Fantasma, Fuego, Hada, Lucha y Volador.');
INSERT INTO `types` (`id`,`name`,`description`) VALUES (NULL, 'Dragon', 'Tipo de Pokemon que es fuerte contra Dragon, y debil contra Acero y Hada.');
INSERT INTO `types` (`id`,`name`,`description`) VALUES (NULL, 'Electrico', 'Tipo de Pokemon que es fuerte contra Agua y Volador, y debil contra Dragon, Electrico y Planta.');
INSERT INTO `types` (`id`,`name`,`description`) VALUES (NULL, 'Fantasma', 'Tipo de Pokemon que es fuerte contra Fantasma y Psíquico, y debil contra Normal y Siniestro.');
INSERT INTO `types` (`id`,`name`,`description`) VALUES (NULL, 'Fuego', 'Tipo de Pokemon que es fuerte contra Acero, Bicho, Hielo y Planta, y debil contra Agua, Dragon, Fuego y Roca.');
INSERT INTO `types` (`id`,`name`,`description`) VALUES (NULL, 'Hada', 'Tipo de Pokemon que es fuerte contra Dragon, Lucha y Siniestro, y debil contra Acero, Fuego y Veneno.');
INSERT INTO `types` (`id`,`name`,`description`) VALUES (NULL, 'Hielo', 'Tipo de Pokemon que es fuerte contra Dragon, Planta, Tierra y Volador, y debil contra Acero, Agua, Fuego e Hielo.');
INSERT INTO `types` (`id`,`name`,`description`) VALUES (NULL, 'Lucha', 'Tipo de Pokemon que es fuerte contra Normal, y debil contra Bicho, Fantasma, Hada, Psíquico y Volador.');
INSERT INTO `types` (`id`,`name`,`description`) VALUES (NULL, 'Normal', 'Tipo de Pokemon que no tiene ventajas ni desventajas especificas contra otros tipos.');
INSERT INTO `types` (`id`,`name`,`description`) VALUES (NULL, 'Planta', 'Tipo de Pokemon que es fuerte contra Agua, Roca y Tierra, y debil contra Acero, Bicho, Dragon, Fuego, Planta, Veneno y Volador.');
INSERT INTO `types` (`id`,`name`,`description`) VALUES (NULL, 'Psiquico', 'Tipo de Pokemon que es fuerte contra Lucha y Veneno, y debil contra Acero, Psíquico y Siniestro.');
INSERT INTO `types` (`id`,`name`,`description`) VALUES (NULL, 'Roca', 'Tipo de Pokemon que es fuerte contra Bicho, Fuego, Hielo y Volador, y debil contra Acero, Lucha y Tierra.');
INSERT INTO `types` (`id`,`name`,`description`) VALUES (NULL, 'Siniestro', 'Tipo de Pokemon que es fuerte contra Fantasma y Psíquico, y debil contra Hada, Lucha y Siniestro.');
INSERT INTO `types` (`id`,`name`,`description`) VALUES (NULL, 'Tierra', 'Tipo de Pokemon que es fuerte contra Acero, Electrico, Fuego, Roca y Veneno, y debil contra Bicho, Planta y Volador.');
INSERT INTO `types` (`id`,`name`,`description`) VALUES (NULL, 'Veneno', 'Tipo de Pokemon que es fuerte contra Hada y Planta, y debil contra Acero, Fantasma, Roca, Tierra y Veneno.');
INSERT INTO `types` (`id`,`name`,`description`) VALUES (NULL, 'Volador', 'Tipo de Pokemon que es fuerte contra Bicho, Lucha y Planta, y debil contra Acero, Electrico y Roca.');

/*pokemon 1*/
INSERT INTO `pokemons` (`id`,`name`,`description`,`height`, `weight`,`code`, `image`) VALUES (NULL, 'pichu','Pichu está basado en un roedor. Pichu tiene una piel de color amarillo pálido, con las mejillas rosadas, una cola corta negra y orejas grandes, con bordeados de color negro. Su pequeño tamaño puede despistar a cualquier entrenador novato, pero puede paralizar incluso a humanos adultos si no se tiene cuidado.','1.00', '4.4', '#0172','pichu.png')
INSERT INTO `pokemons_types` (`pokemons_id`, `types_id`) VALUES (1, (SELECT id FROM types WHERE name = 'Electrico'));
INSERT INTO `pokemons_weaknesses` (`pokemons_id`, `types_id`) VALUES (1, (SELECT id FROM types WHERE name = 'Tierra'));
INSERT INTO `statistics` (`id`, `pokemon_id`, `evolution_id`, `attack`, `defence`, `velocity`, `life`) VALUES (1, 1, NULL, 40, 15, 60, 20); 

/*evolution 1*/
INSERT INTO `evolutions` (`id`, `pokemon_id`, `name`,`description`,`height`, `weight`, `code` ,`image`) VALUES (NULL, 1, 'pikachu','Pikachu es un pequeño Pokémon cuya morfología se encuentra basada en un roedor. Aunque su nombre y su categoría hagan alusión a un ratón, según su diseñadora, sus mejillas están basadas en las de una ardilla. Su cuerpo es de color amarillo con dos rayas marrones en su espalda y en la base de la cola. La punta de sus orejas de color negro, y presenta un gran círculo rojo en cada una de sus mejillas. Tiene una cola con forma de rayo si es macho y en forma de corazón si es hembra.', '1.04', '13.2','#0025','pikachu.png')
INSERT INTO `evolutions_types` (`evolutions_id`, `types_id`) VALUES (1, (SELECT id FROM types WHERE name = 'Electrico'));
INSERT INTO `evolutions_weaknesses` (`evolutions_id`, `types_id`) VALUES (1, (SELECT id FROM types WHERE name = 'Tierra'));

INSERT INTO `statistics` (`id`, `pokemon_id`, `evolution_id`, `attack`, `defence`, `velocity`, `life`) VALUES (NULL, NULL, 1, 55, 40, 90, 35);

/*evolution 2*/
INSERT INTO `evolutions` (`id`, `pokemon_id`, `name`,`description`,`height`, `weight`, `code` ,`image`) VALUES (NULL, 1, 'raichu','Este Pokémon es un gran roedor bípedo. Tiene un pelaje anaranjado, una cola oscura y gruesa como un cable de tendido eléctrico que termina en forma de rayo y totalmente plano, que además puede soportar grandes cargas.','2.07', '66.1', '#0026', 'raichu.png')
INSERT INTO `evolutions_types` (`evolutions_id`, `types_id`) VALUES (2, (SELECT id FROM types WHERE name = 'Electrico'));
INSERT INTO `evolutions_weaknesses` (`evolutions_id`, `types_id`) VALUES (1, (SELECT id FROM types WHERE name = 'Tierra'));
INSERT INTO `statistics` (`id`, `pokemon_id`, `evolution_id`, `attack`, `defence`, `velocity`, `life`) VALUES (NULL, NULL, 2, 90, 55, 100, 60);

/*pokemon 2*/
INSERT INTO `pokemons` (`id`,`name`,`description`,`height`, `weight`,`code`, `image`) VALUES (NULL, 'bulbasaur', 'Bulbasaur es un Pokémon de tipo planta y veneno. Es conocido por tener una planta en su espalda que crecerá a medida que evoluciona. Tiene un cuerpo de color verde y unas manchas más oscuras en su piel. Es pequeño pero muy fuerte y ágil, y a menudo es considerado un excelente compañero por los entrenadores.', '2.04', '15.2','#0001','bulbasaur.png');
INSERT INTO `pokemons_types` (`pokemons_id`, `types_id`) VALUES (2, (SELECT id FROM types WHERE name = 'Planta'));
INSERT INTO `pokemons_types` (`pokemons_id`, `types_id`) VALUES (2, (SELECT id FROM types WHERE name = 'Veneno'));
INSERT INTO `pokemons_weaknesses` (`pokemons_id`, `types_id`) VALUES (1, (SELECT id FROM types WHERE name = 'Fuego'));
INSERT INTO `pokemons_weaknesses` (`pokemons_id`, `types_id`) VALUES (1, (SELECT id FROM types WHERE name = 'Hielo'));
INSERT INTO `pokemons_weaknesses` (`pokemons_id`, `types_id`) VALUES (1, (SELECT id FROM types WHERE name = 'Psiquico'));
INSERT INTO `pokemons_weaknesses` (`pokemons_id`, `types_id`) VALUES (1, (SELECT id FROM types WHERE name = 'Psiquico'));
INSERT INTO `statistics` (`id`, `pokemon_id`, `evolution_id`, `attack`, `defence`, `velocity`, `life`) VALUES (NULL, 2, NULL, 49, 49, 45, 45); 

/*evolution 3*/
INSERT INTO `evolutions` (`id`, `pokemon_id`, `name`,`description`,`height`, `weight`, `code` ,`image`) VALUES (NULL, 2, 'ivysaur', 'Ivysaur es la evolución de Bulbasaur y es de tipo planta y veneno. Tiene una planta más grande que bulbasaur en su espalda, y su cuerpo se ha vuelto un poco más robusto. Ivysaur es conocido por tener un temperamento más fuerte y un poder más notable en batalla.', '3.03', '28.7', '#0002', 'ivysaur.png');
INSERT INTO `evolutions_types` (`evolutions_id`, `types_id`) VALUES (3, (SELECT id FROM types WHERE name = 'Planta'));
INSERT INTO `evolutions_types` (`evolutions_id`, `types_id`) VALUES (3, (SELECT id FROM types WHERE name = 'Veneno'));
INSERT INTO `evolutions_weaknesses` (`evolutions_id`, `types_id`) VALUES (3, (SELECT id FROM types WHERE name = 'Fuego'));
INSERT INTO `evolutions_weaknesses` (`evolutions_id`, `types_id`) VALUES (3, (SELECT id FROM types WHERE name = 'Hielo'));
INSERT INTO `evolutions_weaknesses` (`evolutions_id`, `types_id`) VALUES (3, (SELECT id FROM types WHERE name = 'Psiquico'));
INSERT INTO `evolutions_weaknesses` (`evolutions_id`, `types_id`) VALUES (3, (SELECT id FROM types WHERE name = 'Psiquico'));
INSERT INTO `statistics` (`id`, `pokemon_id`, `evolution_id`, `attack`, `defence`, `velocity`, `life`) VALUES (NULL, NULL, 3, 62, 63, 60, 60);

/*evolution 4*/
INSERT INTO `evolutions` (`id`, `pokemon_id`, `name`,`description`,`height`, `weight`, `code` ,`image`) VALUES (NULL, 2, 'venusaur', 'Venusaur es la forma final de Bulbasaur. Se ha convertido en un Pokémon considerablemente más grande, con una enorme planta en su espalda que ha florecido en una hermosa flor. Venusaur es poderoso y capaz de controlar el entorno a su alrededor a través de sus habilidades de tipo planta.', '6.07', '220.5', '#0003', 'venusaur.png');
INSERT INTO `evolutions_types` (`evolutions_id`, `types_id`) VALUES (4, (SELECT id FROM types WHERE name = 'Planta'));
INSERT INTO `evolutions_types` (`evolutions_id`, `types_id`) VALUES (4, (SELECT id FROM types WHERE name = 'Veneno'));
INSERT INTO `evolutions_weaknesses` (`evolutions_id`, `types_id`) VALUES (4, (SELECT id FROM types WHERE name = 'Fuego'));
INSERT INTO `evolutions_weaknesses` (`evolutions_id`, `types_id`) VALUES (4, (SELECT id FROM types WHERE name = 'Hielo'));
INSERT INTO `evolutions_weaknesses` (`evolutions_id`, `types_id`) VALUES (4, (SELECT id FROM types WHERE name = 'Psiquico'));
INSERT INTO `evolutions_weaknesses` (`evolutions_id`, `types_id`) VALUES (4, (SELECT id FROM types WHERE name = 'Psiquico'));
INSERT INTO `statistics` (`id`, `pokemon_id`, `evolution_id`, `attack`, `defence`, `velocity`, `life`) VALUES (NULL, NULL, 4, 82, 83, 80, 80); 

/*pokemon 3*/
INSERT INTO `pokemons` (`id`,`name`,`description`,`height`, `weight`,`code`, `image`) VALUES (NULL, 'charmander', 'Charmander es un Pokémon de tipo fuego. Su cuerpo es de color naranja y tiene una llama en la punta de su cola que muestra su estado emocional y salud. Charmander es un Pokémon popular y adora la luz y el calor, lo que le permite crecer en uno de los Pokémon más poderosos si evoluciona correctamente.', '2.00', '18.7','#0004','charmander.png');
INSERT INTO `pokemons_types` (`pokemons_id`, `types_id`) VALUES (3, (SELECT id FROM types WHERE name = 'Fuego'));
INSERT INTO `pokemons_weaknesses` (`pokemons_id`, `types_id`) VALUES (3, (SELECT id FROM types WHERE name = 'Agua'));
INSERT INTO `pokemons_weaknesses` (`pokemons_id`, `types_id`) VALUES (3, (SELECT id FROM types WHERE name = 'Roca'));
INSERT INTO `pokemons_weaknesses` (`pokemons_id`, `types_id`) VALUES (3, (SELECT id FROM types WHERE name = 'Tierra'));
INSERT INTO `statistics` (`id`, `pokemon_id`, `evolution_id`, `attack`, `defence`, `velocity`, `life`) VALUES (NULL, 3, NULL, 52, 43, 65, 39);

/*evolution 5*/
INSERT INTO `evolutions` (`id`, `pokemon_id`, `name`,`description`,`height`, `weight`, `code` ,`image`) VALUES (NULL, 3, 'charmeleon', 'Charmeleon es la evolución de Charmander. Se distingue por su temperamento más feroz y su capacidad para controlar mejor el fuego, lo que le hace un adversario formidable en batalla. Su cola sigue ardiendo intensamente, y se vuelve más poderoso al crecer.', '3.07', '41.9', '#0005', 'charmeleon.png');
INSERT INTO `evolutions_types` (`evolutions_id`, `types_id`) VALUES (5, (SELECT id FROM types WHERE name = 'Fuego'));
INSERT INTO `evolutions_weaknesses` (`evolutions_id`, `types_id`) VALUES (5, (SELECT id FROM types WHERE name = 'Agua'));
INSERT INTO `evolutions_weaknesses` (`evolutions_id`, `types_id`) VALUES (5, (SELECT id FROM types WHERE name = 'Roca'));
INSERT INTO `evolutions_weaknesses` (`evolutions_id`, `types_id`) VALUES (5, (SELECT id FROM types WHERE name = 'Tierra'));
INSERT INTO `statistics` (`id`, `pokemon_id`, `evolution_id`, `attack`, `defence`, `velocity`, `life`) VALUES (NULL, NULL, 5, 64, 58, 80, 58); 

/*evolution 6*/
INSERT INTO `evolutions` (`id`, `pokemon_id`, `name`,`description`,`height`, `weight`, `code` ,`image`) VALUES (NULL, 3, 'charizard', 'Charizard es la evolución final de Charmander. Es un Pokémon de tipo fuego y volador, con la capacidad de volar a altas altitudes. Su cuerpo ha crecido significativamente y sus alas son fuertes y poderosas, lo que le permite lanzar potentes ataques de fuego.', '5.07', '199.5', '#0006', 'charizard.png');
INSERT INTO `evolutions_types` (`evolutions_id`, `types_id`) VALUES (6, (SELECT id FROM types WHERE name = 'Fuego'));
INSERT INTO `evolutions_types` (`evolutions_id`, `types_id`) VALUES (6, (SELECT id FROM types WHERE name = 'Volador'));
INSERT INTO `evolutions_weaknesses` (`evolutions_id`, `types_id`) VALUES (6, (SELECT id FROM types WHERE name = 'Dragon'));
INSERT INTO `evolutions_weaknesses` (`evolutions_id`, `types_id`) VALUES (6, (SELECT id FROM types WHERE name = 'Roca'));
INSERT INTO `evolutions_weaknesses` (`evolutions_id`, `types_id`) VALUES (6, (SELECT id FROM types WHERE name = 'Tierra'));
INSERT INTO `statistics` (`id`, `pokemon_id`, `evolution_id`, `attack`, `defence`, `velocity`, `life`) VALUES (NULL, NULL, 6, 84, 78, 100, 78);

/*pokemon 4*/
INSERT INTO `pokemons` (`id`,`name`,`description`,`height`, `weight`,`code`, `image`) VALUES (NULL, 'squirtle', 'Squirtle es un Pokémon de tipo agua que se asemeja a una pequeña tortuga. Es conocido por su caparazón duro y su adorable apariencia. Squirtle es ingenioso y muy hábil en el uso del agua, siendo un compañero confiable para los entrenadores.', '1.08', '19.8','#0007','squirtle.png');
INSERT INTO `pokemons_types` (`pokemons_id`, `types_id`) VALUES (4, (SELECT id FROM types WHERE name = 'Agua'));
INSERT INTO `pokemons_weaknesses` (`pokemons_id`, `types_id`) VALUES (4, (SELECT id FROM types WHERE name = 'Electrico'));
INSERT INTO `pokemons_weaknesses` (`pokemons_id`, `types_id`) VALUES (4, (SELECT id FROM types WHERE name = 'Planta'));
INSERT INTO `statistics` (`id`, `pokemon_id`, `evolution_id`, `attack`, `defence`, `velocity`, `life`) VALUES (NULL, 4, NULL, 48, 65, 43, 44);

/*evolution 7*/
INSERT INTO `evolutions` (`id`, `pokemon_id`, `name`,`description`,`height`, `weight`, `code` ,`image`) VALUES (NULL, 4, 'wartortle', 'Wartortle es la evolución de Squirtle y presenta orejas más largas y un pelaje más esponjoso. Es conocido por su gran agilidad y sus habilidades en batalla, además de su capacidad para manipular el agua con gran eficacia.', '3.03', '49.6', '#0008', 'wartortle.png');
INSERT INTO `evolutions_types` (`evolutions_id`, `types_id`) VALUES (7, (SELECT id FROM types WHERE name = 'Agua'));
INSERT INTO `evolutions_weaknesses` (`evolutions_id`, `types_id`) VALUES (7, (SELECT id FROM types WHERE name = 'Electrico'));
INSERT INTO `evolutions_weaknesses` (`evolutions_id`, `types_id`) VALUES (7, (SELECT id FROM types WHERE name = 'Planta'));
INSERT INTO `statistics` (`id`, `pokemon_id`, `evolution_id`, `attack`, `defence`, `velocity`, `life`) VALUES (NULL, NULL, 7, 63, 80, 58, 59);

/*evolution 8*/
INSERT INTO `evolutions` (`id`, `pokemon_id`, `name`,`description`,`height`, `weight`, `code` ,`image`) VALUES (NULL, 4, 'blastoise', 'Blastoise es la forma final de Squirtle. Este Pokémon es imponente, con un caparazón resistente y dos cañones de agua en su espalda. Blastoise puede lanzar poderosos chorros de agua, lo que lo convierte en un formidable Pokémon en combate.', '5.03', '188.5', '#0009', 'blastoise.png');
INSERT INTO `evolutions_types` (`evolutions_id`, `types_id`) VALUES (8, (SELECT id FROM types WHERE name = 'Agua'));
INSERT INTO `evolutions_weaknesses` (`evolutions_id`, `types_id`) VALUES (8, (SELECT id FROM types WHERE name = 'Electrico'));
INSERT INTO `evolutions_weaknesses` (`evolutions_id`, `types_id`) VALUES (8, (SELECT id FROM types WHERE name = 'Planta'));
INSERT INTO `statistics` (`id`, `pokemon_id`, `evolution_id`, `attack`, `defence`, `velocity`, `life`) VALUES (NULL, NULL, 8, 83, 100, 78, 79);

/*pokemon 5*/
INSERT INTO `pokemons` (`id`,`name`,`description`,`height`, `weight`,`code`, `image`) VALUES (NULL, 'caterpie', 'Caterpie es un Pokémon de tipo bicho que se asemeja a una oruga. Es conocido por ser uno de los Pokémon más débiles pero también uno de los más abundantes. Su cuerpo es de un verde brillante, y tiene grandes ojos que le permiten ver en todas direcciones.', '1.00', '6.4','#0010','caterpie.png');
INSERT INTO `pokemons_types` (`pokemons_id`, `types_id`) VALUES (5, (SELECT id FROM types WHERE name = 'Bicho')); 
INSERT INTO `pokemons_weaknesses` (`pokemons_id`, `types_id`) VALUES (5, (SELECT id FROM types WHERE name = 'Fuego'));
INSERT INTO `pokemons_weaknesses` (`pokemons_id`, `types_id`) VALUES (5, (SELECT id FROM types WHERE name = 'Roca'));
INSERT INTO `pokemons_weaknesses` (`pokemons_id`, `types_id`) VALUES (5, (SELECT id FROM types WHERE name = 'Volador'));
INSERT INTO `statistics` (`id`, `pokemon_id`, `evolution_id`, `attack`, `defence`, `velocity`, `life`) VALUES (NULL, 5, NULL, 30, 35, 45, 50); 

/*evolution 9*/
INSERT INTO `evolutions` (`id`, `pokemon_id`, `name`,`description`,`height`, `weight`, `code` ,`image`) VALUES (NULL, 5, 'metapod', 'Metapod es la evolución de Caterpie. Su cuerpo se transforma en una cápsula duradera, y aunque no tiene mucha capacidad de movimiento o ataque, es fuerte defensivamente y está en proceso de convertirse en un Pokémon más potente.', '2.04', '21.8', '#0011', 'metapod.png');
INSERT INTO `evolutions_types` (`evolutions_id`, `types_id`) VALUES (9, (SELECT id FROM types WHERE name = 'Bicho')); 
INSERT INTO `evolutions_weaknesses` (`evolutions_id`, `types_id`) VALUES (9, (SELECT id FROM types WHERE name = 'Fuego'));
INSERT INTO `evolutions_weaknesses` (`evolutions_id`, `types_id`) VALUES (9, (SELECT id FROM types WHERE name = 'Roca'));
INSERT INTO `evolutions_weaknesses` (`evolutions_id`, `types_id`) VALUES (9, (SELECT id FROM types WHERE name = 'Volador'));
INSERT INTO `statistics` (`id`, `pokemon_id`, `evolution_id`, `attack`, `defence`, `velocity`, `life`) VALUES (NULL, NULL, 9, 20, 55, 30, 50);

/*evolution 10*/
INSERT INTO `evolutions` (`id`, `pokemon_id`, `name`,`description`,`height`, `weight`, `code` ,`image`) VALUES (NULL, 5, 'butterfree', 'Butterfree es la forma final de Caterpie. Es un hermoso Pokémon de tipo bicho y volador con grandes alas que le permiten volar y libar néctar de las flores. Butterfree es considerado un Pokémon muy elegante y es conocido por sus habilidades en batalla.', '3.07', '70.5', '#0012', 'butterfree.png');
INSERT INTO `evolutions_types` (`evolutions_id`, `types_id`) VALUES (10, (SELECT id FROM types WHERE name = 'Bicho'));
INSERT INTO `evolutions_types` (`evolutions_id`, `types_id`) VALUES (10, (SELECT id FROM types WHERE name = 'Volador'));
INSERT INTO `evolutions_weaknesses` (`evolutions_id`, `types_id`) VALUES (9, (SELECT id FROM types WHERE name = 'Electrico'));
INSERT INTO `evolutions_weaknesses` (`evolutions_id`, `types_id`) VALUES (9, (SELECT id FROM types WHERE name = 'Fuego'));
INSERT INTO `evolutions_weaknesses` (`evolutions_id`, `types_id`) VALUES (9, (SELECT id FROM types WHERE name = 'Hielo'));
INSERT INTO `evolutions_weaknesses` (`evolutions_id`, `types_id`) VALUES (9, (SELECT id FROM types WHERE name = 'Volador'));
INSERT INTO `statistics` (`id`, `pokemon_id`, `evolution_id`, `attack`, `defence`, `velocity`, `life`) VALUES (NULL, NULL, 10, 60, 55, 80, 60); 
