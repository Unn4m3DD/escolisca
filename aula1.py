#Exercicio 1.1
def comprimento(lista):
  if lista == []: return 0
  return 1 + comprimento(lista[:-1])

#Exercicio 1.2
def soma(lista):
  if lista == []: return 0
  return lista[0] + soma(lista[1:])

#Exercicio 1.3
def existe(lista, elem):
  if lista == []: return False
  return lista[0] == elem or existe(lista[1:], elem)

#Exercicio 1.4
def concat(l1, l2):
  if l2 == []: return l1
  l1.append(l2[0])
  return concat(l1, l2[1:])

#Exercicio 1.5
def inverte(lista):
  if lista == []: return []
  return [lista[-1]] + inverte(lista[:-1])

#Exercicio 1.6
def capicua(lista):
  if lista == []: return True
  return lista[0] == lista[-1] and capicua(lista[1:-1])
  pass

#Exercicio 1.7
def explode(lista):
  if lista == []: return []
  return lista[0] + explode(lista[1:])

#Exercicio 1.8
def substitui(lista, original, novo):
  if lista == []: return []
  return [lista[0] if lista[0] != original else novo] + substitui(lista[1:], original, novo)

#Exercicio 1.9
def junta_ordenado(lista1, lista2):
  if lista1 == []: return lista2
  if lista2 == []: return lista1
  return [lista1[0] if lista1[0] < lista2[0] else lista2[0]] + \
          junta_ordenado(
            lista1[1:] if lista1[0] < lista2[0] else lista1,
            lista2 if lista1[0] < lista2[0] else lista2[1:]
          )
  

#Exercicio 2.1
def separar(lista):
  if lista == []: return ([], [])
  t1, t2 = separar(lista[1:])
  return [lista[0][0]] + t1, [lista[0][1]] + t2

#Exercicio 2.2
def remove_e_conta(lista, elem):
  if(lista == []): return [], 0
  result_lista, result_count = remove_e_conta(lista[1:], elem)
  return ([lista[0]] if lista[0] != elem else []) + result_lista, result_count + (1 if lista[0] == elem else 0)


#Exercicio 3.1
def cabeca(lista):
  if(lista == []): return None
  return lista[0]

#Exercicio 3.2
def cauda(lista):
  if(lista == []): return None
  return lista[-1]

#Exercicio 3.3
def juntar(l1, l2):
  if len(l1) != len(l2): return
  if l1 == []: return []
  print(l1)
  return [(l1[0], l2[0])] + juntar(l1[1:], l2[1:])
#Exercicio 3.4
def menor(lista):
  if lista == []: return None
  minimum = menor(lista[1:]) 
  minimum = minimum if minimum != None else lista[0]
  return lista[0] if lista[0] < minimum else minimum

#Exercicio 3.6
def max_min(lista):
  if lista == []: return None, None
  maximum, minimum = max_min(lista[1:]) 
  minimum = minimum if minimum != None else lista[0]
  maximum = maximum if maximum != None else lista[0]
  return lista[0] if lista[0] > maximum else maximum, lista[0] if lista[0] < minimum else minimum
