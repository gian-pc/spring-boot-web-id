                    Proyecto 2
            (Inyección de Dependencias)

1. Creación del proyecto **spring-boot-web-id**
   - Maven
   - Java 17
   - Dependencias
     - Spring Boot Actuator 
     - Spring Web 
     - Thymeleaf
     - Spring Boot DevTools
2. Antes de la Inyección de Dependencias
   - Teníamos que realizar el siguiente proceso:
     - Instanciación de clases
     - Creación de Objetos
     - Acceder a los métodos de un objeto en concreto
   - Creamos 2 packages controllers y models.services
   - Creamos MiServicio
   - Creamos MiController
   - Una vista miServicio.html
3. Inyección de Dependencias (No me llames, yo te llamo)
   - Solución poco desacoplada(Sin Interfaces)
   - **MiController** ya no llamará a la clase **MiServicio**
   - **MiServicio** sé instancia o inyecta en **MiController**
   - **@Component** agregamos a MiServicio: Spring toma conocimiento del componente MiServicio para luego inyectarlo
   - **@Autowired** agregamos a MiController: Busca un componente que corresponda, de tal forma que lo inyecta y se puede utilizar
4. Inyección de Dependencias
   - Solución desacoplada(Con Interfaces)
   - Creamos una interfaz "IServicio"
   - Definimos el método operación en IServicio
   - MiServicio implementa IServicio (Desarrollamos el método operación)
   - MiController inyecta la interface IServicio
5. Agregando una nueva Clase
   - Al tener una opción desacoplada no modificamos **MiController**
   - Solo implementamos el servicio a la nueva Clase **MiServicioComplejo**
   - Además, declaramos a la clase **MiServicioComplejo** como un @Component
   - **Problema**
     - Al encontrar 2 implementaciones no sabe a cuál elegir
   - **Solución**
     - Solución1: Eliminar un componente
     - Solución2: Agregar **@Primary**
     - Solución3: **@Qualifier** Se agrega en MiController y se agrega el nombre del componente, para ello antes los componentes tienen que tener un nombre
6. Ejercicio de ejemplo para aplicar la Inyección de Dependencias
   - Creamos un nuevo package **domain**
     - Dentro creamos 4 clases:
       - Boleta
       - Cliente
       - ItemBoleta
       - Producto
     - Relación
       - Cliente 1---->n Boleta
       - Boleta n---->m Producto => Se genera Otra Tabla puente ItemBoleta
   - En una **Boleta** se puede tener una lista de **ItemBoleta**
   - Creamos el controlador **BoletaController** 
     - Que nos permita enviar una boleta a una vista html
     - Que la vista html nos permita renderizar la boleta
   - Creamos un método que me permita enviar la boleta a una vista
   - Creamos la vista **boleta.html**
   - Necesitamos crear un Objeto de tipo **Boleta**
     - Pero necesitamos lo siguiente:
       - **descripcion**
         - ¿En dónde podríamos generar esta descripción?
         - Podríamos crear un objeto y darle la descripción de manera explícita
         - Pero la idea es trabajarlo con **Inyección de Dependencias**
         - Para ello lo que haremos será simular una **Base de Datos**
           - Para lo cual generaremos algunos atributos en **application.properties**
           - Como **descripcion** y con @Value llevamos el valor de **application.properties** a la clase **Boleta**
           
       - **cliente**
         - Lo mismo con los atributos de cliente e inyectamos a la clase **Cliente**
         - **@Value** nos permite inyectar los valores a los atributos de **cliente**
         - Los valores de los atributos de Cliente hay que llevarlos a **Boleta**
         - Para ello hacemos uso de la **Inyección de Dependencias** con **@Autowired**
         - Pero para poder inyectar Cliente debe ser un componente con **@Component**
       - **List< ItemBoleta >**
         - **Problema** 
           - Al tener una lista de elementos en una boleta no se puede agregar solo un **@Componente** porque generaría solo un elemento.
         - **Solución** 
           - Crearemos nuestro propio archivo de configuración **AppConfig** generar ahí un **@Bean**
           - El cual haría la función de un **@Component** generar ahí nuestros items y luego llamarlos e inyectarlos en Boleta
           - Creamos **AppConfig** y le agregamos la anotación **@Configuration** para que se ejecute al arrancar el aplicativo
           - Le agregamos un **@Bean** el cual nos generará los ItemBoleta
           - El @Bean está haciendo las veces de @Component
           - Con una diferencia los @Component son propios de nuestra aplicación(Interface, Clase Concreta)
           - Mientras que los @Bean se usan en los archivos de configuración, no necesariamente son propios de nuestra aplicación, sino que podría ser algo fuera de (como la API de una aplicación externa)
           - Luego inyectamos en Boleta
           - Convertimos Boleta en un component
   - Inyectamos la Boleta en BoletaController
   - Luego se envía a la vista
   - Resultado
   ![img.png](src%2Fmain%2Fresources%2Fstatic%2Fimg.png)



