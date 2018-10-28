import java.io.*;
import java.util.*;

public class Test {

	public static void main(String[] args) {
		
		try
		{
			Scanner scanner = new Scanner (new BufferedReader (new FileReader (new File ("C:\\Users\\moi\\Desktop\\cour imt\\acdc\\exemple vcf.vcf"))));
			Scanner scannerInter = new Scanner (new BufferedReader (new FileReader (new File ("C:\\Users\\moi\\Desktop\\cour imt\\acdc\\exemple-vcf-partinter.vcf"))));
			Scanner scannerInter2 = new Scanner (new BufferedReader (new FileReader (new File ("C:\\Users\\moi\\Desktop\\cour imt\\acdc\\exemple-vcf-partinter.vcf"))));
			/* découpe du fichier vcf en 3 fichiers différents 
			 * 1 fichier contenant les métadonnées commençant par ## (part1)
			 * 1 fichier contenant les colonnes impaires (part2)
			 * 1 fichier contenant les colonnes paires (part3)
			 */
			
			PrintWriter part1 = new PrintWriter("C:\\Users\\moi\\Desktop\\cour imt\\acdc\\exemple-vcf-part1.vcf"); // création d'un nouveau fichier vcf
			PrintWriter partInter = new PrintWriter("C:\\Users\\moi\\Desktop\\cour imt\\acdc\\exemple-vcf-partinter.vcf"); // création d'un nouveau fichier vcf intermédiaire
			PrintWriter part2 = new PrintWriter("C:\\Users\\moi\\Desktop\\cour imt\\acdc\\exemple-vcf-part2.vcf"); // création d'un nouveau fichier vcf
			PrintWriter part3 = new PrintWriter("C:\\Users\\moi\\Desktop\\cour imt\\acdc\\exemple-vcf-part3.vcf"); // création d'un nouveau fichier vcf
			
			
			String lector; // récupère la ligne de lecture actuel du fichier VCF
			String meta;
			String lectorInter;
			String lectorInter2;
			String lectorInterSui;
			meta="##"; // tous les lignes de métadonnées commence par ##
			lector=scanner.nextLine(); // premiere ligne du fichier
			
			while (true) {
				
				if(lector.substring(0,2).equals(meta)) {
				try {
					
					 part1.println(lector);
					 lector=scanner.nextLine();
					 
									}
				catch(NoSuchElementException exception) // quitte la boucle si il n'y a plus de ligne à scanner
			        {
			            System.out.println("Attention: le fichier ne contient pas de métadonnées");
						break;
			        }
				
			}else{
		
					
			try {				
				 partInter.println(lector);
				 lector=scanner.nextLine();
				 
								}
			catch(NoSuchElementException exception) // quitte la boucle si il n'y a plus de ligne à scanner
		        {
		        	break;
		        }
			}
			}
		part1.close();
		partInter.close();
		
		lectorInter=scannerInter.next();
		lectorInterSui=scannerInter.next();
		lectorInter2=scannerInter2.nextLine();
		
		System.out.println(lectorInter);
		System.out.println(lectorInterSui);
		while (true){
			try {
				
				System.out.println(lectorInter2);
				System.out.println(lectorInter);
				System.out.println(lectorInterSui);
				System.out.println(lectorInter2.substring(lectorInter2.lastIndexOf(" ")).length());
				System.out.println(lectorInter.length());
				if((lectorInter2.substring(lectorInter2.lastIndexOf(" ")).length()==lectorInter.length()+1)||(lectorInter2.substring(lectorInter2.lastIndexOf(" ")).length()==lectorInterSui.length()+1)) {
					if (lectorInter.equals(lectorInter2.substring(lectorInter2.lastIndexOf(lectorInter)))||(lectorInterSui.equals(lectorInter2.substring(lectorInter2.lastIndexOf(lectorInterSui))))) {
						part2.println();
						part3.println();
						System.out.println("rhaa");
						lectorInter2=scannerInter2.nextLine();
					}
				}else {
					part2.print(lectorInter);
					part2.print(" ");
					lectorInter=scannerInter.next();
					
					if((lectorInter2.substring(lectorInter2.lastIndexOf(" ")).length()==lectorInter.length()+1)||(lectorInter2.substring(lectorInter2.lastIndexOf(" ")).length()==lectorInterSui.length()+1)) {
						if (lectorInter.equals(lectorInter2.substring(lectorInter2.lastIndexOf(lectorInter)))||(lectorInterSui.equals(lectorInter2.substring(lectorInter2.lastIndexOf(lectorInterSui))))) {
							part2.println();
							part3.println();
							lectorInter2=scannerInter2.nextLine();
						}}
					
					
					part3.print(lectorInterSui);
					part3.print(" ");
					lectorInterSui=scannerInter.next();
				
				}
				}
			catch(NoSuchElementException exception) {
				break;
			}
		}
		part2.close();
		part3.close();
		
		}
		
		catch (FileNotFoundException exception)
		{
	    System.out.println ("Le fichier n'a pas été trouvé");
		}
	
		
}}
