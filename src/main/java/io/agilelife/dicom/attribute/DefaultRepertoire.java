package io.agilelife.dicom.attribute;

public class DefaultRepertoire
{
	public static final char SPACE_CHAR = ' ';
	public static final byte SPACE_BYTE = 0x20;
	
	public static final char BACKSLASH_CHAR = '\\';
	public static final byte BACKSLASH_BYTE = 0x5C;
	
	public static final char[] DECIMAL_DIGIT_CHARS = {
		'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'
	};
	public static final byte[] DECIMAL_DIGIT_BYTES = {
		0x30, // 0
		0x31, // 1
		0x32, // 2
		0x33, // 3
		0x34, // 4
		0x35, // 5
		0x36, // 6
		0x37, // 7
		0x38, // 8
		0x39  // 9
	};
	
	public static final char[] HEXADECIMAL_DIGIT_CHARS = {
		'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 
		'A', 'B', 'C', 'D', 'E', 'F', 'a', 'b', 'c', 'd', 'e', 'f'
	};
	public static final byte[] HEXADECIMAL_DIGIT_BYTES = {
		0x30, // 0
		0x31, // 1
		0x32, // 2
		0x33, // 3
		0x34, // 4
		0x35, // 5
		0x36, // 6
		0x37, // 7
		0x38, // 8
		0x39, // 9
		
		0x41, // A
		0x42, // B
		0x43, // C
		0x44, // D
		0x45, // E
		0x46, // F
		
		0x61, // a
		0x62, // b
		0x63, // c
		0x64, // d
		0x65, // e
		0x66, // f
	};
	
	public static final char[] UPPER_CASE_LETTER_CHARS = {
		'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 
		'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'
	};
	public static final byte[] UPPER_CASE_LETTER_BYTES = {
		0x41, // A
		0x42, // B
		0x43, // C
		0x44, // D
		0x45, // E
		0x46, // F
		0x47, // G
		0x48, // H
		0x49, // I
		0x4A, // J
		0x4B, // K
		0x4C, // L
		0x4D, // M
		0x4E, // N
		0x4F, // O
		
		0x50, // P
		0x51, // Q
		0x52, // R
		0x53, // S
		0x54, // T
		0x55, // U
		0x56, // V
		0x57, // W
		0x58, // X
		0x59, // Y
		0x5A  // Z
	};
	
	public static final char[] LOWER_CASE_LETTER_CHARS = {
		'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 
		'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'
	};
	public static final byte[] LOWER_CASE_LETTER_BYTES = {
		0x61, // a
		0x62, // b
		0x63, // c
		0x64, // d
		0x65, // e
		0x66, // f
		0x67, // g
		0x68, // h
		0x69, // i
		0x6A, // j
		0x6B, // k
		0x6C, // l
		0x6D, // m
		0x6E, // n
		0x6F, // o
		
		0x70, // p
		0x71, // q
		0x72, // r
		0x73, // s
		0x74, // t
		0x75, // u
		0x76, // v
		0x77, // w
		0x78, // x
		0x79, // y
		0x7A  // z
	};
	
	public static final char[] SYMBOL_CHARS = {
		'!', '"', '#', '$', '%', '&', '\'', '(', ')', '*', 
		'+', ',', '-', '.', '/', ':', ';', '<', '=', '>', 
		'?', '@', '[', '\\', ']', '^', '_', '`', '{', '|',
		'}', '~'
	};
	public static final byte[] SYMBOL_BYTES = {
		0x21, // !
		0x22, // "
		0x23, // #
		0x24, // $
		0x25, // %
		0x26, // &
		0x27, // '
		0x28, // (
		0x29, // )
		0x2A, // *
		0x2B, // +
		0x2C, // ,
		0x2D, // -
		0x2E, // .
		0x2F, // / (Forward slash)
		
		0x3A, // :
		0x3B, // ;
		0x3C, // <
		0x3D, // =
		0x3E, // >
		0x3F, // ?
		
		0x40, // @
		
		0x5B, // [
		0x5C, // \ (Backslash)
		0x5D, // ]
		0x5E, // ^
		0x5F, // _
		
		0x60, // `
		
		0x7B, // {
		0x7C, // |
		0x7D, // }
		0x7E  // ~
	};
	
