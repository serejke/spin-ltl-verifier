grammar Ltl;

//φ ::= ( φ ) | expression | !φ | X φ | F φ | G φ | φ U φ | φ R φ | φ & φ | φ '|' φ | φ -> φ

ltl
 : formula EOF
 ;

formula
 : LPAREN body=formula RPAREN             #ltlParen
 | expr                                   #ltlExpr
 | NOT formula                            #ltlNeg
 | X body=formula                         #ltlNext
 | F body=formula                         #ltlFuture
 | G body=formula                         #ltlGlobally
 | left=formula U right=formula           #ltlUntil
 | left=formula R right=formula           #ltlRelease
 | left=formula AND right=formula         #ltlAnd
 | left=formula OR right=formula          #ltlOr
 | left=formula IMPLICATION right=formula #ltlImpl
 ;

condition
 : LPAREN body=condition RPAREN               #condParen
 | expr                                       #condExpr
 | NOT body=condition                         #condNot
 | left=condition AND right=condition         #condAnd
 | left=condition OR right=condition          #condOr
 | left=condition IMPLICATION right=condition #condImpl
 ;

expr
 : left=simpleExpr ( cmpSign=(EQUAL | NOT_EQUAL | LT | LE | GE | GT) right=simpleExpr)?
 ;

simpleExpr
 : term ( (PLUS | MINUS) term)*
 ;

term
 : signedFactor ( (STAR | SLASH) signedFactor)* #signedTerm
 | LPAREN simpleExpr RPAREN                     #parenTerm
 ;

signedFactor
 : MINUS? factor
 ;

factor
 : NUM_INT      #factNumber
 | trueOrFalse  #factTrueOrFalse
 | var          #factVar
 ;

trueOrFalse
 : TRUE | FALSE
 ;

var
 : IDENT
 ;

//Tokens definition

TRUE
 : 'true'
 ;

FALSE
 : 'false'
 ;

NUM_INT
 : ('0' .. '9')+
 ;

EQUAL
 : '='
 ;

NOT_EQUAL
 : '!='
 ;

LT
 : '<'
 ;

LE
 : '<='
 ;

GE
 : '>='
 ;

GT
 : '>'
 ;

SEMI
 : ';'
 ;

COMMA
 : ','
 ;

PLUS
 : '+'
 ;

MINUS
 : '-'
 ;

STAR
 : '*'
 ;

SLASH
 : '/'
 ;

LPAREN
 : '('
 ;

RPAREN
 : ')'
 ;

OR
 : '|'
 ;

AND
 : '&'
 ;

IMPLICATION
 : '->'
 ;

NOT
 : '!'
 ;

G
 : 'G'
 ;

F
 : 'F'
 ;

U
 : 'U'
 ;

X
 : 'X'
 ;

R
 : 'R'
 ;

WS
 : ' ' -> skip
 ;

IDENT
 : ('a' .. 'z' | 'A' .. 'Z') ('a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_')*
 ;
