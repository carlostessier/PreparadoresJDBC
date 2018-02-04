**CURSO: 2017/18**

**SEMANA: 21**

**CONTENIDO: ENUNCIADOS EJERCICIOS JDBC**

**MATERIAL ELABORADO POR: Carlos Tessier Fdez**

1. Crear una base de datos en MySQL con nombre EJEMPLO y un usuario con el mismo nombre.

Crea en la base de datos EJEMPLO dos tablas:

- Departamento, con los campos dept\_no, dnombre y loc
- Empleado, con los campos nombre, apellido, oficio, fecha\_alt, salario, comision y la clave foranea dept\_no de la tabla Departamento

Insertar al menos 3 filas en cada una de las filas.

Implementar un programa en Java que mediante JDBC que tenga los siguientes métodos:

- Crear un método que devuelva en todos los objetos empleados de un departamento dado.
- Crear un método que pida por al usuario un departamento e imprima el Apellido, oficio y salario de los empleados de ese departamento.
- Crear un método que devuelva el objeto empleado con el máximo salario.
- Crear un método que imprima por pantalla el nombre, apellidos y salario del empleado con máximo salario.
- Crear un método que reciba un objeto empleado y que lo añada a la base de datos.
- Crea un método que pida al usuario por los datos de un empleado, comprobando que:

- El departamento exista en la tabla DEPARTAMENTOS.
- El número de empleado no exista
- Que el salario sea mayor que cero.
- Que el director exista en la tabla de empleados.


1. Leer el código de Conexion y AyudanteDB.
  1. Ejecuta Test.java y verifica que se realizar la conexión a BD correctamente
2. Lee el código de las dos clases anteriores y asegúrate de entenderlo.
  1. Ejecuta PruebaCafes.java y verifica que funciona correctamente
  2. Implementa los siguientes métodos de interfazCafes en la clase Cafes.java:
    1. Un método que busque un café por nombre y muestre los datos de ese café
    2. Un método que dado un nombre de café borre los datos de ese café
    3. Un método que dados los datos de un café inserte una fila
  3. Después añade llamadas a estos métodos en PruebaCafes.java para comprobar que funcionan correctamente
3. Reescribe los 3 métodos de la actividad anterior para utilizar preparedStatements en lugar de Staments y comprobar lo eficiente que es para realizar consultas parametrizada
4. En Cafes.java del ejercicio anterior implementa el método para que reciba un identificador de proveedor y muestre de los datos de todos los cafés asociados a ese proveedor. También tiene que mostrar los datos del proveedor
5. Crea una clase llamada Libros, siguiendo la estructura del ejercicio2, que tenga los siguientes métodos de acceso a datos para la tabla libros de la BD librería:

- anadirLibro recibe todos los datos necesarios
- borraLibro recibe el ISBN
- verCatalogo muestra todos los libros ordenadores por título ascendente
- actualizarCopias recibe el ISBN y el nuevo número de copias

Desarrolla una clase de prueba con método main para probar todos los métodos anteriores. Recuerda realizar una gestión de excepciones adecuada como se ha visto en clase.

1. Añade el siguiente método a tu clase Libros, pruébalo, ¿Qué hace este método?

```

private static final String SELECT_CAMPOS_QUERY = "SELECT * FROM LIBROS LIMIT 1";
public String[] getCamposLibro() throws AccesoDatosException {
       
        /*Sentencia sql con parámetros de entrada*/
        pstmt = null;
        /*Conjunto de Resultados a obtener de la sentencia sql*/
        rs= null;
        ResultSetMetaData rsmd = null;
              
        String[] campos = null;


        try {

            //Solicitamos a la conexion un objeto stmt para nuestra consulta
            pstmt = con.prepareStatement(SELECT_CAMPOS_QUERY);

            //Le solicitamos al objeto stmt que ejecute nuestra consulta
            //y nos devuelve los resultados en un objeto ResultSet
            rs = pstmt.executeQuery();
            rsmd = rs.getMetaData();
            int columns = rsmd.getColumnCount();
            campos = new String[columns];
            for (int i = 0; i < columns; i++) {
                //Los indices de las columnas comienzan en 1
                campos[i] = rsmd.getColumnLabel(i + 1);
            }
            return campos;


        } catch (SQLException sqle) {
			// En una aplicación real, escribo en el log y delego
			Utilidades.printSQLException(sqle);
			throw new AccesoDatosException(
					"Ocurrió un error al acceder a los datos");

		} finally{
			liberar();
		}
	}


```


