package analizadores;

import java_cup.runtime.*;
import static analizadores.sym.*;

%% //separador de area

/* opciones y declaraciones de jflex */

%public
%class Lexer1
%cup
%cupdebug
%line
%column

%{
    StringBuilder string = new StringBuilder();
  
  private Symbol symbol(int type) {
    return new Symbol(type, yyline+1, yycolumn+1);
  }

  private Symbol symbol(int type, Object value) {
    return new Symbol(type, yyline+1, yycolumn+1, value);
  }


  private void error(String message) {
    System.out.println("Error en linea line "+(yyline+1)+", columna "+(yycolumn+1)+" : "+message);
  }
%}

LineTerminator = \r|\n|\r\n
WhiteSpace = [ \t\f]
TextoParametro = "[" [^*] ~"]" | "[" "]"
Letra = [a-zA-Z]
Entero = [0-9]
Digito = [1-9][0-9]*
Space = ({WhiteSpace})*
LetraNumero = ({Letra}|{Entero})
NumeroHexadecimal = "#" {LetraNumero}{LetraNumero}{LetraNumero}{LetraNumero}{LetraNumero}{LetraNumero}
Comentario = "##" [^*] ~{LineTerminator} | "##" {LineTerminator}
Variable = ({Letra}|{Digito}|"-"|"_"|"$")+


%% // separador de areas

/* reglas lexicas */
<YYINITIAL> {

	"forward" {return symbol(FORWARD, yytext());}
	"fd" {return symbol(FORWARD, yytext());}
	"backward" {return symbol(BACKWARD, yytext());}
	"bk" {return symbol(BACKWARD, yytext());}
	"right" {return symbol(RIGHT, yytext());}
	"rt" {return symbol(RIGHT, yytext());}
	"left" {return symbol(LEFT, yytext());}
	"lt" {return symbol(LEFT, yytext());}
	"clears" {return symbol(CLEARS, yytext());}
	"cs" {return symbol(CLEARS, yytext());}
	"penup" {return symbol(PENUP, yytext());}
	"pu" {return symbol(PENUP, yytext());}
	"pendown" {return symbol(PENDOWN, yytext());}
	"pd" {return symbol(PENDOWN, yytext());}
	"tocenter" {return symbol(TOCENTER, yytext());}
	"cr" {return symbol(TOCENTER, yytext());}
	"color" {return symbol(COLOR, yytext());}
	"positionxy" {return symbol(POSITIONXY, yytext());}
	"posxy" {return symbol(POSITIONXY, yytext());}
	"positionx" {return symbol(POSITIONX, yytext());}
	"posx" {return symbol(POSITIONX, yytext());}
	"positiony" {return symbol(POSITIONY, yytext());}
	"posy" {return symbol(POSITIONY, yytext());}
	"hideturtle" {return symbol(HIDETURTLE, yytext());}
	"ht" {return symbol(HIDETURTLE, yytext());}
	"showturtle" {return symbol(SHOWTURTLE, yytext());}
	"st" {return symbol(SHOWTURTLE, yytext());}
	"toerase" {return symbol(TOERASE, yytext());}
	"te" {return symbol(TOERASE, yytext());}
	"todraw" {return symbol(TODRAW, yytext());}
	"td" {return symbol(TODRAW, yytext());}
	"repeat" {return symbol(REPEAT, yytext());}
	"(" {return symbol(PAR_ABI, yytext());}
	")" {return symbol(PAR_CER, yytext());}
	":" {return symbol(DOS_PUNTOS, yytext());}
	"=" {return symbol(IGUAL, yytext());}
	"+" {return symbol(SUMA, yytext());}
	"-" {return symbol(RESTA, yytext());}
	"*" {return symbol(MULTIPLICACION, yytext());}
	"/" {return symbol(DIVISION, yytext());}
	"," {return symbol(COMA, yytext());}
	{TextoParametro} {return symbol(TEXTO_PARAM, yytext());}
	{Entero} {return symbol(ENTERO, yytext());}
	{Digito} {return symbol(DIGITO, yytext());}
	{Variable} {return symbol(IDENTIFICADOR, yytext());}
	{NumeroHexadecimal} {return symbol(HEXADECIMAL, yytext());}
	{Comentario} {return symbol(COMENTARIO, yytext());}
	{WhiteSpace} 		{/*Nothing to do*/}
	{LineTerminator} 	{/*Nothing to do*/}

}
[^] {error("Simbolo invalido <"+ yytext()+">");}
<<EOF>>                 { return symbol(EOF); }
