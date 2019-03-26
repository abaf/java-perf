package com.casestudy.designPatterns;

/**
 * @author liujian
 * @create 2019-03-26 18:07
 */
public class DbQueryImpl implements DbQuery {
    public DbQueryImpl(){
        try{
          Thread.sleep(1000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    @Override
    public String request() {
        return "request string";
    }
}