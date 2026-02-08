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


###  Lista de personajes con búsqueda y botones
![1](https://github.com/user-attachments/assets/82a3a060-0d0a-4c6b-bbb6-4e5ef9635839)

###  Detalle del personaje
![3](https://github.com/user-attachments/assets/fa2a8ba5-a3ba-4d1f-97a3-fa2e5e1c3c39)

###  Búsqueda del personaje
![2](https://github.com/user-attachments/assets/18f93c2f-a770-4ab8-a50f-a0d7ca849b8b)

###  Lista de personajes favoritos
![4](https://github.com/user-attachments/assets/d1489f8c-d970-4ead-8a25-a146bac9939b)


---

##  Conclusión

En este proyecto se combina una arquitectura robusta (**MVVM**) con herramientas modernas de Androidw para crear una aplicación funcional y bien estructurada que consume datos de una API externa.


