# MLACandidate

## Descripción del Proyecto
El proyecto MLCandidate consiste en una aplicación mobile realizada sobre la plataforma Android Studio como test práctico para un proceso de selección de personal.
Si bien los tiempos de desarrollo se limitaron a algunas horas fuera de la jornada laboral primaria.
Se busco seguir de la mejor forma posible las recomendaciones oficiales acerca de cuales librerias serian mas optimas para cada funcion dentro del proyecto al momento en que se llevo a cabo el mismo.
 Los aspectos mas destacados de la implementación son:
- Modelo MVVM para organizar el codigo. 	
- Retrofit + rxJava + Gson para las llamadas a los servicios.
- Implementacion de Viewmodel con LiveData.  
- Gestion de la carga de imagenes fuera de la cache del dispositivo.
- Glide y Picasso como librerias para la obtencion de imagenes.
- Manejo de Fragments.
- Uso de Logs internos.
- Etc.

Dentro del apartado visual, se siguieron los lineamientos indicados dentro de la libreria de diseño de la organizacion. 
Los mismos se encuentran dentro del Manual de Marca de ML, obtenidos desde la siguiente URL http://ux.mercadolibre.com/#design.
Se adoptaron colores oficiales, logos y las distintas fuentes de texto.


## Descripción breve de la Aplicación
Esta app permite a cualquier usuario mobile de la plataforma android interactuar con la pagina de e-commerce www.mercadolibre.com.ar y buscar productos publicados en esta.
Dentro de la aplicación, tenemos una primer pantalla en la cual debemos ingresar un parámetro de búsqueda y
pulsar sobre el boton de lupa para llevar a cabo la acción.
A continuación, obtendremos una lista de productos que coinciden con nuestro criterio de busqueda, de los cuales vamos
a vizualizar una imagen en miniatura por cada uno, un título descriptivo y el precio de venta.
De ser necesario, podemos obtener mas detalles de un item en particular pulsando sobre el mismo. Esto abrira una nueva pantalla en la cual ademas de una coleccion de imagenes del producto, veremos caracteristicas específicas del mismo.
Es valido aclarar que la aplicacion no almacena datos localmente, por lo que, para utilizar la misma es condicion inevitable disponer de una coneccion a internet.


## Versiones utilizadas en la estructura del proyecto
- Gradle version 			      5.1.1
- Android Plugin version 		3.4.1


## Versionado de Código
Para el versionado de codigo se utilizo la plataforma GitHub.


## Pre-requisitos para instalar la Aplicación
Necesitas disponer de un telefono con sistema operativo Android que contenga instalada al menos la version 8.0 


## Contribuciones
Las Pull request son bienvenidas. Para cambios significativos, por favor abrir primero un issue para discutir que le gustaria cambiar y como lo implementaria.
Por favor, asegurese de actualizar la documentación de la manera correspondiente.


## RoadMap
A nivel funcional y sin entrar en apartados especificos que requieran de un login de usuario y el manejo de tokens dentro de la aplicacion.	

- Visualizacion de las ultimas busquedas realizadas.
- Opciones de filtrado sobre los resultados obtenidos en la búsqueda, a fin de acotar la cantidad de elementos que coincidan con nuestras preferencias.
- Mayor nivel de detalle en caracteristicas de un item seleccionado, incluyendo formas de pago, Modalidad de envio Y carga dinámica de Atributos (Podria implementarse con un RecyclerView, Actualmente el numero de atributos esta limitado a los primeros 6).
- Incluir Fragments que se adapten a distintos tamaños de pantalla, a fin de poder visualizar la aplicacion de manera optima en todos los dispositivos.
- Controles y mejoras en las vistas. Detalles al usuario de los errores obtenidos.


## Soporte
Ante cualquier dificultad con el funcionamiento de la aplicacion, el entendimiento de la misma u otros motivos. No dude en ponerse en contacto. Podes encontrarme aca nicolasvalsagna@gmail.com.


