/* This class study the following functions:
 * 1) replace string in a utf8 text file.
 * 2) wrap System.out to print utf8 character
 * 3) use "Character" class as utility api to handle such as utf-16 surrogate code 
 * 4) use printf format
 */
package com.ghe.exercise;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

public class StringStudy {
	private static final String FNAME = "C:\\work\\eclipse\\workspace\\effective-java-examples\\pom.xml";
	private static final String ANCHOR1 = "<mainClass>org/effectivejava/examples/";
	private static final String ANCHOR2 = "</mainClass>";
	
	//4 chars but actually 3 characters: ドラ𩸽
    private static final char[] UTF8CHAR = {'\u30c9', '\u30e9', '\ud867', '\ude3d'};


    /**
     * Replace the substring between anchor1 and anchor2 in file fname
     * with the param replacement.
     *
     * @param  fname        Full path of the file
     * @param  replacement  the string to replace the target
     * @param  anchor1      the before anchor of the target string
     * @param  anchor2      the after anchor of the target string
     *
     * @return 0       success
     *         1       failed
     *
     * @exception  IOException   If I/O failed.
     */
	public int replace(String fname, String replacement, String anchor1, String anchor2) 
	        throws IOException  {

		File file = new File(fname);
		FileInputStream fis = new FileInputStream(file);
		//BufferedReader(Reader in, int size) //size default is 8192
		//InputStreamReader(InputStream in, String charsetName)
		BufferedReader in = new BufferedReader(new InputStreamReader(fis, "utf-8"));
		
		File tmpfile = File.createTempFile("tmp-", ".tmp");
		System.out.println("tmp file is:" + tmpfile.getAbsolutePath());
		//BufferedWriter(Writer out, int size)   //size default is 8192
		//OutputStreamWriter(OutputStream out, String charsetName)
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(tmpfile), "utf-8"));
		
		String line = in.readLine();
		while(line != null) {
			int pos = line.indexOf(anchor1);
			if(pos != -1) {
                StringBuilder sb = new StringBuilder(line.substring(0, pos)); 			
			    sb.append(anchor1);
			    sb.append(replacement);
			    sb.append(anchor2);
			    line = sb.toString();
			}
			out.write(line);
			out.newLine();
			line = in.readLine();
		}
		in.close();
		out.close();
		
		if(file.delete()) {
			if(tmpfile.renameTo(file) == false) {
				System.out.println("Failed when rename file");
				return(-1);
			}
		}else{
			System.out.println("Failed when delete file");
			return(-1);
		}
		
		return(0);
	}
	
    /**
     * Get a PrintStream instance that wraps System.out with ability to handle utf-8
     *
     * @param
     *
     * @return an instance of PrintStream 
     *
     * @exception
     */
	public static PrintStream getUTF8SystemOut() {
        try {
        	return new PrintStream(System.out, true, "utf-8");
        }catch(UnsupportedEncodingException e) {
        	return System.out;
        }
	}

	private static void executeReplace() {
		StringStudy ss = new StringStudy();
		try {
			if(0 == ss.replace(FNAME, 
					"chapter03/item10/PhoneNumber",
					ANCHOR1,
					ANCHOR2
					)) {
				System.out.println("Succeed!");
			}else{
				System.out.println("failed!");
			}
		}catch(IOException e) {
			System.out.println("failed!");
		}
	}
	
	public static void main(String[] args) {
		//executeReplace();

		//check if utf8 JP characters can be printed on console without garbled text
		PrintStream out = StringStudy.getUTF8SystemOut();
        String str = new String(UTF8CHAR);
        out.println("str length=" + str.length() + ";  str=" + str);
        
        //The following code snippet counts how many characters are in a utf-8 string. 
        //In java a string consists of utf16 chars. Each char consists of 2 bytes. 
        //String.lenght returns the number of "char"s, not actual number of characters
        //because an extended characters has high and low surrogate code, so that one
        //such character consists of 2 chars, means 4 bytes.
        //The class "Character" has the utility API to handle utf-16 surrogate code.
        int count=0;
        for(int i=0; i<str.length(); i++) {
        	if(Character.isHighSurrogate(str.charAt(i))) {
        		i++;
        	}
        	count++;
        }
        //I intend to use Kanji string to check if the wrapped "out" works fine.
        out.println("このStringにある文字数は　" + count + " です。");

        //printf a int with format
        int aInt = 0xDBFFDFFF;
        out.printf("0x%08X\n", aInt);

	}

}
