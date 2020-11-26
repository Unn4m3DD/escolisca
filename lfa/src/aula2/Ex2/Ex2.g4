grammar Ex2;
program: stat* EOF ;

stat: expr? NEWLINE;
expr: e1=expr e2=expr op=('*'|'/'|'+'|'-') #ExprSuffix
    | Number #ExprNumber;

Number : [0-9]+('.' [0-9]+)?;
NEWLINE: '\r'? '\n';
WS: [ \t]+ -> skip;
