--8b)Ciclistas cuyo nombre empiece o termine por A 
--select c.nombre from Ciclista c where nombre like 'a%' or nombre like '%a'

--8i)Ciclistas ordenados por fecha de nacimiento de menor a mayor
--select c.nombre, c.nacimiento from Ciclista c order by c.nacimiento asc

--9a)De cada etapa, ciudad de salida y llegada y nombre del ciclista que la ha ganado
--select e.salida, e.llegada, e.ciclista.nombre from Etapa e 

--9b)De cada equipo, nombre, director y número de ciclistas qu e tiene
--select DISTINCT  nomeq, director, e.ciclistas.size from Equipo e

--9c)De cada equipo, nombre del equipo y número de etapas que han ganado sus ciclistas.
--select e.nomeq, c.nombre, c.etapas.size from Equipo e join e.ciclistas c

--Cuantas etapas ha ganado un equipo 
--select e.nomeq, sum(c.etapas.size) from Equipo e join e.ciclistas c group by e.nomeq

--9d)De cada etapa, ciclista que la ha ganado y equipo al que pertenece.
select e.netapa, e.ciclista.nombre, e.ciclista.equipo.nomeq from Etapa e order by e.netapa asc