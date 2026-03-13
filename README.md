# Sistema de Avaliacao Semestral

Programa em Java para calcular:

- nota do 1o bimestre (`N1`) e 2o bimestre (`N2`);
- media semestral (`M = (N1 + N2) / 2`);
- elegibilidade para recuperacao (`frequencia >= 75%` e `4,0 <= M < 6,0`);
- media final com recuperacao (`Mfinal = (max(N1, N2) + R) / 2`).

## Regras aplicadas

- **Aprovado direto:** frequencia >= 75% e media semestral >= 6,0.
- **Recuperacao:** frequencia >= 75% e media semestral no intervalo [4,0, 6,0).
- **Reprovado:** frequencia < 75% ou media semestral < 4,0.
- **Apos recuperacao:** aprovado se `Mfinal >= 6,0`.

## Entrada esperada no console

- 2 notas do 1o bimestre;
- 2 notas do 2o bimestre;
- frequencia semestral unica (percentual de `0` a `100`);
- nota de recuperacao, apenas se elegivel.

## Executar

Com Maven:

```powershell
mvn -q compile
mvn -q exec:java -Dexec.mainClass="org.example.Main"
```

Caso o plugin `exec-maven-plugin` nao esteja disponivel, execute com Java diretamente apos compilar.
