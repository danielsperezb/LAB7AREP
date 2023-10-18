# LAB7 AREP: APLICACIÓN DISTRIBUIDA SEGURA EN TODOS SUS FRENTES

## INTRODUCCIÓN

El desarrollo de una aplicación web segura es crucial para salvaguardar información sensible y garantizar la privacidad de los usuarios. Este proyecto se enfoca en implementar una arquitectura robusta que cumple con los requisitos de autenticación, autorización e integridad, tanto para el acceso desde el navegador como para la comunicación entre computadoras y servicios remotos. Utilizando tecnologías como Spark SSL, Spring Boot con certificados autofirmados y servicios de AWS, buscamos crear un prototipo sólido y escalable.

## RESUMEN

La aplicación web desarrollada garantiza la seguridad desde múltiples perspectivas. Para el acceso desde el navegador, se implementa una capa de seguridad basada en Spark SSL, asegurando la autenticación, autorización de usuarios y la integridad de los datos transmitidos.

Además, se emplean certificados autofirmados (carpeta keystore) para asegurar la comunicación entre al menos dos computadoras y los servicios remotos. Esto garantiza que solo usuarios autorizados puedan invocar los servicios y mantiene la integridad de la información.

## OBJETIVOS

1. **Documentación del código:** Cumplida, evidenciada en el último commit llamado "Documentación".

2. **Acceso seguro desde el navegador a la aplicación:** Cumplido, se accede mediante HTTPS, como se muestra en los videos.

3. **Comunicación entre al menos dos computadoras y acceso a servicios remotos:** Cumplido, probado localmente en diferentes puertos y en AWS con dos instancias diferentes simulando dos computadoras.

## Escalamiento de la Arquitectura de Seguridad para Incorporar Nuevos Servicios

Se mantiene una jerarquía clara de certificados para garantizar la seguridad en la comunicación entre servicios y se aplican buenas prácticas de diseño. Se considera el manejo de información en una base de datos para simplificar su almacenamiento y control mediante la persistencia.

## PRUEBAS DE FUNCIONAMIENTO

### VIDEO FUNCIONAMIENTO DE MANERA LOCAL:

[Ver Video](https://www.youtube.com/watch?v=4hfWkyvDKWs)

#### Instrucciones:

1. Clonar el proyecto en tu computadora usando la línea de comandos con git: `git clone path_github`.  Debes ir al commit donde realice esto "Funcionamiento de manera Local" Link: https://github.com/danielsperezb/LAB7AREP/commit/fb0480cdfa6277ab70ea0c20be49945f790a003f
2. 
3. Ejecutar las clases `SecureSpark` y `SecureSpark2`, o utilizar la línea de comandos.

### VIDEO FUNCIONAMIENTO EN AWS:

[Ver Video](https://www.youtube.com/watch?v=VTNaIyFQDl0)

#### Instrucciones:

1. Clonar el proyecto en tu computadora usando la línea de comandos con git: `git clone path_github`.
2. Abrir 2 líneas de comandos y ejecutar una instancia de AWS en cada una.
3. Entrar a la carpeta target o utilizar el comando correspondiente para acceder desde afuera de target.
4. En una instancia ejecutar el comando a), y en la otra el comando b):

   - Comando a): `java -cp "classes:dependency/*" com.mycompany.securespark.SecureSpark`
   - Comando b): `java -cp "classes:dependency/*" com.mycompany.securespark.SecureSpark2`

### REQUERIMIENTOS

1. Instalar Java 17 en las instancias.
2. Opcional: Instalar Maven y Git para clonar y ejecutar `mvn clean install` para obtener el paquete, o transferirlo desde tu máquina local.

3. Cambiar URLs, a donde van los servidores ya que si el creador del proyecto o tú crean otro, este cambiará. Nota: Recuerda reemplazar los paths.

## DESCRIPCIÓN DE LA ARQUITECTURA DE SEGURIDAD

La clase `URLReader` proporciona métodos para realizar solicitudes HTTPS a una URL con configuración de seguridad. Aquí hay una breve descripción de la arquitectura de seguridad:

**Configuración del Keystore:**

- La clase utiliza un archivo keystore (`eciKeyStoreFile`) y una contraseña (`password`) para cargar un truststore.
- El truststore se utiliza para almacenar certificados de confianza, permitiendo establecer una conexión segura con el servidor.

**TrustManagerFactory:**

- La clase utiliza `TrustManagerFactory` para inicializar los trust managers a partir del truststore cargado.
- Los trust managers son responsables de decidir qué certificados de servidor son aceptables.

**SSLContext:**

- Se crea una instancia de `SSLContext` y se inicializa con los trust managers obtenidos de `TrustManagerFactory`.
- Este contexto SSL se establece como el contexto SSL predeterminado para todas las conexiones.

**Lectura de la URL:**

- La clase utiliza un objeto `URLConnection` para abrir una conexión a la URL proporcionada.
- Se leen los campos del encabezado de la respuesta y se muestran.
- Se lee el cuerpo del mensaje de la respuesta.

**Manejo de Excepciones:**

- La clase maneja varias excepciones relacionadas con la carga de keystore, la configuración de SSL, la lectura de URL, etc.

## Construido con

- [Maven](https://maven.apache.org/): Herramienta de administración de dependencias para proyectos Java.

- [README](https://gist.github.com/PurpleBooth/109311bb0361f32d87a2): Este README se creó siguiendo la plantilla de [PurpleBooth](https://gist.github.com/PurpleBooth).

Además, el proyecto se construyó utilizando las siguientes tecnologías y herramientas:

- **Java**: Lenguaje de programación principal.

- **Spark Framework**: Utilizado para la creación del servidor web en el microservicio de registro distribuido.

- **AWS**: Infraestructura en la nube utilizada para el despliegue de máquinas virtuales.

## Autores

- **Daniel Esteban Perez Bohorquez**

## Licencia

Este proyecto está bajo la Licencia MIT. Consulta el archivo [LICENSE.md](LICENSE.md) para obtener más detalles.

## Agradecimientos

- Escuela Colombiana de Ingeniería
