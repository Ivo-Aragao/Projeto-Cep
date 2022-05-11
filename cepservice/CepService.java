/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cepservice;

import com.google.gson.Gson;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import cepmodel.CepModel.CEP;

/**
 *
 * @author USUARIO
 */
public class CepService {
 



	private int cep;

	
		
		public CepService(int cep) {
			this.cep = cep;
			
		}

     
		
		
		//método da mágica
		public CEP retornarCEP() throws IOException {
			StringBuilder resposta = new StringBuilder();
			
			try {
				URL url = new URL("https://viacep.com.br/ws/" + 
				this.cep + "/json/");
				
				HttpURLConnection conexao = (HttpURLConnection) 
				url.openConnection();
				
				//Requisicao
				conexao.setRequestMethod("GET");
				conexao.setRequestProperty("Content-type", 
						"application/json");
				conexao.setRequestProperty("Accept", "application/json");
				
				conexao.connect();
				
                            try 
                                (Scanner scanner = new Scanner(url.openStream())) {
                                while(scanner.hasNext()) {
                                    resposta.append(scanner.next());
                                }
                                conexao.disconnect();
                            }
				
				CEP objetoJson = new Gson().fromJson(
						resposta.toString(), CEP.class);
				
			
				return objetoJson;
				
			} catch (MalformedURLException e) {
                            // TODO Auto-generated catch block

			}
			return null;
		}
		
		
		
		public int getCep() {
			return cep;
		}
		public void setCep(int cep) {
			this.cep = cep;
		}
		
		
		
	
}
