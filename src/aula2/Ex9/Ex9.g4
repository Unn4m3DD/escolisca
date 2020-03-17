grammar Ex9;

program: question* EOF;

question: id1=ID '.' id2=ID '(' text=Sentence ')' '{' opts+ '}';

opts: text=Sentence ':' points=INTEGER ';';

ID: [a-zA-Z]+[0-9]*;


Sentence: '"' (~'"' | '\\"')*  '"' ;


INTEGER: [0-9]+;

WS: [\n\r\t ]+ -> skip;
COMMENT: '#' .*? '\n' -> skip;

