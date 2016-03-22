CREATE OR REPLACE PACKAGE PROCEDIMIENTOS IS
  TYPE G_CURSOR IS REF CURSOR;
  PROCEDURE get_trabajador(i_idTrab IN TRABAJADOR.IDTRABAJADOR%TYPE, o_cursor OUT G_CURSOR);
  PROCEDURE get_trabajadores_centro(i_idCen IN CENTRO.IDCENTrO%TYPE, o_cursor OUT G_CURSOR);
  PROCEDURE get_logisticas_centro(i_idCen IN CENTRO.IDCENTRO%TYPE, o_cursor OUT G_CURSOR);
END PROCEDIMIENTOS;

CREATE OR REPLACE PACKAGE BODY PROCEDIMIENTOS IS
  
  PROCEDURE get_trabajador(
    i_idTrab IN TRABAJADOR.IDTRABAJADOR%TYPE, o_cursor OUT G_CURSOR
  )AS
  BEGIN
    OPEN o_cursor for
      SELECT IDTRABAJADOR, IDCENTRO, DNI, NOMBRE, APE1, APE2, FECHANAC, 
             SALARIO, MOVILEMP, TLFPERSONAL, CALLE, PORTAL, PISO, MANO, 
             (SELECT TIPO FROM TIPOTRABAJADOR WHERE IDTIPO = T.IDTIPO) TIPO
      FROM TRABAJADOR T
      WHERE IDTRABAJADOR = i_idTrab;
  EXCEPTION
    WHEN NO_DATA_FOUND THEN
      RAISE_APPLICATION_ERROR(-20105, 'NO SE ENCONTRÓ EL TRABAJADOR');
  END;
  
  PROCEDURE get_trabajadores_centro(
    i_idCen IN CENTRO.IDCENTRO%TYPE, o_cursor OUT G_CURSOR
  )AS
  BEGIN
    OPEN o_cursor for
      SELECT IDTRABAJADOR
      FROM TRABAJADOR
      WHERE IDCENTRO = i_idCen;
  EXCEPTION
    WHEN NO_DATA_FOUND THEN
      RAISE_APPLICATION_ERROR(-20105, 'NO SE ENCONTRARON TRABAJADORES DE ESE CENTRO');
  END;
  
  PROCEDURE get_logisticas_centro(
    i_idCen IN CENTRO.IDCENTRO%TYPE, o_cursor OUT G_CURSOR
  )AS
  BEGIN
    OPEN o_cursor for
      SELECT IDTRABAJADOR
      FROM TRABAJADOR
      WHERE IDCENTRO = i_idCen
      AND IDTIPO = (SELECT IDTIPO FROM TIPOTRABAJADOR WHERE UPPER(TIPO) LIKE 'LOGISTICA');
  EXCEPTION
    WHEN NO_DATA_FOUND THEN
      RAISE_APPLICATION_ERROR(-20105, 'NO SE ENCONTRÓ EL TRABAJADOR');
  END;
  
END PROCEDIMIENTOS;