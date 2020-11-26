grammar Ex3;
program: stat* EOF;
stat: expr? NEWLINE;
expr:
    unaryOp=('+'|'-') expr #ExprUnary
    | e1=expr op=('*'|'/'|'%') e2=expr #ExprMultDivMod
    | e1=expr op=('+'|'-') e2=expr #ExprAddSub
    | Integer #ExprInteger
    | '(' expr ')' #ExprParent;

Integer: [0-9]+;
NEWLINE: '\r'? '\n' ;
WS: [ \t]+ -> skip ;
COMMENT: '#'.*? '\n' -> skip;