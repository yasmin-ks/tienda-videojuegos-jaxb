# Tienda de videojuegos (JAXB)

Práctica de Java con **JAXB (Jakarta XML Binding)**: lee y modifica un fichero XML que representa el catálogo de una tienda de videojuegos, convirtiéndolo en objetos Java y guardando los cambios de vuelta en el XML.

## Qué hace

- **Lee** el XML y lo convierte en objetos Java (*unmarshal*).
- **Consulta** los datos con streams: muestra todos los títulos, los juegos de una plataforma, los juegos sin stock y el precio medio.
- **Modifica** el catálogo: añade y elimina juegos, cambia el país de un estudio y sube el precio de los juegos de un estudio un porcentaje dado.
- **Guarda** los cambios en el XML con salida formateada (*marshal*).

## Tecnologías

- Java
- Maven
- Jakarta XML Binding (JAXB) 4.0

## Estructura del proyecto

```
proyectoJAXB
├── datos/
│   └── ficheroXML.xml          # Datos de ejemplo
└── src/main/
    ├── java/yks/
    │   ├── app/Main.java       # Clase para probar el programa
    │   ├── logica/
    │   │   └── GestionTienda.java   # Lógica de lectura y escritura del XML
    │   └── model/              # Clases anotadas con JAXB
    │       ├── Tienda.java
    │       ├── Juego.java
    │       ├── Titulo.java
    │       └── Estudio.java
    └── resources/
        └── app.properties      # Ruta del fichero XML
```

## Ejemplo de XML

```xml
<tienda nombre="GameZone Madrid">
    <juegos>
        <juego codigo="VJ-001">
            <titulo plataforma="PS5">Elden Ring</titulo>
            <estudio>
                <pais>Japón</pais>
                <nombre>FromSoftware</nombre>
            </estudio>
            <anio>2022</anio>
            <precio>59.99</precio>
            <stock>true</stock>
        </juego>
    </juegos>
</tienda>
```

## Anotaciones de JAXB utilizadas

| Anotación | Para qué se usa |
|---|---|
| `@XmlRootElement` | Marca `Tienda` como elemento raíz del XML |
| `@XmlAccessorType(FIELD)` | JAXB accede directamente a los campos |
| `@XmlAttribute` | Campos que son atributos (`nombre`, `codigo`, `plataforma`) |
| `@XmlElement(name = ...)` | Renombra un campo en el XML (`hayStock` → `stock`) |
| `@XmlElementWrapper` | Envuelve la lista de juegos en `<juegos>` |
| `@XmlValue` | El texto del elemento `<titulo>` |
| `@XmlType(propOrder = ...)` | Fija el orden de los elementos de `Estudio` |
| `@XmlTransient` | Excluye `valoracionInterna` del XML |

## Cómo ejecutarlo

1. Clona el repositorio.
2. Importa el proyecto como **proyecto Maven** en tu IDE (Eclipse, IntelliJ...).
3. Ejecuta la clase `yks.app.Main`.

La ruta del XML se configura en `src/main/resources/app.properties`:

```properties
ruta = datos/ficheroXML.xml
```
