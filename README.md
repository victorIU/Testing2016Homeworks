# SesionTesting03

Las siguientes clases, representan el módulo de productos de un pequeño sistema de bodega para un tienda de instrumentos músicales, implementado en Java. En el módulo existen las clases Categoría, Producto y Existencia, más la clase ExcepcionDeProducto (lanzada por algunos métodos) que por ahora se encuentra en blanco.  La lógica del módulo es : 

Todos los productos tienen una categoría, por ejemplo existen las categorías: Guitarras Eléctricas, Guitarras Acústicas. 

Los productos tienen un nombre, un stock (que corresponde al stock actual del producto), un stock mínimo y un stock máximo. Algunos productos además, tienen una categoría.   Por ejemplo, dentro de la categoría “Guitarras Eléctricas”, existen un producto cuyo nombre es “Guitarra Gibson Les Paul Studio” . Este producto tienen un stock mínimo de 5, y un stock máximo de 10, que corresponden a las existencias mínimas que debe tener ese producto.    

Las existencias corresponden a cada uno de los items que existen de un producto en particular. Por ejemplo, si a la tiendan llegan 7 guitarras “Guitarra Gibson Les Paul Studio”, eso quiere decir que al Producto ““Guitarra Gibson Les Paul Studio” se le deben agregar 7 existencias. Al hacer esto, el stock actual del producto ““Guitarra Gibson Les Paul Studio” es 7.   Cuando queremos vender una de estas existencias, desde el producto, obtenemos la última existencia ingresada. 

Finalmente, respecto a las clases podemos comentar lo siguiente: 

La clase Existencia tiene un número interno que se guarda en formato String (para poder usar espacios o separadores).  Este número se recibe en el constructor, y el único método público, es para retornar dicho número. Este atributo no debería ser nulo o blanco. 

La clase Categoría almacena almacena un nombre y código, ambos en String (para poder usar espacios o separadores). Estos parámetros son necesarios en el constructor, y existen métodos públicos para obtener y setear estos valores.  Ambos atributos no pueden ser nulos o blancos y categoría debería ser de tamaño máximo 5. 

La clase producto dispone de un método addExistencia, para agregar una nueva existencia, y getProximaExistencia, que devuelve la última existencia ingresada, descontándola del stock. Además, se dispone de un método llamado “getCodigoProximaExistencia” que devuelve el código de la última existencia ingresada (que será la próxima a ser vendida) y que esta compuesto por el código de la categoría, un “-”, y el número de la existencia. Por ejemplo, si el código de la categoría Guitarras eléctricas es “12345”, el código de la existencia cuyo número es “990012” es “12345-990012” . Si el producto no tiene categoría, entonces se devuelve el string “XXXXX” como código de categoría. 



