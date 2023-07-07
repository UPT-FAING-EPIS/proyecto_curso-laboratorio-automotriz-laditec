# Análisis y Mejoramiento del sistema intranet de la empresa LADITEC

Curso: Calidad y Pruebas de Software

Docente: Ing. Patrick Cuadros

Integrantes:

- Condori Loayza, Helbert Andres (2020067571)
- Aranda Reyes, Diego Andre (2019063855)
- Mamani Lima, Erick Mauricio (2020066321)
- Rivera Mendoza, Jhonny (2020067144)


### Resumen del Proyecto

El proyecto se enfoca en reducir la deuda técnica y las vulnerabilidades del sistema intranet de LADITEC. Se utilizará SonarQube para identificar áreas problemáticas, se corregirán con un equipo de desarrolladores y se mantendrá la calidad del código. El objetivo es eliminar los problemas y mejorar el sistema de manera completa.
# DIAGRAMA DE CASOS DE USO
![image](https://github.com/UPT-FAING-EPIS/proyecto_curso-laboratorio-automotriz-laditec/assets/102829461/987adf2a-e21c-4567-b76e-700a4638917e)
# DIAGRAMA DE CLASES
![image](https://github.com/UPT-FAING-EPIS/proyecto_curso-laboratorio-automotriz-laditec/assets/102829461/3a46d862-e882-4c9b-a7ed-e52656804843)

### Desplegar:
Se ha trabajado con MAVEN por lo que se debe ejecutar en el directorio del proyecto:
mvn clean install


### workflow:

name: Testing

on:
  push:
    branches:
      - main
  workflow_dispatch:

jobs:
  build:
    runs-on: ubuntu-latest

    steps:
      - uses: actions/checkout@v3
      - name: Set up JDK 18
        uses: actions/setup-java@v3
        with:
          java-version: '18'
          distribution: 'temurin'
      - name: Build with Maven
        run: mvn -f HACLaditec/pom.xml clean test
      - name: Generate Jacoco Coverage Report
        run: mvn -f HACLaditec/pom.xml jacoco:report
      - name: Generate Allure Report
        run: mvn -f HACLaditec/pom.xml allure:report
      - name: Copy Allure Results to Report Directory
        run: cp -r HACLaditec/allure-results HACLaditec/target/site/allure-maven-plugin/
      - name: Upload Allure Report
        uses: actions/upload-artifact@v2
        with:
          name: allure-report
          path: HACLaditec/target/site/allure-maven-plugin/

![Captura de pantalla 2023-07-07 131806](https://github.com/UPT-FAING-EPIS/proyecto_curso-laboratorio-automotriz-laditec/assets/102819429/53dd5d02-fd76-46d3-89fa-2a8cc6c1092d)