1. Añade un método nuevo verCatalogoInverso a la clase libros para que muestre el catálogo en orden inverso al alfabético. Debes utilizar la misma consulta que ya tienes para mostrar el catálogo en orden alfabético. Resuélvelo utilizando un tipo adecuado de Resultset y los métodos vistos en clase de esta interfaz. (Con insensitive y concur updatable)
Desarrolla una clase java con método main para probar el nuevo método.
2. Realiza una nueva versión del método actualizarCopias de la clase Libros. Esta nueva versión recibe un Hashmap que contiene el nuevo número de copias para cada isbn. Este nuevo número de copias se lo tienes que sumar al actual. Resuélvelo con la consulta SELECT\_LIBROS\_QUERY utilizando un tipo de ResultSet adecuado. Desarrolla una clase java con método main para probar el nuevo método.
3. Añade un método a la clase Libros que reciba un listado con números de filas a mostrar. Los números no tienen por qué ser consecutivos ni estar ordenados. Resuélvelo con la consulta SELECT\_LIBROS\_QUERY utilizando un ResultSet adecuado y sus métodos. Desarrolla una clase java con método main para probar el nuevo método.
4. Añade un nuevo campo precio a la tabla Libros. Añade un nuevo método a la clase Libros que reciba un float indicando el precio por página de cada libro. Este método debe consultar las páginas de cada libro, multiplicar por el precio por página y rellenar la columna precio de cada libro. Resuélvelo con la consulta SELECT\_LIBROS\_QUERY utilizando un ResultSet adecuado y sus métodos. Desarrolla una clase java con método main para probar el nuevo método.
5. Añade un nuevo método a la clase libros que reciba dos isbn y un float que indica el precio por página, este método realizará lo siguiente:

1.
  1. Consultará las páginas de los dos libros y calculará el precio para los dos.
  2. Actualizará para ambos libros el precio con el precio máximo obtenido del cálculo anterior.
  3. Las 2 operaciones de actualización  de precio de los libros tienen que ser una transacción

Desarrolla una clase java con método main para probar el nuevo método.

1. Añade un nuevo método a la clase libros que reciba un isbn, un número de páginas y un float que indica el precio por página, este método realizará lo siguiente:

1. Sumará el número de páginas a las páginas actuales que ya tiene el libro
2. Calcula el precio multiplicando el total de páginas por el precio por página
3. Actualiza el precio del libro
4. Las 2 operaciones de actualización ser una transacción
5. Resuélvelo utilizando ResultSet.CONCUR\_UPDATABLE

Desarrolla una clase java con método main para probar el nuevo método. Fíjate bien lo sencillo que resulta realizar una transacción con .CONCUR\_UPDATABLE cuando los cambios afectan al mismo ResultSet.

1. Añade un nuevo método a la clase libros que reciba dos isbn y realice lo siguiente:

1. Consultará los datos del primer isbn
2. Insertará una nueva fila con el segundo isbn copiando el resto de datos de los obtenidos en la consulta anterior.
3. Debes resolverlo utilizando sólo la consulta del primer isbn y un resultset de tipo adecuado.

1. Añade un método a la clase Cafes.java llamado transferencia que reciba 2 nombres de café. El método realiza lo siguiente:

