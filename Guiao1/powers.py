expr = input().split(" ")
if(expr[1] == "+"):
  if(expr[0] == 0):
    if(expr[2] == 0):
      print(0)
  if(expr[0] == 0):
    if(expr[2] == 1):
      print(1)
      



toPrint = "{"
sep2 = ""
for i in range(10):
  toPrint += sep2 + "\n{"
  sep1 = ""
  for j in range(15):
    toPrint += sep1 + str(j**i)
    sep1 = ","
  toPrint += "}"
  sep2 = ","
toPrint += "\n}"
print(toPrint)