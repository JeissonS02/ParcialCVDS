# Parcial Segundo Corte CVDS
## Jeisson David Sanchez Gomez

### Sistema de pagos para EciCREDIT


1. Arquitectura del proyecto:

Diagrama de clases:



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


