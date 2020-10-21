package designpattern;

/**
 * [author]:  zhengxiaohui  ;
 * [create date]: 2020/9/9 19:59
 * [description]: 抽象工厂模式
 */
public class AbstractFactoryPattern {
    static interface Shape {
        void draw();
    }

    static class Rectangle implements Shape {

        @Override
        public void draw() {
            System.out.println("Rectangle ");
        }
    }

    static class Square implements Shape {

        @Override
        public void draw() {
            System.out.println("Square ");
        }
    }

    static class Circle implements Shape {

        @Override
        public void draw() {
            System.out.println("Circle ");
        }
    }

    static interface Color {
        void fill();
    }

    static class Red implements Color {

        @Override
        public void fill() {
            System.out.println("Red color!");
        }
    }

    static class Blue implements Color {

        @Override
        public void fill() {
            System.out.println("Blue color!");
        }
    }

    public abstract class AbstractFactory {
        public abstract Color getColor(String color);

        public abstract Shape getShape(String shape);
    }

    public class ShapeFactory extends AbstractFactory {

        @Override
        public Color getColor(String color) {
            return null;
        }

        @Override
        public Shape getShape(String shape) {
            if(shape == null){
                return null;
            }
            if(shape.equalsIgnoreCase("CIRCLE")){
                return new Circle();
            } else if(shape.equalsIgnoreCase("RECTANGLE")){
                return new Rectangle();
            } else if(shape.equalsIgnoreCase("SQUARE")){
                return new Square();
            }
            return null;
        }
    }
}
