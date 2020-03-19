grammar Ex8;
program: statement* EOF;

statement : (print | assignment) ';';

assignment: expr '->' ID;

print: 'print' expr;

expr: unaryOP=op2 expr #ExprUnary
    | e1=expr op1 e2=expr #ExprPrecedence1
    | e1=expr op2 e2=expr #ExprPrecedence2
    | 'read' '"' prompt=.* '"' #ExprAssignment
    | ID #ExprID
    | Number #FracNumber
    | '(' expr ')' #ExprParenthesis
    | 'reduce' expr #ExprReduce
    | '('? num=Number '/' den=Number ')'? #FracDenNum;


op1: '*' | ':' | '^';
op2: '+' | '-';
ID: [a-zA-Z_]+;
Number: [-]?[0-9]+;
WS: [ \t\r\n]+ -> skip;
COMMENT: '//'.*? '\n' -> skip;
