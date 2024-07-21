-- Active: 1689531439267@@127.0.0.1@3306@jugos_ventas
SELECT *FROM facturas;
SELECT nombre, direccion_1,direccion_2,barrio,ciudad,estado,cp,fecha_de_nacimiento,edad,sexo,limite_de_credito,volumen_de_compra,primera_compra FROM tabla_de_clientes;

SELECT * FROM tabla_de_clientes;
SELECT dni,nombre from tabla_de_clientes;
SELECT dni AS identificacion,nombre as cliente from tabla_de_clientes;
SELECT *FROM tabla_de_productos;
SELECT *FROM tabla_de_productos WHERE tabla_de_productos.`SABOR`='uva';
SELECT *FROM tabla_de_productos WHERE tabla_de_productos.`SABOR`='mango';
SELECT *FROM tabla_de_productos WHERE tabla_de_productos.`ENVASE`='botella pet';
SELECT *FROM tabla_de_productos WHERE tabla_de_productos.`PRECIO_DE_LISTA`>16;
SELECT *FROM tabla_de_productos WHERE tabla_de_productos.`PRECIO_DE_LISTA`<=17;
SELECT *FROM tabla_de_productos WHERE tabla_de_productos.`PRECIO_DE_LISTA` BETWEEN 16 AND 17;
SELECT *FROM tabla_de_productos WHERE tabla_de_productos.`SABOR`='mango' AND tabla_de_productos.`TAMANO`='470 ml';
SELECT *FROM tabla_de_productos WHERE tabla_de_productos.`SABOR`='mango' OR tabla_de_productos.`TAMANO`='470 ml';
SELECT *FROM tabla_de_productos WHERE NOT (tabla_de_productos.`SABOR`='mango') OR tabla_de_productos.`TAMANO`='470 ml';
SELECT *FROM tabla_de_productos WHERE NOT (tabla_de_productos.`SABOR`='mango' AND tabla_de_productos.`TAMANO`='470 ml');
SELECT *FROM tabla_de_productos WHERE tabla_de_productos.`SABOR`='mango' AND NOT (tabla_de_productos.`TAMANO`='470 ml');
SELECT *FROM tabla_de_productos WHERE tabla_de_productos.`SABOR` IN ('mango', 'uva');
SELECT *FROM tabla_de_productos WHERE tabla_de_productos.`SABOR`='mango' OR tabla_de_productos.`SABOR`='uva';

