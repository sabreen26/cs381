
package cal;
import javafx.application.Application;
	import javafx.event.ActionEvent;
	import javafx.event.EventHandler;
	import javafx.scene.Scene;
	import javafx.scene.control.Button;
	import javafx.scene.layout.GridPane;
	import javafx.stage.Stage;
	import javafx.beans.property.SimpleStringProperty;
	import javafx.beans.property.StringProperty;
	import javafx.geometry.Insets;
	import javafx.geometry.Pos;
	import javafx.scene.control.TextField;
	import javafx.scene.layout.BorderPane;
	import javafx.scene.layout.Priority;
    import javax.script.ScriptEngine;
	import javax.script.ScriptEngineManager;

	public class cal extends Application {			
		 ScriptEngineManager manager=new ScriptEngineManager();
		 ScriptEngine engine=manager.getEngineByName("JavaScript");
		 boolean frac=false;
		 private final StringProperty v= new SimpleStringProperty("");
		 class NumberButtonHandler implements EventHandler<ActionEvent>  {
		    	
		        private final String number ;
		        
		        NumberButtonHandler(String number) {
		            this.number = number ;
		           
		        }
		        @Override
		        public void handle(ActionEvent event) {
		    
		String newn=v.get();
		        v.set( newn+number);
		        }
		}
		  
		    @Override
		    public void start(Stage primaryStage) {

		        GridPane grid = createGrid();
		        grid.setStyle("-fx-background-color:#808080");
		        Button add;
		        TextField displayField;
		        Button  seven =  createNumberButton("7");
		        grid .add(seven, 0, 0);
				Button four =  createNumberButton("4");
			
				grid .add(four, 0, 1);
				Button one =  createNumberButton("1");
			
				grid .add(one,0,2);
				Button eight =  createNumberButton("8");
			
				grid .add(eight, 1, 0);
				Button five = createNumberButton("5");
				 
				grid .add(five, 1, 1);
				Button two =  createNumberButton("2");
				
				grid .add(two, 1, 2);
			
				Button nine=  createNumberButton("9");
				grid .add(nine, 2, 0);
				Button six = createNumberButton("6");
				grid .add(six, 2, 1);
				Button three =  createNumberButton("3");
				grid .add(three, 2, 2);
		        Button zeroButton = createNumberButton("0");
		         grid.add(zeroButton, 0,3);
		         Button modulars = createButton("%");
				 grid.add(modulars, 2, 3);
				 Button division = createButton("/");
	
				 grid.add(division, 3, 0);
				 Button mulitp =createButton("*");
			
				 grid.add( mulitp, 3, 1);
				 Button	 sub = createButton("-");
				 grid.add(sub, 3, 2);
				
				 add =createButton("+");
				 grid.add(add, 3, 3);
			
				 Button	arrow = createButton("←");
				 grid.add(arrow, 4, 0);
		
				 Button	arc1 = createButton("(");
				 grid.add(arc1, 4, 1);
			
				 Button x = createButton("^2");
				 grid.add(x, 4, 2);

				 Button equal=createButton("=");
				 grid.add(equal,4,3,2,1);	
				 
				 Button arc2 = createButton(")");
				 grid.add(arc2, 5, 1);
		
				 Button	sqrt =createButton("sqrt");
				 grid.add(sqrt, 5, 2); 
		
				 Button	dot =createButton(".");
				 grid.add(dot, 1,3); 
			
		         Button clearButton = createButton("∆");
				 Button tan=createButton("tan");
				 grid.add(tan,6,3);
				
				 Button sin=createButton("sin");
				 grid.add(sin,6,1);
				
				 Button log=createButton("log");
				 grid.add(log,6,0);
				
				 Button cos=createButton("cos");
				 grid.add(cos,6,2);
		
				 Button OFF=createButton("OFF");
				 grid.add(OFF,0,4,7,4);
		
		         grid.add(clearButton,5, 0);
		
		        displayField = createDisplayField();
		        displayField.setStyle("-fx-border-color:#808080");
		        displayField.setPrefHeight(60);
		        BorderPane root = new BorderPane();
		        root.setPadding(new Insets(10));
		        root.setTop(displayField);
		        root.setCenter(grid);
		        clearButton.setOnAction(event -> v.set(""));
		        OFF.setOnAction(event -> {
		    	        System.exit(0);
		    	});
		      arrow.setOnAction(event -> {
			  String s=displayField.getText();

			    if(frac){
			    	
			    	       if(s.charAt(s.length()-1)=='.')
			    	        frac=false;}
			    	       else v.set(s.substring(0,s.length()-1));
			    });

					equal.setOnAction(new EventHandler<ActionEvent>(){
		public void handle(ActionEvent t){
		 Thread T=new Thread(new Runnable() {
			@Override
			public void run() {

				 try{
				        
						String s=displayField.getText();
				  		if(s.contains("log"))
				        {
				    	
				    	  	 
				  			String q=s.substring(3,s.length()); 
				   
				    	      String x= engine.eval(q).toString();
				    	      double q1=Double.parseDouble(x);
				                v.set(Double.toString((int)Math.log(q1)));
				               
				        }
				        else if(s.contains("sin"))
				        {String q=s.substring(3,s.length()); 
				        	 String x= engine.eval(q).toString();
				   	      double q1=Double.parseDouble(x);
				    	 
				                v.set(Double.toString( Math.sin(Math.toRadians(q1))));
				               
				        }                                                                              
				        else if(s.contains("tan"))
				        { 
				        	  String q=s.substring(3,s.length()); 
				        	 String x= engine.eval(q).toString();
				   	      double q1=Double.parseDouble(x);
				               v.set(Double.toString( Math.tan(Math.toRadians(q1))));
				                
				        }
				        else if(s.contains("cos"))
				        {String q=s.substring(3,s.length()); 
				        	 String x= engine.eval(q).toString();
				   	      double q1=Double.parseDouble(x);
				             v.set(Double.toString( Math.cos(Math.toRadians(q1))));                                    
				               
				        }
				 
				        else   if( s.contains("-")){
				 	        
				String x= engine.eval(s).toString();
								v.set(x);
					       }
				        else    if( s.contains("+")){
					    	  
					           String x= engine.eval(s).toString();
					           		
					   						v.set(x);
					           	       }
				        else    if( s.contains("*")){
					    	  
					           String x= engine.eval(s).toString();
					           
					   						v.set(x);
					           	       }
				        else    if( s.contains("/")){
					    	  

					    	  
					        
					           String x= engine.eval(s).toString();
					           
					   						
					   						v.set(x);
					           	       }
				     		 else if(s.contains("^2"))
				             {
				         	  	  String q=s.substring(0,s.indexOf("^2")); 
				                	 double  n=Double.parseDouble(q);
				                 v.set(Double.toString((n*n)));
				                 
				             }
				     	 else if(s.contains("sqrt"))
				         {
				     	  	  String q=s.substring(4,s.length()); 
				            	 double  n=Double.parseDouble(q);
				             v.set(Double.toString(Math.sqrt(n)));
				             
				         }

				    	
				     	else if(s.contains("%")) {
					
				     		  String q=s.substring(0,s.indexOf("%")); 
				 	 double  n=Double.parseDouble(q);
				  v.set(Double.toString(n/100));}
				     
				     } 
				    
				    catch (Exception ex)
				    {
				            ex.printStackTrace();
				    }
				    }
			});
				T.start();	}
		        

		});
		        Scene scene = new Scene(root, 365, 300);
		        primaryStage.setTitle("Calculator");
		        primaryStage.setScene(scene);
		        primaryStage.setResizable(false);
		        primaryStage.show();
		    }
		    
		    /**
		     * used for action of Buttons 
		     * and to take the text in the buttons
		     *  and put it on the text field
		     * 
		     */
		     private Button createNumberButton(String number) {
		        Button button = createButton(number);
		        button.setOnAction(new NumberButtonHandler(number));
		        return button ;
		    }
		    /**
		     * 
		     * to create Buttons
		     */
		    private Button createButton(String text) {
		        Button button = new Button(text);
		        button.setMaxSize(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);
		        GridPane.setFillHeight(button, true);
		        GridPane.setFillWidth(button, true);
		        GridPane.setHgrow(button, Priority.ALWAYS);
		        GridPane.setVgrow(button, Priority.ALWAYS);
		       button.setOnAction(new NumberButtonHandler(text));
		        return button ;
		    }
		    
		    /**
		     * create gridPane to
		     * put the Buttons on it
		     * and return grid
		     */
		    private GridPane createGrid() {
		        GridPane grid = new GridPane();
		        grid.setAlignment(Pos.CENTER);
		        grid.setHgap(5);
		        grid.setVgap(5);
		        grid.setPadding(new Insets(10));
		        return grid;
		    }

		    /**
		     * make the text field
		     * and return displayField
		     */
		    private TextField createDisplayField() {
		        TextField displayField = new TextField();
		        displayField.textProperty().bind(  v);
		        
		        displayField.setEditable(false);
		        displayField.setAlignment(Pos.CENTER_RIGHT);
		        return displayField;
		    }
		    public static void main(String[] args) {
		        launch(args);
		    }

}
