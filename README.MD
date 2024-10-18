# Conversor de Monedas

## Descripción

El **Conversor de Monedas** es una aplicación que permite a los usuarios convertir una cantidad de dinero de una divisa a otra utilizando tasas de cambio en tiempo real. La aplicación se conecta a la API de tasas de cambio y proporciona resultados precisos y actualizados.

## Tecnologías Utilizadas

- Java 17 o superior
- Biblioteca Gson para el manejo de JSON
- API de tasas de cambio (https://v6.exchangerate-api.com/)
- JDK 11 o superior
- IntelliJ IDEA (IDE recomendado)

## Estructura del Proyecto

src │ ├── conversor │ ├── ApiClient.java # Clase para manejar solicitudes a la API │ ├── ConvertidorDeMoneda.java # Clase principal de la aplicación │ ├── RespuestaTasaCambio.java # Clase que representa la respuesta de la API │ └── ServicioTasasDeCambio.java # Clase para obtener tasas de cambio │ └── ... # Otros archivos relevantes


## Requisitos

- JDK 11 o superior
- Conexión a Internet para acceder a la API de tasas de cambio

## Instalación

1. Clona el repositorio:
   ```bash
   git clone https://github.com/tu-usuario/nombre-del-repositorio.git
Navega al directorio del proyecto:

cd nombre-del-repositorio
Abre el proyecto en tu IDE (recomendado: IntelliJ IDEA).

Asegúrate de que tienes la biblioteca Gson incluida en tu proyecto. Si no, descárgala y agrégala a tu proyecto.

Uso
Ejecuta la clase ConvertidorDeMoneda.java.
Introduce la divisa base (por ejemplo, USD).
Introduce la divisa de destino (por ejemplo, EUR).
Introduce la cantidad a convertir.
La aplicación mostrará el resultado de la conversión.
Ejemplo
Ingrese la divisa base (ej. USD): USD
Ingrese la divisa de destino (ej. EUR): EUR
Ingrese la cantidad a convertir: 100
100.00 USD hoy equivale a 85.67 EUR

Manejo de Errores
La aplicación maneja diversos errores, como:

Entrada de divisas inválidas.
Cantidades negativas.
Errores en la conexión a la API.
Contribuciones
Si deseas contribuir a este proyecto, por favor sigue estos pasos:

Haz un fork del repositorio.
Crea una nueva rama (git checkout -b nueva-rama).
Realiza tus cambios y haz commit (git commit -m 'Agregando nueva funcionalidad').
Envía tus cambios al repositorio (git push origin nueva-rama).
Crea un Pull Request.
Licencia
Este proyecto está bajo la Licencia MIT. Consulta el archivo LICENSE para más detalles.

Contacto
Si tienes preguntas o sugerencias, no dudes en contactarme:

Nombre: Jose Garcia Lopez
Email: gestarsoft@gmail.com
GitHub: https://github.com/jgarcia-my-apps/challenge-conversor-de-moneda