import mock
import aula1

""" Exercicio 1.1 """


@mock.patch('aula1.comprimento', side_effect=aula1.comprimento)
def test_comprimento(mock_comprimento):
  assert mock_comprimento([1, 2, 3, 4]) == 4
  assert mock_comprimento.call_count == 5


""" Exercicio 1.2 """


@mock.patch('aula1.soma', side_effect=aula1.soma)
def test_soma(mock_soma):
  assert mock_soma([1, 2, 3, 4]) == 10
  assert mock_soma.call_count == 5


""" Exercicio 1.3 """


@mock.patch('aula1.existe', side_effect=aula1.existe)
def test_existe(mock_existe):
  assert mock_existe([1, 2, 3, 4], 5) == False
  assert mock_existe.call_count == 5
  mock_existe.call_count = 0
  assert mock_existe([1, 2, 3, 4], 2) == True
  assert mock_existe.call_count == 2


""" Exercicio 1.4 """


@mock.patch('aula1.concat', side_effect=aula1.concat)
def test_concat(mock_concat):
  assert mock_concat([1, 2, 3, 4], [5, 6]) == [1, 2, 3, 4, 5, 6]
  assert mock_concat.call_count == 3


""" Exercicio 1.5 """


@mock.patch('aula1.inverte', side_effect=aula1.inverte)
def test_inverte(mock_inverte):
  assert mock_inverte([1, 2, 3, 4]) == [4, 3, 2, 1]
  assert mock_inverte.call_count == 5


""" Exercicio 1.6 """


@mock.patch('aula1.capicua', side_effect=aula1.capicua)
def test_capicua(mock_capicua):
  assert mock_capicua([3, 2, 3])
  assert mock_capicua([3, 2, 2, 3])
  assert not mock_capicua([1, 2, 3])
  assert mock_capicua.call_count == 7


""" Exercicio 1.7 """


@mock.patch('aula1.explode', side_effect=aula1.explode)
def test_explode(mock_explode):
  assert mock_explode([[1, 2], [3, 4]]) == [1, 2, 3, 4]
  assert mock_explode([[1, 2], [3, 4], [5]]) == [1, 2, 3, 4, 5]


""" Exercicio 1.8 """


@mock.patch('aula1.substitui', side_effect=aula1.substitui)
def test_substitui(mock_substitui):
  assert mock_substitui([1, 2, 3, 4], 3, 5) == [1, 2, 5, 4]
  assert mock_substitui([1, 2, 3, 4], 5, 6) == [1, 2, 3, 4]


""" Exercicio 1.9 """


@mock.patch('aula1.junta_ordenado', side_effect=aula1.junta_ordenado)
def test_junta_ordenado(mock_junta_ordenado):
  assert mock_junta_ordenado([1, 2, 3, 4], [2, 3, 4, 5]) == [
      1, 2, 2, 3, 3, 4, 4, 5]


""" Exercicio 1.9 """


@mock.patch('aula1.partes', side_effect=aula1.partes)
def test_partes(mock_partes):
  print(mock_partes([1, 2, 3]), "should be equivalent to ", [[], [3], [2], [2, 3],
                                                             [1], [1, 3], [1, 2], [1, 2, 3]])
  print(mock_partes([1, 3, 5]), "should be equivalent to ", [[], [5], [3], [3, 5],
                                                             [1], [1, 5], [1, 3], [1, 3, 5]])


""" Exercicio 2.1 """


@ mock.patch('aula1.separar', side_effect=aula1.separar)
def test_separar(mock_separar):
  assert mock_separar(
      [(1, 'a'), (2, 'b'), (3, 'c')]
  ) == ([1, 2, 3], ['a', 'b', 'c'])
  assert mock_separar.call_count == 4


""" Exercicio 2.2 """


@ mock.patch('aula1.remove_e_conta', side_effect=aula1.remove_e_conta)
def test_remove_e_conta(mock_remove_e_conta):
  assert mock_remove_e_conta([1, 1, 2, 3, 1], 1) == ([2, 3], 3)
  assert mock_remove_e_conta.call_count == 6
  assert mock_remove_e_conta([1, 1, 2, 2, 3, 1], 2) == ([1, 1, 3, 1], 2)
  assert mock_remove_e_conta.call_count == 13


