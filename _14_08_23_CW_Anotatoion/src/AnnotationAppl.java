public class AnnotationAppl {
    public static void main(String[] args) {
        System.out.println("X " + AnnotationRecognition.a_recognition(X.class));
        System.out.println("Y " + AnnotationRecognition.a_recognition(Y.class));

        Y y = new Y(10, 20, "Java");
        AnnotationRecognition.displayFieldsInfo(y);
    }
}
