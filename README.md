# Fantur Agencia de viajes

Fantur es una agencia de viajes con multiples destinos para multiples bolsillos. Planifique sus vacaciones perfectas con nuestra agencia de viajes. Elija entre cientos de ofertas con todo incluido!


## Instalacion del proyecto
Prerequisitos

 - Git
 - Java 18
 - IDE para Java
 - Docker
<p align="left"> <a href="https://www.oracle.com/java/" target="_blank" rel="noreferrer"><img src="https://raw.githubusercontent.com/danielcranney/readme-generator/main/public/icons/skills/java-colored.svg" width="36" height="36" alt="Java" /></a> <a href="https://www.mysql.com/" target="_blank" rel="noreferrer"><img src="https://raw.githubusercontent.com/danielcranney/readme-generator/main/public/icons/skills/mysql-colored.svg" width="36" height="36" alt="MySQL" /></a> </p>
 

>    La administracion de la base de datos fue implementada en la nube
> por el proeveedor de cloud Azure. Para acceder a la misma solicitar
> datos de acceso a los administradores

## Construccion del proyecto

Para poder facilitar el desarrollo del proyecto se hizo uso de la herramienta Maven para poder gestionar y contruir el proyecto. Se hizo uso de las siguientes dependencias.![enter image description here](https://images.velog.io/images/pllap/post/9cefd5dd-bd0c-4382-aa25-6751e1cc9cec/file_type_maven_icon_130397.png)

## Ejcucion del proyecto

 

 1. Clonar repositorio

 3. Importar dependencias del proyecto con ***maven***
 4. Crear variables de entorno en el *IDE*  para definir las credenciales de acceso previamente solicitadas a los administradores a la base de datos. 
 
  

     ` DB_URL`
       ` DB_USER`
         `DB_PASSWORD`
         
 5. Iniciar servicio Turismo control
`docker run -d -p 8080:8080 frredacs/turismo-control:1.2`

 5. Iniciar proyecto.
 6. Acceder a la documentacion de la API REST
  `http://localhost:8081/swagger-ui/index.html#/`