	public static final char[] CONTROL_CHARS = {
		0, 1, 2, 3, 4, 5, 6, 7, 8, 9, '\n', 11, '\f', '\r', 14, 15, 
		16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, // 27 == ESC
		28, 29, 30, 31
	};
	public static final byte[] CONTROL_BYTES = {
		0x00, // non-graphical
		0x01, // non-graphical
		0x02, // non-graphical
		0x03, // non-graphical
		0x04, // non-graphical
		0x05, // non-graphical
		0x06, // non-graphical
		0x07, // non-graphical
		0x08, // non-graphical
		0x09, // TAB (horizontal)
		0x0A, // LF
		0x0B, // non-graphical
		0x0C, // FF
		0x0D, // CR
		0x0E, // non-graphical
		0x0F,  // non-graphical
		
		0x10, // non-graphical
		0x11, // non-graphical
		0x12, // non-graphical
		0x13, // non-graphical
		0x14, // non-graphical
		0x15, // non-graphical
		0x16, // non-graphical
		0x17, // non-graphical
		0x18, // non-graphical
		0x19, // non-graphical
		0x1A, // non-graphical
		0x1B, // ESC
		0x1C, // non-graphical
		0x1D, // non-graphical
		0x1E, // non-graphical
		0x1F  // non-graphical
	};
	
	//
	// Special-purpose char/byte lists
	//
	
	public static final char[] AE_LETTER_CHARS = {'D', 'M', 'W', 'Y'};
	public static final byte[] AE_LETTER_BYTES = {
		0x44, // D
		0x4D, // M
		
		0x57, // W
		0x59, // Y
	};
	
	//
	// Convenience methods
	//
	
	public static boolean isSymbol (char c) { return is (SYMBOL_CHARS, c); }
	public static boolean isSymbol (byte b) { return is (SYMBOL_BYTES, b); }
	
	public static boolean isDecimalDigit (char c) { return is (DECIMAL_DIGIT_CHARS, c); }
	public static boolean isDecimalDigit (byte b) { return is (DECIMAL_DIGIT_BYTES, b); }
	
	public static boolean isHexadecimalDigit (char c) { return is (HEXADECIMAL_DIGIT_CHARS, c); }
	public static boolean isHexadecimalDigit (byte b) { return is (HEXADECIMAL_DIGIT_BYTES, b); }
	
	public static boolean isLetter (char c) { return isUpperCaseLetter (c) || isLowerCaseLetter (c); }
	public static boolean isLetter (byte b) { return isUpperCaseLetter (b) || isLowerCaseLetter (b); }
	
	public static boolean isUpperCaseLetter (char c) { return is (UPPER_CASE_LETTER_CHARS, c); }
	public static boolean isUpperCaseLetter (byte b) { return is (UPPER_CASE_LETTER_BYTES, b); }
	
	public static boolean isLowerCaseLetter (char c) { return is (LOWER_CASE_LETTER_CHARS, c); }
	public static boolean isLowerCaseLetter (byte b) { return is (LOWER_CASE_LETTER_BYTES, b); }
	
	public static boolean isControlCharacter (char c) { return is (CONTROL_CHARS, c); }
	public static boolean isControlCharacter (byte b) { return is (CONTROL_BYTES, b); }
	
	public static boolean is (char[] accepted, char c)
	{
		for (char ok : accepted) if (ok == c) return true;
		return false;
	}
	
	public static boolean is (byte[] accepted, byte c)
	{
		for (byte ok : accepted) if (ok == c) return true;
		return false;
	}
	
	public static void main (String[] args)
	{
		System.out.println (HEXADECIMAL_DIGIT_BYTES[0]);
		System.out.println ((char) HEXADECIMAL_DIGIT_BYTES[0]);
		
		System.out.println (isDecimalDigit ('0'));
		System.out.println (isDecimalDigit ((byte) 48));
	}
}
