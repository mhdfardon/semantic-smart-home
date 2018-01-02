/*******************************************************************************
    Machine to Machine Measurement (M3) Framework 
    Copyright(c) 2012 - 2015 Eurecom

    M3 is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.


    M3 is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with M3. The full GNU General Public License is 
   included in this distribution in the file called "COPYING". If not, 
   see <http://www.gnu.org/licenses/>.

  Contact Information
  M3 : gyrard__at__eurecom.fr, bonnet__at__eurecom.fr, karima.boudaoud__at__unice.fr
  
The M3 framework has been designed and implemented during Amelie Gyrard's thesis.
She is a PhD student at Eurecom under the supervision of Prof. Christian Bonnet (Eurecom) and Dr. Karima Boudaoud (I3S-CNRS/University of Nice Sophia Antipolis).
This work is supported by the Com4Innov platform of the Pole SCS and DataTweet (ANR-13-INFR-0008). 
  
  Address      : Eurecom, Campus SophiaTech, 450 Route des Chappes, CS 50193 - 06904 Biot Sophia Antipolis cedex, FRANCE

 *******************************************************************************/
package fr.liris.semantic.m3.common;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import com.hp.hpl.jena.rdf.model.Model;
//import sun.misc.IOUtils;

/**
 * Funtions to read file from a path and enrich the jena model or get the content of the file in a string
 * @author Amelie gyrard
 *
 */
public class ReadFile {


	/**
	 * Read ontologies or RDF dataset, included directly from the file (a path) and add it to the jena model
	 * @param model
	 * @param file
	 */
	public static void enrichJenaModelOntologyDataset(Model model, String file){
		try {
			
//			FileOutputStream out = new FileOutputStream("xx.xxx");
//			File fr = new File(file);
//			String getAbsolutePath = fr.getAbsolutePath();
//			String getCanonicalPath = fr.getCanonicalPath();
//			System.out.println(getAbsolutePath);
//			System.out.println(getCanonicalPath);
			InputStream in = new FileInputStream(file);
			model.read( in, file );//file:"+
			in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	/**
	 * Read the content of a file, ex. Sparql, or ontologies or datasets and store it in string
	 * @param file
	 * @return String the content of the file
	 */
	public static String readContentFile(String file){
		String text="";
		try{
			InputStream ips=new FileInputStream(file); 
			InputStreamReader ipsr=new InputStreamReader(ips);
			BufferedReader br=new BufferedReader(ipsr);
			String ligne;
			while ((ligne=br.readLine())!=null){
				text+=ligne+"\n";
			}
			br.close(); 
		}		
		catch (Exception e){
			e.printStackTrace();
		}
		return text;
	}
	
	public String readContentFile2(String file){
		String text="";
		try{
			ClassLoader classLoader = this.getClass().getClassLoader();
			File file1 = new File(classLoader.getResource(file).getFile());

			InputStream ips=new FileInputStream(file1);
//			 ips=new FileInputStream(file);
			InputStreamReader ipsr=new InputStreamReader(ips);
			BufferedReader br=new BufferedReader(ipsr);
			String ligne;
			while ((ligne=br.readLine())!=null){
				text+=ligne+"\n";
			}
			br.close(); 
		}		
		catch (Exception e){
			e.printStackTrace();
		}
		return text;
	}
}
