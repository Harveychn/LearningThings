package designpattern;

/**
 * [author]:  zhengxiaohui  ;
 * [create date]: 2020/9/9 19:12
 * [description]: 单例模式
 * 1、 定义一个类型；
 * 2、 定义类似实现类；
 * 3、 定义一个工厂；
 * 4、 通过工厂获取实现类；
 */
public class FactoryPattern {
    interface Shape {
        void draw();
    }

    static class Rectangle implements Shape {

        @Override
        public void draw() {
            System.out.println("Inside Rectangle draw method！");
        }
    }

    static class Square implements Shape {

        @Override
        public void draw() {
            System.out.println("Inside Square draw method！");
        }
    }

    static class ShapeFactory {
        public Shape getShape(String shapeType) {
            if (shapeType == null) {
                return null;
            }
            if (shapeType.equalsIgnoreCase("Rectangle")) {
                return new Rectangle();
            }
            if (shapeType.equalsIgnoreCase("Square")) {
                return new Square();
            }
            return null;
        }
    }

    public static void main(String[] args) {
        ShapeFactory factory = new ShapeFactory();

        Shape rectangleShape = factory.getShape("Rectangle");
        rectangleShape.draw();

        Shape squareShape = factory.getShape("Square");
        squareShape.draw();
    }
}
