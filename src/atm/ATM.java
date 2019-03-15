/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm;

/**
 *
 * @author Mohannad
 */
import com.sun.org.apache.bcel.internal.generic.InstructionConstants;
import java.net.Authenticator;
import static javafx.application.Application.launch;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import sun.security.util.Password;
import sun.text.normalizer.ICUBinary;

import java.util.Queue;
import java.util.LinkedList;

public class ATM extends Application{

    public static void main(String[] args) {
        launch(args);
    }
    Button ok = new Button();
    Stage window=new Stage();
    TransacrionAlgorithm client= new TransacrionAlgorithm();
    
    public void start(Stage primStage) throws Exception{
        TransacrionAlgorithm client=new TransacrionAlgorithm();
        
        this.window=primStage;
        primStage.setTitle("ATM");
        
        Label cardNumLabel= new Label("Card Number: ");
        Label pinLabel= new Label("PIN: ");
        TextField cardNumfiField= new TextField();
        TextField pinField= new TextField();
        Button access = new Button ("Access");
        Label validationLabel= new Label();
        
        GridPane grid1 = new GridPane();
        grid1.add(cardNumLabel, 0, 0);
        grid1.add(pinLabel, 0, 1);
        grid1.add(cardNumfiField, 1, 0);
        grid1.add(pinField, 1, 1);
        grid1.add(access, 1, 2);
        Scene login=new Scene(grid1,400,300);
        window.setScene(login);
        
       access.setOnAction(new EventHandler<ActionEvent>(){
        @Override
        public void handle(ActionEvent event){
            String cardNum=cardNumfiField.getText();
            String pass=pinField.getText();
        if(cardNum.equals(client.storedCardNum) && pass.equals(client.storedpassword))
        {
        window.setScene(mainMenu());
        }
        else{
       
            Alert(ok, "Invalid Card Number or Password");
        }}
        });
       
       window.show();
}
    public Scene mainMenu(){
        
        Button deposit = new Button("Deposit");
        Button withdraw= new Button("Withdraw");
        Button balance= new Button("Balance");
        
        GridPane grid2=new GridPane();
        grid2.add(deposit, 0, 0);
        grid2.add(withdraw, 0, 1);
        grid2.add(balance, 1, 0);
        
        deposit.setOnAction(new EventHandler<ActionEvent>(){
        @Override
        public void handle(ActionEvent event){
            window.setScene(depositMenu());
       }
        });
        withdraw.setOnAction(new EventHandler<ActionEvent>(){
        @Override
        public void handle(ActionEvent event){
            window.setScene(withdrawMenu());
       }
        });
        
        balance.setOnAction(new EventHandler<ActionEvent>(){
        @Override
        public void handle(ActionEvent event){
            window.setScene(showbalance());
       }
        });
        
        Scene home=new Scene(grid2,400,300);
        window.setScene(home);
        window.show();
        return home;
    }
    String enterNum=new String();
    
    static String[] History=new String[6];
    static int historyIndex=0;
    static int previousindex=-1;
    
    public Scene showbalance(){
        
        Label Balance= new Label("Balance Amount= ");
        Label balanceField=new Label();
        Button backButton=new Button("Back to Main Menu");
        Label showHistory=new Label();
        Button nextHistory =new Button("Next");
        Button previousHistory =new Button("previous");
        
        double balance =client.getBalance();
        String valueofBalance=String.valueOf(balance);
        balanceField.setText("$"+valueofBalance);
        
        backButton.setOnAction(new EventHandler<ActionEvent>(){
        @Override
        public void handle(ActionEvent event){
            window.setScene(mainMenu());
       }
        });
        
        GridPane grid3=new GridPane();
        grid3.add(Balance, 0, 0);
        grid3.add(balanceField, 0, 1);
        grid3.add(backButton, 2, 3);
        
        grid3.add(showHistory, 7, 5);
        grid3.add(nextHistory, 7, 6);
        grid3.add(previousHistory, 9, 6);
        
        nextHistory.setOnAction(new EventHandler<ActionEvent>(){
        @Override
        public void handle(ActionEvent event){
            if(previousindex==historyIndex-1){
                Alert(ok, "No History to be shown");
            }
            else{
                previousindex++;
             showHistory.setText(History[previousindex]);
            }
       }
        });
        previousHistory.setOnAction(new EventHandler<ActionEvent>(){
        @Override
        public void handle(ActionEvent event){
            if(previousindex==-1){
                Alert(ok, "No History to be shown");
            }
            else{
                previousindex--;
             showHistory.setText(History[previousindex]);
            }
       }
        });
        
        Scene showBalance=new Scene(grid3,400,300);
        window.setScene(showBalance);
        window.show();
        return showBalance;
    }

