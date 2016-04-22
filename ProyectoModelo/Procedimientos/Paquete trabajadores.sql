CREATE OR REPLACE PACKAGE PAC_TRABAJADOR IS
  TYPE G_CURSOR IS REF CURSOR;
  PROCEDURE get_trabajador(i_dniTrab IN TRABAJADORES.DNI%TYPE, i_idCent IN TRABAJADORES.IDCENTRO%TYPE, o_cursor OUT G_CURSOR);
  PROCEDURE get_trabajadores_centro(i_idCen IN CENTROS.IDCENTRO%TYPE, o_cursor OUT G_CURSOR);
  PROCEDURE get_tipos_centro(i_idCen IN CENTROS.IDCENTRO%TYPE, i_tipo IN TIPOTRABAJADORES.TIPO%TYPE, o_cursor OUT G_CURSOR);
END PAC_TRABAJADOR;

CREATE OR REPLACE PACKAGE BODY PAC_TRABAJADOR IS
  
  PROCEDURE get_trabajador(
    i_dniTrab IN TRABAJADORES.DNI%TYPE, i_idCent IN TRABAJADORES.IDCENTRO%TYPE, o_cursor OUT G_CURSOR
  )AS
  BEGIN
    OPEN o_cursor for
      SELECT IDTRABAJADOR, IDCENTRO, DNI, NOMBRE, APE1, APE2, FECHANAC, 
             SALARIO, MOVILEMP, TLFPERSONAL, CALLE, PORTAL, PISO, MANO, 
             (SELECT TIPO FROM TIPOTRABAJADORES WHERE IDTIPO = T.IDTIPO) TIPO
      FROM TRABAJADORES T
      WHERE DNI = i_dniTrab
      AND IDCENTRO = i_idCent;
  EXCEPTION
    WHEN NO_DATA_FOUND THEN
      RAISE_APPLICATION_ERROR(-20105, 'NO SE ENCONTRÓ EL TRABAJADORES');
  END;
  
  PROCEDURE get_trabajadores_centro(
    i_idCen IN CENTROS.IDCENTRO%TYPE, o_cursor OUT G_CURSOR
  )AS
  BEGIN
    OPEN o_cursor for
      SELECT IDTRABAJADOR
      FROM TRABAJADORES
      WHERE IDCENTRO = i_idCen;
  EXCEPTION
    WHEN NO_DATA_FOUND THEN
      RAISE_APPLICATION_ERROR(-20105, 'NO SE ENCONTRARON TRABAJADORES DE ESE CENTRO');
  END;
  
  PROCEDURE get_tipos_centro(
    i_idCen IN CENTROS.IDCENTRO%TYPE, i_tipo IN TIPOTRABAJADORES.TIPO%TYPE, o_cursor OUT G_CURSOR
  )AS
  BEGIN
    OPEN o_cursor for
      SELECT IDTRABAJADOR
      FROM TRABAJADORES
      WHERE IDCENTRO = i_idCen
      AND IDTIPO = (SELECT IDTIPO FROM TIPOTRABAJADORES WHERE UPPER(TIPO) LIKE UPPER(i_tipo));
  EXCEPTION
    WHEN NO_DATA_FOUND THEN
      RAISE_APPLICATION_ERROR(-20105, 'NO SE ENCONTRÓ EL TRABAJADOR');
  END;
  
END PAC_TRABAJADOR;