SELECT *FROM tabla_de_clientes WHERE tabla_de_clientes.`CIUDAD` IN ('ciudad de mexico','guadalajara');
SELECT *FROM tabla_de_clientes WHERE tabla_de_clientes.`CIUDAD` IN ('ciudad de mexico','guadalajara')
AND tabla_de_clientes.`EDAD`>21;
SELECT *FROM tabla_de_clientes WHERE tabla_de_clientes.`CIUDAD` IN ('ciudad de mexico','guadalajara')
AND tabla_de_clientes.`EDAD` BETWEEN 20 AND 25;
SELECT *FROM tabla_de_clientes WHERE tabla_de_clientes.`CIUDAD` IN ('ciudad de mexico','guadalajara')
AND (tabla_de_clientes.`EDAD` BETWEEN 20 AND 25);
#---------------------------------- LIKE
SELECT * FROM tabla_de_productos WHERE `SABOR` LIKE '%manzana';
SELECT * FROM tabla_de_productos WHERE `SABOR` LIKE '%manzana' AND `ENVASE`='botella pet';
#¿Cuántos clientes tienen apellidos que acaban con “ez”?
SELECT * FROM tabla_de_clientes WHERE `NOMBRE` LIKE '%ez';
SELECT `ENVASE`,`TAMANO` from tabla_de_productos;
#---------------------------------- DISTINCT
SELECT DISTINCT `ENVASE`,`TAMANO` from tabla_de_productos;
SELECT DISTINCT `ENVASE`,`TAMANO`,`SABOR` from tabla_de_productos
WHERE `SABOR`='Naranja';
#¿Cuáles son los barrios en Ciudad de México que tienen clientes?
SELECT DISTINCT BARRIO FROM tabla_de_clientes WHERE CIUDAD = 'Ciudad de México';
#----------------------------------LIMIT
SELECT *FROM tabla_de_productos LIMIT 5;
SELECT *FROM tabla_de_productos LIMIT 5,4 ;
#Queremos obtener las 10 primeras ventas del día 01/01/2017. ¿Cuál sería el comando SQL para obtener este resultado?
SELECT *FROM `facturas` WHERE `FECHA_VENTA`='2017-01-01' LIMIT 10;
#----------------------------------ORDER BY, DESC, ASC
SELECT * FROM tabla_de_productos ORDER BY `PRECIO_DE_LISTA`;
SELECT * FROM tabla_de_productos ORDER BY `PRECIO_DE_LISTA` DESC;
SELECT * FROM tabla_de_productos ORDER BY `NOMBRE_DEL_PRODUCTO`;
SELECT * FROM tabla_de_productos ORDER BY `NOMBRE_DEL_PRODUCTO`DESC;
SELECT * FROM tabla_de_productos ORDER BY `ENVASE` DESC, `NOMBRE_DEL_PRODUCTO` ASC;
#---------------------------------------
#¿Cuál (o cuáles) fue (fueron) la(s) mayor(es) venta(s) del producto “Refrescante, 1 Litro, Frutilla/Limón”, en cantidad? (Obtenga este resultado utilizando 2 comandos SQL).
SELECT CODIGO_DEL_PRODUCTO FROM tabla_de_productos 
WHERE NOMBRE_DEL_PRODUCTO = "Refrescante" AND TAMANO = "1 Litro" 
AND SABOR = "Frutilla/Limón"; 
SELECT * FROM items_facturas WHERE CODIGO_DEL_PRODUCTO = "1101035" ORDER BY CANTIDAD DESC;
#--------------------------------------- GROUP BY, SUM, MAX, MIN, COUNT

SELECT ESTADO, SUM(LIMITE_DE_CREDITO) AS LIMITE_TOTAL FROM tabla_de_clientes
GROUP BY ESTADO;
SELECT ENVASE,MAX (PRECIO_DE_LISTA) AS MAYOR_PRECIO FROM tabla_de_productos
GROUP BY ENVASE;
SELECT ENVASE,COUNT(*) FROM tabla_de_productos GROUP BY ENVASE;
SELECT BARRIO,SUM(LIMITE_DE_CREDITO) AS LIMITE FROM tabla_de_clientes GROUP BY BARRIO;
SELECT BARRIO,SUM(LIMITE_DE_CREDITO) AS LIMITE FROM tabla_de_clientes WHERE CIUDAD='CIUDAD DE MEXICO' GROUP BY BARRIO;
SELECT CIUDAD,BARRIO,SUM(LIMITE_DE_CREDITO) AS LIMITE FROM tabla_de_clientes WHERE CIUDAD='CIUDAD DE MEXICO' GROUP BY BARRIO;
SELECT CIUDAD,BARRIO,SUM(LIMITE_DE_CREDITO) AS LIMITE FROM tabla_de_clientes WHERE CIUDAD='GUADALAJARA' GROUP BY BARRIO;
SELECT CIUDAD,BARRIO,MAX(LIMITE_DE_CREDITO) AS LIMITE FROM tabla_de_clientes GROUP BY ESTADO, BARRIO;
SELECT ESTADO,BARRIO,MAX(LIMITE_DE_CREDITO) AS LIMITE, EDAD FROM tabla_de_clientes 
WHERE EDAD>=20 GROUP BY ESTADO, BARRIO ORDER BY EDAD;
#----------------------------------------
#Aprovechando el ejercicio del video anterior ¿Cuántos ítems vendidos cuentan con la mayor cantidad del producto '1101035'?
SELECT MAX(CANTIDAD) AS CANTIDAD_MAXIMA FROM items_facturas WHERE CODIGO_DEL_PRODUCTO = "1101035";
SELECT COUNT(*) FROM items_facturas WHERE CODIGO_DEL_PRODUCTO = "1101035" AND CANTIDAD = 99;
#---------------------------------- HAVING
SELECT ESTADO, SUM(LIMITE_DE_CREDITO) AS LIMITE_TOTAL FROM tabla_de_clientes 
GROUP BY ESTADO HAVING LIMITE_TOTAL>300000;

