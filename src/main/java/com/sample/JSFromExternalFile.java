package com.sample;

import java.io.FileNotFoundException;
import java.io.FileReader;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class JSFromExternalFile {

    public static void main(String[] args) throws NoSuchMethodException, ScriptException {

        ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
        try {
            engine.eval(new FileReader(
                    "/Users/rvasikarla/SBG_Automation/Nashorn-101/src/main/java/resources/JS_Code/Sample.js"));
        } catch (FileNotFoundException | ScriptException e) {
            e.printStackTrace();
        }

        Invocable invocable = (Invocable) engine;
        String result = (String) invocable.invokeFunction("fun1", "Raj Vasikarla");
        System.out.println(result);
    }
}
