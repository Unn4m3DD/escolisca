grammar Ex1;
mainRule: (greetings|bye)*;
greetings: 'hello' name;
bye: 'bye' name;
name: ID | name ID;
ID: [a-zA-Z_]+;
WS: [ \t\r\n]+ -> skip ;