""" Exercicio 2.3 """


@ mock.patch('aula1.count', side_effect=aula1.count)
def test_count(mock_count):
  assert mock_count([1, 1, 2, 3, 1]) == [(1, 3), (2, 1), (3, 1)]
  assert mock_count.call_count == 4
  assert mock_count([1, 1, 2, 2, 3, 1]) == [(1, 3), (2, 2), (3, 1)]
  assert mock_count.call_count == 8


""" Exercicio 3.1 """


@ mock.patch('aula1.cabeca', side_effect=aula1.cabeca)
def test_cabeca(mock_cabeca):
  assert mock_cabeca([]) is None
  assert mock_cabeca.call_count == 1
  assert mock_cabeca([1, 2, 3]) == 1
  assert mock_cabeca.call_count == 2


""" Exercicio 3.2 """


@ mock.patch('aula1.cauda', side_effect=aula1.cauda)
def test_cauda(mock_cauda):
  assert mock_cauda([]) is None
  assert mock_cauda.call_count == 1
  assert mock_cauda([1, 2, 3]) == [2, 3]
  assert mock_cauda.call_count == 2


""" Exercicio 3.3 """


@ mock.patch('aula1.juntar', side_effect=aula1.juntar)
def test_juntar(mock_juntar):
  assert mock_juntar([1, 2, 3], ['a', 'b',    'c']) == [
      (1, 'a'), (2, 'b'), (3, 'c')]
  assert mock_juntar.call_count == 4
  assert mock_juntar([1, 2, 3], ['a', 'b', 'c', 'd']) is None
  assert mock_juntar.call_count == 5


""" Exercicio 3.4 """


@ mock.patch('aula1.menor', side_effect=aula1.menor)
def test_menor(mock_menor):
  assert mock_menor([1, 2, 3, 0, 5]) == 0
  assert mock_menor.call_count == 6
  assert mock_menor([]) is None


""" Exercicio 3.5 """


@ mock.patch('aula1.max_min', side_effect=aula1.max_min)
def test_max_min(mock_max_min):
  assert mock_max_min([1, 2, 3, 0, 5]) == (5, 0)
  assert mock_max_min.call_count == 6
  assert mock_max_min([1, 2, 3, 0, 5, 100, -21]) == (100, -21)
  assert mock_max_min.call_count == 14


""" Exercicio 3.6 """


@ mock.patch('aula1.menor_e_resto', side_effect=aula1.menor_e_resto)
def test_menor_e_resto(mock_menor_e_resto):
  assert mock_menor_e_resto([1, 3, 2, 1, 4, 2]) == (1, [3, 2, 4, 2])
  assert mock_menor_e_resto.call_count == 7
  assert mock_menor_e_resto([2, 3, 2, 4, 2, 3, 4, 7]) == (2, [3, 4, 3, 4, 7])
  assert mock_menor_e_resto.call_count == 16


""" Exercicio 3.7 """


@ mock.patch('aula1.menores_e_resto', side_effect=aula1.menores_e_resto)
def test_menores_e_resto(mock_menores_e_resto):
  assert mock_menores_e_resto([1, 2, 3, 4, 1, 2, 3, 2, 1]) == (1, 2, [3, 4, 3])
  assert mock_menores_e_resto.call_count == 1
  assert mock_menores_e_resto([1,  3, 4, 1,  3,  1]) == (1, 3, [4])
  assert mock_menores_e_resto.call_count == 2


""" Exercicio 3.8 """


@ mock.patch('aula1.med_e_avg', side_effect=aula1.med_e_avg)
def test_med_e_avg(mock_med_e_avg):
  assert mock_med_e_avg([1, 1, 1, 1, 1, 1]) == (None, 1.0)
  assert mock_med_e_avg.call_count == 3
  assert mock_med_e_avg([2, 2, 2, 2, 2, 2, 2, 2, 2]) == (2, 2.0)
  assert mock_med_e_avg.call_count == 8
