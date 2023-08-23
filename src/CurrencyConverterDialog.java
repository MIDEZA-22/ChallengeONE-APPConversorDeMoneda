import javax.swing.JOptionPane;

public class CurrencyConverterDialog {	
	public static void main(String[] args) {
		boolean continueConversion = true;
		
		while (continueConversion) {
	        String[] mainOptions = {
	        		"Conversión de Moneda"
	        };
	
	        String selectedMainOption = (String) JOptionPane.showInputDialog(
	                null,
	                "Selecciona una opción:",
	                "Aplicación de Conversión",
	                JOptionPane.PLAIN_MESSAGE,
	                null,
	                mainOptions,
	                mainOptions[0]
	        );
	        
	        if (selectedMainOption == null) {
	        	JOptionPane.showMessageDialog(
		            null,
		            "Programa Finalizado.",
		            "Mensaje",
		            JOptionPane.INFORMATION_MESSAGE
				);
	        	return; // Salir del programa si el usuario cancela el cuadro de diálogo
	        };
	        
	        if (selectedMainOption.equals("Conversión de Moneda")) {
	            String[] currencyConversionOptions = {
	                "De Moneda de Perú a Dólar",
	                "De Moneda de Perú a Euro",
	                "De Moneda de Perú a Libra Esterlina",
	                "De Moneda de Perú a Yen Japonés",
	                "De Moneda de Perú a Won Surcoreano"
	            };
	            
	            String selectedCurrencyOption = (String) JOptionPane.showInputDialog(
	                null,
	                "Selecciona la conversión de moneda:",
	                "Conversión de Moneda",
	                JOptionPane.PLAIN_MESSAGE,
	                null,
	                currencyConversionOptions,
	                currencyConversionOptions[0]
	            );
	            
	            if (selectedCurrencyOption == null) {
		        	JOptionPane.showMessageDialog(
			            null,
			            "Programa Finalizado.",
			            "Mensaje",
			            JOptionPane.INFORMATION_MESSAGE
					);
		        	return; // Salir del programa si el usuario cancela el cuadro de diálogo
		        };
	        
		        if (selectedCurrencyOption != null) {
		        	double amount = 0;
		        	
		        	try {
		                String amountString = JOptionPane.showInputDialog(
	                		null,
	                		"Ingresa el monto en Moneda de Perú:",
	                		"Entrada",
	                		JOptionPane.PLAIN_MESSAGE
		                );
		                
		                // Validar la entrada para asegurarse de que sea numérica
		                if (amountString != null && !amountString.isEmpty()) {
		                    amount = Double.parseDouble(amountString);
		                } else {
		                	if (amountString == null) {
		                        JOptionPane.showMessageDialog(
		                            null,
		                            "Programa Finalizado.",
		                            "Mensaje",
		                            JOptionPane.INFORMATION_MESSAGE
		                        );
		                        return; // Salir del programa si el usuario cancela el cuadro de diálogo
		                    } else {
		                        JOptionPane.showMessageDialog(
		                            null,
		                            "No ingresó ningún valor",
		                            "Mensaje",
		                            JOptionPane.INFORMATION_MESSAGE
		                        );
		                    }
		                }
		            } catch (NumberFormatException e) {
		                JOptionPane.showMessageDialog(
		                    null,
		                    "Ingresa un valor numérico válido.",
		                    "Error de Entrada",
		                    JOptionPane.ERROR_MESSAGE
		                );
		            }
	
			        double usdRate = 0.26947; // Dólar estadounidense (USD)
			        double eurRate = 0.24796; // Euro (EUR)
			        double gbpRate = 0.21168; // Libra esterlina (GBP)
			        double jpyRate = 38.99200; // Yen japonés (JPY)
			        double krwRate = 358.82400; // Won Surcoreano (KRW)
			        
			        double penAmount = 0;
			        
			        switch (selectedCurrencyOption) {
			            case "De Moneda de Perú a Dólar":
			                penAmount = amount * usdRate;
			                break;
			            case "De Moneda de Perú a Euro":
			                penAmount = amount * eurRate;
			                break;
			            case "De Moneda de Perú a Libra Esterlina":
			                penAmount = amount * gbpRate;
			                break;
			            case "De Moneda de Perú a Yen Japonés":
			                penAmount = amount * jpyRate;
			                break;
			            case "De Moneda de Perú a Won Surcoreano":
			                penAmount = amount * krwRate;
			                break;
			        }
			        
			        JOptionPane.showMessageDialog(
			            null,
			            "Resultado: " + Math.round(penAmount * 100.0) / 100.0  + " PEN",
			            "Resultado de la Conversión",
			            JOptionPane.INFORMATION_MESSAGE
				    );
			        
			        int confirmResult = JOptionPane.showConfirmDialog(
	                    null,
	                    "¿Desea continuar?",
	                    "Confirmación",
	                    JOptionPane.YES_NO_CANCEL_OPTION
	                );
			        
			        if (confirmResult == JOptionPane.YES_OPTION) {
			            // El usuario eligió continuar
			        	continueConversion = true;
			        } else {
			            // El usuario eligió no continuar
			        	JOptionPane.showMessageDialog(
				            null,
				            "Programa Finalizado.",
				            "Mensaje",
				            JOptionPane.INFORMATION_MESSAGE
						);
			        	return;
			        }
		        }
	        }
		}    
	}
}