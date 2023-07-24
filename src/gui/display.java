package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class display extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	//Tasa Conversion Moneda
	double tasaDolar = 17.14;
	double tasaEuro = 18.79;
	double tasaLibra = 22.00;
	double tasaYen = 0.12;
	double tasaSul = 75.64;
	
	//Tasa Conversion Temperatura
	double kelvil = 16.20;
	double farengei = 16.20;
	
	String cantidad;
	double valor = 0; 
	double resultado = 0;
	boolean sinTipo = true;
		
	JFrame display1, display2, display3;
	JPanel panel1, panel2, panel3;
	JLabel texto1, texto2, texto3;
	JComboBox<String> lista1, lista2, lista3, lista4;
	JButton boton1, boton2;
	
	
	public display () {
		ventanaPrincipal();
	}
	
	public void ventanaPrincipal() {
		display1 = new JFrame();
		panel1 = new JPanel();
		texto1 = new JLabel();
		lista1 = new JComboBox<String>();
		boton1 = new JButton();
		boton2 = new JButton();
		
		panel1.setBounds(0,50,300,100);
		display1.setBounds(500,300,300,200); 				//(X,Y,Xa,Ya) Posisición X,Y Tamaño Xa,Ya
		display1.setLayout(null);							//Posición Absoluta
		display1.setDefaultCloseOperation(EXIT_ON_CLOSE);	//Termina app al cerrar
		display1.setResizable(false);						//No permite modificar tamaño usuario
		display1.setTitle("Ventana prinicpal");				//Titulo
		
		
		texto1.setText("Tipo de conversión");
		texto1.setHorizontalAlignment(SwingConstants.CENTER);
		texto1.setFont(new Font("Arial Bold", Font.PLAIN, 13));
		texto1.setBounds(40, 10, 200, 30);
		
		lista1.addItem("Seleccionar");
		lista1.addItem("Temperatura");
		lista1.addItem("Moneda");
		lista1.setSelectedIndex(0);
								
		boton1.setBounds(35, 100, 100, 30);
		boton1.setText("Aceptar");
		boton1.setBackground(Color.lightGray);
		
		boton2.setBounds(150, 100, 100, 30);
		boton2.setText("Cancelar");
		boton2.setBackground(Color.lightGray);
		
		boton1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
															
				if ((lista1.getSelectedIndex()) == 0) {
					JOptionPane.showMessageDialog(null, "Selecciones un tipo de cambio");					
				} else {
					lista1.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							lista1.getSelectedIndex();
						}
					});
				}
				
				int i = lista1.getSelectedIndex();
				
				switch(i) {
					case 1:	
						Validar();
						display1.setVisible(false);
						ventanaTipoConversionTemperatura();
						break;
					case 2:
						Validar();
						display1.setVisible(false);
						ventanaTipoConversionMoneda();
						break;
				}
			}
		});
									
		boton2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(boton2, "Fin");	
				cerrar();
			}
			
		});
		
		
		display1.setVisible(true);
		display1.add(texto1);
		display1.add(boton1);
		display1.add(boton2);
		panel1.add(lista1);
		display1.add(panel1);
		
	}
	
	public void ventanaTipoConversionMoneda() {
		display2 = new JFrame();
		panel2 = new JPanel();
		texto2 = new JLabel();
		lista2 = new JComboBox<String>();
		boton1 = new JButton();
		boton2 = new JButton();
		
		panel2.setBounds(0,40,500,200);
		display2.setBounds(400,300,500,200); //(X,Y,Xa,Ya) Posisición X,Y Tamaño Xa,Ya
		display2.setLayout(null);
		display2.setDefaultCloseOperation(EXIT_ON_CLOSE);
		display2.setResizable(false);
		display2.setTitle("Seleccione Divisa");
		
		texto2.setText("Elija la moneda que desear convertir");
		texto2.setHorizontalAlignment(SwingConstants.CENTER);
		texto2.setFont(new Font("Arial Bold", Font.PLAIN, 13));
		texto2.setBounds(125,0,250,30);
			
		lista2.addItem("Seleccionar");
		lista2.addItem("PesoMX a Dólar");
		lista2.addItem("PesoMX a Euros");
		lista2.addItem("PesoMX a Libras Esterlinas");
		lista2.addItem("PesoMX a Yen Japonés");
		lista2.addItem("PesoMX a Won sul-coreano");
		lista2.addItem("Dólar a PesoMX");
		lista2.addItem("Euros a PesoMX");
		lista2.addItem("Libras Esterlinas a PesoMX");
		lista2.addItem("Yen Japonés a PesoMX");
		lista2.addItem("Won sul-coreano a PesoMX");
		lista2.setSelectedIndex(0);
		
		boton1.setBounds(125, 100, 100, 30);
		boton1.setText("Aceptar");
		boton1.setBackground(Color.lightGray);
		
		boton2.setBounds(275, 100, 100, 30);
		boton2.setText("Cancelar");
		boton2.setBackground(Color.lightGray);
				
		boton1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if ((lista2.getSelectedIndex()) == 0) {
					JOptionPane.showMessageDialog(null, "Selecciones un tipo de cambio");					
				} else {
					lista2.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							lista2.getSelectedIndex();	
						}
						
					});
				}
				
				convesorMoneda(lista2.getSelectedIndex());
					
			}			
		});
		
		boton2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int selec;
				selec = JOptionPane.showConfirmDialog(null, "Cerrar"); //si=0, No=1, Cancela=2
				if(selec == 0) {
					cerrar();
				}
			}
		});
		
		display2.setVisible(true);
		display2.add(texto2);
		display2.add(boton1);
		display2.add(boton2);
		panel2.add(lista2);
		display2.add(panel2);
		
	}
	
	public void ventanaTipoConversionTemperatura() {
		display3 = new JFrame();
		panel3 = new JPanel();
		texto3 = new JLabel();
		lista3 = new JComboBox<String>();
		lista4 = new JComboBox<String>();
		boton1 = new JButton();
		boton2 = new JButton();
		
		panel3.setBounds(0,40,500,200);
		display3.setBounds(400,300,500,200); //(X,Y,Xa,Ya) Posisición X,Y Tamaño Xa,Ya
		display3.setLayout(null);
		display3.setDefaultCloseOperation(EXIT_ON_CLOSE);
		display3.setResizable(false);
		display3.setTitle("Selección temperatura");
		
		texto3.setText("Elija que desear convertir");
		texto3.setHorizontalAlignment(SwingConstants.CENTER);
		texto3.setFont(new Font("Arial Bold", Font.PLAIN, 13));
		texto3.setBounds(125,0,250,30);
		
		lista3.addItem("°C Celcius");
		lista3.addItem("°F Fahrenheit");
		lista3.addItem("°k Kelvin");
		lista3.setSelectedIndex(0);
		
		lista4.addItem("°C Celcius");
		lista4.addItem("°F Fahrenheit");
		lista4.addItem("°k Kelvin");
		lista4.setSelectedIndex(1);
					
		boton1.setBounds(125, 100, 100, 30);
		boton1.setText("Aceptar");
		boton1.setBackground(Color.lightGray);
		
		boton2.setBounds(275, 100, 100, 30);
		boton2.setText("Cancelar");
		boton2.setBackground(Color.lightGray);
				
		boton1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
											
				lista3.addActionListener(new ActionListener() {								
					@Override
					public void actionPerformed(ActionEvent e) {
						lista3.getSelectedIndex();	
					}
						
				});
				lista4.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						lista4.getSelectedIndex();
					}
				});
				
				
				conversorTemperatura(lista3.getSelectedIndex(), lista4.getSelectedIndex(),lista4.getSelectedItem());
			}			
		});
		
		boton2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int selec;
				selec = JOptionPane.showConfirmDialog(null, "Cerrar"); //si=0, No=1, Cancela=2
				if(selec == 0) {
					cerrar();
				}
			}
		});
		
		display3.setVisible(true);
		display3.add(texto3);
		display3.add(boton1);
		display3.add(boton2);
		panel3.add(lista3);
		panel3.add(lista4);
		display3.add(panel3);
		
		
	}
	
	public void convesorMoneda(int tipo) {
		switch (tipo) {
			case 0:
			break;
			case 1:
				resultado = valor / tasaDolar;
				JOptionPane.showMessageDialog(null,"Tienes $" + (String.format("%.2f", resultado))  + " Dolar" );
				continuarPrograma();
				break;
			case 2:
				resultado = valor / tasaEuro;
				JOptionPane.showMessageDialog(null,"Tienes €" + (String.format("%.2f", resultado)) + " Euros" );
				continuarPrograma();
				break;
			case 3:
				resultado = valor / tasaLibra;
				JOptionPane.showMessageDialog(null,"Tienes £" + (String.format("%.2f", resultado)) + " Libras" );
				continuarPrograma();
				break;
			case 4:
				resultado = valor / tasaYen;
				JOptionPane.showMessageDialog(null,"Tienes ¥" + (String.format("%.2f", resultado)) + " Yen" );
				continuarPrograma();
				break;
			case 5:
				resultado = valor / tasaSul;
				JOptionPane.showMessageDialog(null,"Tienes  ₩" + (String.format("%.2f", resultado)) + " Sul" );
				continuarPrograma();
				break;
			case 6:
				resultado = valor * tasaDolar;
				JOptionPane.showMessageDialog(null,"Tienes $" + (String.format("%.2f", resultado)) + " Pesos" );
				continuarPrograma();
				break;
			case 7:
				resultado = valor * tasaEuro;
				JOptionPane.showMessageDialog(null,"Tienes $" + (String.format("%.2f", resultado)) + " Pesos" );
				continuarPrograma();
				break;
			case 8:
				resultado = valor * tasaLibra;
				JOptionPane.showMessageDialog(null,"Tienes $" + (String.format("%.2f", resultado)) + " Pesos" );
				continuarPrograma();
				break;
			case 9:
				resultado = valor * tasaYen;
				JOptionPane.showMessageDialog(null,"Tienes $" + (String.format("%.2f", resultado)) + " Pesos" );
				continuarPrograma();
				break;
			case 10:
				resultado = valor * tasaSul;
				JOptionPane.showMessageDialog(null,"Tienes $" + (String.format("%.2f", resultado)) + " Pesos" );
				continuarPrograma();
				break;		
		}
		
	}
	
	public void conversorTemperatura(int a, int b, Object c) {
		
		if (a == b) {
			JOptionPane.showMessageDialog(null, "conversion igual a " + valor + c);
		} else if ((a==0) && (b==1)) {
			resultado = (valor * 9/5) + 32;
			JOptionPane.showMessageDialog(null, "conversion igual a " + (String.format("%.2f", resultado)) + c);
		} else if ((a==0) && (b==2)) {
			resultado = valor + 273.15;
			JOptionPane.showMessageDialog(null, "conversion igual a " + (String.format("%.2f", resultado)) + c);
		} else if ((a==1) && (b==0)) {
			resultado = (valor - 32) * 5/9;
			JOptionPane.showMessageDialog(null, "conversion igual a " + (String.format("%.2f", resultado)) + c);
		} else if ((a==1) && (b==2)) {
			resultado = (valor - 32) * 5/9 + 273.15;
			JOptionPane.showMessageDialog(null, "conversion igual a " + (String.format("%.2f", resultado)) + c);
		} else if ((a==2) && (b==1)) {
			resultado = (valor - 273.15) * 9/5 + 32;
			JOptionPane.showMessageDialog(null, "conversion igual a " + (String.format("%.2f", resultado)) + c);
		} else if ((a==2) && (b==0)) {
			resultado = valor - 273.15;
			JOptionPane.showMessageDialog(null, "conversion igual a " + (String.format("%.2f", resultado)) + c);
		}
		
		continuarPrograma();
	}
	
	public void Validar() {					
		boolean procede = false;
    	
    	do {
    		try {
        		cantidad = JOptionPane.showInputDialog("Ingrese Valor");
                valor = Double.parseDouble(cantidad);
                procede = false;
            }
            catch (Exception e) {
                System.out.println("Exception: " + e);
                System.out.println(cantidad);
                	if(cantidad == null) {
                		int selec = JOptionPane.showConfirmDialog(null, "¿Desea continuar?"); //si=0, No=1, Cancela=2
                		if(selec == 1 || selec ==2) {
                			cerrar();
                		}
                	}
                JOptionPane.showMessageDialog(null, "Ingrese un Valor Valido");
                procede = true;
            }
    	} while(procede);		
	}
	
	public void continuarPrograma() {
		int selec;
		selec = JOptionPane.showConfirmDialog(null, "¿Desea continuar?"); //si=0, No=1, Cancela=2
				
		if(selec == 1 || selec ==2) {
			JOptionPane.showMessageDialog(null, "Programa Finalizado");
			cerrar();
		} else if (selec == 0) {
								
			try { // evitar que se mantenga pantalla 
				display2.setVisible(false);
			} catch (Exception display) {
				System.out.println("Exception: " + display);				
			}
			
			try { // evitar que se mantenga pantalla 
				display3.setVisible(false);
			} catch (Exception display) {
				System.out.println("Exception: " + display);				
			}
			
			ventanaPrincipal();
		}
	}
	
	public void cerrar() {
		System.exit(0);
	}


	
}

	

	
