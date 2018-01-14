/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test;

import com.almundo.callcenter.model.Call;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 *
 * @author rubens
 */
public class test {

    final ExecutorService pool = Executors.newFixedThreadPool(10);
    final ExecutorCompletionService<Call> completionService = new ExecutorCompletionService<>(pool);

    ;
    
    public test() throws Exception {
        List<Call> listCall = new ArrayList() {
            {
                add(new Call(1, "CLiente 1"));
                add(new Call(2, "CLiente 2"));
                add(new Call(3, "CLiente 3"));
            }
        };

        for (Call call : listCall) {
            completionService.submit(call);
        }

        for (int i = 0; i < listCall.size(); ++i) {
            System.out.println("TAKEN");
            final Future<Call> future = completionService.take();
            System.out.println("TAKIADO");
            try {
                final Call content = future.get();
                System.out.println("Llamada "+content.getId() + "PROCESADA");
                //...process contents
            } catch (ExecutionException e) {
                System.out.println("Error while downloading");
            }
        }
        System.out.println("FINAL");
        pool.shutdown();
    }

    public static void main(String[] args) throws Exception {
        new test();
    }

}
