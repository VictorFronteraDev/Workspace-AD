-- Consultar els clubs traure el nom y sede
--select  c.nombre, c.sede, c.grupo.nombre, c.grupo.pais from Club c;

-- Consultar el grup u2 quants grups toca
--select g.clubs.size from Grupo g where g.nombre='U2'

--Consultar en quants grups toca 1 grup
--select g.nombre, g.clubs.size from Grupo g

-- Consultar del disc "October" el nom de la companyia, quantes cançons te el disc
--select nombre, companyia.nombre, cancions.size from Disco where nombre='October'

-- Mostrar els grups que son de Anglaterra i que toquen al club Zoomania
--select c.grupo.nombre from Club c where c.nombre = 'Zoomania' and c.grupo.pais = 'Inglaterra'

-- Mitja de la duracio de les cançons del disc zooropa
--select avg(c.duracion) from Disco d join d.cancions c where d.nombre = 'zooropa'
-- Traure la llista de cançons, titulo, de un disc zooropa
--select c.titulo from Disco d join d.cancions c where d.nombre ='zooropa'

--Mostrar de la companyia Island los dicos mostrar el nombre del disco y del grupo
--select d.nombre, d.grupo.nombre from Disco d join d.companyia c where c.nombre = 'Island'