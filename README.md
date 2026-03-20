# ifsc-ps

Aplicacao Java para calcular notas bimestrais, media semestral e resultado de recuperacao.

## Visao geral

O projeto segue um modelo simples orientado a interfaces:

- `Main` inicializa as dependencias de entrada e saida.
- `CalcularNotasApp` orquestra o fluxo principal da aplicacao.
- Entidades (`BimestreBase`, `SemestreBase`, `AvaliacaoBase`, `NotaBase`) representam o dominio.
- Servicos (`CalculadorMediaBimestre`, `CalculadorMediaSemestre`) calculam medias.
- Decoradores de nota (`NotaValida`) aplicam regras de validacao.

## Regras implementadas hoje

- Cada nota deve estar entre `0` e `10` (`NotaValida`).
- Media do bimestre = soma das avaliacoes / quantidade de avaliacoes.
- Media do semestre = media dos bimestres cadastrados.
- A media semestral exibida tambem e arredondada por `ArredondadorPadrao`.
- Recuperacao so e avaliada quando media arredondada estiver em `4 <= media < 6`.
- Elegibilidade de recuperacao exige:
  - frequencia `>= 75`
  - media semestral no intervalo `[4, 6)`
- Resultado final da recuperacao (`RecuperacaoBase`):
  - `Mfinal = (max(N1, N2) + R) / 2`
  - aprovado na recuperacao apenas se `Mfinal > 6`

## Fluxo de execucao

1. Informar quantas avaliacoes houve no 1o bimestre.
2. Informar quantas avaliacoes houve no 2o bimestre.
3. Informar as notas de cada avaliacao dos dois bimestres.
4. O sistema exibe:
   - media do 1o bimestre
   - media do 2o bimestre
   - media semestral
   - media semestral arredondada
5. Se o aluno estiver na faixa de recuperacao, informar:
   - frequencia (%)
   - nota de recuperacao
6. O sistema informa aprovacao ou reprovacao na recuperacao.

## Como executar

Requisitos:

- Java 23 (conforme `pom.xml`)
- Maven 3.9+

Comandos:

```bash
mvn clean compile
mvn exec:java -Dexec.mainClass="org.example.Main"
```

Se o plugin `exec-maven-plugin` nao estiver configurado no seu ambiente, rode pela IDE com a classe `org.example.Main`.

## Estrutura principal

- `src/main/java/org/example/Main.java`
- `src/main/java/org/example/CalcularNotasApp.java`
- `src/main/java/org/example/entity`
- `src/main/java/org/example/interfaces`
- `src/main/java/org/example/services`

## Observacoes

- As quantidades de avaliacoes sao lidas como `double`; na pratica, use valores inteiros (ex.: `2`, `3`).
- O projeto esta em evolucao e ainda nao possui testes automatizados.

