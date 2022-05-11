/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ceptext;

import cepservice.CepService;
import java.io.IOException;
import java.util.Scanner;
import cepmodel.CepModel.CEP;

/**
 *
 * @author USUARIO
 */
public class CepText {
   

	static Scanner in = new Scanner(System.in);
	
	public static void main(String[] Args) throws IOException {
		System.out.println("digite um cep:");
		CEP cep = new CepService(in.nextInt()).retornarCEP();
		
		System.out.println(cep.getDdd());
		System.out.println(cep.getLocalidade());
	 
	    
		
		

	}

    }

