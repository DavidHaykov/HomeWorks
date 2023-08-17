import java.lang.reflect.Field;

public class TableInfoRunner {
    public static void runInfo(Object obj){
        Class<?> clazz = obj.getClass();

        Table annotation = clazz.getAnnotation(Table.class);
        String tableName = (annotation != null) ? annotation.name() : clazz.getSimpleName();
        StringBuilder uniqueIndexes = new StringBuilder();
        StringBuilder nonUniqueIndexes = new StringBuilder();
        Field idField = null;
        for(Field field : clazz.getDeclaredFields()){
            if(field.isAnnotationPresent(Id.class)){
                if(idField != null){
                    throw new RuntimeException("Id duplication");
                }
                idField = field;
            }
            if(field.isAnnotationPresent(Index.class)){
                Index index = field.getAnnotation(Index.class);
                if(index.unique()){
                    uniqueIndexes.append(field.getName()).append(" | ");
                }
                else {
                    nonUniqueIndexes.append(field.getName()).append(" | ");
                }
            }
        }
        System.out.println("Table: " + tableName);
        if(idField != null) {
            System.out.println("Id: " + idField.getName());
        }else {
            throw new RuntimeException("Id is null");
        }
        System.out.println("Unique indexes: " + uniqueIndexes);
        System.out.println("Non unique indexes: " + nonUniqueIndexes);
    }
}
