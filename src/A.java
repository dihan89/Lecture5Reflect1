import java.io.*;
import java.util.*;


public class A {
    public final static String novell = "novell";
    private final static String roman = "roman";
    public final String story;
    public final String essay;
    String drama;
    String detective;

    A (String story, String essay, String drama){
        this.story = story;
        this.essay = essay;
        this.drama = drama;
        this.detective ="detective";
    }

    A (){
        this.story = "story";
        this.essay = "essay";
        drama = "drama";
    }

    public static String getRoman (){
        return roman;
    }

    private static String getNovell(){
        return novell;
    }

    public String getStory(){
        return story;
    }
    private String getEssay(){
        return essay;
    }

    public  String setDrama (String drama){
        this.drama = essay;
        return this.essay;
    }
}

class B extends A{
    public final static String novell2 = "novell2";
    private final static String roman2 = "roman3";
    public final String story2;
    public final String essay2;
    String drama2;
    String detective;

    B (String story, String essay, String detective, String drama){
        this.story2 = story;
        this.essay2 = essay;
        this.drama = drama;
        this.detective = detective;
    }

    B (){
        this.story2 = "story2";
        this.essay2 = "essay2";
        drama2 = "drama2";
    }

    public static String getRoman2 (){
        return roman2;
    }

    private static String getNovell2(){
        return novell2;
    }

    @Override
    public String getStory(){
        return story2;
    }
    private String getEssay2(){
        return essay2;
    }

    public  String setDrama (String drama){
        this.drama = essay;
        return this.essay;
    }


}

class C extends B{
   public void Hello(){
       System.out.println("Hello");
   }
   C(String story, String essay, String detective, String drama){
       super(story,essay,  detective, drama);



   }
   C (){


   }


}