import javafx.application.Application;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.*;
import javafx.event.*;
class Sw extends Thread
{
	TextField st;
	int s;
	boolean temp=true;
	public Sw(TextField st)
	{
		this.st=st;
	}
	public void run()
	{
		s=30;
		while(temp)
		{
		st.setText("Time left:"+s+" seconds");
			try{
                		Thread.sleep(1000);
            		}
            		catch(InterruptedException e)
            		{
                		System.out.println("Watch Stopped");
            		}
			s--;
			if(s==0)
			{
				st.setText("Time's up!Clear and Try again");
				break;
			}
		}
	}
	public void stopTimer() {
        temp=false;
        this.interrupt(); 
    }
}
public class Mcq extends Application {
	private Sw obj;
	public static void main(String[] args) {
        	launch(args);
	}
	public void start(Stage mystage) {
		String qus[]={"Which is the largest Ocean in the World?",
				"Which is the largest Continent in the World?",
				"What is the National Animal of India?",
				"What is the National Bird of India?",
				"What is the National Game of India?"};
		String a[] = {"Indian Ocean", "Africa", "Tiger", "Pegion", "Cricket"};
        	String b[] = {"Pacific Ocean", "Australia", "Lion", "Peacock", "Hockey"};
        	String c[] = {"Atlantic Ocean", "Asia", "Elephant", "Parrot", "Volleyball"};
        	String d[] = {"Arctic Ocean", "Antarctica", "None", "None", "None"};
		VBox vbox = new VBox(10);
		Scene sc=new Scene(vbox,400,600);
		String ans[]={"Pacific Ocean", "Asia", "Tiger", "Peacock", "None"};
		int score=0;
		StringBuilder ca=new StringBuilder();
		StringBuilder wa=new StringBuilder();
		ToggleGroup[] t=new ToggleGroup[qus.length];
		for(int i=0;i<qus.length;i++)
		{
			t[i]=new ToggleGroup();
			Label l=new Label(qus[i]);
			RadioButton e=new RadioButton(a[i]);
			RadioButton f=new RadioButton(b[i]);
			RadioButton g=new RadioButton(c[i]);
			RadioButton h=new RadioButton(d[i]);
			e.setToggleGroup(t[i]);
			f.setToggleGroup(t[i]);
			g.setToggleGroup(t[i]);
			h.setToggleGroup(t[i]);
			VBox v=new VBox(5);
			HBox hb=new HBox(5);
			hb.getChildren().addAll(e,f,g,h);
			v.getChildren().addAll(l,hb);
			vbox.getChildren().add(v);
		}
		Button b1=new Button("Submit");
		Button b2=new Button("Clear");
		Label la=new Label("Score:");
		Label la1=new Label("Correct Answer:");
		Label la2=new Label("Wrong Answer:");
		TextField st=new TextField();
		TextField tf=new TextField();
		TextField tf1=new TextField();
		TextField tf2=new TextField();
		tf.setPrefWidth(150);  
		tf.setMinWidth(100);     
		tf.setMaxWidth(200);    
        	tf.setEditable(false);
		st.setPrefWidth(150);  
		st.setMinWidth(100);     
		st.setMaxWidth(200);    
        	st.setEditable(false);
		tf1.setPrefWidth(150);  
		tf1.setMinWidth(100);     
		tf1.setMaxWidth(200);    
        	tf1.setEditable(false); 
		tf2.setPrefWidth(150);  
		tf2.setMinWidth(100);     
		tf2.setMaxWidth(200);    
        	tf2.setEditable(false); 
		obj=new Sw(st);
		obj.start();
		b1.setOnAction(new EventHandler<ActionEvent>()
		{
			public void handle(ActionEvent ae)
			{
				obj.stopTimer();
				int score=0;
				ca.setLength(0);
				wa.setLength(0);
                		for (int i=0;i<qus.length;i++) 
				{
                    			RadioButton so=(RadioButton)t[i].getSelectedToggle();
                    			if(so!=null && so.getText().equals(ans[i])) 
					{
                        		 	ca.append(" ").append(i+1);
						score++;
                    			}
					else if(so==null)
					{
						tf.setText("Question "+(i+1)+" was not answered");
						return;
					}
					else
					{
						wa.append(" ").append(i+1);
					}
                		}
                		tf.setText("Your score is "+score +"/"+qus.length);
				tf1.setText(ca.toString());
				tf2.setText(wa.toString());
			}
		});
		b2.setOnAction(new EventHandler<ActionEvent>()
		{
			public void handle(ActionEvent ae)
			{
                            tf.clear();
			    st.clear();
                            tf1.clear();
                            tf2.clear();
			    obj=new Sw(st);
			    obj.start();
              for (ToggleGroup clear : t) {
            clear.selectToggle(null); 
        }
                        }
                });
		vbox.getChildren().addAll(st,la,tf,b1,la1,tf1,la2,tf2,b2);
		mystage.setScene(sc);
        	mystage.show();	
	}
}

