package com.converted.cobol;

* Processa os dados de entrada de acordo com as regras de negócio aninhadas.
     * <p>
     * Lógica COBOL original:
     * <pre>
     * COMPUTE RESULT = A + B.
     * IF (A < 10) AND (B > 10) THEN
     *     IF RESULT > 50 THEN
     *         DISPLAY "Result is bigger than 50."
     *     ELSE
     *         MOVE RESULT TO FORMATTED
     *