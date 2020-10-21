package annotation;

import java.lang.reflect.Field;

/**
 * [author]:  zhengxiaohui  ;
 * [create date]: 2020/9/29 8:32
 * [description]:
 */
public class Apple {
    @FruitProvider(id = 1, name = "测试注解方法 ", address = "地址信息")
    private String appleProvider;

    public String getAppleProvider() {
        return appleProvider;
    }

    public void setAppleProvider(String appleProvider) {
        this.appleProvider = appleProvider;
    }
}

class FruitInfoUtil {
    public static void getFruitInfo(Class<?> clazz) {
        String strFruitProvider = "供应商信息：";
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(FruitProvider.class)) {
                FruitProvider fruitProvider = field.getAnnotation(FruitProvider.class);
                strFruitProvider = " 编号" + fruitProvider.id() + fruitProvider.name() + fruitProvider.address();
            }
        }
        System.out.println(strFruitProvider);
    }
}

class TstRunner {
    public static void main(String[] args) {
        FruitInfoUtil.getFruitInfo(Apple.class);
        System.out.println(new Apple().getAppleProvider());
    }
}
