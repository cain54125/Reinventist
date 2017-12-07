package com.example.cain.reinventist;


/**
 * Created by cain on 2017/10/30/030.
 */

public class QueueData {
    private String name;//名字
    private String item;//項目
    private String status;//狀態(等待,排隊,
    private String number;//病歷號
    private String order_n;
    private String bool_n;

    public  QueueData (String number,String name,String item,String status,String order_n,String bool_n){

        this.number=number;
        this.name=name;
        this.item=item;
        this.status=status;
        this.order_n=order_n;
        this.bool_n=bool_n;
    }
    public String getnumber(){
        return number;
    }
    public String getname(){
        return name;
    }
    public String getitem(){
        return item;
    }
    public String getstatus(){
        return status;
    }
    public String getsorder_n(){
        return order_n;
    }
    public Boolean getbool_n(){
        if(bool_n.equals("1")){
            return true;
        }else{
            return false;
        }
    }
    public void setbool_n(String bool_n){
        this.bool_n=bool_n;
       /* new Thread(new Runnable() {
            @Override
            public void run() {
                netUtils.phpOfPost("UPDATE queue SET bool_n='"+QueueData.this.bool_n+"' WHERE ID= "+getnumber());
            }
        }).start();*/
    }

    public void setstatus(String status){
        this.status=status;
      /*  new Thread(new Runnable() {
            @Override
            public void run() {
                netUtils.phpOfPost("UPDATE queue SET Status='"+QueueData.this.status+"' WHERE ID= "+getnumber());
            }
        }).start();
        */
    }
}
