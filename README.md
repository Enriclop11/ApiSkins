# API de Skins

Este proyecto implementa una API para gestionar skins de un videojuego, permitiendo a los usuarios comprar, cambiar el color y eliminar skins, así como obtener información sobre las skins disponibles. A continuación, se detallan los aspectos clave del proyecto y cómo se han cumplido los requisitos establecidos.

## Definición del Modelo de Skin

El modelo de Skin se ha definido en el paquete `com.enriclop.apiskins.modelo` y se encuentra en la clase `Skin`. Este modelo incluye los siguientes campos:

- `id`: Un identificador único para cada skin.
- `nombre`: El nombre de la skin.
- `tipo`: El tipo de la skin, que puede ser una enumeración que identifica su categoría.
- `precio`: El precio de la skin.
- `descripcion`: Una descripción opcional de la skin.
- `color`: El color asociado a la skin, también representado como una enumeración.

La clase `Skin` está mapeada con la anotación `@Entity` y se encuentra en la tabla de la base de datos llamada "skins". Se utiliza la estrategia `TABLE_PER_CLASS` para la herencia de clases.

## Implementación de una Función para Leer las Skins desde un Archivo JSON

Se ha implementado una función que permite cargar las skins disponibles desde un archivo en formato JSON. Esta función es esencial para inicializar la base de datos con las skins iniciales o para agregar nuevas skins al sistema. Solo se debe editar el JSON de skins que hay en recursos.

En este código, se utiliza la biblioteca Jackson (a través de ObjectMapper) para leer el archivo JSON que contiene la información de las skins. Las skins se almacenan en un array y luego se guardan en la base de datos utilizando el servicio SkinService.

Este enfoque permite cargar fácilmente nuevas skins desde un archivo JSON, lo que facilita la administración de las skins disponibles en el sistema.

## Configuración de la Base de Datos (MySQL)

Para configurar la base de datos MySQL para este proyecto, siga estos pasos sencillos:

1. **URL de la Base de Datos:** En la propiedad `spring.datasource.url`, reemplace `<TU BDD>` con la URL de su base de datos MySQL. Por ejemplo, si está ejecutando la base de datos en su máquina local, puede utilizar la URL `jdbc:mysql://localhost:3306/api_skins`.

2. **Nombre de Usuario:** En la propiedad `spring.datasource.username`, reemplace `<TU USER>` con el nombre de usuario de su base de datos. Este debe ser un nombre de usuario con permisos para acceder a la base de datos.

3. **Contraseña:** En la propiedad `spring.datasource.password`, reemplace `<TU CONTRASEÑA>` con la contraseña correspondiente al nombre de usuario definido en `spring.datasource.username`.

Con estas tres configuraciones modificadas en el archivo `application.properties`, su proyecto estará listo para conectarse a su base de datos MySQL. El resto de las configuraciones en este archivo aseguran que Hibernate se comunique correctamente con MySQL y que las consultas SQL se registren con fines de depuración.

La base de datos se configurara automaticamente al encender el programa, esta tiene que estar vacia para que el springboot pueda crear bien las tablas y no tenga errores.

## Rutas API

• GET /skins/avaible - Devuelve una lista de todas las skins disponibles para comprar.

Esta funcion lo unico que hace es acceder a la tabla skins a traves del servicio y te muestra un JSON con todas las skins disponibles.

• POST /skins/buy - Permite a los usuarios adquirir una skin y guardarla en la base de
datos.

Esta funcion pide el usuario y contraseña junto la skin a comprar, cuando se haga, si no tiene el dienro disponible se cancelara la accion y dara error, en cambio si tiene se le restara el dinero y se procedera a añadir la skin en la tabla de skin_users, donde se pondra a nombre del usuario y se dispondra de la fecha de compra.

• GET /skins/myskins - Devuelve una lista de las skins compradas por el usuario.

Esta funcion pide el usuario, se mostraran todas las skins que disponga el usuario.

• PUT /skins/color - Permite a los usuarios cambiar el color de una skin comprada.

Esta funcion pide usuario y contraseña junto la la id de la skin y el color a cambiar, asi no puedes modificar la skin de otro usuario, se cambiara el color y se volvera a guardar.

• DELETE /skins/delete/{id} - Permite a los usuarios eliminar una skin comprada.

Esta funcion pide usuario y contraseña junto la id de la skin, asi no poder borrar la skin de otro usuario, se dispondra a borrar de la tabla de skin_user.

• GET /skin/getskin/{id} – Devuelve una determinada skin. 

Esta funcion pide la id de una de las skins disponibles, enseña en JSON esa skin determinada.

##Ejecutar en local

Para ejecutar en local solo hay que tener una base de datos conectada y con sus propiedades en application.properties
En mi caso lo tengo con un XAMPP con MySQL, simplemente cree una base de datos, se le introduce la url de la ip, en mi caso localhost:3306/api_skins y el usuario ROOT, la password vacia, esto depende de como quieras tu seguridad, en local y para hacer pruebas no haria falta seguridad entonces va bien para testeo.


Autor
Enric López Perdosa
