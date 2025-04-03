# Parcial Segundo Corte CVDS
## Jeisson David Sanchez Gomez

### Sistema de pagos para EciCREDIT

### Tecnologias utilizadas:

1.SpringBoot
2.Maven
3.Github Actions
4.Postman(Verificacion de endPoints)


1. Arquitectura del proyecto:

Diagrama de clases:

![image](https://github.com/user-attachments/assets/7ed457b1-b952-4e47-8b09-bbed28fd0f0b)


En este caso tenemos las clases Usuario, Pago y Articulo


## Usuario
```java
public class Usuario {
    @Id
    private String id;
    private String nombre;
    private String email;
}
```

## Articulo
```java
public class Articulo {
    private String id;
    private String nombre;
    private double precio;
    private int cantidad;
}
```

## Pago
```java
public class Pago {
    @Id
    private String id;
    private String usuarioId;
    private Date fecha;
    private String estado;
    private double total;
    private List<Articulo> articulos;
}
```



Diagrama de componentes:

![image](https://github.com/user-attachments/assets/8d2074db-b150-432a-87af-b6d8984e4bc2)


2.Creacion del proyecto e implementacion de metodos:

Estructura del proyecto:

![image](https://github.com/user-attachments/assets/b88c3278-2e82-4d1b-92b7-feed630e11a2)

Pruebas unitarias - Cobertura:

![image](https://github.com/user-attachments/assets/e25b0257-2d9a-471a-96c1-cbaa1945cbc4)

### Generacion del front

Hacemos uso de react y ejecutando

npx create-react-app payment-app

Una vez creado el proyecto creamos los componentes de registrar y consultar un pago y los añadimos a App.js


Para desplegar la app vamos al siguiente link el cual es el despliegue en azure: 
ecicreditjeisson-dsggbecbc9bahac0.canadacentral-01.azurewebsites.net

