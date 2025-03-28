# weather-API-Rest

Este proyecto implementa la automatización de pruebas para una API REST de consulta del clima por nombre de ciudad, utilizando el framework Serenity BDD y Cucumber.

### 📋 Descripción
La automatización incluye la verificación de:
- El código de respuesta HTTP.
- La estructura del JSON recibido.
- La presencia de datos específicos en la respuesta.

### 🛠️ Características del Proyecto
- **Uso de BDD (Behavior-Driven Development)** para escribir pruebas en un lenguaje natural (Gherkin).
- **Cucumber** para la definición de escenarios en lenguaje Gherkin.
- **Rest-Assured** Librería para interacciones con APIs REST.
- **Apache POI:** Herramienta para la parametrización dinámica de datos desde archivos Excel ofreciendo pruebas más versátiles y reutilizables.

## 📂 Estructura
```
src
├── main
│   ├── java
│   │   └── com.weatherapi
│   │       ├── constants
│   │       ├── questions
│   │       ├── tasks
│   │       └── utils
│   └── resources
└── test
    ├── java
    │   └── com.weatherapi
    │       ├── runners
    │       └── stepDefinitions
    └── resources
        └── features
```
# ⚙️ Cómo Ejecutar el Proyecto

## 1. Requisitos Previos:

- Java JDK 11 Correto.
- Gradle configurado en el entorno.
- Una conexión activa a internet para consumir la API pública.


## 2. Clonar el Repositorio:
`git clone https://github.com/pagutierrezd/weather-API-Rest.git`

## 3. Ejecutar desde el Runner:
- Navega a la clase en `src/test/java/com/weatherapi/runners`.
- Haz clic derecho sobre la clase `GetCityWeatherRunner` y selecciona "Run".

### 📌 Próximos Pasos
- Implementar más escenarios de prueba para validar otras funcionalidades de la API.
- Añadir validaciones adicionales en los datos de la respuesta.