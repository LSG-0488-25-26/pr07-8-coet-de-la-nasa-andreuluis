# 🧪 Rick and Morty 🧪

##  Descripción del Proyecto

Este proyecto es una aplicación Android que muestra información de **personajes, episodios y localizaciones** de la serie *Rick and Morty*.

La aplicación se conecta a la **API pública de Rick and Morty** para obtener los datos en tiempo real, sin necesidad de guardarlos dentro de la aplicación.

---

##  Funcionalidades Principales

-  Lista de personajes  
-  Detalle de cada personaje   
-  Navegación entre pantallas  
-  Carga de imágenes desde Internet con la API

---

##  1. Conexión a la API (Retrofit + Gson)

Para obtener los datos usamos dos librerías esenciales:

### - Retrofit  
Retrofit simplifica la comunicación con la API.  
Permite definir las peticiones HTTP (como obtener todos los personajes) como funciones de Kotlin.

### - Gson  
La API devuelve los datos en formato **JSON**.  
Gson convierte automáticamente ese JSON en **data class** de Kotlin para poder trabajar con los datos fácilmente.

---

##  2. Arquitectura MVVM (Model - View - ViewModel)

El proyecto sigue el patrón **MVVM**.

###  View 
- Construida con **Jetpack Compose**  
- Muestra los datos al usuario  
- Captura las interacciones del usuario  

###  ViewModel  
- Solicita los datos al repositorio  
- Prepara los datos para la vista  
- Sobrevive a cambios de configuración

###  Model  
- Contiene la lógica de negocio y los datos  
- Incluye el **Repositorio**, que gestiona la obtención de datos desde la API.

Esta arquitectura hace el código más organizado, fácil de mantener y testear.

---

##  3. Interfaz de Usuario con Jetpack Compose

Toda la interfaz está creada con **Jetpack Compose**.

###  MainActivity.kt  
- Punto de entrada de la aplicación  
- Configura el tema  
- Inicializa la navegación  

###  Navegación  
- Se utiliza **Navigation Compose**  
- `RickAndMortyNavHost` gestiona las diferentes pantallas  
- Permite navegar entre lista y detalle de personajes.

###  Imágenes  
- Se utiliza **Coil** para cargar imágenes desde Internet  
- Optimizado para Jetpack Compose  

---

##  Tecnologías Utilizadas

- Kotlin  
- Jetpack Compose  
- Retrofit  
- Gson  
- Coroutines  
- MVVM Architecture  
- Navigation Compose  
- Coil  

---

##  Capturas de Pantalla


###  Lista de personajes
<img width="342" height="762" alt="image" src="https://github.com/user-attachments/assets/e7f447a1-b693-4a71-afd6-e9d601cdb9b2" />

###  Detalle del personaje
<img width="336" height="758" alt="image" src="https://github.com/user-attachments/assets/b4901712-1543-4884-8236-1b7a5a55df71" />


---

##  Conclusión

En este proyecto se combina una arquitectura robusta (**MVVM**) con herramientas modernas de Androidw para crear una aplicación funcional y bien estructurada que consume datos de una API externa.