   public Scene depositMenu(){
       
       double balance =client.getBalance();
        Label Deposit=new Label("Deposit Value: ");
        Label depositField= new Label();
        Button proceed= new Button("Proceed");
        Button Num1 = new Button("1");
        Button Num2= new Button("2");
        Button Num3= new Button("3");
        Button Num4= new Button("4");
        Button Num5= new Button("5");
        Button Num6= new Button("6");
        Button Num7= new Button("7");
        Button Num8= new Button("8");
        Button Num9= new Button("9");
        Button Num0= new Button("0");
        Button back=new Button("Return Back");
        Button delete=new Button("Del");
        
        Num1.setOnAction(new EventHandler<ActionEvent>(){
        @Override
        public void handle(ActionEvent event){
          enterNum+="1";
          depositField.setText(enterNum);
       }
        });
        Num2.setOnAction(new EventHandler<ActionEvent>(){
        @Override
        public void handle(ActionEvent event){
          enterNum+="2";
          depositField.setText(enterNum);
       }
        });
        Num3.setOnAction(new EventHandler<ActionEvent>(){
        @Override
        public void handle(ActionEvent event){
          enterNum+="3";
          depositField.setText(enterNum);
       }
        });
        Num4.setOnAction(new EventHandler<ActionEvent>(){
        @Override
        public void handle(ActionEvent event){
          enterNum+="4";
          depositField.setText(enterNum);
       }
        });
        Num5.setOnAction(new EventHandler<ActionEvent>(){
        @Override
        public void handle(ActionEvent event){
          enterNum+="5";
          depositField.setText(enterNum);
       }
        });
        Num6.setOnAction(new EventHandler<ActionEvent>(){
        @Override
        public void handle(ActionEvent event){
          enterNum+="6";
          depositField.setText(enterNum);
       }
        });
        Num7.setOnAction(new EventHandler<ActionEvent>(){
        @Override
        public void handle(ActionEvent event){
          enterNum+="7";
          depositField.setText(enterNum);
       }
        });
        Num8.setOnAction(new EventHandler<ActionEvent>(){
        @Override
        public void handle(ActionEvent event){
          enterNum+="8";
          depositField.setText(enterNum);
       }
        });
        Num9.setOnAction(new EventHandler<ActionEvent>(){
        @Override
        public void handle(ActionEvent event){
          enterNum+="9";
          depositField.setText(enterNum);
       }
        });
        Num0.setOnAction(new EventHandler<ActionEvent>(){
        @Override
        public void handle(ActionEvent event){
          
          if(enterNum.charAt(0)=='0'){
              enterNum="";
              depositField.setText(enterNum);
          }
          else{
              enterNum+="0";
          depositField.setText(enterNum);
          }
          
       }
        });
        delete.setOnAction(new EventHandler<ActionEvent>(){
        @Override
        public void handle(ActionEvent event){
          enterNum="";
          depositField.setText(enterNum);
       }
        });
        proceed.setOnAction(new EventHandler<ActionEvent>(){
        @Override
        public void handle(ActionEvent event){
        long amount=Integer.parseInt(enterNum);
        client.deposit(amount);
        window.setScene(mainMenu());
        if(History.length<=6){
            History[historyIndex]=("Deposite of $"+amount);
            historyIndex++;
        }
        else{
            History[0]=null;
            for(int i=0;i<5;i++)
            {
                History[i]=History[i+1];
            }
            History[5]=("Balance= $"+balance+"Deposite of $"+amount);
            }
        Alert(ok, "Deposite of $"+amount+" is successful");
        enterNum="";
       }
        });
        
        back.setOnAction(new EventHandler<ActionEvent>(){
        @Override
        public void handle(ActionEvent event){
            window.setScene(mainMenu());
            enterNum="";
        }
        });
        
        
        GridPane grid2=new GridPane();
        grid2.add(Deposit, 3, 0);
        grid2.add(depositField, 4, 0);
        grid2.add(proceed, 3, 1);
        grid2.add(Num1,0 , 0);
        grid2.add(Num2,1 , 0);
        grid2.add(Num3,2 , 0);
        grid2.add(Num4,0 , 1);
        grid2.add(Num5,1 , 1);
        grid2.add(Num6,2 , 1);
        grid2.add(Num7,0 , 2);
        grid2.add(Num8,1 , 2);
        grid2.add(Num9,2 , 2);
        grid2.add(Num0,1 , 3);
        grid2.add(back, 5, 5);
        grid2.add(delete, 3, 2);
        
        Scene depositMenu=new Scene(grid2,300,400);
        window.setScene(depositMenu);
        window.show();
        return depositMenu;
    }
   
   
   