SELECT ENVASE,MAX(PRECIO_DE_LISTA)AS PRECIO_MAXIMO,
MIN(PRECIO_DE_LISTA)AS PRECIO_MINIMO FROM tabla_de_productos GROUP BY ENVASE;

SELECT ENVASE,MAX(PRECIO_DE_LISTA)AS PRECIO_MAXIMO,
MIN(PRECIO_DE_LISTA)AS PRECIO_MINIMO FROM tabla_de_productos GROUP BY ENVASE
HAVING SUM(PRECIO_DE_LISTA)>80;
SELECT ENVASE,MAX(PRECIO_DE_LISTA)AS PRECIO_MAXIMO,
MIN(PRECIO_DE_LISTA)AS PRECIO_MINIMO, 
SUM (PRECIO_DE_LISTA)AS SUMA_PRECIO 
FROM tabla_de_productos GROUP BY ENVASE
HAVING SUM(PRECIO_DE_LISTA)>80;

SELECT ENVASE,MAX(PRECIO_DE_LISTA)AS PRECIO_MAXIMO,
MIN(PRECIO_DE_LISTA)AS PRECIO_MINIMO, 
SUM (PRECIO_DE_LISTA)AS SUMA_PRECIO 
FROM tabla_de_productos GROUP BY ENVASE
HAVING SUM(PRECIO_DE_LISTA)>=80 
AND MAX(PRECIO_DE_LISTA)>=5;
#---------------------------------- ¿Quiénes fueron los clientes que realizaron más de 2000 compras en 2016?
SELECT DNI, COUNT(*) FROM facturas
WHERE YEAR(FECHA_VENTA) = 2016
GROUP BY DNI
HAVING COUNT(*) > 2000;
#---------------------------------- CASE
SELECT * FROM tabla_de_productos;
SELECT NOMBRE_DEL_PRODUCTO, PRECIO_DE_LISTA,
CASE 
  WHEN `PRECIO_DE_LISTA`>=12 THEN 'Costoso'
  WHEN `PRECIO_DE_LISTA`>=5 AND `PRECIO_DE_LISTA`<12 THEN 'Asequible'
  ELSE 'Barato'
END AS PRECIO
FROM tabla_de_productos;
SELECT ENVASE, SABOR,
CASE
   WHEN PRECIO_DE_LISTA >= 12 THEN 'Costoso'
   WHEN PRECIO_DE_LISTA >= 5 AND PRECIO_DE_LISTA < 12 THEN 'Asequible'
   ELSE 'Barato'
END AS PRECIO, MIN(PRECIO_DE_LISTA) AS PRECIO_MINIMO
FROM tabla_de_productos
WHERE TAMANO = '700 ml'
GROUP BY ENVASE,
CASE
   WHEN PRECIO_DE_LISTA >= 12 THEN 'Costoso'
   WHEN PRECIO_DE_LISTA >= 5 AND PRECIO_DE_LISTA < 12 THEN 'Asequible'
   ELSE 'Barato'
END
ORDER BY ENVASE;

#Registre el año de nacimiento de los clientes y clasifíquelos de la siguiente manera:
#Nacidos antes de 1990= Viejos, nacidos entre 1990 y 1995= Jóvenes y nacidos después de 1995= Niños. Liste el nombre del cliente y esta clasificación.
SELECT NOMBRE,
CASE 
    WHEN YEAR(fecha_de_nacimiento) < 1990 THEN 'Viejos'
    WHEN YEAR(fecha_de_nacimiento) >= 1990 
    AND YEAR(fecha_de_nacimiento) <= 1995 THEN 'Jóvenes' 
    ELSE 'Niños' 
END AS CLASIFICACION_EDAD
FROM tabla_de_clientes;




