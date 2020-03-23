grammar paulo;

program: statement* EOF;

statement: (declaration | call) ';';

declaration: TYPE ID '(' typedParams ')' '{' body '}' ;

body: statement*;

call: ID '(' params ')';

typedParams: TYPE ID (',' TYPE ID)* | ;

params: ID (',' ID)* | ;

TYPE: 'void'|'int'|'float'|'bool';

ID: [a-zA-Z_][a-zA-Z_0-9]*;

WS: [ \t\r\n]* -> skip;