   public Scene withdrawMenu(){
      
        Label Withdraw=new Label("Withdraw Value: ");
        Label withdrawField= new Label();
        Button proceed= new Button("Proceed");
        Button Num1= new Button("1");
        Button Num2= new Button("2");
        Button Num3= new Button("3");
        Button Num4= new Button("4");
        Button Num5= new Button("5");
        Button Num6= new Button("6");
        Button Num7= new Button("7");
        Button Num8= new Button("8");
        Button Num9= new Button("9");
        Button Num0= new Button("0");
        Button back= new Button("Return Back");
        Button delete=new Button("Del");
        
        back.setOnAction(new EventHandler<ActionEvent>(){
        @Override
        public void handle(ActionEvent event){
            window.setScene(mainMenu());
            enterNum="";
       }
        });
        
        Num1.setOnAction(new EventHandler<ActionEvent>(){
        @Override
        public void handle(ActionEvent event){
          enterNum+="1";
          withdrawField.setText(enterNum);
       }
        });
        Num2.setOnAction(new EventHandler<ActionEvent>(){
        @Override
        public void handle(ActionEvent event){
          enterNum+="2";
          withdrawField.setText(enterNum);
       }
        });
        Num3.setOnAction(new EventHandler<ActionEvent>(){
        @Override
        public void handle(ActionEvent event){
          enterNum+="3";
          withdrawField.setText(enterNum);
       }
        });
        Num4.setOnAction(new EventHandler<ActionEvent>(){
        @Override
        public void handle(ActionEvent event){
          enterNum+="4";
          withdrawField.setText(enterNum);
       }
        });
        Num5.setOnAction(new EventHandler<ActionEvent>(){
        @Override
        public void handle(ActionEvent event){
          enterNum+="5";
          withdrawField.setText(enterNum);
       }
        });
        Num6.setOnAction(new EventHandler<ActionEvent>(){
        @Override
        public void handle(ActionEvent event){
          enterNum+="6";
          withdrawField.setText(enterNum);
       }
        });
        Num7.setOnAction(new EventHandler<ActionEvent>(){
        @Override
        public void handle(ActionEvent event){
          enterNum+="7";
          withdrawField.setText(enterNum);
       }
        });
        Num8.setOnAction(new EventHandler<ActionEvent>(){
        @Override
        public void handle(ActionEvent event){
          enterNum+="8";
          withdrawField.setText(enterNum);
       }
        });
        Num9.setOnAction(new EventHandler<ActionEvent>(){
        @Override
        public void handle(ActionEvent event){
          enterNum+="9";
          withdrawField.setText(enterNum);
       }
        });
        Num0.setOnAction(new EventHandler<ActionEvent>(){
        @Override
        public void handle(ActionEvent event){
          
          if(enterNum.charAt(0)=='0'){
              enterNum="";
              withdrawField.setText(enterNum);
          }
          else{
              enterNum+="0";
          withdrawField.setText(enterNum);
          }
       }
        });
       
        delete.setOnAction(new EventHandler<ActionEvent>(){
        @Override
        public void handle(ActionEvent event){
          enterNum="";
          withdrawField.setText(enterNum);
       }
        });
        
        proceed.setOnAction(new EventHandler<ActionEvent>(){
        @Override
        public void handle(ActionEvent event){
        double balance=client.getBalance();
        long amount=Integer.parseInt(enterNum);
         if (balance<amount) {
             Alert(ok, "Insufficint Fund in your balance");
         }
         else{
             
             if(History.length<=6){
                History[historyIndex]=("Deposite of $"+amount);
                historyIndex++;
                }
            else{
                History[0]=null;
                for(int i=0;i<5;i++)
                {
                    History[i]=History[i+1];
                }
                History[5]=("Balance= $"+balance+"Withdraw of $"+amount);
                }
             
             client.withdraw(amount);
             window.setScene(mainMenu());
        Alert(ok, "Withdraw of $"+amount+" is successful");
        enterNum="";
             
         }
        
       }
        });
        
        GridPane grid2=new GridPane();
        grid2.add(Withdraw, 3, 0);
        grid2.add(withdrawField, 4, 0);
        grid2.add(proceed, 3, 1);
        grid2.add(Num1,0 , 0);
        grid2.add(Num2,1 , 0);
        grid2.add(Num3,2 , 0);
        grid2.add(Num4,0 , 1);
        grid2.add(Num5,1 , 1);
        grid2.add(Num6,2 , 1);
        grid2.add(Num7,0 , 2);
        grid2.add(Num8,1 , 2);
        grid2.add(Num9,2 , 2);
        grid2.add(Num0,1 , 3);
        grid2.add(back, 5, 5);
        grid2.add(delete, 3, 2);
        
        Scene withdrawtMenu=new Scene(grid2,300,400);
        window.setScene(withdrawtMenu);
        window.show();
        return withdrawtMenu;
    }
   
   static void Alert (Button AlertButton,String message){
   
       Stage AlertStage=new Stage();
       AlertStage.setTitle("Error");
       GridPane AlertGrid=new GridPane();
       Scene AlertScene=new Scene(AlertGrid,300,100);
       AlertButton=new Button("OK");
       Label AlertMessage= new Label(message);
       AlertButton.setOnAction(e -> AlertStage.close());
       AlertGrid.add(AlertMessage,0,0);
       AlertGrid.add(AlertButton, 1, 1);
       AlertStage.setScene(AlertScene);
       AlertStage.show();
       
   }
   
}
    
    
    
