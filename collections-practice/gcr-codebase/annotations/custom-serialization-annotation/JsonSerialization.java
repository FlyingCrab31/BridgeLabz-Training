import java.lang.reflect.Field;

public class JsonSerialization{

    public static String toJson(Object obj){
        StringBuilder json = new StringBuilder();
        json.append("{");

        Field[] fields = obj.getClass().getDeclaredFields();

        boolean firstField = true;

        for(Field field:fields){

        if(field.isAnnotationPresent(JsonField.class)){
            field.setAccessible(true);
            JsonField annotation = field.getAnnotation(JsonField.class);
            String fieldName = annotation.name();

            try{
                Object fieldValue=field.get(obj);
                if(!firstField){
                    json.append(",");
                
                }
                json.append("\"").append(fieldName).append("\":");
                if(fieldValue instanceof String){
                    json.append("\"").append(fieldValue).append("\"");
                }else{
                    json.append(fieldValue);
                }
                firstField = false;
            }catch(IllegalAccessException e){
                e.printStackTrace();
            }
        }


    }
    return json.append("}").toString();
}
}