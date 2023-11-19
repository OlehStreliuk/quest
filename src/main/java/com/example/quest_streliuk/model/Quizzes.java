package com.example.quest_streliuk.model;

import java.io.Serializable;

public class Quizzes implements Serializable {
    private  Node root;
    public static Quizzes instance = new Quizzes();

    public  static Quizzes getInstance(){
        return instance;
    }

    Quizzes(){
        treeNode();
    }


    private void treeNode(){
        root =
                new Node("Ты потерял память. Принять вызов НЛО?",
                        new Node("Принять вызов",
                                new Node( "Ты принял вызов. Поднимаешься на мостик к капитану?",
                                        new Node("Ты поднялся на мостик. Кто ты?",
                                                new Node( "Рассказать о себе правду",
                                                        new Node( "Тебя вернули домой. Победа",null, null), null), null), null),
                                new Node( "Отказаться подниматься на мостик?",
                                        new Node( "Ты не пошел на переговоря. Поражение",null, null),null)),

                        new Node("Отклонить вызов",
                                new Node("Ты тклонил вызов. Поражение", null, null), null)
                );
    }

    public Node getRoot() {
        return root;
    }

    public  Node findNextNode(String text){
        if(text == null)
            return root;
        if (root.getValue().equals(text))
            return root;
        return root.nextText(text, root);
    }


}
