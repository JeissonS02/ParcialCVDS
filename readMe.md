# Parcial Segundo Corte CVDS
## Jeisson David Sanchez Gomez

### Sistema de pagos para EciCREDIT


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



![image](https://github.com/user-attachments/assets/e407b4db-c472-41ec-893a-27f0ac3eb35e)



