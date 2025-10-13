# Fatec Estrutura de Dados: Comparativo de Algoritmos de Ordenação

## Descrição

Este repositório foi desenvolvido para a disciplina de **Estrutura de Dados** da **FATEC Carapicuíba** e tem como objetivo:

1. Realizar o **comparativo de desempenho** entre os algoritmos de ordenação **Bubble Sort**, **Insertion Sort**, **Selection Sort** e **QuickSort**.  
2. Utilizar o método `System.nanoTime()` para medir o tempo de execução de cada algoritmo.  
3. Executar **15 repetições** para cada tamanho de vetor, desconsiderando as 5 primeiras, e calcular o **tempo médio** das 10 execuções seguintes.  
4. Gerar arquivos **CSV** contendo as informações de desempenho (algoritmo, tamanho do vetor e tempo médio).  
5. Criar **gráficos de dispersão** para comparar visualmente o crescimento do tempo de execução conforme o aumento do tamanho do vetor.  
6. Observar experimentalmente a diferença entre as complexidades **O(n²)** e **O(n log n)**.  

## Recursos utilizados

### Linguagens
<img src="https://skillicons.dev/icons?i=java,python"/>

### Frameworks e Ferramentas
- [csv](https://docs.python.org/3/library/csv.html)
- [matplotlib](https://matplotlib.org/)

### Outros
<img src="https://skillicons.dev/icons?i=git,github"/>

---

## Estrutura Experimental

- **Linguagem principal:** Java  
- **Controle e análise dos dados:** Python  
- **Timer:** `System.nanoTime()`  
- **Tamanhos dos vetores:** `2000, 4000, 8000, 12000, 16000`  
- **Saída esperada:**  algoritmo, n, tempo_medio_ms
- - **Análise gráfica:**  
- Gráficos **tempo x n (dispersão)** para cada algoritmo.  
- Comparação visual entre o crescimento **quadrático (O(n²))** e o **log-linear (O(n log n))**.  

---

## Documentações utilizadas:
- [Python Subprocess](https://docs.python.org/3/library/subprocess.html): Como executar comandos e subprocessos com Python. Utilizada para conhecer como compilar e executar os arquivos em java

## Contato

**Contribuidor:**  
<a href="https://github.com/Gusales" target="_blank">
<img src="https://github.com/Gusales.png" width="100" style="border-radius: 50%;" />
</a>  
**Gustavo Sales**

📧 **Email pessoal:** [dev.gussales@gmail.com](mailto:dev.gussales@gmail.com)  
📧 **Email FATEC:** [gustavo.souza147@fatec.sp.gov.br](mailto:gustavo.souza147@fatec.sp.gov.br)