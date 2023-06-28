package telran.library.view;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.function.Function;

public interface InputOutput {
    String inputString(String input);
    void output(Object out);


    default void outputLine(Object obj){
        System.out.println(obj.toString());
    }

    default <R> R inputObject(String prompt, String errorPrompt, Function<String, R> mapper ){
        while(true){
            String text = inputString(prompt);
            if(text == null){
                return null;
            }
            R res = mapper.apply(text);
            if (res != null){
                return res;
            }
            outputLine(errorPrompt);
        }
    }
    default Integer inputInteger(String prompt){
        return inputObject(prompt,"it's not integer number", s -> {
            try {
                Integer res = Integer.parseInt(s);
                return res;
            } catch (Exception e){
                return null;
            }
        });
    }
    default Integer inputInteger(String prompt, Integer min, Integer max){
        return inputObject(prompt,
                String.format("it's not integer number in range [%d-%d]", min, max), s -> {
            try {
                Integer res = Integer.parseInt(s);
                return res >= min && res <= max ? res : null;
            } catch (Exception e){
                return null;
            }
        });
    }
    default String inputString(String prompt, List<String> options){
        return inputObject(prompt, "String is not int option",
                s -> options.contains(s) ? s : null);
    }
    default Double inputDouble(String prompt){
        return inputObject(prompt,
                "it's not a double number", s -> {
                    try {
                        return (Double) Double.parseDouble(s);
                    }catch (Exception e){
                        return null;
                    }
                });
    }
    default Long inputLong(String prompt){
        return inputObject(prompt,
                "it's not a long number", s -> {
                    try {
                        return (Long) Long.parseLong(s);
                    }catch (Exception e){
                        return null;
                    }
                });
    }
    default LocalDate inputDate(String prompt, String format){
        return inputObject(prompt,
                String.format("its not a correct date in formatter: " + format), s -> {
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
                    try {
                        return LocalDate.parse(s, formatter);
                    }catch (Exception e){
                        return null;
                    }
                });
    }


}
