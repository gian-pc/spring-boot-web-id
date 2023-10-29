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




