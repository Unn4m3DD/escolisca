grammar int;
top: NUMBER;
NUMBER : '-'? INT '.' INT EXP? // 1.35, 1.35E-9, 0.3, -4.5
       | '-'? INT EXP // 1e10 -3e4
       | '-'? INT; // -3, 45 ;
fragment INT : '0' | [1-9] [0-9]* ; // no leading zeros fragment
fragment EXP : [Ee] [+\-]? INT ; // \- since - means "range" inside [...]