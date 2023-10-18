# LAB7 AREP APLICACIÓN DISTRIBUIDA SEGURA EN TODOS SUS FRENTES

## INTRODUCCIÓN:

Desarrollar una aplicación web segura es esencial para proteger la información sensible y garantizar la privacidad de los usuarios. Este proyecto se centra en la implementación de una arquitectura robusta que cumpla con los requisitos de autenticación, autorización e integridad tanto para el acceso desde el navegador como para la comunicación entre computadoras y servicios remotos. Utilizando tecnologías como Spark SSL, Spring Boot con certificados autofirmados y servicios de AWS, se busca crear un prototipo sólido y escalable.

## RESUMEN:

La aplicación web desarrollada garantiza la seguridad desde múltiples aspectos. Para el acceso desde el navegador, se implementa una capa de seguridad basada en Spark SSL, asegurando la autenticación y autorización de usuarios, así como la integridad de los datos transmitidos. 

Además, se emplean certificados autofirmados (Carpeta keystore) para asegurar la comunicación entre al menos dos computadoras y los servicios remotos. Esto asegura que solo usuarios autorizados pueden invocar los servicios y mantiene la integridad de la información.

## OBJETIVOS:

Debe permitir un acceso seguro desde el browser a la aplicación. Es decir debe garantizar autenticación, autorización e integridad de usuarios.: Cumplido debes acceder y en los videos se evidencia el uso de SSL (https).

Debe tener al menos dos computadores comunicacndose entre ellos y el acceso de servicios remotos debe garantizar: autenticación, autorización e integridad entre los servicios. Nadie puede invocar los servicios si no está autorizado. Cumplido, de forma local se probo en diferentes puertos y en AWS tambien pero se crearon dos instancias diferetes simulando los dos computadores.


## Escalamiento de la arquitectura de seguridad para incorporar nuevos servicios.

Se debe mantener una jerarquía clara de certificados para garantizar la seguridad en la comunicación entre servicios y  usar buenas practicas de diseño, se podria manejar alguna informacion en un base de datos para no tener que ponerla sobre codigo y su almacenamiento y control sea mas sencillo, usando la persistencia.

## PRUEBAS DE FUNCIONAMIENTO

### VIDEO FUNCIONAMINETO DE MANERA LOCAL:

https://www.youtube.com/watch?v=4hfWkyvDKWs

#### Intrucciones: 

1 .Se clona el prpyecto en tu computador, puedes usar la linea de comandos con ayuda de git.

git clone path_github

2. Luego puedes correr las dos clases SecureSpark y SecureSpark2 o otra opcion correrlo por linea de comandos.

### VIDEO FUNCIONAMIENTO EN AWS:

https://www.youtube.com/watch?v=VTNaIyFQDl0

#### Intrucciones: 

1 .Se clona el prpyecto en tu computador, puedes usar la linea de comandos con ayuda de git.

git clone path_github

2 .Se abren 2 linea de comandos y en cada una se ejecuto una instancia de aws.

3. Entras a la carpeta target o no hay necesidad con el comando correspondiente para hacerlo por fuera de target.

4. En uno ejecuta el comando a) y en el otro el comando b)

   comando a):java -cp "classes:dependency/*" com.mycompany.securespark.SecureSpark
   comando b):java -cp "classes:dependency/*" com.mycompany.securespark.SecureSpark2

### REQUERIMIENTOS

1. Instalar java 17 en las instancias.
2.  Podrias instalar maven y git tambien para poder hacer el clone y luego mvn clean install para obtener el package y luego correrlo o otra opcion tambien podria ser hacer el target en tu maquina local y transportarlo de la siguiente manera:

scp -i C:/Users/dalum/OneDrive/Escritorio/lab7/awsseguridad.pem C:/Users/dalum/OneDrive/Escritorio/LAB7AREP/target.zip ec2-user@ec2-54-88-80-32.compute-1.amazonaws.com:~

scp -i C:/Users/dalum/OneDrive/Escritorio/lab7/awsseguridaddos.pem C:/Users/dalum/OneDrive/Escritorio/LAB7AREP/target.zip  ec2-user@ec2-54-82-184-135.compute-1.amazonaws.com:~

Nota: Recuerda reemplazar los paths.
   
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


