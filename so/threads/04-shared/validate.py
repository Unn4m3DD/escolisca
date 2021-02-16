count = 0
while(1):
  [to_parse, length, number_count, char_count] = [x for x in input().split(",")]
  if(
    len(to_parse) == int(length) and
    len([x for x in to_parse if x in [str(y) for y in range(10)]]) == int(number_count) and
    len([x for x in to_parse if x in [str(y) for y in "qwertyuiopasdfgçlkgjhmznxbcvQWERTYUIOPÇLKJHGFDSAZXCVBNM"]]) == int(char_count)
  ):
    print(str(count), end="->")
  else:
    print("\nERROR")
  count += 1