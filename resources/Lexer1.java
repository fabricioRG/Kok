/* The following code was generated by JFlex 1.6.1 */

package analizadores;

import java_cup.runtime.*;
import static analizadores.sym.*;


/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.6.1
 * from the specification file <tt>AnalizadorLexico1.lex</tt>
 */
public class Lexer1 implements java_cup.runtime.Scanner {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int YYINITIAL = 0;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 
     0, 0
  };

  /** 
   * Translates characters to character classes
   */
  private static final String ZZ_CMAP_PACKED = 
    "\11\0\1\3\1\2\1\0\1\3\1\1\22\0\1\3\2\0\1\7"+
    "\1\12\3\0\1\42\1\43\1\10\1\46\1\50\1\11\1\0\1\47"+
    "\1\5\11\6\1\44\2\0\1\45\3\0\32\4\1\40\1\0\1\41"+
    "\1\0\1\12\1\0\1\17\1\21\1\22\1\20\1\31\1\13\1\25"+
    "\1\26\1\24\1\4\1\23\1\30\1\4\1\34\1\14\1\33\1\4"+
    "\1\15\1\32\1\27\1\35\1\4\1\16\1\36\1\37\1\4\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uff95\0";

  /** 
   * Translates characters to character classes
   */
  private static final char [] ZZ_CMAP = zzUnpackCMap(ZZ_CMAP_PACKED);

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\1\0\1\1\2\2\1\3\2\4\1\1\1\5\1\6"+
    "\11\3\1\7\1\10\1\11\1\12\1\13\1\14\1\15"+
    "\1\16\1\17\1\3\1\20\1\0\1\21\1\0\1\3"+
    "\1\22\1\3\1\23\2\3\1\24\1\3\1\25\1\3"+
    "\1\26\1\3\1\27\1\3\1\30\1\31\1\32\2\3"+
    "\1\33\1\3\1\34\1\3\1\35\1\21\1\0\16\3"+
    "\1\0\14\3\1\36\1\37\2\3\1\0\3\3\1\40"+
    "\7\3\1\41\1\3\1\0\1\3\1\42\7\3\1\43"+
    "\12\3";

  private static int [] zzUnpackAction() {
    int [] result = new int[125];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** 
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\51\0\122\0\51\0\173\0\51\0\244\0\315"+
    "\0\51\0\173\0\366\0\u011f\0\u0148\0\u0171\0\u019a\0\u01c3"+
    "\0\u01ec\0\u0215\0\u023e\0\51\0\51\0\51\0\51\0\51"+
    "\0\51\0\51\0\51\0\51\0\u0267\0\244\0\u0290\0\u0290"+
    "\0\u02b9\0\u02e2\0\173\0\u030b\0\173\0\u0334\0\u035d\0\173"+
    "\0\u0386\0\173\0\u03af\0\173\0\u03d8\0\173\0\u0401\0\173"+
    "\0\173\0\173\0\u042a\0\u0453\0\173\0\u047c\0\173\0\u04a5"+
    "\0\173\0\51\0\u04ce\0\u04f7\0\u0520\0\u0549\0\u0572\0\u059b"+
    "\0\u05c4\0\u05ed\0\u0616\0\u063f\0\u0668\0\u0691\0\u06ba\0\u06e3"+
    "\0\u070c\0\u0735\0\u075e\0\u0787\0\u07b0\0\u07d9\0\u0802\0\u082b"+
    "\0\u0854\0\u087d\0\u08a6\0\u08cf\0\u08f8\0\u0921\0\u094a\0\173"+
    "\0\u0973\0\u099c\0\u09c5\0\u09ee\0\u0a17\0\u0a40\0\173\0\u0a69"+
    "\0\u0a92\0\u0abb\0\u0ae4\0\u0b0d\0\u0b36\0\u0b5f\0\173\0\u0b88"+
    "\0\u0bb1\0\u0bda\0\173\0\u0c03\0\u0c2c\0\u0c55\0\u0c7e\0\u0ca7"+
    "\0\u0cd0\0\u0cf9\0\u0290\0\u0d22\0\u0d4b\0\u0d74\0\u0d9d\0\u0dc6"+
    "\0\u0def\0\u0e18\0\u0e41\0\u0e6a\0\u0e93";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[125];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /** 
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\2\1\3\2\4\1\5\1\6\1\7\1\10\1\11"+
    "\1\12\1\5\1\13\1\5\1\14\3\5\1\15\1\16"+
    "\3\5\1\17\1\20\1\21\1\5\1\22\1\23\4\5"+
    "\1\24\1\25\1\26\1\27\1\30\1\31\1\32\1\33"+
    "\1\34\53\0\1\4\52\0\1\5\1\0\1\35\2\0"+
    "\27\5\15\0\1\5\2\36\2\0\27\5\11\0\2\37"+
    "\1\40\1\37\3\41\1\37\1\0\2\37\25\41\11\37"+
    "\4\0\1\5\1\0\1\35\2\0\3\5\1\42\3\5"+
    "\1\43\17\5\15\0\1\5\1\0\1\35\2\0\13\5"+
    "\1\44\2\5\1\45\1\5\1\46\6\5\15\0\1\5"+
    "\1\0\1\35\2\0\6\5\1\47\3\5\1\50\14\5"+
    "\15\0\1\5\1\0\1\35\2\0\3\5\1\51\1\52"+
    "\12\5\1\53\1\5\1\54\5\5\15\0\1\5\1\0"+
    "\1\35\2\0\13\5\1\55\2\5\1\56\10\5\15\0"+
    "\1\5\1\0\1\35\2\0\3\5\1\57\3\5\1\60"+
    "\10\5\1\61\6\5\15\0\1\5\1\0\1\35\2\0"+
    "\16\5\1\62\1\5\1\63\6\5\15\0\1\5\1\0"+
    "\1\35\2\0\15\5\1\64\1\65\10\5\15\0\1\5"+
    "\1\0\1\35\2\0\3\5\1\66\3\5\1\67\10\5"+
    "\1\70\3\5\1\71\2\5\15\0\1\5\2\35\2\0"+
    "\27\5\11\0\2\37\1\72\50\37\1\72\1\37\3\73"+
    "\4\37\25\73\11\37\4\0\1\5\1\0\1\35\2\0"+
    "\4\5\1\74\22\5\15\0\1\5\1\0\1\35\2\0"+
    "\14\5\1\75\12\5\15\0\1\5\1\0\1\35\2\0"+
    "\22\5\1\76\4\5\15\0\1\5\1\0\1\35\2\0"+
    "\11\5\1\77\15\5\15\0\1\5\1\0\1\35\2\0"+
    "\17\5\1\100\7\5\15\0\1\5\1\0\1\35\2\0"+
    "\20\5\1\101\6\5\15\0\1\5\1\0\1\35\2\0"+
    "\7\5\1\102\17\5\15\0\1\5\1\0\1\35\2\0"+
    "\7\5\1\103\1\5\1\104\6\5\1\105\6\5\15\0"+
    "\1\5\1\0\1\35\2\0\2\5\1\106\24\5\15\0"+
    "\1\5\1\0\1\35\2\0\3\5\1\107\23\5\15\0"+
    "\1\5\1\0\1\35\2\0\21\5\1\110\5\5\15\0"+
    "\1\5\1\0\1\35\2\0\23\5\1\111\3\5\11\0"+
    "\2\37\1\72\1\37\3\112\4\37\25\112\11\37\4\0"+
    "\1\5\1\0\1\35\2\0\5\5\1\113\21\5\15\0"+
    "\1\5\1\0\1\35\2\0\15\5\1\114\11\5\15\0"+
    "\1\5\1\0\1\35\2\0\20\5\1\115\6\5\15\0"+
    "\1\5\1\0\1\35\2\0\12\5\1\116\14\5\15\0"+
    "\1\5\1\0\1\35\2\0\3\5\1\117\23\5\15\0"+
    "\1\5\1\0\1\35\2\0\6\5\1\120\20\5\15\0"+
    "\1\5\1\0\1\35\2\0\20\5\1\121\6\5\15\0"+
    "\1\5\1\0\1\35\2\0\4\5\1\122\22\5\15\0"+
    "\1\5\1\0\1\35\2\0\20\5\1\123\6\5\15\0"+
    "\1\5\1\0\1\35\2\0\4\5\1\124\22\5\15\0"+
    "\1\5\1\0\1\35\2\0\16\5\1\62\10\5\15\0"+
    "\1\5\1\0\1\35\2\0\5\5\1\125\21\5\15\0"+
    "\1\5\1\0\1\35\2\0\13\5\1\126\11\5\1\127"+
    "\1\130\15\0\1\5\1\0\1\35\2\0\7\5\1\131"+
    "\14\5\1\132\2\5\11\0\2\37\1\72\1\37\3\133"+
    "\4\37\25\133\11\37\4\0\1\5\1\0\1\35\2\0"+
    "\6\5\1\134\20\5\15\0\1\5\1\0\1\35\2\0"+
    "\16\5\1\45\10\5\15\0\1\5\1\0\1\35\2\0"+
    "\6\5\1\135\20\5\15\0\1\5\1\0\1\35\2\0"+
    "\5\5\1\136\21\5\15\0\1\5\1\0\1\35\2\0"+
    "\4\5\1\137\22\5\15\0\1\5\1\0\1\35\2\0"+
    "\4\5\1\140\22\5\15\0\1\5\1\0\1\35\2\0"+
    "\16\5\1\141\10\5\15\0\1\5\1\0\1\35\2\0"+
    "\6\5\1\142\20\5\15\0\1\5\1\0\1\35\2\0"+
    "\23\5\1\143\3\5\15\0\1\5\1\0\1\35\2\0"+
    "\6\5\1\144\20\5\15\0\1\5\1\0\1\35\2\0"+
    "\16\5\1\145\10\5\15\0\1\5\1\0\1\35\2\0"+
    "\16\5\1\146\10\5\15\0\1\5\1\0\1\35\2\0"+
    "\26\5\1\147\15\0\1\5\1\0\1\35\2\0\3\5"+
    "\1\150\23\5\15\0\1\5\1\0\1\35\2\0\22\5"+
    "\1\71\4\5\11\0\2\37\1\72\1\37\3\151\4\37"+
    "\25\151\11\37\4\0\1\5\1\0\1\35\2\0\4\5"+
    "\1\152\22\5\15\0\1\5\1\0\1\35\2\0\16\5"+
    "\1\153\10\5\15\0\1\5\1\0\1\35\2\0\6\5"+
    "\1\154\20\5\15\0\1\5\1\0\1\35\2\0\21\5"+
    "\1\54\5\5\15\0\1\5\1\0\1\35\2\0\24\5"+
    "\1\155\2\5\15\0\1\5\1\0\1\35\2\0\5\5"+
    "\1\60\21\5\15\0\1\5\1\0\1\35\2\0\16\5"+
    "\1\156\10\5\15\0\1\5\1\0\1\35\2\0\21\5"+
    "\1\157\5\5\15\0\1\5\1\0\1\35\2\0\24\5"+
    "\1\160\2\5\15\0\1\5\1\0\1\35\2\0\13\5"+
    "\1\161\13\5\15\0\1\5\1\0\1\35\2\0\5\5"+
    "\1\162\21\5\11\0\2\37\1\72\1\37\3\163\4\37"+
    "\25\163\11\37\4\0\1\5\1\0\1\35\2\0\7\5"+
    "\1\43\17\5\15\0\1\5\1\0\1\35\2\0\4\5"+
    "\1\164\22\5\15\0\1\5\1\0\1\35\2\0\4\5"+
    "\1\165\22\5\15\0\1\5\1\0\1\35\2\0\20\5"+
    "\1\166\6\5\15\0\1\5\1\0\1\35\2\0\20\5"+
    "\1\61\6\5\15\0\1\5\1\0\1\35\2\0\4\5"+
    "\1\167\22\5\15\0\1\5\1\0\1\35\2\0\3\5"+
    "\1\170\23\5\15\0\1\5\1\0\1\35\2\0\23\5"+
    "\1\67\3\5\15\0\1\5\1\0\1\35\2\0\7\5"+
    "\1\50\17\5\15\0\1\5\1\0\1\35\2\0\16\5"+
    "\1\171\10\5\15\0\1\5\1\0\1\35\2\0\4\5"+
    "\1\52\22\5\15\0\1\5\1\0\1\35\2\0\16\5"+
    "\1\172\10\5\15\0\1\5\1\0\1\35\2\0\23\5"+
    "\1\173\3\5\15\0\1\5\1\0\1\35\2\0\17\5"+
    "\1\174\7\5\15\0\1\5\1\0\1\35\2\0\17\5"+
    "\1\175\7\5\15\0\1\5\1\0\1\35\2\0\25\5"+
    "\1\127\1\130\15\0\1\5\1\0\1\35\2\0\20\5"+
    "\1\56\6\5\15\0\1\5\1\0\1\35\2\0\20\5"+
    "\1\65\6\5\11\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[3772];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /* error messages for the codes above */
  private static final String ZZ_ERROR_MSG[] = {
    "Unknown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\1\0\1\11\1\1\1\11\1\1\1\11\2\1\1\11"+
    "\12\1\11\11\2\1\1\0\1\1\1\0\30\1\1\11"+
    "\1\0\16\1\1\0\20\1\1\0\15\1\1\0\24\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[125];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** the input device */
  private java.io.Reader zzReader;

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private char zzBuffer[] = new char[ZZ_BUFFERSIZE];

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /** number of newlines encountered up to the start of the matched text */
  private int yyline;

  /** the number of characters up to the start of the matched text */
  private int yychar;

  /**
   * the number of characters from the last newline up to the start of the 
   * matched text
   */
  private int yycolumn;

  /** 
   * zzAtBOL == true <=> the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true <=> the scanner is at the EOF */
  private boolean zzAtEOF;

  /** denotes if the user-EOF-code has already been executed */
  private boolean zzEOFDone;
  
  /** 
   * The number of occupied positions in zzBuffer beyond zzEndRead.
   * When a lead/high surrogate has been read from the input stream
   * into the final zzBuffer position, this will have a value of 1;
   * otherwise, it will have a value of 0.
   */
  private int zzFinalHighSurrogate = 0;

  /* user code: */
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


  /**
   * Creates a new scanner
   *
   * @param   in  the java.io.Reader to read input from.
   */
  public Lexer1(java.io.Reader in) {
    this.zzReader = in;
  }


  /** 
   * Unpacks the compressed character translation table.
   *
   * @param packed   the packed character translation table
   * @return         the unpacked character translation table
   */
  private static char [] zzUnpackCMap(String packed) {
    char [] map = new char[0x110000];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < 152) {
      int  count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do map[j++] = value; while (--count > 0);
    }
    return map;
  }


  /**
   * Refills the input buffer.
   *
   * @return      <code>false</code>, iff there was new input.
   * 
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {

    /* first: make room (if you can) */
    if (zzStartRead > 0) {
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
      System.arraycopy(zzBuffer, zzStartRead,
                       zzBuffer, 0,
                       zzEndRead-zzStartRead);

      /* translate stored positions */
      zzEndRead-= zzStartRead;
      zzCurrentPos-= zzStartRead;
      zzMarkedPos-= zzStartRead;
      zzStartRead = 0;
    }

    /* is the buffer big enough? */
    if (zzCurrentPos >= zzBuffer.length - zzFinalHighSurrogate) {
      /* if not: blow it up */
      char newBuffer[] = new char[zzBuffer.length*2];
      System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
      zzBuffer = newBuffer;
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
    }

    /* fill the buffer with new input */
    int requested = zzBuffer.length - zzEndRead;
    int numRead = zzReader.read(zzBuffer, zzEndRead, requested);

    /* not supposed to occur according to specification of java.io.Reader */
    if (numRead == 0) {
      throw new java.io.IOException("Reader returned 0 characters. See JFlex examples for workaround.");
    }
    if (numRead > 0) {
      zzEndRead += numRead;
      /* If numRead == requested, we might have requested to few chars to
         encode a full Unicode character. We assume that a Reader would
         otherwise never return half characters. */
      if (numRead == requested) {
        if (Character.isHighSurrogate(zzBuffer[zzEndRead - 1])) {
          --zzEndRead;
          zzFinalHighSurrogate = 1;
        }
      }
      /* potentially more input available */
      return false;
    }

    /* numRead < 0 ==> end of stream */
    return true;
  }

    
  /**
   * Closes the input stream.
   */
  public final void yyclose() throws java.io.IOException {
    zzAtEOF = true;            /* indicate end of file */
    zzEndRead = zzStartRead;  /* invalidate buffer    */

    if (zzReader != null)
      zzReader.close();
  }


  /**
   * Resets the scanner to read from a new input stream.
   * Does not close the old reader.
   *
   * All internal variables are reset, the old input stream 
   * <b>cannot</b> be reused (internal buffer is discarded and lost).
   * Lexical state is set to <tt>ZZ_INITIAL</tt>.
   *
   * Internal scan buffer is resized down to its initial length, if it has grown.
   *
   * @param reader   the new input stream 
   */
  public final void yyreset(java.io.Reader reader) {
    zzReader = reader;
    zzAtBOL  = true;
    zzAtEOF  = false;
    zzEOFDone = false;
    zzEndRead = zzStartRead = 0;
    zzCurrentPos = zzMarkedPos = 0;
    zzFinalHighSurrogate = 0;
    yyline = yychar = yycolumn = 0;
    zzLexicalState = YYINITIAL;
    if (zzBuffer.length > ZZ_BUFFERSIZE)
      zzBuffer = new char[ZZ_BUFFERSIZE];
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final String yytext() {
    return new String( zzBuffer, zzStartRead, zzMarkedPos-zzStartRead );
  }


  /**
   * Returns the character at position <tt>pos</tt> from the 
   * matched text. 
   * 
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch. 
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBuffer[zzStartRead+pos];
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occured while scanning.
   *
   * In a wellformed scanner (no or only correct usage of 
   * yypushback(int) and a match-all fallback rule) this method 
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  } 


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Contains user EOF-code, which will be executed exactly once,
   * when the end of file is reached
   */
  private void zzDoEOF() throws java.io.IOException {
    if (!zzEOFDone) {
      zzEOFDone = true;
      yyclose();
    }
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public java_cup.runtime.Symbol next_token() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    char [] zzBufferL = zzBuffer;
    char [] zzCMapL = ZZ_CMAP;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      boolean zzR = false;
      int zzCh;
      int zzCharCount;
      for (zzCurrentPosL = zzStartRead  ;
           zzCurrentPosL < zzMarkedPosL ;
           zzCurrentPosL += zzCharCount ) {
        zzCh = Character.codePointAt(zzBufferL, zzCurrentPosL, zzMarkedPosL);
        zzCharCount = Character.charCount(zzCh);
        switch (zzCh) {
        case '\u000B':
        case '\u000C':
        case '\u0085':
        case '\u2028':
        case '\u2029':
          yyline++;
          yycolumn = 0;
          zzR = false;
          break;
        case '\r':
          yyline++;
          yycolumn = 0;
          zzR = true;
          break;
        case '\n':
          if (zzR)
            zzR = false;
          else {
            yyline++;
            yycolumn = 0;
          }
          break;
        default:
          zzR = false;
          yycolumn += zzCharCount;
        }
      }

      if (zzR) {
        // peek one character ahead if it is \n (if we have counted one line too much)
        boolean zzPeek;
        if (zzMarkedPosL < zzEndReadL)
          zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        else if (zzAtEOF)
          zzPeek = false;
        else {
          boolean eof = zzRefill();
          zzEndReadL = zzEndRead;
          zzMarkedPosL = zzMarkedPos;
          zzBufferL = zzBuffer;
          if (eof) 
            zzPeek = false;
          else 
            zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        }
        if (zzPeek) yyline--;
      }
      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;
  
      zzState = ZZ_LEXSTATE[zzLexicalState];

      // set up zzAction for empty match case:
      int zzAttributes = zzAttrL[zzState];
      if ( (zzAttributes & 1) == 1 ) {
        zzAction = zzState;
      }


      zzForAction: {
        while (true) {
    
          if (zzCurrentPosL < zzEndReadL) {
            zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
            zzCurrentPosL += Character.charCount(zzInput);
          }
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
              zzCurrentPosL += Character.charCount(zzInput);
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMapL[zzInput] ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
        zzAtEOF = true;
            zzDoEOF();
              {
                return symbol(EOF);
              }
      }
      else {
        switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
          case 1: 
            { error("Simbolo invalido <"+ yytext()+">");
            }
          case 36: break;
          case 2: 
            { /*Nothing to do*/
            }
          case 37: break;
          case 3: 
            { return symbol(IDENTIFICADOR, yytext());
            }
          case 38: break;
          case 4: 
            { return symbol(ENTERO, yytext());
            }
          case 39: break;
          case 5: 
            { return symbol(MULTIPLICACION, yytext());
            }
          case 40: break;
          case 6: 
            { return symbol(RESTA, yytext());
            }
          case 41: break;
          case 7: 
            { return symbol(COR_ABI, yytext());
            }
          case 42: break;
          case 8: 
            { return symbol(COR_CER, yytext());
            }
          case 43: break;
          case 9: 
            { return symbol(PAR_ABI, yytext());
            }
          case 44: break;
          case 10: 
            { return symbol(PAR_CER, yytext());
            }
          case 45: break;
          case 11: 
            { return symbol(DOS_PUNTOS, yytext());
            }
          case 46: break;
          case 12: 
            { return symbol(IGUAL, yytext());
            }
          case 47: break;
          case 13: 
            { return symbol(SUMA, yytext());
            }
          case 48: break;
          case 14: 
            { return symbol(DIVISION, yytext());
            }
          case 49: break;
          case 15: 
            { return symbol(COMA, yytext());
            }
          case 50: break;
          case 16: 
            { return symbol(DIGITO, yytext());
            }
          case 51: break;
          case 17: 
            { return symbol(COMENTARIO, yytext());
            }
          case 52: break;
          case 18: 
            { return symbol(FORWARD, yytext());
            }
          case 53: break;
          case 19: 
            { return symbol(RIGHT, yytext());
            }
          case 54: break;
          case 20: 
            { return symbol(BACKWARD, yytext());
            }
          case 55: break;
          case 21: 
            { return symbol(TOCENTER, yytext());
            }
          case 56: break;
          case 22: 
            { return symbol(CLEARS, yytext());
            }
          case 57: break;
          case 23: 
            { return symbol(HIDETURTLE, yytext());
            }
          case 58: break;
          case 24: 
            { return symbol(TODRAW, yytext());
            }
          case 59: break;
          case 25: 
            { return symbol(TOERASE, yytext());
            }
          case 60: break;
          case 26: 
            { return symbol(LEFT, yytext());
            }
          case 61: break;
          case 27: 
            { return symbol(SHOWTURTLE, yytext());
            }
          case 62: break;
          case 28: 
            { return symbol(PENDOWN, yytext());
            }
          case 63: break;
          case 29: 
            { return symbol(PENUP, yytext());
            }
          case 64: break;
          case 30: 
            { return symbol(POSITIONX, yytext());
            }
          case 65: break;
          case 31: 
            { return symbol(POSITIONY, yytext());
            }
          case 66: break;
          case 32: 
            { return symbol(COLOR, yytext());
            }
          case 67: break;
          case 33: 
            { return symbol(POSITIONXY, yytext());
            }
          case 68: break;
          case 34: 
            { return symbol(REPEAT, yytext());
            }
          case 69: break;
          case 35: 
            { return symbol(HEXADECIMAL, yytext());
            }
          case 70: break;
          default:
            zzScanError(ZZ_NO_MATCH);
        }
      }
    }
  }

  /**
   * Converts an int token code into the name of the
   * token by reflection on the cup symbol class/interface sym
   *
   * This code was contributed by Karl Meissner <meissnersd@yahoo.com>
   */
  private String getTokenName(int token) {
    try {
      java.lang.reflect.Field [] classFields = sym.class.getFields();
      for (int i = 0; i < classFields.length; i++) {
        if (classFields[i].getInt(null) == token) {
          return classFields[i].getName();
        }
      }
    } catch (Exception e) {
      e.printStackTrace(System.err);
    }

    return "UNKNOWN TOKEN";
  }

  /**
   * Same as next_token but also prints the token to standard out
   * for debugging.
   *
   * This code was contributed by Karl Meissner <meissnersd@yahoo.com>
   */
  public java_cup.runtime.Symbol debug_next_token() throws java.io.IOException {
    java_cup.runtime.Symbol s = next_token();
    System.out.println( "line:" + (yyline+1) + " col:" + (yycolumn+1) + " --"+ yytext() + "--" + getTokenName(s.sym) + "--");
    return s;
  }

  /**
   * Runs the scanner on input files.
   *
   * This main method is the debugging routine for the scanner.
   * It prints debugging information about each returned token to
   * System.out until the end of file is reached, or an error occured.
   *
   * @param argv   the command line, contains the filenames to run
   *               the scanner on.
   */
  public static void main(String argv[]) {
    if (argv.length == 0) {
      System.out.println("Usage : java Lexer1 [ --encoding <name> ] <inputfile(s)>");
    }
    else {
      int firstFilePos = 0;
      String encodingName = "UTF-8";
      if (argv[0].equals("--encoding")) {
        firstFilePos = 2;
        encodingName = argv[1];
        try {
          java.nio.charset.Charset.forName(encodingName); // Side-effect: is encodingName valid? 
        } catch (Exception e) {
          System.out.println("Invalid encoding '" + encodingName + "'");
          return;
        }
      }
      for (int i = firstFilePos; i < argv.length; i++) {
        Lexer1 scanner = null;
        try {
          java.io.FileInputStream stream = new java.io.FileInputStream(argv[i]);
          java.io.Reader reader = new java.io.InputStreamReader(stream, encodingName);
          scanner = new Lexer1(reader);
          while ( !scanner.zzAtEOF ) scanner.debug_next_token();
        }
        catch (java.io.FileNotFoundException e) {
          System.out.println("File not found : \""+argv[i]+"\"");
        }
        catch (java.io.IOException e) {
          System.out.println("IO error scanning file \""+argv[i]+"\"");
          System.out.println(e);
        }
        catch (Exception e) {
          System.out.println("Unexpected exception:");
          e.printStackTrace();
        }
      }
    }
  }


}