1. Consulta las ventas del primer café
2. Suma a las ventas del segundo café las del primero
3. Pone a 0 las ventas del primer café
4. Las 3 operaciones tienen que ser una transacción

 Desarrolla una clase java con método main para probar el nuevo método.

1. Desarrolla una nueva versión del ejercicio anterior para que el acceso a datos se realice mediante un patrón DAO. Recuerda que tienes que definir:

1. Una clase Cafe para representar objetos Cafe del modelo
2. Una interfaz CafeDAO que defina los métodos de acceso a datos a implementar independientemente de la tecnología subyacente
3. Una clase JDBCCafeDAO que implemente los métodos de acceso a datos para la tecnología JDBC
4. Una clase FactoriaDAO encargada de instanciar los DAO adecuados
5. Una clase de prueba con método main que representa la lógica de la aplicación
No olvides de realizar una definición y gestión de excepciones adecuada

1. Vamos a completar el ejercicio anterior añadiendo las clases necesarias para gestionar el acceso a datos de los proveedores de café. Tienes que desarrollar lo siguiente:

1. Una clase Proveedor para representar objetos proveedor del modelo
2. Una interfaz ProveedorDAO que defina los métodos de acceso a datos a implementar independientemente de la tecnología subyacente:

1.
  1.
    1. Define un método para insertar un proveedor que reciba un objeto Proveedor
    2. Define un método para buscar un proveedor por id que devuelva un objeto Proveedor

1. Una clase JDBCProveedorDAO que implemente los métodos de acceso a datos para la tecnología JDBC
2. En la clase FactoriaDAO tienes que añadir un método getProveedorDAO
3. En la clase de prueba con método main añade el código necesario para insertar un proveedor nuevo y después buscarlo por id y mostrar los datos por pantalla

1. En la solución del Ejercicio anterior vamos a ampliar la funcionalidad para:

1. Dado un id de proveedor obtener todos los datos de los cafés que provee. Piensa en que DAO debes implementarlo y como tiene que ser la signatura del método. Después impleméntalo.
2. En la clase de prueba que representa la lógica añade el código necesario para que a partir de un identificador de proveedor:

1.
  1.
    1. Obtenga y muestre por pantalla todos los datos de ese proveedor
    2. Obtenga y muestre por pantalla los datos de todos los cafés asociados a ese proveedor

1. En la empresa en la que trabajas te han solicitado desarrollar una aplicación de gestión de alumnos para la escuela de informática. Ejecuta en tu BD mysql el script alumnos-asignaturas.sql. Una vez ejecutado mira el modelo de datos y asegúrate de entenderlo
 Sólo vamos a desarrollar algunas funciones:

1. a)Dar de alta un alumno: se deberán proporcionar los datos del alumno
2. b)Eliminar un alumno: se deberá proporcionar el id del alumno
3. c)Matricular a un alumno en asignaturas: se identificará al alumno y a las asignaturas
4. d)Ver las asignaturas asociadas a un alumno, mostrando las que ha cursado y las que no. Se mostrarán todos los datos del alumno y de las asignaturas

Debes cumplir los siguientes requisitos:

1. a)Estructurar la aplicación siguiendo un patrón DAO. Toma como referencia los ejercicios anteriores
2. b)Definir y gestionar excepciones de forma adecuada
3. c)Definir un fichero de propiedades adecuado para la conexión a BD
4. d)Piensa bien en la estructura de clases de tu aplicación y anótala. Será lo primero que corrijamos antes de implementar nada.

Desarrolla una clase de Prueba con método main para representar la lógica de la aplicación y que realice lo siguiente:

1. a)Crear un nuevo alumno y almacenarlo en BD
2. b)Busca al alumno nuevo y muestra sus datos por pantalla
3. c)Borrar un alumno existente
4. d)Matricular al alumno nuevo en varias asignaturas
5. e)Consultar las asignaturas para las que está matriculado el nuevo alumno y mostrarlas por pantalla
