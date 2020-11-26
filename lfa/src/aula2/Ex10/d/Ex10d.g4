grammar Ex10d;
program: stat* EOF;

stat: assignment
    | expr;

assignment: ID '=' expr;

expr: set                   #ExprSet
    | ID                    #ExprId
    | e1=expr '+'  e2=expr  #ExprAdd
    | e1=expr '\\' e2=expr  #ExprExcept
    | e1=expr '&'  e2=expr  #ExprJoin
    | '(' expr ')'          #ExprParenthesis;

set: '{' item (',' item)* '}';

item: Word|Number;
ID: [A-Z]+;
Word: [a-z]+;
Number: [+-]?[0-9]+;
COMMENT: '--' .*? '\n' -> skip;
WS: [ \t\n\r]+ -> skip;