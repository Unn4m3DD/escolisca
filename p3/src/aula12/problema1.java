package aula12;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class problema1 {
    static Scanner k = new Scanner(System.in);

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InvocationTargetException, InstantiationException {
        new problema1();
    }

    public problema1() throws ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Object[] arr = new Object[1];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = buildObject("myUtilAula3.Circulo");
        }
        for (Object o : arr) {
            System.out.println(o.toString());
        }
        invokeMethod(arr[0]);
    }

    private void invokeMethod(Object o) throws ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class c = o.getClass();
        Method[] methods = c.getMethods();
        for (Method method : methods) {
            System.out.println(method);
        }
        System.out.println("Select 1 method");
        Method m = methods[k.nextInt()];
        Object[] params = new Object[m.getParameterCount()];
        int i = 0;
        for (Type genericParameterType : m.getParameterTypes()) {
            if (!(genericParameterType.toString().equals("int") ||
                    genericParameterType.toString().equals("double") ||
                    genericParameterType.toString().equals("String") ||
                    genericParameterType.toString().equals("float") ||
                    genericParameterType.toString().equals("long") ||
                    genericParameterType.toString().equals("char"))) {
                System.out.println("Insert " + genericParameterType.getTypeName());
                params[i++] = (buildObject(genericParameterType.getTypeName()));
            } else {
                switch (genericParameterType.toString()) {
                    case "int":
                        System.out.println("Insert " + genericParameterType.getTypeName());
                        params[i++] = (k.nextInt());
                        break;

                    case "double":
                        System.out.println("Insert " + genericParameterType.getTypeName());
                        params[i++] = (k.nextDouble());
                        break;

                    case "String":
                        System.out.println("Insert " + genericParameterType.getTypeName());
                        params[i++] = (k.nextLine());
                        k.nextLine();
                        break;

                    case "float":
                        System.out.println("Insert " + genericParameterType.getTypeName());
                        params[i++] = (k.nextFloat());
                        break;

                    case "long":
                        System.out.println("Insert " + genericParameterType.getTypeName());
                        params[i++] = (k.nextLong());
                        break;

                    case "char":
                        System.out.println("Insert " + genericParameterType.getTypeName());
                        params[i++] = ((char) k.nextByte());
                        break;
                }
            }
        }
        System.out.println(m.invoke(o ,params));
    }

    Object buildObject(String objName) throws ClassNotFoundException, IllegalAccessException, InvocationTargetException, InstantiationException {
        var type = getClass().forName(objName);
        var constructors = type.getConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println(constructor);
//            System.out.println(Arrays.toString(constructor.getParameters()));
        }
        System.out.println("Select a constructor");
        int opc = 0;
        do {
            opc = k.nextInt();
            if (opc == -1) return null;
            if (0 <= opc && opc < constructors.length) {
                var constructor = constructors[opc];
                Object[] params = new Object[constructor.getParameterCount()];
                int i = 0;
                for (Type genericParameterType : constructor.getParameterTypes()) {
                    if (!(genericParameterType.toString().equals("int") ||
                            genericParameterType.toString().equals("double") ||
                            genericParameterType.toString().equals("String") ||
                            genericParameterType.toString().equals("float") ||
                            genericParameterType.toString().equals("long") ||
                            genericParameterType.toString().equals("char"))) {
                        System.out.println("Insert " + genericParameterType.getTypeName());
                        params[i++] = (buildObject(genericParameterType.getTypeName()));
                    } else {
                        switch (genericParameterType.toString()) {
                            case "int":
                                System.out.println("Insert " + genericParameterType.getTypeName());
                                params[i++] = (k.nextInt());
                                break;

                            case "double":
                                System.out.println("Insert " + genericParameterType.getTypeName());
                                params[i++] = (k.nextDouble());
                                break;

                            case "String":
                                System.out.println("Insert " + genericParameterType.getTypeName());
                                params[i++] = (k.nextLine());
                                k.nextLine();
                                break;

                            case "float":
                                System.out.println("Insert " + genericParameterType.getTypeName());
                                params[i++] = (k.nextFloat());
                                break;

                            case "long":
                                System.out.println("Insert " + genericParameterType.getTypeName());
                                params[i++] = (k.nextLong());
                                break;

                            case "char":
                                System.out.println("Insert " + genericParameterType.getTypeName());
                                params[i++] = ((char) k.nextByte());
                                break;
                        }
                    }
                }
                return constructors[opc].newInstance(params);
            }
        } while (opc > constructors.length || opc < 0);
        return true;
    }

}
