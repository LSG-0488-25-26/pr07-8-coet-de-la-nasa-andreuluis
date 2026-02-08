# 🧪 Rick and Morty App 🧪

## Descripción del Proyecto

Este proyecto es una aplicación Android nativa que sirve como una completa enciclopedia de la serie **"Rick and Morty"**.  
La aplicación consume la API pública de Rick and Morty para mostrar información detallada sobre **personajes**.

La arquitectura utiliza **MVVM**, y está construida íntegramente con **Jetpack Compose**.  
Además, incluye funcionalidades avanzadas como **persistencia de datos**, **búsqueda en tiempo real** y una **sección de favoritos**.

---

## Funcionalidades Principales

- **Exploración Completa**  
  Visualiza listas de personajes.

- **Detalle Extenso**  
  Accede a una vista de detalle para cada elemento.

- **Navegación Moderna**  
  Interfaz intuitiva con una **Bottom Navigation Bar** para cambiar entre las secciones principales.

- **Búsqueda Inteligente**  
  Una barra de búsqueda (**SearchBar**) permite filtrar personajes en tiempo real.

- **Persistencia de Datos con Room**  
  La aplicación guarda los datos en una base de datos local, lo que permite:
  - **Modo Offline**: Acceso a los datos previamente cargados sin conexión a internet.
  - **Rendimiento Mejorado**: La carga inicial de datos es casi instantánea al obtenerlos desde la base de datos local.

- **Gestión de Favoritos**  
  Marca tus personajes favoritos y visualízalos en una sección dedicada.

- **Carga Eficiente de Imágenes**  
  Las imágenes se cargan y cachean desde internet usando **Coil**.

---

## Arquitectura y Tecnologías Clave

El proyecto está construido sobre una base sólida y moderna, combinando las siguientes tecnologías y patrones.

### 1. Arquitectura MVVM (Model - View - ViewModel)

La aplicación se divide en tres capas lógicas para lograr un código limpio, escalable y fácil de testear:

#### View (UI con Jetpack Compose)
- Pantallas declarativas y reactivas (`CharacterListScreen`, `DetailScreen`).
- Navegación gestionada por **Navigation Compose**, con una **Bottom Navigation Bar** para las secciones principales.
- Componentes de **Material 3** como `Scaffold`, `SearchBar` y `Card`.

#### ViewModel
- Actúa como intermediario, preparando los datos para la UI.
- Utiliza **Corrutinas de Kotlin** y `viewModelScope` para gestionar operaciones asíncronas de forma segura.
- Expone el estado de la UI mediante **StateFlow**, permitiendo que las vistas reaccionen a los cambios.

#### Model (Capa de Datos)
- **Repositorio**  
  Es la única fuente de verdad (**Single Source of Truth**). Centraliza la lógica de datos y decide si obtenerlos desde la base de datos local o desde la red.
- **Retrofit & Gson**  
  Comunicación con la API REST. Retrofit ejecuta las peticiones HTTP y Gson convierte las respuestas JSON en objetos de datos (`ApiCharacter`).
- **Room**  
  Base de datos local que almacena los datos obtenidos de la API, proporcionando persistencia y soporte offline.

---

### 2. Flujo de Datos (Single Source of Truth)

El repositorio implementa una estrategia de **fuente única de verdad** para garantizar la consistencia de los datos:

1. El **ViewModel** solicita los datos al **Repositorio**.
2. El **Repositorio** obtiene primero los datos desde **Room**, haciendo que la app se sienta instantánea.
3. En paralelo, realiza una llamada a la API mediante **Retrofit** para buscar actualizaciones.
4. Si se reciben datos nuevos, estos se guardan en **Room**, sobrescribiendo los antiguos.
5. **Room**, al trabajar con `Flow`, notifica automáticamente a la UI de cualquier cambio, manteniendo la pantalla siempre actualizada.

---

## Tecnologías Utilizadas

- **Lenguaje**: Kotlin  
- **UI Toolkit**: Jetpack Compose  
- **Arquitectura**: MVVM (Model-View-ViewModel)  
- **Asincronía**: Coroutines  
- **Red**: Retrofit & OkHttp  
- **Parseo JSON**: Gson  
- **Base de Datos**: Room  
- **Navegación**: Navigation Compose  
- **Carga de Imágenes**: Coil  

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

## Conclusión

Este proyecto combina una arquitectura sólida (**MVVM**) con las herramientas más actuales del ecosistema Android —**Jetpack Compose, Room, Retrofit y Corrutinas**— para crear una experiencia de usuario fluida, eficiente y funcional incluso sin conexión.
