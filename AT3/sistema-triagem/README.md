Sistema de Triagem de Pronto Socorro
ARTHUR LOPES MOURA
RA:2019001666 (sem UC)

requisitos
Java 17+
Maven 3.9+

como executar

```bash
./mvnw spring-boot:run
```

Banco padrão: H2 em memória
Acesse a API: http://localhost:8080
Console H2: http://localhost:8080/h2-console
Driver: org.h2.Driver
JDBC URL: jdbc:h2:mem:triagemdb

endpoints principais -

GET /health - verifica se está no ar

POST /triagem - registra paciente

POST /medicos - registra médico

PUT /medicos/{id}/plantao - atualiza status de plantão

GET /pacientes/{id} - consulta paciente

GET /atendimento/proximo - retorna próximo a ser atendido

