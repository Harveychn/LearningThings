package basic;

import java.io.*;

/**
 * [author]:  zhengxiaohui  ;
 * [create date]: 2020/9/29 9:03
 * [description]:
 */
public class DeepClone implements Serializable {

    private static final long serialVersionUID = -3657617495694913851L;
    private String field1;
    private transient String noneSerialField;

    public DeepClone(String field1, String noneSerialField) {
        this.field1 = field1;
        this.noneSerialField = noneSerialField;
    }

    @Override
    public String toString() {
        return "DeepClone{" +
                "field1='" + field1 + '\'' +
                ", noneSerialField='" + noneSerialField + '\'' +
                '}';
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        DeepClone deepClone = new DeepClone("ces1 ", "transtant");
        DeepClone lightClone = deepClone;

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(byteArrayOutputStream);
        out.writeObject(deepClone);
        out.close();

        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        ObjectInputStream input = new ObjectInputStream(byteArrayInputStream);
        DeepClone newCls = (DeepClone) input.readObject();
        input.close();

        System.out.println(deepClone.toString());
        System.out.println(newCls.toString());
        System.out.println(newCls == deepClone);
        System.out.println(lightClone == deepClone);
    }
}
