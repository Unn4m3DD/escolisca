#include <assert.h>
#include <stdio.h>
int comparisons = 0;
int count(int* array, int n) {
  assert(n > 0);
  int counter = 0;
  for (int i = 0; i < n; i++) {
    comparisons++;
    if (array[i] == array[i + 1]) {
      counter++;
    }
  }
  return counter;
}

int main() {
  int array[10][10] = {
      {3, 3, 3, 3, 3, 3, 3, 3, 3, 3}, {4, 3, 3, 3, 3, 3, 3, 3, 3, 3},
      {4, 5, 3, 3, 3, 3, 3, 3, 3, 3}, {4, 5, 1, 3, 3, 3, 3, 3, 3, 3},
      {4, 5, 1, 2, 6, 3, 3, 3, 3, 3}, {4, 5, 1, 2, 6, 8, 3, 3, 3, 3},
      {4, 5, 1, 2, 6, 8, 7, 9, 3, 3}, {4, 5, 1, 2, 3, 3, 3, 3, 3, 3},
      {4, 5, 1, 2, 6, 8, 7, 3, 3, 3}, {4, 5, 1, 2, 6, 8, 7, 9, 3, 0}};

  for (int i = 0; i < 10; i++) {
    comparisons = 0;
    printf("Resultado: %d ", count(array[i], 9));
    printf("Comparações: %d\n", comparisons);
  }
}

/*
Respostas ao guião
tabela:
Resultado: 9 Comparações: 9
Resultado: 8 Comparações: 9
Resultado: 7 Comparações: 9
Resultado: 6 Comparações: 9
Resultado: 4 Comparações: 9
Resultado: 3 Comparações: 9
Resultado: 1 Comparações: 9
Resultado: 5 Comparações: 9
Resultado: 2 Comparações: 9
Resultado: 0 Comparações: 9

q1: não, todos os cenarios resultam em numero de comparações iguais,
a unica diferença é o numero de incrementos na variavel de contagem, o resulado
da função. o "melhor" caso seria o caso em que nenhum dos elementos é repetido e
o pior caso seria o caso em que todos os elementos são iguais

q2: linear : O(n)
q3: para um array de tamanho n
[elem_1, elem_2, elem_3, ... ,elem_n]
existe uma variavel de indice que percorre os elementos de 1 a n-1 e executa uma
comparção totalizando n-1 comparações n-1 E O(n)
$$\sum_0^{n-1} 1 = n - 1$$

q4: n = 10 => 9 iterações
*/